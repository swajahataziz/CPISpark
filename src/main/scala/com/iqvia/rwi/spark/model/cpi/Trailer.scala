package com.iqvia.rwi.spark.model.cpi

class Trailer(totalRecords: String,
              totalPacks: String,
              maxFcc: String) extends RecordType {
  override val recordType: String = "999"

}
