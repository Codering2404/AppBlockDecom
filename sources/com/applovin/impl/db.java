package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.impl.bb;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class db extends bb implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final qp f59195b = new b(mi.f61895f, 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends bb.a {
        public a() {
            this(4);
        }

        public db a() {
            this.f58630c = true;
            return db.b(this.f58628a, this.f58629b);
        }

        public a b(Object obj) {
            super.a(obj);
            return this;
        }

        a(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b extends com.applovin.impl.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final db f59196c;

        b(db dbVar, int i3) {
            super(dbVar.size(), i3);
            this.f59196c = dbVar;
        }

        @Override // com.applovin.impl.c
        protected Object a(int i3) {
            return this.f59196c.get(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends db {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f59197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f59198d;

        c(int i3, int i4) {
            this.f59197c = i3;
            this.f59198d = i4;
        }

        @Override // com.applovin.impl.db, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public db subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, this.f59198d);
            db dbVar = db.this;
            int i5 = this.f59197c;
            return dbVar.subList(i3 + i5, i4 + i5);
        }

        @Override // com.applovin.impl.bb
        Object[] b() {
            return db.this.b();
        }

        @Override // com.applovin.impl.bb
        int c() {
            return db.this.d() + this.f59197c + this.f59198d;
        }

        @Override // com.applovin.impl.bb
        int d() {
            return db.this.d() + this.f59197c;
        }

        @Override // com.applovin.impl.bb
        boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.checkElementIndex(i3, this.f59198d);
            return db.this.get(i3 + this.f59197c);
        }

        @Override // com.applovin.impl.db, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.applovin.impl.db, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f59198d;
        }

        @Override // com.applovin.impl.db, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }
    }

    db() {
    }

    static db b(Object[] objArr, int i3) {
        return i3 == 0 ? h() : new mi(objArr, i3);
    }

    public static db c(Object[] objArr) {
        return objArr.length == 0 ? h() : b((Object[]) objArr.clone());
    }

    public static a f() {
        return new a();
    }

    public static db h() {
        return mi.f61895f;
    }

    @Override // com.applovin.impl.bb
    public final db a() {
        return this;
    }

    @Override // java.util.List
    public final void add(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return hc.a(this, obj);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public qp listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i4 = 0; i4 < size; i4++) {
            i3 = ~(~((i3 * 31) + get(i4).hashCode()));
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return hc.b(this, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public pp iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return hc.d(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i3, Object obj) {
        throw new UnsupportedOperationException();
    }

    static db a(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    private static db b(Object... objArr) {
        return a(fg.a(objArr));
    }

    @Override // com.applovin.impl.bb
    int a(Object[] objArr, int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            objArr[i3 + i4] = get(i4);
        }
        return i3 + size;
    }

    db b(int i3, int i4) {
        return new c(i3, i4 - i3);
    }

    public static db a(Collection collection) {
        if (collection instanceof bb) {
            db dbVarA = ((bb) collection).a();
            return dbVarA.e() ? a(dbVarA.toArray()) : dbVarA;
        }
        return b(collection.toArray());
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qp listIterator(int i3) {
        Preconditions.checkPositionIndex(i3, size());
        if (isEmpty()) {
            return f59195b;
        }
        return new b(this, i3);
    }

    public static db a(Object obj) {
        return b(obj);
    }

    public static db a(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    public static db a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return b(obj, obj2, obj3, obj4, obj5);
    }

    public static db a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return b(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static db a(Comparator comparator, Iterable iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] objArrC = vb.c(iterable);
        fg.a(objArrC);
        Arrays.sort(objArrC, comparator);
        return a(objArrC);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a */
    public db subList(int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i4, size());
        int i5 = i4 - i3;
        if (i5 == size()) {
            return this;
        }
        if (i5 == 0) {
            return h();
        }
        return b(i3, i4);
    }
}
