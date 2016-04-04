//
// Price.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


public class Price: JSONEncodable {

    public var Date: NSDate?
    public var Ticker: String?
    public var Value: Double?
    

    public init() {}

    // MARK: JSONEncodable
    func encodeToJSON() -> AnyObject {
        var nillableDictionary = [String:AnyObject?]()
        nillableDictionary["Date"] = self.Date?.encodeToJSON()
        nillableDictionary["Ticker"] = self.Ticker
        nillableDictionary["Value"] = self.Value
        let dictionary: [String:AnyObject] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}