package It.Project.Model;

import java.util.Objects;

public class ToWhom {

    int id;
    String who;

    public ToWhom() {
    }

    public ToWhom(int id, String who) {
        this.id = id;
        this.who = who;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToWhom toWhom = (ToWhom) o;
        return id == toWhom.id &&
                Objects.equals(who, toWhom.who);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, who);
    }
}


