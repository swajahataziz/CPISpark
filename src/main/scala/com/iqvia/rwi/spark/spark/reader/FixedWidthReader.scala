package com.iqvia.rwi.spark.spark.reader

import com.univocity.parsers.fixed.{FixedWidthFieldLengths, FixedWidthParser, FixedWidthParserSettings}

abstract class FixedWidthReader(fixedWidths: Array[Int],
                                lineSeperator: String = "\n",
                                commentMarker: Char = '#',
                                ignoreLeadingSpace: Boolean = true,
                                ignoreTrailingSpace: Boolean = true,
                                headers: Seq[String],
                                inputBufferSize: Int = 128,
                                maxCols: Int = 20480
                               ) {
  lazy val parser: FixedWidthParser = {
    val settings = new FixedWidthParserSettings()

  }




}
