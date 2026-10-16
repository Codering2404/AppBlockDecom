package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ni extends fb {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final fb f62051i = new ni(null, new Object[0], 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int[] f62052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient Object[] f62053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f62054h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class a extends hb {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient fb f62055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient Object[] f62056d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f62057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final transient int f62058g;

        /* JADX INFO: renamed from: com.applovin.impl.ni$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0114a extends db {
            C0114a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i3) {
                Preconditions.checkElementIndex(i3, a.this.f62058g);
                int i4 = i3 * 2;
                return new AbstractMap.SimpleImmutableEntry(a.this.f62056d[a.this.f62057f + i4], a.this.f62056d[i4 + (a.this.f62057f ^ 1)]);
            }

            @Override // com.applovin.impl.bb
            public boolean e() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f62058g;
            }
        }

        a(fb fbVar, Object[] objArr, int i3, int i4) {
            this.f62055c = fbVar;
            this.f62056d = objArr;
            this.f62057f = i3;
            this.f62058g = i4;
        }

        @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f62055c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.impl.bb
        boolean e() {
            return true;
        }

        @Override // com.applovin.impl.hb
        db f() {
            return new C0114a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public pp iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f62058g;
        }

        @Override // com.applovin.impl.bb
        int a(Object[] objArr, int i3) {
            return a().a(objArr, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class b extends hb {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient fb f62060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient db f62061d;

        b(fb fbVar, db dbVar) {
            this.f62060c = fbVar;
            this.f62061d = dbVar;
        }

        @Override // com.applovin.impl.hb, com.applovin.impl.bb
        public db a() {
            return this.f62061d;
        }

        @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f62060c.get(obj) != null;
        }

        @Override // com.applovin.impl.bb
        boolean e() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public pp iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f62060c.size();
        }

        @Override // com.applovin.impl.bb
        int a(Object[] objArr, int i3) {
            return a().a(objArr, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class c extends db {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient Object[] f62062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient int f62063d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f62064f;

        c(Object[] objArr, int i3, int i4) {
            this.f62062c = objArr;
            this.f62063d = i3;
            this.f62064f = i4;
        }

        @Override // com.applovin.impl.bb
        boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            Preconditions.checkElementIndex(i3, this.f62064f);
            return this.f62062c[(i3 * 2) + this.f62063d];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f62064f;
        }
    }

    private ni(int[] iArr, Object[] objArr, int i3) {
        this.f62052f = iArr;
        this.f62053g = objArr;
        this.f62054h = i3;
    }

    static ni a(int i3, Object[] objArr) {
        if (i3 == 0) {
            return (ni) f62051i;
        }
        if (i3 == 1) {
            p3.a(objArr[0], objArr[1]);
            return new ni(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i3, objArr.length >> 1);
        return new ni(a(objArr, i3, hb.a(i3), 0), objArr, i3);
    }

    @Override // com.applovin.impl.fb
    hb b() {
        return new a(this, this.f62053g, 0, this.f62054h);
    }

    @Override // com.applovin.impl.fb
    hb c() {
        return new b(this, new c(this.f62053g, 0, this.f62054h));
    }

    @Override // com.applovin.impl.fb
    bb d() {
        return new c(this.f62053g, 1, this.f62054h);
    }

    @Override // com.applovin.impl.fb
    boolean f() {
        return false;
    }

    @Override // com.applovin.impl.fb, java.util.Map
    public Object get(Object obj) {
        return a(this.f62052f, this.f62053g, this.f62054h, 0, obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f62054h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int[] a(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            r0 = 1
            if (r11 != r0) goto Le
            r11 = r10[r13]
            r12 = r13 ^ 1
            r10 = r10[r12]
            com.applovin.impl.p3.a(r11, r10)
            r10 = 0
            return r10
        Le:
            int r1 = r12 + (-1)
            int[] r12 = new int[r12]
            r2 = -1
            java.util.Arrays.fill(r12, r2)
            r3 = 0
        L17:
            if (r3 >= r11) goto L77
            int r4 = r3 * 2
            int r5 = r4 + r13
            r6 = r10[r5]
            r7 = r13 ^ 1
            int r4 = r4 + r7
            r4 = r10[r4]
            com.applovin.impl.p3.a(r6, r4)
            int r7 = r6.hashCode()
            int r7 = com.applovin.impl.ja.a(r7)
        L2f:
            r7 = r7 & r1
            r8 = r12[r7]
            if (r8 != r2) goto L39
            r12[r7] = r5
            int r3 = r3 + 1
            goto L17
        L39:
            r9 = r10[r8]
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L44
            int r7 = r7 + 1
            goto L2f
        L44:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Multiple entries with same key: "
            r12.append(r13)
            r12.append(r6)
            java.lang.String r13 = "="
            r12.append(r13)
            r12.append(r4)
            java.lang.String r1 = " and "
            r12.append(r1)
            r1 = r10[r8]
            r12.append(r1)
            r12.append(r13)
            r13 = r8 ^ 1
            r10 = r10[r13]
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L77:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ni.a(java.lang.Object[], int, int, int):int[]");
    }

    static Object a(int[] iArr, Object[] objArr, int i3, int i4, Object obj) {
        if (obj == null) {
            return null;
        }
        if (i3 == 1) {
            if (objArr[i4].equals(obj)) {
                return objArr[i4 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iA = ja.a(obj.hashCode());
        while (true) {
            int i5 = iA & length;
            int i6 = iArr[i5];
            if (i6 == -1) {
                return null;
            }
            if (objArr[i6].equals(obj)) {
                return objArr[i6 ^ 1];
            }
            iA = i5 + 1;
        }
    }
}
