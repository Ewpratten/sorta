package ca.retrylife.sorta.sorters;

import java.util.ArrayList;

import ca.retrylife.hsa2.GraphicsConsole;
import ca.retrylife.sorta.SorterChooser;

public abstract class SteppingSorter {

    protected void register(String name){
        SorterChooser.getInstance().addSorter(name, this);
    }

    public abstract void draw(GraphicsConsole gc);

    public abstract void reset();
    public abstract void set(ArrayList<Integer> lst);

    
}