import com.typesafe.config.ConfigFactory

object MainApp extends App {

  val a = 5
  val b = 15
  val c = a * b

  println(c)

  def loadConfig() = {
    val config = ConfigFactory.load("application.conf").getConfig("properties")
    val sparkConfig = config.getConfig("spark")
    val mysqlConfig = config.getConfig("mysql")
    val appName = sparkConfig.getString("app-name")
    appName
  }


}
