public class Jump {

    /**
     *This attribute tells the start of jump(Ladder or Snake).
     *For Ladder, start<end
     *For Snake, start>end
     */
    private int start;
    /**
     *This attribute tells the end of jump(Ladder or Snake).
     *For Ladder, start<end
     *For Snake, start>end
     */
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
