package okio;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
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
public final class Base64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f144965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f144966b;

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f144965a = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").h();
        f144966b = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").h();
    }

    public static final byte[] a(String str) {
        int i3;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i4 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt2 = str.charAt(i8);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i3 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i3 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i3 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i3 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i3 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i6 = (i6 << 6) | i3;
            i5++;
            if (i5 % 4 == 0) {
                bArr[i7] = (byte) (i6 >> 16);
                int i9 = i7 + 2;
                bArr[i7 + 1] = (byte) (i6 >> 8);
                i7 += 3;
                bArr[i9] = (byte) i6;
            }
        }
        int i10 = i5 % 4;
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            bArr[i7] = (byte) ((i6 << 12) >> 16);
            i7++;
        } else if (i10 == 3) {
            int i11 = i6 << 6;
            int i12 = i7 + 1;
            bArr[i7] = (byte) (i11 >> 16);
            i7 += 2;
            bArr[i12] = (byte) (i11 >> 8);
        }
        if (i7 == i4) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String b(byte[] bArr, byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte b3 = bArr[i3];
            int i5 = i3 + 2;
            byte b4 = bArr[i3 + 1];
            i3 += 3;
            byte b5 = bArr[i5];
            bArr2[i4] = map[(b3 & 255) >> 2];
            bArr2[i4 + 1] = map[((b3 & 3) << 4) | ((b4 & 255) >> 4)];
            int i6 = i4 + 3;
            bArr2[i4 + 2] = map[((b4 & Ascii.SI) << 2) | ((b5 & 255) >> 6)];
            i4 += 4;
            bArr2[i6] = map[b5 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b6 = bArr[i3];
            bArr2[i4] = map[(b6 & 255) >> 2];
            bArr2[i4 + 1] = map[(b6 & 3) << 4];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
        } else if (length2 == 2) {
            int i7 = i3 + 1;
            byte b7 = bArr[i3];
            byte b8 = bArr[i7];
            bArr2[i4] = map[(b7 & 255) >> 2];
            bArr2[i4 + 1] = map[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr2[i4 + 2] = map[(b8 & Ascii.SI) << 2];
            bArr2[i4 + 3] = 61;
        }
        return _JvmPlatformKt.c(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr2 = f144965a;
        }
        return b(bArr, bArr2);
    }
}
