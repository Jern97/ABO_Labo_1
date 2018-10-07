public class Interval implements Comparable<Interval> {

    public Interval(int lowInclusive, int highExclusive) {
        throw new UnsupportedOperationException("Nog te implementeren!");
    }

    /**
     * Geeft de (inclusieve) ondergrens terug
     * @return
     */
    public int getLow() {
        throw new UnsupportedOperationException("Nog te implementeren!");
    }

    /**
     * Geeft de (exclusieve) bovengrens terug
     * @return
     */
    public int getHigh() {
        throw new UnsupportedOperationException("Nog te implementeren!");
    }

    @Override
    /**
     * Te implementeren!
     * Returned -1 als dit interval een lagere ondergrens heeft, of een gelijke ondergrens en lagere bovengrens heeft dan Interval o
     * Returned 0 als dit interval gelijk is aan Interval o
     * Returnd 1 als dit interval een hogere ondergrens heeft, of een gelijke ondergrens en een hogere bovengrens heeft dan Interval o
     */
    public int compareTo(Interval o) {
        throw new UnsupportedOperationException("Nog te implementeren!");

    }

    /**
     * Bereken de overlap met Interval b. Als dit interval niet overlapt met Interval b, dan return je 'null' . Anders
     * return je een nieuw Interval dat de overlap voorstelt.
     * @param b
     * @return
     */
    public Interval calculateOverlap(Interval b) {
        throw new UnsupportedOperationException("Nog te implementeren!");
    }

    @Override
    public String toString() {
        return String.format("[%d, %d)",getLow(),getHigh());
    }
}
