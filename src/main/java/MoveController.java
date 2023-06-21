import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MoveController {
    private  MoveModel moveModel;
    private MoveView moveView;
    public  MoveController(MoveModel moveModel,MoveView moveView)
    {
        this.moveModel=moveModel;
        this.moveView=moveView;
    }

    public ArrayList<MoveModel> setmoveModel(JsonNode movesNode)
    {
       ArrayList<MoveModel> moveList=(this.moveView.getMoves(movesNode));
       return moveList;
    }
    public void showmoveModel(ArrayList<MoveModel> moveList)
    {
        this.moveView.showMoves(moveList);
    }
    public void updateMoveDatabase(Connection conn, ArrayList<MoveModel> moveList, PokemonModel pokemonModel) throws SQLException {

        String query="insert into moves values(?,?,?,?,?,?,?,?,?)";
        System.out.println("--------------------------");
        System.out.println("Updating Move Database");
        PreparedStatement p3= conn.prepareStatement(query);
        for(MoveModel it: moveList)
        {
            p3.setInt(1,pokemonModel.getId());
            p3.setString(2,pokemonModel.getName());
            p3.setString(4,it.getName());
            p3.setString(5,it.getUrl());
            p3.setInt(6,it.getAccuracy());
            p3.setInt(3,it.getId());
            p3.setInt(7,it.getPower());
            p3.setInt(8,it.getPp());
            p3.setString(9,it.getType());
            p3.executeUpdate();
            System.out.println(it.getName());
            System.out.println(it.getUrl());
            System.out.println(it.getAccuracy());
            System.out.println(it.getId());
            System.out.println(it.getPower());
            System.out.println(it.getPp());
            System.out.println(it.getType());

        }
        System.out.println("---------------------");

    }

}
