package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f84004a = new Object[0];
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ArrayBasedBuilder<E> extends Builder<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f84005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f84006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f84007c;

        ArrayBasedBuilder(int i3) {
            CollectPreconditions.b(i3, "initialCapacity");
            this.f84005a = new Object[i3];
            this.f84006b = 0;
        }

        private void h(int i3) {
            Object[] objArr = this.f84005a;
            int iD = Builder.d(objArr.length, this.f84006b + i3);
            if (iD > objArr.length || this.f84007c) {
                this.f84005a = Arrays.copyOf(this.f84005a, iD);
                this.f84007c = false;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                h(collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f84006b = ((ImmutableCollection) collection).b(this.f84005a, this.f84006b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ArrayBasedBuilder e(Object obj) {
            Preconditions.t(obj);
            h(1);
            Object[] objArr = this.f84005a;
            int i3 = this.f84006b;
            this.f84006b = i3 + 1;
            objArr[i3] = obj;
            return this;
        }

        public Builder f(Object... objArr) {
            g(objArr, objArr.length);
            return this;
        }

        final void g(Object[] objArr, int i3) {
            ObjectArrays.c(objArr, i3);
            h(i3);
            System.arraycopy(objArr, 0, this.f84005a, this.f84006b, i3);
            this.f84006b += i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static abstract class Builder<E> {
        Builder() {
        }

        static int d(int i3, int i4) {
            if (i4 < 0) {
                throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
            }
            if (i4 <= i3) {
                return i3;
            }
            int iHighestOneBit = i3 + (i3 >> 1) + 1;
            if (iHighestOneBit < i4) {
                iHighestOneBit = Integer.highestOneBit(i4 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }

        /* JADX INFO: renamed from: a */
        public abstract Builder e(Object obj);

        public Builder b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        public Builder c(Iterator it) {
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }
    }

    ImmutableCollection() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public ImmutableList a() {
        return isEmpty() ? ImmutableList.y() : ImmutableList.l(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    int b(Object[] objArr, int i3) {
        UnmodifiableIterator it = iterator();
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    Object[] d() {
        return null;
    }

    int e() {
        throw new UnsupportedOperationException();
    }

    int f() {
        throw new UnsupportedOperationException();
    }

    abstract boolean g();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public abstract UnmodifiableIterator iterator();

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

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f84004a);
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Preconditions.t(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrD = d();
            if (objArrD != null) {
                return Platform.a(objArrD, f(), e(), objArr);
            }
            objArr = ObjectArrays.g(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        b(objArr, 0);
        return objArr;
    }
}
