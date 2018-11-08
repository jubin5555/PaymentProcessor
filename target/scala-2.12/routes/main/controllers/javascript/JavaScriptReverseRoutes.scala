// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jajubina/SOC Projects/ontologies/conf/routes
// @DATE:Tue Nov 06 22:33:29 EST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {

  // @LINE:10
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def getRejectionLog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getRejectionLog",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectionlog"})
        }
      """
    )
  
    // @LINE:10
    def addMerchant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addMerchant",
      """
        function(uniqueID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addmerchant/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uniqueID", uniqueID0))})
        }
      """
    )
  
    // @LINE:34
    def getBankRejectionCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getBankRejectionCount",
      """
        function(bankID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bankrejections/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID0))})
        }
      """
    )
  
    // @LINE:16
    def isCommercial: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isCommercial",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "iscommercial/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:18
    def isPersonal: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isPersonal",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ispersonal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:22
    def isRefund: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isRefund",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "isrefund/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:30
    def addTransactionTwo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addTransactionTwo",
      """
        function(senderID0,receiverID1,bankID2,category3,amount4,transactionRequestID5) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "transactionrequest/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("senderID", senderID0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("receiverID", receiverID1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID2)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("category", category3)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("amount", amount4)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionRequestID", transactionRequestID5))})
        }
      """
    )
  
    // @LINE:14
    def addTransaction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addTransaction",
      """
        function(senderID0,receiverID1,transactionID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addtransaction/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("senderID", senderID0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("receiverID", receiverID1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID2))})
        }
      """
    )
  
    // @LINE:28
    def addBank: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addBank",
      """
        function(bankID0,nationality1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addbank/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nationality", nationality1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID0))})
        }
      """
    )
  
    // @LINE:20
    def isPurchase: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isPurchase",
      """
        function(transactionID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ispurchase/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("transactionID", transactionID0))})
        }
      """
    )
  
    // @LINE:12
    def addConsumer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addConsumer",
      """
        function(uniqueID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addconsumer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("uniqueID", uniqueID0))})
        }
      """
    )
  
    // @LINE:32
    def bankStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.bankStatus",
      """
        function(bankID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "isblacklisted/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bankID", bankID0))})
        }
      """
    )
  
    // @LINE:38
    def getAcceptanceLog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAcceptanceLog",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "acceptancelog"})
        }
      """
    )
  
    // @LINE:24
    def isTrusted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.isTrusted",
      """
        function(merchantID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "istrusted/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("merchantID", merchantID0))})
        }
      """
    )
  
    // @LINE:26
    def reset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.reset",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reset"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
