package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.jena.ontology.*;
import play.mvc.*;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.apache.jena.util.FileManager;

import java.io.InputStream;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    String source_file = "owlfiles//ontologies.owl"; // This is your file on the disk
    String source_url = "http://www.semanticweb.org/jajubina/ontologies/2018/9/socP3.owl"; // Remember that IRI from before?
    String NS = source_url + "#";
    static OntModel baseOntology=null;
    static OntModel ontReasoned=null;
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
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result addMerchant(String uniqueID){
        OntClass merchant = ontReasoned.getOntClass(NS + "Merchant");
        Individual merchant1 = ontReasoned.createIndividual(NS + uniqueID, merchant);
        //System.out.println("Merchant created: " + merchant1.hasOntClass(merchant));  // should print true

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return ok(objectNode1);
    }

    public Result addConsumer(String uniqueID){
        OntClass consumer = ontReasoned.getOntClass(NS + "Consumer");
        Individual consumer1 = ontReasoned.createIndividual(NS + uniqueID, consumer);
        //System.out.println("Consumer created: " + consumer1.hasOntClass(consumer));  // should print true

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return ok(objectNode1);
    }

    public Result addTransaction(String senderID,String receiverID,String transactionID){
        OntClass transaction = ontReasoned.getOntClass(NS + "Transaction");
        OntClass merchant = ontReasoned.getOntClass(NS + "Merchant");
        OntClass consumer =ontReasoned.getOntClass(NS+"Consumer");
        Individual transaction1 = ontReasoned.createIndividual(NS + transactionID, transaction);
        OntProperty hasSender = ontReasoned.getObjectProperty(NS + "hasSender");
        //System.out.println(hasSender);
        OntProperty hasReceiver =ontReasoned.getObjectProperty(NS+"hasReceiver");
        //System.out.println(hasReceiver);

        OntProperty participatesin =ontReasoned.getObjectProperty(NS+"participatesIn");
        Individual merchant1 =ontReasoned.getIndividual(NS +receiverID);
        Individual consumer1=ontReasoned.getIndividual(NS+senderID);
        if(merchant1!=null && consumer1!=null) {
            if (merchant1.hasOntClass(merchant) && consumer1.hasOntClass(consumer)) {
                merchant1.addProperty(participatesin,transaction1);
            }
        }
        Individual sender = ontReasoned.getIndividual(NS + senderID);
        //System.out.println(sender);
        Individual receiver =ontReasoned.getIndividual(NS+receiverID);
        //System.out.println(receiver);
        transaction1.addProperty(hasSender,sender);
        transaction1.addProperty(hasReceiver,receiver);
        //System.out.println("T " + transaction1.hasOntClass(transaction));  // should print true

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("status:", "success");
        return ok(objectNode1);
    }

    public Result isCommercial(String transactionID){
        OntClass commercial = ontReasoned.getOntClass(NS + "commercialTransaction");
        Individual commercial1 =ontReasoned.getIndividual(NS+transactionID);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        if(commercial1==null){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        //System.out.println(commercial1.hasOntClass(commercial));
        try{
        if(commercial1.hasOntClass(commercial)) {
            objectNode1.put("result", "true");
        }
        else{

            objectNode1.put("result","false");
        }}
        catch(Exception e){
            objectNode1.put("result","error");
            return ok(objectNode1);
        }
        return ok(objectNode1);
    }

    public Result isPersonal(String transactionID){
        OntClass personal = ontReasoned.getOntClass(NS + "personalTransaction");
        Individual personal1 =ontReasoned.getIndividual(NS+transactionID);
        //System.out.println(personal1);
        //System.out.println();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        if(personal1==null){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        //System.out.print(personal1.hasOntClass(personal));
        try{
        if(personal1.hasOntClass(personal)) {
            objectNode1.put("result", "true");
        }
        else{
            objectNode1.put("result","false");
        }}catch(Exception e){
            objectNode1.put("result","error");
            return ok(objectNode1);
        }

        return ok(objectNode1);
    }

    public Result isPurchase(String transactionID){
        OntClass purchase = ontReasoned.getOntClass(NS + "Purchase");
        Individual purchase1 =ontReasoned.getIndividual(NS+transactionID);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        if(purchase1==null){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        //System.out.println(purchase1.hasOntClass(purchase));
        try{
        if(purchase1.hasOntClass(purchase)) {
            objectNode1.put("result", "true");
        }
        else{
            objectNode1.put("result", "false");
        }}catch(Exception e)
    {
        objectNode1.put("result", "error");
        return ok(objectNode1);
    }
        return ok(objectNode1);
    }

    public Result isRefund(String transactionID){
        OntClass refund = ontReasoned.getOntClass(NS + "Refund");
        Individual refund1 =ontReasoned.getIndividual(NS+transactionID);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        if(refund1==null){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        //System.out.println(refund1.hasOntClass(refund));
        try{
        if(refund1.hasOntClass(refund)) {
            objectNode1.put("result", "true");
        }
        else{
            objectNode1.put("result","false");
        }}catch(Exception e)
        {
            objectNode1.put("result", "error");
            return ok(objectNode1);
        }
        return ok(objectNode1);
    }

    public Result isTrusted(String merchantID){
        OntClass trusted = ontReasoned.getOntClass(NS + "Trusted");
        OntClass merchant =ontReasoned.getOntClass(NS+"Merchant");
        Individual trusted1 =ontReasoned.getIndividual(NS+merchantID);
        Individual merchant1= ontReasoned.getIndividual(NS+merchantID);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        if(merchant1==null){objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);}
        if (!merchant1.hasOntClass(merchant)) {
           return ok( objectNode1.put("status","merchant ID does not exist"));
        }
        if(trusted1==null){
            objectNode1.put("result","error the id does not exist");
            return ok(objectNode1);
        }
        try {
            if (trusted1.hasOntClass(trusted)) {
                objectNode1.put("result", true);
            } else {
                objectNode1.put("result", false);
            }
        }catch(Exception e)
        {
            objectNode1.put("error", "not a merchant");
            return ok(objectNode1);
        }
        return ok(objectNode1);
    }

    public Result reset(){
        loadOntology();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("result", "success");
        return ok(objectNode1);
    }
}
