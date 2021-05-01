package tr.edu.javaodev.interfaces;

import java.util.List;

public interface IDALInterfacesExtends<T> extends  IDALInterfacesALS<T>{
	List<T> GetById(int id);
}
