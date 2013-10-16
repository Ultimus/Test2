
%include "asm_io.inc"

segment .data

prompt1 db    "Hello World! ", 0       ; don't forget nul terminator

segment .bss

segment .text
        global  asm_main
asm_main:
        enter   0,0               ; setup routine
        pusha

        mov     eax, prompt1      ; print out prompt
        call    print_string

        popa
        mov     eax, 0            ; return back to C
        leave                     
        ret


