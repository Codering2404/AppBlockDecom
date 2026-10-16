package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ParagraphParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paragraph f145465a = new Paragraph();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkReferenceDefinitionParser f145466b = new LinkReferenceDefinitionParser();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
        SourceLines sourceLinesE = this.f145466b.e();
        if (sourceLinesE.f()) {
            return;
        }
        inlineParser.a(sourceLinesE, this.f145465a);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        return !parserState.a() ? BlockContinue.b(parserState.getIndex()) : BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean d() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145465a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void f(SourceSpan sourceSpan) {
        this.f145466b.a(sourceSpan);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void g(SourceLine sourceLine) {
        this.f145466b.h(sourceLine);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void i() {
        if (this.f145466b.e().f()) {
            this.f145465a.n();
        } else {
            this.f145465a.l(this.f145466b.f());
        }
    }

    public List j() {
        return this.f145466b.d();
    }

    public SourceLines k() {
        return this.f145466b.e();
    }
}
