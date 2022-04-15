// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
		
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubsets){
        if(ind == N){
            sumSubsets.add(sum);
            return;
        }
        //pick the condition
        func(ind+1,sum + arr.get(ind),arr,N,sumSubsets);
        
        //Not Pick Condition
        func(ind+1,sum,arr,N,sumSubsets);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sumSubsets = new ArrayList<>();
        func(0,0,arr,N,sumSubsets);
        Collections.sort(sumSubsets);
        return sumSubsets;
    }
}


//subset sum II
class Solution {
    public void findsubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> anslist) {
        anslist.add(new ArrayList<Integer>(ds));
        for(int i=ind; i<nums.length; i++) {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findsubsets(i+1, nums, ds, anslist);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> anslist = new ArrayList<>();
        findsubsets(0,nums,new ArrayList<>(),anslist);
        return anslist;
    }
}
