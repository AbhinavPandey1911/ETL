import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;

public class TypesView {
    public void showTypes (TypesModel typesModel)
    {
        System.out.println(typesModel.getPokemonModel().getName());
        System.out.println(typesModel.getPokemonModel().getId());
        System.out.println(typesModel.getPokemonModel().getHp());
        System.out.println(typesModel.getType());
    }
    public TypesModel getTypes(JsonNode typesNode, PokemonModel pokemonModel)
    {   ArrayList<String> allTypes=new ArrayList<String>();
        for (JsonNode typeNode : typesNode) {
            for(JsonNode it:typeNode)
            {
                if(it.isContainerNode()){
                    System.out.println(it.get("name"));
                    System.out.println(it.get("url"));
                    String type= it.get("name").asText();
                  allTypes.add(type);

                }
            }

        }
        TypesModel typesModel=new TypesModel(pokemonModel,allTypes);
        return typesModel;
    }

}
