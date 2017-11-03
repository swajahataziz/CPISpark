package com.iqvia.rwi.spark.spark

import com.esotericsoftware.kryo.Kryo
import org.apache.spark.serializer.KryoRegistrator

class SparkRegistrator extends KryoRegistrator{
  override def registerClasses(kryo: Kryo): Unit = {
  }
}