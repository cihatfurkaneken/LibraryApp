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
import tr.edu.javaodev.types.Yetkiler;

public class YetkilerDAL extends ObjectHelper implements IDALInterfacesExtends<Yetkiler> , IDALInterfacesUD<Yetkiler> {

	@Override
	public void Insert(Yetkiler entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO yetkiler (Adi) VALUES('" + entity.getAdi()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Yetkiler> GetAll() {
		List<Yetkiler> datacontract = new ArrayList<Yetkiler>();
		Connection connection = getConnection();
		Yetkiler contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM yetkiler");
			while (resultSet.next()) {
				contract = new Yetkiler();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(Yetkiler entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Yetkiler entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Yetkiler> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}
