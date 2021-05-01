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
import tr.edu.javaodev.types.UyeContract;

public class UyeDAL extends ObjectHelper implements IDALInterfacesExtends<UyeContract> , IDALInterfacesUD<UyeContract> {

	@Override
	public void Insert(UyeContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO uye (AdiSoyadi,OgrNo,Fakulte,Bolum,Sinif) VALUES('"+entity.getAdiSoyadi()+"',"+entity.getOgrno()+","
					+ "'"+entity.getFakulte()+"','"+entity.getBolum()+"',"+entity.getSinif()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<UyeContract> GetAll() {
		List<UyeContract> datacontract = new ArrayList<UyeContract>();
		Connection connection = getConnection();
		UyeContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM uye");
			while (resultSet.next()) {
				contract = new UyeContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setOgrno(resultSet.getString("OgrNo"));
				contract.setFakulte(resultSet.getString("Fakulte"));
				contract.setBolum(resultSet.getString("Bolum"));
				contract.setSinif(resultSet.getInt("Sinif"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(UyeContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM uye WHERE Id = "+entity.getId()+"");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void Update(UyeContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE uye SET AdiSoyadi = '" + entity.getAdiSoyadi() + "',OgrNo = '"
                    + entity.getOgrno() + "' ,Fakulte= '" + entity.getFakulte() + "',Bolum='" + entity.getBolum()
                    + "',Sinif = '"+entity.getSinif()+"' WHERE Id = " + entity.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UyeContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}





}
