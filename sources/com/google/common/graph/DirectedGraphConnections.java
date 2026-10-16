package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.ElementOrder;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f84920e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f84921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f84922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f84923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f84924d;

    /* JADX INFO: renamed from: com.google.common.graph.DirectedGraphConnections$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f84942a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f84942a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f84942a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class NodeConnection<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84943a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Pred<N> extends NodeConnection<N> {
            public boolean equals(Object obj) {
                if (obj instanceof Pred) {
                    return this.f84943a.equals(((Pred) obj).f84943a);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.f84943a.hashCode();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Succ<N> extends NodeConnection<N> {
            public boolean equals(Object obj) {
                if (obj instanceof Succ) {
                    return this.f84943a.equals(((Succ) obj).f84943a);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.f84943a.hashCode();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PredAndSucc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84944a;
    }

    public static /* synthetic */ EndpointPair g(Object obj, NodeConnection nodeConnection) {
        return nodeConnection instanceof NodeConnection.Succ ? EndpointPair.l(obj, nodeConnection.f84943a) : EndpointPair.l(nodeConnection.f84943a, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Object obj) {
        return obj == f84920e || (obj instanceof PredAndSucc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(Object obj) {
        return (obj == f84920e || obj == null) ? false : true;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set a() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                if (DirectedGraphConnections.this.f84922b == null) {
                    final Iterator it = DirectedGraphConnections.this.f84921a.entrySet().iterator();
                    return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.3.1

                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass3 f84936d;

                        {
                            this.f84936d = this;
                        }

                        @Override // com.google.common.collect.AbstractIterator
                        protected Object a() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.p(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.f84922b.iterator();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.3.2

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass3 f84938d;

                    {
                        this.f84938d = this;
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.f84943a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return DirectedGraphConnections.p(DirectedGraphConnections.this.f84921a.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f84924d;
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set b() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                if (DirectedGraphConnections.this.f84922b == null) {
                    final Iterator it = DirectedGraphConnections.this.f84921a.entrySet().iterator();
                    return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.2.1

                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass2 f84931d;

                        {
                            this.f84931d = this;
                        }

                        @Override // com.google.common.collect.AbstractIterator
                        protected Object a() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.o(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.f84922b.iterator();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.2.2

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass2 f84933d;

                    {
                        this.f84933d = this;
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.f84943a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return DirectedGraphConnections.o(DirectedGraphConnections.this.f84921a.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f84923c;
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set c() {
        return this.f84922b == null ? Collections.unmodifiableSet(this.f84921a.keySet()) : new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                final Iterator it = DirectedGraphConnections.this.f84922b.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.1.1

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f84928f;

                    {
                        this.f84928f = this;
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    protected Object a() {
                        while (it.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it.next();
                            if (hashSet.add(nodeConnection.f84943a)) {
                                return nodeConnection.f84943a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return DirectedGraphConnections.this.f84921a.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f84921a.size();
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Object d(Object obj) {
        Preconditions.t(obj);
        Object obj2 = this.f84921a.get(obj);
        if (obj2 == f84920e) {
            return null;
        }
        return obj2 instanceof PredAndSucc ? ((PredAndSucc) obj2).f84944a : obj2;
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator e(final Object obj) {
        Preconditions.t(obj);
        List list = this.f84922b;
        final Iterator itG = list == null ? Iterators.g(Iterators.N(b().iterator(), new Function() { // from class: com.google.common.graph.k
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.l(obj2, obj);
            }
        }), Iterators.N(a().iterator(), new Function() { // from class: com.google.common.graph.l
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.l(obj, obj2);
            }
        })) : Iterators.N(list.iterator(), new Function() { // from class: com.google.common.graph.m
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return DirectedGraphConnections.g(obj, (DirectedGraphConnections.NodeConnection) obj2);
            }
        });
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>(this) { // from class: com.google.common.graph.DirectedGraphConnections.4

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ DirectedGraphConnections f84941f;

            {
                this.f84941f = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public EndpointPair a() {
                while (itG.hasNext()) {
                    EndpointPair endpointPair = (EndpointPair) itG.next();
                    if (!endpointPair.e().equals(endpointPair.f()) || !atomicBoolean.getAndSet(true)) {
                        return endpointPair;
                    }
                }
                return (EndpointPair) b();
            }
        };
    }
}
