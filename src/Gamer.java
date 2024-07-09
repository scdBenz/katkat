public class Gamer extends  User{

    private Classification classification;
    private  boolean mute;

    public Gamer(String name, Integer id, Classification classification, boolean mute) {
        super(name, id);
        this.classification = classification;
        this.mute = mute;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    @Override
    public String toString() {
        return "Имя игрока: " + super.getName() + ". " + "ID игрока: " + super.getId() + ". " + "Класс игрока:  "
                + getClassification() + ". " + "Mute: " + isMute();
    }
}
