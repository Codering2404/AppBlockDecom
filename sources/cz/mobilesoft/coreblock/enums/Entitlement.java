package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
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
public final class Entitlement {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Entitlement[] $VALUES;
    public static final Companion Companion;
    private final String id;
    public static final Entitlement Premium = new Entitlement("Premium", 0, "Premium");
    public static final Entitlement FreeMonthPremium = new Entitlement("FreeMonthPremium", 1, "FreeMonthPremium");
    public static final Entitlement OldAds = new Entitlement("OldAds", 2, "Old Ads");
    public static final Entitlement OldApplications = new Entitlement("OldApplications", 3, "Old Applications");
    public static final Entitlement OldLaunchCount = new Entitlement("OldLaunchCount", 4, "Old Launch Count");
    public static final Entitlement OldLockTime = new Entitlement("OldLockTime", 5, "Old Lock Time");
    public static final Entitlement OldNotifications = new Entitlement("OldNotifications", 6, "Old Notifications");
    public static final Entitlement OldOnetime = new Entitlement("OldOnetime", 7, "Old Onetime");
    public static final Entitlement OldSchedules = new Entitlement("OldSchedules", 8, "Old Schedules");
    public static final Entitlement OldStatistics = new Entitlement("OldStatistics", 9, "Old Statistics");
    public static final Entitlement OldStrictMode = new Entitlement("OldStrictMode", 10, "Old Strict Mode");
    public static final Entitlement OldTimes = new Entitlement("OldTimes", 11, "Old Times");
    public static final Entitlement OldUsageLimit = new Entitlement("OldUsageLimit", 12, "Old Usage Limit");
    public static final Entitlement OldWebsites = new Entitlement("OldWebsites", 13, "Old Websites");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Context context, String entitlement) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entitlement, "entitlement");
            if (Intrinsics.areEqual(entitlement, Entitlement.OldAds.getId())) {
                String string = context.getString(R.string.rs);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (Intrinsics.areEqual(entitlement, Entitlement.OldApplications.getId())) {
                String string2 = context.getString(R.string.aF);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (Intrinsics.areEqual(entitlement, Entitlement.OldLaunchCount.getId())) {
                String string3 = context.getString(R.string.bF);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            }
            if (Intrinsics.areEqual(entitlement, Entitlement.OldLockTime.getId())) {
                String string4 = context.getString(R.string.ac);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            }
            if (Intrinsics.areEqual(entitlement, Entitlement.OldNotifications.getId())) {
                String string5 = context.getString(R.string.cF);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            }
            if (!Intrinsics.areEqual(entitlement, Entitlement.OldOnetime.getId())) {
                if (Intrinsics.areEqual(entitlement, Entitlement.OldSchedules.getId())) {
                    String string6 = context.getString(R.string.gq);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                }
                if (Intrinsics.areEqual(entitlement, Entitlement.OldStatistics.getId())) {
                    String string7 = context.getString(R.string.eF);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                }
                if (Intrinsics.areEqual(entitlement, Entitlement.OldStrictMode.getId())) {
                    String string8 = context.getString(R.string.fF);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return string8;
                }
                if (Intrinsics.areEqual(entitlement, Entitlement.OldTimes.getId())) {
                    String string9 = context.getString(R.string.gF);
                    Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                    return string9;
                }
                if (Intrinsics.areEqual(entitlement, Entitlement.OldUsageLimit.getId())) {
                    String string10 = context.getString(R.string.hF);
                    Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                    return string10;
                }
                if (Intrinsics.areEqual(entitlement, Entitlement.OldWebsites.getId())) {
                    String string11 = context.getString(R.string.iF);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return string11;
                }
            }
            return entitlement;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Entitlement[] $values() {
        return new Entitlement[]{Premium, FreeMonthPremium, OldAds, OldApplications, OldLaunchCount, OldLockTime, OldNotifications, OldOnetime, OldSchedules, OldStatistics, OldStrictMode, OldTimes, OldUsageLimit, OldWebsites};
    }

    static {
        Entitlement[] entitlementArr$values = $values();
        $VALUES = entitlementArr$values;
        $ENTRIES = EnumEntriesKt.a(entitlementArr$values);
        Companion = new Companion(null);
    }

    private Entitlement(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<Entitlement> getEntries() {
        return $ENTRIES;
    }

    public static Entitlement valueOf(String str) {
        return (Entitlement) Enum.valueOf(Entitlement.class, str);
    }

    public static Entitlement[] values() {
        return (Entitlement[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
