package com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    transient long[] f84550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient int f84551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient int f84552k;

    ObjectCountLinkedHashMap(int i3) {
        this(i3, 1.0f);
    }

    private int E(int i3) {
        return (int) (this.f84550i[i3] >>> 32);
    }

    private int F(int i3) {
        return (int) this.f84550i[i3];
    }

    private void G(int i3, int i4) {
        long[] jArr = this.f84550i;
        jArr[i3] = (jArr[i3] & 4294967295L) | (((long) i4) << 32);
    }

    private void H(int i3, int i4) {
        if (i3 == -2) {
            this.f84551j = i4;
        } else {
            I(i3, i4);
        }
        if (i4 == -2) {
            this.f84552k = i3;
        } else {
            G(i4, i3);
        }
    }

    private void I(int i3, int i4) {
        long[] jArr = this.f84550i;
        jArr[i3] = (jArr[i3] & (-4294967296L)) | (((long) i4) & 4294967295L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void a() {
        super.a();
        this.f84551j = -2;
        this.f84552k = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int e() {
        int i3 = this.f84551j;
        if (i3 == -2) {
            return -1;
        }
        return i3;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void n(int i3, float f3) {
        super.n(i3, f3);
        this.f84551j = -2;
        this.f84552k = -2;
        long[] jArr = new long[i3];
        this.f84550i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void o(int i3, Object obj, int i4, int i5) {
        super.o(i3, obj, i4, i5);
        H(this.f84552k, i3);
        H(i3, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void p(int i3) {
        int iC = C() - 1;
        H(E(i3), F(i3));
        if (i3 < iC) {
            H(E(iC), i3);
            H(i3, F(iC));
        }
        super.p(i3);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int s(int i3) {
        int iF = F(i3);
        if (iF == -2) {
            return -1;
        }
        return iF;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int t(int i3, int i4) {
        return i3 == C() ? i4 : i3;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void y(int i3) {
        super.y(i3);
        long[] jArr = this.f84550i;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
        this.f84550i = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i3, -1L);
    }

    ObjectCountLinkedHashMap(int i3, float f3) {
        super(i3, f3);
    }
}
