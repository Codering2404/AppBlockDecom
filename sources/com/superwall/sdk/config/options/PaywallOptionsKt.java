package com.superwall.sdk.config.options;

import com.superwall.sdk.analytics.Tier;
import com.superwall.sdk.config.options.PaywallOptions;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
public final class PaywallOptionsKt {
    public static final boolean computedShouldPreload(SuperwallOptions superwallOptions, Tier tier) {
        Intrinsics.checkNotNullParameter(superwallOptions, "<this>");
        Intrinsics.checkNotNullParameter(tier, "tier");
        Boolean bool = superwallOptions.getPaywalls().getPreloadDeviceOverrides().get(tier);
        return bool != null ? bool.booleanValue() : superwallOptions.getPaywalls().getShouldPreload();
    }

    public static final Map<String, Object> toMap(PaywallOptions paywallOptions) {
        Intrinsics.checkNotNullParameter(paywallOptions, "<this>");
        Pair pairA = TuplesKt.a("is_haptic_feedback_enabled", Boolean.valueOf(paywallOptions.isHapticFeedbackEnabled()));
        Pair pairA2 = TuplesKt.a("restore_failed", MapsKt.mapOf(TuplesKt.a("title", paywallOptions.getRestoreFailed().getTitle()), TuplesKt.a("message", paywallOptions.getRestoreFailed().getMessage()), TuplesKt.a("close_button_title", paywallOptions.getRestoreFailed().getCloseButtonTitle())));
        Pair pairA3 = TuplesKt.a("should_show_purchase_failure_alert", Boolean.valueOf(paywallOptions.getShouldShowPurchaseFailureAlert()));
        Pair pairA4 = TuplesKt.a("should_preload", Boolean.valueOf(paywallOptions.getShouldPreload()));
        Map<Tier, Boolean> preloadDeviceOverrides = paywallOptions.getPreloadDeviceOverrides();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(preloadDeviceOverrides.size()));
        Iterator<T> it = preloadDeviceOverrides.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((Tier) entry.getKey()).getRaw(), entry.getValue());
        }
        Pair pairA5 = TuplesKt.a("preload_device_overrides", linkedHashMap);
        Pair pairA6 = TuplesKt.a("use_cached_templates", Boolean.valueOf(paywallOptions.getUseCachedTemplates()));
        Pair pairA7 = TuplesKt.a("automatically_dismiss", Boolean.valueOf(paywallOptions.getAutomaticallyDismiss()));
        PaywallOptions.TransactionBackgroundView transactionBackgroundView = paywallOptions.getTransactionBackgroundView();
        return MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, TuplesKt.a("transaction_background_view", transactionBackgroundView != null ? transactionBackgroundView.name() : null));
    }
}
