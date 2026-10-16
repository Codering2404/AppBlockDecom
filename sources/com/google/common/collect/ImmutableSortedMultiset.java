package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableMultiset<E> implements SortedMultiset<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient ImmutableSortedMultiset f84137d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<E> extends ImmutableMultiset.Builder<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Comparator f84138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object[] f84139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int[] f84140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f84141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f84142h;

        public Builder(Comparator comparator) {
            super(true);
            this.f84138d = (Comparator) Preconditions.t(comparator);
            this.f84139e = new Object[4];
            this.f84140f = new int[4];
        }

        private void n(boolean z2) {
            int i3 = this.f84141g;
            if (i3 == 0) {
                return;
            }
            Object[] objArrCopyOf = Arrays.copyOf(this.f84139e, i3);
            Arrays.sort(objArrCopyOf, this.f84138d);
            int i4 = 1;
            for (int i5 = 1; i5 < objArrCopyOf.length; i5++) {
                if (this.f84138d.compare(objArrCopyOf[i4 - 1], objArrCopyOf[i5]) < 0) {
                    objArrCopyOf[i4] = objArrCopyOf[i5];
                    i4++;
                }
            }
            Arrays.fill(objArrCopyOf, i4, this.f84141g, (Object) null);
            if (z2) {
                int i6 = i4 * 4;
                int i7 = this.f84141g;
                if (i6 > i7 * 3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, IntMath.i(i7, (i7 / 2) + 1));
                }
            }
            int[] iArr = new int[objArrCopyOf.length];
            for (int i8 = 0; i8 < this.f84141g; i8++) {
                int iBinarySearch = Arrays.binarySearch(objArrCopyOf, 0, i4, this.f84139e[i8], this.f84138d);
                int i9 = this.f84140f[i8];
                if (i9 >= 0) {
                    iArr[iBinarySearch] = iArr[iBinarySearch] + i9;
                } else {
                    iArr[iBinarySearch] = ~i9;
                }
            }
            this.f84139e = objArrCopyOf;
            this.f84140f = iArr;
            this.f84141g = i4;
        }

        private void o() {
            n(false);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = this.f84141g;
                if (i3 >= i5) {
                    Arrays.fill(this.f84139e, i4, i5, (Object) null);
                    Arrays.fill(this.f84140f, i4, this.f84141g, 0);
                    this.f84141g = i4;
                    return;
                }
                int[] iArr = this.f84140f;
                int i6 = iArr[i3];
                if (i6 > 0) {
                    Object[] objArr = this.f84139e;
                    objArr[i4] = objArr[i3];
                    iArr[i4] = i6;
                    i4++;
                }
                i3++;
            }
        }

        private void p() {
            int i3 = this.f84141g;
            Object[] objArr = this.f84139e;
            if (i3 == objArr.length) {
                n(true);
            } else if (this.f84142h) {
                this.f84139e = Arrays.copyOf(objArr, objArr.length);
            }
            this.f84142h = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Builder e(Object obj) {
            return g(obj, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder f(Iterable iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry entry : ((Multiset) iterable).entrySet()) {
                    g(entry.a(), entry.getCount());
                }
            } else {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Builder g(Object obj, int i3) {
            Preconditions.t(obj);
            CollectPreconditions.b(i3, "occurrences");
            if (i3 == 0) {
                return this;
            }
            p();
            Object[] objArr = this.f84139e;
            int i4 = this.f84141g;
            objArr[i4] = obj;
            this.f84140f[i4] = i3;
            this.f84141g = i4 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset h() {
            o();
            int i3 = this.f84141g;
            if (i3 == 0) {
                return ImmutableSortedMultiset.v(this.f84138d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.I(this.f84138d, i3, this.f84139e);
            long[] jArr = new long[this.f84141g + 1];
            int i4 = 0;
            while (i4 < this.f84141g) {
                int i5 = i4 + 1;
                jArr[i5] = jArr[i4] + ((long) this.f84140f[i4]);
                i4 = i5;
            }
            this.f84142h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f84141g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializedForm<E> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator f84143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f84144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f84145c;

        SerializedForm(SortedMultiset sortedMultiset) {
            this.f84143a = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.f84144b = new Object[size];
            this.f84145c = new int[size];
            int i3 = 0;
            for (Multiset.Entry entry : sortedMultiset.entrySet()) {
                this.f84144b[i3] = entry.a();
                this.f84145c[i3] = entry.getCount();
                i3++;
            }
        }

        Object readResolve() {
            int length = this.f84144b.length;
            Builder builder = new Builder(this.f84143a);
            for (int i3 = 0; i3 < length; i3++) {
                builder.g(this.f84144b[i3], this.f84145c[i3]);
            }
            return builder.h();
        }
    }

    ImmutableSortedMultiset() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    static ImmutableSortedMultiset v(Comparator comparator) {
        return Ordering.f().equals(comparator) ? RegularImmutableSortedMultiset.f84610k : new RegularImmutableSortedMultiset(comparator);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator comparator() {
        return i().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public final Multiset.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: t */
    public ImmutableSortedMultiset A1() {
        ImmutableSortedMultiset immutableSortedMultisetV = this.f84137d;
        if (immutableSortedMultisetV == null) {
            immutableSortedMultisetV = isEmpty() ? v(Ordering.b(comparator()).k()) : new DescendingImmutableSortedMultiset(this);
            this.f84137d = immutableSortedMultisetV;
        }
        return immutableSortedMultisetV;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    /* JADX INFO: renamed from: u */
    public abstract ImmutableSortedSet i();

    @Override // com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: w */
    public abstract ImmutableSortedMultiset Q1(Object obj, BoundType boundType);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        Preconditions.o(comparator().compare(obj, obj2) <= 0, "Expected lowerBound <= upperBound but %s > %s", obj, obj2);
        return h2(obj, boundType).Q1(obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: y */
    public abstract ImmutableSortedMultiset h2(Object obj, BoundType boundType);
}
