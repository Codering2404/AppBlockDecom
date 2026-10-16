package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Class f83913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Enum[] f83914d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int[] f83915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f83916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient long f83917h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class Itr<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f83922a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f83923b = -1;

        Itr() {
        }

        abstract Object a(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f83922a < EnumMultiset.this.f83914d.length) {
                int[] iArr = EnumMultiset.this.f83915f;
                int i3 = this.f83922a;
                if (iArr[i3] > 0) {
                    return true;
                }
                this.f83922a = i3 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objA = a(this.f83922a);
            int i3 = this.f83922a;
            this.f83923b = i3;
            this.f83922a = i3 + 1;
            return objA;
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(this.f83923b >= 0);
            if (EnumMultiset.this.f83915f[this.f83923b] > 0) {
                EnumMultiset.l(EnumMultiset.this);
                EnumMultiset.n(EnumMultiset.this, r0.f83915f[this.f83923b]);
                EnumMultiset.this.f83915f[this.f83923b] = 0;
            }
            this.f83923b = -1;
        }
    }

    static /* synthetic */ int l(EnumMultiset enumMultiset) {
        int i3 = enumMultiset.f83916g;
        enumMultiset.f83916g = i3 - 1;
        return i3;
    }

    static /* synthetic */ long n(EnumMultiset enumMultiset, long j3) {
        long j4 = enumMultiset.f83917h - j3;
        enumMultiset.f83917h = j4;
        return j4;
    }

    private void p(Object obj) {
        Preconditions.t(obj);
        if (q(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.f83913c + " but got " + obj);
    }

    private boolean q(Object obj) {
        if (obj instanceof Enum) {
            Enum r5 = (Enum) obj;
            int iOrdinal = r5.ordinal();
            Enum[] enumArr = this.f83914d;
            if (iOrdinal < enumArr.length && enumArr[iOrdinal] == r5) {
                return true;
            }
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        Class cls = (Class) object;
        this.f83913c = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.f83914d = enumArr;
        this.f83915f = new int[enumArr.length];
        Serialization.f(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f83913c);
        Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean L1(Object obj, int i3, int i4) {
        return super.L1(obj, i3, i4);
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        if (obj == null || !q(obj)) {
            return 0;
        }
        return this.f83915f[((Enum) obj).ordinal()];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f83915f, 0);
        this.f83917h = 0L;
        this.f83916g = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    int d() {
        return this.f83916g;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator e() {
        return new EnumMultiset<E>.Itr<E>() { // from class: com.google.common.collect.EnumMultiset.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Enum a(int i3) {
                return EnumMultiset.this.f83914d[i3];
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator f() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.EnumMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry a(final int i3) {
                return new Multisets.AbstractEntry<E>(this) { // from class: com.google.common.collect.EnumMultiset.2.1

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass2 f83921b;

                    {
                        this.f83921b = this;
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Enum a() {
                        return EnumMultiset.this.f83914d[i3];
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public int getCount() {
                        return EnumMultiset.this.f83915f[i3];
                    }
                };
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set i() {
        return super.i();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator iterator() {
        return Multisets.j(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public int t1(Enum r8, int i3) {
        p(r8);
        CollectPreconditions.b(i3, "occurrences");
        if (i3 == 0) {
            return Y1(r8);
        }
        int iOrdinal = r8.ordinal();
        int i4 = this.f83915f[iOrdinal];
        long j3 = i3;
        long j4 = ((long) i4) + j3;
        Preconditions.k(j4 <= 2147483647L, "too many occurrences: %s", j4);
        this.f83915f[iOrdinal] = (int) j4;
        if (i4 == 0) {
            this.f83916g++;
        }
        this.f83917h += j3;
        return i4;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int o1(Object obj, int i3) {
        if (obj == null || !q(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        CollectPreconditions.b(i3, "occurrences");
        if (i3 == 0) {
            return Y1(obj);
        }
        int iOrdinal = r12.ordinal();
        int[] iArr = this.f83915f;
        int i4 = iArr[iOrdinal];
        if (i4 == 0) {
            return 0;
        }
        if (i4 > i3) {
            iArr[iOrdinal] = i4 - i3;
            this.f83917h -= (long) i3;
            return i4;
        }
        iArr[iOrdinal] = 0;
        this.f83916g--;
        this.f83917h -= (long) i4;
        return i4;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int e0(Enum r7, int i3) {
        p(r7);
        CollectPreconditions.b(i3, "count");
        int iOrdinal = r7.ordinal();
        int[] iArr = this.f83915f;
        int i4 = iArr[iOrdinal];
        iArr[iOrdinal] = i3;
        this.f83917h += (long) (i3 - i4);
        if (i4 == 0 && i3 > 0) {
            this.f83916g++;
            return i4;
        }
        if (i4 > 0 && i3 == 0) {
            this.f83916g--;
        }
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.m(this.f83917h);
    }
}
