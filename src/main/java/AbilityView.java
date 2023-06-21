import com.fasterxml.jackson.databind.JsonNode;

public class AbilityView {

    public  void showAbility(AbilityModel abilityModel)
    {
        System.out.println(abilityModel.getName());
        System.out.println(abilityModel.getUrl());
        System.out.println(abilityModel.getSlot());
        System.out.println(abilityModel.isIs_hidden());
    }
}
