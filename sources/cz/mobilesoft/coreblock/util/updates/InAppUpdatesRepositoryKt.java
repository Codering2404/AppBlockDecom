package cz.mobilesoft.coreblock.util.updates;

import android.util.Log;
import com.google.android.play.core.appupdate.AppUpdateInfo;
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
public final class InAppUpdatesRepositoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppUpdateInfo appUpdateInfo, String str) {
        if (appUpdateInfo == null) {
            Log.d(str, "AppUpdateInfo is NULL");
            return;
        }
        Log.d(str, "versionCode=" + appUpdateInfo.a());
        Log.d(str, "stalenessDays=" + appUpdateInfo.b());
        Log.d(str, "updateAvailability=" + appUpdateInfo.f());
        Log.d(str, "isUpdateTypeAllowed(IMMEDIATE)=" + appUpdateInfo.d(1));
    }
}
