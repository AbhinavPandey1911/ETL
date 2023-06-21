import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.spec.ECField;
import java.util.ArrayList;

public class MoveView {


    public ArrayList<MoveModel> getMoves(JsonNode movesNode)
    {
        ArrayList<MoveModel> allmoves=new ArrayList<MoveModel>();
        HttpClient client= HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        for(JsonNode it:movesNode)
        {
            for(JsonNode git: it) {
                try {
                    //System.out.println(git.get("name"));
                    String name = git.get("name").asText();

                    //System.out.println(git.get("url").asText());
                    String url = git.get("url").asText();
                    String turii = git.get("url").asText();
                    HttpRequest requestMoves = HttpRequest.newBuilder().uri(URI.create(turii)).GET().build();
                    HttpResponse<String> responseStringMoves = client.send(requestMoves, HttpResponse.BodyHandlers.ofString());
                    // System.out.println(responseStringMoves.body());

                    JsonNode rootNodeMoves = objectMapper.readTree(responseStringMoves.body());
                   // System.out.println(rootNodeMoves.get("id").asText());
                    int id = rootNodeMoves.get("id").asInt();

                    //System.out.println(rootNodeMoves.get("accuracy").asText());
                    int accuracy = rootNodeMoves.get("accuracy").asInt();


                   // System.out.println(rootNodeMoves.get("power").asText());
                    int power = rootNodeMoves.get("power").asInt();


                   // System.out.println(rootNodeMoves.get("pp").asText());
                    int pp = rootNodeMoves.get("pp").asInt();


                  //  System.out.println(rootNodeMoves.get("type").get("name").asText());
                    String type = rootNodeMoves.get("type").get("name").asText();

                    MoveModel moveModel = new MoveModel(name, url, accuracy, id, power, pp, type);

                    allmoves.add(moveModel);
                    break;
                }
                catch (Exception e)
                {
                    System.out.println(e);
                    return null;
                }
            }

        }
    /*    for(MoveModel it:allmoves)
            System.out.println(it.getName()); */
        return allmoves;

    }
    public void showMoves(ArrayList<MoveModel> moveList)
    {
        System.out.println("--------------------------------");
        System.out.println("Move Details");
        for(MoveModel it: moveList)
        {
            System.out.println(it.getName());
            System.out.println(it.getUrl());
            System.out.println(it.getAccuracy());
            System.out.println(it.getId());
            System.out.println(it.getPower());
            System.out.println(it.getPp());
            System.out.println(it.getType());

        }
        System.out.println("--------------------------------");

    }



}
