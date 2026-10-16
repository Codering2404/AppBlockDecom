package dev.doubledot.doki.api.extensions;

import android.os.Build;
import kotlin.Metadata;
import kotlin.TypeCastException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ConstantsKt {
    public static final String DONT_KILL_MY_APP_BASE_ENDPOINT = "https://dontkillmyapp.com/api/v2/";
    public static final String DONT_KILL_MY_APP_BASE_URL = "https://dontkillmyapp.com";
    private static final String DONT_KILL_MY_APP_DEFAULT_MANUFACTURER;
    public static final String DONT_KILL_MY_APP_FALLBACK_MANUFACTURER = "general";

    static {
        String str = Build.MANUFACTURER;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        DONT_KILL_MY_APP_DEFAULT_MANUFACTURER = StringsKt.O(lowerCase, " ", "-", false, 4, null);
    }

    public static final String getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER() {
        return DONT_KILL_MY_APP_DEFAULT_MANUFACTURER;
    }
}
