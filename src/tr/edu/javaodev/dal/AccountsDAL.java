package tr.edu.javaodev.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.edu.javaodev.core.ObjectHelper;
import tr.edu.javaodev.interfaces.IDALInterfacesExtends;
import tr.edu.javaodev.interfaces.IDALInterfacesUD;
import tr.edu.javaodev.types.PersonelContract;
import tr.edu.javaodev.types.PersonelContract.AccountsContract;

public class AccountsDAL extends ObjectHelper implements IDALInterfacesExtends<PersonelContract.AccountsContract> , IDALInterfacesUD<PersonelContract.AccountsContract>{



	@Override
	public void Insert(PersonelContract.AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO accounts (YetkiId,PersonelId,Sifre) VALUES("+entity.getYetkiId()+","+entity.getPersonelId()+",'"+entity.getSifre()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public AccountsContract GetPersonelIdveSifre(int personelId,String sifre){
		PersonelContract innerContract = new PersonelContract();
		PersonelContract.AccountsContract contract = innerContract.new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();	
		Connection baglanti = getConnection();
		try {
			Statement statement = baglanti.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM accounts WHERE PersonelId = "+personelId+" AND Sifre='"+sifre.trim()+"' ");
			while(rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setSifre(rs.getString("Sifre"));
				contract.setYetkiId(rs.getInt("YetkiId"));
			}
			rs.close();
			statement.close();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return contract;
	}
	public PersonelContract.AccountsContract GetYetkiId(int personelId){
		
		PersonelContract innerContract= new PersonelContract();
		PersonelContract.AccountsContract contract = innerContract.new AccountsContract();
		
		List<PersonelContract.AccountsContract> listele = new ArrayList<PersonelContract.AccountsContract>();
		
		Connection baglanti = getConnection();
		try {
			Statement statement = baglanti.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM accounts WHERE PersonelId = "+personelId+"");
			while(rs.next()) {
				contract.setId(rs.getInt("Id"));
				contract.setPersonelId(rs.getInt("PersonelId"));
				contract.setYetkiId(rs.getInt("YetkiId"));
			}
			rs.close();
			statement.close();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return contract;
	}
	@Override
	public List<PersonelContract.AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(PersonelContract.AccountsContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(PersonelContract.AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE accounts SET Sifre = '" + entity.getSifre() + "'WHERE PersonelId = " + entity.getPersonelId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PersonelContract.AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}
