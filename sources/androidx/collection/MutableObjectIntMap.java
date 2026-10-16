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
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3016f;

    public /* synthetic */ MutableObjectIntMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }

    private final int l(int i3) {
        int i4 = this.f3078d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f3075a;
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

    private final int m(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f3078d;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f3075a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = i5;
            int i11 = i5;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
                if (Intrinsics.areEqual(this.f3076b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iL = l(i4);
                if (this.f3016f == 0 && ((this.f3075a[iL >> 3] >> ((iL & 7) << 3)) & 255) != 254) {
                    i();
                    iL = l(i4);
                }
                this.f3079e++;
                int i12 = this.f3016f;
                long[] jArr2 = this.f3075a;
                int i13 = iL >> 3;
                long j7 = jArr2[i13];
                int i14 = (iL & 7) << 3;
                this.f3016f = i12 - (((j7 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f3078d;
                long j8 = ((~(255 << i14)) & j7) | (j4 << i14);
                jArr2[i13] = j8;
                jArr2[(((iL - 7) & i15) + (i15 & 7)) >> 3] = j8;
                return ~iL;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }

    private final void n() {
        this.f3016f = ScatterMapKt.b(d()) - this.f3079e;
    }

    private final void o(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f3075a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        n();
    }

    private final void p(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f3078d = iMax;
        o(iMax);
        this.f3076b = new Object[iMax];
        this.f3077c = new int[iMax];
    }

    public final void i() {
        if (this.f3078d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f3079e) * 32), ULong.b(ULong.b(this.f3078d) * 25)) > 0) {
            t(ScatterMapKt.d(this.f3078d));
        } else {
            k();
        }
    }

    public final void j() {
        this.f3079e = 0;
        long[] jArr = this.f3075a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f3075a;
            int i3 = this.f3078d;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f3076b, (Object) null, 0, this.f3078d);
        n();
    }

    public final void k() {
        long j3;
        long[] jArr = this.f3075a;
        int i3 = this.f3078d;
        Object[] objArr = this.f3076b;
        int[] iArr = this.f3077c;
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
                        objArr[iL] = objArr[i8];
                        objArr[i8] = null;
                        iArr[iL] = iArr[i8];
                        iArr[i8] = i14;
                    } else {
                        j3 = j5;
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j7 & (~(255 << i16)));
                        Object obj2 = objArr[iL];
                        objArr[iL] = objArr[i8];
                        objArr[i8] = obj2;
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
        n();
    }

    public final int q(Object obj, int i3, int i4) {
        int iM = m(obj);
        if (iM < 0) {
            iM = ~iM;
        } else {
            i4 = this.f3077c[iM];
        }
        this.f3076b[iM] = obj;
        this.f3077c[iM] = i3;
        return i4;
    }

    public final void r(Object obj) {
        int iB = b(obj);
        if (iB >= 0) {
            s(iB);
        }
    }

    public final void s(int i3) {
        this.f3079e--;
        long[] jArr = this.f3075a;
        int i4 = this.f3078d;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        this.f3076b[i3] = null;
    }

    public final void t(int i3) {
        int i4;
        long[] jArr = this.f3075a;
        Object[] objArr = this.f3076b;
        int[] iArr = this.f3077c;
        int i5 = this.f3078d;
        p(i3);
        long[] jArr2 = this.f3075a;
        Object[] objArr2 = this.f3076b;
        int[] iArr2 = this.f3077c;
        int i6 = this.f3078d;
        int i7 = 0;
        while (i7 < i5) {
            if (((jArr[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i7];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i8 = iHashCode ^ (iHashCode << 16);
                int iL = l(i8 >>> 7);
                i4 = i7;
                long j3 = i8 & 127;
                int i9 = iL >> 3;
                int i10 = (iL & 7) << 3;
                long j4 = (j3 << i10) | (jArr2[i9] & (~(255 << i10)));
                jArr2[i9] = j4;
                jArr2[(((iL - 7) & i6) + (i6 & 7)) >> 3] = j4;
                objArr2[iL] = obj;
                iArr2[iL] = iArr[i4];
            } else {
                i4 = i7;
            }
            i7 = i4 + 1;
        }
    }

    public final void u(Object obj, int i3) {
        int iM = m(obj);
        if (iM < 0) {
            iM = ~iM;
        }
        this.f3076b[iM] = obj;
        this.f3077c[iM] = i3;
    }

    public MutableObjectIntMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        p(ScatterMapKt.f(i3));
    }
}
