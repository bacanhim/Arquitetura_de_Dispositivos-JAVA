public class Documentary extends TVShow {
    private String category;
    private int noOfSeries;

    public Documentary(String directorName, String nationality, String birth, String showName, double rating, double duration, int year, String category, int noOfSeries) {
        super(directorName, nationality, birth, showName, rating, duration, year);
        this.category = category;
        this.noOfSeries = noOfSeries;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfSeries() {
        return noOfSeries;
    }

    public void setNoOfSeries(int noOfSeries) {
        this.noOfSeries = noOfSeries;
    }

    @Override
    public String getBirth() {
        return super.getBirth();
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public String getDirectorName() {
        return super.getDirectorName();
    }

    @Override
    public double getDuration() {
        return super.getDuration();
    }

    @Override
    public double getRating() {
        return super.getRating();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public String getShowName() {
        return super.getShowName();
    }

    @Override
    public void setDirectorName(String directorName) {
        super.setDirectorName(directorName);
    }

    @Override
    public void setBirth(String birth) {
        super.setBirth(birth);
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public void setShowName(String showName) {
        super.setShowName(showName);
    }

    @Override
    public void setDuration(double duration) {
        super.setDuration(duration);
    }

    @Override
    public void setRating(double rating) {
        super.setRating(rating);
    }

    @Override
    public String toString() {
        return "O Documentario " + getShowName() + " realizado por" + getDirectorName() + " e posteriormente lançado em "+getYear()+" obteve "+getRating() +
                " pontos tendo "+getDuration()+" de espetaculo.";
    }
}
