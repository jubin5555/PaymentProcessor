package drools;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {
    private String locality;
    private Boolean blacklisted;
    private Integer ID;
    private Integer totalRejectionCount;
    private Integer transactionCount;
    private Integer totalAmount;
    private Integer trustedMerchantCount;
    private Integer checkBankTrustedAverage;
    private Integer bankAverageTransactions;
    private Set<Integer> rejectionSet = new HashSet<>();

    public Bank(){
        this.blacklisted=false;
        this.transactionCount=0;
        this.totalAmount=0;
        this.trustedMerchantCount=0;
        this.bankAverageTransactions=0;
    }
    public int  getTotalAmount(){
        return this.totalAmount;
    }
    public int getTrustedMerchantCount(){
        return this.trustedMerchantCount;
    }
    public void setTrustedMerchantCount(){
        this.trustedMerchantCount =this.trustedMerchantCount+1;
    }
    public void setTotalAmount(int currentAmount){
        this.totalAmount=this.totalAmount+currentAmount;
    }
    public  String getStatus() {
        return this.locality;
    }
    public int getTransactionCount(){
        return this.transactionCount;
    }
    public void setTransactionCount() {
     this.transactionCount=this.transactionCount+1;
    }
    public void setBankRejectionCount() {
        totalRejectionCount=totalRejectionCount+1;
    }
    public int getBankRejectionCount() {
        return  this.totalRejectionCount;
    }
    public void setStatus(String message) {
        this.locality=message;
    }
    public  Boolean getBlacklistStatus() {
        return blacklisted;
    }
    public  void setBlacklist() {
        this.blacklisted=true;
    }
    public int getBankID(){
        return this.ID;
    }
    public void setBankID(int bankID){
        this.ID =bankID;
    }
    public void addRejectionToBank(int transactionID){
        this.rejectionSet.add(transactionID);
    }
    public int getBankAverageTransactions(){
        if(this.transactionCount!=0){
            return (this.totalAmount)/(transactionCount);
        }
        return 0;
    }
    public int getBankTrustedPartnerAverage(){
        if(this.transactionCount!=0){
            return ((this.trustedMerchantCount)/(this.transactionCount)) *100;
        }
        return 0;
    }
    public boolean getLastThreeTransactionRejection()
    {

        if(this.rejectionSet.size() <3)
        {
            return false;
        }
        else {
            int sum=0;
            List<Integer > list =new ArrayList<>(rejectionSet);
            for(int i=list.size()-4;i<=list.size()-1;i++)
            {
                sum=sum+list.get(i);
            }
            int div =sum/3;
            if(div==list.get(list.size()-2))
            {
                return true;
            }
        }
        return false;
    }
}
