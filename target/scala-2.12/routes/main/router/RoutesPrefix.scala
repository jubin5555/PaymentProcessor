// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jajubina/SOC Projects/ontologies/conf/routes
// @DATE:Tue Oct 16 20:00:16 EDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
