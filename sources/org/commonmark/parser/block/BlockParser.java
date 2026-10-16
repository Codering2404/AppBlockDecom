package org.commonmark.parser.block;

import org.commonmark.node.Block;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface BlockParser {
    void a(InlineParser inlineParser);

    boolean b();

    BlockContinue c(ParserState parserState);

    boolean d();

    Block e();

    void f(SourceSpan sourceSpan);

    void g(SourceLine sourceLine);

    boolean h(Block block);

    void i();
}
