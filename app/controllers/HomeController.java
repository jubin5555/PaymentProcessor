package controllers;

import ServiceLayer.OntologyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import drools.Bank;
import drools.Transactions;
import org.apache.jena.ontology.*;
import play.mvc.*;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.apache.jena.util.FileManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Logger.AcceptanceLogger;


import plugins.Drools;

;import static Logger.AcceptanceLogger.getFinalAcceptionLog;
import static Logger.AcceptanceLogger.resetAcceptanceLogger;
import static Logger.RejectionLogger.getFinalRejectionLog;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

public class HomeController extends Controller {
    String source_file = "owlfiles//ontologies.owl"; // This is your file on the disk
    String source_url = "http://www.semanticweb.org/jajubina/ontologies/2018/9/socP3.owl"; // Remember that IRI from before?
    String NS = source_url + "#";
    public static OntModel baseOntology=null;
    public static OntModel ontReasoned=null;
    public static Map<Integer,Bank> bankMap = new HashMap<>();
    @Inject
    Drools drools;
    public static String s;


   public HomeController()
   {
       if(ontReasoned==null || baseOntology==null)
       {
           loadOntology();
       }
    }
    public void loadOntology(){
        baseOntology = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        try
        {
            InputStream in = FileManager.get().open(source_file);
            try
            {
                baseOntology.read(in, null);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (JenaException je)
        {
            System.err.println("ERROR" + je.getMessage());
            je.printStackTrace();
            System.exit(0);
        }

        baseOntology.setNsPrefix( "csc750", NS ); // Just for compact printing; doesn't really matter
        ontReasoned = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC, baseOntology);
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result addMerchant(String uniqueID){
        OntologyService onto = new OntologyService();
        ObjectNode object = onto.addMerchantService(Integer.parseInt(uniqueID));
        return ok(object);
    }

    public Result addConsumer(String uniqueID){
        OntologyService onto = new OntologyService();
        ObjectNode object = onto.addConsumerService(Integer.parseInt(uniqueID));
        return ok(object);
    }

    public Result addTransaction(String senderID,String receiverID,String transactionID){
        OntologyService onto =new OntologyService();
        onto.addTransactionService(Integer.parseInt(senderID),Integer.parseInt(receiverID),Integer.parseInt(transactionID));
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return ok(objectNode1);
    }

    public Result isCommercial(String transactionID){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        OntologyService onto = new OntologyService();
        Boolean isTransaction = onto.isTransaction(Integer.parseInt(transactionID));
        if(isTransaction ==false)
        {
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
       Boolean isCommercial = onto.isCommercialService(Integer.parseInt(transactionID));
        if(isCommercial.equals(Boolean.TRUE))
        {
            objectNode1.put("result","true");
        }
        else
        {
            objectNode1.put("result","false");
        }
        return ok(objectNode1);
    }

    public Result isPersonal(String transactionID){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        OntologyService onto = new OntologyService();
        Boolean isTransaction = onto.isTransaction(Integer.parseInt(transactionID));

        if(isTransaction ==false)
        {
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        Boolean isPersonal = onto.isPersonalService(Integer.parseInt(transactionID));
        if(isPersonal.equals(Boolean.TRUE))
        {
            objectNode1.put("result","true");
        }
        else
        {
            objectNode1.put("result","false");
        }
        return ok(objectNode1);
    }

    public Result isPurchase(String transactionID){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        OntologyService onto = new OntologyService();
        Boolean isTransaction = onto.isTransaction(Integer.parseInt(transactionID));

        if(isTransaction ==false)
        {
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        Boolean isPurchase = onto.isPurchaseService(Integer.parseInt(transactionID));
        if(isPurchase.equals(Boolean.TRUE))
        {
            objectNode1.put("result","true");
        }
        else
        {
            objectNode1.put("result","false");
        }
        return ok(objectNode1);
    }

    public Result isRefund(String transactionID){ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        OntologyService onto = new OntologyService();
        Boolean isTransaction = onto.isTransaction(Integer.parseInt(transactionID));

        if(isTransaction ==false)
        {
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        Boolean isRefund = onto.isRefundService(Integer.parseInt(transactionID));
        if(isRefund.equals(Boolean.TRUE))
        {
            objectNode1.put("result","true");
        }
        else
        {
            objectNode1.put("result","false");
        }

        return ok(objectNode1);
    }

    public Result isTrusted(String merchantID){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        OntologyService onto = new OntologyService();

        //check if id is a valid
        if(onto.checkIDExists(Integer.parseInt(merchantID))==Boolean.FALSE){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }

        //check if id is valid for merchant
        if (onto.isMerchantService(Integer.parseInt(merchantID))==Boolean.FALSE) {
            objectNode1.put("status","merchant ID does not exist");
           return ok( objectNode1);
        }

        if(onto.isValidTrustedID(Integer.parseInt(merchantID))==Boolean.FALSE){
            objectNode1.put("result","false");
            return ok(objectNode1);
        }

        if(onto.isTrustedService(Integer.parseInt(merchantID))==Boolean.TRUE)
        {
            objectNode1.put("result","true");
        }
        else
        {
            objectNode1.put("result","false");
        }

        return ok(objectNode1);
    }

    public Result reset(){
        loadOntology();
        resetAcceptanceLogger();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("result", "success");
        return ok(objectNode1);
    }

    public Result addBank(String id,String nationality)
    {
        Bank bank = new Bank();
        bank.setStatus(nationality);
        bank.setBankID(Integer.parseInt(id));
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("result", "success");
        bankMap.put(Integer.parseInt(id),bank);
        return ok(objectNode1);
    }

    public Result addTransactionTwo(String senderID,String receiverID,String bankID,String category,String amount,String transactionID)
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();

        Transactions transaction = new Transactions();
        transaction.setSenderIDForTransaction(Integer.parseInt(senderID));
        transaction.setReceiverIDForTransaction(Integer.parseInt(receiverID));
        transaction.setBankIDForTransaction(Integer.parseInt(bankID));
        transaction.setCategoryForTransaction(category);
        transaction.setAmountForTransaction(Integer.parseInt(amount));
        transaction.setTransactionID(Integer.parseInt(transactionID));
        transaction.setTimeStampForTransaction();
        transaction.setBankLocality(bankMap.get(Integer.parseInt(bankID)).getStatus());
        drools.kieSession.insert(transaction);
        drools.kieSession.fireAllRules();
        OntologyService onto = new OntologyService();
        if(onto.isTransaction(Integer.parseInt(transactionID)).equals(Boolean.TRUE))
        {
            objectNode1.put("result","success");
        }
        else{
            if(transaction.getRejectionList().size()>=1)
            {
                objectNode1.put("result","failure");
                objectNode1.put("Rule failure number",transaction.getRejectionList().get(0).toString());
            }
            else
            {
                transaction.addTransactionDetailToRejectionLog("3",transaction);
                objectNode1.put("result","failure");
                objectNode1.put("Rule failure number: ", "3");
            }
        }
        return ok(objectNode1);
    }

    //returns whether the bank is blacklisted or not
    public Result bankStatus(String bankID)
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("result", "success");
        System.out.println(bankMap);
        if(!bankMap.containsKey(Integer.parseInt(bankID))){
            objectNode1.put("status","failure");
            objectNode1.put("reason","not a bank");
            return ok(objectNode1);
        }
        Bank tempBank = bankMap.get(Integer.parseInt(bankID));
        Boolean tempBool = tempBank.getBlacklistStatus();
        System.out.println(tempBool);
        if(tempBool.equals(Boolean.TRUE))
        {
            objectNode1.put("status","success");
            objectNode1.put("result","true");
        }
        else{
            objectNode1.put("status","success");
            objectNode1.put("result","false");
        }
        return ok(objectNode1);
    }

    public Result getBankRejectionCount(String bankID)
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("result", "success");
        if(!bankMap.containsKey(Integer.parseInt(bankID))){
            objectNode1.put("status","failure");
            objectNode1.put("reason","not a bank");
            return ok(objectNode1);
        }
        Bank tempBank = bankMap.get(Integer.parseInt(bankID));
        int tempCount = tempBank.getBankRejectionCount();
        objectNode1.put("status","success");
        objectNode1.put("result",tempCount);
        return ok(objectNode1);
    }

    public Result getRejectionLog()
    {
        String s =getFinalRejectionLog();
        return ok(s);
    }

    public Result getAcceptanceLog()
    {
        String s =getFinalAcceptionLog();
        return ok(s);
    }
}
