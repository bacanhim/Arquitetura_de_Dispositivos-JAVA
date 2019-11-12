package Menu;

public class Menu {
    public enum Entries {
        CreateArmy, InspectArmy, Play, Quit;
    }

    @Override
    public String toString() {
        return "Create Army: "+Entries.valueOf("CreateArmy").ordinal()+" \n Inspect Army: "+Entries.valueOf("InspectArmy").ordinal()+ " \n Play: "+Entries.valueOf("Play").ordinal()+" \n Quit: "+Entries.valueOf("Quit").ordinal();
    }
}
