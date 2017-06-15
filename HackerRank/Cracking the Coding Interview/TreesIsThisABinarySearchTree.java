/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
// https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
boolean checkBST(Node root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
// function overload
boolean checkBST(Node node, int min, int max) {
    if (node == null) return true;
    return  min < node.data && node.data < max && 
        checkBST(node.left, min, node.data) && 
        checkBST(node.right, node.data, max);
}
