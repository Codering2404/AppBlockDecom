package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@Deprecated
public abstract class TreeTraverser<T> {

    /* JADX INFO: renamed from: com.google.common.collect.TreeTraverser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends TreeTraverser<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function f84849a;

        @Override // com.google.common.collect.TreeTraverser
        public Iterable a(Object obj) {
            return (Iterable) this.f84849a.apply(obj);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.TreeTraverser$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f84850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TreeTraverser f84851c;

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return this.f84851c.c(this.f84850b);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.TreeTraverser$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f84852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TreeTraverser f84853c;

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return this.f84853c.b(this.f84852b);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.TreeTraverser$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends FluentIterable<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f84854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TreeTraverser f84855c;

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return new BreadthFirstIterator(this.f84854b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f84856a;

        BreadthFirstIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f84856a = arrayDeque;
            arrayDeque.add(obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f84856a.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public Object next() {
            Object objRemove = this.f84856a.remove();
            Iterables.a(this.f84856a, TreeTraverser.this.a(objRemove));
            return objRemove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public Object peek() {
            return this.f84856a.element();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PostOrderIterator extends AbstractIterator<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayDeque f84858c;

        PostOrderIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f84858c = arrayDeque;
            arrayDeque.addLast(d(obj));
        }

        private PostOrderNode d(Object obj) {
            return new PostOrderNode(obj, TreeTraverser.this.a(obj).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        protected Object a() {
            while (!this.f84858c.isEmpty()) {
                PostOrderNode postOrderNode = (PostOrderNode) this.f84858c.getLast();
                if (!postOrderNode.f84861b.hasNext()) {
                    this.f84858c.removeLast();
                    return postOrderNode.f84860a;
                }
                this.f84858c.addLast(d(postOrderNode.f84861b.next()));
            }
            return b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PostOrderNode<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator f84861b;

        PostOrderNode(Object obj, Iterator it) {
            this.f84860a = Preconditions.t(obj);
            this.f84861b = (Iterator) Preconditions.t(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PreOrderIterator extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Deque f84862a;

        PreOrderIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f84862a = arrayDeque;
            arrayDeque.addLast(Iterators.K(Preconditions.t(obj)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f84862a.isEmpty();
        }

        @Override // java.util.Iterator
        public Object next() {
            Iterator it = (Iterator) this.f84862a.getLast();
            Object objT = Preconditions.t(it.next());
            if (!it.hasNext()) {
                this.f84862a.removeLast();
            }
            Iterator<T> it2 = TreeTraverser.this.a(objT).iterator();
            if (it2.hasNext()) {
                this.f84862a.addLast(it2);
            }
            return objT;
        }
    }

    public abstract Iterable a(Object obj);

    UnmodifiableIterator b(Object obj) {
        return new PostOrderIterator(obj);
    }

    UnmodifiableIterator c(Object obj) {
        return new PreOrderIterator(obj);
    }
}
