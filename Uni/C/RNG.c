    #include <stdio.h>

     
    #define ESC 27
     
    int main()
    {
        unsigned c = 'n', r, count = 0;
     
    while (c == 'n')
    {
       printf ("\n\nGeben sie eine Maximalzahl ein: \n\n");
        scanf ("%u", &r);
        printf("<Leertaste> = Ergebniss, "
        "<ESC> = Ende des Programms \n\n"
        "\n\nErgebnisse: \n\n");
     
        do
        {
            while (!kbhit())
            ++count;
     
            if ( (c = getch()) == ' ' )
            printf ("%-5u\t", count % r + 1);
     
        }
     
        while (c != ESC && c!= 'n');
     
     
    }
     
        return 0;
    }

