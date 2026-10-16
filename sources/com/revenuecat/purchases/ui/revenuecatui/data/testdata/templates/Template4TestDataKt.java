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
public final class Template4TestDataKt {
    public static final PaywallData getTemplate4(TestData testData) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        String id = PaywallTemplate.TEMPLATE_4.getId();
        String identifier = PackageType.MONTHLY.getIdentifier();
        Intrinsics.checkNotNull(identifier);
        PackageType packageType = PackageType.SIX_MONTH;
        String identifier2 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier2);
        String identifier3 = PackageType.ANNUAL.getIdentifier();
        Intrinsics.checkNotNull(identifier3);
        String identifier4 = PackageType.WEEKLY.getIdentifier();
        Intrinsics.checkNotNull(identifier4);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{identifier, identifier2, identifier3, identifier4});
        String identifier5 = packageType.getIdentifier();
        Intrinsics.checkNotNull(identifier5);
        PaywallData.Configuration configuration = new PaywallData.Configuration(listListOf, identifier5, new PaywallData.Configuration.Images((String) null, "300883_1690710097.jpg", (String) null, 5, (DefaultConstructorMarker) null), (Map) null, new PaywallData.Configuration.ColorInformation(new PaywallData.Configuration.Colors(new PaywallColor("#FFFFFF"), new PaywallColor("#111111"), new PaywallColor("#333333"), new PaywallColor("#999999"), new PaywallColor("#06357D"), new PaywallColor("#FFFFFF"), (PaywallColor) null, new PaywallColor("#D4B5FC"), new PaywallColor("#DFDFDF"), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32320, (DefaultConstructorMarker) null), (PaywallData.Configuration.Colors) null, 2, (DefaultConstructorMarker) null), (Map) null, (List) null, false, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), 232, (DefaultConstructorMarker) null);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.a("en_US", new PaywallData.LocalizedConfiguration("Get _unlimited_ access", (String) null, "Continue", (String) null, (String) null, "Cancel anytime", "Includes {{ sub_offer_duration }} **free** trial", (String) null, "{{ sub_duration_in_months }}", (List) null, (String) null, (Map) null, 3738, (DefaultConstructorMarker) null)));
        TestData.Constants constants = TestData.Constants.INSTANCE;
        return new PaywallData((String) null, id, configuration, constants.getAssetBaseURL(), 0, mapMapOf, (Map) null, constants.getZeroDecimalPlaceCountries(), (String) null, 337, (DefaultConstructorMarker) null);
    }
}
