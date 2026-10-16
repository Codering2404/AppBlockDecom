package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesConfiguration;
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
public final class SdkConfigurationStateKt {
    private static final String SDK_CONFIG_EXTRA = "sdk_config_args";

    private static final SdkConfigurationState getSdkConfigurationState(Bundle bundle) {
        return Build.VERSION.SDK_INT >= 33 ? (SdkConfigurationState) bundle.getParcelable(SDK_CONFIG_EXTRA, SdkConfigurationState.class) : (SdkConfigurationState) bundle.getParcelable(SDK_CONFIG_EXTRA);
    }

    public static final void restoreSdkConfigurationIfNeeded(Context context, Bundle bundle) {
        SdkConfigurationState sdkConfigurationState;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle == null || (sdkConfigurationState = getSdkConfigurationState(bundle)) == null) {
            return;
        }
        PurchasesConfiguration configuration = sdkConfigurationState.toConfiguration(context);
        Purchases.Companion companion = Purchases.Companion;
        if (!companion.isConfigured()) {
            companion.configure(configuration);
        } else if (Intrinsics.areEqual(companion.getSharedInstance().getCurrentConfiguration(), configuration)) {
            Logger.INSTANCE.i("Skipping Purchases reconfiguration, configuration is unchanged.");
        } else {
            Logger.INSTANCE.i("Purchases already configured with different parameters; not reconfiguring.");
        }
    }

    public static final void saveSdkConfiguration(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Purchases.Companion companion = Purchases.Companion;
        if (companion.isConfigured()) {
            outState.putParcelable(SDK_CONFIG_EXTRA, SdkConfigurationState.Companion.from(companion.getSharedInstance().getCurrentConfiguration()));
        }
    }
}
