package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
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
public final class MutableIntSet extends IntSet {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2989e;

    public MutableIntSet(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        o(ScatterMapKt.f(i3));
    }

    private final int k(int i3) {
        int iHashCode = Integer.hashCode(i3) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & 127;
        int i7 = this.f2893c;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.f2891a;
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
                if (this.f2892b[iNumberOfTrailingZeros] == i3) {
                    return iNumberOfTrailingZeros;
                }
                j6 &= j6 - 1;
                i12 = i14;
            }
            int i15 = i12;
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iL = l(i5);
                if (this.f2989e == 0 && ((this.f2891a[iL >> 3] >> ((iL & 7) << 3)) & 255) != 254) {
                    h();
                    iL = l(i5);
                }
                this.f2894d++;
                int i16 = this.f2989e;
                long[] jArr2 = this.f2891a;
                int i17 = iL >> 3;
                long j7 = jArr2[i17];
                int i18 = (iL & 7) << 3;
                this.f2989e = i16 - (((j7 >> i18) & 255) == 128 ? i15 : 0);
                int i19 = this.f2893c;
                long j8 = ((~(255 << i18)) & j7) | (j4 << i18);
                jArr2[i17] = j8;
                jArr2[(((iL - 7) & i19) + (i19 & 7)) >> 3] = j8;
                return iL;
            }
            i9 = i13 + 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final int l(int i3) {
        int i4 = this.f2893c;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2891a;
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

    private final void m() {
        this.f2989e = ScatterMapKt.b(b()) - this.f2894d;
    }

    private final void n(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f2891a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        m();
    }

    private final void o(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2893c = iMax;
        n(iMax);
        this.f2892b = new int[iMax];
    }

    private final void t(int i3) {
        this.f2894d--;
        long[] jArr = this.f2891a;
        int i4 = this.f2893c;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
    }

    public final boolean g(int i3) {
        int i4 = this.f2894d;
        this.f2892b[k(i3)] = i3;
        return this.f2894d != i4;
    }

    public final void h() {
        if (this.f2893c <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2894d) * 32), ULong.b(ULong.b(this.f2893c) * 25)) > 0) {
            u(ScatterMapKt.d(this.f2893c));
        } else {
            j();
        }
    }

    public final void i() {
        this.f2894d = 0;
        long[] jArr = this.f2891a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f2891a;
            int i3 = this.f2893c;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        m();
    }

    public final void j() {
        long j3;
        long[] jArr = this.f2891a;
        int i3 = this.f2893c;
        int[] iArr = this.f2892b;
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
                int iL = l(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iL - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j5) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                } else {
                    int i15 = iL >> 3;
                    long j7 = jArr[i15];
                    int i16 = (iL & 7) << 3;
                    if (((j7 >> i16) & 255) == 128) {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        iArr[iL] = iArr[i8];
                        iArr[i8] = i14;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        int i17 = iArr[iL];
                        iArr[iL] = iArr[i8];
                        iArr[i8] = i17;
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
        m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(int r14) {
        /*
            r13 = this;
            int r0 = java.lang.Integer.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2893c
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.f2891a
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
            int[] r11 = r13.f2892b
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
            if (r4 == 0) goto L69
            r10 = -1
        L63:
            if (r10 < 0) goto L68
            r13.t(r10)
        L68:
            return
        L69:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.p(int):void");
    }

    public final void q(IntSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int[] iArr = elements.f2892b;
        long[] jArr = elements.f2891a;
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
                        p(iArr[(i3 << 3) + i5]);
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(int r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = java.lang.Integer.hashCode(r19)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.f2893c
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.f2891a
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
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            int[] r14 = r0.f2892b
            r14 = r14[r10]
            r15 = r19
            if (r14 != r15) goto L58
            goto L69
        L58:
            r16 = 1
            long r16 = r8 - r16
            long r8 = r8 & r16
            goto L41
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L72
            r10 = -1
        L69:
            if (r10 < 0) goto L6c
            r4 = r11
        L6c:
            if (r4 == 0) goto L71
            r0.t(r10)
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.r(int):boolean");
    }

    public final boolean s(IntSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f2894d;
        q(elements);
        return i3 != this.f2894d;
    }

    public final void u(int i3) {
        long[] jArr = this.f2891a;
        int[] iArr = this.f2892b;
        int i4 = this.f2893c;
        o(i3);
        long[] jArr2 = this.f2891a;
        int[] iArr2 = this.f2892b;
        int i5 = this.f2893c;
        for (int i6 = 0; i6 < i4; i6++) {
            if (((jArr[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                int i7 = iArr[i6];
                int iHashCode = Integer.hashCode(i7) * (-862048943);
                int i8 = iHashCode ^ (iHashCode << 16);
                int iL = l(i8 >>> 7);
                long j3 = i8 & 127;
                int i9 = iL >> 3;
                int i10 = (iL & 7) << 3;
                long j4 = (jArr2[i9] & (~(255 << i10))) | (j3 << i10);
                jArr2[i9] = j4;
                jArr2[(((iL - 7) & i5) + (i5 & 7)) >> 3] = j4;
                iArr2[iL] = i7;
            }
        }
    }

    public /* synthetic */ MutableIntSet(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }
}
