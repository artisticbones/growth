package cn.swu.edu.javaweb.shoppingcart.dao;

import java.util.List;

import cn.swu.edu.javaweb.shoppingcart.pojo.Book;
import cn.swu.edu.javaweb.shoppingcart.pojo.Cart;

public interface BookDao {
	
	//获取存放着书籍的Map集合
	public List<Book> getAll();
	
	//根据关键字获取某本书籍
	public Book find(String id);
	
	//将用户想买的书的id与购物车关联
	public void buyBook(String id,Cart cart);

	public void deleteBook(String id, Cart cart) throws CartNotFoundException;

	public void updateQuantity(String id, Cart cart, String quantity) throws CartNotFoundException;

	public void clearCart(Cart cart) throws CartNotFoundException;
}
