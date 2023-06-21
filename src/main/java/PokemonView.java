import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokemonView {

    public PokemonModel getPokemon(JsonNode rootNode){

        try {

            String name = rootNode.get("name").asText();
            int height=rootNode.get("height").asInt();
            int weight=rootNode.get("weight").asInt();
            int id=rootNode.get("id").asInt();
           /* System.out.println(id);
            System.out.println(height);
            System.out.println(weight);
            System.out.println(name);
            */
            PokemonModel pokemon=new PokemonModel(id,height,weight,0,name);

            return pokemon;
        }
        catch (Exception e){
            System.out.println(e);
           return null;
        }

    }
    public void pokemondetails(PokemonModel pokemon){
        System.out.println(pokemon.getId());
        System.out.println(pokemon.getHeight());
        System.out.println(pokemon.getWeight());
        System.out.println(pokemon.getName());
    }



}
