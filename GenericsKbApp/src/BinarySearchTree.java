/**
 * @author Hussain Suleman
 * @param <T> will be used as Record
 */

public class BinarySearchTree<T extends Comparable<T>>{

    BinaryTreeNode<T> root;
    public BinarySearchTree ()
    {
        root = null;
    }

    public BinaryTreeNode<T> find ( T d )
    {
        if (root == null)
            return null;
        else
            return find (d, root);
    }
    public BinaryTreeNode<T> find ( T d, BinaryTreeNode<T> node ) {
        int cmp = d.compareTo(node.data);
        if (cmp == 0)
            return node;
        else if (cmp < 0)
            return (node.left == null) ? null : find(d, node.left);
        else
            return (node.right == null) ? null : find(d, node.right);
    }

    public void insert ( T d )
    {
        if (root == null)
            root = new BinaryTreeNode<T> (d, null, null);
        else
            insert (d, root);
    }
    public void insert ( T d, BinaryTreeNode<T> node )
    {
        if (d.compareTo (node.data) <= 0)
        {
            if (node.left == null)
                node.left = new BinaryTreeNode<T> (d, null, null);
            else
                insert (d, node.left);
        } else {
            if (node.right == null)
                node.right = new BinaryTreeNode<T> (d, null, null);
            else
                insert (d, node.right);
        } 
    }

    public void preOrder ()
    {
        preOrder (root);
    }
    public void preOrder ( BinaryTreeNode<T> node ) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }



    public class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T d, BinaryTreeNode<T> l,
                              BinaryTreeNode<T> r) {
            data = d;
            left = l;
            right = r;
        }

        BinaryTreeNode<T> getLeft() {
            return left;
        }

        BinaryTreeNode<T> getRight() {
            return right;
        }

    }

}
