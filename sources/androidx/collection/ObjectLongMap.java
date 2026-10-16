package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
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
public abstract class ObjectLongMap<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f3086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f3087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f3088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3090e;

    public /* synthetic */ ObjectLongMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a(Object obj) {
        int i3 = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i4 = iHashCode ^ (iHashCode << 16);
        int i5 = i4 & 127;
        int i6 = this.f3089d;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.f3086a;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j3 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j4 = (((long) i5) * 72340172838076673L) ^ j3;
            for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                if (Intrinsics.areEqual(this.f3087b[iNumberOfTrailingZeros], obj)) {
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

    public final int b() {
        return this.f3089d;
    }

    public final int c() {
        return this.f3090e;
    }

    public final boolean d() {
        return this.f3090e == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
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
            boolean r3 = r1 instanceof androidx.collection.ObjectLongMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.ObjectLongMap r1 = (androidx.collection.ObjectLongMap) r1
            int r3 = r1.c()
            int r5 = r0.c()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            java.lang.Object[] r3 = r0.f3087b
            long[] r5 = r0.f3088c
            long[] r6 = r0.f3086a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L6d
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
            if (r11 == 0) goto L68
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L66
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L62
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r16 = r5[r14]
            int r14 = r1.a(r15)
            if (r14 < 0) goto L61
            long[] r15 = r1.f3088c
            r14 = r15[r14]
            int r14 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r14 == 0) goto L62
        L61:
            return r4
        L62:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L41
        L66:
            if (r11 != r12) goto L6d
        L68:
            if (r8 == r7) goto L6d
            int r8 = r8 + 1
            goto L27
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectLongMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Object[] objArr = this.f3087b;
        long[] jArr = this.f3088c;
        long[] jArr2 = this.f3086a;
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
                        Object obj = objArr[i6];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(jArr[i6]);
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
        if (d()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.f3087b;
        long[] jArr = this.f3088c;
        long[] jArr2 = this.f3086a;
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
                            Object obj = objArr[i9];
                            i4 = i5;
                            long j4 = jArr[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            sb.append(j4);
                            i6++;
                            if (i6 < this.f3090e) {
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
                    int i10 = i5;
                    if (i7 != 8) {
                        break;
                    }
                    i3 = i10;
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

    private ObjectLongMap() {
        this.f3086a = ScatterMapKt.f3113a;
        this.f3087b = ContainerHelpersKt.f3176c;
        this.f3088c = LongSetKt.a();
    }
}
