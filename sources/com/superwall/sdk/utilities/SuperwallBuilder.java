package com.superwall.sdk.utilities;

import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.misc.ActivityProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class SuperwallBuilder {
    private ActivityProvider activityProvider;
    private Function1<? super Result<Unit>, Unit> completion;
    private SuperwallOptions options;
    private PurchaseController purchaseController;

    public final ActivityProvider getActivityProvider() {
        return this.activityProvider;
    }

    public final Function1<Result<Unit>, Unit> getCompletion() {
        return this.completion;
    }

    public final SuperwallOptions getOptions() {
        return this.options;
    }

    public final PurchaseController getPurchaseController() {
        return this.purchaseController;
    }

    @SuperwallDSL
    public final void options(Function1<? super SuperwallOptions, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        SuperwallOptions superwallOptions = new SuperwallOptions();
        action.invoke(superwallOptions);
        this.options = superwallOptions;
    }

    public final void setActivityProvider(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    public final void setCompletion(Function1<? super Result<Unit>, Unit> function1) {
        this.completion = function1;
    }

    public final void setPurchaseController(PurchaseController purchaseController) {
        this.purchaseController = purchaseController;
    }
}
