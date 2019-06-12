package cn.swu.edu.javaweb.shoppingcart.service;

import java.util.List;


import cn.swu.edu.javaweb.dao.DAO;
import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
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
}