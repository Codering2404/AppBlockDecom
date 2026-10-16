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
public final class MutableIntIntMap extends IntIntMap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2986f;

    public MutableIntIntMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        o(ScatterMapKt.f(i3));
    }

    private final int k(int i3) {
        int i4 = this.f2872d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f2869a;
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

    private final int l(int i3) {
        int iHashCode = Integer.hashCode(i3) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & 127;
        int i7 = this.f2872d;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.f2869a;
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
                if (this.f2870b[iNumberOfTrailingZeros] == i3) {
                    return iNumberOfTrailingZeros;
                }
                j6 &= j6 - 1;
                i12 = i14;
            }
            int i15 = i12;
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iK = k(i5);
                if (this.f2986f == 0 && ((this.f2869a[iK >> 3] >> ((iK & 7) << 3)) & 255) != 254) {
                    h();
                    iK = k(i5);
                }
                this.f2873e++;
                int i16 = this.f2986f;
                long[] jArr2 = this.f2869a;
                int i17 = iK >> 3;
                long j7 = jArr2[i17];
                int i18 = (iK & 7) << 3;
                this.f2986f = i16 - (((j7 >> i18) & 255) == 128 ? i15 : 0);
                int i19 = this.f2872d;
                long j8 = ((~(255 << i18)) & j7) | (j4 << i18);
                jArr2[i17] = j8;
                jArr2[(((iK - 7) & i19) + (i19 & 7)) >> 3] = j8;
                return ~iK;
            }
            i9 = i13 + 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final void m() {
        this.f2986f = ScatterMapKt.b(d()) - this.f2873e;
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
        this.f2869a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        m();
    }

    private final void o(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f2872d = iMax;
        n(iMax);
        this.f2870b = new int[iMax];
        this.f2871c = new int[iMax];
    }

    public final void h() {
        if (this.f2872d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f2873e) * 32), ULong.b(ULong.b(this.f2872d) * 25)) > 0) {
            p(ScatterMapKt.d(this.f2872d));
        } else {
            j();
        }
    }

    public final void i() {
        this.f2873e = 0;
        long[] jArr = this.f2869a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f2869a;
            int i3 = this.f2872d;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        m();
    }

    public final void j() {
        long j3;
        long[] jArr = this.f2869a;
        int i3 = this.f2872d;
        int[] iArr = this.f2870b;
        int[] iArr2 = this.f2871c;
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
                int iK = k(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iK - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i14] & j5) | Long.MIN_VALUE;
                    i8++;
                    i5 = i14;
                } else {
                    int i15 = iK >> 3;
                    long j7 = jArr[i15];
                    int i16 = (iK & 7) << 3;
                    if (((j7 >> i16) & 255) == 128) {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        iArr[iK] = iArr[i8];
                        iArr[i8] = i14;
                        iArr2[iK] = iArr2[i8];
                        iArr2[i8] = i14;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        int i17 = iArr[iK];
                        iArr[iK] = iArr[i8];
                        iArr[i8] = i17;
                        int i18 = iArr2[iK];
                        iArr2[iK] = iArr2[i8];
                        iArr2[i8] = i18;
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

    public final void p(int i3) {
        long[] jArr;
        MutableIntIntMap mutableIntIntMap = this;
        long[] jArr2 = mutableIntIntMap.f2869a;
        int[] iArr = mutableIntIntMap.f2870b;
        int[] iArr2 = mutableIntIntMap.f2871c;
        int i4 = mutableIntIntMap.f2872d;
        o(i3);
        long[] jArr3 = mutableIntIntMap.f2869a;
        int[] iArr3 = mutableIntIntMap.f2870b;
        int[] iArr4 = mutableIntIntMap.f2871c;
        int i5 = mutableIntIntMap.f2872d;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                int i7 = iArr[i6];
                int iHashCode = Integer.hashCode(i7) * (-862048943);
                int i8 = iHashCode ^ (iHashCode << 16);
                int iK = mutableIntIntMap.k(i8 >>> 7);
                long j3 = i8 & 127;
                int i9 = iK >> 3;
                int i10 = (iK & 7) << 3;
                jArr = jArr2;
                long j4 = (jArr3[i9] & (~(255 << i10))) | (j3 << i10);
                jArr3[i9] = j4;
                jArr3[(((iK - 7) & i5) + (i5 & 7)) >> 3] = j4;
                iArr3[iK] = i7;
                iArr4[iK] = iArr2[i6];
            } else {
                jArr = jArr2;
            }
            i6++;
            mutableIntIntMap = this;
            jArr2 = jArr;
        }
    }

    public final void q(int i3, int i4) {
        int iL = l(i3);
        if (iL < 0) {
            iL = ~iL;
        }
        this.f2870b[iL] = i3;
        this.f2871c[iL] = i4;
    }

    public /* synthetic */ MutableIntIntMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }
}
