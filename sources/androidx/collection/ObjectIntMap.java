package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
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
public abstract class ObjectIntMap<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f3075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f3076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f3077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3079e;

    public /* synthetic */ ObjectIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a(Object obj) {
        return b(obj) >= 0;
    }

    public final int b(Object obj) {
        int i3 = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 & 127;
        int i6 = this.f3078d;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.f3075a;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = (((long) i5) * 72340172838076673L) ^ j3;
            for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                if (Intrinsics.areEqual(this.f3076b[iNumberOfTrailingZeros], obj)) {
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

    public final int c(Object obj) {
        int iB = b(obj);
        if (iB < 0) {
            RuntimeHelpersKt.d("There is no key " + obj + " in the map");
        }
        return this.f3077c[iB];
    }

    public final int d() {
        return this.f3078d;
    }

    public final int e(Object obj, int i3) {
        int iB = b(obj);
        return iB >= 0 ? this.f3077c[iB] : i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.ObjectIntMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.ObjectIntMap r1 = (androidx.collection.ObjectIntMap) r1
            int r3 = r1.f()
            int r5 = r0.f()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            java.lang.Object[] r3 = r0.f3076b
            int[] r5 = r0.f3077c
            long[] r6 = r0.f3075a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L78
            r8 = r4
        L27:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L6f
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L6a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L62
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r14 = r5[r14]
            int r15 = r1.b(r15)
            if (r15 < 0) goto L61
            r16 = r2
            int[] r2 = r1.f3077c
            r2 = r2[r15]
            if (r14 == r2) goto L64
        L61:
            return r4
        L62:
            r16 = r2
        L64:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r2 = r16
            goto L41
        L6a:
            r16 = r2
            if (r11 != r12) goto L7a
            goto L71
        L6f:
            r16 = r2
        L71:
            if (r8 == r7) goto L7a
            int r8 = r8 + 1
            r2 = r16
            goto L27
        L78:
            r16 = r2
        L7a:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectIntMap.equals(java.lang.Object):boolean");
    }

    public final int f() {
        return this.f3079e;
    }

    public final boolean g() {
        return this.f3079e == 0;
    }

    public final boolean h() {
        return this.f3079e != 0;
    }

    public int hashCode() {
        Object[] objArr = this.f3076b;
        int[] iArr = this.f3077c;
        long[] jArr = this.f3075a;
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
                        iHashCode += Integer.hashCode(iArr[i6]) ^ (obj != null ? obj.hashCode() : 0);
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[PHI: r8
      0x0074: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0031, B:22:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.g()
            if (r1 == 0) goto Lb
            java.lang.String r1 = "{}"
            return r1
        Lb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 123(0x7b, float:1.72E-43)
            r1.append(r2)
            java.lang.Object[] r2 = r0.f3076b
            int[] r3 = r0.f3077c
            long[] r4 = r0.f3075a
            int r5 = r4.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L79
            r6 = 0
            r7 = r6
            r8 = r7
        L23:
            r9 = r4[r7]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L74
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L3d:
            if (r13 >= r11) goto L72
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L6e
            int r14 = r7 << 3
            int r14 = r14 + r13
            r15 = r2[r14]
            r14 = r3[r14]
            if (r15 != r0) goto L53
            java.lang.String r15 = "(this)"
        L53:
            r1.append(r15)
            java.lang.String r15 = "="
            r1.append(r15)
            r1.append(r14)
            int r8 = r8 + 1
            int r14 = r0.f3079e
            if (r8 >= r14) goto L6e
            r14 = 44
            r1.append(r14)
            r14 = 32
            r1.append(r14)
        L6e:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L3d
        L72:
            if (r11 != r12) goto L79
        L74:
            if (r7 == r5) goto L79
            int r7 = r7 + 1
            goto L23
        L79:
            r2 = 125(0x7d, float:1.75E-43)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectIntMap.toString():java.lang.String");
    }

    private ObjectIntMap() {
        this.f3075a = ScatterMapKt.f3113a;
        this.f3076b = ContainerHelpersKt.f3176c;
        this.f3077c = IntSetKt.a();
    }
}
