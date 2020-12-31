package article.service;

import java.util.Map;

import article.model.Writer;

public class WriteRequest {
	private Writer writer;
	private String title;
	private String content;


	public WriteRequest(Writer writer, String title, String content ) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		

	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	

	public void validate(Map<String, Boolean> errors)
	// errors 파라미터
	{
		if (title == null || title.trim().isEmpty())
		// 만약 title이 null이거나 ,여백없이 비었다면
		{
			errors.put("title", true);
			// errors에 title을 저장.
		}
	}

	
}
