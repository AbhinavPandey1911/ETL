import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypesController {
    private  TypesModel typesModel;
    private  TypesView typesView;

    public TypesController(TypesModel typesModel, TypesView typesView) {
        this.typesModel = typesModel;
        this.typesView = typesView;
    }

    public TypesModel extracttypesModel(JsonNode typesNode, PokemonModel pokemonModel)
    {
       this.typesModel= this.typesView.getTypes(typesNode,pokemonModel);
       return this.typesModel;

    }

    public void updateDatabase(Connection conn, TypesModel typesModel) throws SQLException {
        String query="insert into types values(?,?,?)";
        PreparedStatement p4= conn.prepareStatement(query);
        System.out.println("Updating Types Database");
        System.out.println("-----------------------------------");
        ArrayList<String> alltypes=typesModel.getType();
        PokemonModel pokemonModel= typesModel.getPokemonModel();
        System.out.println(pokemonModel.getName());
        System.out.println(pokemonModel.getId());
        p4.setInt(1, pokemonModel.getId());
        p4.setString(2,pokemonModel.getName());
        for(String it: alltypes)
        {
            p4.setString(3,it);
            p4.executeUpdate();
            System.out.println(it);
        }

        System.out.println("-----------------------------------");
    }



}
