public class PokemonModel {
    private String name;
    private int hp;
    private int height;
    private int weight;
    private int id;

    public PokemonModel(int id,int height,int weight,int hp,String name){
        this.id=id;
        this.height=height;
        this.weight=weight;
        this.hp=hp;
        this.name=name;
    }
    public  PokemonModel(){

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getHp() {

        return hp;
    }

    public void setHp(int hp) {

        this.hp = hp;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
