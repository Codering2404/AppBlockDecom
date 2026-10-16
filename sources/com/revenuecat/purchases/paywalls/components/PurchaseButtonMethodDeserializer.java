package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PurchaseButtonMethodDeserializer extends SealedDeserializerWithDefault<PurchaseButtonComponent.Method> {
    public static final PurchaseButtonMethodDeserializer INSTANCE = new PurchaseButtonMethodDeserializer();

    private PurchaseButtonMethodDeserializer() {
        super("Method", MapsKt.mapOf(TuplesKt.a(PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT, new Function0<KSerializer<PurchaseButtonComponent.Method.InAppCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.InAppCheckout> invoke() {
                return PurchaseButtonComponent.Method.InAppCheckout.INSTANCE.serializer();
            }
        }), TuplesKt.a("web_checkout", new Function0<KSerializer<PurchaseButtonComponent.Method.WebCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.WebCheckout> invoke() {
                return PurchaseButtonComponent.Method.WebCheckout.Companion.serializer();
            }
        }), TuplesKt.a("web_product_selection", new Function0<KSerializer<PurchaseButtonComponent.Method.WebProductSelection>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.WebProductSelection> invoke() {
                return PurchaseButtonComponent.Method.WebProductSelection.Companion.serializer();
            }
        }), TuplesKt.a(YvFRmou.OJi, new Function0<KSerializer<PurchaseButtonComponent.Method.CustomWebCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.4
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.CustomWebCheckout> invoke() {
                return PurchaseButtonComponent.Method.CustomWebCheckout.Companion.serializer();
            }
        })), new Function1<String, PurchaseButtonComponent.Method>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.5
            @Override // kotlin.jvm.functions.Function1
            public final PurchaseButtonComponent.Method invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return PurchaseButtonComponent.Method.Unknown.INSTANCE;
            }
        }, null, 8, null);
    }
}
