package article.model;

public class Writer {
	//글쓴이 아이디와 이름.
	private String id;
	private String name;
	public Writer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
