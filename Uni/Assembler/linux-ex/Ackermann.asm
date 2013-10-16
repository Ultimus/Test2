%include "asm_io.inc"


segment .data

text1 db "Bitte erste Zahl eingeben: ",0 ;m
text2 db "Bitte zweite Zahl eingeben: ",0 ;n
text3 db "Ergebniss: ",0
text4 db "Fehler bei der Eingabe. Bitte geben sie zwei positive ganze Zahlen ein!",0


segment .bss

segment .text
	global asm_main


asm_main:

	mov eax, text1
	call print_string
	call read_int
	call print_nl  ;Erste Zahl einlesen


	mov ecx, eax ; Erste Zahlk liegt in ecx! (m)

	mov eax, text2
	call print_string
	call read_int
	call print_nl

	mov edx, eax ; zweite Zahl liegt in edx(n)

	cmp edx, 0
	JB comp
	JLE err


comp:
	cmp ecx,0
	JB calc
	JLE err


calc:
	mov edx, [ebp+12]
	mov ecx, [ebp+8]

	cmp edx, 0
	JE 

	



err:
	mov eax, text4
	call print_string
	call print_nl
	jmp end

end:
	mov eax, 0            ; return back to C
     leave                     
    	ret

	
