package ru.noties.markwon.html;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlParser;
import ru.noties.markwon.html.MarkwonHtmlRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonHtmlRendererImpl extends MarkwonHtmlRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f147208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f147209b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BuilderImpl implements MarkwonHtmlRenderer.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f147214a = new HashMap(2);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f147215b;

        BuilderImpl() {
        }

        @Override // ru.noties.markwon.html.MarkwonHtmlRenderer.Builder
        public MarkwonHtmlRenderer.Builder a(Collection collection, TagHandler tagHandler) {
            if (tagHandler == null) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    this.f147214a.remove((String) it.next());
                }
            } else {
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    this.f147214a.put((String) it2.next(), tagHandler);
                }
            }
            return this;
        }

        @Override // ru.noties.markwon.html.MarkwonHtmlRenderer.Builder
        public MarkwonHtmlRenderer.Builder b(String str, TagHandler tagHandler) {
            if (tagHandler == null) {
                this.f147214a.remove(str);
                return this;
            }
            this.f147214a.put(str, tagHandler);
            return this;
        }

        @Override // ru.noties.markwon.html.MarkwonHtmlRenderer.Builder
        public MarkwonHtmlRenderer build() {
            return this.f147214a.size() > 0 ? new MarkwonHtmlRendererImpl(this.f147215b, Collections.unmodifiableMap(this.f147214a)) : new MarkwonHtmlRendererNoOp();
        }
    }

    MarkwonHtmlRendererImpl(boolean z2, Map map) {
        this.f147208a = z2;
        this.f147209b = map;
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlRenderer
    public void b(final MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser) {
        int length = !this.f147208a ? -1 : markwonVisitor.length();
        markwonHtmlParser.b(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Inline>() { // from class: ru.noties.markwon.html.MarkwonHtmlRendererImpl.1
            @Override // ru.noties.markwon.html.MarkwonHtmlParser.FlushAction
            public void a(List list) {
                TagHandler tagHandlerC;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    HtmlTag.Inline inline = (HtmlTag.Inline) it.next();
                    if (inline.isClosed() && (tagHandlerC = MarkwonHtmlRendererImpl.this.c(inline.name())) != null) {
                        tagHandlerC.handle(markwonVisitor, MarkwonHtmlRendererImpl.this, inline);
                    }
                }
            }
        });
        markwonHtmlParser.a(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Block>() { // from class: ru.noties.markwon.html.MarkwonHtmlRendererImpl.2
            @Override // ru.noties.markwon.html.MarkwonHtmlParser.FlushAction
            public void a(List list) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    HtmlTag.Block block = (HtmlTag.Block) it.next();
                    if (block.isClosed()) {
                        TagHandler tagHandlerC = MarkwonHtmlRendererImpl.this.c(block.name());
                        if (tagHandlerC != null) {
                            tagHandlerC.handle(markwonVisitor, MarkwonHtmlRendererImpl.this, block);
                        } else {
                            a(block.e());
                        }
                    }
                }
            }
        });
        markwonHtmlParser.e();
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlRenderer
    public TagHandler c(String str) {
        return (TagHandler) this.f147209b.get(str);
    }
}
