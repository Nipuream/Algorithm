#include "stdafx.h"


lrucache::lrucache(){

	header = new Node();
	tailer = new Node();
	header->next = tailer;
	tailer->pre = header;
}

lrucache::~lrucache(){
	maps.clear();
	//release nodes.
}

bool
lrucache::addVal(int key, int value){

	auto it = maps.find(key);
	if (it == maps.end()) {
		Node *newNode = new Node(key, value);
		pair<int, Node*> new_pair(key, newNode);
		pair<unordered_map<int, Node*>::iterator, bool> ret 
			= maps.insert(new_pair);
		if (ret.second != 1){
			return false;
		}

		newNode->next = header->next;
		header->next = newNode;
		newNode->next->pre = newNode;
	}
	else {
		it->second->value = value;
	}

	if (maps.size() > LRU_MAX_VALUE){

		Node* remove = tailer->pre;
		remove->pre->next = remove->next;
		remove->next->pre = remove->pre;

		maps.erase(remove->key);
	}

	return true;
}

int 
lrucache::getVal(int key){

	auto it = maps.find(key);
	if (it == maps.end()) return -1;
	else {
		Node* val = maps[key];
		moveToHeader(*val);
		return val->value;
	}
}

void lrucache::printLru(){

	for (unordered_map<int, Node*>::iterator it = maps.begin(); it != maps.end(); it++){
		printf("key : %d, value : %d \n", it->second->key, it->second->value);
	}
}


void 
lrucache::moveToHeader(Node& node){

	node.pre->next = node.next;
	node.next->pre = node.pre;

	node.next = header->next;
	node.pre = header;
	header->next = &node;
	node.next->pre = &node;
}
