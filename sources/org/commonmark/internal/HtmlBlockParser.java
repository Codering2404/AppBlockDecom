package org.commonmark.internal;

import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
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
public class HtmlBlockParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern[][] f145416e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style|textarea)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style|textarea)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HtmlBlock f145417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pattern f145418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f145419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BlockContent f145420d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int iE = parserState.e();
            CharSequence charSequenceA = parserState.c().a();
            if (parserState.d() < 4 && charSequenceA.charAt(iE) == '<') {
                for (int i3 = 1; i3 <= 7; i3++) {
                    if (i3 != 7 || (!(matchedBlockParser.a().e() instanceof Paragraph) && !parserState.f().d())) {
                        Pattern pattern = HtmlBlockParser.f145416e[i3][0];
                        Pattern pattern2 = HtmlBlockParser.f145416e[i3][1];
                        if (pattern.matcher(charSequenceA.subSequence(iE, charSequenceA.length())).find()) {
                            return BlockStart.d(new HtmlBlockParser(pattern2)).b(parserState.getIndex());
                        }
                    }
                }
            }
            return BlockStart.c();
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        return this.f145419c ? BlockContinue.d() : (parserState.a() && this.f145418b == null) ? BlockContinue.d() : BlockContinue.b(parserState.getIndex());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145417a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void g(SourceLine sourceLine) {
        this.f145420d.a(sourceLine.a());
        Pattern pattern = this.f145418b;
        if (pattern == null || !pattern.matcher(sourceLine.a()).find()) {
            return;
        }
        this.f145419c = true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void i() {
        this.f145417a.q(this.f145420d.b());
        this.f145420d = null;
    }

    private HtmlBlockParser(Pattern pattern) {
        this.f145417a = new HtmlBlock();
        this.f145419c = false;
        this.f145420d = new BlockContent();
        this.f145418b = pattern;
    }
}
