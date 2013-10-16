%include "asm_io.inc"

segment .data
	text1 db "Bitte Zahl eingeben:",0
	text2 db "Bitte Zahl einlesen: ",0


segment .text
	global asm_main
	
asm_main:

	enter 0,0
	pusha
	
	mov eax, text1
	call print_string
	call read_int
	call print_nl	
	mov edx, eax
	

	mov eax, text2
	call print_string
	call read_int
	call print_nl
	mov ecx, eax
	
	jmp calc

calc:
	mov edx, [ebp+12]
	mov ecx, [ebp+8]
	CMP ecx, 0
	JE term_cond				;if b=0 go to term_cond
	dec ecx
	push edx
	push ecx
	call calc
	add edx,1
	pop edx
	pop ecx
	mov eax,edx
	dump_regs 1
	jmp end


term_cond:
	MOV eax, 1					;if b=0 return 1

end:
	popa
	mov eax, 0
	leave
	ret
	
