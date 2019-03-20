package wsdd.complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//���ݸ��Ӷ���
public class ComplexObjService {

	// ���Ʋ�ͬ���񷽷�
	public List<Address> getAddressList() {

		System.out.println("�����˷���");

		List<Address> addressList = new ArrayList<Address>();
		try {

			Address address = new Address();
			address.setCountry("�й�");
			address.setCity("�ൺ");
			address.setAddress("������");
			address.setExist(true);
			address.setArray(new String[] { "a", "b" });
			String innerName = address.getInnerclass().getInnername() + ":list";
			address.getInnerclass().setInnername(innerName);

			addressList.add(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(addressList.size());
		System.out.println("�뿪����");

		return addressList;
	}

	// ���Ʋ�ͬ���񷽷�
	public Map<Integer, Address> getAddressMap() {

		Map<Integer, Address> addressMap = new HashMap<Integer, Address>();

		Address address = new Address();
		address.setCountry("�й�");
		address.setCity("�ൺ");
		address.setAddress("������");
		address.setExist(true);
		address.setArray(new String[] { "a", "b" });
		String innerName = address.getInnerclass().getInnername() + ":map1";
		address.getInnerclass().setInnername(innerName);

		Address address2 = new Address();
		address2.setCountry("�й�");
		address2.setCity("�ൺ");
		address2.setAddress("�б���");
		address2.setExist(true);
		address2.setArray(new String[] { "c", "d" });
		innerName = address2.getInnerclass().getInnername() + ":map2";
		address2.getInnerclass().setInnername(innerName);

		addressMap.put(1, address);
		addressMap.put(2, address2);

		return addressMap;
	}
}
