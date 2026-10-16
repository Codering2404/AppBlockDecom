package okhttp3.internal.http2;

import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;

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
public final class Http2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Http2 f144616a = new Http2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f144617b = ByteString.f144997d.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f144618c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f144619d = new String[64];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f144620e;

    static {
        String[] strArr = new String[Function.MAX_NARGS];
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            String binaryString = Integer.toBinaryString(i4);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i4] = StringsKt.N(Util.t("%8s", binaryString), ' ', '0', false, 4, null);
        }
        f144620e = strArr;
        String[] strArr2 = f144619d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i5 = iArr[0];
        strArr2[i5 | 8] = Intrinsics.stringPlus(strArr2[i5], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i6 = 0;
        while (i6 < 3) {
            int i7 = iArr2[i6];
            i6++;
            int i8 = iArr[0];
            String[] strArr3 = f144619d;
            int i9 = i8 | i7;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) strArr3[i8]);
            sb.append('|');
            sb.append((Object) strArr3[i7]);
            strArr3[i9] = sb.toString();
            strArr3[i9 | 8] = ((Object) strArr3[i8]) + '|' + ((Object) strArr3[i7]) + "|PADDED";
        }
        int length = f144619d.length;
        while (i3 < length) {
            int i10 = i3 + 1;
            String[] strArr4 = f144619d;
            if (strArr4[i3] == null) {
                strArr4[i3] = f144620e[i3];
            }
            i3 = i10;
        }
    }

    private Http2() {
    }

    public final String a(int i3, int i4) {
        String str;
        if (i4 == 0) {
            return "";
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 == 4 || i3 == 6) {
                return i4 == 1 ? "ACK" : f144620e[i4];
            }
            if (i3 != 7 && i3 != 8) {
                String[] strArr = f144619d;
                if (i4 < strArr.length) {
                    str = strArr[i4];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = f144620e[i4];
                }
                String str2 = str;
                return (i3 != 5 || (i4 & 4) == 0) ? (i3 != 0 || (i4 & 32) == 0) ? str2 : StringsKt.O(str2, "PRIORITY", "COMPRESSED", false, 4, null) : StringsKt.O(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return f144620e[i4];
    }

    public final String b(int i3) {
        String[] strArr = f144618c;
        return i3 < strArr.length ? strArr[i3] : Util.t("0x%02x", Integer.valueOf(i3));
    }

    public final String c(boolean z2, int i3, int i4, int i5, int i6) {
        return Util.t("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i3), Integer.valueOf(i4), b(i5), a(i5, i6));
    }
}
