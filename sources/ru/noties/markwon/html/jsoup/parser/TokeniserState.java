package ru.noties.markwon.html.jsoup.parser;

import ru.noties.markwon.html.jsoup.parser.Token;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
enum TokeniserState {
    Data { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.1
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                tokeniser.i(characterReader.d());
            } else {
                if (cQ == '&') {
                    tokeniser.a(TokeniserState.CharacterReferenceInData);
                    return;
                }
                if (cQ == '<') {
                    tokeniser.a(TokeniserState.TagOpen);
                } else if (cQ != 65535) {
                    tokeniser.j(characterReader.e());
                } else {
                    tokeniser.k(new Token.EOF());
                }
            }
        }
    },
    CharacterReferenceInData { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.2
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.j(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.3
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i((char) 65533);
            } else {
                if (cQ == '&') {
                    tokeniser.a(TokeniserState.CharacterReferenceInRcdata);
                    return;
                }
                if (cQ == '<') {
                    tokeniser.a(TokeniserState.RcdataLessthanSign);
                } else if (cQ != 65535) {
                    tokeniser.j(characterReader.m('&', '<', 0));
                } else {
                    tokeniser.k(new Token.EOF());
                }
            }
        }
    },
    CharacterReferenceInRcdata { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.4
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.j(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.5
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.k(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.6
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.k(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.7
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i((char) 65533);
            } else if (cQ != 65535) {
                tokeniser.j(characterReader.k((char) 0));
            } else {
                tokeniser.k(new Token.EOF());
            }
        }
    },
    TagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.8
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == '!') {
                tokeniser.a(TokeniserState.MarkupDeclarationOpen);
                return;
            }
            if (cQ == '/') {
                tokeniser.a(TokeniserState.EndTagOpen);
                return;
            }
            if (cQ == '?') {
                tokeniser.a(TokeniserState.BogusComment);
                return;
            }
            if (characterReader.C()) {
                tokeniser.g(true);
                tokeniser.u(TokeniserState.TagName);
            } else {
                tokeniser.r(this);
                tokeniser.i('<');
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    EndTagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.9
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.j("</");
                tokeniser.u(TokeniserState.Data);
            } else if (characterReader.C()) {
                tokeniser.g(false);
                tokeniser.u(TokeniserState.TagName);
            } else if (characterReader.w('>')) {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.Data);
            } else {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.BogusComment);
            }
        }
    },
    TagName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.10
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.f147272i.i(characterReader.j());
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.f147272i.i(TokeniserState.f147321u0);
                return;
            }
            if (cD != ' ') {
                if (cD == '/') {
                    tokeniser.u(TokeniserState.SelfClosingStartTag);
                    return;
                }
                if (cD == '>') {
                    tokeniser.o();
                    tokeniser.u(TokeniserState.Data);
                    return;
                } else if (cD == 65535) {
                    tokeniser.p(this);
                    tokeniser.u(TokeniserState.Data);
                    return;
                } else if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    tokeniser.f147272i.h(cD);
                    return;
                }
            }
            tokeniser.u(TokeniserState.BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.11
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.w('/')) {
                tokeniser.h();
                tokeniser.a(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.C() && tokeniser.b() != null) {
                if (!characterReader.p("</" + tokeniser.b())) {
                    tokeniser.f147272i = tokeniser.g(false).m(tokeniser.b());
                    tokeniser.o();
                    characterReader.I();
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
            }
            tokeniser.j("<");
            tokeniser.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.12
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.C()) {
                tokeniser.j("</");
                tokeniser.u(TokeniserState.Rcdata);
            } else {
                tokeniser.g(false);
                tokeniser.f147272i.h(characterReader.q());
                tokeniser.f147271h.append(characterReader.q());
                tokeniser.a(TokeniserState.RCDATAEndTagName);
            }
        }
    },
    RCDATAEndTagName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.13
        private void m(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.j("</" + tokeniser.f147271h.toString());
            characterReader.I();
            tokeniser.u(TokeniserState.Rcdata);
        }

        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.C()) {
                String strH = characterReader.h();
                tokeniser.f147272i.i(strH);
                tokeniser.f147271h.append(strH);
                return;
            }
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                if (tokeniser.s()) {
                    tokeniser.u(TokeniserState.BeforeAttributeName);
                    return;
                } else {
                    m(tokeniser, characterReader);
                    return;
                }
            }
            if (cD == '/') {
                if (tokeniser.s()) {
                    tokeniser.u(TokeniserState.SelfClosingStartTag);
                    return;
                } else {
                    m(tokeniser, characterReader);
                    return;
                }
            }
            if (cD != '>') {
                m(tokeniser, characterReader);
            } else if (!tokeniser.s()) {
                m(tokeniser, characterReader);
            } else {
                tokeniser.o();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    RawtextLessthanSign { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.14
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.w('/')) {
                tokeniser.h();
                tokeniser.a(TokeniserState.RawtextEndTagOpen);
            } else {
                tokeniser.i('<');
                tokeniser.u(TokeniserState.Rawtext);
            }
        }
    },
    RawtextEndTagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.15
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.16
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.h(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.17
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '!') {
                tokeniser.j("<!");
                tokeniser.u(TokeniserState.ScriptDataEscapeStart);
            } else if (cD == '/') {
                tokeniser.h();
                tokeniser.u(TokeniserState.ScriptDataEndTagOpen);
            } else {
                tokeniser.j("<");
                characterReader.I();
                tokeniser.u(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.18
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.19
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.h(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.20
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.w('-')) {
                tokeniser.u(TokeniserState.ScriptData);
            } else {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapeStartDash);
            }
        }
    },
    ScriptDataEscapeStartDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.21
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.w('-')) {
                tokeniser.u(TokeniserState.ScriptData);
            } else {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapedDashDash);
            }
        }
    },
    ScriptDataEscaped { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.22
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i((char) 65533);
            } else if (cQ == '-') {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapedDash);
            } else if (cQ != '<') {
                tokeniser.j(characterReader.m('-', '<', 0));
            } else {
                tokeniser.a(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.23
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.i((char) 65533);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else if (cD == '-') {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataEscapedDashDash);
            } else if (cD == '<') {
                tokeniser.u(TokeniserState.ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.24
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.i((char) 65533);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else {
                if (cD == '-') {
                    tokeniser.i(cD);
                    return;
                }
                if (cD == '<') {
                    tokeniser.u(TokeniserState.ScriptDataEscapedLessthanSign);
                } else if (cD != '>') {
                    tokeniser.i(cD);
                    tokeniser.u(TokeniserState.ScriptDataEscaped);
                } else {
                    tokeniser.i(cD);
                    tokeniser.u(TokeniserState.ScriptData);
                }
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.25
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.C()) {
                if (characterReader.w('/')) {
                    tokeniser.h();
                    tokeniser.a(TokeniserState.ScriptDataEscapedEndTagOpen);
                    return;
                } else {
                    tokeniser.i('<');
                    tokeniser.u(TokeniserState.ScriptDataEscaped);
                    return;
                }
            }
            tokeniser.h();
            tokeniser.f147271h.append(characterReader.q());
            tokeniser.j("<" + characterReader.q());
            tokeniser.a(TokeniserState.ScriptDataDoubleEscapeStart);
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.26
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.C()) {
                tokeniser.j("</");
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.g(false);
                tokeniser.f147272i.h(characterReader.q());
                tokeniser.f147271h.append(characterReader.q());
                tokeniser.a(TokeniserState.ScriptDataEscapedEndTagName);
            }
        }
    },
    ScriptDataEscapedEndTagName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.27
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.h(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.28
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.g(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.29
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i((char) 65533);
            } else if (cQ == '-') {
                tokeniser.i(cQ);
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (cQ == '<') {
                tokeniser.i(cQ);
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cQ != 65535) {
                tokeniser.j(characterReader.m('-', '<', 0));
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.30
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.i((char) 65533);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (cD == '-') {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (cD == '<') {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cD != 65535) {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.31
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.i((char) 65533);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            if (cD == '-') {
                tokeniser.i(cD);
                return;
            }
            if (cD == '<') {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (cD == '>') {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptData);
            } else if (cD != 65535) {
                tokeniser.i(cD);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.32
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.w('/')) {
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            tokeniser.i('/');
            tokeniser.h();
            tokeniser.a(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.33
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.g(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.34
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.n();
                characterReader.I();
                tokeniser.u(TokeniserState.AttributeName);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.o();
                            tokeniser.u(TokeniserState.Data);
                            break;
                        default:
                            tokeniser.f147272i.n();
                            characterReader.I();
                            tokeniser.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                tokeniser.r(this);
                tokeniser.f147272i.n();
                tokeniser.f147272i.c(cD);
                tokeniser.u(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.35
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.f147272i.d(characterReader.n(TokeniserState.f147317s0));
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.c((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        switch (cD) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.u(TokeniserState.L);
                                break;
                            case '>':
                                tokeniser.o();
                                tokeniser.u(TokeniserState.Data);
                                break;
                            default:
                                tokeniser.f147272i.c(cD);
                                break;
                        }
                        return;
                    }
                }
                tokeniser.r(this);
                tokeniser.f147272i.c(cD);
                return;
            }
            tokeniser.u(TokeniserState.AfterAttributeName);
        }
    },
    AfterAttributeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.36
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.c((char) 65533);
                tokeniser.u(TokeniserState.AttributeName);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '\'') {
                    if (cD == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (cD == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    switch (cD) {
                        case '<':
                            break;
                        case '=':
                            tokeniser.u(TokeniserState.L);
                            break;
                        case '>':
                            tokeniser.o();
                            tokeniser.u(TokeniserState.Data);
                            break;
                        default:
                            tokeniser.f147272i.n();
                            characterReader.I();
                            tokeniser.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                tokeniser.r(this);
                tokeniser.f147272i.n();
                tokeniser.f147272i.c(cD);
                tokeniser.u(TokeniserState.AttributeName);
            }
        }
    },
    L { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.37
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.e((char) 65533);
                tokeniser.u(TokeniserState.AttributeValue_unquoted);
                return;
            }
            if (cD != ' ') {
                if (cD == '\"') {
                    tokeniser.u(TokeniserState.AttributeValue_doubleQuoted);
                    return;
                }
                if (cD != '`') {
                    if (cD == 65535) {
                        tokeniser.p(this);
                        tokeniser.o();
                        tokeniser.u(TokeniserState.Data);
                        return;
                    }
                    if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                        return;
                    }
                    if (cD == '&') {
                        characterReader.I();
                        tokeniser.u(TokeniserState.AttributeValue_unquoted);
                        return;
                    }
                    if (cD == '\'') {
                        tokeniser.u(TokeniserState.AttributeValue_singleQuoted);
                        return;
                    }
                    switch (cD) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.r(this);
                            tokeniser.o();
                            tokeniser.u(TokeniserState.Data);
                            break;
                        default:
                            characterReader.I();
                            tokeniser.u(TokeniserState.AttributeValue_unquoted);
                            break;
                    }
                    return;
                }
                tokeniser.r(this);
                tokeniser.f147272i.e(cD);
                tokeniser.u(TokeniserState.AttributeValue_unquoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.38
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            String strM = characterReader.m(TokeniserState.f147315r0);
            if (strM.length() > 0) {
                tokeniser.f147272i.f(strM);
            } else {
                tokeniser.f147272i.p();
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.e((char) 65533);
                return;
            }
            if (cD == '\"') {
                tokeniser.u(TokeniserState.AfterAttributeValue_quoted);
                return;
            }
            if (cD != '&') {
                if (cD != 65535) {
                    tokeniser.f147272i.e(cD);
                    return;
                } else {
                    tokeniser.p(this);
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
            }
            int[] iArrD = tokeniser.d('\"', true);
            if (iArrD != null) {
                tokeniser.f147272i.g(iArrD);
            } else {
                tokeniser.f147272i.e('&');
            }
        }
    },
    AttributeValue_singleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.39
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            String strM = characterReader.m(TokeniserState.f147313q0);
            if (strM.length() > 0) {
                tokeniser.f147272i.f(strM);
            } else {
                tokeniser.f147272i.p();
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.e((char) 65533);
                return;
            }
            if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != '&') {
                if (cD != '\'') {
                    tokeniser.f147272i.e(cD);
                    return;
                } else {
                    tokeniser.u(TokeniserState.AfterAttributeValue_quoted);
                    return;
                }
            }
            int[] iArrD = tokeniser.d('\'', true);
            if (iArrD != null) {
                tokeniser.f147272i.g(iArrD);
            } else {
                tokeniser.f147272i.e('&');
            }
        }
    },
    AttributeValue_unquoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.40
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            String strN = characterReader.n(TokeniserState.f147319t0);
            if (strN.length() > 0) {
                tokeniser.f147272i.f(strN);
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147272i.e((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD != '\"' && cD != '`') {
                    if (cD == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    }
                    if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                        if (cD == '&') {
                            int[] iArrD = tokeniser.d('>', true);
                            if (iArrD != null) {
                                tokeniser.f147272i.g(iArrD);
                                return;
                            } else {
                                tokeniser.f147272i.e('&');
                                return;
                            }
                        }
                        if (cD != '\'') {
                            switch (cD) {
                                case '<':
                                case '=':
                                    break;
                                case '>':
                                    tokeniser.o();
                                    tokeniser.u(TokeniserState.Data);
                                    break;
                                default:
                                    tokeniser.f147272i.e(cD);
                                    break;
                            }
                            return;
                        }
                    }
                }
                tokeniser.r(this);
                tokeniser.f147272i.e(cD);
                return;
            }
            tokeniser.u(TokeniserState.BeforeAttributeName);
        }
    },
    AfterAttributeValue_quoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.41
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(TokeniserState.BeforeAttributeName);
                return;
            }
            if (cD == '/') {
                tokeniser.u(TokeniserState.SelfClosingStartTag);
                return;
            }
            if (cD == '>') {
                tokeniser.o();
                tokeniser.u(TokeniserState.Data);
            } else if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            } else {
                tokeniser.r(this);
                characterReader.I();
                tokeniser.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    SelfClosingStartTag { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.42
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '>') {
                tokeniser.f147272i.f147253i = true;
                tokeniser.o();
                tokeniser.u(TokeniserState.Data);
            } else if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            } else {
                tokeniser.r(this);
                characterReader.I();
                tokeniser.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    BogusComment { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.43
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.I();
            Token.Comment comment = new Token.Comment();
            comment.f147240c = true;
            comment.f147239b.append(characterReader.k('>'));
            tokeniser.k(comment);
            tokeniser.a(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.44
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.u("--")) {
                tokeniser.e();
                tokeniser.u(TokeniserState.CommentStart);
            } else if (characterReader.v("DOCTYPE")) {
                tokeniser.u(TokeniserState.Doctype);
            } else if (characterReader.u("[CDATA[")) {
                tokeniser.h();
                tokeniser.u(TokeniserState.CdataSection);
            } else {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.45
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147277n.f147239b.append((char) 65533);
                tokeniser.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                tokeniser.u(TokeniserState.CommentStartDash);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (cD != 65535) {
                tokeniser.f147277n.f147239b.append(cD);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentStartDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.46
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147277n.f147239b.append((char) 65533);
                tokeniser.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                tokeniser.u(TokeniserState.CommentStartDash);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (cD != 65535) {
                tokeniser.f147277n.f147239b.append(cD);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    Comment { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.47
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cQ = characterReader.q();
            if (cQ == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.f147277n.f147239b.append((char) 65533);
            } else if (cQ == '-') {
                tokeniser.a(TokeniserState.CommentEndDash);
            } else {
                if (cQ != 65535) {
                    tokeniser.f147277n.f147239b.append(characterReader.m('-', 0));
                    return;
                }
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.48
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f147277n.f147239b;
                sb.append('-');
                sb.append((char) 65533);
                tokeniser.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                tokeniser.u(TokeniserState.CommentEnd);
                return;
            }
            if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else {
                StringBuilder sb2 = tokeniser.f147277n.f147239b;
                sb2.append('-');
                sb2.append(cD);
                tokeniser.u(TokeniserState.Comment);
            }
        }
    },
    CommentEnd { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.49
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f147277n.f147239b;
                sb.append("--");
                sb.append((char) 65533);
                tokeniser.u(TokeniserState.Comment);
                return;
            }
            if (cD == '!') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.CommentEndBang);
                return;
            }
            if (cD == '-') {
                tokeniser.r(this);
                tokeniser.f147277n.f147239b.append('-');
                return;
            }
            if (cD == '>') {
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else {
                tokeniser.r(this);
                StringBuilder sb2 = tokeniser.f147277n.f147239b;
                sb2.append("--");
                sb2.append(cD);
                tokeniser.u(TokeniserState.Comment);
            }
        }
    },
    CommentEndBang { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.50
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f147277n.f147239b;
                sb.append("--!");
                sb.append((char) 65533);
                tokeniser.u(TokeniserState.Comment);
                return;
            }
            if (cD == '-') {
                tokeniser.f147277n.f147239b.append("--!");
                tokeniser.u(TokeniserState.CommentEndDash);
                return;
            }
            if (cD == '>') {
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (cD == 65535) {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else {
                StringBuilder sb2 = tokeniser.f147277n.f147239b;
                sb2.append("--!");
                sb2.append(cD);
                tokeniser.u(TokeniserState.Comment);
            }
        }
    },
    Doctype { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.51
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (cD != '>') {
                if (cD != 65535) {
                    tokeniser.r(this);
                    tokeniser.u(TokeniserState.BeforeDoctypeName);
                    return;
                }
                tokeniser.p(this);
            }
            tokeniser.r(this);
            tokeniser.f();
            tokeniser.f147276m.f147245f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    BeforeDoctypeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.52
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.C()) {
                tokeniser.f();
                tokeniser.u(TokeniserState.DoctypeName);
                return;
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f();
                tokeniser.f147276m.f147241b.append((char) 65533);
                tokeniser.u(TokeniserState.DoctypeName);
                return;
            }
            if (cD != ' ') {
                if (cD == 65535) {
                    tokeniser.p(this);
                    tokeniser.f();
                    tokeniser.f147276m.f147245f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
                if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r') {
                    return;
                }
                tokeniser.f();
                tokeniser.f147276m.f147241b.append(cD);
                tokeniser.u(TokeniserState.DoctypeName);
            }
        }
    },
    DoctypeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.53
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.C()) {
                tokeniser.f147276m.f147241b.append(characterReader.h());
                return;
            }
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147276m.f147241b.append((char) 65533);
                return;
            }
            if (cD != ' ') {
                if (cD == '>') {
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
                if (cD == 65535) {
                    tokeniser.p(this);
                    tokeniser.f147276m.f147245f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
                if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r') {
                    tokeniser.f147276m.f147241b.append(cD);
                    return;
                }
            }
            tokeniser.u(TokeniserState.AfterDoctypeName);
        }
    },
    AfterDoctypeName { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.54
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (characterReader.y('\t', '\n', '\r', '\f', ' ')) {
                characterReader.a();
                return;
            }
            if (characterReader.w('>')) {
                tokeniser.n();
                tokeniser.a(TokeniserState.Data);
                return;
            }
            if (characterReader.v("PUBLIC")) {
                tokeniser.f147276m.f147242c = "PUBLIC";
                tokeniser.u(TokeniserState.AfterDoctypePublicKeyword);
            } else if (characterReader.v("SYSTEM")) {
                tokeniser.f147276m.f147242c = "SYSTEM";
                tokeniser.u(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.a(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.55
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypePublicIdentifier);
                return;
            }
            if (cD == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.56
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.57
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147276m.f147243d.append((char) 65533);
                return;
            }
            if (cD == '\"') {
                tokeniser.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.f147276m.f147243d.append(cD);
                return;
            }
            tokeniser.p(this);
            tokeniser.f147276m.f147245f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.58
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147276m.f147243d.append((char) 65533);
                return;
            }
            if (cD == '\'') {
                tokeniser.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.f147276m.f147243d.append(cD);
                return;
            }
            tokeniser.p(this);
            tokeniser.f147276m.f147245f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    AfterDoctypePublicIdentifier { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.59
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (cD == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.60
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.61
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypeSystemIdentifier);
                return;
            }
            if (cD == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.62
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '\"') {
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cD == '\'') {
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.63
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147276m.f147244e.append((char) 65533);
                return;
            }
            if (cD == '\"') {
                tokeniser.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.f147276m.f147244e.append(cD);
                return;
            }
            tokeniser.p(this);
            tokeniser.f147276m.f147245f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.64
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == 0) {
                tokeniser.r(this);
                tokeniser.f147276m.f147244e.append((char) 65533);
                return;
            }
            if (cD == '\'') {
                tokeniser.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (cD == '>') {
                tokeniser.r(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
                return;
            }
            if (cD != 65535) {
                tokeniser.f147276m.f147244e.append(cD);
                return;
            }
            tokeniser.p(this);
            tokeniser.f147276m.f147245f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.65
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                return;
            }
            if (cD == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (cD != 65535) {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f147276m.f147245f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BogusDoctype { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.66
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            char cD = characterReader.d();
            if (cD == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else {
                if (cD != 65535) {
                    return;
                }
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: ru.noties.markwon.html.jsoup.parser.TokeniserState.67
        @Override // ru.noties.markwon.html.jsoup.parser.TokeniserState
        void i(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.f147271h.append(characterReader.l("]]>"));
            if (characterReader.u("]]>") || characterReader.r()) {
                tokeniser.k(new Token.CData(tokeniser.f147271h.toString()));
                tokeniser.u(TokeniserState.Data);
            }
        }
    };


    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    static final char[] f147313q0 = {0, '&', '\''};

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    static final char[] f147315r0 = {0, '\"', '&'};

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    static final char[] f147317s0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    static final char[] f147319t0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final String f147321u0 = String.valueOf((char) 65533);

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.C()) {
            String strH = characterReader.h();
            tokeniser.f147271h.append(strH);
            tokeniser.j(strH);
            return;
        }
        char cD = characterReader.d();
        if (cD != '\t' && cD != '\n' && cD != '\f' && cD != '\r' && cD != ' ' && cD != '/' && cD != '>') {
            characterReader.I();
            tokeniser.u(tokeniserState2);
        } else {
            if (tokeniser.f147271h.toString().equals("script")) {
                tokeniser.u(tokeniserState);
            } else {
                tokeniser.u(tokeniserState2);
            }
            tokeniser.i(cD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.C()) {
            String strH = characterReader.h();
            tokeniser.f147272i.i(strH);
            tokeniser.f147271h.append(strH);
            return;
        }
        if (tokeniser.s() && !characterReader.r()) {
            char cD = characterReader.d();
            if (cD == '\t' || cD == '\n' || cD == '\f' || cD == '\r' || cD == ' ') {
                tokeniser.u(BeforeAttributeName);
                return;
            }
            if (cD == '/') {
                tokeniser.u(SelfClosingStartTag);
                return;
            } else {
                if (cD == '>') {
                    tokeniser.o();
                    tokeniser.u(Data);
                    return;
                }
                tokeniser.f147271h.append(cD);
            }
        }
        tokeniser.j("</" + tokeniser.f147271h.toString());
        tokeniser.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] iArrD = tokeniser.d(null, false);
        if (iArrD == null) {
            tokeniser.i('&');
        } else {
            tokeniser.l(iArrD);
        }
        tokeniser.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char cQ = characterReader.q();
        if (cQ == 0) {
            tokeniser.r(tokeniserState);
            characterReader.a();
            tokeniser.i((char) 65533);
        } else if (cQ == '<') {
            tokeniser.a(tokeniserState2);
        } else if (cQ != 65535) {
            tokeniser.j(characterReader.m('<', 0));
        } else {
            tokeniser.k(new Token.EOF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.C()) {
            tokeniser.g(false);
            tokeniser.u(tokeniserState);
        } else {
            tokeniser.j("</");
            tokeniser.u(tokeniserState2);
        }
    }

    abstract void i(Tokeniser tokeniser, CharacterReader characterReader);
}
