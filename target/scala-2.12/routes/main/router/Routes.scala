// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jajubina/SOC Projects/ontologies/conf/routes
// @DATE:Tue Nov 06 22:33:29 EST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  Assets_1: controllers.Assets,
  // @LINE:10
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_1: controllers.Assets,
    // @LINE:10
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, Assets_1, HomeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addmerchant/""" + "$" + """uniqueID<[^/]+>""", """controllers.HomeController.addMerchant(uniqueID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addconsumer/""" + "$" + """uniqueID<[^/]+>""", """controllers.HomeController.addConsumer(uniqueID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtransaction/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.addTransaction(senderID:String, receiverID:String, transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """iscommercial/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isCommercial(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ispersonal/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isPersonal(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ispurchase/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isPurchase(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isrefund/""" + "$" + """transactionID<[^/]+>""", """controllers.HomeController.isRefund(transactionID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """istrusted/""" + "$" + """merchantID<[^/]+>""", """controllers.HomeController.isTrusted(merchantID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reset""", """controllers.HomeController.reset()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addbank/""" + "$" + """nationality<[^/]+>/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.addBank(bankID:String, nationality:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transactionrequest/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """bankID<[^/]+>/""" + "$" + """category<[^/]+>/""" + "$" + """amount<[^/]+>/""" + "$" + """transactionRequestID<[^/]+>""", """controllers.HomeController.addTransactionTwo(senderID:String, receiverID:String, bankID:String, category:String, amount:String, transactionRequestID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """isblacklisted/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.bankStatus(bankID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """bankrejections/""" + "$" + """bankID<[^/]+>""", """controllers.HomeController.getBankRejectionCount(bankID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectionlog""", """controllers.HomeController.getRejectionLog()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """acceptancelog""", """controllers.HomeController.getAcceptanceLog()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_addMerchant1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addmerchant/"), DynamicPart("uniqueID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addMerchant1_invoker = createInvoker(
    HomeController_0.addMerchant(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addMerchant",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addmerchant/""" + "$" + """uniqueID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_addConsumer2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addconsumer/"), DynamicPart("uniqueID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addConsumer2_invoker = createInvoker(
    HomeController_0.addConsumer(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addConsumer",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addconsumer/""" + "$" + """uniqueID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_addTransaction3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtransaction/"), DynamicPart("senderID", """[^/]+""",true), StaticPart("/"), DynamicPart("receiverID", """[^/]+""",true), StaticPart("/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addTransaction3_invoker = createInvoker(
    HomeController_0.addTransaction(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addTransaction",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """addtransaction/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """transactionID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_isCommercial4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("iscommercial/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isCommercial4_invoker = createInvoker(
    HomeController_0.isCommercial(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isCommercial",
      Seq(classOf[String]),
      "GET",
      this.prefix + """iscommercial/""" + "$" + """transactionID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_isPersonal5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ispersonal/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isPersonal5_invoker = createInvoker(
    HomeController_0.isPersonal(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isPersonal",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ispersonal/""" + "$" + """transactionID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_isPurchase6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ispurchase/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isPurchase6_invoker = createInvoker(
    HomeController_0.isPurchase(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isPurchase",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ispurchase/""" + "$" + """transactionID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HomeController_isRefund7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isrefund/"), DynamicPart("transactionID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isRefund7_invoker = createInvoker(
    HomeController_0.isRefund(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isRefund",
      Seq(classOf[String]),
      "GET",
      this.prefix + """isrefund/""" + "$" + """transactionID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_isTrusted8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("istrusted/"), DynamicPart("merchantID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_isTrusted8_invoker = createInvoker(
    HomeController_0.isTrusted(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "isTrusted",
      Seq(classOf[String]),
      "GET",
      this.prefix + """istrusted/""" + "$" + """merchantID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HomeController_reset9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reset")))
  )
  private[this] lazy val controllers_HomeController_reset9_invoker = createInvoker(
    HomeController_0.reset(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "reset",
      Nil,
      "POST",
      this.prefix + """reset""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_HomeController_addBank10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addbank/"), DynamicPart("nationality", """[^/]+""",true), StaticPart("/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addBank10_invoker = createInvoker(
    HomeController_0.addBank(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addBank",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """addbank/""" + "$" + """nationality<[^/]+>/""" + "$" + """bankID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_HomeController_addTransactionTwo11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transactionrequest/"), DynamicPart("senderID", """[^/]+""",true), StaticPart("/"), DynamicPart("receiverID", """[^/]+""",true), StaticPart("/"), DynamicPart("bankID", """[^/]+""",true), StaticPart("/"), DynamicPart("category", """[^/]+""",true), StaticPart("/"), DynamicPart("amount", """[^/]+""",true), StaticPart("/"), DynamicPart("transactionRequestID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_addTransactionTwo11_invoker = createInvoker(
    HomeController_0.addTransactionTwo(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addTransactionTwo",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """transactionrequest/""" + "$" + """senderID<[^/]+>/""" + "$" + """receiverID<[^/]+>/""" + "$" + """bankID<[^/]+>/""" + "$" + """category<[^/]+>/""" + "$" + """amount<[^/]+>/""" + "$" + """transactionRequestID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_HomeController_bankStatus12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("isblacklisted/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_bankStatus12_invoker = createInvoker(
    HomeController_0.bankStatus(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "bankStatus",
      Seq(classOf[String]),
      "GET",
      this.prefix + """isblacklisted/""" + "$" + """bankID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_HomeController_getBankRejectionCount13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("bankrejections/"), DynamicPart("bankID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getBankRejectionCount13_invoker = createInvoker(
    HomeController_0.getBankRejectionCount(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getBankRejectionCount",
      Seq(classOf[String]),
      "GET",
      this.prefix + """bankrejections/""" + "$" + """bankID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_HomeController_getRejectionLog14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectionlog")))
  )
  private[this] lazy val controllers_HomeController_getRejectionLog14_invoker = createInvoker(
    HomeController_0.getRejectionLog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRejectionLog",
      Nil,
      "POST",
      this.prefix + """rejectionlog""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_HomeController_getAcceptanceLog15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("acceptancelog")))
  )
  private[this] lazy val controllers_HomeController_getAcceptanceLog15_invoker = createInvoker(
    HomeController_0.getAcceptanceLog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAcceptanceLog",
      Nil,
      "POST",
      this.prefix + """acceptancelog""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:10
    case controllers_HomeController_addMerchant1_route(params@_) =>
      call(params.fromPath[String]("uniqueID", None)) { (uniqueID) =>
        controllers_HomeController_addMerchant1_invoker.call(HomeController_0.addMerchant(uniqueID))
      }
  
    // @LINE:12
    case controllers_HomeController_addConsumer2_route(params@_) =>
      call(params.fromPath[String]("uniqueID", None)) { (uniqueID) =>
        controllers_HomeController_addConsumer2_invoker.call(HomeController_0.addConsumer(uniqueID))
      }
  
    // @LINE:14
    case controllers_HomeController_addTransaction3_route(params@_) =>
      call(params.fromPath[String]("senderID", None), params.fromPath[String]("receiverID", None), params.fromPath[String]("transactionID", None)) { (senderID, receiverID, transactionID) =>
        controllers_HomeController_addTransaction3_invoker.call(HomeController_0.addTransaction(senderID, receiverID, transactionID))
      }
  
    // @LINE:16
    case controllers_HomeController_isCommercial4_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isCommercial4_invoker.call(HomeController_0.isCommercial(transactionID))
      }
  
    // @LINE:18
    case controllers_HomeController_isPersonal5_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isPersonal5_invoker.call(HomeController_0.isPersonal(transactionID))
      }
  
    // @LINE:20
    case controllers_HomeController_isPurchase6_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isPurchase6_invoker.call(HomeController_0.isPurchase(transactionID))
      }
  
    // @LINE:22
    case controllers_HomeController_isRefund7_route(params@_) =>
      call(params.fromPath[String]("transactionID", None)) { (transactionID) =>
        controllers_HomeController_isRefund7_invoker.call(HomeController_0.isRefund(transactionID))
      }
  
    // @LINE:24
    case controllers_HomeController_isTrusted8_route(params@_) =>
      call(params.fromPath[String]("merchantID", None)) { (merchantID) =>
        controllers_HomeController_isTrusted8_invoker.call(HomeController_0.isTrusted(merchantID))
      }
  
    // @LINE:26
    case controllers_HomeController_reset9_route(params@_) =>
      call { 
        controllers_HomeController_reset9_invoker.call(HomeController_0.reset())
      }
  
    // @LINE:28
    case controllers_HomeController_addBank10_route(params@_) =>
      call(params.fromPath[String]("bankID", None), params.fromPath[String]("nationality", None)) { (bankID, nationality) =>
        controllers_HomeController_addBank10_invoker.call(HomeController_0.addBank(bankID, nationality))
      }
  
    // @LINE:30
    case controllers_HomeController_addTransactionTwo11_route(params@_) =>
      call(params.fromPath[String]("senderID", None), params.fromPath[String]("receiverID", None), params.fromPath[String]("bankID", None), params.fromPath[String]("category", None), params.fromPath[String]("amount", None), params.fromPath[String]("transactionRequestID", None)) { (senderID, receiverID, bankID, category, amount, transactionRequestID) =>
        controllers_HomeController_addTransactionTwo11_invoker.call(HomeController_0.addTransactionTwo(senderID, receiverID, bankID, category, amount, transactionRequestID))
      }
  
    // @LINE:32
    case controllers_HomeController_bankStatus12_route(params@_) =>
      call(params.fromPath[String]("bankID", None)) { (bankID) =>
        controllers_HomeController_bankStatus12_invoker.call(HomeController_0.bankStatus(bankID))
      }
  
    // @LINE:34
    case controllers_HomeController_getBankRejectionCount13_route(params@_) =>
      call(params.fromPath[String]("bankID", None)) { (bankID) =>
        controllers_HomeController_getBankRejectionCount13_invoker.call(HomeController_0.getBankRejectionCount(bankID))
      }
  
    // @LINE:36
    case controllers_HomeController_getRejectionLog14_route(params@_) =>
      call { 
        controllers_HomeController_getRejectionLog14_invoker.call(HomeController_0.getRejectionLog())
      }
  
    // @LINE:38
    case controllers_HomeController_getAcceptanceLog15_route(params@_) =>
      call { 
        controllers_HomeController_getAcceptanceLog15_invoker.call(HomeController_0.getAcceptanceLog())
      }
  }
}
