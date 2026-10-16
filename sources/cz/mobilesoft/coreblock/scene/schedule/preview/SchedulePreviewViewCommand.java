package cz.mobilesoft.coreblock.scene.schedule.preview;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
public abstract class SchedulePreviewViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f117385a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCloseClicked);
        }

        public int hashCode() {
            return 217223639;
        }

        public String toString() {
            return "OnCloseClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEditScheduleClicked extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile f117386a;

        public OnEditScheduleClicked(Profile profile) {
            super(null);
            this.f117386a = profile;
        }

        public final Profile a() {
            return this.f117386a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEditScheduleClicked) && Intrinsics.areEqual(this.f117386a, ((OnEditScheduleClicked) obj).f117386a);
        }

        public int hashCode() {
            Profile profile = this.f117386a;
            if (profile == null) {
                return 0;
            }
            return profile.hashCode();
        }

        public String toString() {
            return "OnEditScheduleClicked(profile=" + this.f117386a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPauseBlockingActivity extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f117387d = ProfileDisabledSuggestStrictModeState.$stable;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f117388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProfileDisabledSuggestStrictModeState f117389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PremiumState f117390c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPauseBlockingActivity(long j3, ProfileDisabledSuggestStrictModeState state, PremiumState premiumState) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f117388a = j3;
            this.f117389b = state;
            this.f117390c = premiumState;
        }

        public final PremiumState a() {
            return this.f117390c;
        }

        public final long b() {
            return this.f117388a;
        }

        public final ProfileDisabledSuggestStrictModeState c() {
            return this.f117389b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenPauseBlockingActivity)) {
                return false;
            }
            OpenPauseBlockingActivity openPauseBlockingActivity = (OpenPauseBlockingActivity) obj;
            return this.f117388a == openPauseBlockingActivity.f117388a && Intrinsics.areEqual(this.f117389b, openPauseBlockingActivity.f117389b) && Intrinsics.areEqual(this.f117390c, openPauseBlockingActivity.f117390c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f117388a) * 31) + this.f117389b.hashCode()) * 31) + this.f117390c.hashCode();
        }

        public String toString() {
            return "OpenPauseBlockingActivity(profileId=" + this.f117388a + ", state=" + this.f117389b + ", premiumState=" + this.f117390c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPremiumFeatureActivity extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f117391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f117392b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPremiumFeatureActivity(PremiumFeature premiumFeature, String entrancesDetail) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            this.f117391a = premiumFeature;
            this.f117392b = entrancesDetail;
        }

        public final String a() {
            return this.f117392b;
        }

        public final PremiumFeature b() {
            return this.f117391a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenPremiumFeatureActivity)) {
                return false;
            }
            OpenPremiumFeatureActivity openPremiumFeatureActivity = (OpenPremiumFeatureActivity) obj;
            return this.f117391a == openPremiumFeatureActivity.f117391a && Intrinsics.areEqual(this.f117392b, openPremiumFeatureActivity.f117392b);
        }

        public int hashCode() {
            return (this.f117391a.hashCode() * 31) + this.f117392b.hashCode();
        }

        public String toString() {
            return "OpenPremiumFeatureActivity(premiumFeature=" + this.f117391a + ", entrancesDetail=" + this.f117392b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPremiumGenericActivity extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenPremiumGenericActivity f117393a = new OpenPremiumGenericActivity();

        private OpenPremiumGenericActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenPremiumGenericActivity);
        }

        public int hashCode() {
            return -1381038238;
        }

        public String toString() {
            return "OpenPremiumGenericActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenProfileDuplication extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleDTO f117394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f117395b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenProfileDuplication(ScheduleDTO scheduleDTO, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleDTO, "scheduleDTO");
            this.f117394a = scheduleDTO;
            this.f117395b = l3;
        }

        public final Long a() {
            return this.f117395b;
        }

        public final ScheduleDTO b() {
            return this.f117394a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenProfileDuplication)) {
                return false;
            }
            OpenProfileDuplication openProfileDuplication = (OpenProfileDuplication) obj;
            return Intrinsics.areEqual(this.f117394a, openProfileDuplication.f117394a) && Intrinsics.areEqual(this.f117395b, openProfileDuplication.f117395b);
        }

        public int hashCode() {
            int iHashCode = this.f117394a.hashCode() * 31;
            Long l3 = this.f117395b;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "OpenProfileDuplication(scheduleDTO=" + this.f117394a + ", originalId=" + this.f117395b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends SchedulePreviewViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f117396a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f117396a = message;
        }

        public final String a() {
            return this.f117396a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f117396a, ((ShowSnackBar) obj).f117396a);
        }

        public int hashCode() {
            return this.f117396a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(message=" + this.f117396a + ")";
        }
    }

    public /* synthetic */ SchedulePreviewViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SchedulePreviewViewCommand() {
    }
}
