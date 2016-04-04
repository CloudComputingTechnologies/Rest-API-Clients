package io.swagger.client.model {

import io.swagger.common.ListWrapper;

    public class PriceList implements ListWrapper {
        // This declaration below of _Price_obj_class is to force flash compiler to include this class
        private var _price_obj_class: io.swagger.client.model.Price = null;
        [XmlElements(name="price", type="io.swagger.client.model.Price")]
        public var price: Array = new Array();

        public function getList(): Array{
            return price;
        }

}
        

}
