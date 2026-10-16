package androidx.collection;

import kotlin.Metadata;
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
public abstract class FloatIntMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f2833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f2834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f2835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2837e;

    public /* synthetic */ FloatIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a(float f3) {
        int iHashCode = Float.hashCode(f3) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 & 127;
        int i5 = this.f2836d;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.f2833a;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j3 = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j4 = (((long) i4) * 72340172838076673L) ^ j3;
            for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i6) & i5;
                if (this.f2834b[iNumberOfTrailingZeros] == f3) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    public final int b() {
        return this.f2836d;
    }

    public final int c() {
        return this.f2837e;
    }

    public final boolean d() {
        return this.f2837e == 0;
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
            boolean r3 = r1 instanceof androidx.collection.FloatIntMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.FloatIntMap r1 = (androidx.collection.FloatIntMap) r1
            int r3 = r1.c()
            int r5 = r0.c()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            float[] r3 = r0.f2834b
            int[] r5 = r0.f2835c
            long[] r6 = r0.f2833a
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
            int r15 = r1.a(r15)
            if (r15 < 0) goto L61
            r16 = r2
            int[] r2 = r1.f2835c
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatIntMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        float[] fArr = this.f2834b;
        int[] iArr = this.f2835c;
        long[] jArr = this.f2833a;
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
                        float f3 = fArr[i6];
                        iHashCode += Integer.hashCode(iArr[i6]) ^ Float.hashCode(f3);
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[PHI: r8
      0x0070: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0031, B:19:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.d()
            if (r1 == 0) goto Lb
            java.lang.String r1 = "{}"
            return r1
        Lb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 123(0x7b, float:1.72E-43)
            r1.append(r2)
            float[] r2 = r0.f2834b
            int[] r3 = r0.f2835c
            long[] r4 = r0.f2833a
            int r5 = r4.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L75
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
            if (r11 == 0) goto L70
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L3d:
            if (r13 >= r11) goto L6e
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L6a
            int r14 = r7 << 3
            int r14 = r14 + r13
            r15 = r2[r14]
            r14 = r3[r14]
            r1.append(r15)
            java.lang.String r15 = "="
            r1.append(r15)
            r1.append(r14)
            int r8 = r8 + 1
            int r14 = r0.f2837e
            if (r8 >= r14) goto L6a
            r14 = 44
            r1.append(r14)
            r14 = 32
            r1.append(r14)
        L6a:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L3d
        L6e:
            if (r11 != r12) goto L75
        L70:
            if (r7 == r5) goto L75
            int r7 = r7 + 1
            goto L23
        L75:
            r2 = 125(0x7d, float:1.75E-43)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatIntMap.toString():java.lang.String");
    }

    private FloatIntMap() {
        this.f2833a = ScatterMapKt.f3113a;
        this.f2834b = FloatSetKt.a();
        this.f2835c = IntSetKt.a();
    }
}
