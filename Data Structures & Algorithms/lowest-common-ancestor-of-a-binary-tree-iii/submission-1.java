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
        if(p.parent == q|| q.parent == p)
        {
            return p.parent == q ? q : p;
        }
        if(p.parent== q.parent)
        {
            return p.parent;
        }
        Node pParent = null;
        if(p.parent!=null)
        {
            pParent = lowestCommonAncestor(p.parent, q);
        }
        Node qParent = null;
        if(q.parent!=null)
        {
            qParent = lowestCommonAncestor(p, q.parent);
        }
        return qParent == null ? pParent : qParent;
    }
}