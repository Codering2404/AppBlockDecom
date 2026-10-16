package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f83813k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Object f83814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int[] f83815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f83816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient Object[] f83817d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f83818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f83819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Set f83820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Set f83821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient Collection f83822j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map mapX = CompactHashMap.this.x();
            if (mapX != null) {
                return mapX.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iF = CompactHashMap.this.F(entry.getKey());
                if (iF != -1 && Objects.a(CompactHashMap.this.a0(iF), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.A();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD;
            int iF;
            Map mapX = CompactHashMap.this.x();
            if (mapX != null) {
                return mapX.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.L() || (iF = CompactHashing.f(entry.getKey(), entry.getValue(), (iD = CompactHashMap.this.D()), CompactHashMap.this.Q(), CompactHashMap.this.N(), CompactHashMap.this.P(), CompactHashMap.this.R())) == -1) {
                return false;
            }
            CompactHashMap.this.K(iF, iD);
            CompactHashMap.e(CompactHashMap.this);
            CompactHashMap.this.E();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class Itr<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f83827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f83828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f83829c;

        private Itr() {
            this.f83827a = CompactHashMap.this.f83818f;
            this.f83828b = CompactHashMap.this.B();
            this.f83829c = -1;
        }

        private void a() {
            if (CompactHashMap.this.f83818f != this.f83827a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i3);

        void c() {
            this.f83827a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f83828b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i3 = this.f83828b;
            this.f83829c = i3;
            Object objB = b(i3);
            this.f83828b = CompactHashMap.this.C(this.f83828b);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            CollectPreconditions.e(this.f83829c >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.I(this.f83829c));
            this.f83828b = CompactHashMap.this.o(this.f83828b, this.f83829c);
            this.f83829c = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return CompactHashMap.this.J();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapX = CompactHashMap.this.x();
            return mapX != null ? mapX.keySet().remove(obj) : CompactHashMap.this.M(obj) != CompactHashMap.f83813k;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class MapEntry extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f83832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f83833b;

        MapEntry(int i3) {
            this.f83832a = CompactHashMap.this.I(i3);
            this.f83833b = i3;
        }

        private void c() {
            int i3 = this.f83833b;
            if (i3 == -1 || i3 >= CompactHashMap.this.size() || !Objects.a(this.f83832a, CompactHashMap.this.I(this.f83833b))) {
                this.f83833b = CompactHashMap.this.F(this.f83832a);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getKey() {
            return this.f83832a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            Map mapX = CompactHashMap.this.x();
            if (mapX != null) {
                return NullnessCasts.a(mapX.get(this.f83832a));
            }
            c();
            int i3 = this.f83833b;
            return i3 == -1 ? NullnessCasts.b() : CompactHashMap.this.a0(i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map mapX = CompactHashMap.this.x();
            if (mapX != 0) {
                return NullnessCasts.a(mapX.put(this.f83832a, obj));
            }
            c();
            int i3 = this.f83833b;
            if (i3 == -1) {
                CompactHashMap.this.put(this.f83832a, obj);
                return NullnessCasts.b();
            }
            Object objA0 = CompactHashMap.this.a0(i3);
            CompactHashMap.this.Z(this.f83833b, obj);
            return objA0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return CompactHashMap.this.b0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        G(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        return (1 << (this.f83818f & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(Object obj) {
        if (L()) {
            return -1;
        }
        int iD = Hashing.d(obj);
        int iD2 = D();
        int iH = CompactHashing.h(Q(), iD & iD2);
        if (iH == 0) {
            return -1;
        }
        int iB = CompactHashing.b(iD, iD2);
        do {
            int i3 = iH - 1;
            int iY = y(i3);
            if (CompactHashing.b(iY, iD2) == iB && Objects.a(obj, I(i3))) {
                return i3;
            }
            iH = CompactHashing.c(iY, iD2);
        } while (iH != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object I(int i3) {
        return P()[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object M(Object obj) {
        if (L()) {
            return f83813k;
        }
        int iD = D();
        int iF = CompactHashing.f(obj, null, iD, Q(), N(), P(), null);
        if (iF == -1) {
            return f83813k;
        }
        Object objA0 = a0(iF);
        K(iF, iD);
        this.f83819g--;
        E();
        return objA0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] N() {
        int[] iArr = this.f83815b;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] P() {
        Object[] objArr = this.f83816c;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object Q() {
        Object obj = this.f83814a;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] R() {
        Object[] objArr = this.f83817d;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void T(int i3) {
        int iMin;
        int length = N().length;
        if (i3 <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        S(iMin);
    }

    private int U(int i3, int i4, int i5, int i6) {
        Object objA = CompactHashing.a(i4);
        int i7 = i4 - 1;
        if (i6 != 0) {
            CompactHashing.i(objA, i5 & i7, i6 + 1);
        }
        Object objQ = Q();
        int[] iArrN = N();
        for (int i8 = 0; i8 <= i3; i8++) {
            int iH = CompactHashing.h(objQ, i8);
            while (iH != 0) {
                int i9 = iH - 1;
                int i10 = iArrN[i9];
                int iB = CompactHashing.b(i10, i3) | i8;
                int i11 = iB & i7;
                int iH2 = CompactHashing.h(objA, i11);
                CompactHashing.i(objA, i11, iH);
                iArrN[i9] = CompactHashing.d(iB, iH2, i7);
                iH = CompactHashing.c(i10, i3);
            }
        }
        this.f83814a = objA;
        X(i7);
        return i7;
    }

    private void W(int i3, int i4) {
        N()[i3] = i4;
    }

    private void X(int i3) {
        this.f83818f = CompactHashing.d(this.f83818f, 32 - Integer.numberOfLeadingZeros(i3), 31);
    }

    private void Y(int i3, Object obj) {
        P()[i3] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i3, Object obj) {
        R()[i3] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a0(int i3) {
        return R()[i3];
    }

    static /* synthetic */ int e(CompactHashMap compactHashMap) {
        int i3 = compactHashMap.f83819g;
        compactHashMap.f83819g = i3 - 1;
        return i3;
    }

    public static CompactHashMap r() {
        return new CompactHashMap();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i3 = objectInputStream.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Invalid size: " + i3);
        }
        G(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public static CompactHashMap w(int i3) {
        return new CompactHashMap(i3);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator itA = A();
        while (itA.hasNext()) {
            Map.Entry entry = (Map.Entry) itA.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private int y(int i3) {
        return N()[i3];
    }

    Iterator A() {
        Map mapX = x();
        return mapX != null ? mapX.entrySet().iterator() : new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry b(int i3) {
                return new MapEntry(i3);
            }
        };
    }

    int B() {
        return isEmpty() ? -1 : 0;
    }

    int C(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.f83819g) {
            return i4;
        }
        return -1;
    }

    void E() {
        this.f83818f += 32;
    }

    void G(int i3) {
        Preconditions.e(i3 >= 0, "Expected size must be >= 0");
        this.f83818f = Ints.f(i3, 1, 1073741823);
    }

    void H(int i3, Object obj, Object obj2, int i4, int i5) {
        W(i3, CompactHashing.d(i4, 0, i5));
        Y(i3, obj);
        Z(i3, obj2);
    }

    Iterator J() {
        Map mapX = x();
        return mapX != null ? mapX.keySet().iterator() : new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            Object b(int i3) {
                return CompactHashMap.this.I(i3);
            }
        };
    }

    void K(int i3, int i4) {
        Object objQ = Q();
        int[] iArrN = N();
        Object[] objArrP = P();
        Object[] objArrR = R();
        int size = size();
        int i5 = size - 1;
        if (i3 >= i5) {
            objArrP[i3] = null;
            objArrR[i3] = null;
            iArrN[i3] = 0;
            return;
        }
        Object obj = objArrP[i5];
        objArrP[i3] = obj;
        objArrR[i3] = objArrR[i5];
        objArrP[i5] = null;
        objArrR[i5] = null;
        iArrN[i3] = iArrN[i5];
        iArrN[i5] = 0;
        int iD = Hashing.d(obj) & i4;
        int iH = CompactHashing.h(objQ, iD);
        if (iH == size) {
            CompactHashing.i(objQ, iD, i3 + 1);
            return;
        }
        while (true) {
            int i6 = iH - 1;
            int i7 = iArrN[i6];
            int iC = CompactHashing.c(i7, i4);
            if (iC == size) {
                iArrN[i6] = CompactHashing.d(i7, i3 + 1, i4);
                return;
            }
            iH = iC;
        }
    }

    boolean L() {
        return this.f83814a == null;
    }

    void S(int i3) {
        this.f83815b = Arrays.copyOf(N(), i3);
        this.f83816c = Arrays.copyOf(P(), i3);
        this.f83817d = Arrays.copyOf(R(), i3);
    }

    Iterator b0() {
        Map mapX = x();
        return mapX != null ? mapX.values().iterator() : new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            Object b(int i3) {
                return CompactHashMap.this.a0(i3);
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (L()) {
            return;
        }
        E();
        Map mapX = x();
        if (mapX != null) {
            this.f83818f = Ints.f(size(), 3, 1073741823);
            mapX.clear();
            this.f83814a = null;
            this.f83819g = 0;
            return;
        }
        Arrays.fill(P(), 0, this.f83819g, (Object) null);
        Arrays.fill(R(), 0, this.f83819g, (Object) null);
        CompactHashing.g(Q());
        Arrays.fill(N(), 0, this.f83819g, 0);
        this.f83819g = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map mapX = x();
        return mapX != null ? mapX.containsKey(obj) : F(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.containsValue(obj);
        }
        for (int i3 = 0; i3 < this.f83819g; i3++) {
            if (Objects.a(obj, a0(i3))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f83821i;
        if (set != null) {
            return set;
        }
        Set setS = s();
        this.f83821i = setS;
        return setS;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.get(obj);
        }
        int iF = F(obj);
        if (iF == -1) {
            return null;
        }
        n(iF);
        return a0(iF);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f83820h;
        if (set != null) {
            return set;
        }
        Set setU = u();
        this.f83820h = setU;
        return setU;
    }

    int o(int i3, int i4) {
        return i3 - 1;
    }

    int p() {
        Preconditions.A(L(), "Arrays already allocated");
        int i3 = this.f83818f;
        int iJ = CompactHashing.j(i3);
        this.f83814a = CompactHashing.a(iJ);
        X(iJ - 1);
        this.f83815b = new int[i3];
        this.f83816c = new Object[i3];
        this.f83817d = new Object[i3];
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (L()) {
            p();
        }
        Map mapX = x();
        if (mapX != null) {
            return mapX.put(obj, obj2);
        }
        int[] iArrN = N();
        Object[] objArrP = P();
        Object[] objArrR = R();
        int i3 = this.f83819g;
        int i4 = i3 + 1;
        int iD = Hashing.d(obj);
        int iD2 = D();
        int i5 = iD & iD2;
        int iH = CompactHashing.h(Q(), i5);
        if (iH != 0) {
            int iB = CompactHashing.b(iD, iD2);
            int i6 = 0;
            while (true) {
                int i7 = iH - 1;
                int i8 = iArrN[i7];
                if (CompactHashing.b(i8, iD2) == iB && Objects.a(obj, objArrP[i7])) {
                    Object obj3 = objArrR[i7];
                    objArrR[i7] = obj2;
                    n(i7);
                    return obj3;
                }
                int iC = CompactHashing.c(i8, iD2);
                i6++;
                if (iC != 0) {
                    obj = obj;
                    obj2 = obj2;
                    iH = iC;
                } else {
                    if (i6 >= 9) {
                        return q().put(obj, obj2);
                    }
                    if (i4 > iD2) {
                        iD2 = U(iD2, CompactHashing.e(iD2), iD, i3);
                    } else {
                        iArrN[i7] = CompactHashing.d(i8, i4, iD2);
                    }
                }
            }
        } else if (i4 > iD2) {
            iD2 = U(iD2, CompactHashing.e(iD2), iD, i3);
        } else {
            CompactHashing.i(Q(), i5, i4);
        }
        int i9 = iD2;
        T(i4);
        H(i3, obj, obj2, iD, i9);
        this.f83819g = i4;
        E();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Map q() {
        Map mapT = t(D() + 1);
        int iB = B();
        while (iB >= 0) {
            mapT.put(I(iB), a0(iB));
            iB = C(iB);
        }
        this.f83814a = mapT;
        this.f83815b = null;
        this.f83816c = null;
        this.f83817d = null;
        E();
        return mapT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map mapX = x();
        if (mapX != null) {
            return mapX.remove(obj);
        }
        Object objM = M(obj);
        if (objM == f83813k) {
            return null;
        }
        return objM;
    }

    Set s() {
        return new EntrySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map mapX = x();
        return mapX != null ? mapX.size() : this.f83819g;
    }

    Map t(int i3) {
        return new LinkedHashMap(i3, 1.0f);
    }

    Set u() {
        return new KeySetView();
    }

    Collection v() {
        return new ValuesView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f83822j;
        if (collection != null) {
            return collection;
        }
        Collection collectionV = v();
        this.f83822j = collectionV;
        return collectionV;
    }

    Map x() {
        Object obj = this.f83814a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    CompactHashMap(int i3) {
        G(i3);
    }

    void n(int i3) {
    }
}
