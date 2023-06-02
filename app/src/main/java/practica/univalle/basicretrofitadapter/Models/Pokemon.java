package practica.univalle.basicretrofitadapter.Models;

public class Pokemon {
    public int id;
    public int weight;
    public String name;
    public String url;
    public String base_experience;
    public String hp;
    public String ataque;
    public String ataqueEspecial;
    public String defensa;
    public Stats[] stats;

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }
    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }
    public Pokemon(int id, int weight, String name, String url, String base_experience) {
        this.id = id;
        this.weight = weight;
        this.name = name;
        this.url = url;
        this.base_experience = "Exp: "+base_experience;

    }

    public Stats[] getStats() {
        return stats;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", base_experience='" + base_experience + '\'' +
                ", ataque='" + ataque + '\'' +
                ", ataqueEspecial='" + ataqueEspecial + '\'' +
                ", defensa='" + defensa + '\'' +
                '}';
    }
}

