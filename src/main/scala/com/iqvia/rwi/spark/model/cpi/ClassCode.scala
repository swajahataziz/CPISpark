package com.iqvia.rwi.spark.model.cpi

class ClassCode(val extractOrder: String,
                schemaAbbr: String,
                classCodeAbbr: String,
                classCodeDesc: String) extends RecordType with DefRecords {

  override val recordType: String = "003"
}
