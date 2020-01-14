public class MiniSeries extends TVShow {
    private int numberOfEpisodes;

    public MiniSeries(String directorName, String nationality, String birth, String showName, double rating, double duration, int year, int numberOfEpisodes) {
        super(directorName, nationality, birth, showName, rating, duration, year);
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
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
    public void setRating(double rating) {
        super.setRating(rating);
    }


    @Override
    public void setDuration(double duration) {
        super.setDuration(duration);
    }



    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "A MiniSerie " + getShowName() + " realizado por" + getDirectorName() + " e posteriormente lançado em "+getYear()+" obteve "+getRating() +
                " pontos tendo "+getDuration()+" de espetaculo e "+getNumberOfEpisodes()+" episodios";
    }
}

