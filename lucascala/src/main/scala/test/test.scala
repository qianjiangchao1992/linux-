package test
object Test {
  import org.apache.spark.SparkContext
  import org.apache.spark.SparkConf
  import org.apache.spark.rdd.RDD
  object test{
    def main(args: Array[String]): Unit = {
      val conf=new SparkConf().setAppName("WordCount").setMaster("local")
      val sc=new SparkContext(conf)
      val fileRdd:RDD[String]=sc.textFile("/home/qjc/sparkdata/prodata_new.txt")
      val secondRDD:RDD[(String,Int)]=fileRdd.map(_.split("\t")).map(x=>x(1)).map(x=>(x.split("_"))).map(x=>(x(0),1))
      val label1RDD:RDD[(String,Int)]=fileRdd.map(_.split("\t")).map(x=>x(2)).map(x=>(x,1)).reduceByKey((x,y)=>(x+y)).sortBy(_._2,false)
      label1RDD.saveAsTextFile("/home/qjc/sparkdata/Count_Label1")
      val label2RDD:RDD[(String,Int)]=fileRdd.map(_.split("\t")).map(x=>(x(3),1)).reduceByKey((x,y)=>(x+y)).sortBy(_._2,false)
      label2RDD.saveAsTextFile("/home/qjc/sparkdata/Count_Label2")
      val label3RDD:RDD[(String,Int)]=fileRdd.map(_.split("\t")).map(x=>(x(4),1)).reduceByKey((x,y)=>(x+y)).sortBy(_._2,false)
      label3RDD.saveAsTextFile("/home/qjc/sparkdata/Count_Label3")
      println("代码处理完成！")
    }}
}
