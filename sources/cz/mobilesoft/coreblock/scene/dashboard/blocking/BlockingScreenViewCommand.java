package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public abstract class BlockingScreenViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleTemplateClicked extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleTemplate f99523a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnScheduleTemplateClicked(ScheduleTemplate scheduleTemplate) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleTemplate, "scheduleTemplate");
            this.f99523a = scheduleTemplate;
        }

        public final ScheduleTemplate a() {
            return this.f99523a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleTemplateClicked) && this.f99523a == ((OnScheduleTemplateClicked) obj).f99523a;
        }

        public int hashCode() {
            return this.f99523a.hashCode();
        }

        public String toString() {
            return "OnScheduleTemplateClicked(scheduleTemplate=" + this.f99523a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenEmailConsentActivity extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f99524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenEmailConsentActivity(String emailConsentSource) {
            super(null);
            Intrinsics.checkNotNullParameter(emailConsentSource, "emailConsentSource");
            this.f99524a = emailConsentSource;
        }

        public final String a() {
            return this.f99524a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenEmailConsentActivity) && Intrinsics.areEqual(this.f99524a, ((OpenEmailConsentActivity) obj).f99524a);
        }

        public int hashCode() {
            return this.f99524a.hashCode();
        }

        public String toString() {
            return "OpenEmailConsentActivity(emailConsentSource=" + this.f99524a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPauseBlockingActivity extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f99525d = ProfileDisabledSuggestStrictModeState.$stable;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f99526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProfileDisabledSuggestStrictModeState f99527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PremiumState f99528c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPauseBlockingActivity(long j3, ProfileDisabledSuggestStrictModeState state, PremiumState premiumState) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f99526a = j3;
            this.f99527b = state;
            this.f99528c = premiumState;
        }

        public final PremiumState a() {
            return this.f99528c;
        }

        public final long b() {
            return this.f99526a;
        }

        public final ProfileDisabledSuggestStrictModeState c() {
            return this.f99527b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenPauseBlockingActivity)) {
                return false;
            }
            OpenPauseBlockingActivity openPauseBlockingActivity = (OpenPauseBlockingActivity) obj;
            return this.f99526a == openPauseBlockingActivity.f99526a && Intrinsics.areEqual(this.f99527b, openPauseBlockingActivity.f99527b) && Intrinsics.areEqual(this.f99528c, openPauseBlockingActivity.f99528c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f99526a) * 31) + this.f99527b.hashCode()) * 31) + this.f99528c.hashCode();
        }

        public String toString() {
            return "OpenPauseBlockingActivity(profileId=" + this.f99526a + ", state=" + this.f99527b + ", premiumState=" + this.f99528c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPremiumFeatureActivity extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f99529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f99530b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPremiumFeatureActivity(PremiumFeature premiumFeature, String entrancesDetail) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            this.f99529a = premiumFeature;
            this.f99530b = entrancesDetail;
        }

        public final String a() {
            return this.f99530b;
        }

        public final PremiumFeature b() {
            return this.f99529a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenPremiumFeatureActivity)) {
                return false;
            }
            OpenPremiumFeatureActivity openPremiumFeatureActivity = (OpenPremiumFeatureActivity) obj;
            return this.f99529a == openPremiumFeatureActivity.f99529a && Intrinsics.areEqual(this.f99530b, openPremiumFeatureActivity.f99530b);
        }

        public int hashCode() {
            return (this.f99529a.hashCode() * 31) + this.f99530b.hashCode();
        }

        public String toString() {
            return "OpenPremiumFeatureActivity(premiumFeature=" + this.f99529a + ", entrancesDetail=" + this.f99530b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPremiumGenericActivity extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenPremiumGenericActivity f99531a = new OpenPremiumGenericActivity();

        private OpenPremiumGenericActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenPremiumGenericActivity);
        }

        public int hashCode() {
            return -1630021068;
        }

        public String toString() {
            return "OpenPremiumGenericActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenProfileCreating extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenProfileCreating f99532a = new OpenProfileCreating();

        private OpenProfileCreating() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenProfileCreating);
        }

        public int hashCode() {
            return 341520285;
        }

        public String toString() {
            return "OpenProfileCreating";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenProfileDuplication extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleDTO f99533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f99534b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenProfileDuplication(ScheduleDTO scheduleDTO, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleDTO, "scheduleDTO");
            this.f99533a = scheduleDTO;
            this.f99534b = l3;
        }

        public final Long a() {
            return this.f99534b;
        }

        public final ScheduleDTO b() {
            return this.f99533a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenProfileDuplication)) {
                return false;
            }
            OpenProfileDuplication openProfileDuplication = (OpenProfileDuplication) obj;
            return Intrinsics.areEqual(this.f99533a, openProfileDuplication.f99533a) && Intrinsics.areEqual(this.f99534b, openProfileDuplication.f99534b);
        }

        public int hashCode() {
            int iHashCode = this.f99533a.hashCode() * 31;
            Long l3 = this.f99534b;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "OpenProfileDuplication(scheduleDTO=" + this.f99533a + ", originalId=" + this.f99534b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenProfileWithConditionCreating extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f99535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConditionDTO f99536b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenProfileWithConditionCreating(ProfileType profileType, ConditionDTO conditionDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f99535a = profileType;
            this.f99536b = conditionDTO;
        }

        public final ConditionDTO a() {
            return this.f99536b;
        }

        public final ProfileType b() {
            return this.f99535a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenProfileWithConditionCreating)) {
                return false;
            }
            OpenProfileWithConditionCreating openProfileWithConditionCreating = (OpenProfileWithConditionCreating) obj;
            return this.f99535a == openProfileWithConditionCreating.f99535a && Intrinsics.areEqual(this.f99536b, openProfileWithConditionCreating.f99536b);
        }

        public int hashCode() {
            int iHashCode = this.f99535a.hashCode() * 31;
            ConditionDTO conditionDTO = this.f99536b;
            return iHashCode + (conditionDTO == null ? 0 : conditionDTO.hashCode());
        }

        public String toString() {
            return "OpenProfileWithConditionCreating(profileType=" + this.f99535a + ", condition=" + this.f99536b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenStreakDetail extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenStreakDetail f99537a = new OpenStreakDetail();

        private OpenStreakDetail() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenStreakDetail);
        }

        public int hashCode() {
            return -554459340;
        }

        public String toString() {
            return "OpenStreakDetail";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenStreakMilestone extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f99538a;

        public OpenStreakMilestone(int i3) {
            super(null);
            this.f99538a = i3;
        }

        public final int a() {
            return this.f99538a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenStreakMilestone) && this.f99538a == ((OpenStreakMilestone) obj).f99538a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f99538a);
        }

        public String toString() {
            return "OpenStreakMilestone(streakCount=" + this.f99538a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenTroubleshootingActivity extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenTroubleshootingActivity f99539a = new OpenTroubleshootingActivity();

        private OpenTroubleshootingActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenTroubleshootingActivity);
        }

        public int hashCode() {
            return 1796182180;
        }

        public String toString() {
            return "OpenTroubleshootingActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAutoLockInfoDialogAfterEnabling extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAutoLockInfoDialogAfterEnabling f99540a = new ShowAutoLockInfoDialogAfterEnabling();

        private ShowAutoLockInfoDialogAfterEnabling() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAutoLockInfoDialogAfterEnabling);
        }

        public int hashCode() {
            return -63230540;
        }

        public String toString() {
            return "ShowAutoLockInfoDialogAfterEnabling";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowBlockedNotificationsSnackbar extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f99541a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowBlockedNotificationsSnackbar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f99541a = text;
        }

        public final String a() {
            return this.f99541a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowBlockedNotificationsSnackbar) && Intrinsics.areEqual(this.f99541a, ((ShowBlockedNotificationsSnackbar) obj).f99541a);
        }

        public int hashCode() {
            return this.f99541a.hashCode();
        }

        public String toString() {
            return "ShowBlockedNotificationsSnackbar(text=" + this.f99541a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowDisclaimerDialog extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisclaimerType f99542a;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DisclaimerType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ DisclaimerType[] $VALUES;
            public static final DisclaimerType STRICT_MODE = new DisclaimerType("STRICT_MODE", 0);
            public static final DisclaimerType LOCATION = new DisclaimerType("LOCATION", 1);
            public static final DisclaimerType WIFI = new DisclaimerType("WIFI", 2);

            private static final /* synthetic */ DisclaimerType[] $values() {
                return new DisclaimerType[]{STRICT_MODE, LOCATION, WIFI};
            }

            static {
                DisclaimerType[] disclaimerTypeArr$values = $values();
                $VALUES = disclaimerTypeArr$values;
                $ENTRIES = EnumEntriesKt.a(disclaimerTypeArr$values);
            }

            private DisclaimerType(String str, int i3) {
            }

            public static EnumEntries<DisclaimerType> getEntries() {
                return $ENTRIES;
            }

            public static DisclaimerType valueOf(String str) {
                return (DisclaimerType) Enum.valueOf(DisclaimerType.class, str);
            }

            public static DisclaimerType[] values() {
                return (DisclaimerType[]) $VALUES.clone();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowDisclaimerDialog(DisclaimerType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f99542a = type;
        }

        public final DisclaimerType a() {
            return this.f99542a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDisclaimerDialog) && this.f99542a == ((ShowDisclaimerDialog) obj).f99542a;
        }

        public int hashCode() {
            return this.f99542a.hashCode();
        }

        public String toString() {
            return "ShowDisclaimerDialog(type=" + this.f99542a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStrictModeSnackbar extends BlockingScreenViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f99543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowStrictModeSnackbar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f99543a = text;
        }

        public final String a() {
            return this.f99543a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowStrictModeSnackbar) && Intrinsics.areEqual(this.f99543a, ((ShowStrictModeSnackbar) obj).f99543a);
        }

        public int hashCode() {
            return this.f99543a.hashCode();
        }

        public String toString() {
            return "ShowStrictModeSnackbar(text=" + this.f99543a + ")";
        }
    }

    public /* synthetic */ BlockingScreenViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingScreenViewCommand() {
    }
}
