package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bb extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f58627a = new Object[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class b {
        b() {
        }

        static int a(int i3, int i4) {
            if (i4 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i3 + (i3 >> 1) + 1;
            if (iHighestOneBit < i4) {
                iHighestOneBit = Integer.highestOneBit(i4 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }
    }

    bb() {
    }

    abstract int a(Object[] objArr, int i3);

    public db a() {
        return isEmpty() ? db.h() : db.a(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    Object[] b() {
        return null;
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    int d() {
        throw new UnsupportedOperationException();
    }

    abstract boolean e();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract pp iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f58627a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrB = b();
            if (objArrB != null) {
                return mh.a(objArrB, d(), c(), objArr);
            }
            objArr = fg.b(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        a(objArr, 0);
        return objArr;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f58628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f58629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f58630c;

        a(int i3) {
            p3.a(i3, "initialCapacity");
            this.f58628a = new Object[i3];
            this.f58629b = 0;
        }

        public a a(Object obj) {
            Preconditions.checkNotNull(obj);
            a(this.f58629b + 1);
            Object[] objArr = this.f58628a;
            int i3 = this.f58629b;
            this.f58629b = i3 + 1;
            objArr[i3] = obj;
            return this;
        }

        private void a(int i3) {
            Object[] objArr = this.f58628a;
            if (objArr.length < i3) {
                this.f58628a = Arrays.copyOf(objArr, b.a(objArr.length, i3));
                this.f58630c = false;
            } else if (this.f58630c) {
                this.f58628a = (Object[]) objArr.clone();
                this.f58630c = false;
            }
        }
    }
}
