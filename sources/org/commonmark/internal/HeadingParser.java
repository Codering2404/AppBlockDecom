package org.commonmark.internal;

import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HeadingParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Heading f145414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SourceLines f145415b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            HeadingParser headingParserL;
            if (parserState.d() >= Parsing.f145510a) {
                return BlockStart.c();
            }
            SourceLine sourceLineC = parserState.c();
            int iE = parserState.e();
            if (sourceLineC.a().charAt(iE) == '#' && (headingParserL = HeadingParser.l(sourceLineC.d(iE, sourceLineC.a().length()))) != null) {
                return BlockStart.d(headingParserL).b(sourceLineC.a().length());
            }
            int iM = HeadingParser.m(sourceLineC.a(), iE);
            if (iM > 0) {
                SourceLines sourceLinesB = matchedBlockParser.b();
                if (!sourceLinesB.f()) {
                    return BlockStart.d(new HeadingParser(iM, sourceLinesB)).b(sourceLineC.a().length()).e();
                }
            }
            return BlockStart.c();
        }
    }

    public HeadingParser(int i3, SourceLines sourceLines) {
        Heading heading = new Heading();
        this.f145414a = heading;
        heading.q(i3);
        this.f145415b = sourceLines;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeadingParser l(SourceLine sourceLine) {
        Scanner scannerK = Scanner.k(SourceLines.h(sourceLine));
        int iG = scannerK.g('#');
        if (iG == 0 || iG > 6) {
            return null;
        }
        if (!scannerK.e()) {
            return new HeadingParser(iG, SourceLines.b());
        }
        char cL = scannerK.l();
        if (cL != ' ' && cL != '\t') {
            return null;
        }
        scannerK.r();
        Position positionO = scannerK.o();
        Position positionO2 = positionO;
        loop0: while (true) {
            boolean z2 = true;
            while (scannerK.e()) {
                char cL2 = scannerK.l();
                if (cL2 == '\t' || cL2 == ' ') {
                    scannerK.h();
                } else {
                    if (cL2 != '#') {
                        scannerK.h();
                        positionO2 = scannerK.o();
                    } else if (z2) {
                        scannerK.g('#');
                        int iR = scannerK.r();
                        if (scannerK.e()) {
                            positionO2 = scannerK.o();
                        }
                        if (iR > 0) {
                            break;
                        }
                    } else {
                        scannerK.h();
                        positionO2 = scannerK.o();
                    }
                    z2 = false;
                }
            }
            break loop0;
        }
        SourceLines sourceLinesD = scannerK.d(positionO, positionO2);
        return sourceLinesD.c().isEmpty() ? new HeadingParser(iG, SourceLines.b()) : new HeadingParser(iG, sourceLinesD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(CharSequence charSequence, int i3) {
        char cCharAt = charSequence.charAt(i3);
        if (cCharAt != '-') {
            if (cCharAt != '=') {
                return 0;
            }
            if (n(charSequence, i3 + 1, '=')) {
                return 1;
            }
        }
        return n(charSequence, i3 + 1, '-') ? 2 : 0;
    }

    private static boolean n(CharSequence charSequence, int i3, char c3) {
        return Parsing.o(charSequence, Parsing.m(c3, charSequence, i3, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
        inlineParser.a(this.f145415b, this.f145414a);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        return BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145414a;
    }
}
