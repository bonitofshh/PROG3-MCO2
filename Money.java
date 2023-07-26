/**
 * A money object that stores the number of denominations.
 * It records the number of bills and coins.
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

public class Money {
    private int coin1;
    private int coin5;
    private int coin10;
    private int bill20;
    private int bill50;
    private int bill100;
    
    /**
     * Sets each denomination to zero when a money object is created.
     */
    public Money () {
        this.coin1 = 0;
        this.coin5 = 0;
        this.coin10 = 0;
        this.bill20 = 0;
        this.bill50 = 0;
        this.bill100 = 0;
    }

    public Money (int coin1, int coin5, int coin10, int bill20, int bill50, int bill100) {
        this.coin1 = coin1;
        this.coin5 = coin5;
        this.coin10 = coin10;
        this.bill20 = bill20;
        this.bill50 = bill50;
        this.bill100 = bill100;
    }

    /**
     * Displays a breakdown of denominations
     */
    public void displayDenominations() {
        if (this.getTotalMoney() != 0) System.out.println("MONEY BREAKDOWN");
        if(this.bill100>0) System.out.println("No. of 100 bills: " + bill100);
        if(this.bill50>0) System.out.println("No. of 50 bills: " + bill50);
        if(this.bill20>0) System.out.println("No. of 20 bills: " + bill20);
        if(this.coin10>0) System.out.println("No. of 10 coins: " + coin10);
        if(this.coin5>0) System.out.println("No. of 5 coins: " + coin5);
        if(this.coin1>0) System.out.println("No. of 1 coins: " + coin1);
    }

    /**
     * Gets the total amount of money in a money object
     * @return total money
     */
    public int getTotalMoney(){ 
        return coin1*1 + coin5*5 + coin10*10 + bill20*20 + bill50*50 +
                    bill100*100;
    }
    
    /**
     * Gets the number of 1 peso coins
     * @return number of 1 peso coins
     */
    public int getCoin1() {
        return coin1;
    }

    /**
     * Gets the number of 5 peso coins
     * @return number of 5 peso coins
     */
    public int getCoin5() {
        return coin5;
    }

    /**
     * Gets the number of 10 peso coins
     * @return number of 10 peso coins
     */
    public int getCoin10() {
        return coin10;
    }

    /**
     * Gets the number of 20 peso bills
     * @return number of 20 peso bills
     */
    public int getBill20() {
        return bill20;
    }

    /**
     * Gets the number of 50 peso bills
     * @return number of 50 peso bills
     */
    public int getBill50() {
        return bill50;
    }

    /**
     * Gets the number of 100 peso bills
     * @return number of 100 peso bills
     */
    public int getBill100() {
        return bill100;
    }

    /**
     * Sets the number of 1 peso coins
     * @param coin1 new number of 1 peso coins
     */
    public void setCoin1(int coin1) {
        this.coin1 = coin1;
    }

    /**
     * Sets the number of 5 peso coins
     * @param coin5 new number of 5 peso coins
     */
    public void setCoin5(int coin5) {
        this.coin5 = coin5;
    }

    /**
     * Sets the number of 10 pesocoins
     * @param coin10 new number of 10 peso coins
     */
    public void setCoin10(int coin10) {
        this.coin10 = coin10;
    }


    /**
     * Sets the number of 20 peso bills
     * @param bill20 new number of 20 peso bills
     */
    public void setBill20(int bill20) {
        this.bill20 = bill20;
    }

    /**
     * Sets the number of 50 peso bills
     * @param bill50 new number of 50 peso bills
     */
    public void setBill50(int bill50) {
        this.bill50 = bill50;
    }

    /**
     * Sets the number of 100 peso bills
     * @param bill100 new number of 100 peso bills
     */
    public void setBill100(int bill100) {
        this.bill100 = bill100;
    }
}
