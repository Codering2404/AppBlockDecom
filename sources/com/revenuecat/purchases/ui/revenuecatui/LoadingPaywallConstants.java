package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
final class LoadingPaywallConstants {
    public static final float placeholderAlpha = 0.5f;
    public static final LoadingPaywallConstants INSTANCE = new LoadingPaywallConstants();
    private static final long placeholderColor = Color.r(Color.f25715b.e(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
    private static final PaywallTemplate template = PaywallTemplate.TEMPLATE_2;
    public static final String offeringIdentifier = "loading_offering";
    private static final List<Package> packages = CollectionsKt.listOf((Object[]) new Package[]{new Package("weekly", PackageType.WEEKLY, new TestStoreProduct("com.revenuecat.weekly", "Weekly", "Weekly (App name)", "Weekly", new Price("$1.99", 1990000, "USD"), new Period(1, Period.Unit.WEEK, "P1W"), null, null, 192, null), offeringIdentifier), new Package("monthly", PackageType.MONTHLY, new TestStoreProduct("com.revenuecat.monthly", "Monthly", "Monthly (App name)", "Monthly", new Price("$5.99", 5990000, "USD"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, 192, null), offeringIdentifier), new Package("annual", PackageType.ANNUAL, new TestStoreProduct("com.revenuecat.annual", "Annual", "Annual (App name)", "Annual", new Price("$15.99", 5990000, "USD"), new Period(1, Period.Unit.YEAR, "P1Y"), null, null, 192, null), offeringIdentifier)});

    private LoadingPaywallConstants() {
    }

    public final List<Package> getPackages() {
        return packages;
    }

    /* JADX INFO: renamed from: getPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m681getPlaceholderColor0d7_KjU() {
        return placeholderColor;
    }

    public final PaywallTemplate getTemplate() {
        return template;
    }
}
