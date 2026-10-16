package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockQuoteParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockQuote f145368a = new BlockQuote();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int iE = parserState.e();
            if (!BlockQuoteParser.l(parserState, iE)) {
                return BlockStart.c();
            }
            int iB = parserState.b() + parserState.d();
            int i3 = iB + 1;
            if (Parsing.j(parserState.c().a(), iE + 1)) {
                i3 = iB + 2;
            }
            return BlockStart.d(new BlockQuoteParser()).a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(ParserState parserState, int i3) {
        CharSequence charSequenceA = parserState.c().a();
        return parserState.d() < Parsing.f145510a && i3 < charSequenceA.length() && charSequenceA.charAt(i3) == '>';
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean b() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        int iE = parserState.e();
        if (!l(parserState, iE)) {
            return BlockContinue.d();
        }
        int iB = parserState.b() + parserState.d();
        int i3 = iB + 1;
        if (Parsing.j(parserState.c().a(), iE + 1)) {
            i3 = iB + 2;
        }
        return BlockContinue.a(i3);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean h(Block block) {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public BlockQuote e() {
        return this.f145368a;
    }
}
