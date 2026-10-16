package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MutableScatterSet<E> extends ScatterSet<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3039e;

    public MutableScatterSet(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        t(ScatterMapKt.f(i3));
    }

    private final int p(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f3117c;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f3115a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = i5;
            int i11 = i5;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
                if (Intrinsics.areEqual(this.f3116b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iQ = q(i4);
                if (this.f3039e == 0 && ((this.f3115a[iQ >> 3] >> ((iQ & 7) << 3)) & 255) != 254) {
                    l();
                    iQ = q(i4);
                }
                this.f3118d++;
                int i12 = this.f3039e;
                long[] jArr2 = this.f3115a;
                int i13 = iQ >> 3;
                long j7 = jArr2[i13];
                int i14 = (iQ & 7) << 3;
                this.f3039e = i12 - (((j7 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f3117c;
                long j8 = ((~(255 << i14)) & j7) | (j4 << i14);
                jArr2[i13] = j8;
                jArr2[(((iQ - 7) & i15) + (i15 & 7)) >> 3] = j8;
                return iQ;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }

    private final int q(int i3) {
        int i4 = this.f3117c;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f3115a;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j3 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j4 = j3 & ((~j3) << 7) & (-9187201950435737472L);
            if (j4 != 0) {
                return (i5 + (Long.numberOfTrailingZeros(j4) >> 3)) & i4;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
    }

    private final void r() {
        this.f3039e = ScatterMapKt.b(c()) - this.f3118d;
    }

    private final void s(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f3115a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        r();
    }

    private final void t(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f3117c = iMax;
        s(iMax);
        this.f3116b = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
    }

    public final boolean A(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iD = d();
        u(elements);
        return iD != d();
    }

    public final void B(int i3) {
        this.f3118d--;
        long[] jArr = this.f3115a;
        int i4 = this.f3117c;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        this.f3116b[i3] = null;
    }

    public final void C(int i3) {
        long[] jArr = this.f3115a;
        Object[] objArr = this.f3116b;
        int i4 = this.f3117c;
        t(i3);
        long[] jArr2 = this.f3115a;
        Object[] objArr2 = this.f3116b;
        int i5 = this.f3117c;
        for (int i6 = 0; i6 < i4; i6++) {
            if (((jArr[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i6];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iQ = q(i7 >>> 7);
                long j3 = i7 & 127;
                int i8 = iQ >> 3;
                int i9 = (iQ & 7) << 3;
                long j4 = (jArr2[i8] & (~(255 << i9))) | (j3 << i9);
                jArr2[i8] = j4;
                jArr2[(((iQ - 7) & i5) + (i5 & 7)) >> 3] = j4;
                objArr2[iQ] = obj;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean D(java.util.Collection r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.Object[] r2 = r0.f3116b
            int r3 = r0.f3118d
            long[] r4 = r0.f3115a
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L57
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L52
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L50
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4c
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r1
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r15 = r2[r13]
            boolean r14 = kotlin.collections.CollectionsKt.contains(r14, r15)
            if (r14 != 0) goto L4c
            r0.B(r13)
        L4c:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L50:
            if (r10 != r11) goto L57
        L52:
            if (r7 == r5) goto L57
            int r7 = r7 + 1
            goto L16
        L57:
            int r1 = r0.f3118d
            if (r3 == r1) goto L5d
            r1 = 1
            return r1
        L5d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.D(java.util.Collection):boolean");
    }

    public final boolean i(Object obj) {
        int iD = d();
        this.f3116b[p(obj)] = obj;
        return d() != iD;
    }

    public final boolean j(ScatterSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iD = d();
        w(elements);
        return iD != d();
    }

    public final boolean k(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iD = d();
        x(elements);
        return iD != d();
    }

    public final void l() {
        if (this.f3117c <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f3118d) * 32), ULong.b(ULong.b(this.f3117c) * 25)) > 0) {
            C(ScatterMapKt.d(this.f3117c));
        } else {
            o();
        }
    }

    public final Set m() {
        return new MutableSetWrapper(this);
    }

    public final void n() {
        this.f3118d = 0;
        long[] jArr = this.f3115a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f3115a;
            int i3 = this.f3117c;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f3116b, (Object) null, 0, this.f3117c);
        r();
    }

    public final void o() {
        long j3;
        long[] jArr = this.f3115a;
        int i3 = this.f3117c;
        Object[] objArr = this.f3116b;
        int i4 = (i3 + 7) >> 3;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            long j4 = jArr[i6] & (-9187201950435737472L);
            jArr[i6] = (-72340172838076674L) & ((~j4) + (j4 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i7 = lastIndex - 1;
        long j5 = 72057594037927935L;
        jArr[i7] = (jArr[i7] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i8 = 0;
        while (i8 != i3) {
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j6 = (jArr[i9] >> i10) & 255;
            if (j6 != 128 && j6 == 254) {
                Object obj = objArr[i8];
                int iHashCode = (obj != null ? obj.hashCode() : i5) * (-862048943);
                int i11 = iHashCode ^ (iHashCode << 16);
                int i12 = i11 >>> 7;
                int iQ = q(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iQ - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j5) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                } else {
                    int i15 = iQ >> 3;
                    long j7 = jArr[i15];
                    int i16 = (iQ & 7) << 3;
                    if (((j7 >> i16) & 255) == 128) {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        objArr[iQ] = objArr[i8];
                        objArr[i8] = null;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        Object obj2 = objArr[iQ];
                        objArr[iQ] = objArr[i8];
                        objArr[i8] = obj2;
                        i8--;
                    }
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j3) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                    j5 = j3;
                }
            } else {
                i8++;
            }
        }
        r();
    }

    public final void u(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            v(it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13.f3117c
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.f3115a
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r4 = r4[r5]
            int r9 = 64 - r6
            long r4 = r4 << r9
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L42:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L61
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.f3116b
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r14)
            if (r11 == 0) goto L5b
            goto L6b
        L5b:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L42
        L61:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L71
            r10 = -1
        L6b:
            if (r10 < 0) goto L70
            r13.B(r10)
        L70:
            return
        L71:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.v(java.lang.Object):void");
    }

    public final void w(ScatterSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.f3116b;
        long[] jArr = elements.f3115a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        y(objArr[(i3 << 3) + i5]);
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void x(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    public final void y(Object obj) {
        this.f3116b[p(obj)] = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean z(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0.f3117c
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f3115a
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L47:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L66
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.f3116b
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r1)
            if (r15 == 0) goto L60
            goto L70
        L60:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L47
        L66:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L79
            r11 = -1
        L70:
            if (r11 < 0) goto L73
            r2 = r12
        L73:
            if (r2 == 0) goto L78
            r0.B(r11)
        L78:
            return r2
        L79:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.z(java.lang.Object):boolean");
    }

    public /* synthetic */ MutableScatterSet(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }
}
