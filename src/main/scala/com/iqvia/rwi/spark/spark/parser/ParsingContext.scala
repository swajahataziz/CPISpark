package com.iqvia.rwi.spark.spark.parser

trait ParsingContext extends Context {


  /**
    * Returns the current line of text being processed by the parser
    *
    * @return current line of text being processed by the parser
    */
  def currentLine: Long

  /**
    * Returns the index of the last char read from the input so far.
    *
    * @return the index of the last char read from the input so far.
    */
  def currentChar: Long

  /**
    * Skips a given number of lines from the current position.
    *
    * @param lines the number of lines to be skipped.
    */
  def skipLines(lines: Long): Unit

  /**
    * Returns the headers <b>parsed</b> from the input, if and only if {@link CommonParserSettings#headerExtractionEnabled} is {@code true}.
    * The result of this method won't return the list of headers manually set by the user in {@link CommonParserSettings#getHeaders()}.
    * Use the {@link #headers()} method instead to obtain the headers actually used by the parser.
    *
    * @return the headers parsed from the input, when { @link CommonParserSettings#headerExtractionEnabled} is { @code true}.
    */
  def parsedHeaders: Array[String]

  /**
    * Returns a String with the input character sequence parsed to produce the current record.
    *
    * @return the text content parsed for the current input record.
    */
  def currentParsedContent: String

  /**
    * Returns a String with the input character sequence accumulated on a field before {@link TextParsingException} occurred.
    *
    * @return the text content parsed for the current field of the current input record at the time of the error.
    */
  def fieldContentOnError: String

  /**
    * Returns all comments collected by the parser so far.
    * An empty map will be returned if {@link CommonParserSettings#isCommentCollectionEnabled()} evaluates to {@code false}.
    *
    * @return a map containing the line numbers and comments found in each.
    */
  def comments: Nothing

  /**
    * Returns the last comment found in the input.
    * {@code null} will be returned if {@link CommonParserSettings#isCommentCollectionEnabled()} is evaluated to {@code false}.
    *
    * @return the last comment found in the input.
    */
  def lastComment: String

  /**
    * Returns the line separator characters used to separate individual records when parsing. This could be the line
    * separator defined in the {@link Format#getLineSeparator()} configuration, or the line separator sequence
    * identified automatically when {@link CommonParserSettings#isLineSeparatorDetectionEnabled()} evaluates to {@code true}.
    *
    * @return the line separator sequence. Might contain one or two characters.
    */
  def lineSeparator: Array[Char]
}
