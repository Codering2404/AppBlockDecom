package org.commonmark.internal;

import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class FencedCodeBlockParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FencedCodeBlock f145411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f145412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f145413c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int iD = parserState.d();
            if (iD >= Parsing.f145510a) {
                return BlockStart.c();
            }
            int iE = parserState.e();
            FencedCodeBlockParser fencedCodeBlockParserL = FencedCodeBlockParser.l(parserState.c().a(), iE, iD);
            return fencedCodeBlockParserL != null ? BlockStart.d(fencedCodeBlockParserL).b(iE + fencedCodeBlockParserL.f145411a.r()) : BlockStart.c();
        }
    }

    public FencedCodeBlockParser(char c3, int i3, int i4) {
        FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
        this.f145411a = fencedCodeBlock;
        this.f145413c = new StringBuilder();
        fencedCodeBlock.u(c3);
        fencedCodeBlock.w(i3);
        fencedCodeBlock.v(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FencedCodeBlockParser l(CharSequence charSequence, int i3, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = i3; i7 < length; i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt == '`') {
                i5++;
            } else {
                if (cCharAt != '~') {
                    break;
                }
                i6++;
            }
        }
        if (i5 >= 3 && i6 == 0) {
            if (Parsing.b('`', charSequence, i3 + i5) != -1) {
                return null;
            }
            return new FencedCodeBlockParser('`', i5, i4);
        }
        if (i6 < 3 || i5 != 0) {
            return null;
        }
        return new FencedCodeBlockParser('~', i6, i4);
    }

    private boolean m(CharSequence charSequence, int i3) {
        char cP = this.f145411a.p();
        int iR = this.f145411a.r();
        int iM = Parsing.m(cP, charSequence, i3, charSequence.length()) - i3;
        return iM >= iR && Parsing.o(charSequence, i3 + iM, charSequence.length()) == charSequence.length();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        int iE = parserState.e();
        int index = parserState.getIndex();
        CharSequence charSequenceA = parserState.c().a();
        if (parserState.d() < Parsing.f145510a && iE < charSequenceA.length() && charSequenceA.charAt(iE) == this.f145411a.p() && m(charSequenceA, iE)) {
            return BlockContinue.c();
        }
        int length = charSequenceA.length();
        for (int iQ = this.f145411a.q(); iQ > 0 && index < length && charSequenceA.charAt(index) == ' '; iQ--) {
            index++;
        }
        return BlockContinue.b(index);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145411a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void g(SourceLine sourceLine) {
        if (this.f145412b == null) {
            this.f145412b = sourceLine.a().toString();
        } else {
            this.f145413c.append(sourceLine.a());
            this.f145413c.append('\n');
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void i() {
        this.f145411a.x(Escaping.f(this.f145412b.trim()));
        this.f145411a.y(this.f145413c.toString());
    }
}
