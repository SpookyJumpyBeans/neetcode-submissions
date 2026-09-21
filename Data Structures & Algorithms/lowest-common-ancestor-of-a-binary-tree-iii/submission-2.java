/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        //BRUTE FORCE SOLUTION: TRY EVERY COMBINATION of p's ancestors and q's ancestors
        // BASE CASE 1: Direct Parent-Child Relationship
        // If one node is the immediate parent of the other, the parent is the LCA.
        if(p.parent == q || q.parent == p) {
            return p.parent == q ? q : p;
        }
        
        // BASE CASE 2: Shared Parent (Siblings)
        // If both nodes have the exact same parent, that shared parent is the LCA.
        if(p.parent == q.parent) {
            return p.parent;
        }
        
        // RECURSIVE BRANCH 1: Move 'p' upwards
        // Hold 'q' in place and move 'p' up to its parent to see if an intersection 
        // exists between p's ancestors and q.
        Node pParent = null;
        if(p.parent != null) {
            pParent = lowestCommonAncestor(p.parent, q);
        }
        
        // RECURSIVE BRANCH 2: Move 'q' upwards
        // Hold 'p' in place and move 'q' up to its parent to see if an intersection
        // exists between q's ancestors and p.
        Node qParent = null;
        if(q.parent != null) {
            qParent = lowestCommonAncestor(p, q.parent);
        }
        
        // COMBINE RESULTS
        // Because of the brute-force nature, one of the branches might hit a dead end (null).
        // We return whichever branch successfully found the intersection.
        return qParent == null ? pParent : qParent;
    }
}