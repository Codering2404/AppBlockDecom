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
public final class MutableLongIntMap extends LongIntMap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3004f;

    public MutableLongIntMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        l(ScatterMapKt.f(i3));
    }

    private final int h(int i3) {
        int i4 = this.f2917d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2914a;
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

    private final int i(long j3) {
        int iHashCode = Long.hashCode(j3) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f2917d;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f2914a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j4 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j5 = i5;
            int i11 = i8;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i7) & i6;
                if (this.f2915b[iNumberOfTrailingZeros] == j3) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j4) << 6) & j4 & (-9187201950435737472L)) != 0) {
                int iH = h(i4);
                if (this.f3004f == 0 && ((this.f2914a[iH >> 3] >> ((iH & 7) << 3)) & 255) != 254) {
                    f();
                    iH = h(i4);
                }
                this.f2918e++;
                int i12 = this.f3004f;
                long[] jArr2 = this.f2914a;
                int i13 = iH >> 3;
                long j8 = jArr2[i13];
                int i14 = (iH & 7) << 3;
                this.f3004f = i12 - (((j8 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f2917d;
                long j9 = ((~(255 << i14)) & j8) | (j5 << i14);
                jArr2[i13] = j9;
                jArr2[(((iH - 7) & i15) + (i15 & 7)) >> 3] = j9;
                return ~iH;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final void j() {
        this.f3004f = ScatterMapKt.b(c()) - this.f2918e;
    }

    private final void k(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f2914a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        j();
    }

    private final void l(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2917d = iMax;
        k(iMax);
        this.f2915b = new long[iMax];
        this.f2916c = new int[iMax];
    }

    public final void f() {
        if (this.f2917d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2918e) * 32), ULong.b(ULong.b(this.f2917d) * 25)) > 0) {
            m(ScatterMapKt.d(this.f2917d));
        } else {
            g();
        }
    }

    public final void g() {
        long j3;
        long[] jArr = this.f2914a;
        int i3 = this.f2917d;
        long[] jArr2 = this.f2915b;
        int[] iArr = this.f2916c;
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
                int iHashCode = Long.hashCode(jArr2[i8]) * (-862048943);
                int i11 = iHashCode ^ (iHashCode << 16);
                int i12 = i11 >>> 7;
                int iH = h(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iH - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j5) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                } else {
                    int i15 = iH >> 3;
                    long j7 = jArr[i15];
                    int i16 = (iH & 7) << 3;
                    if (((j7 >> i16) & 255) == 128) {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        jArr2[iH] = jArr2[i8];
                        jArr2[i8] = 0;
                        iArr[iH] = iArr[i8];
                        iArr[i8] = i14;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        long j8 = jArr2[iH];
                        jArr2[iH] = jArr2[i8];
                        jArr2[i8] = j8;
                        int i17 = iArr[iH];
                        iArr[iH] = iArr[i8];
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
        j();
    }

    public final void m(int i3) {
        long[] jArr;
        MutableLongIntMap mutableLongIntMap = this;
        long[] jArr2 = mutableLongIntMap.f2914a;
        long[] jArr3 = mutableLongIntMap.f2915b;
        int[] iArr = mutableLongIntMap.f2916c;
        int i4 = mutableLongIntMap.f2917d;
        l(i3);
        long[] jArr4 = mutableLongIntMap.f2914a;
        long[] jArr5 = mutableLongIntMap.f2915b;
        int[] iArr2 = mutableLongIntMap.f2916c;
        int i5 = mutableLongIntMap.f2917d;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                long j3 = jArr3[i6];
                int iHashCode = Long.hashCode(j3) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iH = mutableLongIntMap.h(i7 >>> 7);
                long j4 = i7 & 127;
                int i8 = iH >> 3;
                int i9 = (iH & 7) << 3;
                jArr = jArr2;
                long j5 = (jArr4[i8] & (~(255 << i9))) | (j4 << i9);
                jArr4[i8] = j5;
                jArr4[(((iH - 7) & i5) + (i5 & 7)) >> 3] = j5;
                jArr5[iH] = j3;
                iArr2[iH] = iArr[i6];
            } else {
                jArr = jArr2;
            }
            i6++;
            mutableLongIntMap = this;
            jArr2 = jArr;
        }
    }

    public final void n(long j3, int i3) {
        int i4 = i(j3);
        if (i4 < 0) {
            i4 = ~i4;
        }
        this.f2915b[i4] = j3;
        this.f2916c[i4] = i3;
    }

    public /* synthetic */ MutableLongIntMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }
}
