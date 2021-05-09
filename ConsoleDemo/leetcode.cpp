
#include "leetcode.h"
#include "stdafx.h"
#include <memory.h>
#include <math.h>
#include "utils.h"
#include <limits.h>
#include <algorithm>

using namespace std;

lineProgram::PackagePro::PackagePro(int vs[], int ws[]){
	this->ws = ws;
	this->vs = vs;
}

lineProgram::PackagePro::
~ PackagePro(){
	printf("Enter packagePro...");

	delete[] ws;
	delete[] vs;
}

int
lineProgram::PackagePro::
knapsack(int num, int weight){

	this->num = num;
	this->weight = weight;

	result = new int*[num+1];
	for (int i = 0; i < num+1; i++){
		result[i] = new int[weight+1];
		memset(result[i], 0, sizeof(int) * (weight+1));
	}

	for (int i = 1; i < num+1; i++){
		for (int j = 1; j < weight+1; j++){
			if (j < ws[i - 1]){
				result[i][j] = result[i - 1][j];
			}
			else {
				int nextVal = result[i - 1][j - ws[i - 1]] +vs[i-1];
				if (result[i - 1][j] > nextVal){
					result[i][j] = result[i - 1][j];
				}
				else {
					result[i][j] = nextVal;
				}
			}
		}
	}
	return result[num][weight];
}


int lineProgram::saleSocket(int prices[], int size){

	printf("size : %d", size);
	int** dp = new int*[size];
	for (int i = 0; i < size; i++){
		dp[i] = new int[2];
		memset(dp[i], 0, sizeof(int)* 2);
	}

	dp[0][0] = 0; //第一天卖出
	dp[0][1] = -prices[0]; // 第一天买入
	for (int i = 1; i < size; i++){
		dp[i][0] = fmax((double)dp[i - 1][0], (double)dp[i - 1][1] + prices[i]);
		dp[i][1] = fmax((double)dp[i - 1][1], (double)dp[i - 1][0] - prices[i]);
	}

	return dp[size-1][0];
}

int lineProgram::findMaxForm(vector<string>& strs, int m, int n){

	int** dp = new int*[m+1];
	for (int i = 0; i < m+1; i++){
		dp[i] = new int[n+1];
		memset(dp[i], 0, sizeof(int) * (n+1));
	}

	int result[2];

	for (vector<string>::iterator i = strs.begin(); i != strs.end(); i++){
		string val = i->data();
		cal01(val, result);

		for (int i = m; i >= result[0]; i--){
			for (int j = n; j >= result[1]; j--){
				dp[i][j] = fmax((double)(dp[i - result[0]][j - result[1]] +1),(double)dp[i][j]);
			}
		}
	}

	return dp[m][n];
}


void Sort::quick_sort(int arr[], int left, int right){

	if (left < right){
	    
		int i = left, j = right, x = arr[left];
		while (i < j){
		   
			while (i < j && arr[j] >= x){
				j--;
			}

			if (i < j){
				arr[i++] = arr[j];
			}

			while (i < j && arr[i] <= x){
				i++;
			}

			if (i < j){
				arr[j--] = arr[i];
			}
		}

		arr[i] = x;
		quick_sort(arr, left, i - 1);
		quick_sort(arr, i + 1, right);
	}

}

void 
Sort::mergeSort(int arr[], int len){
 
	int *tmp = new int[len];
	memset(tmp, 0, sizeof(int) * len);
	mergeSort(arr, tmp, 0, len - 1);
}

void Sort::mergeSort(int arr[], int tmp[], int left, int right){

	if (left < right){
		  int mid = left + (right - left) / 2;
		  mergeSort(arr, tmp, left, mid);
		  mergeSort(arr, tmp, mid + 1, right);
		  merge(arr, tmp, left, mid, right);
	}
}

void Sort::merge(int arr[], int tmp[], int left, int leftEnd, int right){

	int i = left, j = leftEnd + 1;
	int tmpPos = left;
	int len = right - left + 1;
	while (i <= leftEnd  && j <= right){

		if (arr[i] <= arr[j]){
			tmp[tmpPos++] = arr[i++];
		}
		else {
			tmp[tmpPos++] = arr[j++];
		}
	}

	while (i <= leftEnd){
		tmp[tmpPos++] = arr[i++];
	}

	while (j <= right){
		tmp[tmpPos++] = arr[j++];
	}

	for (int index = 0; index < len; index++, right--){
		arr[right] = tmp[right];
	}

}

