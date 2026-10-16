package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class IndentedCodeBlockParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IndentedCodeBlock f145421a = new IndentedCodeBlock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f145422b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            return (parserState.d() < Parsing.f145510a || parserState.a() || (parserState.f().e() instanceof Paragraph)) ? BlockStart.c() : BlockStart.d(new IndentedCodeBlockParser()).a(parserState.b() + Parsing.f145510a);
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        return parserState.d() >= Parsing.f145510a ? BlockContinue.a(parserState.b() + Parsing.f145510a) : parserState.a() ? BlockContinue.b(parserState.e()) : BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145421a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void g(SourceLine sourceLine) {
        this.f145422b.add(sourceLine.a());
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void i() {
        int size = this.f145422b.size() - 1;
        while (size >= 0 && Parsing.f((CharSequence) this.f145422b.get(size))) {
            size--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < size + 1; i3++) {
            sb.append((CharSequence) this.f145422b.get(i3));
            sb.append('\n');
        }
        this.f145421a.q(sb.toString());
    }
}
