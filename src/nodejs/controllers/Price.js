'use strict';

var url = require('url');


var Price = require('./PriceService');


module.exports.priceGetByTicker = function priceGetByTicker (req, res, next) {
  Price.priceGetByTicker(req.swagger.params, res, next);
};

module.exports.priceGet = function priceGet (req, res, next) {
  Price.priceGet(req.swagger.params, res, next);
};
