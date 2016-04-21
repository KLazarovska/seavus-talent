package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Book;

public class LibraryDao {
	
	public Connection getConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
		}catch(SQLException e){
			e.getMessage();
		}
		return connection;
	}
	
	public void registerBook(Book book) throws SQLException{
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("insert into book(isbn, title) values (?, ?)");
			statement.setString(1, book.getIsbn());
			statement.setString(2, book.getTitle());
			statement.addBatch();
			statement.executeUpdate();
		}finally{
			connection.close();
			statement.close();
		}
	}
	
	public void listBooks() throws SQLException{
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from book");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String isbn= resultSet.getString("isbn");
				String title = resultSet.getString("title");
				System.out.println("ID - " + id + " | ISBN - " + isbn+ " | Title - " + title);
			}
		}finally{
			connection.close();
			statement.close();
		}
	}
	
	public void updateBook(String isbn, String title) throws SQLException{
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("update book set title = ? where isbn = ?");
			statement.setString(1, title);
			statement.setString(2, isbn);
			statement.addBatch();
			statement.executeUpdate();
		}finally{
			connection.close();
			statement.close();
		}
	}
	
	public void unregisterBook(String isbn) throws SQLException{
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("delete from book where isbn = ?");
			 statement.setString(1, isbn);
			 statement.executeUpdate();
		}finally{
			connection.close();
			statement.close();
		}
	}
}
