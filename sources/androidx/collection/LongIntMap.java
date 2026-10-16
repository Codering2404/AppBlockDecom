package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.applovin.impl.sdk.utils.JsonUtils;
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
public abstract class LongIntMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f2914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f2915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f2916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2918e;

    public /* synthetic */ LongIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a(long j3) {
        int iHashCode = Long.hashCode(j3) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 & 127;
        int i5 = this.f2917d;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.f2914a;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j4 = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j5 = (((long) i4) * 72340172838076673L) ^ j4;
            for (long j6 = (~j5) & (j5 - 72340172838076673L) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j6) >> 3) + i6) & i5;
                if (this.f2915b[iNumberOfTrailingZeros] == j3) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j4 & ((~j4) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    public final int b(long j3) {
        int iA = a(j3);
        if (iA < 0) {
            RuntimeHelpersKt.d("Cannot find value for key " + j3);
        }
        return this.f2916c[iA];
    }

    public final int c() {
        return this.f2917d;
    }

    public final int d() {
        return this.f2918e;
    }

    public final boolean e() {
        return this.f2918e == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
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
            boolean r3 = r1 instanceof androidx.collection.LongIntMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.LongIntMap r1 = (androidx.collection.LongIntMap) r1
            int r3 = r1.d()
            int r5 = r0.d()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            long[] r3 = r0.f2915b
            int[] r5 = r0.f2916c
            long[] r6 = r0.f2914a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L7e
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
            if (r11 == 0) goto L73
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L6d
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L63
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r2
            r16 = r3
            r2 = r16[r14]
            r14 = r5[r14]
            int r2 = r1.a(r2)
            if (r2 < 0) goto L62
            int[] r3 = r1.f2916c
            r2 = r3[r2]
            if (r14 == r2) goto L66
        L62:
            return r4
        L63:
            r15 = r2
            r16 = r3
        L66:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r2 = r15
            r3 = r16
            goto L41
        L6d:
            r15 = r2
            r16 = r3
            if (r11 != r12) goto L7f
            goto L76
        L73:
            r15 = r2
            r16 = r3
        L76:
            if (r8 == r7) goto L7f
            int r8 = r8 + 1
            r2 = r15
            r3 = r16
            goto L27
        L7e:
            r15 = r2
        L7f:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long[] jArr = this.f2915b;
        int[] iArr = this.f2916c;
        long[] jArr2 = this.f2914a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i3 = 0;
        int iHashCode = 0;
        while (true) {
            long j3 = jArr2[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = (i3 << 3) + i5;
                        long j4 = jArr[i6];
                        iHashCode += Integer.hashCode(iArr[i6]) ^ Long.hashCode(j4);
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

    public String toString() {
        int i3;
        int i4;
        if (e()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        long[] jArr = this.f2915b;
        int[] iArr = this.f2916c;
        long[] jArr2 = this.f2914a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j3 = jArr2[i5];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((255 & j3) < 128) {
                            int i9 = (i5 << 3) + i8;
                            i4 = i5;
                            long j4 = jArr[i9];
                            int i10 = iArr[i9];
                            sb.append(j4);
                            sb.append("=");
                            sb.append(i10);
                            i6++;
                            if (i6 < this.f2918e) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        } else {
                            i4 = i5;
                        }
                        j3 >>= 8;
                        i8++;
                        i5 = i4;
                    }
                    int i11 = i5;
                    if (i7 != 8) {
                        break;
                    }
                    i3 = i11;
                } else {
                    i3 = i5;
                }
                if (i3 == length) {
                    break;
                }
                i5 = i3 + 1;
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private LongIntMap() {
        this.f2914a = ScatterMapKt.f3113a;
        this.f2915b = LongSetKt.a();
        this.f2916c = IntSetKt.a();
    }
}
