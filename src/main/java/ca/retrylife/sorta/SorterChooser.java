package ca.retrylife.sorta;

import java.util.ArrayList;

import ca.retrylife.hsa2.GraphicsConsole;
import ca.retrylife.sorta.sorters.SteppingSorter;
import ca.retrylife.sorta.utils.Match;

public class SorterChooser {
    static SorterChooser m_instance = null;

    // Basically a struct
    private class DisplayableSorter {
        String name;
        SteppingSorter sorter;

        public DisplayableSorter(String name, SteppingSorter sorter) {
            this.name = name;
            this.sorter = sorter;
        }
    }

    ArrayList<DisplayableSorter> m_sorters = new ArrayList<DisplayableSorter>();
    DisplayableSorter m_currentSorter = null;

    public static SorterChooser getInstance() {
        if (m_instance == null) {
            m_instance = new SorterChooser();
        }

        return m_instance;
    }

    public void addSorter(String name, SteppingSorter sorter) {
        m_sorters.add(new DisplayableSorter(name, sorter));
    }

    public SteppingSorter getSelection() {
        if (m_currentSorter == null) {
            m_currentSorter = m_sorters.get(0);
        }
        return m_currentSorter.sorter;
    }

    public void displayChooser(GraphicsConsole gc) {
        // Check for an empty list of sorters
        if (m_sorters.size() == 0) {
            gc.showDialog("No sorters are avalible", "Sorta error");
            return;
        }

        // Operate normally
        String selection = gc.showInputDialog("Enter a sort method\n1) Quicksort\n2) Bubblesort", "Select sort");

        if (selection == null || selection.equals("")) {
            return;
        }

        int index;
        try{
            index = Integer.valueOf(selection) % m_sorters.size();
        } catch (NumberFormatException nfe){
            return;
        }

        m_currentSorter = m_sorters.get(index);
        
    }

    public void setList(ArrayList<Integer> lst) {
        getSelection().set(lst);
    }
}