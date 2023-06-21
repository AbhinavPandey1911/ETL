public class AbilityModel {
   private String name;
   private  String url;
   private boolean is_hidden;
   private int slot;

    public AbilityModel(String name, String url, boolean is_hidden, int slot) {
        this.name = name;
        this.url = url;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public AbilityModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
