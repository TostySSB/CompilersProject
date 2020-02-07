grammar grammar;
WHITESPACE
    :   [ \t\r\n]+ -> skip
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
    :   [('A'-'Z')('a'-'z')('0'-'9')]+
    ;

OPERATOR
    :   (':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=')
    ;

COMMENT
    : '--'.*'\n' -> skip
    ;

KEYWORDS
    :   ('PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|
'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONT'I'NUE'|'BREAK'|
'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT')
    ;