package cz.mobilesoft.coreblock.activity.rating;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.Iterator;
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
public final class RatingTriggerSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RatingTriggerSource[] $VALUES;
    public static final Companion Companion;
    private final String analyticsValue;
    public static final RatingTriggerSource LockScreen = new RatingTriggerSource("LockScreen", 0, "lock_screen");
    public static final RatingTriggerSource WeeklyReport = new RatingTriggerSource(pMpIcGE.BFjtZUOFTHQ, 1, "weekly_report");
    public static final RatingTriggerSource TrialStarted = new RatingTriggerSource("TrialStarted", 2, "trial_started");
    public static final RatingTriggerSource Purchase = new RatingTriggerSource("Purchase", 3, "premium_purchase");
    public static final RatingTriggerSource SuperwallOnboarding = new RatingTriggerSource("SuperwallOnboarding", 4, "superwall_onboarding");
    public static final RatingTriggerSource SuperwallFinish = new RatingTriggerSource("SuperwallFinish", 5, "superwall_finish");
    public static final RatingTriggerSource DeveloperPreview = new RatingTriggerSource("DeveloperPreview", 6, "developer_preview");
    public static final RatingTriggerSource Unknown = new RatingTriggerSource(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 7, "unknown");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RatingTriggerSource a(String str) {
            RatingTriggerSource next;
            Iterator<RatingTriggerSource> it = RatingTriggerSource.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.name(), str)) {
                    break;
                }
            }
            RatingTriggerSource ratingTriggerSource = next;
            return ratingTriggerSource == null ? RatingTriggerSource.Unknown : ratingTriggerSource;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ RatingTriggerSource[] $values() {
        return new RatingTriggerSource[]{LockScreen, WeeklyReport, TrialStarted, Purchase, SuperwallOnboarding, SuperwallFinish, DeveloperPreview, Unknown};
    }

    private RatingTriggerSource(String str, int i3, String str2) {
        this.analyticsValue = str2;
    }

    public static EnumEntries<RatingTriggerSource> getEntries() {
        return $ENTRIES;
    }

    public static RatingTriggerSource valueOf(String str) {
        return (RatingTriggerSource) Enum.valueOf(RatingTriggerSource.class, str);
    }

    public static RatingTriggerSource[] values() {
        return (RatingTriggerSource[]) $VALUES.clone();
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }

    static {
        RatingTriggerSource[] ratingTriggerSourceArr$values = $values();
        $VALUES = ratingTriggerSourceArr$values;
        $ENTRIES = EnumEntriesKt.a(ratingTriggerSourceArr$values);
        Companion = new Companion(null);
    }
}
