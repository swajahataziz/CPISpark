package com.iqvia.rwi.spark.model.cpi

class PackStudyIndicator(val extractOrder: String,
                         studyAbbr: String,
                         studyDesc: String) extends RecordType with DefRecords {

  override val recordType: String = "011"
}
