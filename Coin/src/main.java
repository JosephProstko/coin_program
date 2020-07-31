import java.util.*;

public class main {

    public HashMap<String, ArrayList<coin>> holder= new HashMap<>();
    public ArrayList<coin> bank;
    public int totalCoin = 0;
    public int marketCap = 1000000;

    /**
     * The constructor fills the universal bank with available coins.
     */
    public main(){
        for (int i = 0; i < marketCap; i++){
            bank.add(new coin(i, "VACANT"));
        }
    }

    /**
     * The coin class creates a coin object for each individual coin.
     */
    public class coin {
        private Integer code;
        private String shareHolder;

        public coin(Integer x, String y) {
            code = x;
            shareHolder = y;
        }
    }

    /**
     * This method executes a transaction for purchasing a coin.
     * @param amount Specifies the amount being purchased.
     * @param owner Specifies the owner of the purchase.
     */
    public void transaction(int amount, String owner){
        if (totalCoin + amount <= marketCap){
            for (int i = 0; i < amount; i++){
                    coin tempCoin = bank.get(0);
                    bank.remove(0);
                    ArrayList<coin> tempList = holder.get(owner);
                    tempList.add(tempCoin);
                    holder.put(owner, tempList);
            }
            totalCoin += amount;
        }
    }
    
    /**
     * This method executes a transaction for selling a coin.
     * @param amount Specifies the amount being sold.
     * @param owner Specifies the owner of the sale.
     */
    public void sell(int amount, String owner){
        for (int i = 0; i < amount; i++) {
            if (!holder.get(owner).isEmpty()){
                ArrayList<coin> tempList = holder.get(owner);
                coin tempCoin = tempList.get(0);
                tempList.remove(0);
                bank.add(tempCoin);
                holder.put(owner, tempList);
            }
        }
    }

    /**
     * Main method executes the final transaction.
     * @param args
     */
    public static void main (String [] args) {
        System.out.println("===========================================================");
        System.out.println("                          COIN                             ");
        System.out.println("===========================================================");
        System.out.println();
    }
}
