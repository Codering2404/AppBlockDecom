package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
public final class ConditionSerializer extends SealedDeserializerWithDefault<ComponentOverride.Condition> {
    public static final ConditionSerializer INSTANCE = new ConditionSerializer();

    private ConditionSerializer() {
        super("Condition", MapsKt.mapOf(TuplesKt.a("compact", new Function0<KSerializer<ComponentOverride.Condition.Compact>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.Compact> invoke() {
                return ComponentOverride.Condition.Compact.INSTANCE.serializer();
            }
        }), TuplesKt.a("medium", new Function0<KSerializer<ComponentOverride.Condition.Medium>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.Medium> invoke() {
                return ComponentOverride.Condition.Medium.INSTANCE.serializer();
            }
        }), TuplesKt.a("expanded", new Function0<KSerializer<ComponentOverride.Condition.Expanded>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.Expanded> invoke() {
                return ComponentOverride.Condition.Expanded.INSTANCE.serializer();
            }
        }), TuplesKt.a("intro_offer", new Function0<KSerializer<ComponentOverride.Condition.IntroOffer>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.4
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.IntroOffer> invoke() {
                return ComponentOverride.Condition.IntroOffer.INSTANCE.serializer();
            }
        }), TuplesKt.a("intro_offer_condition", new Function0<KSerializer<ComponentOverride.Condition.IntroOfferRule>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.5
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.IntroOfferRule> invoke() {
                return ComponentOverride.Condition.IntroOfferRule.Companion.serializer();
            }
        }), TuplesKt.a("multiple_intro_offers", new Function0<KSerializer<ComponentOverride.Condition.MultiplePhaseOffers>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.6
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.MultiplePhaseOffers> invoke() {
                return ComponentOverride.Condition.MultiplePhaseOffers.INSTANCE.serializer();
            }
        }), TuplesKt.a("selected", new Function0<KSerializer<ComponentOverride.Condition.Selected>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.7
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.Selected> invoke() {
                return ComponentOverride.Condition.Selected.INSTANCE.serializer();
            }
        }), TuplesKt.a("promo_offer", new Function0<KSerializer<ComponentOverride.Condition.PromoOffer>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.8
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.PromoOffer> invoke() {
                return ComponentOverride.Condition.PromoOffer.INSTANCE.serializer();
            }
        }), TuplesKt.a("promo_offer_condition", new Function0<KSerializer<ComponentOverride.Condition.PromoOfferRule>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.9
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.PromoOfferRule> invoke() {
                return ComponentOverride.Condition.PromoOfferRule.Companion.serializer();
            }
        }), TuplesKt.a("selected_package_condition", new Function0<KSerializer<ComponentOverride.Condition.SelectedPackage>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.10
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.SelectedPackage> invoke() {
                return ComponentOverride.Condition.SelectedPackage.Companion.serializer();
            }
        }), TuplesKt.a("variable_condition", new Function0<KSerializer<ComponentOverride.Condition.Variable>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.11
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<ComponentOverride.Condition.Variable> invoke() {
                return ComponentOverride.Condition.Variable.Companion.serializer();
            }
        })), new Function1<String, ComponentOverride.Condition>() { // from class: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer.12
            @Override // kotlin.jvm.functions.Function1
            public final ComponentOverride.Condition invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ComponentOverride.Condition.Unsupported.INSTANCE;
            }
        }, null, 8, null);
    }
}
