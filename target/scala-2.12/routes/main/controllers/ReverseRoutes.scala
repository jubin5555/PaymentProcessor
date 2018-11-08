// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jajubina/SOC Projects/ontologies/conf/routes
// @DATE:Tue Nov 06 22:33:29 EST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:10
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def getRejectionLog(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "rejectionlog")
    }
  
    // @LINE:10
    def addMerchant(uniqueID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addmerchant/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uniqueID", uniqueID)))
    }
  
    // @LINE:34
    def getBankRejectionCount(bankID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "bankrejections/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:16
    def isCommercial(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "iscommercial/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:18
    def isPersonal(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ispersonal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:22
    def isRefund(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "isrefund/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:30
    def addTransactionTwo(senderID:String, receiverID:String, bankID:String, category:String, amount:String, transactionRequestID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "transactionrequest/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("senderID", senderID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("receiverID", receiverID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("category", category)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("amount", amount)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionRequestID", transactionRequestID)))
    }
  
    // @LINE:14
    def addTransaction(senderID:String, receiverID:String, transactionID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addtransaction/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("senderID", senderID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("receiverID", receiverID)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:28
    def addBank(bankID:String, nationality:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addbank/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nationality", nationality)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:20
    def isPurchase(transactionID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ispurchase/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("transactionID", transactionID)))
    }
  
    // @LINE:12
    def addConsumer(uniqueID:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addconsumer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("uniqueID", uniqueID)))
    }
  
    // @LINE:32
    def bankStatus(bankID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "isblacklisted/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bankID", bankID)))
    }
  
    // @LINE:38
    def getAcceptanceLog(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "acceptancelog")
    }
  
    // @LINE:24
    def isTrusted(merchantID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "istrusted/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("merchantID", merchantID)))
    }
  
    // @LINE:26
    def reset(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "reset")
    }
  
  }

  // @LINE:8
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
