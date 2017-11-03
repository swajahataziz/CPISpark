package com.iqvia.rwi.spark.spark.parser

abstract class AbstractProcessorSwitch[T <:Context]  extends Processor[T] {

  val processors: Map[Processor[T], Context]
  val selectedProcessor: Processor[T]
  val contextForSelectedProcessor: Context

  /**
    * Analyzes the input to determine whether or not the row processor implementation must be changed
    *
    * @param row     a row parsed from the input
    * @param context the current parsing context (not associated with the current row processor used by this class)
    * @return the row processor implementation to use. If it is not the same as the one used by the previous row,
    *         the returned row processor will be used, and the { @link #processorSwitched(Processor, Processor)} method
    *         will be called.
    */
  def switchRowProcessor(row: String, context: T): Processor[T]

  import com.univocity.parsers.common.CommonParserSettings

  /**
    * Returns the headers in use by the current row processor implementation, which can vary among row processors.
    * If {@code null}, the headers parsed by the input, or defined in {@link CommonParserSettings#getHeaders()} will be returned.
    *
    * @return the current sequence of headers to use.
    */
  def getHeaders: Array[String]

  /**
    * Returns the indexes in use by the current row processor implementation, which can vary among row processors.
    * If {@code null} all columns of a given record will be considered.
    *
    * @return the current sequence of indexes to use.
    */
  def getIndexes: Array[Int]

  import com.univocity.parsers.common.processor.RowProcessor

  /**
    * Notifies a change of {@link Processor} implementation. Users are expected to override this method to receive the notification.
    *
    * @param from the processor previously in use
    * @param to   the new processor to use to continue processing the input.
    */
  def processorSwitched(from: Processor[T], to: Processor[T]): Unit = {
    if (from != null)
      if (from.isInstanceOf[Processor])
        if (to == null || to.isInstanceOf[Processor])
          rowProcessorSwitched(from.asInstanceOf[Processor[T]], to.asInstanceOf[Processor[T]])
    else if (to != null && to.isInstanceOf[Processor])
          rowProcessorSwitched(from.asInstanceOf[Processor[T]], to.asInstanceOf[Processor[T]])
  }

  def rowProcessorSwitched(from: Processor[T], to: Processor[T]): Unit

  def processStarted(context: T): Unit = {
    processors = 
  }





}
