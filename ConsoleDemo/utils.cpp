#include "stdafx.h"

void cal01(string& str, int result[]){

	memset(result, 0, sizeof(int) * 2);
	int len = str.length();
	for (int i = 0; i < len; i++){
		if (str[i] == '0'){
			result[0]++;
		}
		else if (str[i] == '1'){
			result[1]++;
		}
	}
}
