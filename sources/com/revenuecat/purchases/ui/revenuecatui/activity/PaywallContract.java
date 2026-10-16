package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
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
public final class PaywallContract extends ActivityResultContract<PaywallActivityArgs, PaywallResult> {
    public static final int $stable = 0;

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, PaywallActivityArgs args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, "args");
        Intent intent = new Intent(context, (Class<?>) PaywallActivity.class);
        intent.putExtra(PaywallActivity.ARGS_EXTRA, args);
        return intent;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public PaywallResult parseResult(int i3, Intent intent) {
        PaywallResult paywallResult;
        if (i3 != -1 || intent == null) {
            return PaywallResult.Cancelled.INSTANCE;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            paywallResult = (PaywallResult) intent.getParcelableExtra(PaywallActivity.RESULT_EXTRA, PaywallResult.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(PaywallActivity.RESULT_EXTRA);
            paywallResult = parcelableExtra instanceof PaywallResult ? (PaywallResult) parcelableExtra : null;
        }
        return paywallResult == null ? new PaywallResult.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "PaywallActivity returned null result")) : paywallResult;
    }
}
