package androidx.navigation;

import android.net.Uri;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavUriUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NavUriUtils f48980a = new NavUriUtils();

    private NavUriUtils() {
    }

    public static /* synthetic */ String c(NavUriUtils navUriUtils, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return navUriUtils.b(str, str2);
    }

    public final String a(String s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        String strDecode = Uri.decode(s2);
        Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
        return strDecode;
    }

    public final String b(String s2, String str) {
        Intrinsics.checkNotNullParameter(s2, "s");
        String strEncode = Uri.encode(s2, str);
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
        return strEncode;
    }

    public final Uri d(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        Uri uri = Uri.parse(uriString);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }
}
