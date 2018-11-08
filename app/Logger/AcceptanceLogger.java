package Logger;

import drools.Transactions;

public  class AcceptanceLogger {
    private static StringBuffer sb= new StringBuffer();

    public static void addToAcceptionLog( Transactions t)
    {
        sb.append("The acceptance log : ");
        sb.append("Transaction ID is " + t.getTransactionID() +" ");
        sb.append("Bank ID is "+ t.getBankIDForTransaction() + " ");
        sb.append("Sender ID is " + t.getSenderIDForTransaction() +" ");
        sb.append("Receiver ID is "+ t.getReceiverIDForTransaction() + " ");
        sb.append("Amount is " + t.getAmountForTransaction() +" ");
        sb.append("Category is "+ t.getCategoryForTransaction() + " ");
        sb.append("Timestamp is " + t.getTimeStampIDForTransaction() +" ");
        sb.append("\n");

    }
    public static String getFinalAcceptionLog(){
        return sb.toString();
    }
    public static void resetAcceptanceLogger(){
        sb=new StringBuffer();
    }

}