int 
Base::binarySearch(int arr[], int n, int left, int right){

	if (left < right){
	   
		int mid = left + (right - left) / 2;
		if (arr[mid] > n){
			return binarySearch(arr, n, left, mid - 1);
		}
		else if (arr[mid] < n){
			return binarySearch(arr, n, mid + 1, right);
		}
		else {
			return mid;
		}
	}
}

bool
Base::canMeasureWater(int x, int y, int z){

	if (x + y < z) return false;

	if (x == 0 || y == 0){
		return z == 0 || x + y == z;
	}

	return z % gcd(x, y) == 0;
}

int
Base::gcd(int x, int y){
   
	if (x % y == 0) return y;
	return gcd(y, x%y);
}

int
Base::numWays(int n){

	int x1 = 1;
	int x2 = 2;

	int x = 0;
	for (int i = 3; i <= n; i++){
		x = (x1 + x2) % 1000000007;
		x1 = x2;
		x2 = 2;
	}
	return x;
}

int 
Base::sqrt(int n,int left, int right){

	if (left < right){
		int mid = left + (right - left) / 2;
		if (mid * mid > n){
			return sqrt(n, 0, mid - 1);
		}
		else if(mid * mid < n) {
			return sqrt(n, mid + 1, right);
		}
		else {
			return mid;
		}
	}
	else {
		return -1;
	}
}


void 
Array::moveArray(int arr[], int len, int offset){

	int tmp = arr[0];
	for (int i = 0; i + offset < len;){

		int next = i + offset;
		int nextVal = arr[next];
		arr[next] = tmp;
		tmp = nextVal;
		i = next;
	}
	arr[0] = tmp;
	
	tmp = arr[1];
	for (int i = 1; i + offset < len;){
	    
		int next = i + offset;
		int nextVal = arr[next];
		arr[next] = tmp;
		tmp = nextVal;
		i = next;
	}
	arr[1] = tmp;
}

int* 
Array::mergeSortArray(int arr1[], int arr2[], int len1, int len2){
 

	int* last = new int[len1 + len2];
	memset(last, 0, sizeof(int) * (len1 + len2));

	int arr1pos = 0, arr2pos = 0, lastpos;
	while (arr1pos < len1 && arr2pos < len2){
	
		if (arr1[arr1pos] <= arr2[arr2pos]){
			last[lastpos++] = arr1[arr1pos++];
		}
		else {
			last[lastpos++] = arr2[arr2pos++];
		}
	}

	while (arr1pos < len1){
		last[lastpos++] = arr1[arr1pos++];
	}

	while (arr2pos < len2){
		last[lastpos++] = arr2[arr2pos++];
	}

	return last;
}

int 
Array::maxSubArraySum(int arr[], int len){

	int maxSum = INT_MIN;
	int tmpSum = 0;
	for (int i = 0; i < len; i++){
	   
		tmpSum += arr[i];
		if (tmpSum > 0){
			maxSum = max(maxSum, tmpSum);
		}
		else {
			tmpSum = 0;
		}
	}
	return maxSum;
}


void Tree::printTree(TreeNode* root){

	if (root){
		printf(" %d", root->val);
		printTree(root->left);
		printTree(root->right);
	}
}


void Tree::mirrorTree(TreeNode &root){

	list<TreeNode*> list;
	list.push_back(&root);

	while (!list.empty()){
		TreeNode *node = list.front();
		list.pop_front();

		if (node->left != NULL){
			list.push_back(node->left);
		}

		if (node->right != NULL){
			list.push_back(node->right);
		}

		TreeNode *tmp = node->left;
		root.left = root.right;
		root.right = tmp;
	}
}

void Tree::mirrorTree1(TreeNode &root){

	if (root.left != NULL){
		mirrorTree1(*root.left);
	}

	if (root.right != NULL){
		mirrorTree1(*root.right);
	}


	TreeNode *node = root.left;
	root.left = root.right;
	root.right = node;
}

int Tree::treeDept(TreeNode *root){

	if (root == NULL) return 0;
	return max(treeDept(root->left), treeDept(root->right)) + 1;
}

