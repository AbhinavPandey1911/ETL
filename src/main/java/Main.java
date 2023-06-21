import java.io.IOException;
import java.sql.Connection;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        HttpClient clientroot = HttpClient.newHttpClient();
        URI uriiroot = URI.create("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0");
        try {
            HttpRequest requestAllPokemon = HttpRequest.newBuilder().uri(uriiroot).GET().build();
            HttpResponse<String> responseStringAllPokemon = clientroot.send(requestAllPokemon, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapperroot = new ObjectMapper();
            JsonNode rootNodeAllPokemon = objectMapperroot.readTree(responseStringAllPokemon.body());
            JsonNode resultSet = rootNodeAllPokemon.get("results");
           for (JsonNode r : resultSet) {
                if(!r.isContainerNode())
                    continue;
                String urlPokemon=r.get("url").asText();
                String namePokemon=r.get("name").asText();
                System.out.println(urlPokemon);
                System.out.println(namePokemon);
                HttpClient client = HttpClient.newHttpClient();
                URI urii = URI.create(urlPokemon);
                try {

                    HttpRequest requestPokemon = HttpRequest.newBuilder().uri(urii).GET().build();
                    HttpResponse<String> responseStringPokemon = client.send(requestPokemon, HttpResponse.BodyHandlers.ofString());
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode rootNodePokemon = objectMapper.readTree(responseStringPokemon.body());

                    //Individual pokemon
            /*        PokemonModel pokemonModel = new PokemonModel();
                    PokemonView pokemonView = new PokemonView();
                    PokemonController pokemonController = new PokemonController(pokemonModel, pokemonView);
                    pokemonModel = pokemonController.setmodelcontroller(rootNodePokemon);
                    pokemonController.updatePokemonDatabase();


             */
                    //Stats
              /*      JsonNode statsNode = rootNodePokemon.get("stats");
                    StatsModel statsModel = new StatsModel();
                    StatsView statsView = new StatsView();
                    StatsController statsController = new StatsController(statsModel, statsView);
                    statsModel = statsController.setStatsModel(statsNode, statsModel);
                    statsController.updateStatsDatabase();

                    */

                    //Moves
                /*    JsonNode movesNode = rootNodePokemon.get("moves");
                    MoveModel moveModel = new MoveModel();
                    MoveView moveView = new MoveView();
                    MoveController moveController = new MoveController(moveModel, moveView);
                    ArrayList<MoveModel> moves;
                    moves = moveController.setmoveModel(movesNode);
                    moveController.updateMoveDatabase(moves);
                */

                    //Types
                /*    JsonNode typesNode = rootNodePokemon.get("types");
                    TypesModel typesModel = new TypesModel();
                    TypesView typesView = new TypesView();
                    TypesController typesController = new TypesController(typesModel, typesView);
                   typesModel = typesController.extracttypesModel(typesNode, pokemonModel);
                   typesController.updateDatabase(typesModel); */


                    //Ability
               /*     JsonNode abilityNode = rootNodePokemon.get("abilities");
                    AbilityModel abilityModel = new AbilityModel();
                    AbilityView abilityView = new AbilityView();
                    AbilityController abilityController = new AbilityController(abilityModel, abilityView);
                    ArrayList<AbilityModel> allAbilities = new ArrayList<AbilityModel>();
                    allAbilities = abilityController.getallAbilities(abilityNode);
                   abilityController.updateAbilitydatabse(allAbilities);
*/
                    PokemonModel pokemonModel = new PokemonModel();
                    PokemonView pokemonView = new PokemonView();
                    PokemonController pokemonController = new PokemonController(pokemonModel, pokemonView);
                    pokemonModel = pokemonController.setmodelcontroller(rootNodePokemon);

                    PokemonModel finalPokemonModel = pokemonModel;
                    Thread thread1 = new Thread(() -> {

                        Connection conn=JdbcConnection.getJdbcConnection();
                        try {
                            pokemonController.updatePokemonDatabase(conn,urlPokemon);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });

                    Thread thread2 = new Thread(() -> {
                        JsonNode statsNode = rootNodePokemon.get("stats");
                        StatsModel statsModel = new StatsModel();
                        StatsView statsView = new StatsView();
                        StatsController statsController = new StatsController(statsModel, statsView);
                        statsModel = statsController.setStatsModel(statsNode, statsModel);
                        Connection conn=JdbcConnection.getJdbcConnection();
                        try {
                            statsController.updateStatsDatabase(conn, finalPokemonModel.getId(), finalPokemonModel.getName());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });

                    Thread thread3 = new Thread(() -> {
                        JsonNode movesNode = rootNodePokemon.get("moves");
                        MoveModel moveModel = new MoveModel();
                        MoveView moveView = new MoveView();
                        MoveController moveController = new MoveController(moveModel, moveView);
                        ArrayList<MoveModel> moves;
                        moves = moveController.setmoveModel(movesNode);
                        Connection conn= JdbcConnection.getJdbcConnection();
                        try {
                            moveController.updateMoveDatabase(conn,moves,finalPokemonModel);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });

                    Thread thread4 = new Thread(() -> {
                        JsonNode typesNode = rootNodePokemon.get("types");
                        TypesModel typesModel = new TypesModel();
                        TypesView typesView = new TypesView();
                        TypesController typesController = new TypesController(typesModel, typesView);
                        typesModel = typesController.extracttypesModel(typesNode, finalPokemonModel);
                        Connection conn=JdbcConnection.getJdbcConnection();
                        try {
                            typesController.updateDatabase(conn,typesModel);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }


                    });

                  //  ArrayList<AbilityModel> finalAllAbilities = allAbilities;
                    Thread thread5 = new Thread(() -> {
                        JsonNode abilityNode = rootNodePokemon.get("abilities");
                        AbilityModel abilityModel = new AbilityModel();
                        AbilityView abilityView = new AbilityView();
                        AbilityController abilityController = new AbilityController(abilityModel, abilityView);
                        ArrayList<AbilityModel> allAbilities = new ArrayList<AbilityModel>();
                        allAbilities = abilityController.getallAbilities(abilityNode);
                        Connection conn=JdbcConnection.getJdbcConnection();
                        try {
                            abilityController.updateAbilitydatabse(conn,allAbilities,finalPokemonModel);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    });


                    long startTime = System.nanoTime();

                    thread1.start();
                   thread2.start();
                    thread3.start();
                    thread4.start();
                    thread5.start();
                    thread1.join();
                   thread2.join();
                    thread3.join();
                   thread4.join();
                    thread5.join();
                    long endTime = System.nanoTime();
                    long runtimeInNanos = endTime - startTime;
                   double runtimeInSeconds = (double) runtimeInNanos / 1_000_000_000.0;

                    System.out.println("Runtime: " + runtimeInSeconds + " seconds");


                }

        catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("Hii");


            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    }
