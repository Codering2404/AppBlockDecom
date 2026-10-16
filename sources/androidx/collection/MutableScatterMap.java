package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Map;
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
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3038f;

    public /* synthetic */ MutableScatterMap(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }

    private final int m(int i3) {
        int i4 = this.f3111d;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f3108a;
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

    private final void o() {
        this.f3038f = ScatterMapKt.b(f()) - this.f3112e;
    }

    private final void p(int i3) {
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
        this.f3108a = jArr;
        o();
    }

    private final void q(int i3) {
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f3111d = iMax;
        p(iMax);
        this.f3109b = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
        this.f3110c = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
    }

    public final void j() {
        if (this.f3111d <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f3112e) * 32), ULong.b(ULong.b(this.f3111d) * 25)) > 0) {
            w(ScatterMapKt.d(this.f3111d));
        } else {
            l();
        }
    }

    public final void k() {
        this.f3112e = 0;
        long[] jArr = this.f3108a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f3108a;
            int i3 = this.f3111d;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f3110c, (Object) null, 0, this.f3111d);
        ArraysKt.fill(this.f3109b, (Object) null, 0, this.f3111d);
        o();
    }

    public final void l() {
        long[] jArr = this.f3108a;
        int i3 = this.f3111d;
        Object[] objArr = this.f3109b;
        Object[] objArr2 = this.f3110c;
        int i4 = (i3 + 7) >> 3;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            long j3 = jArr[i6] & (-9187201950435737472L);
            jArr[i6] = (-72340172838076674L) & ((~j3) + (j3 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i7 = lastIndex - 1;
        jArr[i7] = (jArr[i7] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i8 = 0;
        while (i8 != i3) {
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j4 = (jArr[i9] >> i10) & 255;
            if (j4 != 128 && j4 == 254) {
                Object obj = objArr[i8];
                int iHashCode = (obj != null ? obj.hashCode() : i5) * (-862048943);
                int i11 = iHashCode ^ (iHashCode << 16);
                int i12 = i11 >>> 7;
                int iM = m(i12);
                int i13 = i12 & i3;
                int i14 = i5;
                if (((iM - i13) & i3) / 8 == ((i8 - i13) & i3) / 8) {
                    jArr[i9] = (((long) (i11 & 127)) << i10) | ((~(255 << i10)) & jArr[i9]);
                    jArr[ArraysKt.getLastIndex(jArr)] = jArr[i14];
                } else {
                    int i15 = iM >> 3;
                    long j5 = jArr[i15];
                    int i16 = (iM & 7) << 3;
                    if (((j5 >> i16) & 255) == 128) {
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j5 & (~(255 << i16)));
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        objArr[iM] = objArr[i8];
                        objArr[i8] = null;
                        objArr2[iM] = objArr2[i8];
                        objArr2[i8] = null;
                    } else {
                        jArr[i15] = (((long) (i11 & 127)) << i16) | (j5 & (~(255 << i16)));
                        Object obj2 = objArr[iM];
                        objArr[iM] = objArr[i8];
                        objArr[i8] = obj2;
                        Object obj3 = objArr2[iM];
                        objArr2[iM] = objArr2[i8];
                        objArr2[i8] = obj3;
                        i8--;
                    }
                    jArr[ArraysKt.getLastIndex(jArr)] = jArr[i14];
                }
                i8++;
                i5 = i14;
            } else {
                i8++;
            }
        }
        o();
    }

    public final int n(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f3111d;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f3108a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = i5;
            int i11 = i5;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
                if (Intrinsics.areEqual(this.f3109b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iM = m(i4);
                if (this.f3038f == 0 && ((this.f3108a[iM >> 3] >> ((iM & 7) << 3)) & 255) != 254) {
                    j();
                    iM = m(i4);
                }
                this.f3112e++;
                int i12 = this.f3038f;
                long[] jArr2 = this.f3108a;
                int i13 = iM >> 3;
                long j7 = jArr2[i13];
                int i14 = (iM & 7) << 3;
                this.f3038f = i12 - (((j7 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f3111d;
                long j8 = ((~(255 << i14)) & j7) | (j4 << i14);
                jArr2[i13] = j8;
                jArr2[(((iM - 7) & i15) + (i15 & 7)) >> 3] = j8;
                return ~iM;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }

    public final Object r(Object obj, Object obj2) {
        int iN = n(obj);
        if (iN < 0) {
            iN = ~iN;
        }
        Object[] objArr = this.f3110c;
        Object obj3 = objArr[iN];
        this.f3109b[iN] = obj;
        objArr[iN] = obj2;
        return obj3;
    }

    public final void s(ScatterMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.f3109b;
        Object[] objArr2 = from.f3110c;
        long[] jArr = from.f3108a;
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
                        int i6 = (i3 << 3) + i5;
                        x(objArr[i6], objArr2[i6]);
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

    public final void t(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<K, V> entry : from.entrySet()) {
            x(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.lang.Object r14) {
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
            int r3 = r13.f3111d
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.f3108a
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
            java.lang.Object[] r11 = r13.f3109b
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
            if (r4 == 0) goto L74
            r10 = -1
        L6b:
            if (r10 < 0) goto L72
            java.lang.Object r14 = r13.v(r10)
            return r14
        L72:
            r14 = 0
            return r14
        L74:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap.u(java.lang.Object):java.lang.Object");
    }

    public final Object v(int i3) {
        this.f3112e--;
        long[] jArr = this.f3108a;
        int i4 = this.f3111d;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        this.f3109b[i3] = null;
        Object[] objArr = this.f3110c;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    public final void w(int i3) {
        int i4;
        long[] jArr = this.f3108a;
        Object[] objArr = this.f3109b;
        Object[] objArr2 = this.f3110c;
        int i5 = this.f3111d;
        q(i3);
        long[] jArr2 = this.f3108a;
        Object[] objArr3 = this.f3109b;
        Object[] objArr4 = this.f3110c;
        int i6 = this.f3111d;
        int i7 = 0;
        while (i7 < i5) {
            if (((jArr[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i7];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i8 = iHashCode ^ (iHashCode << 16);
                int iM = m(i8 >>> 7);
                i4 = i7;
                long j3 = i8 & 127;
                int i9 = iM >> 3;
                int i10 = (iM & 7) << 3;
                long j4 = (j3 << i10) | (jArr2[i9] & (~(255 << i10)));
                jArr2[i9] = j4;
                jArr2[(((iM - 7) & i6) + (i6 & 7)) >> 3] = j4;
                objArr3[iM] = obj;
                objArr4[iM] = objArr2[i4];
            } else {
                i4 = i7;
            }
            i7 = i4 + 1;
        }
    }

    public final void x(Object obj, Object obj2) {
        int iN = n(obj);
        if (iN < 0) {
            iN = ~iN;
        }
        this.f3109b[iN] = obj;
        this.f3110c[iN] = obj2;
    }

    public MutableScatterMap(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        q(ScatterMapKt.f(i3));
    }
}
