package cz.mobilesoft.coreblock.view.compose.profileitem;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
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
public abstract class ProfileItemEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCreateProfile extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCreateProfile f131660a = new OnCreateProfile();

        private OnCreateProfile() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCreateProfile);
        }

        public int hashCode() {
            return -1772991318;
        }

        public String toString() {
            return "OnCreateProfile";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCreateProfileWithCondition extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f131661a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCreateProfileWithCondition(ProfileType profileType) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f131661a = profileType;
        }

        public final ProfileType a() {
            return this.f131661a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCreateProfileWithCondition) && this.f131661a == ((OnCreateProfileWithCondition) obj).f131661a;
        }

        public int hashCode() {
            return this.f131661a.hashCode();
        }

        public String toString() {
            return "OnCreateProfileWithCondition(profileType=" + this.f131661a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileActionButtonClicked extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f131662a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileActionButtonClicked(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f131662a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f131662a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileActionButtonClicked) && Intrinsics.areEqual(this.f131662a, ((OnProfileActionButtonClicked) obj).f131662a);
        }

        public int hashCode() {
            return this.f131662a.hashCode();
        }

        public String toString() {
            return "OnProfileActionButtonClicked(profileViewDTO=" + this.f131662a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileDeleted extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f131663a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileDeleted(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f131663a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f131663a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileDeleted) && Intrinsics.areEqual(this.f131663a, ((OnProfileDeleted) obj).f131663a);
        }

        public int hashCode() {
            return this.f131663a.hashCode();
        }

        public String toString() {
            return "OnProfileDeleted(profileViewDTO=" + this.f131663a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileDuplicate extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f131664a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileDuplicate(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f131664a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f131664a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileDuplicate) && Intrinsics.areEqual(this.f131664a, ((OnProfileDuplicate) obj).f131664a);
        }

        public int hashCode() {
            return this.f131664a.hashCode();
        }

        public String toString() {
            return "OnProfileDuplicate(profileViewDTO=" + this.f131664a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfilePauseSelected extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f131665a;

        public OnProfilePauseSelected(long j3) {
            super(null);
            this.f131665a = j3;
        }

        public final long a() {
            return this.f131665a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfilePauseSelected) && this.f131665a == ((OnProfilePauseSelected) obj).f131665a;
        }

        public int hashCode() {
            return Long.hashCode(this.f131665a);
        }

        public String toString() {
            return "OnProfilePauseSelected(profileId=" + this.f131665a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileResumed extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f131666a;

        public OnProfileResumed(long j3) {
            super(null);
            this.f131666a = j3;
        }

        public final long a() {
            return this.f131666a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileResumed) && this.f131666a == ((OnProfileResumed) obj).f131666a;
        }

        public int hashCode() {
            return Long.hashCode(this.f131666a);
        }

        public String toString() {
            return "OnProfileResumed(profileId=" + this.f131666a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileSeasonalTemplateDismissed extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleTemplate f131667a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileSeasonalTemplateDismissed(ScheduleTemplate seasonalTemplate) {
            super(null);
            Intrinsics.checkNotNullParameter(seasonalTemplate, "seasonalTemplate");
            this.f131667a = seasonalTemplate;
        }

        public final ScheduleTemplate a() {
            return this.f131667a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileSeasonalTemplateDismissed) && this.f131667a == ((OnProfileSeasonalTemplateDismissed) obj).f131667a;
        }

        public int hashCode() {
            return this.f131667a.hashCode();
        }

        public String toString() {
            return "OnProfileSeasonalTemplateDismissed(seasonalTemplate=" + this.f131667a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileSelected extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f131668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f131669b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileSelected(ProfileViewDTO profileViewDTO, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f131668a = profileViewDTO;
            this.f131669b = z2;
        }

        public final boolean a() {
            return this.f131669b;
        }

        public final ProfileViewDTO b() {
            return this.f131668a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnProfileSelected)) {
                return false;
            }
            OnProfileSelected onProfileSelected = (OnProfileSelected) obj;
            return Intrinsics.areEqual(this.f131668a, onProfileSelected.f131668a) && this.f131669b == onProfileSelected.f131669b;
        }

        public int hashCode() {
            return (this.f131668a.hashCode() * 31) + Boolean.hashCode(this.f131669b);
        }

        public String toString() {
            return "OnProfileSelected(profileViewDTO=" + this.f131668a + ", becomingSelected=" + this.f131669b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileStartedManually extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f131670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f131671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f131672c;

        public OnProfileStartedManually(long j3, long j4, boolean z2) {
            super(null);
            this.f131670a = j3;
            this.f131671b = j4;
            this.f131672c = z2;
        }

        public final long a() {
            return this.f131670a;
        }

        public final long b() {
            return this.f131671b;
        }

        public final boolean c() {
            return this.f131672c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnProfileStartedManually)) {
                return false;
            }
            OnProfileStartedManually onProfileStartedManually = (OnProfileStartedManually) obj;
            return this.f131670a == onProfileStartedManually.f131670a && this.f131671b == onProfileStartedManually.f131671b && this.f131672c == onProfileStartedManually.f131672c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f131670a) * 31) + Long.hashCode(this.f131671b)) * 31) + Boolean.hashCode(this.f131672c);
        }

        public String toString() {
            return "OnProfileStartedManually(profileId=" + this.f131670a + ", time=" + this.f131671b + ", willBeLocked=" + this.f131672c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileStoppedManually extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileViewDTO f131673a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileStoppedManually(ProfileViewDTO profileViewDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
            this.f131673a = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f131673a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileStoppedManually) && Intrinsics.areEqual(this.f131673a, ((OnProfileStoppedManually) obj).f131673a);
        }

        public int hashCode() {
            return this.f131673a.hashCode();
        }

        public String toString() {
            return "OnProfileStoppedManually(profileViewDTO=" + this.f131673a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileTemplateSelected extends ProfileItemEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleTemplate f131674a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileTemplateSelected(ScheduleTemplate template) {
            super(null);
            Intrinsics.checkNotNullParameter(template, "template");
            this.f131674a = template;
        }

        public final ScheduleTemplate a() {
            return this.f131674a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileTemplateSelected) && this.f131674a == ((OnProfileTemplateSelected) obj).f131674a;
        }

        public int hashCode() {
            return this.f131674a.hashCode();
        }

        public String toString() {
            return "OnProfileTemplateSelected(template=" + this.f131674a + ")";
        }
    }

    public /* synthetic */ ProfileItemEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileItemEvent() {
    }
}
