package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class w3 extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int[] f64542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient long[] f64543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f64544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient Object[] f64545d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    transient float f64546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    transient int f64547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f64548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient int f64549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient Set f64550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient Set f64551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private transient Collection f64552l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends e {
        a() {
            super(w3.this, null);
        }

        @Override // com.applovin.impl.w3.e
        Object a(int i3) {
            return w3.this.f64544c[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b extends e {
        b() {
            super(w3.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.applovin.impl.w3.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i3) {
            return w3.this.new g(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends e {
        c() {
            super(w3.this, null);
        }

        @Override // com.applovin.impl.w3.e
        Object a(int i3) {
            return w3.this.f64545d[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iA = w3.this.a(entry.getKey());
                if (iA != -1 && Objects.equal(w3.this.f64545d[iA], entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return w3.this.e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = w3.this.a(entry.getKey());
            if (iA == -1 || !Objects.equal(w3.this.f64545d[iA], entry.getValue())) {
                return false;
            }
            w3.this.f(iA);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return w3.this.f64549i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return w3.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return w3.this.h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iA = w3.this.a(obj);
            if (iA == -1) {
                return false;
            }
            w3.this.f(iA);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return w3.this.f64549i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class g extends com.applovin.impl.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f64562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f64563b;

        g(int i3) {
            this.f64562a = w3.this.f64544c[i3];
            this.f64563b = i3;
        }

        private void a() {
            int i3 = this.f64563b;
            if (i3 == -1 || i3 >= w3.this.size() || !Objects.equal(this.f64562a, w3.this.f64544c[this.f64563b])) {
                this.f64563b = w3.this.a(this.f64562a);
            }
        }

        @Override // com.applovin.impl.g, java.util.Map.Entry
        public Object getKey() {
            return this.f64562a;
        }

        @Override // com.applovin.impl.g, java.util.Map.Entry
        public Object getValue() {
            a();
            int i3 = this.f64563b;
            if (i3 == -1) {
                return null;
            }
            return w3.this.f64545d[i3];
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            int i3 = this.f64563b;
            if (i3 == -1) {
                w3.this.put(this.f64562a, obj);
                return null;
            }
            Object[] objArr = w3.this.f64545d;
            Object obj2 = objArr[i3];
            objArr[i3] = obj;
            return obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return w3.this.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return w3.this.f64549i;
        }
    }

    w3() {
        a(3, 1.0f);
    }

    private static int b(long j3) {
        return (int) j3;
    }

    private static long[] d(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] e(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int g() {
        return this.f64542a.length - 1;
    }

    private void h(int i3) {
        int length = this.f64543b.length;
        if (i3 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (iMax != length) {
                g(iMax);
            }
        }
    }

    private void i(int i3) {
        if (this.f64542a.length >= 1073741824) {
            this.f64548h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        int i4 = ((int) (i3 * this.f64546f)) + 1;
        int[] iArrE = e(i3);
        long[] jArr = this.f64543b;
        int length = iArrE.length - 1;
        for (int i5 = 0; i5 < this.f64549i; i5++) {
            int iA = a(jArr[i5]);
            int i6 = iA & length;
            int i7 = iArrE[i6];
            iArrE[i6] = i5;
            jArr[i5] = (((long) iA) << 32) | (((long) i7) & 4294967295L);
        }
        this.f64548h = i4;
        this.f64542a = iArrE;
    }

    int a(int i3, int i4) {
        return i3 - 1;
    }

    void c(int i3) {
        int size = size() - 1;
        if (i3 >= size) {
            this.f64544c[i3] = null;
            this.f64545d[i3] = null;
            this.f64543b[i3] = -1;
            return;
        }
        Object[] objArr = this.f64544c;
        objArr[i3] = objArr[size];
        Object[] objArr2 = this.f64545d;
        objArr2[i3] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.f64543b;
        long j3 = jArr[size];
        jArr[i3] = j3;
        jArr[size] = -1;
        int iA = a(j3) & g();
        int[] iArr = this.f64542a;
        int i4 = iArr[iA];
        if (i4 == size) {
            iArr[iA] = i3;
            return;
        }
        while (true) {
            long j4 = this.f64543b[i4];
            int iB = b(j4);
            if (iB == size) {
                this.f64543b[i4] = a(j4, i3);
                return;
            }
            i4 = iB;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f64547g++;
        Arrays.fill(this.f64544c, 0, this.f64549i, (Object) null);
        Arrays.fill(this.f64545d, 0, this.f64549i, (Object) null);
        Arrays.fill(this.f64542a, -1);
        Arrays.fill(this.f64543b, -1L);
        this.f64549i = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i3 = 0; i3 < this.f64549i; i3++) {
            if (Objects.equal(obj, this.f64545d[i3])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f64551k;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f64551k = setB;
        return setB;
    }

    int f() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        int iA = a(obj);
        a(iA);
        if (iA == -1) {
            return null;
        }
        return this.f64545d[iA];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f64549i == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f64550j;
        if (set != null) {
            return set;
        }
        Set setC = c();
        this.f64550j = setC;
        return setC;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        long[] jArr = this.f64543b;
        Object[] objArr = this.f64544c;
        Object[] objArr2 = this.f64545d;
        int iA = ja.a(obj);
        int iG = g() & iA;
        int i3 = this.f64549i;
        int[] iArr = this.f64542a;
        int i4 = iArr[iG];
        if (i4 == -1) {
            iArr[iG] = i3;
        } else {
            while (true) {
                long j3 = jArr[i4];
                if (a(j3) == iA && Objects.equal(obj, objArr[i4])) {
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = obj2;
                    a(i4);
                    return obj3;
                }
                int iB = b(j3);
                if (iB == -1) {
                    jArr[i4] = a(j3, i3);
                    break;
                }
                i4 = iB;
            }
        }
        if (i3 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i3 + 1;
        h(i5);
        a(i3, obj, obj2, iA);
        this.f64549i = i5;
        if (i3 >= this.f64548h) {
            i(this.f64542a.length * 2);
        }
        this.f64547g++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return a(obj, ja.a(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f64549i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f64552l;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f64552l = collectionD;
        return collectionD;
    }

    private static int a(long j3) {
        return (int) (j3 >>> 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f(int i3) {
        return a(this.f64544c[i3], a(this.f64543b[i3]));
    }

    int b(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.f64549i) {
            return i4;
        }
        return -1;
    }

    void g(int i3) {
        this.f64544c = Arrays.copyOf(this.f64544c, i3);
        this.f64545d = Arrays.copyOf(this.f64545d, i3);
        long[] jArr = this.f64543b;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(jArrCopyOf, length, i3, -1L);
        }
        this.f64543b = jArrCopyOf;
    }

    private static long a(long j3, int i3) {
        return (j3 & (-4294967296L)) | (((long) i3) & 4294967295L);
    }

    Set b() {
        return new d();
    }

    Collection d() {
        return new h();
    }

    Iterator e() {
        return new b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class e implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f64557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f64558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f64559c;

        private e() {
            this.f64557a = w3.this.f64547g;
            this.f64558b = w3.this.f();
            this.f64559c = -1;
        }

        private void a() {
            if (w3.this.f64547g != this.f64557a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object a(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f64558b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i3 = this.f64558b;
            this.f64559c = i3;
            Object objA = a(i3);
            this.f64558b = w3.this.b(this.f64558b);
            return objA;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            p3.a(this.f64559c >= 0);
            this.f64557a++;
            w3.this.f(this.f64559c);
            this.f64558b = w3.this.a(this.f64558b, this.f64559c);
            this.f64559c = -1;
        }

        /* synthetic */ e(w3 w3Var, a aVar) {
            this();
        }
    }

    void a(int i3) {
    }

    Iterator h() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Object obj) {
        int iA = ja.a(obj);
        int iB = this.f64542a[g() & iA];
        while (iB != -1) {
            long j3 = this.f64543b[iB];
            if (a(j3) == iA && Objects.equal(obj, this.f64544c[iB])) {
                return iB;
            }
            iB = b(j3);
        }
        return -1;
    }

    void a(int i3, float f3) {
        Preconditions.checkArgument(i3 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f3 > 0.0f, "Illegal load factor");
        int iA = ja.a(i3, f3);
        this.f64542a = e(iA);
        this.f64546f = f3;
        this.f64544c = new Object[i3];
        this.f64545d = new Object[i3];
        this.f64543b = d(i3);
        this.f64548h = Math.max(1, (int) (iA * f3));
    }

    Iterator i() {
        return new c();
    }

    Set c() {
        return new f();
    }

    void a(int i3, Object obj, Object obj2, int i4) {
        this.f64543b[i3] = (((long) i4) << 32) | 4294967295L;
        this.f64544c[i3] = obj;
        this.f64545d[i3] = obj2;
    }

    private Object a(Object obj, int i3) {
        int iG = g() & i3;
        int i4 = this.f64542a[iG];
        if (i4 == -1) {
            return null;
        }
        int i5 = -1;
        while (true) {
            if (a(this.f64543b[i4]) == i3 && Objects.equal(obj, this.f64544c[i4])) {
                Object obj2 = this.f64545d[i4];
                if (i5 == -1) {
                    this.f64542a[iG] = b(this.f64543b[i4]);
                } else {
                    long[] jArr = this.f64543b;
                    jArr[i5] = a(jArr[i5], b(jArr[i4]));
                }
                c(i4);
                this.f64549i--;
                this.f64547g++;
                return obj2;
            }
            int iB = b(this.f64543b[i4]);
            if (iB == -1) {
                return null;
            }
            i5 = i4;
            i4 = iB;
        }
    }

    public static w3 a() {
        return new w3();
    }
}
