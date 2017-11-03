package com.iqvia.rwi.spark.model.cpi

class PackCode(val extractOrder: String,
               packCodeAbbr: String,
               packCodeDesc: String
              ) extends RecordType with DefRecords{

  override val recordType: String = "009"
}
