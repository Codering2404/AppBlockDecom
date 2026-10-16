package cz.mobilesoft.coreblock.scene.dashboard.profile;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumState;
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
public abstract class ProfileViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchBackupCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumState f100916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f100917b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LaunchBackupCommand(PremiumState premiumState, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f100916a = premiumState;
            this.f100917b = z2;
        }

        public final PremiumState a() {
            return this.f100916a;
        }

        public final boolean b() {
            return this.f100917b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LaunchBackupCommand)) {
                return false;
            }
            LaunchBackupCommand launchBackupCommand = (LaunchBackupCommand) obj;
            return Intrinsics.areEqual(this.f100916a, launchBackupCommand.f100916a) && this.f100917b == launchBackupCommand.f100917b;
        }

        public int hashCode() {
            return (this.f100916a.hashCode() * 31) + Boolean.hashCode(this.f100917b);
        }

        public String toString() {
            return "LaunchBackupCommand(premiumState=" + this.f100916a + ", isSignedIn=" + this.f100917b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRequestSignUpLoginCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRequestSignUpLoginCommand f100918a = new OnRequestSignUpLoginCommand();

        private OnRequestSignUpLoginCommand() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRequestSignUpLoginCommand);
        }

        public int hashCode() {
            return 1064844549;
        }

        public String toString() {
            return "OnRequestSignUpLoginCommand";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSectionClickActionCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileSectionItemType f100919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f100920b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSectionClickActionCommand(ProfileSectionItemType type, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f100919a = type;
            this.f100920b = z2;
        }

        public final ProfileSectionItemType a() {
            return this.f100919a;
        }

        public final boolean b() {
            return this.f100920b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSectionClickActionCommand)) {
                return false;
            }
            OnSectionClickActionCommand onSectionClickActionCommand = (OnSectionClickActionCommand) obj;
            return this.f100919a == onSectionClickActionCommand.f100919a && this.f100920b == onSectionClickActionCommand.f100920b;
        }

        public int hashCode() {
            return (this.f100919a.hashCode() * 31) + Boolean.hashCode(this.f100920b);
        }

        public String toString() {
            return "OnSectionClickActionCommand(type=" + this.f100919a + ", isTrialEligible=" + this.f100920b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowStatisticsPageCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowStatisticsPageCommand f100921a = new OnShowStatisticsPageCommand();

        private OnShowStatisticsPageCommand() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowStatisticsPageCommand);
        }

        public int hashCode() {
            return 439923896;
        }

        public String toString() {
            return "OnShowStatisticsPageCommand";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowWeeklyInsightsCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowWeeklyInsightsCommand f100922a = new OnShowWeeklyInsightsCommand();

        private OnShowWeeklyInsightsCommand() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowWeeklyInsightsCommand);
        }

        public int hashCode() {
            return 1948558414;
        }

        public String toString() {
            return "OnShowWeeklyInsightsCommand";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSocialMediaClickActionCommand extends ProfileViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SocialMedia f100923a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSocialMediaClickActionCommand(SocialMedia media) {
            super(null);
            Intrinsics.checkNotNullParameter(media, "media");
            this.f100923a = media;
        }

        public final SocialMedia a() {
            return this.f100923a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSocialMediaClickActionCommand) && this.f100923a == ((OnSocialMediaClickActionCommand) obj).f100923a;
        }

        public int hashCode() {
            return this.f100923a.hashCode();
        }

        public String toString() {
            return "OnSocialMediaClickActionCommand(media=" + this.f100923a + ")";
        }
    }

    public /* synthetic */ ProfileViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileViewCommand() {
    }
}
