package com.iqvia.rwi.spark.model.cpi

class Hospital(fcc: String,
               fscCode: String,
               hospitalDescription: String,
               hospitalNormalSize: String,
               hospitalNormalMeasure: String,
               hospitalCountUnits: String,
               hospitalCountMeasure: String,
               hospitalMultiFactor: String,
               hospitalStartDate: String,
               hospitalEndDate: String
              ) extends RecordType {
  override val recordType: String = "030"

}
