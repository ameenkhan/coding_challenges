package com.akpg.model;

import java.util.ArrayList;

public class Node_nary {
    public int val;
    public ArrayList<Node_nary> children;

    public Node_nary(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node_nary(int val, ArrayList<Node_nary> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ArrayList<Node_nary> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node_nary> children) {
        this.children = children;
    }
}
