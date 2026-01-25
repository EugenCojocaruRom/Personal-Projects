//Define the 'priority' enum - for task priority - public, so it can be accessed from Main
public enum Priority {
    LOW(3), MEDIUM(2), HIGH(1);

    //Declare variable 'level' of type int and set it as final
    private final int level;

    //Add constructor to initialize the 'level' variable and be able to access it
    Priority(int level) {
        this.level = level;
    }

    //Add getter for 'level'
    public int getLevel() {
        return level;
    }
}
