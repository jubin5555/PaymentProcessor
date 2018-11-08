package Logger;

import drools.Transactions;

public  class RejectionLogger {
    private static StringBuffer sb= new StringBuffer();

    public static void addToRejectionLog(String s, Transactions t)
    {
        sb.append("Transaction ID is " + t.getTransactionID() +" ");
        sb.append("Bank ID is "+ t.getBankIDForTransaction() + " ");
        sb.append("Sender ID is " + t.getSenderIDForTransaction() +" ");
        sb.append("Receiver ID is "+ t.getReceiverIDForTransaction() + " ");
        sb.append("Amount is " + t.getAmountForTransaction() +" ");
        sb.append("Category is "+ t.getCategoryForTransaction() + " ");
        sb.append("Timestamp is " + t.getTimeStampIDForTransaction() +" ");
        sb.append("The rule because of which the certain transaction failed is  "+ s + " ");
        sb.append("\n");

    }
    public static String getFinalRejectionLog(){
        return sb.toString();
    }

    public static void resetRejectionLogger(){
        sb = new StringBuffer();
    }
}
