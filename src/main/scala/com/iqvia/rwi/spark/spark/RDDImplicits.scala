package com.iqvia.rwi.spark.spark

import org.apache.spark.rdd.RDD

import scala.reflect.ClassTag


/*
 * Implicit classes to extend RDD functionality where needed
 */
object RDDImplicits {

    implicit class RichRDD[T: ClassTag] (rdd: RDD[T]) {

      /**
        * Repartition RDD to number of partitions
        * @param numOutputPartitions number of partitions for output rdd
        * @return if numOutputPartitions =< 0 don't do anything
        *         else return rdd repartitioned with selected number
        *         of output partitions
        */
      def reduceToNumberOfPartitions(numOutputPartitions: Int = -1): RDD[T] = {
        numOutputPartitions match {
          case x: Int if x <= 0 => rdd
          case x: Int if x < rdd.partitions.length => rdd.coalesce(numOutputPartitions, shuffle = false)
          case _ => rdd
        }
      }
    }

}
