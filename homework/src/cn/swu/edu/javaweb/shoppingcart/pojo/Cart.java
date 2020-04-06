package cn.swu.edu.javaweb.shoppingcart.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
    private double price;

    /**
     * 向购物车中添加图书
     * @param book
     */
    public void add(Book book) {

        CartItem item = map.get(book.getId());

        if(item == null) {
            // 若不存在相同类型书籍，则创建新的购物项
            item = new CartItem();
            item.setBook(book);
            item.setQuantity(1);
            // 将购物项添加到购物车中
            map.put(book.getId(), item);
        } else {
            // 若存在相同类型书籍，则将购物项个数加一
            item.setQuantity(item.getQuantity()+1);
        }
    }
    /**
     * 重构getPrice方法
     * @return
     */
    public double getPrice() {

        // 购物车总价格
        double totalprice = 0;
        // 迭代购物车中所有购物项, 相加获取购物车总价
        for(Map.Entry<String, CartItem> me : map.entrySet()) {
            CartItem item = me.getValue();
            totalprice += item.getPrice();
        }
        return totalprice;
    }
    public Map<String, CartItem> getMap() {
        return map;
    }
    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
