package com.revenuecat.purchases.utils;

import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.sun.jna.Function;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

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
final class PreviewOfferingParser extends OfferingParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageType.values().length];
            try {
                iArr[PackageType.LIFETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageType.ANNUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageType.SIX_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PackageType.THREE_MONTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PackageType.TWO_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PackageType.MONTHLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PackageType.WEEKLY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.revenuecat.purchases.common.OfferingParser
    protected StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> productsById, JSONObject packageJson) throws JSONException {
        Intrinsics.checkNotNullParameter(productsById, "productsById");
        Intrinsics.checkNotNullParameter(packageJson, "packageJson");
        String string = packageJson.getString("identifier");
        for (PackageType packageType : PackageType.values()) {
            if (Intrinsics.areEqual(packageType.getIdentifier(), string)) {
                switch (WhenMappings.$EnumSwitchMapping$0[packageType.ordinal()]) {
                    case 1:
                        return new TestStoreProduct("com.revenuecat.lifetime_product", "Lifetime", "Lifetime (App name)", "Lifetime", new Price(wgbAZXYjrv.JWJQKEk, 1000000000L, "USD"), null, null, null, 192, null);
                    case 2:
                        return new TestStoreProduct("com.revenuecat.annual_product", "Annual", "Annual (App name)", "Annual", new Price("$ 67.99", 67990000L, "USD"), new Period(1, Period.Unit.YEAR, "P1Y"), new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0L, "USD")), null, null, 384, null);
                    case 3:
                        return new TestStoreProduct("com.revenuecat.semester_product", "6 month", "6 month (App name)", "6 month", new Price("$ 39.99", 39990000L, "USD"), new Period(6, Period.Unit.MONTH, "P6M"), null, null, 192, null);
                    case 4:
                        Price price = new Price("$ 23.99", 23990000L, "USD");
                        Period.Unit unit = Period.Unit.MONTH;
                        Period period = new Period(3, unit, "P3M");
                        Period period2 = new Period(2, Period.Unit.WEEK, "P2W");
                        RecurrenceMode recurrenceMode = RecurrenceMode.FINITE_RECURRING;
                        return new TestStoreProduct("com.revenuecat.quarterly_product", "3 month", "3 month (App name)", "3 month", price, period, new PricingPhase(period2, recurrenceMode, 1, new Price("Free", 0L, "USD")), new PricingPhase(new Period(1, unit, "P1M"), recurrenceMode, 1, new Price("$ 3.99", 3990000L, "USD")), null, Function.MAX_NARGS, null);
                    case 5:
                        Price price2 = new Price("$ 15.99", 15990000L, "USD");
                        Period.Unit unit2 = Period.Unit.MONTH;
                        return new TestStoreProduct("com.revenuecat.bimonthly_product", "2 month", "2 month (App name)", "2 month", price2, new Period(2, unit2, "P2M"), null, new PricingPhase(new Period(1, unit2, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, new Price("$ 3.99", 3990000L, "USD")), null, 320, null);
                    case 6:
                        return new TestStoreProduct("com.revenuecat.monthly_product", "Monthly", "Monthly (App name)", "Monthly", new Price("$ 7.99", 7990000L, "USD"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, 192, null);
                    case 7:
                        return new TestStoreProduct("com.revenuecat.weekly_product", "Weekly", "Weekly (App name)", "Weekly", new Price("$ 1.49", 1490000L, "USD"), new Period(1, Period.Unit.WEEK, "P1W"), null, null, 192, null);
                    default:
                        return null;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
