lexer grammar Nib;

/*
 * Lexer
 */

WS
    :   (' ' | '\t' | '\r' | '\n')+ -> skip
    ;

INTLITERAL 
    :   [0-9]+
    ;

FLOATLITERAL
    :   [0-9]*.[0-9]+
    ;

//STRINGLITERAL
//    :   \"([~\\\"]|\\.)*\"|\'([~\\']|\\.)*\' 
//    ;

IDENTIFIER
    :   [A-Za-z0-9]+
    ;

OPERATOR
    :   (':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=')
    ;

COMMENT
    : '--.*\\n' -> skip
    ;

KEYWORDS
    :   ('PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|
'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONTINUE'|'BREAK'|
'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT')
    ;