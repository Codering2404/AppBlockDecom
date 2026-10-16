package com.superwall.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.config.WebToAppConfig;
import java.util.Map;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OpenWebRestoreKt {
    public static final void openRestoreOnWeb(Superwall superwall) {
        WebToAppConfig webToAppConfig;
        Activity currentActivity;
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Superwall.Companion companion = Superwall.Companion;
        Config config = companion.getInstance().getDependencyContainer$superwall_release().getConfigManager().getConfig();
        if (config == null || (webToAppConfig = config.getWebToAppConfig()) == null) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.webEntitlements, "Configuration not available - cannot restore purchases", (Map) null, (Throwable) null, 24, (Object) null);
            return;
        }
        ActivityProvider activityProvider = companion.getInstance().getDependencyContainer$superwall_release().getActivityProvider();
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            return;
        }
        currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webToAppConfig.getRestoreAccesUrl())));
    }
}
