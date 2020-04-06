package cn.swu.edu.javaweb.shoppingcart.pojo;

public class CartItem {

    private Book book;
    private int quantity;
    private double price;

    /**
     * 重构getPrice方法
     * @return 购物项总价格
     */
    public double getPrice() {
        return book.getPrice() * this.quantity;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
