package com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates;

import com.facebook.GraphRequest;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Template5TestDataKt {
    public static final PaywallData getTemplate5(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_5.getId();
        PackageType packageType = PackageType.ANNUAL;
        String identifier = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        String identifier2 = PackageType.MONTHLY.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2});
        String identifier3 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        PaywallData.Configuration configuration = new PaywallData.Configuration(listListOf, identifier3, new PaywallData.Configuration.Images("954459_1692992845.png", (String) null, (String) null, 6, (DefaultConstructorMarker) null), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), new PaywallColor("#adf5c5"), new PaywallColor("#b15d5d"), new PaywallColor("#45c186"), new PaywallColor("#ffffff"), (PaywallColor) null, new PaywallColor("#b24010"), new PaywallColor("#027424"), new PaywallColor("#D1D1D1"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 31808, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), (Map) null, (List) null, false, true, (URL) null, new URL("https://revenuecat.com/privacy"), 744, (DefaultConstructorMarker) null);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.a("en_US", new PaywallData.LocalizedConfiguration("Spice Up Your Kitchen - Go Pro for Exclusive Benefits!", (String) null, "Continue", "Start your Free Trial", (String) null, "{{ total_price_and_per_month }}", "Free for {{ sub_offer_duration }}, then {{ total_price_and_per_month }}", (String) null, "{{ sub_period }}", CollectionsKt.listOf((Object[]) new PaywallData.LocalizedConfiguration.Feature[]{new PaywallData.LocalizedConfiguration.Feature("Unique gourmet recipes", (String) null, "tick", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Advanced nutritional recipes", (String) null, "apple", 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Personalized support from our Chef", (String) null, GraphRequest.DEBUG_SEVERITY_WARNING, 2, (DefaultConstructorMarker) null), new PaywallData.LocalizedConfiguration.Feature("Unlimited receipt collections", (String) null, "bookmark", 2, (DefaultConstructorMarker) null)}), (String) null, (Map) null, 3218, (DefaultConstructorMarker) null)));
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, configuration, constants.getAssetBaseURL(), 0, mapMapOf, (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
