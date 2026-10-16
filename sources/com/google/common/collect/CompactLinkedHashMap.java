package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    transient long[] f83845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private transient int f83846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient int f83847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f83848o;

    CompactLinkedHashMap() {
        this(3);
    }

    public static CompactLinkedHashMap c0() {
        return new CompactLinkedHashMap();
    }

    public static CompactLinkedHashMap d0(int i3) {
        return new CompactLinkedHashMap(i3);
    }

    private int e0(int i3) {
        return ((int) (f0(i3) >>> 32)) - 1;
    }

    private long f0(int i3) {
        return h0()[i3];
    }

    private long[] h0() {
        long[] jArr = this.f83845l;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void i0(int i3, long j3) {
        h0()[i3] = j3;
    }

    private void j0(int i3, int i4) {
        i0(i3, (f0(i3) & 4294967295L) | (((long) (i4 + 1)) << 32));
    }

    private void k0(int i3, int i4) {
        if (i3 == -2) {
            this.f83846m = i4;
        } else {
            l0(i3, i4);
        }
        if (i4 == -2) {
            this.f83847n = i3;
        } else {
            j0(i4, i3);
        }
    }

    private void l0(int i3, int i4) {
        i0(i3, (f0(i3) & (-4294967296L)) | (((long) (i4 + 1)) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    int B() {
        return this.f83846m;
    }

    @Override // com.google.common.collect.CompactHashMap
    int C(int i3) {
        return ((int) f0(i3)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    void G(int i3) {
        super.G(i3);
        this.f83846m = -2;
        this.f83847n = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    void H(int i3, Object obj, Object obj2, int i4, int i5) {
        super.H(i3, obj, obj2, i4, i5);
        k0(this.f83847n, i3);
        k0(i3, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    void K(int i3, int i4) {
        int size = size() - 1;
        super.K(i3, i4);
        k0(e0(i3), C(i3));
        if (i3 < size) {
            k0(e0(size), i3);
            k0(i3, C(size));
        }
        i0(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    void S(int i3) {
        super.S(i3);
        this.f83845l = Arrays.copyOf(h0(), i3);
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (L()) {
            return;
        }
        this.f83846m = -2;
        this.f83847n = -2;
        long[] jArr = this.f83845l;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    void n(int i3) {
        if (this.f83848o) {
            k0(e0(i3), C(i3));
            k0(this.f83847n, i3);
            k0(i3, -2);
            E();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    int o(int i3, int i4) {
        return i3 >= size() ? i4 : i3;
    }

    @Override // com.google.common.collect.CompactHashMap
    int p() {
        int iP = super.p();
        this.f83845l = new long[iP];
        return iP;
    }

    @Override // com.google.common.collect.CompactHashMap
    Map q() {
        Map mapQ = super.q();
        this.f83845l = null;
        return mapQ;
    }

    @Override // com.google.common.collect.CompactHashMap
    Map t(int i3) {
        return new LinkedHashMap(i3, 1.0f, this.f83848o);
    }

    CompactLinkedHashMap(int i3) {
        this(i3, false);
    }

    CompactLinkedHashMap(int i3, boolean z2) {
        super(i3);
        this.f83848o = z2;
    }
}
