package com.iqvia.rwi.spark.spark.parser

/**
  * Basic context information used internally by instances of Parsers
  */
trait Context {

  /**
    * Returns the file headers that identify each parsed record
    * @return the headers used to identify each record parsed from the input
    */
  def headers: Array[String]

  /**
    * Returns the sequence of headers that have been selected. if no selection has been made, all available headers
    * will be returned, producing the same output as method {@link #headers()}
    * @return
    */
  def selectedHeaders: Array[String]


  /**
    * Returns the indexes of each field extracted from the input when fields are selected.
    *
    * <p> The indexes are relative to their original position in the input.
    * <p> For example, if the input has the fields "A, B, C, D", and the selected fields are "A, D", then the extracted field indexes will return [0, 3]
    *
    * <p>If no fields were selected, then this method will return null. This means all fields are being parsed.
    *
    * @return The indexes of each selected field; null if no fields were selected.
    *
    */
  def extractedFieldIndexes: Array[Int]

  /**
    * Returns the column index of the record being processed.
    *
    * @return the column index of the record being processed.
    */
  def currentColumn: Int

  /**
    * Returns the index of the last valid record parsed from the input
    *
    * @return the index of the last valid record parsed from the input
    */
  def currentRecord: Long

  /**
    * Stops the parsing process. Any open resources in use by the parser are closed automatically.
    */
  def stop: Unit

  /**
    * Identifies whether the parser is running.
    *
    * @return true if the parser is stopped, false otherwise.
    */
  def isStopped: Boolean


}
