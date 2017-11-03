package com.iqvia.rwi.spark.spark

import com.iqvia.rwi.spark.utils.Logging
import org.apache.spark.SparkConf
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession

trait SparkContextBuilder extends Logging {

  @transient private var _sparkSession: SparkSession = _

  /**
    * Create a single Spark Context
    *
    * @param contextType          Type of Job
    * @param contextName          Name of Job
    * @param serializerClass      Kyro Registrator Used. Defaults to SparkRegistrator
    * @param kyroBuffer           Kyro buffer, defaults to 8M
    * @param eventLogEnabled      save log files, defaults to false
    * @param applicationSparkLog  location to save spark job events
    * @param sqlJoinPartitions    How many partitions to use for data join shuffles
    * @tparam T                   Parameter for serializer class, which is of type Class[T]
    * @return                     Spark session
    */
  def createSparkSession[T](contextType: String,
                            contextName: String,
                            serializerClass: Class[T],
                            kyroBuffer: String = "8M",
                            eventLogEnabled: Boolean = false,
                            applicationSparkLog: String = "file://tmp/spark-events",
                            sqlJoinPartitions: Int = 10
                           ): SparkSession = {
    val conf = new SparkConf()
    conf
      .setMaster(contextType)
      .setAppName(contextName)
      .set("spark.serializer", classOf[KryoSerializer].getCanonicalName)
      .set("spark.kyro.registrator", serializerClass.getCanonicalName)
      .set("spark.kyroserializer.buffer", kyroBuffer)
      .set("spark.hadoop.validateOutputSpecs", "false")
      .set("spark.sql.shuffle.partitions", sqlJoinPartitions.toString)

    logInfo(s"Created new Spark Context of type $contextType named $contextName")

    _sparkSession = SparkSession
      .builder()
      .config("spark.sql.warehouse.dir", "file://tmp/spark-warehouse")
      .config(conf)
      .getOrCreate()

    sparkSession
  }

  def sparkSession: SparkSession = _sparkSession

  def stopSparkSession(): Unit = {
    if(_sparkSession != null) {
      _sparkSession.stop()
    }
    System.clearProperty("spark.driver.port")
    logInfo(s"Stopped SparkSession")
  }
}
