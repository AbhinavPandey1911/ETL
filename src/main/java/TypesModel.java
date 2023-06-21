import java.util.ArrayList;

public class TypesModel {
    private  PokemonModel pokemonModel;
    private ArrayList<String> type;

    public TypesModel(PokemonModel pokemonModel, ArrayList<String> type) {
        this.pokemonModel = pokemonModel;
        this.type = type;
    }
    public  TypesModel(){
        this.pokemonModel=null;
        this.type=null;
    }

    public PokemonModel getPokemonModel() {
        return pokemonModel;
    }

    public void setPokemonModel(PokemonModel pokemonModel) {
        this.pokemonModel = pokemonModel;
    }

    public ArrayList<String>  getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }
}
