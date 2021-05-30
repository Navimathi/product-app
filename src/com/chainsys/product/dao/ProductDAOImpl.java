package com.chainsys.product.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.product.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Product> productSet;
	private static List<String> namelist;
	private static List<Integer> idlist;

	public ProductDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Product> findAll() {
		try {
			pstmt = con.prepareStatement("select * from product_2607");
			rs = pstmt.executeQuery();
			productSet = new HashSet<>();
			while (rs.next()) {
				Product product = new Product(rs.getInt("P_id"), rs.getString("P_name"),
						rs.getDate("P_expiry_date").toLocalDate());
				productSet.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSet;
	}

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2607 where P_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("P_id"), rs.getString("P_name"), rs.getDate("P_expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void save(Product product) {
		try {
			pstmt = con.prepareStatement("insert into product_2607 values(?,?,?)");
			pstmt.setInt(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setDate(3, Date.valueOf(product.getExpiryDate()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2607 set P_name=? where P_id=?");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			pstmt = con.prepareStatement("delete product_2607 where P_id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Product findbyname(String name) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2607 where P_name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("P_id"), rs.getString("P_name"), rs.getDate("P_expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public void updateExpire(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2607 set P_expiry_date=? where P_id=?");
			pstmt.setDate(1, Date.valueOf(product.getExpiryDate()));
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void deletebyname(String name) {
		try {
			pstmt = con.prepareStatement("delete product_2607 where P_name=?");
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<String> ViewAllProductName(){
		try {
			pstmt=con.prepareStatement("select P_name from product_2607");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				namelist.add(rs.getString("P_name"));
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return namelist;

	}
	
	public Product findByDate (String date) {
		Product productED = null;
		try {
			pstmt = con.prepareStatement("Select * from product_2607 where p_expiry_date =?");
			pstmt.setDate(1, Date.valueOf(productED.getExpiryDate()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				productED = new Product(rs.getInt("P_id"), rs.getString("P_name"), rs.getDate("P_expiry_date").toLocalDate());
			}
		}
	    catch (SQLException e) {
			e.printStackTrace();
		}
		return productED;
	}
	
	public void deleteByExpiryDate(String date) {
		Product productED = null;
		try {
			pstmt = con.prepareStatement("delete product_2607 where p_expiry_date=?");
			pstmt.setDate(1, Date.valueOf(productED.getExpiryDate()));
			pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Integer> viewAllProductId(){
		try {
			pstmt=con.prepareStatement("select P_id from product_2607");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				idlist.add(rs.getInt("P_id"));
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return idlist;

	}
}
