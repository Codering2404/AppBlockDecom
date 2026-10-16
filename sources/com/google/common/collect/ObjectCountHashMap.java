package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class ObjectCountHashMap<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient Object[] f84539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int[] f84540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient int f84541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient int f84542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient int[] f84543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    transient long[] f84544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient float f84545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f84546h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MapEntry extends Multisets.AbstractEntry<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f84548b;

        MapEntry(int i3) {
            this.f84547a = ObjectCountHashMap.this.f84539a[i3];
            this.f84548b = i3;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public Object a() {
            return this.f84547a;
        }

        void b() {
            int i3 = this.f84548b;
            if (i3 == -1 || i3 >= ObjectCountHashMap.this.C() || !Objects.a(this.f84547a, ObjectCountHashMap.this.f84539a[this.f84548b])) {
                this.f84548b = ObjectCountHashMap.this.m(this.f84547a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            b();
            int i3 = this.f84548b;
            if (i3 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.f84540b[i3];
        }
    }

    ObjectCountHashMap() {
        n(3, 1.0f);
    }

    private void A(int i3) {
        if (this.f84543e.length >= 1073741824) {
            this.f84546h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        int i4 = ((int) (i3 * this.f84545g)) + 1;
        int[] iArrR = r(i3);
        long[] jArr = this.f84544f;
        int length = iArrR.length - 1;
        for (int i5 = 0; i5 < this.f84541c; i5++) {
            int iH = h(jArr[i5]);
            int i6 = iH & length;
            int i7 = iArrR[i6];
            iArrR[i6] = i5;
            jArr[i5] = (((long) iH) << 32) | (((long) i7) & 4294967295L);
        }
        this.f84546h = i4;
        this.f84543e = iArrR;
    }

    private static long D(long j3, int i3) {
        return (j3 & (-4294967296L)) | (4294967295L & ((long) i3));
    }

    static ObjectCountHashMap b() {
        return new ObjectCountHashMap();
    }

    static ObjectCountHashMap c(int i3) {
        return new ObjectCountHashMap(i3);
    }

    private static int h(long j3) {
        return (int) (j3 >>> 32);
    }

    private static int j(long j3) {
        return (int) j3;
    }

    private int l() {
        return this.f84543e.length - 1;
    }

    private static long[] q(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(Object obj, int i3) {
        int iL = l() & i3;
        int i4 = this.f84543e[iL];
        if (i4 == -1) {
            return 0;
        }
        int i5 = -1;
        while (true) {
            if (h(this.f84544f[i4]) == i3 && Objects.a(obj, this.f84539a[i4])) {
                int i6 = this.f84540b[i4];
                if (i5 == -1) {
                    this.f84543e[iL] = j(this.f84544f[i4]);
                } else {
                    long[] jArr = this.f84544f;
                    jArr[i5] = D(jArr[i5], j(jArr[i4]));
                }
                p(i4);
                this.f84541c--;
                this.f84542d++;
                return i6;
            }
            int iJ = j(this.f84544f[i4]);
            if (iJ == -1) {
                return 0;
            }
            i5 = i4;
            i4 = iJ;
        }
    }

    private void z(int i3) {
        int length = this.f84544f.length;
        if (i3 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (iMax != length) {
                y(iMax);
            }
        }
    }

    void B(int i3, int i4) {
        Preconditions.r(i3, this.f84541c);
        this.f84540b[i3] = i4;
    }

    int C() {
        return this.f84541c;
    }

    public void a() {
        this.f84542d++;
        Arrays.fill(this.f84539a, 0, this.f84541c, (Object) null);
        Arrays.fill(this.f84540b, 0, this.f84541c, 0);
        Arrays.fill(this.f84543e, -1);
        Arrays.fill(this.f84544f, -1L);
        this.f84541c = 0;
    }

    void d(int i3) {
        if (i3 > this.f84544f.length) {
            y(i3);
        }
        if (i3 >= this.f84546h) {
            A(Math.max(2, Integer.highestOneBit(i3 - 1) << 1));
        }
    }

    int e() {
        return this.f84541c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int iM = m(obj);
        if (iM == -1) {
            return 0;
        }
        return this.f84540b[iM];
    }

    Multiset.Entry g(int i3) {
        Preconditions.r(i3, this.f84541c);
        return new MapEntry(i3);
    }

    Object i(int i3) {
        Preconditions.r(i3, this.f84541c);
        return this.f84539a[i3];
    }

    int k(int i3) {
        Preconditions.r(i3, this.f84541c);
        return this.f84540b[i3];
    }

    int m(Object obj) {
        int iD = Hashing.d(obj);
        int iJ = this.f84543e[l() & iD];
        while (iJ != -1) {
            long j3 = this.f84544f[iJ];
            if (h(j3) == iD && Objects.a(obj, this.f84539a[iJ])) {
                return iJ;
            }
            iJ = j(j3);
        }
        return -1;
    }

    void n(int i3, float f3) {
        Preconditions.e(i3 >= 0, "Initial capacity must be non-negative");
        Preconditions.e(f3 > 0.0f, "Illegal load factor");
        int iA = Hashing.a(i3, f3);
        this.f84543e = r(iA);
        this.f84545g = f3;
        this.f84539a = new Object[i3];
        this.f84540b = new int[i3];
        this.f84544f = q(i3);
        this.f84546h = Math.max(1, (int) (iA * f3));
    }

    void o(int i3, Object obj, int i4, int i5) {
        this.f84544f[i3] = (((long) i5) << 32) | 4294967295L;
        this.f84539a[i3] = obj;
        this.f84540b[i3] = i4;
    }

    void p(int i3) {
        int iC = C() - 1;
        if (i3 >= iC) {
            this.f84539a[i3] = null;
            this.f84540b[i3] = 0;
            this.f84544f[i3] = -1;
            return;
        }
        Object[] objArr = this.f84539a;
        objArr[i3] = objArr[iC];
        int[] iArr = this.f84540b;
        iArr[i3] = iArr[iC];
        objArr[iC] = null;
        iArr[iC] = 0;
        long[] jArr = this.f84544f;
        long j3 = jArr[iC];
        jArr[i3] = j3;
        jArr[iC] = -1;
        int iH = h(j3) & l();
        int[] iArr2 = this.f84543e;
        int i4 = iArr2[iH];
        if (i4 == iC) {
            iArr2[iH] = i3;
            return;
        }
        while (true) {
            long j4 = this.f84544f[i4];
            int iJ = j(j4);
            if (iJ == iC) {
                this.f84544f[i4] = D(j4, i3);
                return;
            }
            i4 = iJ;
        }
    }

    int s(int i3) {
        int i4 = i3 + 1;
        if (i4 < this.f84541c) {
            return i4;
        }
        return -1;
    }

    int t(int i3, int i4) {
        return i3 - 1;
    }

    public int u(Object obj, int i3) {
        CollectPreconditions.d(i3, "count");
        long[] jArr = this.f84544f;
        Object[] objArr = this.f84539a;
        int[] iArr = this.f84540b;
        int iD = Hashing.d(obj);
        int iL = l() & iD;
        int i4 = this.f84541c;
        int[] iArr2 = this.f84543e;
        int i5 = iArr2[iL];
        if (i5 == -1) {
            iArr2[iL] = i4;
        } else {
            while (true) {
                long j3 = jArr[i5];
                if (h(j3) == iD && Objects.a(obj, objArr[i5])) {
                    int i6 = iArr[i5];
                    iArr[i5] = i3;
                    return i6;
                }
                int iJ = j(j3);
                if (iJ == -1) {
                    jArr[i5] = D(j3, i4);
                    break;
                }
                i5 = iJ;
            }
        }
        if (i4 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i7 = i4 + 1;
        z(i7);
        o(i4, obj, i3, iD);
        this.f84541c = i7;
        if (i4 >= this.f84546h) {
            A(this.f84543e.length * 2);
        }
        this.f84542d++;
        return 0;
    }

    public int v(Object obj) {
        return w(obj, Hashing.d(obj));
    }

    int x(int i3) {
        return w(this.f84539a[i3], h(this.f84544f[i3]));
    }

    void y(int i3) {
        this.f84539a = Arrays.copyOf(this.f84539a, i3);
        this.f84540b = Arrays.copyOf(this.f84540b, i3);
        long[] jArr = this.f84544f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(jArrCopyOf, length, i3, -1L);
        }
        this.f84544f = jArrCopyOf;
    }

    ObjectCountHashMap(ObjectCountHashMap objectCountHashMap) {
        n(objectCountHashMap.C(), 1.0f);
        int iE = objectCountHashMap.e();
        while (iE != -1) {
            u(objectCountHashMap.i(iE), objectCountHashMap.k(iE));
            iE = objectCountHashMap.s(iE);
        }
    }

    ObjectCountHashMap(int i3) {
        this(i3, 1.0f);
    }

    ObjectCountHashMap(int i3, float f3) {
        n(i3, f3);
    }
}
