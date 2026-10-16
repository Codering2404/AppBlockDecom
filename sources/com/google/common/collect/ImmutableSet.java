package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ImmutableList f84118b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object[] f84119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f84120e;

        public Builder() {
            super(4);
        }

        private void m(Object obj) {
            Objects.requireNonNull(this.f84119d);
            int length = this.f84119d.length - 1;
            int iHashCode = obj.hashCode();
            int iC = Hashing.c(iHashCode);
            while (true) {
                int i3 = iC & length;
                Object[] objArr = this.f84119d;
                Object obj2 = objArr[i3];
                if (obj2 == null) {
                    objArr[i3] = obj;
                    this.f84120e += iHashCode;
                    super.e(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    iC = i3 + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder e(Object obj) {
            Preconditions.t(obj);
            if (this.f84119d != null && ImmutableSet.q(this.f84006b) <= this.f84119d.length) {
                m(obj);
                return this;
            }
            this.f84119d = null;
            super.e(obj);
            return this;
        }

        public Builder j(Object... objArr) {
            if (this.f84119d == null) {
                super.f(objArr);
                return this;
            }
            for (Object obj : objArr) {
                e(obj);
            }
            return this;
        }

        public Builder k(Iterable iterable) {
            Preconditions.t(iterable);
            if (this.f84119d == null) {
                super.b(iterable);
                return this;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        public Builder l(Iterator it) {
            Preconditions.t(it);
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }

        public ImmutableSet n() {
            ImmutableSet immutableSetS;
            int i3 = this.f84006b;
            if (i3 == 0) {
                return ImmutableSet.z();
            }
            if (i3 == 1) {
                Object obj = this.f84005a[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.A(obj);
            }
            if (this.f84119d == null || ImmutableSet.q(i3) != this.f84119d.length) {
                immutableSetS = ImmutableSet.s(this.f84006b, this.f84005a);
                this.f84006b = immutableSetS.size();
            } else {
                Object[] objArrCopyOf = ImmutableSet.H(this.f84006b, this.f84005a.length) ? Arrays.copyOf(this.f84005a, this.f84006b) : this.f84005a;
                immutableSetS = new RegularImmutableSet(objArrCopyOf, this.f84120e, this.f84119d, r5.length - 1, this.f84006b);
            }
            this.f84007c = true;
            this.f84119d = null;
            return immutableSetS;
        }

        Builder o(Builder builder) {
            if (this.f84119d == null) {
                g(builder.f84005a, builder.f84006b);
                return this;
            }
            for (int i3 = 0; i3 < builder.f84006b; i3++) {
                Object obj = builder.f84005a[i3];
                Objects.requireNonNull(obj);
                e(obj);
            }
            return this;
        }

        Builder(int i3, boolean z2) {
            super(i3);
            if (z2) {
                this.f84119d = new Object[ImmutableSet.q(i3)];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f84121a;

        SerializedForm(Object[] objArr) {
            this.f84121a = objArr;
        }

        Object readResolve() {
            return ImmutableSet.w(this.f84121a);
        }
    }

    ImmutableSet() {
    }

    public static ImmutableSet A(Object obj) {
        return new SingletonImmutableSet(obj);
    }

    public static ImmutableSet B(Object obj, Object obj2) {
        return s(2, obj, obj2);
    }

    public static ImmutableSet C(Object obj, Object obj2, Object obj3) {
        return s(3, obj, obj2, obj3);
    }

    public static ImmutableSet D(Object obj, Object obj2, Object obj3, Object obj4) {
        return s(4, obj, obj2, obj3, obj4);
    }

    public static ImmutableSet E(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return s(5, obj, obj2, obj3, obj4, obj5);
    }

    public static ImmutableSet G(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Preconditions.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return s(length, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(int i3, int i4) {
        return i3 < (i4 >> 1) + (i4 >> 2);
    }

    public static Builder o() {
        return new Builder();
    }

    public static Builder p(int i3) {
        CollectPreconditions.b(i3, "expectedSize");
        return new Builder(i3, true);
    }

    static int q(int i3) {
        int iMax = Math.max(i3, 2);
        if (iMax >= 751619276) {
            Preconditions.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableSet s(int i3, Object... objArr) {
        if (i3 == 0) {
            return z();
        }
        if (i3 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return A(obj);
        }
        int iQ = q(i3);
        Object[] objArr2 = new Object[iQ];
        int i4 = iQ - 1;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            Object objA = ObjectArrays.a(objArr[i7], i7);
            int iHashCode = objA.hashCode();
            int iC = Hashing.c(iHashCode);
            while (true) {
                int i8 = iC & i4;
                Object obj2 = objArr2[i8];
                if (obj2 == null) {
                    objArr[i6] = objA;
                    objArr2[i8] = objA;
                    i5 += iHashCode;
                    i6++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iC++;
            }
        }
        Arrays.fill(objArr, i6, i3, (Object) null);
        if (i6 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (q(i6) < iQ / 2) {
            return s(i6, objArr);
        }
        if (H(i6, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i6);
        }
        return new RegularImmutableSet(objArr, i5, objArr2, i4, i6);
    }

    public static ImmutableSet t(Iterable iterable) {
        return iterable instanceof Collection ? u((Collection) iterable) : v(iterable.iterator());
    }

    public static ImmutableSet u(Collection collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet immutableSet = (ImmutableSet) collection;
            if (!immutableSet.g()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return s(array.length, array);
    }

    public static ImmutableSet v(Iterator it) {
        if (!it.hasNext()) {
            return z();
        }
        Object next = it.next();
        return !it.hasNext() ? A(next) : new Builder().e(next).l(it).n();
    }

    public static ImmutableSet w(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? s(objArr.length, (Object[]) objArr.clone()) : A(objArr[0]) : z();
    }

    public static ImmutableSet z() {
        return RegularImmutableSet.f84603j;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList a() {
        ImmutableList immutableList = this.f84118b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListX = x();
        this.f84118b = immutableListX;
        return immutableListX;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && y() && ((ImmutableSet) obj).y() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.b(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public abstract UnmodifiableIterator iterator();

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.f(this);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    ImmutableList x() {
        return ImmutableList.l(toArray());
    }

    boolean y() {
        return false;
    }
}
