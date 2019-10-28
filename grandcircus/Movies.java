package co.grandcircus;

public class Movies {

	
	private String title;
	private String category;
	
	
	public Movies() {}; 
	
	
	public Movies(String title, String category) { 
		setTitle(title);
		setCategory(category);
	}
	
	
	public void setTitle(String title) { 
		this.title = title;
	}
	
	
	public void setCategory(String category) { 
		this.category = category;
	}
	
	
	public String getTitle() {  
		return title;
	}
	
	
	public String getCategory() { 
		return category;
	}
	
}
