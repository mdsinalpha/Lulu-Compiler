grammar Lulu;

//Rules:
program:        ft_dcl? ft_def+;
ft_dcl:         'declare' '{' (func_dcl | type_dcl | var_def)+ '}';
func_dcl:       ('(' args ')' '=')? ('native')? ID '('(args | args_var)? ')' ';';
args:           type ('['']')* |
                args ',' type ('['']')*;
args_var:       type ('['']')* ID |
                args_var ',' type ('['']')* ID;
type_dcl:       ID ';';
var_def:        ('const')? type var_val (','var_val)* ';';
var_val:        ref ('='expr)?;
ft_def:         type_def #TYPE | func_def #FUNC;
type_def:       'type' ID(':' ID)? '{' component+ '}';
component:      ACCSSMOD? (var_def | func_def);
func_def:       ('(' args_var ')' '=')? 'function' ID '(' args_var? ')' block;
block:          '{' (var_def | stmt)* '}';
stmt:           assign ';' #ASSIGN |
                func_call ';' #FUNCTIONC |
                cond_stmt #CONDITION |
                loop_stmt #LOOP |
                'return' ';' #RETURN | 'break' ';' #BREAK | 'continue' ';' #CONTINUE | 'destruct'('['']')* ID ';' #DESTRUCTION;
assign:         (<assoc=right> (var | '(' var (',' var)* ')') '=' expr);
var:            (('this' | 'super')'.')? ref ('.' ref)*;
ref:            ID ('[' expr ']')*;
expr:           '(' expr ')' #PARENTHESES|
                UNARY_OP expr #UNARY_OP | MINUS expr #MINUS |
                expr ARIT_P1 expr #ARIT_P1 |
                expr ARIT_P2 expr #ARIT_P2 | expr MINUS expr #MINUS |
                expr BITWISE_AND expr #BITWISE_AND |
                expr BITWISE_XOR expr #BITWISE_XOR |
                expr BITWISE_OR expr #BITWISE_OR |
                expr REL expr #REL |
                expr REL_EQ expr #REL_EQ |
                expr LOGICAL_AND expr #LOGICAL_AND |
                expr LOGICAL_OR expr #LOGICAL_OR |
                'allocate' handle_call #ALLOCATION |
                func_call #FUNCTION | var #VAR | list #LIST | 'nil' #NIL | const_val #CONST;
func_call:      (var'.')? handle_call #HANDLE |
                'read' '(' var ')' #READ | 'write' '(' var ')' #WRITE;
list:           '[' (expr|list) ( ',' (expr | list))* ']';
handle_call:    ID '(' params? ')';
params:         expr | expr ',' params;
cond_stmt:      'if' expr block ('else' block)? #IF |
                'switch' var '{' ('case' INT_CONST ':' block)* 'default' ':' block '}' #CASE;
loop_stmt:      'for' ( type? assign)? ';' expr ';' assign? block #FOR |
                'while' expr block #WHILE;
const_val:      INT_CONST #INT | REAL_CONST #REAL | BOOL_CONST #BOOL | STRING_CONST #STRING;
type:           PRIM_TYPE #PRIM | ID #ID;

//Tokens:
BOOL_CONST:     'true' | 'false';
PRIM_TYPE:      'int' | 'bool' | 'float' | 'string';
ACCSSMOD:       'private' | 'public' | 'protected';
ID:             LETTER (LETTER | DIGIT) * ;
UNARY_OP:       '!' | '~';
MINUS:          '-';
ARIT_P1:        '*' | '/' | '%';
ARIT_P2:        '+';
BITWISE_AND:    '&';
BITWISE_OR:     '|';
BITWISE_XOR:    '^';
LOGICAL_AND:    '&&';
LOGICAL_OR:     '||';
REL:            '<=' | '>=' | '<' | '>';
REL_EQ:         '==' | '!=';
STRING_CONST:   '\'' (ESCAPE | ~[\\])*? '\'';
REAL_CONST:     REAL_DECIMAL | REAL_HEX;
INT_CONST:      '0'[xX]HEX+ | DIGIT+;

//Fragments:
fragment LETTER:         [a-zA-Z_#];  
fragment DIGIT:          [0-9];
fragment HEX:            [a-fA-F0-9];
fragment ESCAPE:         '\\n' | '\\r' | '\\t' | '\\\\' | '\\0' | '\\"' | '\\' [xX] HEX HEX;
fragment REAL_DECIMAL:   (REAL_DECIMAL_L | REAL_DECIMAL_R) REAL_DECIMAL_EXP?;
fragment REAL_DECIMAL_L: (DIGIT+) '.' (DIGIT+)?;
fragment REAL_DECIMAL_R: (DIGIT+)? '.' (DIGIT+);
fragment REAL_DECIMAL_EXP:([eE]([+-])? DIGIT+);
fragment REAL_HEX:       '0'[xX] (REAL_HEX_L | REAL_HEX_R) REAL_HEX_EXP?;
fragment REAL_HEX_L:     (HEX+) '.' (HEX+)?;
fragment REAL_HEX_R:     (HEX+)? '.' (HEX+);
fragment REAL_HEX_EXP:   ([eE]([+-]) HEX+);

//Skip:
WHITESPACE:   [ \n\t\r] -> skip;
LINE_COMMENT: '%%' .*? ('\n'|EOF) -> skip;
COMMENT:      '%~' .*? '~%' -> skip;


