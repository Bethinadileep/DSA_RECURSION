class Solution {
    private void findcombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
       if(ind == arr.length){
           if(target == 0){
               ans.add(new ArrayList<>(ds));
           }
           return;
       }
       
       if(arr[ind] <= target){
           ds.add(arr[ind]);
           findcombinations(ind,arr,target-arr[ind],ans,ds);
           ds.remove(ds.size()-1);
           
       }
        //not pick condition
       findcombinations(ind+1,arr,target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombinations(0, candidates, target, ans, new ArrayList<Integer>());
        return ans;
    }
}


//Combination sum 11
class Solution {
    private void findcombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
    if(target == 0){
        ans.add(new ArrayList<>(ds));
        return;
    }
       
    for(int i = ind; i < arr.length; i++) {  
        if(i > ind && arr[i] == arr[i-1]) continue;
        if(arr[i]>target) break;
      
        ds.add(arr[i]);
        findcombinations(i+1,arr,target-arr[i],ans,ds);
        ds.remove(ds.size()-1);
           
        }
     }
         
        
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findcombinations(0, candidates, target, ans, new ArrayList<Integer>());
        return ans;
        
        
    }
}
// t(n) = 2^n * k
// s(n) = k * x
