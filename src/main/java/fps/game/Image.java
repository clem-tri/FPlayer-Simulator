package fps.game;


public class Image {
    public static final String PATH_TO_IMG = System.getProperty("user.dir")+"\\resources\\img\\";
    private String image;

    public Image(String image){
        this.image = image;
    }

    public String getImage(){
        return PATH_TO_IMG+this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
