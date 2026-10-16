package cz.mobilesoft.coreblock.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PackageManagerHelperKt {
    public static final Pair a(PackageManager packageManager, String packageName) throws Exception {
        Drawable applicationIcon;
        Intrinsics.checkNotNullParameter(packageManager, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            String string = packageManager.getApplicationLabel(applicationInfo).toString();
            applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            packageName = string;
        } catch (Exception e3) {
            if (!(e3 instanceof PackageManager.NameNotFoundException) && !(e3 instanceof NullPointerException)) {
                throw e3;
            }
            e3.printStackTrace();
            applicationIcon = null;
        }
        return TuplesKt.a(packageName, applicationIcon);
    }
}
