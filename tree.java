import java.util.*;
public class tree{
   
        public static void main(String... args){
            node<Integer> root = new node<>();
            root.node = 3;
            node<Integer> Node1 = new node<>();
            root.left= Node1;
            root.left.node = 1;
            node<Integer> aNode2 = new node<>();
            root.left.right= aNode2;
            root.left.right.node = 2;
            node<Integer> aNode3 = new node<>();
            root.right= aNode3;
            root.right.node = 4;
            node<Integer> aNode4 = new node<>();
            root.right.right = aNode4;
            root.right.right.node = 5;
            node<Integer> aNode5 = new node<>();
            root.right.right.right= aNode5;
            root.right.right.right.node = 65;

            node<Integer> aNode6 = new node<>();
            root.right.right.right.left= aNode6;
            root.right.right.right.left.node = 64;
            node<Integer> aNode7 = new node<>();
            root.right.right.right.right= aNode7;
            root.right.right.right.right.node = 70;

            root.preorder(root);
            System.out.println("==============");
            root.preorder2(root);
           // int height =llist.getHeight(root);
           // System.out.println("height: " + height);
            System.out.println("searching node \"2\"...");
            if (root.search(root,22))
                System.out.println("found target");
            int result = root.getCommonParent(root,5,70);
            System.out.println("common parent: " + result);

            System.out.println("post order: ");
            root.postorder(root);

            //tree to heap
            node<Integer> heap = root.treeToArray(root);
            heap.preorder(heap);
            System.out.println("post");
            heap.postorder(heap);
        }

        /**
        public int getHeight(node<String> root) {
            if (root == null) return 0;
            int a = getHeight(root.left) ;
            int b = getHeight(root.right) ;
            return 1 + ((a>b)? a : b);
        }
        **/

}
 class node<E extends Comparable<E>> implements Comparable<E>{
        public E node;
        public node<E> left;
        public node<E> right;

        public node() {
            
        }

        public node(E node) {
            this.node = node;
        }

        public void printNode() {
            System.out.println(node);
        }

        public int nodeCounter(node<E> root){
            if (root == null)
                return 0;
            return  1+(nodeCounter(root.left) + (nodeCounter(root.right)));
        }
        public int nodeCounterV2(node<E> root, int count) {
            if (node == null) return count;
            count++;
            count = nodeCounterV2(root.left, count);
            count = nodeCounterV2(root.right, count);
            return count;

        }

        public E getNode(node<E> root) {
            if (root == null) return null;
            getNode(root.left);
            getNode(root.right);
            return root.node;
        }
        public int[] treeToArray(node<E> root, int[] nodeArray) {
            if (root == null) return null;
            Stack<node<E>> stack = new Stack<>();
            int i = 0;
            while (root != null) {
                nodeArray[i] = (Integer)root.node;
                i++;
                if (root.right != null) stack.push(root.right);
                root = root.left;
                if (root == null){
                    if (!stack.isEmpty()) root = stack.pop();
                }
            }
            return nodeArray;
        }

        public node<E> treeToArray(node<E> root){
            //int countv2 = nodeCounterV2(root, 0);
            int numOfnodes = nodeCounter(root);
            int[] nodeArray = new int[numOfnodes];
            nodeArray = treeToArray(root, nodeArray);
            Arrays.sort(nodeArray);
            for (int num:nodeArray)
                System.out.println("num: " + num);

            LinkedList<node<Integer>> queue = new LinkedList<>();
            node<Integer> newNode = new node<>(nodeArray[0]);
            queue.add(newNode);
            
            int i = 0;
            node<Integer> treeNode = queue.getFirst();
            while(queue.size() > 0) {
                System.out.println("queue..");
                node<Integer> parent = queue.pop();
                int l = 2*i+1;
                int r = 2*i + 2;
                if (l < nodeArray.length) {
                    node<Integer> leftNode = new node<>(nodeArray[l]);
                    queue.add(leftNode);
                    parent.left = leftNode;
                }
                if (r < nodeArray.length) {
                    node<Integer> rightNode = new node<>(nodeArray[r]);
                    queue.add(rightNode);
                    parent.right = rightNode;
                }
                i++;
            }
            System.out.println("tansformed array to heap!");
            return (node<E>)treeNode;
        }

        public int compareTo(E n){
            int cmp = this.node.compareTo(n);
            return cmp;
        }

        public boolean search(node<E> root, E value){
            while (root != null ){
                if (root.compareTo(value) == 0)
                    return true;
                if (root.compareTo(value) > 0){
                    root = root.left;
                }
                else{
                    root = root.right;
                }
            }
            return false;
        }

        public E getCommonParent(node<E> root, E a, E b) {
            Stack<node<E>> treeStack = new Stack<>();
            while (root !=null) {
                boolean leftA = false;
                boolean leftB = false;
                boolean rightA = false;
                boolean rightB = false;
                if (root.left != null) {
                    leftA = root.left.search(root.left, a);
                    leftB = root.left.search(root.left, b);
                }

                if (root.right !=null){
                    rightA = root.right.search(root.right, a);
                    rightB = root.right.search(root.right, b);
                }

                if ((leftA || leftB) && (rightA || rightB)){
                    return root.node;
                }

                if ((leftA && leftB) || (rightA && rightB)){
                    if (root.left != null) {
                        if (root.left.compareTo(a) == 0 || root.left.compareTo(b) == 0) return root.node;
                    }
                    if (root.right != null) {
                        if (root.right.compareTo(a) == 0 || root.right.compareTo(b) == 0 ) return root.node;
                    }
                }

                if (root.right != null) treeStack.push(root.right);

                root = root.left;
                if (root == null){
                    if (!treeStack.isEmpty()) {
                        root = treeStack.pop();
                    }
                }

            }
            return null;
        }

        public void inorder(node<E> root){
            if (root == null) return;
            inorder(root.left);
            root.printNode();
            inorder(root.right);
        }

        public void postorder(node<E> root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            root.printNode();
        }
        public void preorder(node<E> root){
            if (root == null) return;
            root.printNode();
            preorder(root.left);
            preorder(root.right);
        }
        public void preorder2(node<E> root){
            Stack<node<E>> treeStack = new Stack<>();
            while (root != null || !treeStack.isEmpty()){
                root.printNode();
                if (root.right != null){
                    treeStack.push(root.right);
                } 

                root = root.left;
                if (root == null){
                    if (!treeStack.isEmpty()) {
                        root = treeStack.pop();
                        //if (root != null)
                           // root.printNode();
                        }
                    }
            }
    }
}

