package wsdd.complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//传递复杂对象
public class ComplexObjService {

	// 定制不同服务方法
	public List<Address> getAddressList() {

		System.out.println("进入了方法");

		List<Address> addressList = new ArrayList<Address>();
		try {

			Address address = new Address();
			address.setCountry("中国");
			address.setCity("青岛");
			address.setAddress("市南区");
			address.setExist(true);
			address.setArray(new String[] { "a", "b" });
			String innerName = address.getInnerclass().getInnername() + ":list";
			address.getInnerclass().setInnername(innerName);

			addressList.add(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(addressList.size());
		System.out.println("离开方法");

		return addressList;
	}

	// 定制不同服务方法
	public Map<Integer, Address> getAddressMap() {

		Map<Integer, Address> addressMap = new HashMap<Integer, Address>();

		Address address = new Address();
		address.setCountry("中国");
		address.setCity("青岛");
		address.setAddress("市南区");
		address.setExist(true);
		address.setArray(new String[] { "a", "b" });
		String innerName = address.getInnerclass().getInnername() + ":map1";
		address.getInnerclass().setInnername(innerName);

		Address address2 = new Address();
		address2.setCountry("中国");
		address2.setCity("青岛");
		address2.setAddress("市北区");
		address2.setExist(true);
		address2.setArray(new String[] { "c", "d" });
		innerName = address2.getInnerclass().getInnername() + ":map2";
		address2.getInnerclass().setInnername(innerName);

		addressMap.put(1, address);
		addressMap.put(2, address2);

		return addressMap;
	}
}
