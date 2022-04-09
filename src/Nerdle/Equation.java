package Nerdle;

public class Equation {
    private char[] eq;
    private int size;

    public Equation() {
        size = 8;
        eq = new char[8];
    }

    public Equation(int size) {
        this.size = size;
        eq = new char[size];
    }

    public char[] getEq() {
        return eq;
    }

    public void setEq(char[] eq) {
        this.eq = eq;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
