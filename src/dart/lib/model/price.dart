part of api;


@Entity()
class Price {
  
  DateTime date = null;
  
  
  String ticker = null;
  
  
  num value = null;
  
  
  Price();

  @override
  String toString()  {
    return 'Price[date=$date, ticker=$ticker, value=$value, ]';
  }

}

