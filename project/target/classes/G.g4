grammar G;

/* Parser rules */
/* Program */
program : KEYWORD id 'BEGIN' pgm_body 'END';
id: IDENTIFIER;
pgm_body: decl func_declarations;
decl: string_decl decl | var_decl decl | WS;

/* Global String Declaration */
string_decl: STRINGLITERAL id ':=' str;
str : STRINGLITERAL;

/* Variable Declaration */
var_decl: var_type id_list;
var_type: 'FLOAT' | 'INT';
any_type: var_type | 'VOID';
id_list: id id_tail;
id_tail: ',' id id_tail | WS;

/* Function Paramater List */
param_decl_list: param_decl param_decl_tail | WS;
param_decl: var_type id;
param_decl_tail: ',' param_decl param_decl_tail | WS;

/* Function Declarations */
func_declarations: func_decl func_declarations | WS;
func_decl: 'FUNCTION' any_type id (param_decl_list) 'BEGIN' func_body 'END';
func_body: decl stmt_list;

/* Statement List */
stmt_list: stmt stmt_list | WS;
stmt: base_stmt | if_stmt | while_stmt;
base_stmt: assign_stmt | read_stmt | write_stmt | return_stmt;

/* Basic Statements */
assign_stmt: assign_expr;
assign_expr: id ':=' expr;
read_stmt: 'READ' ( id_list );
write_stmt: 'WRITE' ( id_list );
return_stmt: 'RETURN' expr;

/* Expressions */

expr: expr_prefix factor;
expr_prefix: expr_prefix factor addop | WS;
factor: factor_prefix postfix_expr;
factor_prefix: factor_prefix postfix_expr mulop | WS;
postfix_expr: primary | call_expr;
call_expr: id ( expr_list );
expr_list: expr expr_list_tail | WS;
expr_list_tail: ',' expr expr_list_tail | WS;
addop: '+' | '-';
mulop: '*' | '/';
primary: ( expr ) | id | INTLITERAL | FLOATLITERAL;


/* Complex Statements and Condition */ 
if_stmt: 'IF' ( cond ) decl stmt_list else_part 'ENDIF';
else_part: 'ELSE' decl stmt_list | WS;
cond: expr compop expr;
compop: '<' | '>' | '=' | '!=' | '<=' | '>=';

/* While statements */
while_stmt: 'WHILE' ( cond ) decl stmt_list 'ENDWHILE';


/* Token rules */

inputFile: (WS | INTLITERAL | FLOATLITERAL | COMMENT |KEYWORD | OPERATOR)+;

KEYWORD
    :   ('PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|
'IF'|'ELSE'|'ENDIF'|'WHILE'|'ENDWHILE'|'CONTINUE'|'BREAK'|
'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT')
    ;

WS
    :   (' ' | '\t' | '\r' | '\n')+ -> skip
    ;

INTLITERAL
    :   [0-9]+
    ;

FLOATLITERAL
    :   [-+]?[0-9]*'.'[0-9]+
    ;

STRINGLITERAL
   :   '"'.*?'"'
   ;

IDENTIFIER
    :   [A-Za-z0-9]+
    ;

OPERATOR
    :   ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>='
    ;

COMMENT
    : '--'.*?'\n' -> skip
    ;



