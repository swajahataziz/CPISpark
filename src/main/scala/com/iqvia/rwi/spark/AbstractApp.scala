package com.iqvia.rwi.spark

import com.iqvia.rwi.spark.spark.{SparkContextBuilder, SparkRegistrator}

abstract class AbstractApp extends SparkContextBuilder {

  def main(args: Array[String]): Unit = {
    createSparkSession("local[*]", this.getClass.toString, classOf[SparkRegistrator])
    execute(args)
    stopSparkSession()
  }

  def execute(args: Array[String])
}
