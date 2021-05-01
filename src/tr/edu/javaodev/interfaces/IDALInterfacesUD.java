package tr.edu.javaodev.interfaces;

public interface IDALInterfacesUD<T> {

	void Delete(T entity);

	void Update(T entity);
}
