import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatsController {
    private  StatsModel statsModel;
    private  StatsView statsView;
    public StatsController(StatsModel statsModel, StatsView statsView) {
        this.statsModel = statsModel;
        this.statsView = statsView;
    }

    public StatsModel setStatsModel(JsonNode rootNode,StatsModel statsModel) {
        this.statsModel = this.statsView.getStats(rootNode);
        return this.statsModel;
    }

    public void statsViewController(StatsModel statsModel) {
        this.statsView.statDetails(statsModel);
    }
    public void updateStatDetails()
    {
        this.statsView.statDetails(this.statsModel);
    }
    public void updateStatsDatabase(Connection conn, int id,String name) throws SQLException {

        String query="insert into stats values (?,?,?,?,?,?,?,?)";
        PreparedStatement p2=conn.prepareStatement(query);
        p2.setInt(1,id);
        p2.setString(2,name);
        p2.setInt(3,this.statsModel.getHp());
        p2.setInt(4,this.statsModel.getAttack());
        p2.setInt(5,this.statsModel.getDefence());
        p2.setInt(6,this.statsModel.getSpecial_attack());
        p2.setInt(7,this.statsModel.getSpecial_defence());
        p2.setInt(8,this.statsModel.getSpeed());
        p2.executeUpdate();

        System.out.println("------------------------------------");
        System.out.println("Updating Stats database");
        System.out.println(this.statsModel.getHp());
        System.out.println(this.statsModel.getAttack());
        System.out.println(this.statsModel.getDefence());
        System.out.println(this.statsModel.getSpecial_attack());
        System.out.println(this.statsModel.getSpecial_defence());
        System.out.println(this.statsModel.getSpeed());
        System.out.println("-------------------------------------");


    }
}
