package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ListItemParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListItem f145462a = new ListItem();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f145464c;

    public ListItemParser(int i3) {
        this.f145463b = i3;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean b() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        if (!parserState.a()) {
            return parserState.d() >= this.f145463b ? BlockContinue.a(parserState.b() + this.f145463b) : BlockContinue.d();
        }
        if (this.f145462a.d() == null) {
            return BlockContinue.d();
        }
        Block blockE = parserState.f().e();
        this.f145464c = (blockE instanceof Paragraph) || (blockE instanceof ListItem);
        return BlockContinue.b(parserState.e());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145462a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean h(Block block) {
        if (!this.f145464c) {
            return true;
        }
        Block blockG = this.f145462a.g();
        if (!(blockG instanceof ListBlock)) {
            return true;
        }
        ((ListBlock) blockG).q(false);
        return true;
    }
}
