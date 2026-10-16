package kotlinx.serialization.json.internal;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class StringOpsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f143168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f143169b;

    static {
        String[] strArr = new String[93];
        for (int i3 = 0; i3 < 32; i3++) {
            strArr[i3] = "\\u" + e(i3 >> 12) + e(i3 >> 8) + e(i3 >> 4) + e(i3);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f143168a = strArr;
        byte[] bArr = new byte[93];
        for (int i4 = 0; i4 < 32; i4++) {
            bArr[i4] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f143169b = bArr;
    }

    public static final byte[] a() {
        return f143169b;
    }

    public static final String[] b() {
        return f143168a;
    }

    public static final void c(StringBuilder sb, String value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append('\"');
        int length = value.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = value.charAt(i4);
            String[] strArr = f143168a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i3, i4);
                sb.append(strArr[cCharAt]);
                i3 = i4 + 1;
            }
        }
        if (i3 != 0) {
            sb.append((CharSequence) value, i3, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.F(str, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.F(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i3) {
        int i4 = i3 & 15;
        return (char) (i4 < 10 ? i4 + 48 : i4 + 87);
    }
}
