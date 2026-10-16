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
public abstract class LongObjectMap<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f2931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f2932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2935e;

    public /* synthetic */ LongObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(long r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = java.lang.Long.hashCode(r17)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.f2934d
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.f2931a
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r6 = r6[r7]
            int r12 = 64 - r8
            long r6 = r6 << r12
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L41:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5e
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.f2932b
            r14 = r14[r10]
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L58
            goto L68
        L58:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L41
        L5e:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L6c
            r10 = -1
        L68:
            if (r10 < 0) goto L6b
            return r11
        L6b:
            return r4
        L6c:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.a(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(long r14) {
        /*
            r13 = this;
            int r0 = java.lang.Long.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13.f2934d
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.f2931a
            int r5 = r0 >> 3
            r6 = r0 & 7
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
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3e:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L5b
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            long[] r11 = r13.f2932b
            r11 = r11[r10]
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L55
            goto L65
        L55:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L5b:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6e
            r10 = -1
        L65:
            if (r10 < 0) goto L6c
            java.lang.Object[] r14 = r13.f2933c
            r14 = r14[r10]
            return r14
        L6c:
            r14 = 0
            return r14
        L6e:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.b(long):java.lang.Object");
    }

    public final int c() {
        return this.f2934d;
    }

    public final int d() {
        return this.f2935e;
    }

    public final boolean e() {
        return this.f2935e == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
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
            boolean r3 = r1 instanceof androidx.collection.LongObjectMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            int r3 = r1.d()
            int r5 = r0.d()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            long[] r3 = r0.f2932b
            java.lang.Object[] r5 = r0.f2933c
            long[] r6 = r0.f2931a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L8b
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
            if (r11 == 0) goto L80
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L7a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L70
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r2
            r16 = r3
            r2 = r16[r14]
            r14 = r5[r14]
            if (r14 != 0) goto L65
            java.lang.Object r14 = r1.b(r2)
            if (r14 != 0) goto L64
            boolean r2 = r1.a(r2)
            if (r2 != 0) goto L73
        L64:
            return r4
        L65:
            java.lang.Object r2 = r1.b(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r2)
            if (r2 != 0) goto L73
            return r4
        L70:
            r15 = r2
            r16 = r3
        L73:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r2 = r15
            r3 = r16
            goto L41
        L7a:
            r15 = r2
            r16 = r3
            if (r11 != r12) goto L8c
            goto L83
        L80:
            r15 = r2
            r16 = r3
        L83:
            if (r8 == r7) goto L8c
            int r8 = r8 + 1
            r2 = r15
            r3 = r16
            goto L27
        L8b:
            r15 = r2
        L8c:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        long[] jArr = this.f2932b;
        Object[] objArr = this.f2933c;
        long[] jArr2 = this.f2931a;
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
                        Object obj = objArr[i6];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(j4);
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
        long[] jArr = this.f2932b;
        Object[] objArr = this.f2933c;
        long[] jArr2 = this.f2931a;
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
                            Object obj = objArr[i9];
                            sb.append(j4);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i6++;
                            if (i6 < this.f2935e) {
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

    private LongObjectMap() {
        this.f2931a = ScatterMapKt.f3113a;
        this.f2932b = LongSetKt.a();
        this.f2933c = ContainerHelpersKt.f3176c;
    }
}
