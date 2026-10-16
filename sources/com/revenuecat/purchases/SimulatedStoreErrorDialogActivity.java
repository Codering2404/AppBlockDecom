package com.revenuecat.purchases;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.revenuecat.purchases.common.LogWrapperKt;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SimulatedStoreErrorDialogActivity extends Activity {
    public static final Companion Companion = new Companion(null);
    private static final String redactedApiKeyExtra = "redactedApiKey";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(Context context, String redactedApiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(redactedApiKey, "redactedApiKey");
            Intent intent = new Intent(context, (Class<?>) SimulatedStoreErrorDialogActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(SimulatedStoreErrorDialogActivity.redactedApiKeyExtra, redactedApiKey);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final boolean wasLaunchedThroughSDK() {
        return getIntent().hasExtra(redactedApiKeyExtra);
    }

    public final String getRedactedApiKey() {
        String stringExtra = getIntent().getStringExtra(redactedApiKeyExtra);
        return stringExtra == null ? "" : stringExtra;
    }

    @Override // android.app.Activity
    public void onBackPressed() throws PurchasesException {
        crashApp();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        new AlertDialog.Builder(this).setTitle("Wrong API Key").setMessage("This app is using a test API key: " + getRedactedApiKey() + ".\n\nTo prepare for release, update your RevenueCat settings to use a production key.\n\nFor more info, visit the RevenueCat dashboard.\n\nThe app will close now to protect the security of test purchases.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) throws PurchasesException {
                this.f92312a.crashApp();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onPause() throws PurchasesException {
        super.onPause();
        crashApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void crashApp() throws PurchasesException {
        if (!wasLaunchedThroughSDK()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "SimulatedStoreErrorDialogActivity was launched incorrectly. This activity is only meant to be launched internally by the SDK.", null);
            finish();
            return;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, null, 2, null), "Test Store API key used in release build: " + getRedactedApiKey() + MrGIhy.rapuoey);
    }
}
