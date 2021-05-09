#include "stdafx.h"

// lock_guard / unique_lock Çø±ð
bool Resources::putData(int data){

	unique_lock<std::mutex> lk(mutex);
	while (datas.size() >= MAX_VALUE){
		cond.wait(lk);
	}

	datas.push_back(data);
	cond.notify_all();
	return true;
}

int Resources::getData(){

	std::this_thread::sleep_for(std::chrono::seconds(1));
	unique_lock<std::mutex> lk(mutex);

	while (datas.empty()){
		cond.wait(lk);
	}

	int data = datas.front();
	datas.pop_front();
	cond.notify_all();
	return data;
}

void producter(Resources& res){
	int i = 0;
	while (!res.isStop){
		if (res.putData(i++)){
			printf("put data : %d\n", i);
		}
	}
}

void customer(Resources& res){

	while (!res.isStop){
		int data = res.getData();
		printf("get data : %d\n", data);
	}
}

void Resources::test(){

	Resources *res = new Resources;
	thread one(&producter, std::ref((*res)));
	thread two(&customer, std::ref((*res)));

	two.join();
	one.join();
}


