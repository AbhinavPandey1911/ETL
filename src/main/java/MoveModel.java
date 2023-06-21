public class MoveModel {
    private String name;
    private  String url;
    private int accuracy;
    private int id;
    private int power;
    private int pp;
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MoveModel(String name, String url, int accuracy, int id, int power, int pp, String type) {
        this.name = name;
        this.url = url;
        this.accuracy = accuracy;
        this.id = id;
        this.power = power;
        this.pp = pp;
        this.type = type;
    }
    public  MoveModel()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
