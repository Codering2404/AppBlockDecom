package cz.mobilesoft.coreblock.scene.schedule.preview;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
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
public abstract class SchedulePreviewViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDisabledByPremiumClicked extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDisabledByPremiumClicked f117397a = new OnDisabledByPremiumClicked();

        private OnDisabledByPremiumClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDisabledByPremiumClicked);
        }

        public int hashCode() {
            return -1641923524;
        }

        public String toString() {
            return "OnDisabledByPremiumClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEditScheduleClicked extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEditScheduleClicked f117398a = new OnEditScheduleClicked();

        private OnEditScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEditScheduleClicked);
        }

        public int hashCode() {
            return 21200621;
        }

        public String toString() {
            return "OnEditScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileDeleted extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f117399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileDeleted(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f117399a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f117399a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileDeleted) && Intrinsics.areEqual(this.f117399a, ((OnProfileDeleted) obj).f117399a);
        }

        public int hashCode() {
            return this.f117399a.hashCode();
        }

        public String toString() {
            return "OnProfileDeleted(profileViewDTO=" + this.f117399a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileDuplicate extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f117400a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileDuplicate(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f117400a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f117400a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileDuplicate) && Intrinsics.areEqual(this.f117400a, ((OnProfileDuplicate) obj).f117400a);
        }

        public int hashCode() {
            return this.f117400a.hashCode();
        }

        public String toString() {
            return "OnProfileDuplicate(profileViewDTO=" + this.f117400a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfilePauseSelected extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f117401a;

        public OnProfilePauseSelected(long j3) {
            super(null);
            this.f117401a = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfilePauseSelected) && this.f117401a == ((OnProfilePauseSelected) obj).f117401a;
        }

        public int hashCode() {
            return Long.hashCode(this.f117401a);
        }

        public String toString() {
            return "OnProfilePauseSelected(profileId=" + this.f117401a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfilePausedFromCard extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnProfilePausedFromCard f117402a = new OnProfilePausedFromCard();

        private OnProfilePausedFromCard() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnProfilePausedFromCard);
        }

        public int hashCode() {
            return 914502200;
        }

        public String toString() {
            return "OnProfilePausedFromCard";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileResumed extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnProfileResumed f117403a = new OnProfileResumed();

        private OnProfileResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnProfileResumed);
        }

        public int hashCode() {
            return 480718535;
        }

        public String toString() {
            return "OnProfileResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileStoppedManually extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f117404a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileStoppedManually(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f117404a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f117404a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileStoppedManually) && Intrinsics.areEqual(this.f117404a, ((OnProfileStoppedManually) obj).f117404a);
        }

        public int hashCode() {
            return this.f117404a.hashCode();
        }

        public String toString() {
            return "OnProfileStoppedManually(profileViewDTO=" + this.f117404a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileUpdated extends SchedulePreviewViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnProfileUpdated f117405a = new OnProfileUpdated();

        private OnProfileUpdated() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnProfileUpdated);
        }

        public int hashCode() {
            return -851258965;
        }

        public String toString() {
            return "OnProfileUpdated";
        }
    }

    public /* synthetic */ SchedulePreviewViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SchedulePreviewViewEvent() {
    }
}
