// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jajubina/SOC Projects/ontologies/conf/routes
// @DATE:Tue Nov 06 22:33:29 EST 2018


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
