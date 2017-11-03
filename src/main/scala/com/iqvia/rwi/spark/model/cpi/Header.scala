package com.iqvia.rwi.spark.model.cpi

import java.util.Date

class Header(cpiCycleNumber: String,
             countryCode: String,
             countryName: String,
             period: String,
             dateOfExtract: Date,
             extractPeriod: String,
             previousCycleNumber: String,
             extractType: String) extends RecordType {
  override val recordType: String = "000"
}
