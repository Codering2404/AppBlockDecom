package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class ScheduleViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleResult f114502a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CloseScreen(ScheduleResult scheduleResult) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleResult, "scheduleResult");
            this.f114502a = scheduleResult;
        }

        public final ScheduleResult a() {
            return this.f114502a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloseScreen) && Intrinsics.areEqual(this.f114502a, ((CloseScreen) obj).f114502a);
        }

        public int hashCode() {
            return this.f114502a.hashCode();
        }

        public String toString() {
            return "CloseScreen(scheduleResult=" + this.f114502a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishActivity extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FinishActivity f114503a = new FinishActivity();

        private FinishActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof FinishActivity);
        }

        public int hashCode() {
            return -1468972053;
        }

        public String toString() {
            return "FinishActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HandleOnboardingFinished extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114504a;

        public HandleOnboardingFinished(boolean z2) {
            super(null);
            this.f114504a = z2;
        }

        public final boolean a() {
            return this.f114504a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HandleOnboardingFinished) && this.f114504a == ((HandleOnboardingFinished) obj).f114504a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114504a);
        }

        public String toString() {
            return "HandleOnboardingFinished(showConsent=" + this.f114504a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateBack extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateBack f114505a = new NavigateBack();

        private NavigateBack() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateBack);
        }

        public int hashCode() {
            return -1261357215;
        }

        public String toString() {
            return "NavigateBack";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileUsageLimitSave extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UsageLimit.PeriodType f114507b;

        public final UsageLimit.PeriodType a() {
            return this.f114507b;
        }

        public final long b() {
            return this.f114506a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnProfileUsageLimitSave)) {
                return false;
            }
            OnProfileUsageLimitSave onProfileUsageLimitSave = (OnProfileUsageLimitSave) obj;
            return this.f114506a == onProfileUsageLimitSave.f114506a && this.f114507b == onProfileUsageLimitSave.f114507b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f114506a) * 31) + this.f114507b.hashCode();
        }

        public String toString() {
            return "OnProfileUsageLimitSave(timeInMillis=" + this.f114506a + ", periodType=" + this.f114507b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenEmailConsentActivity extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114508a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenEmailConsentActivity(String emailConsentSource) {
            super(null);
            Intrinsics.checkNotNullParameter(emailConsentSource, "emailConsentSource");
            this.f114508a = emailConsentSource;
        }

        public final String a() {
            return this.f114508a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenEmailConsentActivity) && Intrinsics.areEqual(this.f114508a, ((OpenEmailConsentActivity) obj).f114508a);
        }

        public int hashCode() {
            return this.f114508a.hashCode();
        }

        public String toString() {
            return "OpenEmailConsentActivity(emailConsentSource=" + this.f114508a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PremiumFeatureForLaunchCountRequired extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UsageLimit.PeriodType f114509a;

        public PremiumFeatureForLaunchCountRequired(UsageLimit.PeriodType periodType) {
            super(null);
            this.f114509a = periodType;
        }

        public final UsageLimit.PeriodType a() {
            return this.f114509a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PremiumFeatureForLaunchCountRequired) && this.f114509a == ((PremiumFeatureForLaunchCountRequired) obj).f114509a;
        }

        public int hashCode() {
            UsageLimit.PeriodType periodType = this.f114509a;
            if (periodType == null) {
                return 0;
            }
            return periodType.hashCode();
        }

        public String toString() {
            return "PremiumFeatureForLaunchCountRequired(usageLimitPeriod=" + this.f114509a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PremiumFeatureForUsageLimitRequired extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UsageLimit.PeriodType f114510a;

        public PremiumFeatureForUsageLimitRequired(UsageLimit.PeriodType periodType) {
            super(null);
            this.f114510a = periodType;
        }

        public final UsageLimit.PeriodType a() {
            return this.f114510a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PremiumFeatureForUsageLimitRequired) && this.f114510a == ((PremiumFeatureForUsageLimitRequired) obj).f114510a;
        }

        public int hashCode() {
            UsageLimit.PeriodType periodType = this.f114510a;
            if (periodType == null) {
                return 0;
            }
            return periodType.hashCode();
        }

        public String toString() {
            return "PremiumFeatureForUsageLimitRequired(usageLimitPeriod=" + this.f114510a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAddToFollowSchedulesDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAddToFollowSchedulesDialog f114511a = new ShowAddToFollowSchedulesDialog();

        private ShowAddToFollowSchedulesDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAddToFollowSchedulesDialog);
        }

        public int hashCode() {
            return 271797661;
        }

        public String toString() {
            return "ShowAddToFollowSchedulesDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowApplicationSelection extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowApplicationSelection f114512a = new ShowApplicationSelection();

        private ShowApplicationSelection() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowApplicationSelection);
        }

        public int hashCode() {
            return -1135167326;
        }

        public String toString() {
            return "ShowApplicationSelection";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowBlockingModeSettings extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowBlockingModeSettings f114513a = new ShowBlockingModeSettings();

        private ShowBlockingModeSettings() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowBlockingModeSettings);
        }

        public int hashCode() {
            return 1905152577;
        }

        public String toString() {
            return "ShowBlockingModeSettings";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowChargerLockConfirmDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114514a;

        public ShowChargerLockConfirmDialog(boolean z2) {
            super(null);
            this.f114514a = z2;
        }

        public final boolean a() {
            return this.f114514a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowChargerLockConfirmDialog) && this.f114514a == ((ShowChargerLockConfirmDialog) obj).f114514a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114514a);
        }

        public String toString() {
            return "ShowChargerLockConfirmDialog(willAlsoBeSaving=" + this.f114514a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowConditionDetail extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f114515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConditionDTO f114516b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowConditionDetail(ProfileType profileType, ConditionDTO conditionDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f114515a = profileType;
            this.f114516b = conditionDTO;
        }

        public final ConditionDTO a() {
            return this.f114516b;
        }

        public final ProfileType b() {
            return this.f114515a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowConditionDetail)) {
                return false;
            }
            ShowConditionDetail showConditionDetail = (ShowConditionDetail) obj;
            return this.f114515a == showConditionDetail.f114515a && Intrinsics.areEqual(this.f114516b, showConditionDetail.f114516b);
        }

        public int hashCode() {
            int iHashCode = this.f114515a.hashCode() * 31;
            ConditionDTO conditionDTO = this.f114516b;
            return iHashCode + (conditionDTO == null ? 0 : conditionDTO.hashCode());
        }

        public String toString() {
            return "ShowConditionDetail(profileType=" + this.f114515a + ", condition=" + this.f114516b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowConditionSelection extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowConditionSelection f114517a = new ShowConditionSelection();

        private ShowConditionSelection() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowConditionSelection);
        }

        public int hashCode() {
            return -607596873;
        }

        public String toString() {
            return "ShowConditionSelection";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowConflictingSchedules extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114518a;

        public ShowConflictingSchedules(boolean z2) {
            super(null);
            this.f114518a = z2;
        }

        public final boolean a() {
            return this.f114518a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowConflictingSchedules) && this.f114518a == ((ShowConflictingSchedules) obj).f114518a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114518a);
        }

        public String toString() {
            return "ShowConflictingSchedules(showContinueButton=" + this.f114518a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowDetailSettingsBottomSheet extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowDetailSettingsBottomSheet f114519a = new ShowDetailSettingsBottomSheet();

        private ShowDetailSettingsBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowDetailSettingsBottomSheet);
        }

        public int hashCode() {
            return -1460571398;
        }

        public String toString() {
            return "ShowDetailSettingsBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowDisabledDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114520a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowDisabledDialog(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f114520a = text;
        }

        public final String a() {
            return this.f114520a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDisabledDialog) && Intrinsics.areEqual(this.f114520a, ((ShowDisabledDialog) obj).f114520a);
        }

        public int hashCode() {
            return this.f114520a.hashCode();
        }

        public String toString() {
            return "ShowDisabledDialog(text=" + this.f114520a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowEmojiEditScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowEmojiEditScreen f114521a = new ShowEmojiEditScreen();

        private ShowEmojiEditScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowEmojiEditScreen);
        }

        public int hashCode() {
            return 482605494;
        }

        public String toString() {
            return "ShowEmojiEditScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInfoDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f114523b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInfoDialog(String title, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.f114522a = title;
            this.f114523b = message;
        }

        public final String a() {
            return this.f114523b;
        }

        public final String b() {
            return this.f114522a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInfoDialog)) {
                return false;
            }
            ShowInfoDialog showInfoDialog = (ShowInfoDialog) obj;
            return Intrinsics.areEqual(this.f114522a, showInfoDialog.f114522a) && Intrinsics.areEqual(this.f114523b, showInfoDialog.f114523b);
        }

        public int hashCode() {
            return (this.f114522a.hashCode() * 31) + this.f114523b.hashCode();
        }

        public String toString() {
            return "ShowInfoDialog(title=" + this.f114522a + ", message=" + this.f114523b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInvalidForSavingDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInvalidForSavingDialog(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f114524a = message;
        }

        public final String a() {
            return this.f114524a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowInvalidForSavingDialog) && Intrinsics.areEqual(this.f114524a, ((ShowInvalidForSavingDialog) obj).f114524a);
        }

        public int hashCode() {
            return this.f114524a.hashCode();
        }

        public String toString() {
            return "ShowInvalidForSavingDialog(message=" + this.f114524a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionActivity extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f114525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PermissionRequestReason f114526b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionActivity(List requiredPermissions, PermissionRequestReason requestReason) {
            super(null);
            Intrinsics.checkNotNullParameter(requiredPermissions, "requiredPermissions");
            Intrinsics.checkNotNullParameter(requestReason, "requestReason");
            this.f114525a = requiredPermissions;
            this.f114526b = requestReason;
        }

        public final PermissionRequestReason a() {
            return this.f114526b;
        }

        public final List b() {
            return this.f114525a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionActivity)) {
                return false;
            }
            ShowPermissionActivity showPermissionActivity = (ShowPermissionActivity) obj;
            return Intrinsics.areEqual(this.f114525a, showPermissionActivity.f114525a) && this.f114526b == showPermissionActivity.f114526b;
        }

        public int hashCode() {
            return (this.f114525a.hashCode() * 31) + this.f114526b.hashCode();
        }

        public String toString() {
            return "ShowPermissionActivity(requiredPermissions=" + this.f114525a + ", requestReason=" + this.f114526b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPomodoroScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowPomodoroScreen f114527a = new ShowPomodoroScreen();

        private ShowPomodoroScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowPomodoroScreen);
        }

        public int hashCode() {
            return -965825477;
        }

        public String toString() {
            return "ShowPomodoroScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumFeatureScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f114528a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumFeatureScreen(PremiumFeature premiumFeature) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            this.f114528a = premiumFeature;
        }

        public final PremiumFeature a() {
            return this.f114528a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPremiumFeatureScreen) && this.f114528a == ((ShowPremiumFeatureScreen) obj).f114528a;
        }

        public int hashCode() {
            return this.f114528a.hashCode();
        }

        public String toString() {
            return "ShowPremiumFeatureScreen(premiumFeature=" + this.f114528a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumOneTimeToSubScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowPremiumOneTimeToSubScreen f114529a = new ShowPremiumOneTimeToSubScreen();

        private ShowPremiumOneTimeToSubScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowPremiumOneTimeToSubScreen);
        }

        public int hashCode() {
            return -275460561;
        }

        public String toString() {
            return "ShowPremiumOneTimeToSubScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowScheduleDetail extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowScheduleDetail f114530a = new ShowScheduleDetail();

        private ShowScheduleDetail() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowScheduleDetail);
        }

        public int hashCode() {
            return 643176654;
        }

        public String toString() {
            return "ShowScheduleDetail";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowScheduleSummaryScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowScheduleSummaryScreen f114531a = new ShowScheduleSummaryScreen();

        private ShowScheduleSummaryScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowScheduleSummaryScreen);
        }

        public int hashCode() {
            return 394881173;
        }

        public String toString() {
            return "ShowScheduleSummaryScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114532a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f114532a = text;
        }

        public final String a() {
            return this.f114532a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f114532a, ((ShowSnackBar) obj).f114532a);
        }

        public int hashCode() {
            return this.f114532a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(text=" + this.f114532a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimeLockSelector extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114533a;

        public ShowTimeLockSelector(boolean z2) {
            super(null);
            this.f114533a = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowTimeLockSelector) && this.f114533a == ((ShowTimeLockSelector) obj).f114533a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114533a);
        }

        public String toString() {
            return "ShowTimeLockSelector(willAlsoBeSaving=" + this.f114533a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimeSelectScreen extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f114534a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowTimeSelectScreen(List history) {
            super(null);
            Intrinsics.checkNotNullParameter(history, "history");
            this.f114534a = history;
        }

        public final List a() {
            return this.f114534a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowTimeSelectScreen) && Intrinsics.areEqual(this.f114534a, ((ShowTimeSelectScreen) obj).f114534a);
        }

        public int hashCode() {
            return this.f114534a.hashCode();
        }

        public String toString() {
            return "ShowTimeSelectScreen(history=" + this.f114534a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUnsavedChangesBeforeLockingDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f114535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LockType f114536b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowUnsavedChangesBeforeLockingDialog(int i3, LockType lockType) {
            super(null);
            Intrinsics.checkNotNullParameter(lockType, "lockType");
            this.f114535a = i3;
            this.f114536b = lockType;
        }

        public final int a() {
            return this.f114535a;
        }

        public final LockType b() {
            return this.f114536b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowUnsavedChangesBeforeLockingDialog)) {
                return false;
            }
            ShowUnsavedChangesBeforeLockingDialog showUnsavedChangesBeforeLockingDialog = (ShowUnsavedChangesBeforeLockingDialog) obj;
            return this.f114535a == showUnsavedChangesBeforeLockingDialog.f114535a && this.f114536b == showUnsavedChangesBeforeLockingDialog.f114536b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f114535a) * 31) + this.f114536b.hashCode();
        }

        public String toString() {
            return "ShowUnsavedChangesBeforeLockingDialog(buttonTextRes=" + this.f114535a + ", lockType=" + this.f114536b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUnsavedChangesDialog extends ScheduleViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowUnsavedChangesDialog f114537a = new ShowUnsavedChangesDialog();

        private ShowUnsavedChangesDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowUnsavedChangesDialog);
        }

        public int hashCode() {
            return -635375741;
        }

        public String toString() {
            return "ShowUnsavedChangesDialog";
        }
    }

    public /* synthetic */ ScheduleViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ScheduleViewCommand() {
    }
}
