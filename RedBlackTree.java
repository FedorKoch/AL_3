public class RedBlackTree {
	private Node root;

	public RedBlackTree() {
		root = null;
	}

	public RedBlackTree(int[] elements) {
		root = null;
		for (int element : elements) {
			insert(element);
		}
	}

	public void insert(int key) {
		Node node = new Node(key);

		if (root == null) {
			root = node;
		} else {
			Node parent = null;
			Node current = root;

			while (current != null) {
				parent = current;

				if (key < current.key) {
					current = current.left;
				} else {
					current = current.right;
				}
			}

			if (key < parent.key) {
				parent.left = node;
			} else {
				parent.right = node;
			}

			node.parent = parent;
		}

		insertFixup(node);
	}

	public Node getLeft(Node node) {
		return node.left;
	}

	public Node getRight(Node node) {
		return node.right;
	}

	public Node getRoot() {
		return root;
	}

	public void insertFixup(Node node) {
	}

	public static class Node {
		public int key;
		public Node parent;
		public Node left;
		public Node right;
		public boolean isRed;

		public Node(int key) {
			this.key = key;
			this.isRed = true;
		}
	}
}