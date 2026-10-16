package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class MutableIntObjectMap<V> extends IntObjectMap<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2988f;

    public /* synthetic */ MutableIntObjectMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }

    private final int i(int i3) {
        int iHashCode = Integer.hashCode(i3) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & 127;
        int i7 = this.f2888d;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.f2885a;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            int i12 = 1;
            long j3 = ((jArr[i10 + 1] << (64 - i11)) & ((-i11) >> 63)) | (jArr[i10] >>> i11);
            long j4 = i6;
            int i13 = i9;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L);
            while (j6 != 0) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j6) >> 3) + i8) & i7;
                int i14 = i12;
                if (this.f2886b[iNumberOfTrailingZeros] == i3) {
                    return iNumberOfTrailingZeros;
                }
                j6 &= j6 - 1;
                i12 = i14;
            }
            int i15 = i12;
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iJ = j(i5);
                if (this.f2988f == 0 && ((this.f2885a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    f();
                    iJ = j(i5);
                }
                this.f2889e++;
                int i16 = this.f2988f;
                long[] jArr2 = this.f2885a;
                int i17 = iJ >> 3;
                long j7 = jArr2[i17];
                int i18 = (iJ & 7) << 3;
                this.f2988f = i16 - (((j7 >> i18) & 255) == 128 ? i15 : 0);
                int i19 = this.f2888d;
                long j8 = ((~(255 << i18)) & j7) | (j4 << i18);
                jArr2[i17] = j8;
                jArr2[(((iJ - 7) & i19) + (i19 & 7)) >> 3] = j8;
                return iJ;
            }
            i9 = i13 + 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final int j(int i3) {
        int i4 = this.f2888d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2885a;
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

    private final void k() {
        this.f2988f = ScatterMapKt.b(c()) - this.f2889e;
    }

    private final void l(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f2885a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        k();
    }

    private final void m(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2888d = iMax;
        l(iMax);
        this.f2886b = new int[iMax];
        this.f2887c = new Object[iMax];
    }

    public final void f() {
        if (this.f2888d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2889e) * 32), ULong.b(ULong.b(this.f2888d) * 25)) > 0) {
            q(ScatterMapKt.d(this.f2888d));
        } else {
            h();
        }
    }

    public final void g() {
        this.f2889e = 0;
        long[] jArr = this.f2885a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f2885a;
            int i3 = this.f2888d;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f2887c, (Object) null, 0, this.f2888d);
        k();
    }

    public final void h() {
        long j3;
        long[] jArr = this.f2885a;
        int i3 = this.f2888d;
        int[] iArr = this.f2886b;
        Object[] objArr = this.f2887c;
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
                int iHashCode = Integer.hashCode(iArr[i8]) * (-862048943);
                int i11 = iHashCode ^ (iHashCode << 16);
                int i12 = i11 >>> 7;
                int iJ = j(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iJ - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j5) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                } else {
                    int i15 = iJ >> 3;
                    long j7 = jArr[i15];
                    int i16 = (iJ & 7) << 3;
                    if (((j7 >> i16) & 255) == 128) {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        iArr[iJ] = iArr[i8];
                        iArr[i8] = i14;
                        objArr[iJ] = objArr[i8];
                        objArr[i8] = null;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        int i17 = iArr[iJ];
                        iArr[iJ] = iArr[i8];
                        iArr[i8] = i17;
                        Object obj = objArr[iJ];
                        objArr[iJ] = objArr[i8];
                        objArr[i8] = obj;
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
        k();
    }

    public final Object n(int i3, Object obj) {
        int i4 = i(i3);
        Object[] objArr = this.f2887c;
        Object obj2 = objArr[i4];
        this.f2886b[i4] = i3;
        objArr[i4] = obj;
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(int r14) {
        /*
            r13 = this;
            int r0 = java.lang.Integer.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2888d
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.f2885a
            int r5 = r0 >> 3
            r6 = r0 & 7
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
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3e:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L59
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.f2886b
            r11 = r11[r10]
            if (r11 != r14) goto L53
            goto L63
        L53:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L59:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6c
            r10 = -1
        L63:
            if (r10 < 0) goto L6a
            java.lang.Object r14 = r13.p(r10)
            return r14
        L6a:
            r14 = 0
            return r14
        L6c:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntObjectMap.o(int):java.lang.Object");
    }

    public final Object p(int i3) {
        this.f2889e--;
        long[] jArr = this.f2885a;
        int i4 = this.f2888d;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        Object[] objArr = this.f2887c;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    public final void q(int i3) {
        long[] jArr;
        MutableIntObjectMap<V> mutableIntObjectMap = this;
        long[] jArr2 = mutableIntObjectMap.f2885a;
        int[] iArr = mutableIntObjectMap.f2886b;
        Object[] objArr = mutableIntObjectMap.f2887c;
        int i4 = mutableIntObjectMap.f2888d;
        m(i3);
        long[] jArr3 = mutableIntObjectMap.f2885a;
        int[] iArr2 = mutableIntObjectMap.f2886b;
        Object[] objArr2 = mutableIntObjectMap.f2887c;
        int i5 = mutableIntObjectMap.f2888d;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                int i7 = iArr[i6];
                int iHashCode = Integer.hashCode(i7) * (-862048943);
                int i8 = iHashCode ^ (iHashCode << 16);
                int iJ = mutableIntObjectMap.j(i8 >>> 7);
                long j3 = i8 & 127;
                int i9 = iJ >> 3;
                int i10 = (iJ & 7) << 3;
                jArr = jArr2;
                long j4 = (jArr3[i9] & (~(255 << i10))) | (j3 << i10);
                jArr3[i9] = j4;
                jArr3[(((iJ - 7) & i5) + (i5 & 7)) >> 3] = j4;
                iArr2[iJ] = i7;
                objArr2[iJ] = objArr[i6];
            } else {
                jArr = jArr2;
            }
            i6++;
            mutableIntObjectMap = this;
            jArr2 = jArr;
        }
    }

    public final void r(int i3, Object obj) {
        int i4 = i(i3);
        this.f2886b[i4] = i3;
        this.f2887c[i4] = obj;
    }

    public MutableIntObjectMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        m(ScatterMapKt.f(i3));
    }
}
