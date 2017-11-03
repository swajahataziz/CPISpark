package com.iqvia.rwi.spark.utils

import org.slf4j.{Logger, LoggerFactory}

trait Logging {

  // Make the log field transient so that objects with Logging can
  // be serialized and used on another machine
  @transient private var log_ : Logger = null

  protected def logInfo(msg: String): Unit = {
    if (log.isInfoEnabled) log.info(msg)
  }

  protected def logDebug(msg: String): Unit = {
    if (log.isDebugEnabled) log.debug(msg)
  }

  protected def logTrace(msg: String) = {
    if (log.isTraceEnabled) log.trace(msg)
  }

  protected def logWarning(msg: String): Unit = {
    if (log.isWarnEnabled) log.warn(msg)
  }

  protected def logError(msg: String): Unit = {
    if (log.isErrorEnabled) log.error(msg)
  }

  protected def isTraceEnabled: Boolean = {
    log.isTraceEnabled
  }

  protected def logInfo(msg: String, throwable: Throwable): Unit = {
    if (log.isInfoEnabled) log.info(msg, throwable)
  }

  protected def logDebug(msg: String, throwable: Throwable): Unit = {
    if (log.isDebugEnabled) log.debug(msg, throwable)
  }

  protected def logTrace(msg: String, throwable: Throwable) = {
    if (log.isTraceEnabled) log.trace(msg, throwable)
  }

  protected def logWarning(msg: String, throwable: Throwable): Unit = {
    if (log.isWarnEnabled) log.warn(msg, throwable)
  }

  protected def logError(msg: String, throwable: Throwable): Unit = {
    if (log.isErrorEnabled) log.error(msg,throwable)
  }

  protected def log: Logger = {
    if (log_ == null) {
      log_ = LoggerFactory.getLogger(logName)
    }
    log_
  }

  protected def logName = {
    this.getClass.getName.stripSuffix("$")
  }
}
