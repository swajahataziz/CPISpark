package com.iqvia.rwi.spark.model.cpi

class PackAttributeCode(val extractOrder: String,
                        packAttributeAbbr: String,
                        packAtteibuteDesc: String,
                        packFlagValue1: String,
                        packFlagValue2: String,
                        packFlagValue3: String,
                        packFlagValue4: String,
                        packFlagValue5: String,
                        packFlagValue6: String,
                        packFlagValue7: String,
                        packFlagValue8: String,
                        packFlagValue9: String,
                        packFlagValue10: String
                       ) extends RecordType with DefRecords {

  override val recordType: String = "007"
}
