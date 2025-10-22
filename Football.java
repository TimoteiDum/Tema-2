package ro.emanuel.tema2.pojo;

public class Football {
    private int id;
    private String name;
    private String team;
    private String number;
    private String age;

    public Football(int id, String name, String team, String number, String age) {
        super();
        this.id = id;
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

    public Football(String name, String team, String number, String age) {
        super();
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

     
    public Football() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
