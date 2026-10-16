package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient Object[] f83967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient Object[] f83968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient int f83969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient int f83970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int[] f83971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int[] f83972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int[] f83973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient int[] f83974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient int f83975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient int f83976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private transient int[] f83977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private transient int[] f83978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient Set f83979n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private transient Set f83980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private transient Set f83981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private transient BiMap f83982q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntryForKey extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f83984b;

        EntryForKey(int i3) {
            this.f83983a = NullnessCasts.a(HashBiMap.this.f83967a[i3]);
            this.f83984b = i3;
        }

        void c() {
            int i3 = this.f83984b;
            if (i3 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i3 <= hashBiMap.f83969c && Objects.a(hashBiMap.f83967a[i3], this.f83983a)) {
                    return;
                }
            }
            this.f83984b = HashBiMap.this.m(this.f83983a);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getKey() {
            return this.f83983a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            c();
            int i3 = this.f83984b;
            return i3 == -1 ? NullnessCasts.b() : NullnessCasts.a(HashBiMap.this.f83968b[i3]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            c();
            int i3 = this.f83984b;
            if (i3 == -1) {
                HashBiMap.this.put(this.f83983a, obj);
                return NullnessCasts.b();
            }
            Object objA = NullnessCasts.a(HashBiMap.this.f83968b[i3]);
            if (Objects.a(objA, obj)) {
                return obj;
            }
            HashBiMap.this.E(this.f83984b, obj, false);
            return objA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final HashBiMap f83986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f83987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f83988c;

        EntryForValue(HashBiMap hashBiMap, int i3) {
            this.f83986a = hashBiMap;
            this.f83987b = NullnessCasts.a(hashBiMap.f83968b[i3]);
            this.f83988c = i3;
        }

        private void c() {
            int i3 = this.f83988c;
            if (i3 != -1) {
                HashBiMap hashBiMap = this.f83986a;
                if (i3 <= hashBiMap.f83969c && Objects.a(this.f83987b, hashBiMap.f83968b[i3])) {
                    return;
                }
            }
            this.f83988c = this.f83986a.o(this.f83987b);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getKey() {
            return this.f83987b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            c();
            int i3 = this.f83988c;
            return i3 == -1 ? NullnessCasts.b() : NullnessCasts.a(this.f83986a.f83967a[i3]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            c();
            int i3 = this.f83988c;
            if (i3 == -1) {
                this.f83986a.w(this.f83987b, obj, false);
                return NullnessCasts.b();
            }
            Object objA = NullnessCasts.a(this.f83986a.f83967a[i3]);
            if (Objects.a(objA, obj)) {
                return obj;
            }
            this.f83986a.D(this.f83988c, obj, false);
            return objA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i3) {
            return new EntryForKey(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int iM = HashBiMap.this.m(key);
                if (iM != -1 && Objects.a(value, HashBiMap.this.f83968b[iM])) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = Hashing.d(key);
            int iN = HashBiMap.this.n(key, iD);
            if (iN == -1 || !Objects.a(value, HashBiMap.this.f83968b[iN])) {
                return false;
            }
            HashBiMap.this.A(iN, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashBiMap f83990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set f83991b;

        Inverse(HashBiMap hashBiMap) {
            this.f83990a = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f83990a.f83982q = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f83990a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f83990a.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.f83990a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f83991b;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.f83990a);
            this.f83991b = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return this.f83990a.q(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f83990a.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.f83990a.w(obj, obj2, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return this.f83990a.C(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f83990a.f83969c;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap u1() {
            return this.f83990a;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set values() {
            return this.f83990a.keySet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i3) {
            return new EntryForValue(this.f83994a, i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int iO = this.f83994a.o(key);
                if (iO != -1 && Objects.a(this.f83994a.f83967a[iO], value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = Hashing.d(key);
            int iP = this.f83994a.p(key, iD);
            if (iP == -1 || !Objects.a(this.f83994a.f83967a[iP], value)) {
                return false;
            }
            this.f83994a.B(iP, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        Object a(int i3) {
            return NullnessCasts.a(HashBiMap.this.f83967a[i3]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = Hashing.d(obj);
            int iN = HashBiMap.this.n(obj, iD);
            if (iN == -1) {
                return false;
            }
            HashBiMap.this.A(iN, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        Object a(int i3) {
            return NullnessCasts.a(HashBiMap.this.f83968b[i3]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = Hashing.d(obj);
            int iP = HashBiMap.this.p(obj, iD);
            if (iP == -1) {
                return false;
            }
            HashBiMap.this.B(iP, iD);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class View<K, V, T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final HashBiMap f83994a;

        View(HashBiMap hashBiMap) {
            this.f83994a = hashBiMap;
        }

        abstract Object a(int i3);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f83994a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private int f83995a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private int f83996b = -1;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private int f83997c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private int f83998d;

                {
                    this.f83995a = View.this.f83994a.f83975j;
                    HashBiMap hashBiMap = View.this.f83994a;
                    this.f83997c = hashBiMap.f83970d;
                    this.f83998d = hashBiMap.f83969c;
                }

                private void a() {
                    if (View.this.f83994a.f83970d != this.f83997c) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    a();
                    return this.f83995a != -2 && this.f83998d > 0;
                }

                @Override // java.util.Iterator
                public Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object objA = View.this.a(this.f83995a);
                    this.f83996b = this.f83995a;
                    this.f83995a = View.this.f83994a.f83978m[this.f83995a];
                    this.f83998d--;
                    return objA;
                }

                @Override // java.util.Iterator
                public void remove() {
                    a();
                    CollectPreconditions.e(this.f83996b != -1);
                    View.this.f83994a.x(this.f83996b);
                    int i3 = this.f83995a;
                    HashBiMap hashBiMap = View.this.f83994a;
                    if (i3 == hashBiMap.f83969c) {
                        this.f83995a = this.f83996b;
                    }
                    this.f83996b = -1;
                    this.f83997c = hashBiMap.f83970d;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f83994a.f83969c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i3, Object obj, boolean z2) {
        int i4;
        Preconditions.d(i3 != -1);
        int iD = Hashing.d(obj);
        int iN = n(obj, iD);
        int i5 = this.f83976k;
        if (iN == -1) {
            i4 = -2;
        } else {
            if (!z2) {
                throw new IllegalArgumentException("Key already present in map: " + obj);
            }
            i5 = this.f83977l[iN];
            i4 = this.f83978m[iN];
            A(iN, iD);
            if (i3 == this.f83969c) {
                i3 = iN;
            }
        }
        if (i5 == i3) {
            i5 = this.f83977l[i3];
        } else if (i5 == this.f83969c) {
            i5 = iN;
        }
        if (i4 == i3) {
            iN = this.f83978m[i3];
        } else if (i4 != this.f83969c) {
            iN = i4;
        }
        F(this.f83977l[i3], this.f83978m[i3]);
        h(i3, Hashing.d(this.f83967a[i3]));
        this.f83967a[i3] = obj;
        s(i3, Hashing.d(obj));
        F(i5, i3);
        F(i3, iN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, Object obj, boolean z2) {
        Preconditions.d(i3 != -1);
        int iD = Hashing.d(obj);
        int iP = p(obj, iD);
        if (iP != -1) {
            if (!z2) {
                throw new IllegalArgumentException("Value already present in map: " + obj);
            }
            B(iP, iD);
            if (i3 == this.f83969c) {
                i3 = iP;
            }
        }
        i(i3, Hashing.d(this.f83968b[i3]));
        this.f83968b[i3] = obj;
        t(i3, iD);
    }

    private void F(int i3, int i4) {
        if (i3 == -2) {
            this.f83975j = i4;
        } else {
            this.f83978m[i3] = i4;
        }
        if (i4 == -2) {
            this.f83976k = i3;
        } else {
            this.f83977l[i4] = i3;
        }
    }

    private int f(int i3) {
        return i3 & (this.f83971f.length - 1);
    }

    private static int[] g(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void h(int i3, int i4) {
        Preconditions.d(i3 != -1);
        int iF = f(i4);
        int[] iArr = this.f83971f;
        int i5 = iArr[iF];
        if (i5 == i3) {
            int[] iArr2 = this.f83973h;
            iArr[iF] = iArr2[i3];
            iArr2[i3] = -1;
            return;
        }
        int i6 = this.f83973h[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.f83967a[i3]);
            }
            if (i5 == i3) {
                int[] iArr3 = this.f83973h;
                iArr3[i7] = iArr3[i3];
                iArr3[i3] = -1;
                return;
            }
            i6 = this.f83973h[i5];
        }
    }

    private void i(int i3, int i4) {
        Preconditions.d(i3 != -1);
        int iF = f(i4);
        int[] iArr = this.f83972g;
        int i5 = iArr[iF];
        if (i5 == i3) {
            int[] iArr2 = this.f83974i;
            iArr[iF] = iArr2[i3];
            iArr2[i3] = -1;
            return;
        }
        int i6 = this.f83974i[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.f83968b[i3]);
            }
            if (i5 == i3) {
                int[] iArr3 = this.f83974i;
                iArr3[i7] = iArr3[i3];
                iArr3[i3] = -1;
                return;
            }
            i6 = this.f83974i[i5];
        }
    }

    private void j(int i3) {
        int[] iArr = this.f83973h;
        if (iArr.length < i3) {
            int iD = ImmutableCollection.Builder.d(iArr.length, i3);
            this.f83967a = Arrays.copyOf(this.f83967a, iD);
            this.f83968b = Arrays.copyOf(this.f83968b, iD);
            this.f83973h = k(this.f83973h, iD);
            this.f83974i = k(this.f83974i, iD);
            this.f83977l = k(this.f83977l, iD);
            this.f83978m = k(this.f83978m, iD);
        }
        if (this.f83971f.length < i3) {
            int iA = Hashing.a(i3, 1.0d);
            this.f83971f = g(iA);
            this.f83972g = g(iA);
            for (int i4 = 0; i4 < this.f83969c; i4++) {
                int iF = f(Hashing.d(this.f83967a[i4]));
                int[] iArr2 = this.f83973h;
                int[] iArr3 = this.f83971f;
                iArr2[i4] = iArr3[iF];
                iArr3[iF] = i4;
                int iF2 = f(Hashing.d(this.f83968b[i4]));
                int[] iArr4 = this.f83974i;
                int[] iArr5 = this.f83972g;
                iArr4[i4] = iArr5[iF2];
                iArr5[iF2] = i4;
            }
        }
    }

    private static int[] k(int[] iArr, int i3) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
        Arrays.fill(iArrCopyOf, length, i3, -1);
        return iArrCopyOf;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = Serialization.h(objectInputStream);
        r(16);
        Serialization.c(this, objectInputStream, iH);
    }

    private void s(int i3, int i4) {
        Preconditions.d(i3 != -1);
        int iF = f(i4);
        int[] iArr = this.f83973h;
        int[] iArr2 = this.f83971f;
        iArr[i3] = iArr2[iF];
        iArr2[iF] = i3;
    }

    private void t(int i3, int i4) {
        Preconditions.d(i3 != -1);
        int iF = f(i4);
        int[] iArr = this.f83974i;
        int[] iArr2 = this.f83972g;
        iArr[i3] = iArr2[iF];
        iArr2[iF] = i3;
    }

    private void u(int i3, int i4) {
        int i5;
        int i6;
        if (i3 == i4) {
            return;
        }
        int i7 = this.f83977l[i3];
        int i8 = this.f83978m[i3];
        F(i7, i4);
        F(i4, i8);
        Object[] objArr = this.f83967a;
        Object obj = objArr[i3];
        Object[] objArr2 = this.f83968b;
        Object obj2 = objArr2[i3];
        objArr[i4] = obj;
        objArr2[i4] = obj2;
        int iF = f(Hashing.d(obj));
        int[] iArr = this.f83971f;
        int i9 = iArr[iF];
        if (i9 == i3) {
            iArr[iF] = i4;
        } else {
            int i10 = this.f83973h[i9];
            while (true) {
                i5 = i9;
                i9 = i10;
                if (i9 == i3) {
                    break;
                } else {
                    i10 = this.f83973h[i9];
                }
            }
            this.f83973h[i5] = i4;
        }
        int[] iArr2 = this.f83973h;
        iArr2[i4] = iArr2[i3];
        iArr2[i3] = -1;
        int iF2 = f(Hashing.d(obj2));
        int[] iArr3 = this.f83972g;
        int i11 = iArr3[iF2];
        if (i11 == i3) {
            iArr3[iF2] = i4;
        } else {
            int i12 = this.f83974i[i11];
            while (true) {
                i6 = i11;
                i11 = i12;
                if (i11 == i3) {
                    break;
                } else {
                    i12 = this.f83974i[i11];
                }
            }
            this.f83974i[i6] = i4;
        }
        int[] iArr4 = this.f83974i;
        iArr4[i4] = iArr4[i3];
        iArr4[i3] = -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.i(this, objectOutputStream);
    }

    private void y(int i3, int i4, int i5) {
        Preconditions.d(i3 != -1);
        h(i3, i4);
        i(i3, i5);
        F(this.f83977l[i3], this.f83978m[i3]);
        u(this.f83969c - 1, i3);
        Object[] objArr = this.f83967a;
        int i6 = this.f83969c;
        objArr[i6 - 1] = null;
        this.f83968b[i6 - 1] = null;
        this.f83969c = i6 - 1;
        this.f83970d++;
    }

    void A(int i3, int i4) {
        y(i3, i4, Hashing.d(this.f83968b[i3]));
    }

    void B(int i3, int i4) {
        y(i3, Hashing.d(this.f83967a[i3]), i4);
    }

    Object C(Object obj) {
        int iD = Hashing.d(obj);
        int iP = p(obj, iD);
        if (iP == -1) {
            return null;
        }
        Object obj2 = this.f83967a[iP];
        B(iP, iD);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f83967a, 0, this.f83969c, (Object) null);
        Arrays.fill(this.f83968b, 0, this.f83969c, (Object) null);
        Arrays.fill(this.f83971f, -1);
        Arrays.fill(this.f83972g, -1);
        Arrays.fill(this.f83973h, 0, this.f83969c, -1);
        Arrays.fill(this.f83974i, 0, this.f83969c, -1);
        Arrays.fill(this.f83977l, 0, this.f83969c, -1);
        Arrays.fill(this.f83978m, 0, this.f83969c, -1);
        this.f83969c = 0;
        this.f83975j = -2;
        this.f83976k = -2;
        this.f83970d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return o(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f83981p;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f83981p = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        int iM = m(obj);
        if (iM == -1) {
            return null;
        }
        return this.f83968b[iM];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f83979n;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f83979n = keySet;
        return keySet;
    }

    int l(Object obj, int i3, int[] iArr, int[] iArr2, Object[] objArr) {
        int i4 = iArr[f(i3)];
        while (i4 != -1) {
            if (Objects.a(objArr[i4], obj)) {
                return i4;
            }
            i4 = iArr2[i4];
        }
        return -1;
    }

    int m(Object obj) {
        return n(obj, Hashing.d(obj));
    }

    int n(Object obj, int i3) {
        return l(obj, i3, this.f83971f, this.f83973h, this.f83967a);
    }

    int o(Object obj) {
        return p(obj, Hashing.d(obj));
    }

    int p(Object obj, int i3) {
        return l(obj, i3, this.f83972g, this.f83974i, this.f83968b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return v(obj, obj2, false);
    }

    Object q(Object obj) {
        int iO = o(obj);
        if (iO == -1) {
            return null;
        }
        return this.f83967a[iO];
    }

    void r(int i3) {
        CollectPreconditions.b(i3, "expectedSize");
        int iA = Hashing.a(i3, 1.0d);
        this.f83969c = 0;
        this.f83967a = new Object[i3];
        this.f83968b = new Object[i3];
        this.f83971f = g(iA);
        this.f83972g = g(iA);
        this.f83973h = g(i3);
        this.f83974i = g(i3);
        this.f83975j = -2;
        this.f83976k = -2;
        this.f83977l = g(i3);
        this.f83978m = g(i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        int iD = Hashing.d(obj);
        int iN = n(obj, iD);
        if (iN == -1) {
            return null;
        }
        Object obj2 = this.f83968b[iN];
        A(iN, iD);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f83969c;
    }

    @Override // com.google.common.collect.BiMap
    public BiMap u1() {
        BiMap biMap = this.f83982q;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.f83982q = inverse;
        return inverse;
    }

    Object v(Object obj, Object obj2, boolean z2) {
        int iD = Hashing.d(obj);
        int iN = n(obj, iD);
        if (iN != -1) {
            Object obj3 = this.f83968b[iN];
            if (Objects.a(obj3, obj2)) {
                return obj2;
            }
            E(iN, obj2, z2);
            return obj3;
        }
        int iD2 = Hashing.d(obj2);
        int iP = p(obj2, iD2);
        if (!z2) {
            Preconditions.m(iP == -1, "Value already present: %s", obj2);
        } else if (iP != -1) {
            B(iP, iD2);
        }
        j(this.f83969c + 1);
        Object[] objArr = this.f83967a;
        int i3 = this.f83969c;
        objArr[i3] = obj;
        this.f83968b[i3] = obj2;
        s(i3, iD);
        t(this.f83969c, iD2);
        F(this.f83976k, this.f83969c);
        F(this.f83969c, -2);
        this.f83969c++;
        this.f83970d++;
        return null;
    }

    Object w(Object obj, Object obj2, boolean z2) {
        int iD = Hashing.d(obj);
        int iP = p(obj, iD);
        if (iP != -1) {
            Object obj3 = this.f83967a[iP];
            if (Objects.a(obj3, obj2)) {
                return obj2;
            }
            D(iP, obj2, z2);
            return obj3;
        }
        int i3 = this.f83976k;
        int iD2 = Hashing.d(obj2);
        int iN = n(obj2, iD2);
        if (!z2) {
            Preconditions.m(iN == -1, "Key already present: %s", obj2);
        } else if (iN != -1) {
            i3 = this.f83977l[iN];
            A(iN, iD2);
        }
        j(this.f83969c + 1);
        Object[] objArr = this.f83967a;
        int i4 = this.f83969c;
        objArr[i4] = obj2;
        this.f83968b[i4] = obj;
        s(i4, iD2);
        t(this.f83969c, iD);
        int i5 = i3 == -2 ? this.f83975j : this.f83978m[i3];
        F(i3, this.f83969c);
        F(this.f83969c, i5);
        this.f83969c++;
        this.f83970d++;
        return null;
    }

    void x(int i3) {
        A(i3, Hashing.d(this.f83967a[i3]));
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set values() {
        Set set = this.f83980o;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.f83980o = valueSet;
        return valueSet;
    }
}
