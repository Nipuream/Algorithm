#pragma once

#include "stdafx.h"
#define LRU_MAX_VALUE 5


/*
 c++ 实现的 lru算法
*/
class lrucache {

public:
	lrucache();
	~lrucache();
	bool addVal(int key, int value);
	int getVal(int key);
	void printLru();

private:
	struct Node;
	unordered_map<int, Node*> maps;
	Node *header;
	Node *tailer;

	void moveToHeader(Node& node);
};

struct lrucache::Node {

public:
	Node(int key, int value)
		:key(key), value(value), pre(nullptr), next(nullptr){};
	Node()
		:key(0), value(0), pre(nullptr), next(nullptr){};

	int key, value;
	Node *pre, *next;
};
