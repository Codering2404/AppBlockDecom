package org.commonmark.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.internal.LinkReferenceDefinitions;
import org.commonmark.node.Node;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Parser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f145553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f145554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InlineParserFactory f145555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f145556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final IncludeSourceSpans f145557e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private InlineParserFactory f145562e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f145558a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f145559b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f145560c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set f145561d = DocumentParser.t();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IncludeSourceSpans f145563f = IncludeSourceSpans.NONE;

        /* JADX INFO: Access modifiers changed from: private */
        public InlineParserFactory j() {
            InlineParserFactory inlineParserFactory = this.f145562e;
            return inlineParserFactory != null ? inlineParserFactory : new InlineParserFactory() { // from class: org.commonmark.parser.Parser.Builder.1
                @Override // org.commonmark.parser.InlineParserFactory
                public InlineParser a(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }

        public Parser g() {
            return new Parser(this);
        }

        public Builder h(DelimiterProcessor delimiterProcessor) {
            if (delimiterProcessor == null) {
                throw new NullPointerException("delimiterProcessor must not be null");
            }
            this.f145559b.add(delimiterProcessor);
            return this;
        }

        public Builder i(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Extension extension = (Extension) it.next();
                if (extension instanceof ParserExtension) {
                    ((ParserExtension) extension).a(this);
                }
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ParserExtension extends Extension {
        void a(Builder builder);
    }

    public static Builder a() {
        return new Builder();
    }

    private DocumentParser b() {
        return new DocumentParser(this.f145553a, this.f145555c, this.f145554b, this.f145557e);
    }

    private Node d(Node node) {
        Iterator it = this.f145556d.iterator();
        while (it.hasNext()) {
            node = ((PostProcessor) it.next()).a(node);
        }
        return node;
    }

    public Node c(String str) {
        if (str != null) {
            return d(b().u(str));
        }
        throw new NullPointerException("input must not be null");
    }

    private Parser(Builder builder) {
        this.f145553a = DocumentParser.m(builder.f145558a, builder.f145561d);
        InlineParserFactory inlineParserFactoryJ = builder.j();
        this.f145555c = inlineParserFactoryJ;
        this.f145556d = builder.f145560c;
        List list = builder.f145559b;
        this.f145554b = list;
        this.f145557e = builder.f145563f;
        inlineParserFactoryJ.a(new InlineParserContextImpl(list, new LinkReferenceDefinitions()));
    }
}
