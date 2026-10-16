package dev.doubledot.doki.api.extensions;

import android.os.Build;
import kotlin.Metadata;

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
public final class AndroidKt {
    public static final String getAndroidVersion() {
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        if (StringKt.hasContent(str)) {
            return str;
        }
        String str2 = Build.VERSION.CODENAME;
        return str2 != null ? str2 : "";
    }

    public static final String getAndroidVersionName() {
        return Build.VERSION.SDK_INT != 28 ? "" : "Pie";
    }

    public static final String getFullAndroidVersion() {
        return "Android " + getAndroidVersion() + ' ' + getAndroidVersionName();
    }
}
