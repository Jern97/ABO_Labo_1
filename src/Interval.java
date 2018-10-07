public class Interval implements Comparable<Interval> {
    private int low;
    private int high;


    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    /**
     * Geeft de (inclusieve) ondergrens terug
     * @return
     */
    public int getLow() {
        return low;
    }

    /**
     * Geeft de (exclusieve) bovengrens terug
     * @return
     */
    public int getHigh() {
        return high;
    }

    @Override
    /**
     * Te implementeren!
     * Returned -1 als dit interval een lagere ondergrens heeft, of een gelijke ondergrens en lagere bovengrens heeft dan Interval o
     * Returned 0 als dit interval gelijk is aan Interval o
     * Returnd 1 als dit interval een hogere ondergrens heeft, of een gelijke ondergrens en een hogere bovengrens heeft dan Interval o
     */
    public int compareTo(Interval o) {
        if(this.low < o.low || (this.low == o.low && this.high < o.high)){
            return -1;
        }
        if(this.low > o.low || (this.low == o.low && this.high > o.high)){
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
            if(this.high > b.low){
                return new Interval(b.low, this.high);
            }
            else return null;
        }
        if(type == 1){
            if(this.low < b.high){
                return new Interval(this.low, b.high);
            }
            else return null;
        }
        if(type == 0){
            return new Interval(this.low, this.high);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d)",getLow(),getHigh());
    }
}
