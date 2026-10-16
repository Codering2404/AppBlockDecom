package com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates;

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
public final class Template1TestDataKt {
    public static final PaywallData getTemplate1(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_1.getId();
        PackageType packageType = PackageType.MONTHLY;
        String identifier = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        List listListOf = CollectionsKt.listOf(identifier);
        String identifier2 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, new PaywallData.Configuration(listListOf, identifier2, constants.getImages(), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#000000"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#5CD27A"), new PaywallColor("#FFFFFF"), (PaywallColor) null, new PaywallColor("#BC66FF"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32588, (DefaultConstructorMarker) null), new PaywallData.Configuration.Colors(new PaywallColor("#000000"), new PaywallColor("#FFFFFF"), (PaywallColor) null, (PaywallColor) null, new PaywallColor("#ACD27A"), new PaywallColor("#000000"), (PaywallColor) null, new PaywallColor("#B022BB"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32588, (DefaultConstructorMarker) null)), (Map) null, (List) null, true, true, new URL("https://revenuecat.com/tos"), (URL) null, 1128, (DefaultConstructorMarker) null), constants.getAssetBaseURL(), 0, MapsKt.mapOf(TuplesKt.a("en_US", new PaywallData.LocalizedConfiguration("Ignite your _child_'s curiosity", "Get access to **all our educational content** trusted by thousands of parents.", "Subscribe for _only_ {{ sub_price_per_month }}", "Purchase for _only_ {{ sub_price_per_month }} per month", (String) null, "*Just* {{ sub_price_per_month }} per month", "Start your {{ sub_offer_duration }} trial, then {{ sub_price_per_month }} per month", (String) null, (String) null, (List) null, (String) null, (Map) null, 3984, (DefaultConstructorMarker) null))), (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
