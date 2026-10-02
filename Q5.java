class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    Cart(String cartId, int capacity) {
        this.cartId = cartId;
        prices = new double[capacity];
        count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length && price >= 0) {
            prices[count++] = price;
        } else {
            System.out.println("Invalid price or cart is full");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return count;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}