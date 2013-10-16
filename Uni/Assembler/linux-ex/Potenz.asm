%include "asm_io.inc"

segment .data

text1 db    "Bitte Zahl a eingeben: ", 0       ; don't forget nul terminator
text2 db    "Bitte Zahl b eingeben: ", 0
text3 db    "Potenz der Zahlen ist: ", 0

segment .bss
base resd 1
exp resd 1
result resd 1


segment .text
	global asm_main

asm_main:
	enter 0,0
	pusha

	mov eax, text1
	call print_string
	
	call read_int
	mov [base], eax
	cmp eax,0

	mov eax,[base]
	mov [result], eax

	mov eax, text2
	call print_string
	
	call read_int
	mov [exp], eax
	cmp eax, 0
	JE equal

	;berechnung
		
	mov ecx, [exp]
	mov edx,[base]
	mov eax, [result]
	

start:
	mov ecx, [exp]        ; Exponentenzähler in ecx laden

    ;cmp ecx, 1            ; Exponent mit 1 vergleichen

    ;JLE finish            ; Exponent = 1 --> ausgabe

    mov eax, dword[base]         ; Basis in eax laden

    mul dword[result]            ; Basis * Basis            FEHLER ??? WIE SONST ???

    mov dword[result], eax        ; neue Basis speichern

    mov [exp], ecx
	loop start
	
	jmp finish

equal:	mov eax, text3
		call print_string
		mov eax,1
		call print_int
		call print_nl
		jmp end
	
finish: 
	mov eax, text3
	call print_string
	mov eax, edx
	call print_int
	jmp end


end:	popa
	mov eax, 0
	leave 
	ret
