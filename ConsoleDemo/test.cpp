#include "test.h"

#include "stdafx.h"

using namespace std;

void testSort(){

	int arr[] = { 7, 1, 5, 3, 2 };
	Sort sort;
	//sort.quick_sort(arr, 0, sizeof(arr) / sizeof(int) - 1);
	sort.mergeSort(arr, sizeof(arr) / sizeof(int));
	for (int i = 0; i < sizeof(arr) / sizeof(int); i++){
		printf(" %d", arr[i]);
	}
}

void testLru(){

	lrucache *lru = new lrucache;
	lru->addVal(1, 1);
	lru->addVal(2, 2);
	lru->addVal(3, 3);
	lru->addVal(4, 4);
	lru->addVal(5, 5);
	lru->printLru();

	int result = lru->getVal(1);
	printf("==== È¡³ö  result : %d \n", result);
	printf("===================================\n");

	lru->addVal(6, 6);
	lru->printLru();
	delete lru;
}

void testZeroOne(){

	//	string strs[] = {"10", "0001", "111001", "1", "0"};

	vector<string> vec;
	vec.push_back("10");
	vec.push_back("0001");
	vec.push_back("111001");
	vec.push_back("1");
	vec.push_back("0");

	lineProgram *pro = new lineProgram;
	int result = pro->findMaxForm(vec, 5, 3);
	printf("result : %d", result);

	delete pro;
}

void testMaxProfit(){

	int prices[] = { 1, 2, 3, 4, 5, 6, 7 };
	lineProgram *pro = new lineProgram;
	int result = pro->saleSocket(prices, sizeof(prices) / sizeof(int));
	printf("result : %d", result);

	delete pro;
}

void testPackage(){

	int ws[] = { 2, 3, 5, 5 };
	int vs[] = { 2, 4, 3, 7 };
	lineProgram::PackagePro *pro = new lineProgram::PackagePro(vs, ws);
	int result = pro->knapsack(4, 10);
	printf("result : %d", result);

	delete pro;
}

void testbinarySort(){

	int arr[] = { 1, 2, 3, 4, 5, 6 };
	Base base;
	int index = base.binarySearch(arr, 3, 0, 5);
	printf("index : %d", index);
}

void testSqrt(){
	Base base;
	int result = base.sqrt(54, 0, 16);
	printf("result : %d", result);
}

void testArrayMove(){

	int arr[] = { 1, 2, 3, 4, 5, 6 };

	Array array;
	array.moveArray(arr, sizeof(arr) / sizeof(int), 2);
	for (int i = 0; i < sizeof(arr) / sizeof(int); i++){
		printf(" %d", arr[i]);
	}
}

void testMaxSubArraySum(){

	int arr[] = { 2, -2, -1, 5, 2, -2 };
	Array array;
	int maxSubSum = array.maxSubArraySum(arr, sizeof(arr) / sizeof(int));
	printf("maxSubSum : %d", maxSubSum);
}
