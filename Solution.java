import java.io.*;
import java.util.*;

public class Solution {

	/**
	 * Represents a Node in a tree
	 */
	static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return this.value+"";
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final int numNodes = scanner.nextInt();
		int nodeValues[] = new int[numNodes];
		for (int i = 0; i < numNodes; i++) {
			nodeValues[i] = scanner.nextInt();
		}
		final int numParams = scanner.nextInt();
		String parameters[] = new String[numParams];
		scanner.nextLine();
		for (int i = 0; i < numParams; i++) {
			parameters[i] = scanner.nextLine();
		}

		Node tree = fromArray(nodeValues);
		preOrder(tree);
		postOrder(tree);
		System.out.println(isBST(tree));
		System.out.println(numNodes(tree));

	}

	/**
	 * Constructs a Complete Tree from an array of integers
	 * @param arr an Array of integers
	 * @return the root node of the tree
	 */
	public static Node fromArray(int arr[]) {
		Node node = fromArrayHelp(arr,0, arr.length );
		return  node;
	}

	/**
	 * Used by fromArray to construct the tree
	 * @param arr an array of integers
	 * @param index the index of the value in arr for the node
	 * @param numNodes the number of nodes the tree will contain
	 * @return the root node of a complete tree
	 */
	public static Node fromArrayHelp(int arr[], int index, final int numNodes){
		Node node = null;
		if (index<numNodes){
			node = new Node(arr[index]);
			//System.out.println("Adding"+arr[index]);
			node.left = fromArrayHelp(arr,2*index+1, numNodes);
			node.right =fromArrayHelp(arr,2*index+2, numNodes);
		}
		return node;
	}

	/**
	 * Prints our the Preorder traversal of the tree
	 * @param root a Node, the the root node of the tree
	 */
	public static void preOrder(Node root){
		preOrderHelp(root);
		System.out.println();
	}

	/**
	 * Used by preOrder to print out the nodes in preorder
	 * @param node the current node being explored
	 */
	public static void preOrderHelp(Node node){
		System.out.print(node + " ");
		if (node.left!=null)
			preOrderHelp(node.left);
		if (node.right!=null)
			preOrderHelp(node.right);
	}

	/**
	 * Prints our the postorder traversal of the tree
	 * @param root a Node, the the root node of the tree
	 */
	public static void postOrder(Node root){
		postOrderHelp(root);
		System.out.println();
	}
	/**
	 * Used by postOrder to print out the nodes in postorder
	 * @param node the current node being explored
	 */
	public static void postOrderHelp(Node node){
		if (node.left!=null)
			postOrderHelp(node.left);
		if (node.right!=null)
			postOrderHelp(node.right);
		System.out.print(node + " ");
	}

	/**
	 * Determins if a tree is a Binary Search Tree
	 * @param root the root node of the tree
	 */
	public static boolean isBST(Node node){
		if (node.left!=null && node.left.value>node.value)
			return false;
		else if (node.left != null)
			isBST(node.left);
		if (node.right!=null && node.right.value<node.value)
			return false;
		else if (node.right != null)
			isBST(node.right);
		return true;
	}
	public static int[] toArray(Node root){
		//ArrayList<Integer> = new ArrayList<Integer>;
		//Queue queueA = new LinkedList();
		int arr[] = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
		return arr;
	}
	
	public static int numNodes(Node root){
		return numNodesHelp(root, 0);

	}
	public static int numNodesHelp(Node node, int count){
		if (node.left!=null)
			count = count +numNodesHelp(node.left,count);
		if (node.right!=null)
			count = count  + numNodesHelp(node.right,count);
		return 1;
	}

}

