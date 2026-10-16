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
public final class MutableLongObjectMap<V> extends LongObjectMap<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3006f;

    public /* synthetic */ MutableLongObjectMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }

    private final int i(long j3) {
        int iHashCode = Long.hashCode(j3) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f2934d;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f2931a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j4 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j5 = i5;
            int i11 = i8;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i7) & i6;
                if (this.f2932b[iNumberOfTrailingZeros] == j3) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j4) << 6) & j4 & (-9187201950435737472L)) != 0) {
                int iJ = j(i4);
                if (this.f3006f == 0 && ((this.f2931a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    f();
                    iJ = j(i4);
                }
                this.f2935e++;
                int i12 = this.f3006f;
                long[] jArr2 = this.f2931a;
                int i13 = iJ >> 3;
                long j8 = jArr2[i13];
                int i14 = (iJ & 7) << 3;
                this.f3006f = i12 - (((j8 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f2934d;
                long j9 = ((~(255 << i14)) & j8) | (j5 << i14);
                jArr2[i13] = j9;
                jArr2[(((iJ - 7) & i15) + (i15 & 7)) >> 3] = j9;
                return iJ;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final int j(int i3) {
        int i4 = this.f2934d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2931a;
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
        this.f3006f = ScatterMapKt.b(c()) - this.f2935e;
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
        this.f2931a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        k();
    }

    private final void m(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2934d = iMax;
        l(iMax);
        this.f2932b = new long[iMax];
        this.f2933c = new Object[iMax];
    }

    public final void f() {
        if (this.f2934d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2935e) * 32), ULong.b(ULong.b(this.f2934d) * 25)) > 0) {
            q(ScatterMapKt.d(this.f2934d));
        } else {
            h();
        }
    }

    public final void g() {
        this.f2935e = 0;
        long[] jArr = this.f2931a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f2931a;
            int i3 = this.f2934d;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f2933c, (Object) null, 0, this.f2934d);
        k();
    }

    public final void h() {
        long j3;
        long[] jArr = this.f2931a;
        int i3 = this.f2934d;
        long[] jArr2 = this.f2932b;
        Object[] objArr = this.f2933c;
        int i4 = (i3 + 7) >> 3;
        char c3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            long j4 = jArr[i5] & (-9187201950435737472L);
            jArr[i5] = (-72340172838076674L) & ((~j4) + (j4 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i6 = lastIndex - 1;
        long j5 = 72057594037927935L;
        jArr[i6] = (jArr[i6] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i7 = 0;
        while (i7 != i3) {
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j6 = (jArr[i8] >> i9) & 255;
            if (j6 != 128 && j6 == 254) {
                int iHashCode = Long.hashCode(jArr2[i7]) * (-862048943);
                int i10 = iHashCode ^ (iHashCode << 16);
                int i11 = i10 >>> 7;
                int iJ = j(i11);
                int i12 = i11 & i3;
                char c4 = c3;
                if (((iJ - i12) & i3) / 8 == ((i7 - i12) & i3) / 8) {
                    jArr[i8] = (((long) (i10 & 127)) << i9) | ((~(255 << i9)) & jArr[i8]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c4] & j5) | Long.MIN_VALUE;
                    i7++;
                    c3 = c4;
                } else {
                    int i13 = iJ >> 3;
                    long j7 = jArr[i13];
                    int i14 = (iJ & 7) << 3;
                    if (((j7 >> i14) & 255) == 128) {
                        j3 = j5;
                        jArr[i13] = (((long) (i10 & 127)) << i14) | (j7 & (~(255 << i14)));
                        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (128 << i9);
                        jArr2[iJ] = jArr2[i7];
                        jArr2[i7] = 0;
                        objArr[iJ] = objArr[i7];
                        objArr[i7] = null;
                    } else {
                        j3 = j5;
                        jArr[i13] = (((long) (i10 & 127)) << i14) | (j7 & (~(255 << i14)));
                        long j8 = jArr2[iJ];
                        jArr2[iJ] = jArr2[i7];
                        jArr2[i7] = j8;
                        Object obj = objArr[iJ];
                        objArr[iJ] = objArr[i7];
                        objArr[i7] = obj;
                        i7--;
                    }
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c4] & j3) | Long.MIN_VALUE;
                    i7++;
                    c3 = c4;
                    j5 = j3;
                }
            } else {
                i7++;
            }
        }
        k();
    }

    public final Object n(long j3, Object obj) {
        int i3 = i(j3);
        Object[] objArr = this.f2933c;
        Object obj2 = objArr[i3];
        this.f2932b[i3] = j3;
        objArr[i3] = obj;
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(long r14) {
        /*
            r13 = this;
            int r0 = java.lang.Long.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2934d
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.f2931a
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
            if (r12 == 0) goto L5b
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            long[] r11 = r13.f2932b
            r11 = r11[r10]
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L55
            goto L65
        L55:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L5b:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6e
            r10 = -1
        L65:
            if (r10 < 0) goto L6c
            java.lang.Object r14 = r13.p(r10)
            return r14
        L6c:
            r14 = 0
            return r14
        L6e:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.o(long):java.lang.Object");
    }

    public final Object p(int i3) {
        this.f2935e--;
        long[] jArr = this.f2931a;
        int i4 = this.f2934d;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        Object[] objArr = this.f2933c;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    public final void q(int i3) {
        long[] jArr;
        MutableLongObjectMap<V> mutableLongObjectMap = this;
        long[] jArr2 = mutableLongObjectMap.f2931a;
        long[] jArr3 = mutableLongObjectMap.f2932b;
        Object[] objArr = mutableLongObjectMap.f2933c;
        int i4 = mutableLongObjectMap.f2934d;
        m(i3);
        long[] jArr4 = mutableLongObjectMap.f2931a;
        long[] jArr5 = mutableLongObjectMap.f2932b;
        Object[] objArr2 = mutableLongObjectMap.f2933c;
        int i5 = mutableLongObjectMap.f2934d;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                long j3 = jArr3[i6];
                int iHashCode = Long.hashCode(j3) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iJ = mutableLongObjectMap.j(i7 >>> 7);
                long j4 = i7 & 127;
                int i8 = iJ >> 3;
                int i9 = (iJ & 7) << 3;
                jArr = jArr2;
                long j5 = (jArr4[i8] & (~(255 << i9))) | (j4 << i9);
                jArr4[i8] = j5;
                jArr4[(((iJ - 7) & i5) + (i5 & 7)) >> 3] = j5;
                jArr5[iJ] = j3;
                objArr2[iJ] = objArr[i6];
            } else {
                jArr = jArr2;
            }
            i6++;
            mutableLongObjectMap = this;
            jArr2 = jArr;
        }
    }

    public final void r(long j3, Object obj) {
        int i3 = i(j3);
        this.f2932b[i3] = j3;
        this.f2933c[i3] = obj;
    }

    public MutableLongObjectMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        m(ScatterMapKt.f(i3));
    }
}
