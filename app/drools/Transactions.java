package drools;

import ServiceLayer.OntologyService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static controllers.HomeController.bankMap;

public class Transactions {

    private int bankID;
    private int amount;
    private int senderID;
    private int receiverID;
    private int transactionID;
    private String timeStamp;
    private String category;
    private String bankLocality;
    private List<Integer> rejectionReasonList = new ArrayList<>();

    public void setTransactionID(int transactionID)
    {
        this.transactionID=transactionID;
    }
    public int getTransactionID()
    {
        return this.transactionID;
    }
    public void setBankIDForTransaction(int bankID){
        this.bankID =bankID;
    }
    public int getBankIDForTransaction(){
        return this.bankID;
    }
    public void setAmountForTransaction(int amount){
        this.amount =amount;
    }
    public int getAmountForTransaction(){
        return this.amount;
    }
    public void setSenderIDForTransaction(int senderID){
        this.senderID=senderID;
    }
    public int getSenderIDForTransaction(){
        return this.senderID;
    }
    public void setReceiverIDForTransaction(int receiverID){
        this.receiverID=receiverID;
    }
    public int getReceiverIDForTransaction(){
        return this.receiverID;
    }
    public void setTimeStampForTransaction(){
        Date date = new Date();
        this.timeStamp = date.toString();
    }
    public String getTimeStampIDForTransaction() {
        return this.timeStamp;
    }
    public void setCategoryForTransaction(String category){
            this.category=category;
    }
    public String getCategoryForTransaction(){
        return this.category;
    }
    public void setBankBlackListed(int id) {
        Bank bank =bankMap.get(id);
        bank.setBlacklist();
    }
    public boolean getBankStatus(int id){
        Bank bank = bankMap.get(id);
        return bank.getBlacklistStatus();
    }
    public void addTransactionDetailToAcceptanceLog(Transactions t){
        Logger.AcceptanceLogger.addToAcceptionLog(t);
    }
    public void addTransactionDetailToRejectionLog(String s,Transactions t){
        Logger.RejectionLogger.addToRejectionLog(s,t);
    }
    public void addTransactionToOWL(int senderID,int receiverID,int transactionID){

        //before adding transaction to owl we need to add the attributes to the bank instance
        Bank tempBank =bankMap.get(this.getBankIDForTransaction());
        tempBank.setTransactionCount();
        tempBank.setTotalAmount(this.amount);
        if(isTrusted(this.getReceiverIDForTransaction()) || isTrusted(this.getSenderIDForTransaction()))
        {
            tempBank.setTrustedMerchantCount();
        }

        //adding the transaction to the ontology
        OntologyService onto = new OntologyService();
        onto.addTransactionService(senderID,receiverID,transactionID);
    }
    public void addRejectionReason(int rules)
    {
        this.rejectionReasonList.add(rules);
    }
    public List getRejectionList(){
        return this.rejectionReasonList;
    }
    public boolean isTrusted(int id)
    {
        OntologyService onto = new OntologyService();
        System.out.println("Inside Onto" +onto.isTrustedService(id));
        return onto.isTrustedService(id);
    }
    public String getBankLocality( ){
        return this.bankLocality;
    }
    public void setBankLocality(String s){
        this.bankLocality =s;
    }

    //false means has been rejected last three times.
    public boolean getLastThreeTransactiondetailForBank(){
        Bank bank =bankMap.get(this.getBankIDForTransaction());
        System.out.println("Inside getLastThreeTransactionDetailForBank" + bank.getLastThreeTransactionRejection());
        return bank.getLastThreeTransactionRejection();
    }

    public int getBankTrustedAverage(){
        Bank bank =bankMap.get(this.getBankIDForTransaction());
        System.out.println("The trusted Average is: "+ bank.getBankTrustedPartnerAverage());
        return bank.getBankTrustedPartnerAverage();
    }

    //0 means it is the first transaction
    public int getBankAverage(){
        Bank bank =bankMap.get(this.getBankIDForTransaction());
        System.out.println("Inside bank total amount: "+ bank.getBankAverageTransactions());
        return bank.getBankAverageTransactions();
    }

    public void addTransctionToRejectionSet(Boolean tempBool){
        Bank bank = bankMap.get(this.getBankIDForTransaction());
        bank.addRejectionToBank(tempBool);
    }
}
