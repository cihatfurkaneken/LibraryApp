package tr.edu.javaodev.interfaces;

import java.util.List;

public interface IDALInterfacesALS<T> {

	void Insert(T entity);

	List<T> GetAll();


}
