package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.google.android.gms.common.api.Api;
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
public final class MutableOrderedScatterSet<E> extends OrderedScatterSet<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3025h;

    public /* synthetic */ MutableOrderedScatterSet(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 6 : i3);
    }

    private final int m(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this.f3097f;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.f3092a;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = i5;
            int i11 = i5;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
                if (Intrinsics.areEqual(this.f3093b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int iN = n(i4);
                if (this.f3025h == 0 && ((this.f3092a[iN >> 3] >> ((iN & 7) << 3)) & 255) != 254) {
                    i();
                    iN = n(i4);
                }
                this.f3098g++;
                int i12 = this.f3025h;
                long[] jArr2 = this.f3092a;
                int i13 = iN >> 3;
                long j7 = jArr2[i13];
                int i14 = (iN & 7) << 3;
                this.f3025h = i12 - (((j7 >> i14) & 255) == 128 ? 1 : 0);
                int i15 = this.f3097f;
                long j8 = ((~(255 << i14)) & j7) | (j4 << i14);
                jArr2[i13] = j8;
                jArr2[(((iN - 7) & i15) + (i15 & 7)) >> 3] = j8;
                return iN;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }

    private final int n(int i3) {
        int i4 = this.f3097f;
        int i5 = i3 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.f3092a;
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

    private final void o(int[] iArr) {
        long[] jArr = this.f3094c;
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
        int i7 = this.f3095d;
        if (i7 != Integer.MAX_VALUE) {
            this.f3095d = iArr[i7];
        }
        int i8 = this.f3096e;
        if (i8 != Integer.MAX_VALUE) {
            this.f3096e = iArr[i8];
        }
    }

    private final void p(long[] jArr) {
        long[] jArr2 = this.f3094c;
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
        int i7 = this.f3095d;
        if (i7 != Integer.MAX_VALUE) {
            this.f3095d = (int) (jArr[i7] & 4294967295L);
        }
        int i8 = this.f3096e;
        if (i8 != Integer.MAX_VALUE) {
            this.f3096e = (int) (jArr[i8] & 4294967295L);
        }
    }

    private final void q() {
        this.f3025h = ScatterMapKt.b(b()) - this.f3098g;
    }

    private final void r(int i3) {
        long[] jArr;
        if (i3 == 0) {
            jArr = ScatterMapKt.f3113a;
        } else {
            long[] jArr2 = new long[((i3 + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.f3092a = jArr;
        int i4 = i3 >> 3;
        long j3 = 255 << ((i3 & 7) << 3);
        jArr[i4] = (jArr[i4] & (~j3)) | j3;
        q();
    }

    private final void s(int i3) {
        long[] jArrA;
        int iMax = i3 > 0 ? Math.max(7, ScatterMapKt.e(i3)) : 0;
        this.f3097f = iMax;
        r(iMax);
        this.f3093b = iMax == 0 ? ContainerHelpersKt.f3176c : new Object[iMax];
        if (iMax == 0) {
            jArrA = SieveCacheKt.a();
        } else {
            long[] jArr = new long[iMax];
            ArraysKt.fill$default(jArr, 4611686018427387903L, 0, 0, 6, (Object) null);
            jArrA = jArr;
        }
        this.f3094c = jArrA;
    }

    public final void A(int i3) {
        long[] jArr;
        Object[] objArr;
        long[] jArr2 = this.f3092a;
        Object[] objArr2 = this.f3093b;
        long[] jArr3 = this.f3094c;
        int i4 = this.f3097f;
        int[] iArr = new int[i4];
        s(i3);
        long[] jArr4 = this.f3092a;
        Object[] objArr3 = this.f3093b;
        long[] jArr5 = this.f3094c;
        int i5 = this.f3097f;
        int i6 = 0;
        while (i6 < i4) {
            if (((jArr2[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128) {
                Object obj = objArr2[i6];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i7 = iHashCode ^ (iHashCode << 16);
                int iN = n(i7 >>> 7);
                long j3 = i7 & 127;
                int i8 = iN >> 3;
                int i9 = (iN & 7) << 3;
                jArr = jArr2;
                objArr = objArr2;
                long j4 = (jArr4[i8] & (~(255 << i9))) | (j3 << i9);
                jArr4[i8] = j4;
                jArr4[(((iN - 7) & i5) + (i5 & 7)) >> 3] = j4;
                objArr3[iN] = obj;
                jArr5[iN] = jArr3[i6];
                iArr[i6] = iN;
            } else {
                jArr = jArr2;
                objArr = objArr2;
            }
            i6++;
            jArr2 = jArr;
            objArr2 = objArr;
        }
        o(iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean B(java.util.Collection r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.Object[] r2 = r0.f3093b
            int r3 = r0.f3098g
            long[] r4 = r0.f3092a
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
            r0.z(r13)
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
            int r1 = r0.f3098g
            if (r3 == r1) goto L5d
            r1 = 1
            return r1
        L5d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableOrderedScatterSet.B(java.util.Collection):boolean");
    }

    public final void C(int i3) {
        int i4;
        long[] jArr = this.f3094c;
        int i5 = this.f3095d;
        while (i5 != Integer.MAX_VALUE && (i4 = this.f3098g) > i3 && i4 != 0) {
            int i6 = (int) (jArr[i5] & 2147483647L);
            z(i5);
            i5 = i6;
        }
    }

    public final boolean g(Object obj) {
        int iC = c();
        int iM = m(obj);
        this.f3093b[iM] = obj;
        long[] jArr = this.f3094c;
        int i3 = this.f3095d;
        jArr[iM] = (((long) i3) & 2147483647L) | 4611686016279904256L;
        if (i3 != Integer.MAX_VALUE) {
            jArr[i3] = ((((long) iM) & 2147483647L) << 31) | (jArr[i3] & (-4611686016279904257L));
        }
        this.f3095d = iM;
        if (this.f3096e == Integer.MAX_VALUE) {
            this.f3096e = iM;
        }
        return c() != iC;
    }

    public final boolean h(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iC = c();
        v(elements);
        return iC != c();
    }

    public final void i() {
        if (this.f3097f <= 8 || Long.compareUnsigned(ULong.b(ULong.b(this.f3098g) * 32), ULong.b(ULong.b(this.f3097f) * 25)) > 0) {
            A(ScatterMapKt.d(this.f3097f));
        } else {
            l();
        }
    }

    public final Set j() {
        return new MutableOrderedSetWrapper(this);
    }

    public final void k() {
        this.f3098g = 0;
        long[] jArr = this.f3092a;
        if (jArr != ScatterMapKt.f3113a) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.f3092a;
            int i3 = this.f3097f;
            int i4 = i3 >> 3;
            long j3 = 255 << ((i3 & 7) << 3);
            jArr2[i4] = (jArr2[i4] & (~j3)) | j3;
        }
        ArraysKt.fill(this.f3093b, (Object) null, 0, this.f3097f);
        ArraysKt.fill$default(this.f3094c, 4611686018427387903L, 0, 0, 6, (Object) null);
        this.f3095d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f3096e = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        q();
    }

    public final void l() {
        int i3;
        long[] jArr = this.f3092a;
        if (jArr == null) {
            return;
        }
        int i4 = this.f3097f;
        Object[] objArr = this.f3093b;
        long[] jArr2 = this.f3094c;
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
                Object obj = objArr[i9];
                int iHashCode = (obj != null ? obj.hashCode() : i5) * (-862048943);
                int i12 = iHashCode ^ (iHashCode << 16);
                int i13 = i12 >>> 7;
                long j6 = j3;
                int iN = n(i13);
                int i14 = i13 & i4;
                if (((iN - i14) & i4) / 8 == ((i9 - i14) & i4) / 8) {
                    jArr[i10] = (((long) (i12 & 127)) << i11) | (jArr[i10] & (~(255 << i11)));
                    if (jArr3[i9] == j6) {
                        long j7 = i9;
                        jArr3[i9] = j7 | (j7 << 32);
                    }
                    jArr[jArr.length - 1] = jArr[i5];
                    i9++;
                    j3 = j6;
                } else {
                    int i15 = iN >> 3;
                    long j8 = jArr[i15];
                    int i16 = (iN & 7) << 3;
                    int i17 = i5;
                    if (((j8 >> i16) & 255) == 128) {
                        int i18 = i9;
                        jArr[i15] = (j8 & (~(255 << i16))) | (((long) (i12 & 127)) << i16);
                        jArr[i10] = (jArr[i10] & (~(255 << i11))) | (128 << i11);
                        objArr[iN] = objArr[i18];
                        objArr[i18] = null;
                        jArr2[iN] = jArr2[i18];
                        jArr2[i18] = 4611686018427387903L;
                        int i19 = (int) ((jArr3[i18] >> 32) & 4294967295L);
                        if (i19 != Integer.MAX_VALUE) {
                            jArr3[i19] = (jArr3[i19] & (-4294967296L)) | ((long) iN);
                            jArr3[i18] = (jArr3[i18] & 4294967295L) | (-4294967296L);
                        } else {
                            jArr3[i18] = (((long) Api.BaseClientBuilder.API_PRIORITY_OTHER) << 32) | ((long) iN);
                        }
                        i3 = i18;
                        jArr3[iN] = ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER) | (((long) i3) << 32);
                    } else {
                        jArr[i15] = (((long) (i12 & 127)) << i16) | (j8 & (~(255 << i16)));
                        Object obj2 = objArr[iN];
                        objArr[iN] = objArr[i9];
                        objArr[i9] = obj2;
                        long j9 = jArr2[iN];
                        jArr2[iN] = jArr2[i9];
                        jArr2[i9] = j9;
                        int i20 = (int) ((jArr3[i9] >> 32) & 4294967295L);
                        if (i20 != Integer.MAX_VALUE) {
                            long j10 = iN;
                            jArr3[i20] = (jArr3[i20] & (-4294967296L)) | j10;
                            jArr3[i9] = (jArr3[i9] & 4294967295L) | (j10 << 32);
                        } else {
                            long j11 = iN;
                            jArr3[i9] = j11 | (j11 << 32);
                            i20 = i9;
                        }
                        jArr3[iN] = (((long) i20) << 32) | ((long) i9);
                        i3 = i9 - 1;
                    }
                    jArr[jArr.length - 1] = jArr[i17];
                    i9 = i3 + 1;
                    j3 = j6;
                    i5 = i17;
                }
            } else {
                i9++;
            }
        }
        q();
        p(jArr3);
    }

    public final void t(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            u(it.next());
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
    public final void u(java.lang.Object r14) {
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
            int r3 = r13.f3097f
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.f3092a
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
            java.lang.Object[] r11 = r13.f3093b
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
            r13.z(r10)
        L70:
            return
        L71:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableOrderedScatterSet.u(java.lang.Object):void");
    }

    public final void v(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
    }

    public final void w(Object obj) {
        int iM = m(obj);
        this.f3093b[iM] = obj;
        long[] jArr = this.f3094c;
        int i3 = this.f3095d;
        jArr[iM] = (((long) i3) & 2147483647L) | 4611686016279904256L;
        if (i3 != Integer.MAX_VALUE) {
            jArr[i3] = ((((long) iM) & 2147483647L) << 31) | (jArr[i3] & (-4611686016279904257L));
        }
        this.f3095d = iM;
        if (this.f3096e == Integer.MAX_VALUE) {
            this.f3096e = iM;
        }
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
    public final boolean x(java.lang.Object r18) {
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
            int r5 = r0.f3097f
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.f3092a
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
            java.lang.Object[] r15 = r0.f3093b
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
            r0.z(r11)
        L78:
            return r2
        L79:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableOrderedScatterSet.x(java.lang.Object):boolean");
    }

    public final boolean y(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iC = c();
        t(elements);
        return iC != c();
    }

    public final void z(int i3) {
        this.f3098g--;
        long[] jArr = this.f3092a;
        int i4 = this.f3097f;
        int i5 = i3 >> 3;
        int i6 = (i3 & 7) << 3;
        long j3 = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        jArr[i5] = j3;
        jArr[(((i3 - 7) & i4) + (i4 & 7)) >> 3] = j3;
        this.f3093b[i3] = null;
        long[] jArr2 = this.f3094c;
        long j4 = jArr2[i3];
        int i7 = (int) ((j4 >> 31) & 2147483647L);
        int i8 = (int) (j4 & 2147483647L);
        if (i7 != Integer.MAX_VALUE) {
            jArr2[i7] = (jArr2[i7] & (-2147483648L)) | (((long) i8) & 2147483647L);
        } else {
            this.f3095d = i8;
        }
        if (i8 != Integer.MAX_VALUE) {
            jArr2[i8] = ((((long) i7) & 2147483647L) << 31) | (jArr2[i8] & (-4611686016279904257L));
        } else {
            this.f3096e = i7;
        }
        jArr2[i3] = 4611686018427387903L;
    }

    public MutableOrderedScatterSet(int i3) {
        super(null);
        if (!(i3 >= 0)) {
            RuntimeHelpersKt.a("Capacity must be a positive value.");
        }
        s(ScatterMapKt.f(i3));
    }
}
