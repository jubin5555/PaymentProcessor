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
    private List<Boolean> rejectionSet = new ArrayList<>();

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

    public int getBankRejectionCount() {
        int count=0;
        for(Boolean tempBool:this.rejectionSet)
        {
            if(tempBool.equals(Boolean.TRUE))
            {
                count++;
            }
        }
        return count;
    }
    public void setStatus(String message) {
        this.locality=message;
    }
    public  Boolean getBlacklistStatus() {
        return this.blacklisted;
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
    public void addRejectionToBank(Boolean bool){
        System.out.println("Inside Bank adding rejection" );
        this.rejectionSet.add(bool);
    }
    public int getBankAverageTransactions(){
        if(this.transactionCount!=0){
            return (this.totalAmount)/(this.transactionCount);
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
        System.out.println("The rejection set is" + this.rejectionSet);
        Boolean tempBool =Boolean.TRUE;
        if(this.rejectionSet.size() <3)
        {
            return false ;
        }
        else {

            for(int i=this.rejectionSet.size()-3;i<this.rejectionSet.size();i++)
            {
                System.out.println("Inside list" +this.rejectionSet.get(i));
                tempBool=tempBool && this.rejectionSet.get(i);
            }
        }
        return tempBool;
    }
}
