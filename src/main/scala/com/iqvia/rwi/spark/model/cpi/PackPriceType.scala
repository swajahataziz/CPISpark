package com.iqvia.rwi.spark.model.cpi

class PackPriceType(val extractOrder: String,
                    priceType: String,
                    priceTypeDesc: String,
                    priceDecimalPlaces: Int) extends RecordType with DefRecords {

  override val recordType: String = "013"
}
