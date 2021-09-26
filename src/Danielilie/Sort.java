package Danielilie;

public class Sort {

	int[] arr;
	int l = 0;
	int r = 0;
	
	public Sort(int[] arr, int l, int r) {
		
		this.arr = arr;
		this.l = l;
		this.r = r;
		
		this.arr = sort(this.arr, this.l, this.r);
		
	}

	public int[] getSort() {
		return this.arr;
	}
	
	
	public int[] sort(int[] arr, int l, int r)
	{
	    if (l < r) {
	        // Find the middle point
	        int m =l+ (r-l)/2;

	        // Sort first and second halves
	        sort(arr, l, m);
	        sort(arr, m + 1, r);

	        // Merge the sorted halves
	        merge(arr, l, m, r);
	      
	    }
	    return arr;
	}

	void merge(int arr[], int l, int m, int r)
	{
	    // Find sizes of two subarrays to be merged
	    int n1 = m - l + 1;
	    int n2 = r - m;

	    /* Create temp arrays */
	    int L[] = new int[n1];
	    int R[] = new int[n2];

	    /*Copy data to temp arrays*/
	    for (int i = 0; i < n1; ++i)
	        L[i] = arr[l + i];
	    for (int j = 0; j < n2; ++j)
	        R[j] = arr[m + 1 + j];

	    /* Merge the temp arrays */

	    // Initial indexes of first and second subarrays
	    int i = 0, j = 0;

	    // Initial index of merged subarray array
	    int k = l;
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i];
	            i++;
	        }
	        else {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }

	    /* Copy remaining elements of L[] if any */
	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }

	    /* Copy remaining elements of R[] if any */
	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	
	
	
	
	
	
	
}
