package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Object f83836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int[] f83837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f83838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f83839d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f83840f;

    CompactHashSet(int i3) {
        u(i3);
    }

    private Object A() {
        Object obj = this.f83836a;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void C(int i3) {
        int iMin;
        int length = z().length;
        if (i3 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        B(iMin);
    }

    private int D(int i3, int i4, int i5, int i6) {
        Object objA = CompactHashing.a(i4);
        int i7 = i4 - 1;
        if (i6 != 0) {
            CompactHashing.i(objA, i5 & i7, i6 + 1);
        }
        Object objA2 = A();
        int[] iArrZ = z();
        for (int i8 = 0; i8 <= i3; i8++) {
            int iH = CompactHashing.h(objA2, i8);
            while (iH != 0) {
                int i9 = iH - 1;
                int i10 = iArrZ[i9];
                int iB = CompactHashing.b(i10, i3) | i8;
                int i11 = iB & i7;
                int iH2 = CompactHashing.h(objA, i11);
                CompactHashing.i(objA, i11, iH);
                iArrZ[i9] = CompactHashing.d(iB, iH2, i7);
                iH = CompactHashing.c(i10, i3);
            }
        }
        this.f83836a = objA;
        H(i7);
        return i7;
    }

    private void E(int i3, Object obj) {
        y()[i3] = obj;
    }

    private void G(int i3, int i4) {
        z()[i3] = i4;
    }

    private void H(int i3) {
        this.f83839d = CompactHashing.d(this.f83839d, 32 - Integer.numberOfLeadingZeros(i3), 31);
    }

    private Set g(int i3) {
        return new LinkedHashSet(i3, 1.0f);
    }

    public static CompactHashSet h(int i3) {
        return new CompactHashSet(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object n(int i3) {
        return y()[i3];
    }

    private int o(int i3) {
        return z()[i3];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i3 = objectInputStream.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Invalid size: " + i3);
        }
        u(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            add(objectInputStream.readObject());
        }
    }

    private int s() {
        return (1 << (this.f83839d & 31)) - 1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private Object[] y() {
        Object[] objArr = this.f83838c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] z() {
        int[] iArr = this.f83837b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    void B(int i3) {
        this.f83837b = Arrays.copyOf(z(), i3);
        this.f83838c = Arrays.copyOf(y(), i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (x()) {
            e();
        }
        Set setL = l();
        if (setL != null) {
            return setL.add(obj);
        }
        int[] iArrZ = z();
        Object[] objArrY = y();
        int i3 = this.f83840f;
        int i4 = i3 + 1;
        int iD = Hashing.d(obj);
        int iS = s();
        int i5 = iD & iS;
        int iH = CompactHashing.h(A(), i5);
        if (iH != 0) {
            int iB = CompactHashing.b(iD, iS);
            int i6 = 0;
            while (true) {
                int i7 = iH - 1;
                int i8 = iArrZ[i7];
                if (CompactHashing.b(i8, iS) == iB && com.google.common.base.Objects.a(obj, objArrY[i7])) {
                    return false;
                }
                int iC = CompactHashing.c(i8, iS);
                i6++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i6 >= 9) {
                        return f().add(obj);
                    }
                    if (i4 > iS) {
                        iS = D(iS, CompactHashing.e(iS), iD, i3);
                    } else {
                        iArrZ[i7] = CompactHashing.d(i8, i4, iS);
                    }
                }
            }
        } else if (i4 > iS) {
            iS = D(iS, CompactHashing.e(iS), iD, i3);
        } else {
            CompactHashing.i(A(), i5, i4);
        }
        C(i4);
        v(i3, obj, iD, iS);
        this.f83840f = i4;
        t();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (x()) {
            return;
        }
        t();
        Set setL = l();
        if (setL != null) {
            this.f83839d = Ints.f(size(), 3, 1073741823);
            setL.clear();
            this.f83836a = null;
            this.f83840f = 0;
            return;
        }
        Arrays.fill(y(), 0, this.f83840f, (Object) null);
        CompactHashing.g(A());
        Arrays.fill(z(), 0, this.f83840f, 0);
        this.f83840f = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (x()) {
            return false;
        }
        Set setL = l();
        if (setL != null) {
            return setL.contains(obj);
        }
        int iD = Hashing.d(obj);
        int iS = s();
        int iH = CompactHashing.h(A(), iD & iS);
        if (iH == 0) {
            return false;
        }
        int iB = CompactHashing.b(iD, iS);
        do {
            int i3 = iH - 1;
            int iO = o(i3);
            if (CompactHashing.b(iO, iS) == iB && com.google.common.base.Objects.a(obj, n(i3))) {
                return true;
            }
            iH = CompactHashing.c(iO, iS);
        } while (iH != 0);
        return false;
    }

    int d(int i3, int i4) {
        return i3 - 1;
    }

    int e() {
        Preconditions.A(x(), "Arrays already allocated");
        int i3 = this.f83839d;
        int iJ = CompactHashing.j(i3);
        this.f83836a = CompactHashing.a(iJ);
        H(iJ - 1);
        this.f83837b = new int[i3];
        this.f83838c = new Object[i3];
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Set f() {
        Set setG = g(s() + 1);
        int iP = p();
        while (iP >= 0) {
            setG.add(n(iP));
            iP = q(iP);
        }
        this.f83836a = setG;
        this.f83837b = null;
        this.f83838c = null;
        t();
        return setG;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        Set setL = l();
        return setL != null ? setL.iterator() : new Iterator<E>() { // from class: com.google.common.collect.CompactHashSet.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f83841a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f83842b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f83843c = -1;

            {
                this.f83841a = CompactHashSet.this.f83839d;
                this.f83842b = CompactHashSet.this.p();
            }

            private void a() {
                if (CompactHashSet.this.f83839d != this.f83841a) {
                    throw new ConcurrentModificationException();
                }
            }

            void b() {
                this.f83841a += 32;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f83842b >= 0;
            }

            @Override // java.util.Iterator
            public Object next() {
                a();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i3 = this.f83842b;
                this.f83843c = i3;
                Object objN = CompactHashSet.this.n(i3);
                this.f83842b = CompactHashSet.this.q(this.f83842b);
                return objN;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                CollectPreconditions.e(this.f83843c >= 0);
                b();
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.n(this.f83843c));
                this.f83842b = CompactHashSet.this.d(this.f83842b, this.f83843c);
                this.f83843c = -1;
            }
        };
    }

    Set l() {
        Object obj = this.f83836a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    int p() {
        return isEmpty() ? -1 : 0;
    }

    int q(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.f83840f) {
            return i4;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (x()) {
            return false;
        }
        Set setL = l();
        if (setL != null) {
            return setL.remove(obj);
        }
        int iS = s();
        int iF = CompactHashing.f(obj, null, iS, A(), z(), y(), null);
        if (iF == -1) {
            return false;
        }
        w(iF, iS);
        this.f83840f--;
        t();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set setL = l();
        return setL != null ? setL.size() : this.f83840f;
    }

    void t() {
        this.f83839d += 32;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (x()) {
            return new Object[0];
        }
        Set setL = l();
        return setL != null ? setL.toArray() : Arrays.copyOf(y(), this.f83840f);
    }

    void u(int i3) {
        Preconditions.e(i3 >= 0, "Expected size must be >= 0");
        this.f83839d = Ints.f(i3, 1, 1073741823);
    }

    void v(int i3, Object obj, int i4, int i5) {
        G(i3, CompactHashing.d(i4, 0, i5));
        E(i3, obj);
    }

    void w(int i3, int i4) {
        Object objA = A();
        int[] iArrZ = z();
        Object[] objArrY = y();
        int size = size();
        int i5 = size - 1;
        if (i3 >= i5) {
            objArrY[i3] = null;
            iArrZ[i3] = 0;
            return;
        }
        Object obj = objArrY[i5];
        objArrY[i3] = obj;
        objArrY[i5] = null;
        iArrZ[i3] = iArrZ[i5];
        iArrZ[i5] = 0;
        int iD = Hashing.d(obj) & i4;
        int iH = CompactHashing.h(objA, iD);
        if (iH == size) {
            CompactHashing.i(objA, iD, i3 + 1);
            return;
        }
        while (true) {
            int i6 = iH - 1;
            int i7 = iArrZ[i6];
            int iC = CompactHashing.c(i7, i4);
            if (iC == size) {
                iArrZ[i6] = CompactHashing.d(i7, i3 + 1, i4);
                return;
            }
            iH = iC;
        }
    }

    boolean x() {
        return this.f83836a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (x()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set setL = l();
        if (setL != null) {
            return setL.toArray(objArr);
        }
        return ObjectArrays.j(y(), 0, this.f83840f, objArr);
    }
}
