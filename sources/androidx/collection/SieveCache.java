package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SieveCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f3132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f3133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function4 f3134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f3135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f3136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object[] f3137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long[] f3138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3146o;

    public SieveCache(int i3, int i4, Function2 sizeOf, Function1 createValueFromKey, Function4 onEntryRemoved) {
        Intrinsics.checkNotNullParameter(sizeOf, "sizeOf");
        Intrinsics.checkNotNullParameter(createValueFromKey, "createValueFromKey");
        Intrinsics.checkNotNullParameter(onEntryRemoved, "onEntryRemoved");
        this.f3132a = sizeOf;
        this.f3133b = createValueFromKey;
        this.f3134c = onEntryRemoved;
        this.f3135d = ScatterMapKt.f3113a;
        Object[] objArr = ContainerHelpersKt.f3176c;
        this.f3136e = objArr;
        this.f3137f = objArr;
        this.f3138g = SieveCacheKt.a();
        this.f3144m = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3145n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3146o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (!(i3 > 0)) {
            RuntimeHelpersKt.a("maxSize must be > 0");
        }
        this.f3142k = i3;
        n(ScatterMapKt.f(i4));
    }

    private final int c() {
        long[] jArr = this.f3138g;
        int i3 = this.f3146o;
        int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 == Integer.MAX_VALUE) {
            i3 = this.f3145n;
        }
        while (i3 != Integer.MAX_VALUE) {
            long j3 = jArr[i3];
            if (((int) ((j3 >> 62) & 1)) == 0) {
                break;
            }
            int i5 = (int) (2147483647L & (j3 >> 31));
            jArr[i3] = 4611686018427387903L & j3;
            i3 = i5 != Integer.MAX_VALUE ? i5 : this.f3145n;
        }
        int i6 = (int) (2147483647L & (jArr[i3] >> 31));
        if (i6 != Integer.MAX_VALUE) {
            i4 = i6;
        }
        this.f3146o = i4;
        return i3;
    }

    private final int d(int i3) {
        int i4 = this.f3139h;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f3135d;
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

    private final int e(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f3139h;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f3135d;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = i5;
            int i11 = i5;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
                if (Intrinsics.areEqual(this.f3136e[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iD = d(i4);
                if (this.f3140i == 0 && ((this.f3135d[iD >> 3] >> ((iD & 7) << 3)) & 255) != 254) {
                    a();
                    iD = d(i4);
                }
                this.f3141j++;
                int i12 = this.f3140i;
                long[] jArr2 = this.f3135d;
                int i13 = iD >> 3;
                long j7 = jArr2[i13];
                int i14 = (iD & 7) << 3;
                this.f3140i = i12 - (((j7 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f3139h;
                long j8 = ((~(255 << i14)) & j7) | (j4 << i14);
                jArr2[i13] = j8;
                jArr2[(((iD - 7) & i15) + (i15 & 7)) >> 3] = j8;
                return ~iD;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }

    private final int f(Object obj) {
        int i3 = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 & 127;
        int i6 = this.f3139h;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.f3135d;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = (((long) i5) * 72340172838076673L) ^ j3;
            for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                if (Intrinsics.areEqual(this.f3136e[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i3 += 8;
            i7 = i8 + i3;
        }
    }

    private final void g(int[] iArr) {
        long[] jArr = this.f3138g;
        int length = jArr.length;
        int i3 = 0;
        while (true) {
            int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i3 >= length) {
                break;
            }
            long j3 = jArr[i3];
            int i5 = (int) ((j3 >> 31) & 2147483647L);
            int i6 = (int) (j3 & 2147483647L);
            long j4 = ((j3 & (-4611686018427387904L)) | ((long) (i5 == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[i5]))) << 31;
            if (i6 != Integer.MAX_VALUE) {
                i4 = iArr[i6];
            }
            jArr[i3] = j4 | ((long) i4);
            i3++;
        }
        int i7 = this.f3144m;
        if (i7 != Integer.MAX_VALUE) {
            this.f3144m = iArr[i7];
        }
        int i8 = this.f3145n;
        if (i8 != Integer.MAX_VALUE) {
            this.f3145n = iArr[i8];
        }
        int i9 = this.f3146o;
        if (i9 != Integer.MAX_VALUE) {
            this.f3146o = iArr[i9];
        }
    }

    private final void h(long[] jArr) {
        long[] jArr2 = this.f3138g;
        int length = jArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i3 >= length) {
                break;
            }
            long j3 = jArr2[i3];
            int i5 = (int) ((j3 >> 31) & 2147483647L);
            int i6 = (int) (j3 & 2147483647L);
            long j4 = ((j3 & (-4611686018427387904L)) | ((long) (i5 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr[i5] & 4294967295L)))) << 31;
            if (i6 != Integer.MAX_VALUE) {
                i4 = (int) (4294967295L & jArr[i6]);
            }
            jArr2[i3] = ((long) i4) | j4;
            i3++;
        }
        int i7 = this.f3144m;
        if (i7 != Integer.MAX_VALUE) {
            this.f3144m = (int) (jArr[i7] & 4294967295L);
        }
        int i8 = this.f3145n;
        if (i8 != Integer.MAX_VALUE) {
            this.f3145n = (int) (jArr[i8] & 4294967295L);
        }
        int i9 = this.f3146o;
        if (i9 != Integer.MAX_VALUE) {
            this.f3146o = (int) (jArr[i9] & 4294967295L);
        }
    }

    private final void l() {
        this.f3140i = ScatterMapKt.b(this.f3139h) - j();
    }

    private final void m(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
            jArr = jArr2;
        }
        this.f3135d = jArr;
        l();
    }

    private final void n(int i3) {
        long[] jArrA;
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f3139h = iMax;
        m(iMax);
        this.f3136e = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
        this.f3137f = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
        if (iMax == 0) {
            jArrA = SieveCacheKt.a();
        } else {
            long[] jArr = new long[iMax];
            ArraysKt.fill$default(jArr, 4611686018427387903L, 0, 0, 6, (Object) null);
            jArrA = jArr;
        }
        this.f3138g = jArrA;
    }

    private final Object p(int i3) {
        this.f3141j--;
        long[] jArr = this.f3135d;
        int i4 = this.f3139h;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        this.f3136e[i3] = null;
        Object[] objArr = this.f3137f;
        Object obj = objArr[i3];
        objArr[i3] = null;
        long[] jArr2 = this.f3138g;
        long j4 = jArr2[i3];
        int i7 = (int) ((j4 >> 31) & 2147483647L);
        int i8 = (int) (j4 & 2147483647L);
        if (i7 != Integer.MAX_VALUE) {
            jArr2[i7] = (jArr2[i7] & (-2147483648L)) | (((long) i8) & 2147483647L);
        } else {
            this.f3144m = i8;
        }
        if (i8 != Integer.MAX_VALUE) {
            jArr2[i8] = ((((long) i7) & 2147483647L) << 31) | (jArr2[i8] & (-4611686016279904257L));
        } else {
            this.f3145n = i7;
        }
        if (this.f3146o == i3) {
            this.f3146o = i7;
        }
        jArr2[i3] = 4611686018427387903L;
        return obj;
    }

    public final void a() {
        if (this.f3139h <= 8 || Long.compareUnsigned(ULong.b(ULong.b(j()) * 32), ULong.b(ULong.b(this.f3139h) * 25)) > 0) {
            q(ScatterMapKt.d(this.f3139h));
        } else {
            b();
        }
    }

    public final void b() {
        int i3;
        Object[] objArr;
        long[] jArr = this.f3135d;
        if (jArr == null) {
            return;
        }
        int i4 = this.f3139h;
        Object[] objArr2 = this.f3136e;
        Object[] objArr3 = this.f3137f;
        long[] jArr2 = this.f3138g;
        long[] jArr3 = new long[i4];
        long j3 = 9223372034707292159L;
        int i5 = 0;
        ArraysKt.fill(jArr3, 9223372034707292159L, 0, i4);
        int i6 = (i4 + 7) >> 3;
        for (int i7 = 0; i7 < i6; i7++) {
            long j4 = jArr[i7] & (-9187201950435737472L);
            jArr[i7] = (-72340172838076674L) & ((~j4) + (j4 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i8 = lastIndex - 1;
        jArr[i8] = (jArr[i8] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i9 = 0;
        while (i9 != i4) {
            int i10 = i9 >> 3;
            int i11 = (i9 & 7) << 3;
            long j5 = (jArr[i10] >> i11) & 255;
            if (j5 != 128 && j5 == 254) {
                Object obj = objArr2[i9];
                int iHashCode = (obj != null ? obj.hashCode() : i5) * (-862048943);
                int i12 = iHashCode ^ (iHashCode << 16);
                int i13 = i12 >>> 7;
                long j6 = j3;
                int iD = d(i13);
                int i14 = i13 & i4;
                if (((iD - i14) & i4) / 8 == ((i9 - i14) & i4) / 8) {
                    int i15 = i5;
                    int i16 = i9;
                    jArr[i10] = (((long) (i12 & 127)) << i11) | ((~(255 << i11)) & jArr[i10]);
                    if (jArr3[i16] == j6) {
                        long j7 = i16;
                        jArr3[i16] = j7 | (j7 << 32);
                    }
                    jArr[jArr.length - 1] = jArr[i15];
                    i9 = i16 + 1;
                    j3 = j6;
                    i5 = i15;
                } else {
                    int i17 = i5;
                    int i18 = iD >> 3;
                    long j8 = jArr[i18];
                    int i19 = (iD & 7) << 3;
                    if (((j8 >> i19) & 255) == 128) {
                        i3 = i4;
                        objArr = objArr2;
                        jArr[i18] = (j8 & (~(255 << i19))) | (((long) (i12 & 127)) << i19);
                        jArr[i10] = (jArr[i10] & (~(255 << i11))) | (128 << i11);
                        objArr[iD] = objArr[i9];
                        objArr[i9] = null;
                        objArr3[iD] = objArr3[i9];
                        objArr3[i9] = null;
                        jArr2[iD] = jArr2[i9];
                        jArr2[i9] = 4611686018427387903L;
                        int i20 = (int) ((jArr3[i9] >> 32) & 4294967295L);
                        if (i20 != Integer.MAX_VALUE) {
                            jArr3[i20] = (jArr3[i20] & (-4294967296L)) | ((long) iD);
                            jArr3[i9] = (jArr3[i9] & 4294967295L) | (-4294967296L);
                        } else {
                            jArr3[i9] = (((long) Api.BaseClientBuilder.API_PRIORITY_OTHER) << 32) | ((long) iD);
                        }
                        jArr3[iD] = (((long) i9) << 32) | ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER);
                    } else {
                        i3 = i4;
                        objArr = objArr2;
                        jArr[i18] = (((long) (i12 & 127)) << i19) | (j8 & (~(255 << i19)));
                        Object obj2 = objArr[iD];
                        objArr[iD] = objArr[i9];
                        objArr[i9] = obj2;
                        Object obj3 = objArr3[iD];
                        objArr3[iD] = objArr3[i9];
                        objArr3[i9] = obj3;
                        long j9 = jArr2[iD];
                        jArr2[iD] = jArr2[i9];
                        jArr2[i9] = j9;
                        int i21 = (int) ((jArr3[i9] >> 32) & 4294967295L);
                        if (i21 != Integer.MAX_VALUE) {
                            long j10 = iD;
                            jArr3[i21] = (jArr3[i21] & (-4294967296L)) | j10;
                            jArr3[i9] = (jArr3[i9] & 4294967295L) | (j10 << 32);
                        } else {
                            long j11 = iD;
                            jArr3[i9] = j11 | (j11 << 32);
                            i21 = i9;
                        }
                        jArr3[iD] = (((long) i21) << 32) | ((long) i9);
                        i9--;
                    }
                    jArr[jArr.length - 1] = jArr[i17];
                    i9++;
                    i4 = i3;
                    j3 = j6;
                    i5 = i17;
                    objArr2 = objArr;
                }
            } else {
                i9++;
            }
        }
        l();
        h(jArr3);
    }

    public boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SieveCache)) {
            return false;
        }
        SieveCache sieveCache = (SieveCache) obj;
        if (sieveCache.k() != k() || sieveCache.f3141j != this.f3141j) {
            return false;
        }
        Object[] objArr = this.f3136e;
        Object[] objArr2 = this.f3137f;
        long[] jArr = this.f3135d;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        Object obj2 = objArr[i6];
                        z3 = z4;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj3 = objArr2[i6];
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        if (!Intrinsics.areEqual(obj3, sieveCache.i(obj2))) {
                            return false;
                        }
                    } else {
                        z3 = z4;
                    }
                    j3 >>= 8;
                    i5++;
                    z4 = z3;
                }
                z2 = z4;
                if (i4 != 8) {
                    return z2;
                }
            } else {
                z2 = z4;
            }
            if (i3 == length) {
                return z2;
            }
            i3++;
            z4 = z2;
        }
    }

    public int hashCode() {
        Object[] objArr = this.f3136e;
        Object[] objArr2 = this.f3137f;
        long[] jArr = this.f3135d;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i3 = 0;
        int iHashCode = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        Object obj = objArr[i6];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
                        Object obj2 = objArr2[i6];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
                        iHashCode += obj2.hashCode() ^ obj.hashCode();
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return iHashCode;
                }
            }
            if (i3 == length) {
                return iHashCode;
            }
            i3++;
        }
    }

    public final Object i(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int iF = f(key);
        if (iF >= 0) {
            long[] jArr = this.f3138g;
            jArr[iF] = (jArr[iF] & 4611686018427387903L) | 4611686018427387904L;
            return this.f3137f[iF];
        }
        Object objInvoke = this.f3133b.invoke(key);
        if (objInvoke == null) {
            return null;
        }
        o(key, objInvoke);
        return objInvoke;
    }

    public final int j() {
        return this.f3141j;
    }

    public final int k() {
        return this.f3143l;
    }

    public final Object o(Object key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        int iE = e(key);
        if (iE < 0) {
            iE = ~iE;
        }
        Object[] objArr = this.f3137f;
        Object obj = objArr[iE];
        objArr[iE] = value;
        this.f3136e[iE] = key;
        int iIntValue = this.f3143l + ((Number) this.f3132a.invoke(key, value)).intValue();
        this.f3143l = iIntValue;
        if (obj != null) {
            this.f3143l = iIntValue - ((Number) this.f3132a.invoke(key, obj)).intValue();
            this.f3134c.invoke(key, obj, value, Boolean.FALSE);
            r(this.f3142k);
            return obj;
        }
        r(this.f3142k);
        long[] jArr = this.f3138g;
        int i3 = this.f3144m;
        jArr[iE] = (((long) i3) & 2147483647L) | 4611686016279904256L;
        if (i3 != Integer.MAX_VALUE) {
            jArr[i3] = (jArr[i3] & (-4611686016279904257L)) | ((2147483647L & ((long) iE)) << 31);
        }
        this.f3144m = iE;
        if (this.f3145n == Integer.MAX_VALUE) {
            this.f3145n = iE;
        }
        return obj;
    }

    public final void q(int i3) {
        long[] jArr;
        Object[] objArr;
        long[] jArr2 = this.f3135d;
        Object[] objArr2 = this.f3136e;
        Object[] objArr3 = this.f3137f;
        long[] jArr3 = this.f3138g;
        int i4 = this.f3139h;
        int[] iArr = new int[i4];
        n(i3);
        long[] jArr4 = this.f3135d;
        Object[] objArr4 = this.f3136e;
        Object[] objArr5 = this.f3137f;
        long[] jArr5 = this.f3138g;
        int i5 = this.f3139h;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                Object obj = objArr2[i6];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iD = d(i7 >>> 7);
                jArr = jArr2;
                objArr = objArr2;
                long j3 = i7 & 127;
                int i8 = iD >> 3;
                int i9 = (iD & 7) << 3;
                long j4 = (jArr4[i8] & (~(255 << i9))) | (j3 << i9);
                jArr4[i8] = j4;
                jArr4[(((iD - 7) & i5) + (i5 & 7)) >> 3] = j4;
                objArr4[iD] = obj;
                objArr5[iD] = objArr3[i6];
                jArr5[iD] = jArr3[i6];
                iArr[i6] = iD;
            } else {
                jArr = jArr2;
                objArr = objArr2;
            }
            i6++;
            jArr2 = jArr;
            objArr2 = objArr;
        }
        g(iArr);
    }

    public final void r(int i3) {
        int iC;
        while (this.f3143l > i3 && j() != 0 && (iC = c()) != Integer.MAX_VALUE) {
            Object obj = this.f3136e[iC];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
            Object objP = p(iC);
            if (objP != null) {
                this.f3143l -= ((Number) this.f3132a.invoke(obj, objP)).intValue();
                this.f3134c.invoke(obj, objP, null, Boolean.TRUE);
            }
        }
    }

    public String toString() {
        return "SieveCache[maxSize=" + this.f3142k + ", size=" + this.f3143l + ", capacity=" + this.f3139h + ", count=" + this.f3141j + ']';
    }

    public /* synthetic */ SieveCache(int i3, int i4, Function2 function2, Function1 function1, Function4 function4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i5 & 2) != 0 ? 6 : i4, (i5 & 4) != 0 ? new Function2<K, V, Integer>() { // from class: androidx.collection.SieveCache.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Object obj, Object obj2) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(obj2, "<anonymous parameter 1>");
                return 1;
            }
        } : function2, (i5 & 8) != 0 ? new Function1() { // from class: androidx.collection.SieveCache.2
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : function1, (i5 & 16) != 0 ? new Function4<K, V, V, Boolean, Unit>() { // from class: androidx.collection.SieveCache.3
            public final void c(Object obj, Object obj2, Object obj3, boolean z2) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(obj2, "<anonymous parameter 1>");
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c(obj, obj2, obj3, ((Boolean) obj4).booleanValue());
                return Unit.f139807a;
            }
        } : function4);
    }
}
