package sort;

public class QuikSort {
    public static void  sort(Comparable a[]){
        sort(a,0,a.length-1);

    }

    public static void sort(Comparable[] a, int lo, int hi) {
       if(lo<hi){
           int index = partition(a,lo,hi);
           sort(a,lo,index);
           sort(a,index+1,hi);
       }
    }

    public static int partition(Comparable[] a, int lo, int hi){

        Comparable base =a[lo];
        while (lo<hi){
            while (lo<hi&&a[hi].compareTo(base)<0){
                hi--;
            }
            a[lo]=a[hi];
            while (lo<hi&&a[lo].compareTo(base)>=0){
                lo++;
            }
            a[hi]=a[lo];
        }
        a[lo]=base;


        return lo;


    }


    public static void sortMaopao(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                Comparable tmp = null;
                if(a[i].compareTo(a[j])>0){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }



    public static void main(String[] args) {
        String[] strs = {"a","e","s","a","e","s","a","e","s"};
        sort(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
