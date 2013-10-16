%include "asm_io.inc"

segment .data
	text1 db "Bitte erste Zahl eingeben: ",0
	text2 db "Fehler bei der Eingabe, bitte geben sie eine positive Zahl ein!",0
	text3 db "Das Ergebniss lautet: ",0
	
segment .text
	
	mov eax, text1
	call print_string
	call read_int
	call print_nl
	mov ebx, eax
	
	cmp ebx,0
	JL err
	JGE f


f:
	

err:
	mov eax, text2
	call print_string
	call print_nl
	jmp end


result:
	mov eax,text3
	call print_string
	mov eax, ebx
	call print_int
	call print_nl
	jmp end




end:
    mov     eax, 0            ; return back to C

        leave                     

        ret
	
