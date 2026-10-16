package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class Traverser<N> {

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Traverser<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SuccessorsFunction f85005a;

        @Override // com.google.common.graph.Traverser
        Traversal a() {
            return Traversal.b(this.f85005a);
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends Traverser<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SuccessorsFunction f85006a;

        @Override // com.google.common.graph.Traverser
        Traversal a() {
            return Traversal.c(this.f85006a);
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Iterable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImmutableSet f85007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Traverser f85008b;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.f85008b.a().a(this.f85007a.iterator());
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements Iterable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImmutableSet f85009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Traverser f85010b;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.f85010b.a().e(this.f85009a.iterator());
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 implements Iterable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImmutableSet f85011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Traverser f85012b;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.f85012b.a().d(this.f85011a.iterator());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            void b(Deque deque, Object obj) {
                deque.addFirst(obj);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            void b(Deque deque, Object obj) {
                deque.addLast(obj);
            }
        };

        abstract void b(Deque deque, Object obj);

        /* synthetic */ InsertionOrder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class Traversal<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SuccessorsFunction f85016a;

        Traversal(SuccessorsFunction successorsFunction) {
            this.f85016a = successorsFunction;
        }

        static Traversal b(SuccessorsFunction successorsFunction) {
            final HashSet hashSet = new HashSet();
            return new Traversal<Object>(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.1
                @Override // com.google.common.graph.Traverser.Traversal
                Object g(Deque deque) {
                    Iterator it = (Iterator) deque.getFirst();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Objects.requireNonNull(next);
                        if (hashSet.add(next)) {
                            return next;
                        }
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        static Traversal c(SuccessorsFunction successorsFunction) {
            return new Traversal<Object>(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.2
                @Override // com.google.common.graph.Traverser.Traversal
                Object g(Deque deque) {
                    Iterator it = (Iterator) deque.getFirst();
                    if (it.hasNext()) {
                        return Preconditions.t(it.next());
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        private Iterator f(Iterator it, final InsertionOrder insertionOrder) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new AbstractIterator<N>(this) { // from class: com.google.common.graph.Traverser.Traversal.3

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Traversal f85020f;

                {
                    this.f85020f = this;
                }

                @Override // com.google.common.collect.AbstractIterator
                protected Object a() {
                    do {
                        Object objG = this.f85020f.g(arrayDeque);
                        if (objG != null) {
                            Iterator it2 = this.f85020f.f85016a.a(objG).iterator();
                            if (it2.hasNext()) {
                                insertionOrder.b(arrayDeque, it2);
                            }
                            return objG;
                        }
                    } while (!arrayDeque.isEmpty());
                    return b();
                }
            };
        }

        final Iterator a(Iterator it) {
            return f(it, InsertionOrder.BACK);
        }

        final Iterator d(Iterator it) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            final ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new AbstractIterator<N>(this) { // from class: com.google.common.graph.Traverser.Traversal.4

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Traversal f85023f;

                {
                    this.f85023f = this;
                }

                @Override // com.google.common.collect.AbstractIterator
                protected Object a() {
                    while (true) {
                        Object objG = this.f85023f.g(arrayDeque2);
                        if (objG == null) {
                            return !arrayDeque.isEmpty() ? arrayDeque.pop() : b();
                        }
                        Iterator it2 = this.f85023f.f85016a.a(objG).iterator();
                        if (!it2.hasNext()) {
                            return objG;
                        }
                        arrayDeque2.addFirst(it2);
                        arrayDeque.push(objG);
                    }
                }
            };
        }

        final Iterator e(Iterator it) {
            return f(it, InsertionOrder.FRONT);
        }

        abstract Object g(Deque deque);
    }

    abstract Traversal a();
}