int Tree::treeDept1(TreeNode *root){

	list<TreeNode*> list;
	list.push_back(root);
	int dept = 0;

	while (!list.empty()){
	
		int popNum = list.size();
		for (int i = 0; i < popNum; i++){
			TreeNode *node = list.back();
			list.pop_back();

			if (node->left != NULL){
				list.push_front(node);

			}
			if (node->right != NULL){
				list.push_front(node);
			}
		}

		dept++;
	}

	return dept;
}

int Tree::treeMinDept(TreeNode *root){

	if (root == NULL) return 0;

	int left = treeMinDept(root->left);
	int right = treeMinDept(root->right);

	if (root->left == NULL || root->right == NULL){
		return left + right + 1;
	}
	else {
		return min(left, right) + 1;
	}
}

bool Tree::isBalanceTree(TreeNode *root){
	return balance_recur(root) != -1;
}

int Tree::balance_recur(TreeNode *root){

	if (root == NULL) return -1;

	int left = balance_recur(root->left);
	if (left == -1) return -1;
	int right = balance_recur(root->right);
	if (right == -1) return -1;

	return abs(left - right) < 2 ? max(left, right) + 1 : -1;
}

bool Tree::isSubTree(TreeNode *parent, TreeNode *child){
	return false;
}


bool List::isCycleList(ListNode *node){

	ListNode *slow, *fast = node;
	while (fast != NULL && fast->next != NULL){
	    
		slow = slow->next;
		fast = fast->next->next;

		if (slow == fast){
			return true;
		}
	}

	return false;
}

List::ListNode*
List::findCycleNode(ListNode *node){

	//找出fast slow指针相交的那个地方
	ListNode *fast, *slow = node;
	while (fast != NULL && fast->next != NULL){

		slow = slow->next;
		fast = fast->next->next;
		if (fast == slow){
			break;
		}
	}

	while (slow != node){
		slow = slow->next;
		node = node->next;
	}

	return node;
}

List::ListNode* 
List::reverseList(ListNode *header){

	if (header == NULL || header->next == NULL){
		return header;
	}

	ListNode* newNode = reverseList(header->next);
	header->next->next = header;
	header->next = NULL;

	return newNode;
}

List::ListNode*
List::reverseList1(ListNode *header){

	if (header == NULL || header->next == NULL){
		return header;
	}

	ListNode* pre = NULL, *cur = header;
	while (cur->next != NULL){
		ListNode* next = cur->next;
		cur->next = pre;
		pre = cur;
		cur = next;
	}

	return cur;
}

List::ListNode*
List::deleteListNode(List::ListNode *header, int val){

	if (header->val == val) return header->next;

	ListNode* pre = header, *cur = header->next;
	while (cur != NULL){
	    
		if (cur->val != val){
			pre = cur;
			cur = cur->next;
		}
		else {
			pre->next = cur->next;
			break;
		}
	}

	return header;
}

List::ListNode*
List::mergeSortList(List::ListNode* h1, List::ListNode* h2){

	ListNode *last = new ListNode(-1);
	ListNode *cur = last;
	 
	while (h1 != NULL && h2 != NULL){

		if (h1->val <= h2->val){
			last->next = new ListNode(h1->val);;
			h1 = h1->next;
		}
		else {
			last->next = new ListNode(h2->val);
			h2 = h2->next;
		}
	}

	if (h1 != NULL){
		last->next = h1;
	}
	if (h2 != NULL){
		last->next = h2;
	}

	return cur->next;
}

string
lineProgram::longestPalindrone(string s){

	int length = s.length();
	bool **dp = new bool*[length];
	for (int i = 0; i < length; i++){
		dp[i] = new bool[length];
		memset(dp[i], false, sizeof(bool)*length);
	}

	int start, end = 0;

	for (int i = 1; i < length; i++){
		for (int j = 0; j < i; i++){
		   
			if (s[i] == s[j]){
				if (j - i < 3){
					dp[i][j] = true;
				}
				else {
					dp[i][j] = dp[i + 1][j - 1];
				}
			}
			else {
				dp[i][j] = false;
			}

			if (dp[i][j] && (j -i > end - start)){
				start = i;
				end = j;
			}
		}
	}

	return s.substr(start, end);
}


int
lineProgram::coinChange(int coins[], int amount){

	return -1;
}