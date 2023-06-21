import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PokemonController {
    private PokemonModel pokemonModel;
    private  PokemonView pokemonView;

    public PokemonController(PokemonModel pokemonModel,PokemonView pokemonView){
        this.pokemonModel=pokemonModel;
        this.pokemonView=pokemonView;
    }
    public PokemonModel setmodelcontroller(JsonNode rootNode)
    {
        this.pokemonModel=this.pokemonView.getPokemon(rootNode);
        return pokemonModel;

    }
    public  void viewmodelController(PokemonModel pokemonModel)
    {
        this.pokemonView.pokemondetails(pokemonModel);
    }
    public  void updatePokemonDetails(){
        this.pokemonView.pokemondetails(this.pokemonModel);
    }
    public void updatePokemonDatabase(Connection conn, String urlpokemon) throws SQLException {
        String query="insert into pokemon values(?,?,?,?,?)";
        PreparedStatement p1= conn.prepareStatement(query);
        p1.setInt(1,this.pokemonModel.getId());
        p1.setString(2,this.pokemonModel.getName());
        p1.setInt(3,this.pokemonModel.getWeight());
        p1.setInt(4,this.pokemonModel.getHeight());
        p1.setString(5,urlpokemon);
        p1.executeUpdate();
        System.out.println("Database is updated with");
        System.out.println(this.pokemonModel.getName());
        System.out.println(this.pokemonModel.getId());
        System.out.println(this.pokemonModel.getWeight());
        System.out.println(this.pokemonModel.getHeight());
        System.out.println(this.pokemonModel.getHp());
        System.out.println("-----------------------------------");

    }


}
