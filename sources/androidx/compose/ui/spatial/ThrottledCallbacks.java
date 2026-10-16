package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ThrottledCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Entry f28602b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f28604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f28605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f28606f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntObjectMap f28601a = IntObjectMapKt.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f28603c = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Entry implements DelegatableNode.RegistrationHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f28609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DelegatableNode f28610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Function1 f28611e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Entry f28612f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f28613g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f28614h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f28615i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f28616j = -1;

        public Entry(int i3, long j3, long j4, DelegatableNode delegatableNode, Function1 function1) {
            this.f28607a = i3;
            this.f28608b = j3;
            this.f28609c = j4;
            this.f28610d = delegatableNode;
            this.f28611e = function1;
            this.f28615i = -j3;
        }

        @Override // androidx.compose.ui.node.DelegatableNode.RegistrationHandle
        public void a() {
            ThrottledCallbacks throttledCallbacks = ThrottledCallbacks.this;
            if (throttledCallbacks.o(throttledCallbacks.j(), this.f28607a, this)) {
                return;
            }
            ThrottledCallbacks.this.q(this);
        }

        public final void b(long j3, long j4, long j5, long j6, float[] fArr) {
            RelativeLayoutBounds relativeLayoutBoundsA = ThrottledCallbacksKt.a(this.f28610d, j3, j4, j5, j6, fArr);
            if (relativeLayoutBoundsA == null) {
                return;
            }
            this.f28611e.invoke(relativeLayoutBoundsA);
        }

        public final long c() {
            return this.f28614h;
        }

        public final long d() {
            return this.f28609c;
        }

        public final long e() {
            return this.f28615i;
        }

        public final long f() {
            return this.f28616j;
        }

        public final Entry g() {
            return this.f28612f;
        }

        public final DelegatableNode h() {
            return this.f28610d;
        }

        public final long i() {
            return this.f28608b;
        }

        public final long j() {
            return this.f28613g;
        }

        public final void k(long j3) {
            this.f28614h = j3;
        }

        public final void l(long j3) {
            this.f28615i = j3;
        }

        public final void m(long j3) {
            this.f28616j = j3;
        }

        public final void n(Entry entry) {
            this.f28612f = entry;
        }

        public final void o(long j3) {
            this.f28613g = j3;
        }
    }

    public ThrottledCallbacks() {
        IntOffset.Companion companion = IntOffset.f29988b;
        this.f28604d = companion.b();
        this.f28605e = companion.b();
    }

    private final long c(Entry entry, long j3, long j4, float[] fArr, long j5, long j6) {
        if (entry.d() <= 0 || entry.f() <= 0) {
            return j6;
        }
        if (j5 - entry.f() <= entry.d()) {
            return Math.min(j6, entry.f() + entry.d());
        }
        entry.l(j5);
        entry.m(-1L);
        entry.b(entry.j(), entry.c(), j3, j4, fArr);
        return j6;
    }

    private final void d(Entry entry, long j3, long j4, float[] fArr, long j5) {
        boolean z2 = j5 - entry.e() > entry.i();
        boolean z3 = entry.d() == 0;
        entry.m(j5);
        if (z2 && z3) {
            entry.l(j5);
            entry.b(entry.j(), entry.c(), j3, j4, fArr);
        }
        if (z3) {
            return;
        }
        long j6 = this.f28603c;
        long jD = entry.d() + j5;
        if (j6 <= 0 || jD >= j6) {
            return;
        }
        this.f28603c = j6;
    }

    private final void h(Entry entry, long j3, long j4, long j5) {
        long jE = entry.e();
        long jI = entry.i();
        long jD = entry.d();
        boolean z2 = j5 - jE >= jI;
        boolean z3 = jD == 0;
        boolean z4 = jI == 0;
        entry.o(j3);
        entry.k(j4);
        boolean z5 = !(z3 || z4) || z3;
        if (z2 && z5) {
            entry.m(-1L);
            entry.l(j5);
            entry.b(j3, j4, this.f28604d, this.f28605e, this.f28606f);
        } else {
            if (z3) {
                return;
            }
            entry.m(j5);
            long j6 = this.f28603c;
            long j7 = j5 + jD;
            if (j6 <= 0 || j7 >= j6) {
                return;
            }
            this.f28603c = j6;
        }
    }

    private final Entry n(MutableIntObjectMap mutableIntObjectMap, int i3, Entry entry) {
        Object objB = mutableIntObjectMap.b(i3);
        if (objB == null) {
            mutableIntObjectMap.r(i3, entry);
            objB = entry;
        }
        Entry entryG = (Entry) objB;
        if (entryG != entry) {
            while (entryG.g() != null) {
                entryG = entryG.g();
                Intrinsics.checkNotNull(entryG);
            }
            entryG.n(entry);
        }
        return entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean o(androidx.collection.MutableIntObjectMap r6, int r7, androidx.compose.ui.spatial.ThrottledCallbacks.Entry r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.o(r7)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r0 = (androidx.compose.ui.spatial.ThrottledCallbacks.Entry) r0
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1f
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r0 = r8.g()
            r8.n(r4)
            if (r0 == 0) goto L1e
            r6.n(r7, r0)
        L1e:
            return r3
        L1f:
            r6.n(r7, r0)
        L22:
            if (r0 == 0) goto L3d
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r6 = r0.g()
            if (r6 != 0) goto L2b
            return r1
        L2b:
            if (r6 != r8) goto L38
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r6 = r8.g()
            r0.n(r6)
            r8.n(r4)
            goto L3d
        L38:
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r0 = r0.g()
            goto L22
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.ThrottledCallbacks.o(androidx.collection.MutableIntObjectMap, int, androidx.compose.ui.spatial.ThrottledCallbacks$Entry):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(Entry entry) {
        Entry entry2 = this.f28602b;
        if (entry2 == entry) {
            this.f28602b = entry2.g();
            entry.n(null);
            return true;
        }
        Entry entryG = entry2 != null ? entry2.g() : null;
        while (true) {
            Entry entry3 = entryG;
            Entry entry4 = entry2;
            entry2 = entry3;
            if (entry2 == null) {
                return false;
            }
            if (entry2 == entry) {
                if (entry4 != null) {
                    entry4.n(entry2.g());
                }
                entry.n(null);
                return true;
            }
            entryG = entry2.g();
        }
    }

    public final void e(long j3) {
        long j4 = this.f28604d;
        long j5 = this.f28605e;
        float[] fArr = this.f28606f;
        Entry entry = this.f28602b;
        if (entry != null) {
            for (Entry entryG = entry; entryG != null; entryG = entryG.g()) {
                LayoutNode layoutNodeO = DelegatableNodeKt.o(entryG.h());
                long jV0 = layoutNodeO.v0();
                long jE0 = layoutNodeO.e0();
                entryG.o(jV0);
                entryG.k((((long) (IntOffset.k(jV0) + ((int) (jE0 >> 32)))) << 32) | (((long) (IntOffset.l(jV0) + ((int) (jE0 & 4294967295L)))) & 4294967295L));
                d(entryG, j4, j5, fArr, j3);
            }
        }
    }

    public final void f(long j3) {
        ThrottledCallbacks throttledCallbacks = this;
        long j4 = throttledCallbacks.f28604d;
        long j5 = throttledCallbacks.f28605e;
        float[] fArr = throttledCallbacks.f28606f;
        MutableIntObjectMap mutableIntObjectMap = throttledCallbacks.f28601a;
        Object[] objArr = mutableIntObjectMap.f2887c;
        long[] jArr = mutableIntObjectMap.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j6 = jArr[i3];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                long j7 = j6;
                int i5 = 0;
                while (i5 < i4) {
                    if ((j7 & 255) < 128) {
                        Entry entryG = (Entry) objArr[(i3 << 3) + i5];
                        while (entryG != null) {
                            int i6 = i5;
                            Entry entry = entryG;
                            throttledCallbacks.d(entry, j4, j5, fArr, j3);
                            entryG = entry.g();
                            throttledCallbacks = this;
                            i5 = i6;
                        }
                    }
                    j7 >>= 8;
                    i5++;
                    throttledCallbacks = this;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            }
            i3++;
            throttledCallbacks = this;
        }
    }

    public final void g(int i3, long j3, long j4, long j5) {
        for (Entry entryG = (Entry) this.f28601a.b(i3); entryG != null; entryG = entryG.g()) {
            h(entryG, j3, j4, j5);
        }
    }

    public final long i() {
        return this.f28603c;
    }

    public final MutableIntObjectMap j() {
        return this.f28601a;
    }

    public final long k() {
        return this.f28605e;
    }

    public final float[] l() {
        return this.f28606f;
    }

    public final long m() {
        return this.f28604d;
    }

    public final DelegatableNode.RegistrationHandle p(int i3, long j3, long j4, DelegatableNode delegatableNode, Function1 function1) {
        return n(this.f28601a, i3, new Entry(i3, j3, j4 == 0 ? j3 : j4, delegatableNode, function1));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[LOOP:0: B:8:0x0023->B:25:0x008c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096 A[EDGE_INSN: B:39:0x0096->B:27:0x0096 BREAK  A[LOOP:0: B:8:0x0023->B:25:0x008c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(long r27) {
        /*
            r26 = this;
            r0 = r26
            long r1 = r0.f28603c
            int r1 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
            if (r1 <= 0) goto L9
            return
        L9:
            long r2 = r0.f28604d
            long r4 = r0.f28605e
            float[] r6 = r0.f28606f
            androidx.collection.MutableIntObjectMap r1 = r0.f28601a
            java.lang.Object[] r11 = r1.f2887c
            long[] r12 = r1.f2885a
            int r1 = r12.length
            int r13 = r1 + (-2)
            if (r13 < 0) goto L8f
            r16 = 0
            r1 = r16
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L23:
            r9 = r12[r1]
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r14 = ~r9
            r19 = 7
            long r14 = r14 << r19
            long r14 = r14 & r9
            r19 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r19
            int r14 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r14 == 0) goto L8a
            int r14 = r1 - r13
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r19 = r9
            r9 = r16
        L48:
            if (r9 >= r14) goto L84
            r21 = 255(0xff, double:1.26E-321)
            long r21 = r19 & r21
            r23 = 128(0x80, double:6.3E-322)
            int r10 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r10 >= 0) goto L7a
            int r10 = r1 << 3
            int r10 = r10 + r9
            r10 = r11[r10]
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r10 = (androidx.compose.ui.spatial.ThrottledCallbacks.Entry) r10
        L5b:
            if (r10 == 0) goto L74
            r25 = r1
            r21 = r9
            r1 = r10
            r9 = r7
            r7 = r27
            long r9 = r0.c(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.g()
            r7 = r9
            r9 = r21
            r10 = r1
            r1 = r25
            goto L5b
        L74:
            r21 = r9
            r9 = r7
        L77:
            r25 = r1
            goto L7d
        L7a:
            r21 = r9
            goto L77
        L7d:
            long r19 = r19 >> r15
            int r9 = r21 + 1
            r1 = r25
            goto L48
        L84:
            r25 = r1
            if (r14 != r15) goto L96
            r1 = r25
        L8a:
            if (r1 == r13) goto L96
            int r1 = r1 + 1
            goto L23
        L8f:
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = r17
        L96:
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r0.f28602b
            if (r1 == 0) goto La9
            r9 = r7
        L9b:
            if (r1 == 0) goto La8
            r7 = r27
            long r9 = r0.c(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.g()
            goto L9b
        La8:
            r7 = r9
        La9:
            int r1 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r1 != 0) goto Laf
            r7 = -1
        Laf:
            r0.f28603c = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.ThrottledCallbacks.r(long):void");
    }

    public final boolean s(long j3, long j4, float[] fArr) {
        boolean z2;
        if (IntOffset.j(j4, this.f28604d)) {
            z2 = false;
        } else {
            this.f28604d = j4;
            z2 = true;
        }
        if (!IntOffset.j(j3, this.f28605e)) {
            this.f28605e = j3;
            z2 = true;
        }
        if (fArr == null) {
            return z2;
        }
        this.f28606f = fArr;
        return true;
    }
}
