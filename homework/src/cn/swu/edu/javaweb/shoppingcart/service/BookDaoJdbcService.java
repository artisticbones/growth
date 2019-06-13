package cn.swu.edu.javaweb.shoppingcart.service;

import java.util.List;


import cn.swu.edu.javaweb.dao.DAO;
import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
import cn.swu.edu.javaweb.shoppingcart.dao.CartNotFoundException;
import cn.swu.edu.javaweb.shoppingcart.pojo.Book;
import cn.swu.edu.javaweb.shoppingcart.pojo.Cart;

public class BookDaoJdbcService extends DAO<Book> implements BookDao{

	private BookDao bookDao = new BookDaoJdbcService();
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from t_book";
		return getForList(sql);
	}

	@Override
	public Book find(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_book where id = ?";
		return get(sql, id);
	}
	
	@Override
	public void buyBook(String id, Cart cart) {
		// TODO Auto-generated method stub
		Book book = bookDao.find(id);
		cart.add(book);
	}

	@Override
	public void deleteBook(String id, Cart cart) throws CartNotFoundException {
		// TODO Auto-generated method stub
		//如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
        //告诉用户购物车是空的
        if (cart == null) {
            throw new CartNotFoundException("购物车为空");
        }
        
      //把购物项移除出去集合就行了！
        cart.getMap().remove(id);
	}

	@Override
	public void updateQuantity(String id, Cart cart, String quantity) throws CartNotFoundException {
		// TODO Auto-generated method stub
		//如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
        //告诉用户购物车是空的
        if (cart == null) {
            throw new CartNotFoundException("购物车为空");
        }

        //通过书的id获取得到购物车的购物项，再修改购物项的数量即可！（因为书的id和获取购物项的关键字是一致的！）
        cart.getMap().get(id).setQuantity(Integer.parseInt(quantity));
	}

	@Override
	public void clearCart(Cart cart) throws CartNotFoundException {
		// TODO Auto-generated method stub
		cart.getMap().clear();
	}
}