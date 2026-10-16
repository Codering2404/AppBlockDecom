package cz.mobilesoft.coreblock.scene.dashboard.profile;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.SocialMedia;
import cz.mobilesoft.coreblock.scene.dashboard.profile.type.ProfileSectionItemType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class ProfileViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeleteAccount extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeleteAccount f100924a = new DeleteAccount();

        private DeleteAccount() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof DeleteAccount);
        }

        public int hashCode() {
            return -1842427380;
        }

        public String toString() {
            return "DeleteAccount";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAdsConsentUpdated extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f100925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f100926b;

        public OnAdsConsentUpdated(Integer num, boolean z2) {
            super(null);
            this.f100925a = num;
            this.f100926b = z2;
        }

        public final Integer a() {
            return this.f100925a;
        }

        public final boolean b() {
            return this.f100926b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAdsConsentUpdated)) {
                return false;
            }
            OnAdsConsentUpdated onAdsConsentUpdated = (OnAdsConsentUpdated) obj;
            return Intrinsics.areEqual(this.f100925a, onAdsConsentUpdated.f100925a) && this.f100926b == onAdsConsentUpdated.f100926b;
        }

        public int hashCode() {
            Integer num = this.f100925a;
            return ((num == null ? 0 : num.hashCode()) * 31) + Boolean.hashCode(this.f100926b);
        }

        public String toString() {
            return "OnAdsConsentUpdated(consentStatus=" + this.f100925a + ", userPrefersAdFree=" + this.f100926b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBackupClicked extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBackupClicked f100927a = new OnBackupClicked();

        private OnBackupClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBackupClicked);
        }

        public int hashCode() {
            return -421334544;
        }

        public String toString() {
            return "OnBackupClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsGranted extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPermissionsGranted f100928a = new OnPermissionsGranted();

        private OnPermissionsGranted() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPermissionsGranted);
        }

        public int hashCode() {
            return 128342668;
        }

        public String toString() {
            return "OnPermissionsGranted";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileSectionItemClicked extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileSectionItemType f100929a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileSectionItemClicked(ProfileSectionItemType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f100929a = type;
        }

        public final ProfileSectionItemType a() {
            return this.f100929a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileSectionItemClicked) && this.f100929a == ((OnProfileSectionItemClicked) obj).f100929a;
        }

        public int hashCode() {
            return this.f100929a.hashCode();
        }

        public String toString() {
            return "OnProfileSectionItemClicked(type=" + this.f100929a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResume extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResume f100930a = new OnResume();

        private OnResume() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResume);
        }

        public int hashCode() {
            return 1621945506;
        }

        public String toString() {
            return "OnResume";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSocialMediaItemClicked extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SocialMedia f100931a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSocialMediaItemClicked(SocialMedia media) {
            super(null);
            Intrinsics.checkNotNullParameter(media, "media");
            this.f100931a = media;
        }

        public final SocialMedia a() {
            return this.f100931a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSocialMediaItemClicked) && this.f100931a == ((OnSocialMediaItemClicked) obj).f100931a;
        }

        public int hashCode() {
            return this.f100931a.hashCode();
        }

        public String toString() {
            return "OnSocialMediaItemClicked(media=" + this.f100931a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestSignUpLoginEvent extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestSignUpLoginEvent f100932a = new RequestSignUpLoginEvent();

        private RequestSignUpLoginEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof RequestSignUpLoginEvent);
        }

        public int hashCode() {
            return -1813383102;
        }

        public String toString() {
            return "RequestSignUpLoginEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStatisticsPageEvent extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowStatisticsPageEvent f100933a = new ShowStatisticsPageEvent();

        private ShowStatisticsPageEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowStatisticsPageEvent);
        }

        public int hashCode() {
            return 532332725;
        }

        public String toString() {
            return "ShowStatisticsPageEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowWeeklyInsights extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowWeeklyInsights f100934a = new ShowWeeklyInsights();

        private ShowWeeklyInsights() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowWeeklyInsights);
        }

        public int hashCode() {
            return 2138592783;
        }

        public String toString() {
            return "ShowWeeklyInsights";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SignOut extends ProfileViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SignOut f100935a = new SignOut();

        private SignOut() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SignOut);
        }

        public int hashCode() {
            return -1370339365;
        }

        public String toString() {
            return "SignOut";
        }
    }

    public /* synthetic */ ProfileViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileViewEvent() {
    }
}
