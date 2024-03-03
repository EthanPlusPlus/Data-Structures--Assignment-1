import java.util.Objects;

public class Record implements Comparable<Record>{

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

    public void setTerm(String term) {
        this.term = term;
    }

    public void setStmnt(String stmnt) {
        this.stmnt = stmnt;
    }

    public void setConfScore(float confScore) {
        this.confScore = confScore;
    }

    public void update(Record record) {

        this.stmnt = record.getStmnt();
        this.confScore = record.getConfScore();

    }

    public int compareTo(Record o) {

        return this.getTerm().compareTo(o.getTerm());

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
