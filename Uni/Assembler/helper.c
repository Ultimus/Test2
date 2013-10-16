#include <cdecl.h>

int PRE_CDCECL ams_main (void) POST_CDECL;

int main(){
	int ret_status;
	ret_status = asm_main();
	return ret_status;
	}

