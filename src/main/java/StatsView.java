import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.ArrayList;

public class StatsView {


    public StatsModel getStats(JsonNode rootNode){
        ArrayList<Integer> al=new ArrayList<Integer>();
        StatsModel statsModel=new StatsModel();
        for(JsonNode it:rootNode)
        {
            al.add(it.get("base_stat").asInt());

        }
       if(al.size()>0)
       {
           statsModel.setHp(al.get(0));
       }
       if(al.size()>1)
       {
           statsModel.setAttack(al.get(1));
       }
       if(al.size()>2)
       {
           statsModel.setDefence(al.get(2));
       }
       if(al.size()>3)
       {
           statsModel.setSpecial_attack(al.get(3));
       }
       if(al.size()>4)
       {
           statsModel.setSpecial_defence(al.get(4));
       }
       if(al.size()>5)
       {
           statsModel.setSpeed(al.get(5));
       }
       return statsModel;


    }
    public  void statDetails(StatsModel statsModel)
    {
        System.out.println("-------------------------------------");
        System.out.println("Stats Details");
        System.out.println(statsModel.getHp());
        System.out.println(statsModel.getAttack());
        System.out.println(statsModel.getDefence());
        System.out.println(statsModel.getSpecial_attack());
        System.out.println(statsModel.getSpecial_defence());
        System.out.println(statsModel.getSpeed());
        System.out.println("------------------------------------");

    }



}
