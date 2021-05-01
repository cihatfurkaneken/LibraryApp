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

public class PersonelDAL extends ObjectHelper implements IDALInterfacesExtends<PersonelContract> , IDALInterfacesUD<PersonelContract> {

	@Override
	public void Insert(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO personel (AdiSoyadi,Email) "
					+ "VALUES('" 
					+ entity.getAdiSoyadi() + "','"
					+ entity.getEmail() + "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PersonelContract> GetAll() {
		List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
		Connection connection = getConnection();
		PersonelContract contract ;
		
		PersonelContract innerGo = new PersonelContract();
		PersonelContract.PersonelInnerContract personelInner = innerGo.new PersonelInnerContract();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM personel");
			while (resultSet.next()) {
				contract = new PersonelContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setEmail(resultSet.getString("Email"));
				personelInner.setYetkiId(resultSet.getInt("yetkiId"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(PersonelContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM personel WHERE Id = "+entity.getId()+"");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void Update(PersonelContract entity) {
		
		//PersonelContract.PersonelInnerContract innerEntity = entityInner.new PersonelInnerContract();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE personel SET AdiSoyadi = '" + entity.getAdiSoyadi() + " WHERE Id = " + entity.getId() + "");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Update(PersonelContract.PersonelInnerContract entityInner,PersonelContract entityId) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//statement.executeUpdate("UPDATE personel SET yetkiId = '" + entityInner.getYetkiId() + " WHERE Id = " + entityId.getId() + "");
			statement.executeUpdate("UPDATE personel SET AdiSoyadi = '" + entityId.getAdiSoyadi() + "',yetkiId = "
					+ entityInner.getYetkiId() + " WHERE Id = " + entityId.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
