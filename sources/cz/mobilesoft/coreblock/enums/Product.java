package cz.mobilesoft.coreblock.enums;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class Product {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Product[] $VALUES;
    public static final Product ADS;

    @Deprecated
    public static final Product ANIA;
    public static final Product APPLICATIONS;
    public static final Companion Companion;
    public static final Product LAUNCH_COUNT;
    public static final Product LIFETIME;
    public static final Product LIFETIME_PROMO;
    public static final Product LOCK_TIME;
    public static final Product NOTIFICATIONS;
    public static final Product PREMIUM;
    public static final Product PREMIUM_DISCOUNT;
    public static final Product PROFILE;
    public static final Product STATISTICS;
    public static final Product STRICT_MODE;

    @Deprecated
    public static final Product SUB_MONTH;
    public static final Product SUB_MONTH_V5;

    @Deprecated
    public static final Product SUB_YEAR;

    @Deprecated
    public static final Product SUB_YEAR_DISC_1;

    @Deprecated
    public static final Product SUB_YEAR_DISC_2;

    @Deprecated
    public static final Product SUB_YEAR_DISC_3;

    @Deprecated
    public static final Product SUB_YEAR_DISC_4;

    @Deprecated
    public static final Product SUB_YEAR_DISC_4_2022;

    @Deprecated
    public static final Product SUB_YEAR_DISC_CAMPAIGN_1_2022;

    @Deprecated
    public static final Product SUB_YEAR_DISC_EX_SUB;

    @Deprecated
    public static final Product SUB_YEAR_DISC_ONETIME;

    @Deprecated
    public static final Product SUB_YEAR_PRCOM_PROMO_CODE;
    public static final Product SUB_YEAR_V5;
    public static final Product TIMES;
    public static final Product UNKNOWN;
    public static final Product USAGE_LIMIT;
    public static final Product WEBSITES;
    private static final Lazy<Map<String, Product>> byIdsMap$delegate;
    private static final Lazy<Set<Product>> featureProducts$delegate;
    private static final Lazy<Map<String, Product>> inAppsByIds$delegate;
    private static final Lazy<Map<String, Product>> lifetimeByIds$delegate;
    private static final Lazy<Map<String, Product>> subscriptionsByIds$delegate;
    private static final boolean useAcademyProductIds = true;
    private final String academyId;
    private final int buyDescriptionResId;
    private final int buyTitleResId;
    private final String defaultTrialPeriod;
    private final Entitlement entitlement;
    private final String id;
    private final int limit;
    private final int orderInList;
    private final String productId;
    private final List<SubscriptionOfferId> subscriptionOfferIds;
    private final SubscriptionPeriod subscriptionPeriod;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Product a(String productId) {
            Intrinsics.checkNotNullParameter(productId, "productId");
            Product product = (Product) b().get(productId);
            if (product != null) {
                return product;
            }
            if (StringsKt.a0(productId, "prcom", false, 2, null) || StringsKt.a0(productId, "affil", false, 2, null)) {
                return Product.SUB_YEAR_PRCOM_PROMO_CODE;
            }
            return null;
        }

        public final Map b() {
            return (Map) Product.byIdsMap$delegate.getValue();
        }

        public final Set c() {
            return (Set) Product.featureProducts$delegate.getValue();
        }

        public final Map d() {
            return (Map) Product.lifetimeByIds$delegate.getValue();
        }

        public final Set e() {
            return d().keySet();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionPeriod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SubscriptionPeriod[] $VALUES;
        private final int calendarPeriod;
        private final String isoCode;
        private final int periodLength;
        public static final SubscriptionPeriod NONE = new SubscriptionPeriod("NONE", 0, null, 0, 0, 7, null);
        public static final SubscriptionPeriod WEEK = new SubscriptionPeriod("WEEK", 1, "P1W", 5, 7);
        public static final SubscriptionPeriod MONTH = new SubscriptionPeriod("MONTH", 2, "P1M", 2, 1);
        public static final SubscriptionPeriod MONTHS_3 = new SubscriptionPeriod("MONTHS_3", 3, "P3M", 2, 3);
        public static final SubscriptionPeriod MONTHS_6 = new SubscriptionPeriod("MONTHS_6", 4, pMpIcGE.JEf, 2, 6);
        public static final SubscriptionPeriod YEAR = new SubscriptionPeriod("YEAR", 5, "P1Y", 1, 1);
        public static final SubscriptionPeriod LIFETIME = new SubscriptionPeriod("LIFETIME", 6, null, 0, 0, 7, null);

        private static final /* synthetic */ SubscriptionPeriod[] $values() {
            return new SubscriptionPeriod[]{NONE, WEEK, MONTH, MONTHS_3, MONTHS_6, YEAR, LIFETIME};
        }

        private SubscriptionPeriod(String str, int i3, String str2, int i4, int i5) {
            this.isoCode = str2;
            this.calendarPeriod = i4;
            this.periodLength = i5;
        }

        public static EnumEntries<SubscriptionPeriod> getEntries() {
            return $ENTRIES;
        }

        public static SubscriptionPeriod valueOf(String str) {
            return (SubscriptionPeriod) Enum.valueOf(SubscriptionPeriod.class, str);
        }

        public static SubscriptionPeriod[] values() {
            return (SubscriptionPeriod[]) $VALUES.clone();
        }

        public final int getCalendarPeriod() {
            return this.calendarPeriod;
        }

        public final String getIsoCode() {
            return this.isoCode;
        }

        public final int getPeriodLength() {
            return this.periodLength;
        }

        static {
            SubscriptionPeriod[] subscriptionPeriodArr$values = $values();
            $VALUES = subscriptionPeriodArr$values;
            $ENTRIES = EnumEntriesKt.a(subscriptionPeriodArr$values);
        }

        /* synthetic */ SubscriptionPeriod(String str, int i3, String str2, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i6 & 1) != 0 ? "" : str2, (i6 & 2) != 0 ? -1 : i4, (i6 & 4) != 0 ? -1 : i5);
        }
    }

    private static final /* synthetic */ Product[] $values() {
        return new Product[]{SUB_MONTH, SUB_YEAR, SUB_YEAR_DISC_1, SUB_YEAR_DISC_2, SUB_YEAR_DISC_3, SUB_YEAR_DISC_4, SUB_YEAR_DISC_4_2022, SUB_YEAR_PRCOM_PROMO_CODE, SUB_YEAR_DISC_ONETIME, SUB_YEAR_DISC_CAMPAIGN_1_2022, SUB_YEAR_DISC_EX_SUB, SUB_YEAR_V5, SUB_MONTH_V5, LIFETIME_PROMO, LIFETIME, PREMIUM, PREMIUM_DISCOUNT, PROFILE, APPLICATIONS, WEBSITES, ADS, LOCK_TIME, STRICT_MODE, USAGE_LIMIT, TIMES, NOTIFICATIONS, LAUNCH_COUNT, STATISTICS, ANIA, UNKNOWN};
    }

    private Product(String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, SubscriptionPeriod subscriptionPeriod, String str4, List list, Entitlement entitlement) {
        this.id = str2;
        this.academyId = str3;
        this.orderInList = i4;
        this.buyTitleResId = i5;
        this.buyDescriptionResId = i6;
        this.limit = i7;
        this.subscriptionPeriod = subscriptionPeriod;
        this.defaultTrialPeriod = str4;
        this.subscriptionOfferIds = list;
        this.entitlement = entitlement;
        this.productId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map byIdsMap_delegate$lambda$0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        EnumEntries<Product> entries = getEntries();
        ArrayList arrayList = new ArrayList();
        for (Product product : entries) {
            if (!StringsKt.p0(product.getProductId())) {
                arrayList.add(product);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            linkedHashMap.put(((Product) obj).id, obj);
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            if (!StringsKt.p0(((Product) obj2).academyId)) {
                arrayList2.add(obj2);
            }
        }
        int size3 = arrayList2.size();
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            linkedHashMap.put(((Product) obj3).academyId, obj3);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set featureProducts_delegate$lambda$0() {
        return SetsKt.setOf((Object[]) new Product[]{PROFILE, APPLICATIONS, WEBSITES, ADS, LOCK_TIME, STRICT_MODE, USAGE_LIMIT, TIMES, NOTIFICATIONS, LAUNCH_COUNT, STATISTICS});
    }

    public static EnumEntries<Product> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map inAppsByIds_delegate$lambda$0() {
        Map mapB = Companion.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapB.entrySet()) {
            if (!((Product) entry.getValue()).isSubscription()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map lifetimeByIds_delegate$lambda$0() {
        Map mapB = Companion.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapB.entrySet()) {
            if (((Product) entry.getValue()).isLifetime()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map subscriptionsByIds_delegate$lambda$0() {
        Map mapB = Companion.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapB.entrySet()) {
            if (((Product) entry.getValue()).isSubscription()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static Product valueOf(String str) {
        return (Product) Enum.valueOf(Product.class, str);
    }

    public static Product[] values() {
        return (Product[]) $VALUES.clone();
    }

    public final int getBuyDescriptionResId() {
        return this.buyDescriptionResId;
    }

    public final int getBuyTitleResId() {
        return this.buyTitleResId;
    }

    public final String getDefaultTrialPeriod() {
        return this.defaultTrialPeriod;
    }

    public final Entitlement getEntitlement() {
        return this.entitlement;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getOrderInList() {
        return this.orderInList;
    }

    public final String getProductId() {
        return this.academyId;
    }

    public final List<SubscriptionOfferId> getSubscriptionOfferIds() {
        return this.subscriptionOfferIds;
    }

    public final SubscriptionPeriod getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public final boolean isLifetime() {
        return this.subscriptionPeriod == SubscriptionPeriod.LIFETIME;
    }

    public final boolean isSubscription() {
        SubscriptionPeriod subscriptionPeriod = this.subscriptionPeriod;
        return (subscriptionPeriod == SubscriptionPeriod.NONE || subscriptionPeriod == SubscriptionPeriod.LIFETIME) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        SubscriptionPeriod subscriptionPeriod = SubscriptionPeriod.MONTH;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        SUB_MONTH = new Product("SUB_MONTH", 0, "cz.mobilesoft.appblock.subscription.month", "2021.cz.mobilesoft.appblock.subscription.month", 0, i3, i4, i5, subscriptionPeriod, null, null, null, 952, null);
        SubscriptionPeriod subscriptionPeriod2 = SubscriptionPeriod.YEAR;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        SUB_YEAR = new Product("SUB_YEAR", 1, "cz.mobilesoft.appblock.subscription.year", "2021.cz.mobilesoft.appblock.subscription.year", 0, i6, i7, i8, subscriptionPeriod2, "P1W", null, null, 824, null);
        int i9 = 952;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i10 = 0;
        Entitlement entitlement = null;
        SUB_YEAR_DISC_1 = new Product("SUB_YEAR_DISC_1", 2, "cz.mobilesoft.appblock.subscription.year.disc1", "2021.cz.mobilesoft.appblock.subscription.year.disc1", i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i9, defaultConstructorMarker);
        SUB_YEAR_DISC_2 = new Product("SUB_YEAR_DISC_2", 3, "cz.mobilesoft.appblock.subscription.year.disc2", "2021.cz.mobilesoft.appblock.subscription.year.disc2", i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i9, defaultConstructorMarker);
        SUB_YEAR_DISC_3 = new Product("SUB_YEAR_DISC_3", 4, "cz.mobilesoft.appblock.subscription.year.disc3", "2021.cz.mobilesoft.appblock.subscription.year.disc3", i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i9, defaultConstructorMarker);
        SUB_YEAR_DISC_4 = new Product("SUB_YEAR_DISC_4", 5, "cz.mobilesoft.appblock.subscription.year.disc4", "2021.cz.mobilesoft.appblock.subscription.year.disc4", i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i9, defaultConstructorMarker);
        int i11 = 954;
        SUB_YEAR_DISC_4_2022 = new Product("SUB_YEAR_DISC_4_2022", 6, "2022.cz.mobilesoft.appblock.subscription.year.disc4", null, i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i11, defaultConstructorMarker);
        SUB_YEAR_PRCOM_PROMO_CODE = new Product("SUB_YEAR_PRCOM_PROMO_CODE", 7, "prcom", 0 == true ? 1 : 0, i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i11, defaultConstructorMarker);
        SUB_YEAR_DISC_ONETIME = new Product("SUB_YEAR_DISC_ONETIME", 8, "2021.cz.mobilesoft.appblock.subscription.year.disc.onetime", 0 == true ? 1 : 0, i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i11, defaultConstructorMarker);
        SUB_YEAR_DISC_CAMPAIGN_1_2022 = new Product("SUB_YEAR_DISC_CAMPAIGN_1_2022", 9, "2022.cz.mobilesoft.appblock.subscription.year.campaign1", 0 == true ? 1 : 0, i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i11, defaultConstructorMarker);
        SUB_YEAR_DISC_EX_SUB = new Product("SUB_YEAR_DISC_EX_SUB", 10, "premium.appblock.yearly.exsub", 0 == true ? 1 : 0, i6, i7, i8, i10, subscriptionPeriod2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement, i11, defaultConstructorMarker);
        String isoCode = SubscriptionPeriod.WEEK.getIsoCode();
        SubscriptionOfferId subscriptionOfferId = SubscriptionOfferId.ID_BASE;
        Object[] objArr = 0 == true ? 1 : 0;
        SUB_YEAR_V5 = new Product("SUB_YEAR_V5", 11, "premium.appblock.yearly", objArr, i6, i7, i8, i10, subscriptionPeriod2, isoCode, CollectionsKt.listOf((Object[]) new SubscriptionOfferId[]{subscriptionOfferId, SubscriptionOfferId.ID_TRIAL, SubscriptionOfferId.ID_TRIAL_MANUAL, SubscriptionOfferId.ID_20_LIMIT, SubscriptionOfferId.ID_50_LIMIT, SubscriptionOfferId.ID_50_BLOCK, SubscriptionOfferId.ID_50_CAMPAIGN, SubscriptionOfferId.ID_50_EXSUB, SubscriptionOfferId.ID_50_ONETIME, SubscriptionOfferId.ID_30_PROMO, SubscriptionOfferId.ID_50_PROMO, SubscriptionOfferId.ID_30_REFERRAL}), null, 570, null);
        int i12 = 0;
        SUB_MONTH_V5 = new Product("SUB_MONTH_V5", 12, "premium.appblock.monthly", null, i3, i4, i5, i12, subscriptionPeriod, null, CollectionsKt.listOf(subscriptionOfferId), null, 698, 0 == true ? 1 : 0);
        SubscriptionPeriod subscriptionPeriod3 = SubscriptionPeriod.LIFETIME;
        int i13 = 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        LIFETIME_PROMO = new Product("LIFETIME_PROMO", 13, "cz.mobilesoft.appblock.lifetime.promo", null, i4, i5, i12, i13, subscriptionPeriod3, null, objArr2, null, 954, null);
        int i14 = 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        Object[] objArr4 = 0 == true ? 1 : 0;
        LIFETIME = new Product("LIFETIME", 14, "premium.appblock.lifetime", null, i5, i12, i13, i14, subscriptionPeriod3, objArr3, objArr4, null, 954, null);
        Entitlement entitlement2 = Entitlement.OldOnetime;
        int i15 = 0;
        PREMIUM = new Product("PREMIUM", 15, "cz.mobilesoft.appblock.premium", null, i12, i13, i14, i15, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, entitlement2, 506, null);
        Object[] objArr5 = 0 == true ? 1 : 0;
        Object[] objArr6 = 0 == true ? 1 : 0;
        PREMIUM_DISCOUNT = new Product("PREMIUM_DISCOUNT", 16, "cz.mobilesoft.appblock.premiumdiscount", null, i13, i14, i15, 0, objArr5, objArr6, null, entitlement2, 506, null);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str = null;
        SubscriptionPeriod subscriptionPeriod4 = null;
        String str2 = null;
        List list = null;
        PROFILE = new Product("PROFILE", 17, "cz.mobilesoft.appblock.profiles", str, 8, R.string.lu, R.string.wu, Limit.PROFILE_LIMIT.getLimitValue(), subscriptionPeriod4, str2, list, Entitlement.OldSchedules, 450, defaultConstructorMarker2);
        Object[] objArr7 = 0 == true ? 1 : 0;
        Object[] objArr8 = 0 == true ? 1 : 0;
        APPLICATIONS = new Product("APPLICATIONS", 18, "cz.mobilesoft.appblock.applications", null, 1, R.string.Sb, R.plurals.f95746g, Limit.APP_LIMIT.getLimitValue(), objArr8, null, null, Entitlement.OldApplications, 450, objArr7);
        Object[] objArr9 = 0 == true ? 1 : 0;
        Object[] objArr10 = 0 == true ? 1 : 0;
        Object[] objArr11 = 0 == true ? 1 : 0;
        WEBSITES = new Product("WEBSITES", 19, "cz.mobilesoft.appblock.websites", null, 9, R.string.gc, R.plurals.f95757r, Limit.WEBSITE_LIMIT.getLimitValue(), objArr10, objArr11, null, Entitlement.OldWebsites, 450, objArr9);
        ADS = new Product("ADS", 20, "cz.mobilesoft.appblock.noadds", str, 7, 0, 0, 0, subscriptionPeriod4, str2, list, Entitlement.OldAds, 506, defaultConstructorMarker2);
        LOCK_TIME = new Product("LOCK_TIME", 21, QgXempTBEfV.yPQuCgWBVTQpAB, null, 2, R.string.ac, R.string.Zb, Limit.LOCK_TIME_LIMIT.getLimitValue(), null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, Entitlement.OldLockTime, 450, null);
        Object[] objArr12 = 0 == true ? 1 : 0;
        Object[] objArr13 = 0 == true ? 1 : 0;
        Object[] objArr14 = 0 == true ? 1 : 0;
        STRICT_MODE = new Product("STRICT_MODE", 22, "cz.mobilesoft.appblock.strictmode", null, 4, R.string.cc, R.string.bc, Limit.STRICT_MODE_LIMIT.getLimitValue(), objArr13, objArr14, null, Entitlement.OldStrictMode, 450, objArr12);
        int i16 = 450;
        USAGE_LIMIT = new Product("USAGE_LIMIT", 23, "cz.mobilesoft.appblock.usagelimit", str, 5, R.string.fc, R.string.ec, Limit.USAGE_LIMIT.getLimitValue(), subscriptionPeriod4, str2, list, Entitlement.OldUsageLimit, i16, defaultConstructorMarker2);
        TIMES = new Product("TIMES", 24, "cz.mobilesoft.appblock.times", null, 6, R.string.pk, R.string.Jh, Limit.TIMES_LIMIT.getLimitValue(), null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, Entitlement.OldTimes, 450, null);
        int i17 = 0;
        Object[] objArr15 = 0 == true ? 1 : 0;
        Object[] objArr16 = 0 == true ? 1 : 0;
        Object[] objArr17 = 0 == true ? 1 : 0;
        NOTIFICATIONS = new Product("NOTIFICATIONS", 25, "cz.mobilesoft.appblock.notifications", null, 10, i17, 0, Limit.NOTIFICATION_LIMIT.getLimitValue(), objArr16, objArr17, null, Entitlement.OldNotifications, 474, objArr15);
        LAUNCH_COUNT = new Product("LAUNCH_COUNT", 26, "cz.mobilesoft.appblock.launchcount", str, 11, R.string.Vb, R.string.Ub, Limit.LAUNCH_COUNT.getLimitValue(), subscriptionPeriod4, str2, list, Entitlement.OldLaunchCount, i16, defaultConstructorMarker2);
        STATISTICS = new Product("STATISTICS", 27, "cz.mobilesoft.appblock.statistics", null, 3, 0, i17, Limit.STATISTICS_LIMIT.getLimitValue(), null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, Entitlement.OldStatistics, 474, null);
        int i18 = 0;
        Object[] objArr18 = 0 == true ? 1 : 0;
        Object[] objArr19 = 0 == true ? 1 : 0;
        Object[] objArr20 = 0 == true ? 1 : 0;
        ANIA = new Product("ANIA", 28, "cz.mobilesoft.appblock.ania", objArr20, 12, R.string.Q, R.string.tp, i18, objArr19, objArr18, null, entitlement2, 482, null);
        Object[] objArr21 = 0 == true ? 1 : 0;
        Object[] objArr22 = 0 == true ? 1 : 0;
        Object[] objArr23 = 0 == true ? 1 : 0;
        UNKNOWN = new Product("UNKNOWN", 29, objArr22, null, 0, 0, i18, 0, objArr21, objArr23, null, null, 1023, null);
        Product[] productArr$values = $values();
        $VALUES = productArr$values;
        $ENTRIES = EnumEntriesKt.a(productArr$values);
        Companion = new Companion(null);
        byIdsMap$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Product.byIdsMap_delegate$lambda$0();
            }
        });
        subscriptionsByIds$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Product.subscriptionsByIds_delegate$lambda$0();
            }
        });
        lifetimeByIds$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Product.lifetimeByIds_delegate$lambda$0();
            }
        });
        inAppsByIds$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Product.inAppsByIds_delegate$lambda$0();
            }
        });
        featureProducts$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Product.featureProducts_delegate$lambda$0();
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* synthetic */ Product(String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, SubscriptionPeriod subscriptionPeriod, String str4, List list, Entitlement entitlement, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        String str5 = (i8 & 1) != 0 ? "" : str2;
        this(str, i3, str5, (i8 & 2) != 0 ? str5 : str3, (i8 & 4) != 0 ? 99 : i4, (i8 & 8) != 0 ? -1 : i5, (i8 & 16) != 0 ? -1 : i6, (i8 & 32) != 0 ? -1 : i7, (i8 & 64) != 0 ? SubscriptionPeriod.NONE : subscriptionPeriod, (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str4, (i8 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list, (i8 & 512) != 0 ? Entitlement.Premium : entitlement);
    }
}
