#pragma once

#include "stdafx.h"
#define MAX_VALUE 100

/*
 c++ ʵ�ֵ������� ������
*/
class Resources {

public:
	bool putData(int data);
	int getData();
	void test();
	bool isStop;
private:
	list<int> datas;
	mutex mutex;
	condition_variable cond;
};