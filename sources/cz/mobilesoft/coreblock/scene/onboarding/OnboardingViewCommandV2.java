package cz.mobilesoft.coreblock.scene.onboarding;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class OnboardingViewCommandV2 implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchGuestPassActivation extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchGuestPassActivation f110932a = new LaunchGuestPassActivation();

        private LaunchGuestPassActivation() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LaunchGuestPassActivation);
        }

        public int hashCode() {
            return 1695568543;
        }

        public String toString() {
            return "LaunchGuestPassActivation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToFinishRegistration extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110933a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToFinishRegistration(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f110933a = email;
        }

        public final String a() {
            return this.f110933a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToFinishRegistration) && Intrinsics.areEqual(this.f110933a, ((NavigateToFinishRegistration) obj).f110933a);
        }

        public int hashCode() {
            return this.f110933a.hashCode();
        }

        public String toString() {
            return "NavigateToFinishRegistration(email=" + this.f110933a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToPhonePickUpScreen extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToPhonePickUpScreen f110934a = new NavigateToPhonePickUpScreen();

        private NavigateToPhonePickUpScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToPhonePickUpScreen);
        }

        public int hashCode() {
            return -1964530467;
        }

        public String toString() {
            return "NavigateToPhonePickUpScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToSoftPaywallPremium extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToSoftPaywallPremium f110935a = new NavigateToSoftPaywallPremium();

        private NavigateToSoftPaywallPremium() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToSoftPaywallPremium);
        }

        public int hashCode() {
            return -1881477880;
        }

        public String toString() {
            return "NavigateToSoftPaywallPremium";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToStatsPermissionScreen extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToStatsPermissionScreen f110936a = new NavigateToStatsPermissionScreen();

        private NavigateToStatsPermissionScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToStatsPermissionScreen);
        }

        public int hashCode() {
            return 732664961;
        }

        public String toString() {
            return "NavigateToStatsPermissionScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOnboardingSkipped extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110937a;

        public OnOnboardingSkipped(boolean z2) {
            super(null);
            this.f110937a = z2;
        }

        public final boolean a() {
            return this.f110937a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOnboardingSkipped) && this.f110937a == ((OnOnboardingSkipped) obj).f110937a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110937a);
        }

        public String toString() {
            return "OnOnboardingSkipped(showConsent=" + this.f110937a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowGuestPassIneligibleSnackbar extends OnboardingViewCommandV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110938a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowGuestPassIneligibleSnackbar(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f110938a = message;
        }

        public final String a() {
            return this.f110938a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowGuestPassIneligibleSnackbar) && Intrinsics.areEqual(this.f110938a, ((ShowGuestPassIneligibleSnackbar) obj).f110938a);
        }

        public int hashCode() {
            return this.f110938a.hashCode();
        }

        public String toString() {
            return "ShowGuestPassIneligibleSnackbar(message=" + this.f110938a + ")";
        }
    }

    public /* synthetic */ OnboardingViewCommandV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingViewCommandV2() {
    }
}
