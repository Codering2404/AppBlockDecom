package ru.noties.markwon;

import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.core.spans.LinkSpan;
import ru.noties.markwon.html.MarkwonHtmlParser;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.image.ImageSizeResolver;
import ru.noties.markwon.image.ImageSizeResolverDef;
import ru.noties.markwon.syntax.SyntaxHighlight;
import ru.noties.markwon.syntax.SyntaxHighlightNoOp;
import ru.noties.markwon.urlprocessor.UrlProcessor;
import ru.noties.markwon.urlprocessor.UrlProcessorNoOp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MarkwonConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsyncDrawableLoader f147062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SyntaxHighlight f147063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkSpan.Resolver f147064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UrlProcessor f147065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageSizeResolver f147066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MarkwonHtmlParser f147067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MarkwonHtmlRenderer f147068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MarkwonSpansFactory f147069i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MarkwonTheme f147070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AsyncDrawableLoader f147071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SyntaxHighlight f147072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private LinkSpan.Resolver f147073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private UrlProcessor f147074e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ImageSizeResolver f147075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private MarkwonHtmlParser f147076g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private MarkwonHtmlRenderer f147077h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MarkwonSpansFactory f147078i;

        Builder() {
        }

        public MarkwonConfiguration j(MarkwonTheme markwonTheme, AsyncDrawableLoader asyncDrawableLoader, MarkwonHtmlRenderer markwonHtmlRenderer, MarkwonSpansFactory markwonSpansFactory) {
            this.f147070a = markwonTheme;
            this.f147071b = asyncDrawableLoader;
            this.f147077h = markwonHtmlRenderer;
            this.f147078i = markwonSpansFactory;
            if (this.f147072c == null) {
                this.f147072c = new SyntaxHighlightNoOp();
            }
            if (this.f147073d == null) {
                this.f147073d = new LinkResolverDef();
            }
            if (this.f147074e == null) {
                this.f147074e = new UrlProcessorNoOp();
            }
            if (this.f147075f == null) {
                this.f147075f = new ImageSizeResolverDef();
            }
            if (this.f147076g == null) {
                this.f147076g = MarkwonHtmlParser.c();
            }
            return new MarkwonConfiguration(this);
        }

        public Builder k(MarkwonHtmlParser markwonHtmlParser) {
            this.f147076g = markwonHtmlParser;
            return this;
        }
    }

    public AsyncDrawableLoader a() {
        return this.f147062b;
    }

    public MarkwonHtmlParser b() {
        return this.f147067g;
    }

    public MarkwonHtmlRenderer c() {
        return this.f147068h;
    }

    public ImageSizeResolver d() {
        return this.f147066f;
    }

    public LinkSpan.Resolver e() {
        return this.f147064d;
    }

    public MarkwonSpansFactory f() {
        return this.f147069i;
    }

    public SyntaxHighlight g() {
        return this.f147063c;
    }

    public MarkwonTheme h() {
        return this.f147061a;
    }

    public UrlProcessor i() {
        return this.f147065e;
    }

    private MarkwonConfiguration(Builder builder) {
        this.f147061a = builder.f147070a;
        this.f147062b = builder.f147071b;
        this.f147063c = builder.f147072c;
        this.f147064d = builder.f147073d;
        this.f147065e = builder.f147074e;
        this.f147066f = builder.f147075f;
        this.f147069i = builder.f147078i;
        this.f147067g = builder.f147076g;
        this.f147068h = builder.f147077h;
    }
}
