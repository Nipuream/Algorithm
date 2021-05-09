#pragma once

#include <string>
#include <vector>

//线性规划
class lineProgram {

public:
	class PackagePro;
	//卖股票2，获取最大收益
	int saleSocket(int prices[], int num);
	//0和1
	int findMaxForm(std::vector<std::string>& strs, int m, int n);
	//最大回文子串
	std::string longestPalindrone(std::string s);
	//硬币交换
	int coinChange(int coins[], int amount);
};

//背包问题 0-1背包
class lineProgram::PackagePro {
public:
	PackagePro(int vs[], int ws[]);
	int knapsack(int num, int weight);
	~PackagePro();
private:
	int *vs;
	int *ws;
	int num;
	int weight;
	int** result;
};


//排序
class Sort {

public :
	//快速排序
	void quick_sort(int arr[], int left, int right);
	//归并排序
	void mergeSort(int arr[], int len);

private:
	void mergeSort(int arr[], int tmp[], int left, int right);
	void merge(int arr[], int tmp[], int left, int leftEnd, int right);

};


class Base {

public:
	//求n 的平方根，就是二分法
	int sqrt(int n, int left, int right);
	int binarySearch(int arr[], int n, int left, int right);
	//水壶问题，x,y容量的水壶，是否能盛 zL的水，辗转相除法很容易解决
	bool canMeasureWater(int x, int y, int z);
	//青蛙跳台阶问题，典型的斐波那契数列
	int numWays(int n);
	//旋转图像
	void rotatePic(int **matrix, int m, int n);
	//螺旋矩阵打印
	list<int> spiralOrder(int** matrix);

private:
	//辗转相除法
	int gcd(int x, int y);

};


class Array {

public:
	//移动数组，eg: arr = [1,2,3,4,5,6] offset = 2 , ==> arr = [5,6,1,2,3,4]
	void moveArray(int arr[], int len, int offset);
	//合并两个已排序数组
	int* mergeSortArray(int arr1[], int arr2[], int len1, int len2);
	//最大子数组之和
	int maxSubArraySum(int arr[], int len);
};


class Tree {

public:
	struct TreeNode;
	//镜像二叉树 stack方式实现
	void mirrorTree(TreeNode &root);
	//镜像二叉树 递归方式实现
	void mirrorTree1(TreeNode &root);
	//树的深度
	int treeDept(TreeNode *root);
	//树的深度 层序遍历
	int treeDept1(TreeNode *root);
	//树的最小深度
	int treeMinDept(TreeNode *root);
	//是否平衡二叉树/完全二叉树
	bool isBalanceTree(TreeNode *root);
	//是否为子树
	bool isSubTree(TreeNode *parent, TreeNode *child);

	//打印树，前序遍历
	void printTree(TreeNode *root);

private:
	int balance_recur(TreeNode *root);
};

struct Tree::TreeNode {

	int val;
	TreeNode *left;
	TreeNode *right;
};


class List{

public:
	struct ListNode;
	//判断链表是否有环
	bool isCycleList(ListNode *node);
	//找到环的入口点
	ListNode* findCycleNode(ListNode *node);
	//反转链表  递归方式实现
	ListNode* reverseList(ListNode *header);
	//反转链表  迭代方式实现
	ListNode* reverseList1(ListNode *header);
	//删除链表节点
	ListNode* deleteListNode(ListNode *header, int val);
	//合并两个有序链表
	ListNode* mergeSortList(ListNode *h1, ListNode *h2);
	//给链表排序
	ListNode* listSort(ListNode* header);
	//删除最后N个节点
	ListNode* deleteLastNode(ListNode* header, int n);
	//两个链表是否相交
	ListNode* listCross(ListNode* header1, ListNode* header2);

};

struct List::ListNode {

	int val;
	ListNode *next;

	ListNode(int val) :val(val), next(NULL){}
};