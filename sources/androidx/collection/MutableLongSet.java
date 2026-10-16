package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;

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
public final class MutableLongSet extends LongSet {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3007e;

    public MutableLongSet(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        k(ScatterMapKt.f(i3));
    }

    private final int g(long j3) {
        int iHashCode = Long.hashCode(j3) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f2939c;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f2937a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j4 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j5 = i5;
            int i11 = i8;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i7) & i6;
                if (this.f2938b[iNumberOfTrailingZeros] == j3) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j4) << 6) & j4 & (-9187201950435737472L)) != 0) {
                int iH = h(i4);
                if (this.f3007e == 0 && ((this.f2937a[iH >> 3] >> ((iH & 7) << 3)) & 255) != 254) {
                    e();
                    iH = h(i4);
                }
                this.f2940d++;
                int i12 = this.f3007e;
                long[] jArr2 = this.f2937a;
                int i13 = iH >> 3;
                long j8 = jArr2[i13];
                int i14 = (iH & 7) << 3;
                this.f3007e = i12 - (((j8 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f2939c;
                long j9 = ((~(255 << i14)) & j8) | (j5 << i14);
                jArr2[i13] = j9;
                jArr2[(((iH - 7) & i15) + (i15 & 7)) >> 3] = j9;
                return iH;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final int h(int i3) {
        int i4 = this.f2939c;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2937a;
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

    private final void i() {
        this.f3007e = ScatterMapKt.b(b()) - this.f2940d;
    }

    private final void j(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f2937a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        i();
    }

    private final void k(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2939c = iMax;
        j(iMax);
        this.f2938b = new long[iMax];
    }

    private final void n(int i3) {
        this.f2940d--;
        long[] jArr = this.f2937a;
        int i4 = this.f2939c;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
    }

    public final void e() {
        if (this.f2939c <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2940d) * 32), ULong.b(ULong.b(this.f2939c) * 25)) > 0) {
            o(ScatterMapKt.d(this.f2939c));
        } else {
            f();
        }
    }

    public final void f() {
        long j3;
        long[] jArr = this.f2937a;
        int i3 = this.f2939c;
        long[] jArr2 = this.f2938b;
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
                int iH = h(i11);
                int i12 = i11 & i3;
                char c4 = c3;
                if (((iH - i12) & i3) / 8 == ((i7 - i12) & i3) / 8) {
                    jArr[i8] = (((long) (i10 & 127)) << i9) | ((~(255 << i9)) & jArr[i8]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c4] & j5) | Long.MIN_VALUE;
                    i7++;
                    c3 = c4;
                } else {
                    int i13 = iH >> 3;
                    long j7 = jArr[i13];
                    int i14 = (iH & 7) << 3;
                    if (((j7 >> i14) & 255) == 128) {
                        j3 = j5;
                        jArr[i13] = (((long) (i10 & 127)) << i14) | (j7 & (~(255 << i14)));
                        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (128 << i9);
                        jArr2[iH] = jArr2[i7];
                        jArr2[i7] = 0;
                    } else {
                        j3 = j5;
                        jArr[i13] = (((long) (i10 & 127)) << i14) | (j7 & (~(255 << i14)));
                        long j8 = jArr2[iH];
                        jArr2[iH] = jArr2[i7];
                        jArr2[i7] = j8;
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
        i();
    }

    public final void l(long j3) {
        this.f2938b[g(j3)] = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m(long r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = java.lang.Long.hashCode(r17)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.f2939c
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.f2937a
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r6 = r6[r7]
            int r12 = 64 - r8
            long r6 = r6 << r12
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L41:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5e
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.f2938b
            r14 = r14[r10]
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L58
            goto L68
        L58:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L41
        L5e:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L71
            r10 = -1
        L68:
            if (r10 < 0) goto L6b
            r4 = r11
        L6b:
            if (r4 == 0) goto L70
            r0.n(r10)
        L70:
            return r4
        L71:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.m(long):boolean");
    }

    public final void o(int i3) {
        long[] jArr = this.f2937a;
        long[] jArr2 = this.f2938b;
        int i4 = this.f2939c;
        k(i3);
        long[] jArr3 = this.f2937a;
        long[] jArr4 = this.f2938b;
        int i5 = this.f2939c;
        for (int i6 = 0; i6 < i4; i6++) {
            if (((jArr[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                long j3 = jArr2[i6];
                int iHashCode = Long.hashCode(j3) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iH = h(i7 >>> 7);
                long j4 = i7 & 127;
                int i8 = iH >> 3;
                int i9 = (iH & 7) << 3;
                long j5 = (jArr3[i8] & (~(255 << i9))) | (j4 << i9);
                jArr3[i8] = j5;
                jArr3[(((iH - 7) & i5) + (i5 & 7)) >> 3] = j5;
                jArr4[iH] = j3;
            }
        }
    }
}
