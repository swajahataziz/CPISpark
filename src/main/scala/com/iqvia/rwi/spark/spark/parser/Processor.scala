package com.iqvia.rwi.spark.spark.parser

trait Processor[T <: Context] {

  /**
    * This method will by invoked by the parser once, when it is ready to start processing the input.
    *
    * @param context A contextual object with information and controls over the current state of the parsing process
    */
  def processStarted(context: T)

  import com.univocity.parsers.common.CommonSettings

  /**
    * Invoked by the parser after all values of a valid record have been processed.
    *
    * @param row the data extracted by the parser for an individual record. Note that:
    *            <ul>
    *            <li>it will never by null. </li>
    *            <li>it will never be empty unless explicitly configured using { @link CommonSettings#setSkipEmptyLines(boolean)}</li>
    *            <li>it won't contain lines identified by the parser as comments. To disable comment processing set { @link Format#setComment(char)} to '\0'</li>
    *            </ul>
    * @param context A contextual object with information and controls over the current state of the parsing process
    */
  def rowProcessed(row: Array[String], context: T)

  import com.univocity.parsers.common.ParsingContext

  /**
    * This method will by invoked by the parser once, after the parsing process stopped and all resources were closed.
    * <p> It will always be called by the parser: in case of errors, if the end of the input us reached, or if the user stopped the process manually using {@link ParsingContext#stop()}.
    *
    * @param context A contextual object with information and controls over the state of the parsing process
    */
  def processEnded(context: T)
}
