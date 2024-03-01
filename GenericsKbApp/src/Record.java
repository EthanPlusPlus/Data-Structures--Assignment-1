import java.util.Objects;

public class Record {

    String term, stmnt;
    float confScore;

    public Record(String term, String stmnt, float confScore) {

        this.term = term;
        this.stmnt = stmnt;
        this.confScore = confScore;

    }

    public String getTerm() {
        return term;
    }

    public String getStmnt() {
        return stmnt;
    }

    public float getConfScore() {
        return confScore;
    }

    public int compareTo(Record r) {

        return 21;

    }

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;
        return Float.compare(confScore, record.confScore) == 0 && Objects.equals(term, record.term) && Objects.equals(stmnt, record.stmnt);

    }

    public String toString() {

        return term + "\t" + stmnt + "\t" + confScore;

    }

}
