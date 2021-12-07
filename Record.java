import java.util.*;
/**
 * Record. Esta clase permite crear un record, el cual contiene el nombre del jugador y su puntuación.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Record{
    private String namePlayer;
    private int scorePlayer;

    public Record(String name, int score) {
        namePlayer = name;
        scorePlayer = score;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String name) {
        namePlayer = name;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int score) {
        scorePlayer = score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "namePlayer='" + namePlayer + '\'' +
                ", scorePlayer=" + scorePlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return scorePlayer == record.scorePlayer && Objects.equals(namePlayer, record.namePlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePlayer, scorePlayer);
    }
}
