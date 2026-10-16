package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PremiumFeature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumFeature[] $VALUES;
    public static final PremiumFeature ACADEMY;
    public static final PremiumFeature ADD_NEWLY_INSTALLED_APPS;
    public static final PremiumFeature ADULT_CONTENT_BLOCKING;
    public static final PremiumFeature ALLOWLIST;
    public static final PremiumFeature ALL_FEATURES;
    public static final PremiumFeature BACKUP;
    public static final PremiumFeature BLOCK_UNSUPPORTED_BROWSERS;
    public static final PremiumFeature CUSTOM_BLOCK_SCREEN;
    public static final PremiumFeature DUPLICATE_SCHEDULES;
    public static final PremiumFeature EXTRA_OPTIONS;
    public static final PremiumFeature IMPORT_CSV;
    public static final PremiumFeature INTERVALS_UNLIMITED;
    public static final PremiumFeature IN_APP_PURCHASES_BLOCKING;
    public static final PremiumFeature LAUNCH_COUNT_UNLIMITED;
    public static final PremiumFeature NOTIFICATIONS_UNLIMITED;
    public static final PremiumFeature PAUSE_SCHEDULES;
    public static final PremiumFeature PROFILES_APPS_UNLIMITED;
    public static final PremiumFeature PROFILES_UNLIMITED;
    public static final PremiumFeature PROFILES_WEBS_UNLIMITED;
    public static final PremiumFeature PROFILE_LOCK_TIME_UNLIMITED;
    public static final PremiumFeature QUICK_BLOCK_APPS_UNLIMITED;
    public static final PremiumFeature QUICK_BLOCK_TILE;
    public static final PremiumFeature QUICK_BLOCK_TIMER = new PremiumFeature("QUICK_BLOCK_TIMER", 0, R.drawable.q6, Integer.valueOf(R.drawable.r6), R.string.rr, R.string.qr, null, false, "quick_block", null, false, 432, null);
    public static final PremiumFeature QUICK_BLOCK_WEBS_UNLIMITED;
    public static final PremiumFeature REMOVE_ADS;
    public static final PremiumFeature SCHEDULES_WIDGET;
    public static final PremiumFeature STATISTICS;
    public static final PremiumFeature STATISTICS_IGNORE_UNLIMITED;
    public static final PremiumFeature STATISTICS_LAUNCH_COUNT;
    public static final PremiumFeature STATISTICS_SCREEN_UNLOCKS;
    public static final PremiumFeature STRICT_MODE_APPROVAL;
    public static final PremiumFeature STRICT_MODE_EXTEND_TIMER;
    public static final PremiumFeature STRICT_MODE_PROFILES;
    public static final PremiumFeature STRICT_MODE_TIMER;
    public static final PremiumFeature SUB_APPS;
    public static final PremiumFeature UNLIMITED_SCHEDULE_DAYS;
    public static final PremiumFeature USAGE_LIMIT_UNLIMITED;
    private final boolean addEnjoyPremiumSuffixToDescription;
    private final List<Integer> descriptionPlaceholdersResIds;
    private final int descriptionResId;
    private final String eventKey;
    private final boolean hasQuantityString;
    private final int iconResId;
    private final Limit limit;
    private final Integer smallIconResId;
    private final int titleResId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97019a;

        static {
            int[] iArr = new int[PremiumFeature.values().length];
            try {
                iArr[PremiumFeature.UNLIMITED_SCHEDULE_DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumFeature.INTERVALS_UNLIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PremiumFeature.USAGE_LIMIT_UNLIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PremiumFeature.LAUNCH_COUNT_UNLIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f97019a = iArr;
        }
    }

    private static final /* synthetic */ PremiumFeature[] $values() {
        return new PremiumFeature[]{QUICK_BLOCK_TIMER, QUICK_BLOCK_APPS_UNLIMITED, QUICK_BLOCK_WEBS_UNLIMITED, PROFILES_APPS_UNLIMITED, PROFILES_WEBS_UNLIMITED, STRICT_MODE_PROFILES, STRICT_MODE_APPROVAL, STRICT_MODE_TIMER, STRICT_MODE_EXTEND_TIMER, PROFILES_UNLIMITED, INTERVALS_UNLIMITED, STATISTICS_IGNORE_UNLIMITED, LAUNCH_COUNT_UNLIMITED, USAGE_LIMIT_UNLIMITED, PROFILE_LOCK_TIME_UNLIMITED, NOTIFICATIONS_UNLIMITED, ADD_NEWLY_INSTALLED_APPS, REMOVE_ADS, STATISTICS, ACADEMY, ALL_FEATURES, QUICK_BLOCK_TILE, STATISTICS_LAUNCH_COUNT, STATISTICS_SCREEN_UNLOCKS, BACKUP, PAUSE_SCHEDULES, ALLOWLIST, EXTRA_OPTIONS, BLOCK_UNSUPPORTED_BROWSERS, ADULT_CONTENT_BLOCKING, IN_APP_PURCHASES_BLOCKING, SCHEDULES_WIDGET, UNLIMITED_SCHEDULE_DAYS, DUPLICATE_SCHEDULES, SUB_APPS, IMPORT_CSV, CUSTOM_BLOCK_SCREEN};
    }

    private PremiumFeature(String str, int i3, int i4, Integer num, int i5, int i6, List list, boolean z2, String str2, Limit limit, boolean z3) {
        this.iconResId = i4;
        this.smallIconResId = num;
        this.titleResId = i5;
        this.descriptionResId = i6;
        this.descriptionPlaceholdersResIds = list;
        this.addEnjoyPremiumSuffixToDescription = z2;
        this.eventKey = str2;
        this.limit = limit;
        this.hasQuantityString = z3;
    }

    public static EnumEntries<PremiumFeature> getEntries() {
        return $ENTRIES;
    }

    public static PremiumFeature valueOf(String str) {
        return (PremiumFeature) Enum.valueOf(PremiumFeature.class, str);
    }

    public static PremiumFeature[] values() {
        return (PremiumFeature[]) $VALUES.clone();
    }

    public final boolean getAddEnjoyPremiumSuffixToDescription() {
        return this.addEnjoyPremiumSuffixToDescription;
    }

    public final CharSequence getDescription(Context context) {
        String quantityString;
        Intrinsics.checkNotNullParameter(context, "context");
        List<Integer> list = this.descriptionPlaceholdersResIds;
        if (list != null) {
            int i3 = this.descriptionResId;
            List<Integer> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(context.getString(((Number) it.next()).intValue()));
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            quantityString = context.getString(i3, Arrays.copyOf(strArr, strArr.length));
        } else {
            Limit limit = this.limit;
            quantityString = limit != null ? this.hasQuantityString ? context.getResources().getQuantityString(this.descriptionResId, this.limit.getLimitValue(), Integer.valueOf(this.limit.getLimitValue())) : context.getString(this.descriptionResId, Integer.valueOf(limit.getLimitValue())) : context.getString(this.descriptionResId);
        }
        Intrinsics.checkNotNull(quantityString);
        return StringHelperExtKt.z(this.addEnjoyPremiumSuffixToDescription ? StringHelper.h(context.getString(R.string.Xi, quantityString, context.getString(R.string.f95790f1))) : StringHelper.h(quantityString));
    }

    public final List<Integer> getDescriptionPlaceholdersResIds() {
        return this.descriptionPlaceholdersResIds;
    }

    public final int getDescriptionResId() {
        return this.descriptionResId;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final boolean getHasCustomIcon() {
        return this.iconResId != PremiumFeatureKt.f97020a;
    }

    public final boolean getHasQuantityString() {
        return this.hasQuantityString;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final Limit getLimit() {
        return this.limit;
    }

    public final String getShortTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = WhenMappings.f97019a[ordinal()];
        if (i3 == 1) {
            return context.getString(R.string.tk);
        }
        if (i3 == 2) {
            return context.getString(R.string.pk);
        }
        if (i3 == 3) {
            int i4 = R.string.EF;
            Limit limit = this.limit;
            return context.getString(i4, limit != null ? Integer.valueOf(limit.getLimitValue()) : null);
        }
        if (i3 != 4) {
            return null;
        }
        int i5 = R.string.zi;
        Limit limit2 = this.limit;
        return context.getString(i5, limit2 != null ? Integer.valueOf(limit2.getLimitValue()) : null);
    }

    public final Integer getSmallIconResId() {
        return this.smallIconResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Product product = Product.APPLICATIONS;
        int buyTitleResId = product.getBuyTitleResId();
        int buyDescriptionResId = product.getBuyDescriptionResId();
        Limit limit = Limit.APP_WEB_LIMIT_QUICK_BLOCK;
        QUICK_BLOCK_APPS_UNLIMITED = new PremiumFeature("QUICK_BLOCK_APPS_UNLIMITED", 1, 0, null, buyTitleResId, buyDescriptionResId, null, true, "quick_block_unlimited_apps", limit, true, 19, null);
        Product product2 = Product.WEBSITES;
        QUICK_BLOCK_WEBS_UNLIMITED = new PremiumFeature("QUICK_BLOCK_WEBS_UNLIMITED", 2, 0, null, product2.getBuyTitleResId(), product2.getBuyDescriptionResId(), null, true, "quick_block_unlimited_webs", limit, true, 19, null);
        PROFILES_APPS_UNLIMITED = new PremiumFeature("PROFILES_APPS_UNLIMITED", 3, 0, null, product.getBuyTitleResId(), product.getBuyDescriptionResId(), null, true, "unlimited_apps", Limit.APP_LIMIT, true, 19, null);
        PROFILES_WEBS_UNLIMITED = new PremiumFeature("PROFILES_WEBS_UNLIMITED", 4, 0, null, product2.getBuyTitleResId(), product2.getBuyDescriptionResId(), null, true, "unlimited_webs", Limit.WEBSITE_LIMIT, true, 19, null);
        int i3 = R.string.Oq;
        STRICT_MODE_PROFILES = new PremiumFeature("STRICT_MODE_PROFILES", 5, 0, null, i3, R.string.UB, null, true, "strict_mode_profiles", null, false, RCHTTPStatusCodes.FORBIDDEN, null);
        int i4 = 0;
        STRICT_MODE_APPROVAL = new PremiumFeature("STRICT_MODE_APPROVAL", 6, i4, null, i3, R.string.Nx, null, true, "strict_mode_approval", null, false, RCHTTPStatusCodes.FORBIDDEN, null);
        Product product3 = Product.STRICT_MODE;
        STRICT_MODE_TIMER = new PremiumFeature("STRICT_MODE_TIMER", 7, 0, null, product3.getBuyTitleResId(), product3.getBuyDescriptionResId(), null, true, "strict_mode_timer", Limit.STRICT_MODE_LIMIT, false, 275, null);
        STRICT_MODE_EXTEND_TIMER = new PremiumFeature("STRICT_MODE_EXTEND_TIMER", 8, i4, null, R.string.KB, i3, null, true, "strict_mode_extend_timer", null, false, RCHTTPStatusCodes.FORBIDDEN, null);
        Product product4 = Product.PROFILE;
        PROFILES_UNLIMITED = new PremiumFeature("PROFILES_UNLIMITED", 9, 0, null, product4.getBuyTitleResId(), product4.getBuyDescriptionResId(), null, true, "profiles_unlimited", Limit.PROFILE_LIMIT, false, 275, null);
        Product product5 = Product.TIMES;
        DefaultConstructorMarker defaultConstructorMarker = null;
        INTERVALS_UNLIMITED = new PremiumFeature("INTERVALS_UNLIMITED", 10, 0, null, product5.getBuyTitleResId(), product5.getBuyDescriptionResId(), null, true, "intervals_unlimited", Limit.TIMES_LIMIT, false, 275, defaultConstructorMarker);
        STATISTICS_IGNORE_UNLIMITED = new PremiumFeature("STATISTICS_IGNORE_UNLIMITED", 11, 0, null, R.string.jg, R.string.ig, null, true, "statistics_ignore_unlimited", Limit.STATISTICS_LIMIT, false, 275, null);
        Product product6 = Product.LAUNCH_COUNT;
        LAUNCH_COUNT_UNLIMITED = new PremiumFeature("LAUNCH_COUNT_UNLIMITED", 12, 0, null, product6.getBuyTitleResId(), product6.getBuyDescriptionResId(), null, true, "launch_count_unlimited", Limit.LAUNCH_COUNT, false, 275, null);
        Product product7 = Product.USAGE_LIMIT;
        USAGE_LIMIT_UNLIMITED = new PremiumFeature("USAGE_LIMIT_UNLIMITED", 13, 0, null, product7.getBuyTitleResId(), product7.getBuyDescriptionResId(), null, true, "usage_limit_unlimited", Limit.USAGE_LIMIT, false, 275, null);
        Product product8 = Product.LOCK_TIME;
        PROFILE_LOCK_TIME_UNLIMITED = new PremiumFeature("PROFILE_LOCK_TIME_UNLIMITED", 14, 0, null, product8.getBuyTitleResId(), product8.getBuyDescriptionResId(), null, true, "profile_lock_time_unlimited", Limit.LOCK_TIME_LIMIT, false, 275, null);
        NOTIFICATIONS_UNLIMITED = new PremiumFeature("NOTIFICATIONS_UNLIMITED", 15, 0, null, R.string.cF, R.string.dF, null, true, "notifications_unlimited", Limit.NOTIFICATION_LIMIT, false, 275, null);
        ADD_NEWLY_INSTALLED_APPS = new PremiumFeature("ADD_NEWLY_INSTALLED_APPS", 16, R.drawable.C2, null, R.string.Q, R.string.r3, null, false, "ania", null, false, 434, 0 == true ? 1 : 0);
        int i5 = R.drawable.R3;
        Integer numValueOf = Integer.valueOf(R.drawable.A4);
        int i6 = R.string.rs;
        int i7 = R.string.fp;
        int i8 = R.string.f95790f1;
        REMOVE_ADS = new PremiumFeature("REMOVE_ADS", 17, i5, numValueOf, i6, i7, CollectionsKt.listOf(Integer.valueOf(i8)), false, "remove_ads", null, false, 416, null);
        STATISTICS = new PremiumFeature("STATISTICS", 18, R.drawable.D4, Integer.valueOf(R.drawable.C4), R.string.ch, R.string.dh, null, false, "statistics", null, false, 432, null);
        ACADEMY = new PremiumFeature("ACADEMY", 19, 0, Integer.valueOf(R.drawable.z4), R.string.wD, R.string.f95784e, null, false, "academy", null, false, 433, 0 == true ? 1 : 0);
        ALL_FEATURES = new PremiumFeature("ALL_FEATURES", 20, 0, Integer.valueOf(R.drawable.B4), R.string.gp, R.string.ep, null, false, "all_features", null, false, 433, null);
        QUICK_BLOCK_TILE = new PremiumFeature("QUICK_BLOCK_TILE", 21, R.drawable.p5, null, R.string.Yq, R.string.lr, null, false, "quick_block_tile", null, false, 434, null);
        STATISTICS_LAUNCH_COUNT = new PremiumFeature("STATISTICS_LAUNCH_COUNT", 22, R.drawable.S2, null, R.string.Bi, R.string.Ai, CollectionsKt.listOf(Integer.valueOf(i8)), false, "statistics_launch_count", null, false, 418, null);
        STATISTICS_SCREEN_UNLOCKS = new PremiumFeature("STATISTICS_SCREEN_UNLOCKS", 23, R.drawable.I6, null, R.string.pF, R.string.mF, CollectionsKt.listOf(Integer.valueOf(i8)), false, "statistics_screen_unlocks", null, false, 418, null);
        BACKUP = new PremiumFeature("BACKUP", 24, R.drawable.N0, null, R.string.yD, R.string.R2, CollectionsKt.listOf(Integer.valueOf(R.string.X2)), false, sECyKyO.huSUkrrrEBT, null, false, 418, null);
        PAUSE_SCHEDULES = new PremiumFeature("PAUSE_SCHEDULES", 25, R.drawable.c4, null, R.string.bj, R.string.aj, CollectionsKt.listOf(Integer.valueOf(i8)), false, "pause_schedules", null, false, 418, defaultConstructorMarker);
        ALLOWLIST = new PremiumFeature("ALLOWLIST", 26, R.drawable.f95570v0, null, R.string.A0, R.string.D0, null, false, "allowlist", null, false, 434, null);
        EXTRA_OPTIONS = new PremiumFeature("EXTRA_OPTIONS", 27, 0, null, R.string.ge, R.string.Zi, null, false, "extra_options", null, false, 435, null);
        BLOCK_UNSUPPORTED_BROWSERS = new PremiumFeature("BLOCK_UNSUPPORTED_BROWSERS", 28, R.drawable.f95499c1, null, R.string.U3, R.string.T3, null, false, "unsupported_browsers", null, false, 434, null);
        ADULT_CONTENT_BLOCKING = new PremiumFeature("ADULT_CONTENT_BLOCKING", 29, R.drawable.f95564t0, null, R.string.wo, R.string.vo, null, false, "adult_content_blocking", null, false, 434, null);
        IN_APP_PURCHASES_BLOCKING = new PremiumFeature("IN_APP_PURCHASES_BLOCKING", 30, R.drawable.K2, null, R.string.Rq, R.string.Qq, null, false, "in_app_purchases_blocking", null, false, 434, null);
        SCHEDULES_WIDGET = new PremiumFeature("SCHEDULES_WIDGET", 31, 0, null, R.string.wv, R.string.xv, null, false, "schedules_widget", null, false, 435, 0 == true ? 1 : 0);
        UNLIMITED_SCHEDULE_DAYS = new PremiumFeature("UNLIMITED_SCHEDULE_DAYS", 32, 0, null, R.string.zv, R.string.Av, null, false, "days_limit", Limit.TIME_SCHEDULE_DAY_LIMIT, false, 307, null);
        DUPLICATE_SCHEDULES = new PremiumFeature("DUPLICATE_SCHEDULES", 33, 0, null, R.string.Fc, R.string.Gc, null, false, "duplicate_schedule", Limit.DUPLICATE_SCHEDULES, false, 307, null);
        SUB_APPS = new PremiumFeature("SUB_APPS", 34, 0, null, R.string.ZB, R.string.YB, null, false, "sub_apps", null, false, 435, null);
        IMPORT_CSV = new PremiumFeature("IMPORT_CSV", 35, 0, null, R.string.mg, R.string.lg, null, false, "import_csv", null, false, 435, null);
        CUSTOM_BLOCK_SCREEN = new PremiumFeature("CUSTOM_BLOCK_SCREEN", 36, 0, null, R.string.I3, R.string.H3, null, false, "custom_block_screen", null, false, 435, null);
        PremiumFeature[] premiumFeatureArr$values = $values();
        $VALUES = premiumFeatureArr$values;
        $ENTRIES = EnumEntriesKt.a(premiumFeatureArr$values);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    /* synthetic */ PremiumFeature(java.lang.String r15, int r16, int r17, java.lang.Integer r18, int r19, int r20, java.util.List r21, boolean r22, java.lang.String r23, cz.mobilesoft.coreblock.enums.Limit r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto Lc
            int r1 = cz.mobilesoft.coreblock.enums.PremiumFeatureKt.a()
            r5 = r1
            goto Le
        Lc:
            r5 = r17
        Le:
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L15
            r6 = r2
            goto L17
        L15:
            r6 = r18
        L17:
            r1 = r0 & 16
            if (r1 == 0) goto L1d
            r9 = r2
            goto L1f
        L1d:
            r9 = r21
        L1f:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L26
            r10 = r3
            goto L28
        L26:
            r10 = r22
        L28:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L2e
            r12 = r2
            goto L30
        L2e:
            r12 = r24
        L30:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L40
            r13 = r3
            r2 = r14
            r4 = r16
            r7 = r19
            r8 = r20
            r11 = r23
            r3 = r15
            goto L4c
        L40:
            r13 = r25
            r2 = r14
            r3 = r15
            r4 = r16
            r7 = r19
            r8 = r20
            r11 = r23
        L4c:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.enums.PremiumFeature.<init>(java.lang.String, int, int, java.lang.Integer, int, int, java.util.List, boolean, java.lang.String, cz.mobilesoft.coreblock.enums.Limit, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
