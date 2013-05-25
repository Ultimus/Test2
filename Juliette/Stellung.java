public class Stellung{

	int id;
	String picture,text;
	public Stellung(int id, String picture, String text){
		this.id = id;
		this. picture = picture;
		this. text= text;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return this.id;
	}

	public void setPicture (String p){
		this.picture = p;
	}

	public String getPicture(){
		return this.picture;
	}
		
	public void setText(String t){
		this.text = t;
	}

	public String getText(){
		return this.text;
	}

	


}
