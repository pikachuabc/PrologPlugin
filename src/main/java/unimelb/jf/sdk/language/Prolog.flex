// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package unimelb.jf.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import unimelb.jf.sdk.language.psi.PrologTypes;
import com.intellij.psi.TokenType;

%%

%class PrologLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
//%eof{  return;
//%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("%")[^\r\n]*

INTEGER=[0-9]+
FLOAT=[0-9]+(\.d+)?([Ee][0-9]+)?
PREDICATE=(([:lowercase:])|_)(([:letter:]|[:digit:])|_|-|:)*
CONST=(([:lowercase:])|_)(([:letter:]|[:digit:])|_|-|:)*
ATOM=(([:uppercase:])|_)(([:letter:]|[:digit:])|_)*
OPERATOR=[<=>:!+\\\-*/]+
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")




%state WAITING_VALUE

%%
<YYINITIAL> {

  "="                { return PrologTypes.EQUAL; }
  ";"                { return PrologTypes.SEMI; }
  ","                { return PrologTypes.COMMA; }
  "."                { return PrologTypes.DOT; }
  ":-"               { return PrologTypes.UNIFY; }
  "-->"              { return PrologTypes.EXPAND; }
  "/+"               { return PrologTypes.NOT; }
  "("                { return PrologTypes.LP; }
  ")"                { return PrologTypes.RP; }
  "["                { return PrologTypes.LB; }
  "]"                { return PrologTypes.RB; }
  "{"                { return PrologTypes.LBR; }
  "}"                { return PrologTypes.RBR; }
  "|"                { return PrologTypes.LIST_CONS; }
  "_"                { return PrologTypes.WILDCARD; }
  "is"               { return PrologTypes.ARITH_EVAL; }

}


<YYINITIAL> {STRING}                                        { yybegin(YYINITIAL); return PrologTypes.STRING; }

<YYINITIAL> {OPERATOR}                                      { yybegin(YYINITIAL); return PrologTypes.OPERATOR; }

<YYINITIAL> {ATOM}                                          { yybegin(YYINITIAL); return PrologTypes.ATOM; }

<YYINITIAL> {CONST}                                        { yybegin(YYINITIAL); return PrologTypes.CONST; }

<YYINITIAL> {FLOAT}                                         { yybegin(YYINITIAL); return PrologTypes.FLOAT; }

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return PrologTypes.COMMENT; }

<YYINITIAL> {INTEGER}                                       { yybegin(YYINITIAL); return PrologTypes.INTEGER; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
