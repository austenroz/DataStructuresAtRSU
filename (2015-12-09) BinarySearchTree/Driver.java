public class Driver
{
    public static void main(String[] args)
    {
        BinarySearchTreeTest t = new BinarySearchTreeTest();
        TreeNode tn1 = new TreeNode(5, null, null); //Left Side of tree
        TreeNode tn2 = new TreeNode(7, null, null);
        TreeNode tn3 = new TreeNode(6, tn1, tn2);
        
        TreeNode tn4 = new TreeNode(9, null, null); //Right side of tree
        TreeNode tn5 = new TreeNode(11, null, null);
        TreeNode tn6 = new TreeNode(10, tn4, tn5);
        
        
        TreeNode tn8 = new TreeNode(8, tn3, tn6);
        System.out.println(t.helper(tn8));
    }
}