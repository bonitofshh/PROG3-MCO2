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
    private int coin20;
    private int bill20;
    private int bill50;
    private int bill100;
    private int bill200;
    private int bill500;
    private int bill1000;
    
    /**
     * Sets each denomination to zero when a money object is created.
     */
    public Money () {
        this.coin1 = 0;
        this.coin5 = 0;
        this.coin10 = 0;
        this.coin20 = 0;
        this.bill20 = 0;
        this.bill50 = 0;
        this.bill100 = 0;
        this.bill200 = 0;
        this.bill500 = 0;
        this.bill1000 = 0;
    }

    public Money (int coin1, int coin5, int coin10, int coin20, int bill20, int bill50, int bill100, int bill200, int bill500, int bill1000) {
        this.coin1 = coin1;
        this.coin5 = coin5;
        this.coin10 = coin10;
        this.coin20 = coin20;
        this.bill20 = bill20;
        this.bill50 = bill50;
        this.bill100 = bill100;
        this.bill200 = bill200;
        this.bill500 = bill500;
        this.bill1000 = bill1000;
    }

    /**
     * Displays a breakdown of denominations
     */
    public void displayDenominations() {
        if (this.getTotalMoney() != 0) System.out.println("MONEY BREAKDOWN");
        if(this.bill1000>0) System.out.println("No. of 1000 bills: " + bill1000);
        if(this.bill500>0) System.out.println("No. of 500 bills: " + bill500);
        if(this.bill200>0) System.out.println("No. of 200 bills: " + bill200);
        if(this.bill100>0) System.out.println("No. of 100 bills: " + bill100);
        if(this.bill50>0) System.out.println("No. of 50 bills: " + bill50);
        if(this.bill20>0) System.out.println("No. of 20 bills: " + bill20);
        if(this.coin20>0) System.out.println("No. of 20 coins: " + coin20);
        if(this.coin10>0) System.out.println("No. of 10 coins: " + coin10);
        if(this.coin5>0) System.out.println("No. of 5 coins: " + coin5);
        if(this.coin1>0) System.out.println("No. of 1 coins: " + coin1);
    }

    /**
     * Gets the total amount of money in a money object
     * @return total money
     */
    public int getTotalMoney(){ 
        return coin1*1 + coin5*5 + coin10*10 + coin20*20 + bill20*20 + bill50*50 +
                    bill100*100 + bill200*200 + bill500*500 + bill1000*1000;
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
     * Gets the number of 20 peso coins
     * @return number of 20 peso coins
     */
    public int getCoin20() {
        return coin20;
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
     * Gets the number of 200 peso bills
     * @return number of 200 peso bills
     */
    public int getBill200() {
        return bill200;
    }

    /**
     * Gets the number of 500 peso bills
     * @return number of 500 peso bills
     */
    public int getBill500() {
        return bill500;
    }

    /**
     * Gets the number of 1000 peso bills
     * @return number of 1000 peso bills
     */
    public int getBill1000() {
        return bill1000;
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
     * Sets the number of 20 peso coins
     * @param coin20 new number of 20 peso coins
     */
    public void setCoin20(int coin20) {
        this.coin20 = coin20;
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

    /**
     * Sets the number of 200 peso bills
     * @param bill200 new number of 200 peso bills
     */
    public void setBill200(int bill200) {
        this.bill200 = bill200;
    }

    /**
     * Sets the number of 500 peso bills
     * @param bill500 new number of 500 peso bills
     */
    public void setBill500(int bill500) {
        this.bill500 = bill500;
    }

    /**
     * Sets the number of 1000 peso bills
     * @param bill1000 new number of 1000 peso bills
     */
    public void setBill1000(int bill1000) {
        this.bill1000 = bill1000;
    }
}
