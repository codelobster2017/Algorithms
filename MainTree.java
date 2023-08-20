package BinaryTree;

public class MainTree {
    enum Color {
        RED,
        BLACK
    }

    static class RedBlackNode<T> {
        T data;
        RedBlackNode<T> left;
        RedBlackNode<T> right;
        RedBlackNode<T> parent;
        Color color;
        public RedBlackNode(T data) {
            this.data = data;
            this.color = Color.RED;
        }

    }
    static class RedBlackTree<T extends Comparable<T>> {
        private RedBlackNode<T> root;
        public RedBlackTree() {
            this.root = null;
        }
        private void leftRotate(RedBlackNode<T> x) {
            RedBlackNode<T> y = x.right;
            x.right = y.left;
            if (y.left != null) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.left = x;
            x.parent = y;
        }



        private void rightRotate(RedBlackNode<T> x) {
            RedBlackNode<T> y = x.left;
            x.left = y.right;
            if (y.right != null) {
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }

            y.right = x;
            x.parent = y;

        }



        private void insertColor(RedBlackNode<T> z) {
            while (z.parent != null && z.parent.color == Color.RED) {
                if (z.parent == z.parent.parent.left) {
                    RedBlackNode<T> y = z.parent.parent.right;
                    if (y != null && y.color == Color.RED) {
                        z.parent.color = Color.BLACK;
                        y.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        z = z.parent.parent;

                    } else {
                        if (z == z.parent.right) {
                            z = z.parent;
                            leftRotate(z);
                        }

                        z.parent.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        rightRotate(z.parent.parent);

                    }

                } else {

                    RedBlackNode<T> y = z.parent.parent.left;
                    if (y != null && y.color == Color.RED) {
                        z.parent.color = Color.BLACK;
                        y.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        z = z.parent.parent;

                    } else {

                        if (z == z.parent.left) {
                            z = z.parent;
                            rightRotate(z);
                        }

                        z.parent.color = Color.BLACK;
                        z.parent.parent.color = Color.RED;
                        leftRotate(z.parent.parent);

                    }

                }

            }
            this.root.color = Color.BLACK;
        }



        public void insert(T data) {
            RedBlackNode<T> z = new RedBlackNode<>(data);
            RedBlackNode<T> y = null;
            RedBlackNode<T> x = this.root;

            while (x != null) {
                y = x;
                if (z.data.compareTo(x.data) <= 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }

            z.parent = y;

            if (y == null) {
                this.root = z;
            } else if (z.data.compareTo(y.data) <= 0) {
                y.left = z;
            } else {
                y.right = z;
            }

            insertColor(z);
        }
    }

    public static void main(String[] args) {

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.insert(55);

        tree.insert(80);

        tree.insert(22);

        tree.insert(40);

        tree.insert(36);

        tree.insert(70);

        tree.insert(92);

    }

}
