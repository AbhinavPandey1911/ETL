import com.fasterxml.jackson.databind.JsonNode;

import java.security.cert.PolicyNode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AbilityController {
    private AbilityModel abilityModel;
    private  AbilityView abilityView;

    public AbilityController(AbilityModel abilityModel, AbilityView abilityView) {
        this.abilityModel = abilityModel;
        this.abilityView = abilityView;
    }

    public ArrayList<AbilityModel> getallAbilities(JsonNode abilityNode)
    {
        ArrayList<AbilityModel> allAbilities=new ArrayList<AbilityModel>();
        String name = null;
        String url=null;
        boolean is_hidden = true;
        int slot = 0;
        for( JsonNode it:abilityNode)
        {
            if(it.isContainerNode()){
                for(JsonNode insideIt:it)
                {
                    if(insideIt.isContainerNode())
                    {
                        name =  insideIt.get("name").asText();

                        url = insideIt.get("url").asText();
                    }

                }
                is_hidden  = it.get("is_hidden").asBoolean();
                //  System.out.println(it.get("is_hidden").asText());
                slot  = it.get("slot").asInt();
                //System.out.println(it.get("slot").asText());
            }

            AbilityModel abilityModel=new AbilityModel(name,url,is_hidden,slot);
        allAbilities.add(abilityModel);
        }

        return allAbilities;
    }

    public void updateAbilitydatabse(Connection conn, ArrayList<AbilityModel> allAbilities, PokemonModel pokemonModel) throws SQLException {
        String query="insert into abilities values(?,?,?,?,?,?)";
        PreparedStatement p5= conn.prepareStatement(query);
        p5.setInt(1,pokemonModel.getId());
        p5.setString(2, pokemonModel.getName());
        System.out.println("Updating Database");
        System.out.println("--------------------------------");
        for(AbilityModel abilityModel : allAbilities)
        {
            System.out.println(abilityModel.getName());
            p5.setString(3,abilityModel.getName());
            System.out.println(abilityModel.getUrl());
            p5.setString(4,abilityModel.getUrl());
            System.out.println(abilityModel.getSlot());
            p5.setInt(5,abilityModel.getSlot());
            System.out.println(abilityModel.isIs_hidden());
            if(abilityModel.isIs_hidden()==true)
            p5.setInt(6,1);
            else
                p5.setInt(6,0);
            p5.executeUpdate();

        }

        System.out.println("-----------------------------------");

    }


}
