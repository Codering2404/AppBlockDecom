package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;

/* JADX INFO: renamed from: okio.-SegmentedByteString, reason: invalid class name */
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
public final class SegmentedByteString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Buffer.UnsafeCursor f144971a = new Buffer.UnsafeCursor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f144972b = -1234567890;

    public static final boolean a(byte[] a3, int i3, byte[] b3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(a3, "a");
        Intrinsics.checkNotNullParameter(b3, "b");
        for (int i6 = 0; i6 < i5; i6++) {
            if (a3[i6 + i3] != b3[i6 + i4]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException("size=" + j3 + " offset=" + j4 + " byteCount=" + j5);
        }
    }

    public static final int c() {
        return f144972b;
    }

    public static final Buffer.UnsafeCursor d() {
        return f144971a;
    }

    public static final int e(ByteString byteString, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i3 == f144972b ? byteString.C() : i3;
    }

    public static final int f(byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return i3 == f144972b ? bArr.length : i3;
    }

    public static final Buffer.UnsafeCursor g(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return unsafeCursor == f144971a ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int h(int i3) {
        return ((i3 & 255) << 24) | (((-16777216) & i3) >>> 24) | ((16711680 & i3) >>> 8) | ((65280 & i3) << 8);
    }

    public static final long i(long j3) {
        return ((j3 & 255) << 56) | (((-72057594037927936L) & j3) >>> 56) | ((71776119061217280L & j3) >>> 40) | ((280375465082880L & j3) >>> 24) | ((1095216660480L & j3) >>> 8) | ((4278190080L & j3) << 8) | ((16711680 & j3) << 24) | ((65280 & j3) << 40);
    }

    public static final short j(short s2) {
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    public static final String k(byte b3) {
        return StringsKt.y(new char[]{okio.internal.ByteString.f()[(b3 >> 4) & 15], okio.internal.ByteString.f()[b3 & Ascii.SI]});
    }

    public static final String l(int i3) {
        if (i3 == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        int i4 = 0;
        char[] cArr = {okio.internal.ByteString.f()[(i3 >> 28) & 15], okio.internal.ByteString.f()[(i3 >> 24) & 15], okio.internal.ByteString.f()[(i3 >> 20) & 15], okio.internal.ByteString.f()[(i3 >> 16) & 15], okio.internal.ByteString.f()[(i3 >> 12) & 15], okio.internal.ByteString.f()[(i3 >> 8) & 15], okio.internal.ByteString.f()[(i3 >> 4) & 15], okio.internal.ByteString.f()[i3 & 15]};
        while (i4 < 8 && cArr[i4] == '0') {
            i4++;
        }
        return StringsKt.z(cArr, i4, 8);
    }
}
