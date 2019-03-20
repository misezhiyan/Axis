package wsdd.bean;

//自定义类
public class BeanService {

	public Bean getBean(Bean bean) {

		Bean newBean = new Bean();

		if ("1".equals(bean.getId())) {
			newBean.setName("是1");
		} else {
			newBean.setName("不是1");
		}

		return newBean;
	}

}
