package com.iqvia.rwi.spark.model.cpi

class Organization(val extractOrder: String,
                   orgCode: String,
                   orgName: String,
                   orgAbbreviation: String,
                   manufacturerFlag: String,
                   whsFlag: String,
                   corpFlag: String,
                   distFlag: String) extends RecordType with DefRecords {
  override val recordType: String = "015"
}
