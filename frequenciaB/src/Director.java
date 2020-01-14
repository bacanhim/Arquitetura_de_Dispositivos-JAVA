public abstract class Director {
    private String directorName, nationality, birth;

    public Director(String name, String nationality, String birth) {
        this.directorName = name;
        this.nationality = nationality;
        this.birth = birth;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + directorName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}