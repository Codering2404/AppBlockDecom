package ru.noties.markwon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import ru.noties.markwon.MarkwonSpansFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonSpansFactoryImpl implements MarkwonSpansFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f147083a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BuilderImpl implements MarkwonSpansFactory.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f147084a = new HashMap(3);

        BuilderImpl() {
        }

        @Override // ru.noties.markwon.MarkwonSpansFactory.Builder
        public MarkwonSpansFactory.Builder a(Class cls, SpanFactory spanFactory) {
            if (spanFactory == null) {
                this.f147084a.remove(cls);
                return this;
            }
            this.f147084a.put(cls, spanFactory);
            return this;
        }

        @Override // ru.noties.markwon.MarkwonSpansFactory.Builder
        public MarkwonSpansFactory build() {
            return new MarkwonSpansFactoryImpl(Collections.unmodifiableMap(this.f147084a));
        }
    }

    MarkwonSpansFactoryImpl(Map map) {
        this.f147083a = map;
    }

    @Override // ru.noties.markwon.MarkwonSpansFactory
    public SpanFactory a(Class cls) {
        return (SpanFactory) this.f147083a.get(cls);
    }
}
