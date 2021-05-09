#pragma once

#include <string>
#include <vector>

//���Թ滮
class lineProgram {

public:
	class PackagePro;
	//����Ʊ2����ȡ�������
	int saleSocket(int prices[], int num);
	//0��1
	int findMaxForm(std::vector<std::string>& strs, int m, int n);
	//�������Ӵ�
	std::string longestPalindrone(std::string s);
	//Ӳ�ҽ���
	int coinChange(int coins[], int amount);
};

//�������� 0-1����
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


//����
class Sort {

public :
	//��������
	void quick_sort(int arr[], int left, int right);
	//�鲢����
	void mergeSort(int arr[], int len);

private:
	void mergeSort(int arr[], int tmp[], int left, int right);
	void merge(int arr[], int tmp[], int left, int leftEnd, int right);

};


class Base {

public:
	//��n ��ƽ���������Ƕ��ַ�
	int sqrt(int n, int left, int right);
	int binarySearch(int arr[], int n, int left, int right);
	//ˮ�����⣬x,y������ˮ�����Ƿ���ʢ zL��ˮ��շת����������׽��
	bool canMeasureWater(int x, int y, int z);
	//������̨�����⣬���͵�쳲���������
	int numWays(int n);
	//��תͼ��
	void rotatePic(int **matrix, int m, int n);
	//���������ӡ
	list<int> spiralOrder(int** matrix);

private:
	//շת�����
	int gcd(int x, int y);

};


class Array {

public:
	//�ƶ����飬eg: arr = [1,2,3,4,5,6] offset = 2 , ==> arr = [5,6,1,2,3,4]
	void moveArray(int arr[], int len, int offset);
	//�ϲ���������������
	int* mergeSortArray(int arr1[], int arr2[], int len1, int len2);
	//���������֮��
	int maxSubArraySum(int arr[], int len);
};


class Tree {

public:
	struct TreeNode;
	//��������� stack��ʽʵ��
	void mirrorTree(TreeNode &root);
	//��������� �ݹ鷽ʽʵ��
	void mirrorTree1(TreeNode &root);
	//�������
	int treeDept(TreeNode *root);
	//������� �������
	int treeDept1(TreeNode *root);
	//������С���
	int treeMinDept(TreeNode *root);
	//�Ƿ�ƽ�������/��ȫ������
	bool isBalanceTree(TreeNode *root);
	//�Ƿ�Ϊ����
	bool isSubTree(TreeNode *parent, TreeNode *child);

	//��ӡ����ǰ�����
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
	//�ж������Ƿ��л�
	bool isCycleList(ListNode *node);
	//�ҵ�������ڵ�
	ListNode* findCycleNode(ListNode *node);
	//��ת����  �ݹ鷽ʽʵ��
	ListNode* reverseList(ListNode *header);
	//��ת����  ������ʽʵ��
	ListNode* reverseList1(ListNode *header);
	//ɾ������ڵ�
	ListNode* deleteListNode(ListNode *header, int val);
	//�ϲ�������������
	ListNode* mergeSortList(ListNode *h1, ListNode *h2);
	//����������
	ListNode* listSort(ListNode* header);
	//ɾ�����N���ڵ�
	ListNode* deleteLastNode(ListNode* header, int n);
	//���������Ƿ��ཻ
	ListNode* listCross(ListNode* header1, ListNode* header2);

};

struct List::ListNode {

	int val;
	ListNode *next;

	ListNode(int val) :val(val), next(NULL){}
};