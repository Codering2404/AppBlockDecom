package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.graph.ElementOrder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f85024a;

    /* JADX INFO: renamed from: com.google.common.graph.UndirectedGraphConnections$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f85025a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f85025a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f85025a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.common.graph.GraphConnections
    public Set a() {
        return c();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set b() {
        return c();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set c() {
        return Collections.unmodifiableSet(this.f85024a.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Object d(Object obj) {
        return this.f85024a.get(obj);
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator e(final Object obj) {
        return Iterators.N(this.f85024a.keySet().iterator(), new Function() { // from class: com.google.common.graph.o
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.p(obj, obj2);
            }
        });
    }
}
