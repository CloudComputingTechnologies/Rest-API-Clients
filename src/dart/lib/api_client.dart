part of api;

class ApiClient {
  static ApiClient defaultApiClient = new ApiClient();

  Map<String, String> _defaultHeaderMap = {};
  Map<String, Authentication> _authentications = {};
  static final dson = new Dartson.JSON();
  final DateFormat _dateFormatter = new DateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

  ApiClient() {
    // Setup authentications (key: authentication name, value: authentication).
  }

  void addDefaultHeader(String key, String value) {
     _defaultHeaderMap[key] = value;
  }

  /// Format the given Date object into string.
  String formatDate(DateTime date) {
    return _dateFormatter.format(date);
  }

  /// Format the given parameter object into string.
  String parameterToString(Object param) {
    if (param == null) {
      return '';
    } else if (param is DateTime) {
      return formatDate(param);
    } else if (param is List) {
      return (param).join(',');
    } else {
      return param.toString();
    }
  }

  static dynamic deserialize(String json, dynamic clazz) {
    var result = json;

    try {
      var decodedJson = JSON.decode(json);

      if(decodedJson is List) {
        result = [];
        for(var obj in decodedJson) {
          result.add(_createEntity(obj, clazz));
        }
      } else {
        result = _createEntity(json, clazz);
      }
    } on FormatException {
      // Just return the passed in value
    }

    return result;
  }

  static dynamic _createEntity(dynamic json, dynamic clazz) {
    bool isMap = json is Map;

    switch(clazz) {
      
      
      case Price:
        return isMap ? dson.map(json, new Price()) : dson.decode(json, new Price());
      
      
      default:
        throw new ApiException(500, 'Could not find a suitable class for deserialization');
    }
  }

  static String serialize(Object obj) {
    String serialized = '';
    if (obj == null) {
      serialized = '';
    } else if (obj is String) {
      serialized = obj;
    } else {
      serialized = dson.encode(obj);
    }
    return serialized;
  }

  Future<Response> invokeAPI( String host, 
                              String path,
                              String method,
                              Map<String, String> queryParams,
                              Object body,
                              Map<String, String> headerParams,
                              Map<String, String> formParams,
                              String contentType,
                              List<String> authNames)  {

    updateParamsForAuth(authNames, queryParams, headerParams);

    var client = new BrowserClient();

    StringBuffer sb = new StringBuffer();
    
    for(String key in queryParams.keys) {
      String value = queryParams[key];
      if (value != null){
        if(sb.toString().length == 0) {
          sb.write("?");
        } else {
          sb.write("&");
        }
        sb.write(key);
        sb.write("=");
        sb.write(value);
      }
    }
    String querystring = sb.toString();

    String url = host + path + querystring;

    headerParams.addAll(_defaultHeaderMap);
    headerParams['Content-Type'] = contentType;

    var completer = new Completer();

    if(body is MultipartRequest) {
      var request = new MultipartRequest(method, Uri.parse(url));      
      request.fields.addAll(body.fields);
      request.files.addAll(body.files);
      request.headers.addAll(body.headers);
      request.headers.addAll(headerParams);
      client.send(request).then((response) => completer.complete(Response.fromStream(response)));
    } else {
      var msgBody = contentType == "application/x-www-form-urlencoded" ? formParams : serialize(body);
      switch(method) {
        case "GET":
          return client.get(url, headers: headerParams);
        case "POST":
          return client.post(url, headers: headerParams, body: msgBody);
        case "PUT":
          return client.put(url, headers: headerParams, body: msgBody);
        case "DELETE":
          return client.delete(url, headers: headerParams);
      }
    }

    return completer.future;
  }

  /// Update query and header parameters based on authentication settings.
  /// @param authNames The authentications to apply  
  void updateParamsForAuth(List<String> authNames, Map<String, String> queryParams, Map<String, String> headerParams) {
    authNames.forEach((authName) {
      Authentication auth = _authentications[authName];
      if (auth == null) throw new ArgumentError("Authentication undefined: " + authName);
      auth.applyToParams(queryParams, headerParams);
    });
  }

}
