%include "asm_io.inc"

segment .data

 

text1 db    "Wechselbetrag eingeben: ", 0

text2 db    "50 Cent Stuecke: ", 0

text3 db    "10 Cent Stuecke: ", 0

text4 db    " 5 Cent Stuecke: ", 0

text5 db    " 1 Cent Stuecke: ", 0

 

segment .bss

 

input resd 1

vergleich resd 1

 

ausgabe resd 1

 

 

segment .text

        global  asm_main

asm_main:

 

    mov eax, text1        ; Text laden

    call print_string        ; Text ausgeben
   

 

    call read_int        ; Wechselgeldbetrag einlesen

    call print_nl        ; Neue Zeile

 

    mov [input], eax        ; und speichern in input1

 

    mov ecx, 50            ; Vergleichszahl 1 speichern

    mov [vergleich], ecx

 

 

f0: mov eax, [input]        ; Wechselgeldbetrag laden

    cmp eax, 50     ; Wechselgeldbetrag mit 50 Cent vergleichen

    JGE f1            ; Falls Wechselgeldbetrag größer als 50 Cent, springe zu s1

 

    mov eax, text2        ; lädt den Text

    call print_string        ; gibt den Text aus

    mov eax, [ausgabe]        ; lädt in eax Ausgabe

    call print_int        ; gibt die Zahl aus

    call print_nl        

    mov eax, 0            ;setzt die Ausgabe gleich 0

    mov [ausgabe], eax

 

    mov eax, [input]

     cmp eax, 50

    JL z0            ; Falls Wechselgeldbetrag kleiner als 50 Cent ist, springe zu s2

 

 

f1: mov ebx, [ausgabe]        ; Zähler für 50 Cent laden

    add ebx, 1            ; 1 addieren FEHLER ???

    mov [ausgabe], ebx        ; Zähler für 50 Cent speichern

    mov edx, [input]        ; Wechselgeldbetrag laden

    sub edx, 50            ; 50 Cent abziehen

    mov [input], edx

    jmp f0            ; Springe zurück zum Vergleich
 

 

 

z0: mov eax, [input]        ; Wechselgeldbetrag laden

    cmp eax, 10         ; Wechselgeldbetrag mit 50 Cent vergleichen

    JGE z1            ; Falls Wechselgeldbetrag größer als 50 Cent, springe zu s1

 

    mov eax, text3        ; lädt den Text

    call print_string        ; gibt den Text aus

    mov eax, [ausgabe]        ; lädt in eax Ausgabe

    call print_int        ; gibt die Zahl aus

    call print_nl        

    mov eax, 0            ;setzt die Ausgabe gleich 0

    mov [ausgabe], eax

 

    mov eax, [input]

     cmp eax, 10

    JL c0            ; Falls Wechselgeldbetrag kleiner als 50 Cent ist, springe zu s2

 

 

z1: mov ebx, [ausgabe]        ; Zähler für 50 Cent laden

    add ebx, 1            ; 1 addieren FEHLER ???

    mov [ausgabe], ebx        ; Zähler für 10 Cent speichern

    mov edx, [input]        ; Wechselgeldbetrag laden

    sub edx, 10            ; 10 Cent abziehen

    mov [input], edx

    jmp z0            ; Springe zurück zum Vergleich
 

 

 

c0: mov eax, [input]        ; Wechselgeldbetrag laden

    cmp eax, 5         ; Wechselgeldbetrag mit 50 Cent vergleichen

    JGE c1            ; Falls Wechselgeldbetrag größer als 50 Cent, springe zu s1

 

    mov eax, text4        ; lädt den Text

    call print_string        ; gibt den Text aus

    mov eax, [ausgabe]        ; lädt in eax Ausgabe

    call print_int        ; gibt die Zahl aus

    call print_nl        

    mov eax, 0            ;setzt die Ausgabe gleich 0

    mov [ausgabe], eax

 

    mov eax, [input]

     cmp eax, 5

    JL e1            ; Falls Wechselgeldbetrag kleiner als 50 Cent ist, springe zu s2

 

 

c1: mov ebx, [ausgabe]        ; Zähler für 50 Cent laden

    add ebx, 1            ; 1 addieren FEHLER ???

    mov [ausgabe], ebx        ; Zähler für 10 Cent speichern

    mov edx, [input]        ; Wechselgeldbetrag laden

    sub edx, 5            ; 5 Cent abziehen

    mov [input], edx

    jmp c0            ; Springe zurück zum Vergleich
 

 

 

e0: mov eax, [input]        ; Wechselgeldbetrag laden

    cmp eax, 1             ; Wechselgeldbetrag mit 1 Cent vergleichen

    JGE e1            ; Falls Wechselgeldbetrag größer als 10 Cent, springe zu e1

 

    mov eax, text5        ; lädt den Text

    call print_string        ; gibt den Text aus

    mov eax, [ausgabe]        ; lädt in eax Ausgabe

    call print_int        ; gibt die Zahl aus

    call print_nl        

    mov eax, 0            ;setzt die Ausgabe gleich 0

    mov [ausgabe], eax

 

    mov eax, [input]

     cmp eax, 1            ; Vergleich ob mehr als ein Cent vorhanden ist

    JL end            ; Falls Wechselgeldbetrag kleiner als 1 Cent ist beende das Programm

 

 

e1: mov ebx, [ausgabe]        ; Zähler für 50 Cent laden

    add ebx, 1            ; 1 addieren FEHLER ???

    mov [ausgabe], ebx        ; Zähler für 10 Cent speichern

    mov edx, [input]        ; Wechselgeldbetrag laden

    sub edx, 1            ; 1 Cent abziehen

    mov [input], edx

    jmp e0            ; Springe zurück zum Vergleich
 

 

end:    mov     eax, 0            ; return back to C

        leave                     

        ret
