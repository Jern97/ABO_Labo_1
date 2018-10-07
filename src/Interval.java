public class Interval implements Comparable<Interval> {
    int lowInclusive;
    int highExclusive;


    public Interval(int lowInclusive, int highExclusive) {
        this.lowInclusive = lowInclusive;
        this.highExclusive = highExclusive;
    }

    /**
     * Geeft de (inclusieve) ondergrens terug
     * @return
     */
    public int getLow() {
        return lowInclusive;
    }

    /**
     * Geeft de (exclusieve) bovengrens terug
     * @return
     */
    public int getHigh() {
        return highExclusive;
    }

    @Override
    /**
     * Te implementeren!
     * Returned -1 als dit interval een lagere ondergrens heeft, of een gelijke ondergrens en lagere bovengrens heeft dan Interval o
     * Returned 0 als dit interval gelijk is aan Interval o
     * Returnd 1 als dit interval een hogere ondergrens heeft, of een gelijke ondergrens en een hogere bovengrens heeft dan Interval o
     */
    public int compareTo(Interval o) {
        if(this.lowInclusive < o.lowInclusive || (this.lowInclusive == o.lowInclusive && this.highExclusive < o.highExclusive)){
            return -1;
        }
        if(this.lowInclusive > o.lowInclusive || (this.lowInclusive == o.lowInclusive && this.highExclusive > o.highExclusive)){
            return 1;
        }
        else return 0;
    }

    /**
     * Bereken de overlap met Interval b. Als dit interval niet overlapt met Interval b, dan return je 'null' . Anders
     * return je een nieuw Interval dat de overlap voorstelt.
     * @param b
     * @return
     */
    public Interval calculateOverlap(Interval b) {
        int type = this.compareTo(b);
        if(type == -1){
            if(this.highExclusive > b.lowInclusive){
                return new Interval(b.lowInclusive, this.highExclusive);
            }
            else return null;
        }
        if(type == 1){
            if(this.lowInclusive < b.highExclusive){
                return new Interval(this.lowInclusive, b.highExclusive);
            }
            else return null;
        }
        if(type == 0){
            return new Interval(this.lowInclusive, this.highExclusive);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d)",getLow(),getHigh());
    }
}
