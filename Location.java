public class Location implements Comparable
{
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public String toString()
    {
        return "(" + row + ", " + col + ")";
    }

    public boolean equals(Object other)
    {
        Location otherLoc = (Location)(other);
        return this.row == otherLoc.getRow() && this.col == otherLoc.getCol();
    }

    public int compareTo(Object other)
    {
        Location otherLoc = (Location)(other);
        if (otherLoc.getRow() == this.row)
            return this.col - otherLoc.getCol();
        else
            return this.row - otherLoc.getRow();
    }
}
