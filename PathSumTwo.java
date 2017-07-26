// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int sum){
      List<List<Integer>> result = new ArrayList<>();

      if(root == null){
        return result;
      }

      if(root.left == null && root.right == null){
        if(root.val == sum){
          List<Integer> oneList = new ArrayList<>();
          oneList.add(root.val);
          result.add(oneList);
        }
        return result;
      }
      List<List<Integer>> preListRight = pathSum(root.right, sum - root.val);
      List<List<Integer>> preListLeft = pathSum(root.left, sum - root.val);

      if(preListLeft != null){
        result.addAll(preListLeft);
      }

      if(preListRight != null){
        result.addAll(preListRight);
      }

      for(List<Integer> oneList : result){
        oneList.add(0, root.val);
      }

      return result;

    }
}
