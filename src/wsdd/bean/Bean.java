package wsdd.bean;

import java.io.Serializable;

//自定义类
public class Bean implements Serializable {

	private String id;
	private String name;
	//使用另外的

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
