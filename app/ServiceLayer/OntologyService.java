package ServiceLayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import openllet.core.utils.Bool;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntProperty;

import static controllers.HomeController.ontReasoned;

public class OntologyService {
    String source_url = "http://www.semanticweb.org/jajubina/ontologies/2018/9/socP3.owl"; // Remember that IRI from before?
    String NS = source_url + "#";

    //this method is used to add merchant to the ontology
    public  ObjectNode addMerchantService(int uniqueID){
        OntClass merchant = ontReasoned.getOntClass(NS + "Merchant");
        Individual merchant1 = ontReasoned.createIndividual(NS + uniqueID, merchant);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return objectNode1;
    }

    public ObjectNode addConsumerService(int uniqueID){
        OntClass consumer = ontReasoned.getOntClass(NS + "Consumer");
        Individual consumer1 = ontReasoned.createIndividual(NS + uniqueID, consumer);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return objectNode1;
    }

    public  Boolean isTransaction(int transactionID){
        Individual transaction1 =ontReasoned.getIndividual(NS+transactionID);
        if(transaction1==null){ return false;}
        else {return true;}
    }
    /**
     * The function is used to add a transaction as well as check if the transaction is a purchase transaction
     * and make the merchant trusted.
     * **/
    public  void addTransactionService(Integer senderID,Integer receiverID,Integer transactionID){

        //adding a certain transaction
        OntClass transaction = ontReasoned.getOntClass(NS + "Transaction");
        Individual transaction1 = ontReasoned.createIndividual(NS + transactionID, transaction);
        OntProperty hasSender = ontReasoned.getObjectProperty(NS + "hasSender");
        OntProperty hasReceiver =ontReasoned.getObjectProperty(NS+"hasReceiver");
        Individual sender = ontReasoned.getIndividual(NS + senderID);
        Individual receiver =ontReasoned.getIndividual(NS+receiverID);
        transaction1.addProperty(hasSender,sender);
        transaction1.addProperty(hasReceiver,receiver);

        //here we check if the receiver is a merchant and if the sender is a consumer
        //if yes then add make the merchant trusted since he takes part in the purchase transaction
        OntClass merchant = ontReasoned.getOntClass(NS + "Merchant");
        OntClass consumer =ontReasoned.getOntClass(NS+"Consumer");
        OntProperty participatesin =ontReasoned.getObjectProperty(NS+"participatesIn");
        Individual merchant1 =ontReasoned.getIndividual(NS +receiverID);
        Individual consumer1=ontReasoned.getIndividual(NS+senderID);
        if(merchant1!=null && consumer1!=null) {
            if (merchant1.hasOntClass(merchant) && consumer1.hasOntClass(consumer)) {
                merchant1.addProperty(participatesin,transaction1);
            }
        }


    }
    public  Boolean isCommercialService(int transactionID){
        OntClass commercial = ontReasoned.getOntClass(NS + "commercialTransaction");
        Individual commercial1 =ontReasoned.getIndividual(NS+transactionID);
        if(commercial1.hasOntClass(commercial)) {
           return true;
        }
        else {
            return false;
        }
    }
    public  Boolean isPersonalService(int transactionID){
        OntClass personal = ontReasoned.getOntClass(NS + "personalTransaction");
        Individual personal1 =ontReasoned.getIndividual(NS+transactionID);
        if(personal1.hasOntClass(personal)) {
            return true;
        }
        else {
            return false;
        }

    }
    public  Boolean isPurchaseService(int transactionID){
        OntClass purchase = ontReasoned.getOntClass(NS + "Purchase");
        Individual purchase1 =ontReasoned.getIndividual(NS+transactionID);
        if(purchase1.hasOntClass(purchase)) {
            return true;
        }
        else {
            return false;
        }
    }
    public  Boolean isRefundService(int transactionID){
        OntClass refund = ontReasoned.getOntClass(NS + "Refund");
        Individual refund1 =ontReasoned.getIndividual(NS+transactionID);
        if(refund1.hasOntClass(refund)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean isTrustedService(int merchantID){
        OntClass trusted = ontReasoned.getOntClass(NS + "Trusted");
        Individual trusted1 =ontReasoned.getIndividual(NS+merchantID);

        if (trusted1.hasOntClass(trusted)) {
            return true;
        }
        return false;
    }

    public Boolean isMerchantService(int merchantID){
        OntClass merchant =ontReasoned.getOntClass(NS+"Merchant");
        Individual merchant1= ontReasoned.getIndividual(NS+merchantID);
        if (!merchant1.hasOntClass(merchant)) {
            return false;
        }
        return true;
    }

    public Boolean checkIDExists(int merchantID)
    {
        Individual merchant1= ontReasoned.getIndividual(NS+merchantID);
        if(merchant1==null) {
            return false;
        }
        return true;
    }

    public Boolean isValidTrustedID(int merchantID)
    {
        Individual trusted1 =ontReasoned.getIndividual(NS+merchantID);
        if(trusted1 ==null){
            return false;
        }
        return true;
    }
}
