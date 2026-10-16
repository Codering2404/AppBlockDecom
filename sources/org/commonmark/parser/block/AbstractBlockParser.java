package org.commonmark.parser.block;

import org.commonmark.node.Block;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractBlockParser implements BlockParser {
    @Override // org.commonmark.parser.block.BlockParser
    public boolean b() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean d() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void f(SourceSpan sourceSpan) {
        e().b(sourceSpan);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean h(Block block) {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void i() {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void g(SourceLine sourceLine) {
    }
}
