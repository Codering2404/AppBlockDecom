package org.commonmark.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.SourceSpan;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.IncludeSourceSpans;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentParser implements ParserState {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Set f145389r = new LinkedHashSet(Arrays.asList(BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Map f145390s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SourceLine f145391a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f145395e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f145399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f145400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final InlineParserFactory f145401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f145402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final IncludeSourceSpans f145403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final DocumentBlockParser f145404n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145392b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145393c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f145394d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f145396f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f145397g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f145398h = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final LinkReferenceDefinitions f145405o = new LinkReferenceDefinitions();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f145406p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f145407q = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MatchedBlockParserImpl implements MatchedBlockParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockParser f145408a;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.f145408a = blockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public BlockParser a() {
            return this.f145408a;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public SourceLines b() {
            BlockParser blockParser = this.f145408a;
            return blockParser instanceof ParagraphParser ? ((ParagraphParser) blockParser).k() : SourceLines.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OpenBlockParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockParser f145409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f145410b;

        OpenBlockParser(BlockParser blockParser, int i3) {
            this.f145409a = blockParser;
            this.f145410b = i3;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(BlockQuote.class, new BlockQuoteParser.Factory());
        map.put(Heading.class, new HeadingParser.Factory());
        map.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        map.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        map.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        map.put(ListBlock.class, new ListBlockParser.Factory());
        map.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        f145390s = Collections.unmodifiableMap(map);
    }

    public DocumentParser(List list, InlineParserFactory inlineParserFactory, List list2, IncludeSourceSpans includeSourceSpans) {
        this.f145400j = list;
        this.f145401k = inlineParserFactory;
        this.f145402l = list2;
        this.f145403m = includeSourceSpans;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.f145404n = documentBlockParser;
        g(new OpenBlockParser(documentBlockParser, 0));
    }

    private void A(int i3) {
        int i4 = this.f145396f;
        if (i3 >= i4) {
            this.f145393c = i4;
            this.f145394d = this.f145397g;
        }
        int length = this.f145391a.a().length();
        while (true) {
            int i5 = this.f145393c;
            if (i5 >= i3 || i5 == length) {
                break;
            } else {
                l();
            }
        }
        this.f145395e = false;
    }

    private void g(OpenBlockParser openBlockParser) {
        this.f145406p.add(openBlockParser);
    }

    private void h(OpenBlockParser openBlockParser) {
        while (!f().h(openBlockParser.f145409a.e())) {
            n(1);
        }
        f().e().c(openBlockParser.f145409a.e());
        g(openBlockParser);
    }

    private void i(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition linkReferenceDefinition : paragraphParser.j()) {
            paragraphParser.e().j(linkReferenceDefinition);
            this.f145405o.a(linkReferenceDefinition);
        }
    }

    private void j() {
        CharSequence charSequenceA;
        if (this.f145395e) {
            CharSequence charSequenceSubSequence = this.f145391a.a().subSequence(this.f145393c + 1, this.f145391a.a().length());
            int iA = Parsing.a(this.f145394d);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence.length() + iA);
            for (int i3 = 0; i3 < iA; i3++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence);
            charSequenceA = sb.toString();
        } else {
            charSequenceA = this.f145393c == 0 ? this.f145391a.a() : this.f145391a.a().subSequence(this.f145393c, this.f145391a.a().length());
        }
        f().g(SourceLine.c(charSequenceA, this.f145403m == IncludeSourceSpans.BLOCKS_AND_INLINES ? SourceSpan.d(this.f145392b, this.f145393c, charSequenceA.length()) : null));
        k();
    }

    private void k() {
        if (this.f145403m != IncludeSourceSpans.NONE) {
            for (int i3 = 1; i3 < this.f145406p.size(); i3++) {
                OpenBlockParser openBlockParser = (OpenBlockParser) this.f145406p.get(i3);
                int i4 = openBlockParser.f145410b;
                int length = this.f145391a.a().length() - i4;
                if (length != 0) {
                    openBlockParser.f145409a.f(SourceSpan.d(this.f145392b, i4, length));
                }
            }
        }
    }

    private void l() {
        char cCharAt = this.f145391a.a().charAt(this.f145393c);
        this.f145393c++;
        if (cCharAt != '\t') {
            this.f145394d++;
        } else {
            int i3 = this.f145394d;
            this.f145394d = i3 + Parsing.a(i3);
        }
    }

    public static List m(List list, Set set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(f145390s.get((Class) it.next()));
        }
        return arrayList;
    }

    private void n(int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            BlockParser blockParser = o().f145409a;
            p(blockParser);
            this.f145407q.add(blockParser);
        }
    }

    private OpenBlockParser o() {
        return (OpenBlockParser) this.f145406p.remove(r0.size() - 1);
    }

    private void p(BlockParser blockParser) {
        if (blockParser instanceof ParagraphParser) {
            i((ParagraphParser) blockParser);
        }
        blockParser.i();
    }

    private Document q() {
        n(this.f145406p.size());
        x();
        return this.f145404n.e();
    }

    private BlockStartImpl r(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        Iterator it = this.f145400j.iterator();
        while (it.hasNext()) {
            BlockStart blockStartA = ((BlockParserFactory) it.next()).a(this, matchedBlockParserImpl);
            if (blockStartA instanceof BlockStartImpl) {
                return (BlockStartImpl) blockStartA;
            }
        }
        return null;
    }

    private void s() {
        int i3 = this.f145393c;
        int i4 = this.f145394d;
        this.f145399i = true;
        int length = this.f145391a.a().length();
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = this.f145391a.a().charAt(i3);
            if (cCharAt == '\t') {
                i3++;
                i4 += 4 - (i4 % 4);
            } else if (cCharAt != ' ') {
                this.f145399i = false;
                break;
            } else {
                i3++;
                i4++;
            }
        }
        this.f145396f = i3;
        this.f145397g = i4;
        this.f145398h = i4 - this.f145394d;
    }

    public static Set t() {
        return f145389r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0115, code lost:
    
        A(r11.f145396f);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(java.lang.CharSequence r12) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.DocumentParser.v(java.lang.CharSequence):void");
    }

    private Block w() {
        BlockParser blockParser = o().f145409a;
        if (blockParser instanceof ParagraphParser) {
            i((ParagraphParser) blockParser);
        }
        blockParser.i();
        blockParser.e().n();
        return blockParser.e();
    }

    private void x() {
        InlineParser inlineParserA = this.f145401k.a(new InlineParserContextImpl(this.f145402l, this.f145405o));
        Iterator it = this.f145407q.iterator();
        while (it.hasNext()) {
            ((BlockParser) it.next()).a(inlineParserA);
        }
    }

    private void y(CharSequence charSequence) {
        this.f145392b++;
        this.f145393c = 0;
        this.f145394d = 0;
        this.f145395e = false;
        CharSequence charSequenceL = Parsing.l(charSequence);
        this.f145391a = SourceLine.c(charSequenceL, this.f145403m != IncludeSourceSpans.NONE ? SourceSpan.d(this.f145392b, 0, charSequenceL.length()) : null);
    }

    private void z(int i3) {
        int i4;
        int i5 = this.f145397g;
        if (i3 >= i5) {
            this.f145393c = this.f145396f;
            this.f145394d = i5;
        }
        int length = this.f145391a.a().length();
        while (true) {
            i4 = this.f145394d;
            if (i4 >= i3 || this.f145393c == length) {
                break;
            } else {
                l();
            }
        }
        if (i4 <= i3) {
            this.f145395e = false;
            return;
        }
        this.f145393c--;
        this.f145394d = i3;
        this.f145395e = true;
    }

    @Override // org.commonmark.parser.block.ParserState
    public boolean a() {
        return this.f145399i;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int b() {
        return this.f145394d;
    }

    @Override // org.commonmark.parser.block.ParserState
    public SourceLine c() {
        return this.f145391a;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int d() {
        return this.f145398h;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int e() {
        return this.f145396f;
    }

    @Override // org.commonmark.parser.block.ParserState
    public BlockParser f() {
        return ((OpenBlockParser) this.f145406p.get(r0.size() - 1)).f145409a;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndex() {
        return this.f145393c;
    }

    public Document u(String str) {
        int i3 = 0;
        while (true) {
            int iC = Parsing.c(str, i3);
            if (iC == -1) {
                break;
            }
            v(str.substring(i3, iC));
            i3 = iC + 1;
            if (i3 < str.length() && str.charAt(iC) == '\r' && str.charAt(i3) == '\n') {
                i3 = iC + 2;
            }
        }
        if (str.length() > 0 && (i3 == 0 || i3 < str.length())) {
            v(str.substring(i3));
        }
        return q();
    }
}
