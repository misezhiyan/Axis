package wsdd.complex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Address implements Serializable {

	// 需要向ws传递的对象<除了本类支持序列化, 所有属性都要支持序列化>

	private String address;
	private String city;
	private String country;

	private String[] array;
	private List<Integer> list;
	private boolean isExist;

	// 内部类属性
	private innerClass innerclass;

	public static class innerClass implements Serializable {
		private String innername;

		public String getInnername() {
			return innername;
		}

		public void setInnername(String innername) {
			this.innername = innername;
		}

	}

	public Address() {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		innerclass = new innerClass();
		innerclass.setInnername("测试内部类");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public innerClass getInnerclass() {
		return innerclass;
	}

	public void setInnerclass(innerClass innerclass) {
		this.innerclass = innerclass;
	}

}
