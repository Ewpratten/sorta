package ca.retrylife.sorta.sorters;

import java.util.ArrayList;

import ca.retrylife.hsa2.GraphicsConsole;

public class QuickSorter extends SteppingSorter {

    ArrayList<Integer> m_dataset;
    ArrayList<Integer> m_workingDataset;

    int start = 0;
    int end = 0;

    public QuickSorter() {
        register("Quicksort");
    }

    private int partition(int start, int end) {
        int piviot = m_workingDataset.get(end);

        for (int i = start; i < end; i++) {
            if (m_workingDataset.get(i) < piviot) {
                int tmp = m_workingDataset.get(start);
                m_workingDataset.set(start, m_workingDataset.get(i));
                m_workingDataset.set(i, tmp);
                start++;
            }
        }

        int tmp = m_workingDataset.get(start);
        m_workingDataset.set(start, piviot);
        m_workingDataset.set(end, tmp);

        return start;
    }

    private void stepSort(){ 
		if (start >= end)
			return;
 
		// pick the pivot
		int middle = start + (end - start) / 2;
		int pivot = m_workingDataset.get(middle);
 
		// make left < pivot and right > pivot
		int i = start, j = end;
		while (i <= j) {
			while (m_workingDataset.get(i) < pivot) {
				i++;
			}
 
			while (m_workingDataset.get(j) > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = m_workingDataset.get(i);
                m_workingDataset.set(i, m_workingDataset.get(j));
                m_workingDataset.set(j, temp);
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (start < j)
            end = j;
 
		if (end > i)
			start = i;
    }

    @Override
    public void draw(GraphicsConsole gc) {
        // // Step sort

        int part = partition(start, end);

        if (part - 1 > start) {
            end = part - 1;
        }else if (part + 1 < end) {
            start = part + 1;
        } else {
            System.out.println("DONE");
        }

        // stepSort();

        // Vis dataset
        int width = gc.getWidth() / m_workingDataset.size();
        for (int i = 0; i < m_workingDataset.size(); i++) {
            gc.fillRect(i * width, 0, width, m_workingDataset.get(i));
        }
    }

    @Override
    public void reset() {
        m_workingDataset = new ArrayList<Integer>(m_dataset);
        int start = 0;
        end = m_workingDataset.size() - 1;
    }

    @Override
    public void set(ArrayList<Integer> lst) {
        m_dataset = lst;
        reset();
        
    }
    
}