package tr.edu.javaodev.core;

class OuterClass {
	String userName = "root";
	String password = "";
	  class InnerClass {

			String url = "jdbc:mysql://localhost:3306/kutuphaneotomasyon";
	  }
}
public class CoreFields {	

	OuterClass myQuter = new OuterClass();
	OuterClass.InnerClass myInner = myQuter.new InnerClass();
	public String getUserName() {
		return myQuter.userName;
	}

	public String getPassword() {
		return myQuter.password;
	}

	public String getUrl() {
		return myInner.url;
	}

}
