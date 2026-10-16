package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Options;
import okio.Segment;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;

/* JADX INFO: renamed from: okio.internal.-Buffer, reason: invalid class name */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Buffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f145138a = _JvmPlatformKt.a("0123456789abcdef");

    public static final Buffer.UnsafeCursor a(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor unsafeCursorG = SegmentedByteString.g(unsafeCursor);
        if (unsafeCursorG.f144988a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursorG.f144988a = buffer;
        unsafeCursorG.f144989b = true;
        return unsafeCursorG;
    }

    public static final byte[] b() {
        return f145138a;
    }

    public static final boolean c(Segment segment, int i3, byte[] bytes, int i4, int i5) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i6 = segment.f145106c;
        byte[] bArr = segment.f145104a;
        while (i4 < i5) {
            if (i3 == i6) {
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.f145104a;
                bArr = bArr2;
                i3 = segment.f145105b;
                i6 = segment.f145106c;
            }
            if (bArr[i3] != bytes[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    public static final String d(okio.Buffer buffer, long j3) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 > 0) {
            long j4 = j3 - 1;
            if (buffer.r(j4) == 13) {
                String strM1 = buffer.m1(j4);
                buffer.skip(2L);
                return strM1;
            }
        }
        String strM12 = buffer.m1(j3);
        buffer.skip(1L);
        return strM12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (r19 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5 A[LOOP:0: B:8:0x0026->B:46:0x00a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int e(okio.Buffer r17, okio.Options r18, boolean r19) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "options"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            okio.Segment r0 = r0.f144986a
            r1 = -2
            r3 = -1
            if (r0 != 0) goto L18
            if (r19 == 0) goto L17
            return r1
        L17:
            return r3
        L18:
            byte[] r4 = r0.f145104a
            int r5 = r0.f145105b
            int r6 = r0.f145106c
            int[] r2 = r2.f()
            r7 = 0
            r9 = r0
            r10 = r3
            r8 = r7
        L26:
            int r11 = r8 + 1
            r12 = r2[r8]
            int r8 = r8 + 2
            r11 = r2[r11]
            if (r11 == r3) goto L31
            r10 = r11
        L31:
            if (r9 != 0) goto L34
            goto L64
        L34:
            r11 = 0
            if (r12 >= 0) goto L7d
            int r12 = r12 * (-1)
            int r13 = r8 + r12
        L3b:
            int r12 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r8 + 1
            r8 = r2[r8]
            if (r5 == r8) goto L48
            goto L87
        L48:
            if (r14 != r13) goto L4c
            r5 = 1
            goto L4d
        L4c:
            r5 = r7
        L4d:
            if (r12 != r6) goto L6d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            okio.Segment r4 = r9.f145109f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r6 = r4.f145105b
            byte[] r8 = r4.f145104a
            int r9 = r4.f145106c
            if (r4 != r0) goto L67
            if (r5 == 0) goto L64
            r4 = r8
            r8 = r11
            goto L70
        L64:
            if (r19 == 0) goto L87
            return r1
        L67:
            r16 = r8
            r8 = r4
            r4 = r16
            goto L70
        L6d:
            r8 = r9
            r9 = r6
            r6 = r12
        L70:
            if (r5 == 0) goto L78
            r5 = r2[r14]
            r13 = r6
            r6 = r9
            r9 = r8
            goto La2
        L78:
            r5 = r6
            r6 = r9
            r9 = r8
            r8 = r14
            goto L3b
        L7d:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r8 + r12
        L85:
            if (r8 != r14) goto L88
        L87:
            return r10
        L88:
            r15 = r2[r8]
            if (r5 != r15) goto La9
            int r8 = r8 + r12
            r5 = r2[r8]
            if (r13 != r6) goto La2
            okio.Segment r9 = r9.f145109f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r4 = r9.f145105b
            byte[] r6 = r9.f145104a
            int r8 = r9.f145106c
            r13 = r4
            r4 = r6
            r6 = r8
            if (r9 != r0) goto La2
            r9 = r11
        La2:
            if (r5 < 0) goto La5
            return r5
        La5:
            int r8 = -r5
            r5 = r13
            goto L26
        La9:
            int r8 = r8 + 1
            goto L85
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.e(okio.Buffer, okio.Options, boolean):int");
    }

    public static /* synthetic */ int f(okio.Buffer buffer, Options options, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return e(buffer, options, z2);
    }
}
