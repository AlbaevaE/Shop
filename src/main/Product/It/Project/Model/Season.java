package It.Project.Model;

public class Season {
    int id;
    String season;

    public Season() {
    }

    public Season(int id, String season) {
        this.id = id;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
