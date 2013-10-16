%include "asm_io.inc"

segment .data
	text1 db "Bitte Zahl eingeben: ",0
	text2 db "Die gesuchte Fibonacci Zahl ist: ",0

segment .bss
	input resd 1
	

segment .text

	global asm_main

asm_main:
	mov eax, text1        ; Text laden

    call print_string        ; Text ausgeben

    call read_int        ; Wechselgeldbetrag einlesen

    call print_nl        ; Neue Zeile

	mov ecx, eax

	mov eax, 1
	mov ebx, 0
	sub ecx,1
	mov edx, 0

calc:
	mov edx, eax
	add eax, ebx
	mov ebx, edx
	loop calc

	mov edx, eax

	mov eax, text2
	mov eax, edx
	call print_int
	call print_nl


   popa
   mov     eax, 0            ; return back to C
   leave
   ret
