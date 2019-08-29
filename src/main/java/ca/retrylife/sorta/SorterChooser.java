package ca.retrylife.sorta;

import java.util.ArrayList;

import ca.retrylife.sorta.sorters.SteppingSorter;

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
        return m_currentSorter.sorter;
    }
}