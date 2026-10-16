package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class wb {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends pp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f64621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f64622b;

        a(Object obj) {
            this.f64622b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f64621a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f64621a) {
                throw new NoSuchElementException();
            }
            this.f64621a = true;
            return this.f64622b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends com.applovin.impl.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final qp f64623f = new b(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f64624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f64625d;

        b(Object[] objArr, int i3, int i4, int i5) {
            super(i4, i5);
            this.f64624c = objArr;
            this.f64625d = i3;
        }

        @Override // com.applovin.impl.c
        protected Object a(int i3) {
            return this.f64624c[this.f64625d + i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c implements Iterator {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p3.a(false);
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static Object b(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    static Object c(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static String d(Iterator it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z2 = true;
        while (it.hasNext()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(it.next());
            z2 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    static qp b() {
        return b.f64623f;
    }

    static Iterator c() {
        return c.INSTANCE;
    }

    static void a(Iterator it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean a(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static Object a(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static boolean a(Iterator it, Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    static pp a() {
        return b();
    }

    public static pp a(Object obj) {
        return new a(obj);
    }
}
