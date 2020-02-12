lexer grammar g;

tokens {PROGRAM,BEGIN,END,FUNCTION,READ,WRITE,IF,ELSE,ENDIF,WHILE,ENDWHILE,CONTINUE,BREAK,RETURN,INT,VOID,STRING,FLOAT}


WHITESPACE
    :   [ \t\r\n]+ -> skip
    ;

INTLITERAL
    :   [0-9]+
    ;

FLOATLITERAL
    :   [0-9]*.[0-9]+
    ;

COMMENT
    :   '--'.*;
