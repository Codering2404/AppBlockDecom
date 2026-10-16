package com.revenuecat.purchases.ui.revenuecatui.helpers;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallLegacyComponentInteraction {
    public static final int $stable = 0;
    public static final String ALL_PLANS_BUTTON_NAME = "all_plans_button";
    public static final PaywallLegacyComponentInteraction INSTANCE = new PaywallLegacyComponentInteraction();
    public static final String PRIVACY_LINK_NAME = "privacy_link";
    public static final String PURCHASE_BUTTON_NAME = "purchase_button";
    public static final String RESTORE_BUTTON_NAME = "restore_button";
    public static final String TERMS_LINK_NAME = "terms_link";
    public static final String TIER_SELECTOR_NAME = "tier_selector";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Value {
        public static final int $stable = 0;
        public static final Value INSTANCE = new Value();
        public static final String IN_APP_CHECKOUT = "in_app_checkout";
        public static final String NAVIGATE_TO_PRIVACY_POLICY = "navigate_to_privacy_policy";
        public static final String NAVIGATE_TO_TERMS = "navigate_to_terms";
        public static final String RESTORE_PURCHASES = "restore_purchases";
        public static final String TOGGLE_ALL_PLANS = "toggle_all_plans";

        private Value() {
        }
    }

    private PaywallLegacyComponentInteraction() {
    }
}
