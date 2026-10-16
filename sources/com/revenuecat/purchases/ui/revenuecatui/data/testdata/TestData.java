package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import androidx.compose.ui.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template1TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template2TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template3TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template4TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template5TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template7CustomPackagesTestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.templates.Template7TestDataKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestData {
    public static final int $stable;
    public static final TestData INSTANCE;
    private static final String TEMPLATE_1_ID = "Template1";
    private static final String TEMPLATE_2_ID = "Template2";
    private static final String TEMPLATE_3_ID = "Template3";
    private static final String TEMPLATE_4_ID = "Template4";
    private static final String TEMPLATE_5_ID = "Template5";
    private static final String TEMPLATE_7_CUSTOM_PACKAGE_ID = "Template7CustomPackage";
    private static final String TEMPLATE_7_ID = "Template7";
    private static final Offering offeringWithNoPaywall;
    private static final Offering template1Offering;
    private static final Offering template1OfferingNoFooter;
    private static final Offering template2Offering;
    private static final Offering template3Offering;
    private static final Offering template4Offering;
    private static final Offering template5Offering;
    private static final Offering template7CustomPackageOffering;
    private static final Offering template7Offering;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Components {
        public static final int $stable = 0;
        public static final Components INSTANCE = new Components();
        private static final PackageComponent monthlyPackageComponent;

        static {
            String identifier = PackageType.MONTHLY.getIdentifier();
            Intrinsics.checkNotNull(identifier);
            monthlyPackageComponent = new PackageComponent(identifier, false, new StackComponent(CollectionsKt.emptyList(), (Boolean) null, (Dimension) null, (Size) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65534, (DefaultConstructorMarker) null), (PromoOfferConfig) null, (String) null, (Boolean) null, (List) null, 120, (DefaultConstructorMarker) null);
        }

        private Components() {
        }

        public final PackageComponent getMonthlyPackageComponent() {
            return monthlyPackageComponent;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Constants {
        public static final int $stable;
        private static final androidx.compose.material3.ColorScheme currentColorScheme;
        public static final Constants INSTANCE = new Constants();
        private static final PaywallData.Configuration.Images images = new PaywallData.Configuration.Images("9a17e0a7_1689854430..jpeg", "9a17e0a7_1689854342..jpg", "9a17e0a7_1689854430..jpeg");
        private static final URL assetBaseURL = new URL("https://assets.pawwalls.com");
        private static final List<String> zeroDecimalPlaceCountries = CollectionsKt.listOf((Object[]) new String[]{"PH", "KZ", "TW", "MX", "TH"});
        private static final PaywallData.LocalizedConfiguration localization = new PaywallData.LocalizedConfiguration("Call to action for _better_ conversion.", "Lorem ipsum is simply dummy text of the ~printing and~ typesetting industry.", "Subscribe for {{ sub_price_per_month }}/mo", (String) null, (String) null, "{{ total_price_and_per_month }}", "{{ total_price_and_per_month }} after {{ sub_offer_duration }} trial", (String) null, "{{ sub_period }}", CollectionsKt.emptyList(), (String) null, (Map) null, 3224, (DefaultConstructorMarker) null);

        static {
            Color.Companion companion = Color.f25715b;
            currentColorScheme = new androidx.compose.material3.ColorScheme(companion.l(), companion.l(), companion.l(), companion.l(), companion.f(), companion.a(), companion.a(), companion.a(), companion.a(), companion.c(), companion.a(), companion.e(), companion.l(), companion.l(), companion.a(), companion.e(), companion.a(), companion.d(), companion.l(), companion.g(), companion.a(), companion.l(), companion.i(), companion.l(), companion.i(), companion.l(), companion.j(), companion.g(), companion.e(), null);
            $stable = 8;
        }

        private Constants() {
        }

        public final URL getAssetBaseURL() {
            return assetBaseURL;
        }

        public final androidx.compose.material3.ColorScheme getCurrentColorScheme() {
            return currentColorScheme;
        }

        public final PaywallData.Configuration.Images getImages() {
            return images;
        }

        public final PaywallData.LocalizedConfiguration getLocalization() {
            return localization;
        }

        public final List<String> getZeroDecimalPlaceCountries() {
            return zeroDecimalPlaceCountries;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Packages {
        public static final int $stable;
        public static final Packages INSTANCE = new Packages();
        private static final Package annual;
        private static final Package annualEuros;
        private static final Package annualTaiwan;
        private static final Package bimonthly;
        private static final Package custom;
        private static final Package lifetime;
        private static final Package monthly;
        private static final Package monthlyMexico;
        private static final Package quarterly;
        private static final Package quarterlyThailand;
        private static final Package semester;
        private static final Package unknown;
        private static final Package weekly;

        static {
            PackageType packageType = PackageType.WEEKLY;
            String identifier = packageType.getIdentifier();
            Intrinsics.checkNotNull(identifier);
            Price price = new Price("$1.49", 1490000L, "USD");
            Period.Unit unit = Period.Unit.WEEK;
            weekly = new Package(identifier, packageType, new TestStoreProduct("com.revenuecat.weekly_product", "Weekly", "Weekly (App name)", "Weekly", price, new Period(1, unit, "P1W"), null, null, 192, null), "offering");
            PackageType packageType2 = PackageType.MONTHLY;
            String identifier2 = packageType2.getIdentifier();
            Intrinsics.checkNotNull(identifier2);
            Price price2 = new Price("$7.99", 7990000L, "USD");
            Period.Unit unit2 = Period.Unit.MONTH;
            monthly = new Package(identifier2, packageType2, new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", price2, new Period(1, unit2, "P1M"), null, null, 192, null), new PresentedOfferingContext("offering"), new URL("https://test-web-billing.revenuecat.com?rc_package=" + packageType2.getIdentifier()));
            PackageType packageType3 = PackageType.ANNUAL;
            String identifier3 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier3);
            Price price3 = new Price("$67.99", 67990000L, "USD");
            Period.Unit unit3 = Period.Unit.YEAR;
            annual = new Package(identifier3, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", price3, new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null), new PresentedOfferingContext("offering"), new URL("https://test-web-billing.revenuecat.com?rc_package=" + packageType3.getIdentifier()));
            String identifier4 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier4);
            annualEuros = new Package(identifier4, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("67,99 €", 67990000L, "EUR"), new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null), "offering");
            PackageType packageType4 = PackageType.LIFETIME;
            String identifier5 = packageType4.getIdentifier();
            Intrinsics.checkNotNull(identifier5);
            lifetime = new Package(identifier5, packageType4, new TestStoreProduct("com.revenuecat.lifetime_product", "Lifetime", "Lifetime (App name)", "Lifetime", new Price("$1,000", 1000000000L, "USD"), null, null, null, 192, null), "offering");
            PackageType packageType5 = PackageType.TWO_MONTH;
            String identifier6 = packageType5.getIdentifier();
            Intrinsics.checkNotNull(identifier6);
            bimonthly = new Package(identifier6, packageType5, new TestStoreProduct("com.revenuecat.bimonthly_product", "2 month", "2 month (App name)", "2 month", new Price("$15.99", 15990000L, "USD"), new Period(2, unit2, "P2M"), null, new Price("$3.99", 3990000L, "USD"), 64, null), "offering");
            PackageType packageType6 = PackageType.THREE_MONTH;
            String identifier7 = packageType6.getIdentifier();
            Intrinsics.checkNotNull(identifier7);
            quarterly = new Package(identifier7, packageType6, new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", new Price("$23.99", 23990000L, "USD"), new Period(3, unit2, "P3M"), new Period(2, unit, "P2W"), new Price("$3.99", 3990000L, "USD")), "offering");
            PackageType packageType7 = PackageType.SIX_MONTH;
            String identifier8 = packageType7.getIdentifier();
            Intrinsics.checkNotNull(identifier8);
            semester = new Package(identifier8, packageType7, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, 192, null), "offering");
            custom = new Package("Custom", PackageType.CUSTOM, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, 192, null), "offering");
            unknown = new Package(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, PackageType.UNKNOWN, new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$39.99", 39990000L, "USD"), new Period(6, unit2, "P6M"), null, null, 192, null), "offering");
            String identifier9 = packageType3.getIdentifier();
            Intrinsics.checkNotNull(identifier9);
            annualTaiwan = new Package(identifier9, packageType3, new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("NT$67.00", 67000000L, "TWD"), new Period(1, unit3, "P1Y"), new Period(1, unit2, "P1M"), null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null), "offering");
            String identifier10 = packageType2.getIdentifier();
            Intrinsics.checkNotNull(identifier10);
            monthlyMexico = new Package(identifier10, packageType2, new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", new Price("$8.00", 8000000L, "MXN"), new Period(1, unit2, "P1M"), null, null, 192, null), "offering");
            String identifier11 = packageType6.getIdentifier();
            Intrinsics.checkNotNull(identifier11);
            quarterlyThailand = new Package(identifier11, packageType6, new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", new Price("THB24.00", 24000000L, "THB"), new Period(3, unit2, "P3M"), null, new Price("THB4.00", 4000000L, "THB"), 64, null), "offering");
            $stable = 8;
        }

        private Packages() {
        }

        public final Package getAnnual() {
            return annual;
        }

        public final Package getAnnualEuros() {
            return annualEuros;
        }

        public final Package getAnnualTaiwan() {
            return annualTaiwan;
        }

        public final Package getBimonthly() {
            return bimonthly;
        }

        public final Package getCustom() {
            return custom;
        }

        public final Package getLifetime() {
            return lifetime;
        }

        public final Package getMonthly() {
            return monthly;
        }

        public final Package getMonthlyMexico() {
            return monthlyMexico;
        }

        public final Package getQuarterly() {
            return quarterly;
        }

        public final Package getQuarterlyThailand() {
            return quarterlyThailand;
        }

        public final Package getSemester() {
            return semester;
        }

        public final Package getUnknown() {
            return unknown;
        }

        public final Package getWeekly() {
            return weekly;
        }
    }

    static {
        TestData testData = new TestData();
        INSTANCE = testData;
        Packages packages = Packages.INSTANCE;
        offeringWithNoPaywall = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), null, null, null, 96, null);
        template1Offering = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), Template1TestDataKt.getTemplate1(testData), null, null, 96, null);
        template1OfferingNoFooter = new Offering(TEMPLATE_1_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_1_ID)), PaywallData.copy$default(Template1TestDataKt.getTemplate1(testData), null, PaywallData.Configuration.copy$default(Template1TestDataKt.getTemplate1(testData).getConfig(), null, null, null, null, null, false, false, null, null, null, null, null, null, 7743, null), null, 0, null, null, null, null, 253, null), null, null, 96, null);
        template2Offering = new Offering(TEMPLATE_2_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getWeekly(), TEMPLATE_2_ID), testData.copy(packages.getMonthly(), TEMPLATE_2_ID), testData.copy(packages.getAnnual(), TEMPLATE_2_ID), testData.copy(packages.getLifetime(), TEMPLATE_2_ID)}), Template2TestDataKt.getTemplate2(testData), null, null, 96, null);
        template3Offering = new Offering(TEMPLATE_3_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf(testData.copy(packages.getMonthly(), TEMPLATE_3_ID)), Template3TestDataKt.getTemplate3(testData), null, null, 96, null);
        template4Offering = new Offering(TEMPLATE_4_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_4_ID), testData.copy(packages.getSemester(), TEMPLATE_4_ID), testData.copy(packages.getAnnual(), TEMPLATE_4_ID), testData.copy(packages.getWeekly(), TEMPLATE_4_ID)}), Template4TestDataKt.getTemplate4(testData), null, null, 96, null);
        template5Offering = new Offering(TEMPLATE_5_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_5_ID), testData.copy(packages.getAnnual(), TEMPLATE_5_ID)}), Template5TestDataKt.getTemplate5(testData), null, null, 96, null);
        template7Offering = new Offering(TEMPLATE_7_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_7_ID), testData.copy(packages.getAnnual(), TEMPLATE_7_ID), testData.copy(packages.getBimonthly(), TEMPLATE_7_ID), testData.copy(packages.getQuarterly(), TEMPLATE_7_ID), testData.copy(packages.getSemester(), TEMPLATE_7_ID), testData.copy(packages.getLifetime(), TEMPLATE_7_ID)}), Template7TestDataKt.getTemplate7(testData), null, null, 96, null);
        template7CustomPackageOffering = new Offering(TEMPLATE_7_CUSTOM_PACKAGE_ID, "", MapsKt.emptyMap(), CollectionsKt.listOf((Object[]) new Package[]{testData.copy(packages.getMonthly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getAnnual(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getBimonthly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getQuarterly(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getSemester(), TEMPLATE_7_CUSTOM_PACKAGE_ID), testData.copy(packages.getLifetime(), TEMPLATE_7_CUSTOM_PACKAGE_ID)}), Template7CustomPackagesTestDataKt.getTemplate7CustomPackages(testData), null, null, 96, null);
        $stable = 8;
    }

    private TestData() {
    }

    public final Package copy(Package r8, String offeringId) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(offeringId);
        return new Package(r8.getIdentifier(), r8.getPackageType(), r8.getProduct().copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext, r8.getWebCheckoutURL());
    }

    public final Offering getOfferingWithNoPaywall() {
        return offeringWithNoPaywall;
    }

    public final Offering getTemplate1Offering() {
        return template1Offering;
    }

    public final Offering getTemplate1OfferingNoFooter() {
        return template1OfferingNoFooter;
    }

    public final Offering getTemplate2Offering() {
        return template2Offering;
    }

    public final Offering getTemplate3Offering() {
        return template3Offering;
    }

    public final Offering getTemplate4Offering() {
        return template4Offering;
    }

    public final Offering getTemplate5Offering() {
        return template5Offering;
    }

    public final Offering getTemplate7CustomPackageOffering() {
        return template7CustomPackageOffering;
    }

    public final Offering getTemplate7Offering() {
        return template7Offering;
    }
}
