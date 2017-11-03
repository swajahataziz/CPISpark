package com.iqvia.rwi.spark.model.cpi

class ProductAttributeCode(val extractOrder: String,
                           productAttributeAbbr: String,
                           productAttributeDesc: String,
                           productFlagValue1: String,
                           productFlagValue2: String
                          ) extends RecordType with DefRecords {

  override val recordType: String = "005"

}
