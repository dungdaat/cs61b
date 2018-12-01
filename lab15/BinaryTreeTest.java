import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BinaryTreeTest<T> {
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**BinaryTree<T> test = new BinaryTree<T>();
        test.sampleTree4();
        System.out.println(test.isCompletelyBalanced());
        System.out.print(test.height()); */
        BinaryTree<Integer> a = new BinaryTree<Integer>();
        BinaryTree<Integer> tree = a.fibTree(3);
        BinaryTree.TreeNode<Integer> node  = tree.root;
        Method p = node.getClass().getDeclaredMethod("printInorder",null);
        p.setAccessible(true);
        p.invoke(node);

    }
}
