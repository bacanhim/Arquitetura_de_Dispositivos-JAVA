public class TVShow extends Director {
    private String showName;
    private double rating;
    private double duration;
    private int year;

    public TVShow(String directorName, String nationality, String birth, String showName, double rating, double duration, int year) {
        super(directorName, nationality, birth);
        this.showName = showName;
        this.rating = rating;
        this.duration = duration;
        this.year = year;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getDirectorName() {
        return super.getDirectorName();
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public String getBirth() {
        return super.getBirth();
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }

    @Override
    public void setBirth(String birth) {
        super.setBirth(birth);
    }

    @Override
    public void setDirectorName(String directorName) {
        super.setDirectorName(directorName);
    }

    @Override
    public String toString() {
        return "O programa de tv " + getShowName() + " lancado no ano " + getYear() + " obteve " + getRating() + " cordenada pelo realizador " + getDirectorName() + " com a duracao de " + getDuration();
    }
}
