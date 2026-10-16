package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel;
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
public abstract class StrictMode3ViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAccessMethod extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f121162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessMethodConfiguration f121163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StrictModeState f121164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f121165d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenAccessMethod(StrictModeAccessMethod strictModeAccessMethod, AccessMethodConfiguration currentAccessMethodConfiguration, StrictModeState activeState, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(currentAccessMethodConfiguration, "currentAccessMethodConfiguration");
            Intrinsics.checkNotNullParameter(activeState, "activeState");
            this.f121162a = strictModeAccessMethod;
            this.f121163b = currentAccessMethodConfiguration;
            this.f121164c = activeState;
            this.f121165d = j3;
        }

        public final StrictModeState a() {
            return this.f121164c;
        }

        public final StrictModeAccessMethod b() {
            return this.f121162a;
        }

        public final AccessMethodConfiguration c() {
            return this.f121163b;
        }

        public final long d() {
            return this.f121165d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenAccessMethod)) {
                return false;
            }
            OpenAccessMethod openAccessMethod = (OpenAccessMethod) obj;
            return this.f121162a == openAccessMethod.f121162a && Intrinsics.areEqual(this.f121163b, openAccessMethod.f121163b) && this.f121164c == openAccessMethod.f121164c && this.f121165d == openAccessMethod.f121165d;
        }

        public int hashCode() {
            StrictModeAccessMethod strictModeAccessMethod = this.f121162a;
            return ((((((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f121163b.hashCode()) * 31) + this.f121164c.hashCode()) * 31) + Long.hashCode(this.f121165d);
        }

        public String toString() {
            return "OpenAccessMethod(currentAccessMethod=" + this.f121162a + ", currentAccessMethodConfiguration=" + this.f121163b + ", activeState=" + this.f121164c + ", onUntil=" + this.f121165d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAccessMethodsScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAccessMethodsScreen f121166a = new ShowAccessMethodsScreen();

        private ShowAccessMethodsScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAccessMethodsScreen);
        }

        public int hashCode() {
            return -436069950;
        }

        public String toString() {
            return "ShowAccessMethodsScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowApprovalEmailBottomSheet extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowApprovalEmailBottomSheet f121167a = new ShowApprovalEmailBottomSheet();

        private ShowApprovalEmailBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowApprovalEmailBottomSheet);
        }

        public int hashCode() {
            return 1780723731;
        }

        public String toString() {
            return "ShowApprovalEmailBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowApprovalRequestUnblockBottomSheet extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowApprovalRequestUnblockBottomSheet f121168a = new ShowApprovalRequestUnblockBottomSheet();

        private ShowApprovalRequestUnblockBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowApprovalRequestUnblockBottomSheet);
        }

        public int hashCode() {
            return 1060869044;
        }

        public String toString() {
            return "ShowApprovalRequestUnblockBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowCommitmentDeactivationScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f121169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f121170b;

        public ShowCommitmentDeactivationScreen(int i3, long j3) {
            super(null);
            this.f121169a = i3;
            this.f121170b = j3;
        }

        public final long a() {
            return this.f121170b;
        }

        public final int b() {
            return this.f121169a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowCommitmentDeactivationScreen)) {
                return false;
            }
            ShowCommitmentDeactivationScreen showCommitmentDeactivationScreen = (ShowCommitmentDeactivationScreen) obj;
            return this.f121169a == showCommitmentDeactivationScreen.f121169a && this.f121170b == showCommitmentDeactivationScreen.f121170b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f121169a) * 31) + Long.hashCode(this.f121170b);
        }

        public String toString() {
            return "ShowCommitmentDeactivationScreen(deactivationTimeInMinutes=" + this.f121169a + ", activeSinceMillis=" + this.f121170b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowEmailConsentScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowEmailConsentScreen f121171a = new ShowEmailConsentScreen();

        private ShowEmailConsentScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowEmailConsentScreen);
        }

        public int hashCode() {
            return 1079566306;
        }

        public String toString() {
            return "ShowEmailConsentScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInfoDialog extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f121173b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInfoDialog(String title, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.f121172a = title;
            this.f121173b = message;
        }

        public final String a() {
            return this.f121173b;
        }

        public final String b() {
            return this.f121172a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInfoDialog)) {
                return false;
            }
            ShowInfoDialog showInfoDialog = (ShowInfoDialog) obj;
            return Intrinsics.areEqual(this.f121172a, showInfoDialog.f121172a) && Intrinsics.areEqual(this.f121173b, showInfoDialog.f121173b);
        }

        public int hashCode() {
            return (this.f121172a.hashCode() * 31) + this.f121173b.hashCode();
        }

        public String toString() {
            return "ShowInfoDialog(title=" + this.f121172a + ", message=" + this.f121173b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowLearnMoreScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowLearnMoreScreen f121174a = new ShowLearnMoreScreen();

        private ShowLearnMoreScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowLearnMoreScreen);
        }

        public int hashCode() {
            return -686518387;
        }

        public String toString() {
            return "ShowLearnMoreScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowLimitScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f121175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f121176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f121177c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowLimitScreen(PremiumFeature premiumFeature, String entrancesDetail, String entrances) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            Intrinsics.checkNotNullParameter(entrances, "entrances");
            this.f121175a = premiumFeature;
            this.f121176b = entrancesDetail;
            this.f121177c = entrances;
        }

        public final String a() {
            return this.f121177c;
        }

        public final String b() {
            return this.f121176b;
        }

        public final PremiumFeature c() {
            return this.f121175a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowLimitScreen)) {
                return false;
            }
            ShowLimitScreen showLimitScreen = (ShowLimitScreen) obj;
            return this.f121175a == showLimitScreen.f121175a && Intrinsics.areEqual(this.f121176b, showLimitScreen.f121176b) && Intrinsics.areEqual(this.f121177c, showLimitScreen.f121177c);
        }

        public int hashCode() {
            return (((this.f121175a.hashCode() * 31) + this.f121176b.hashCode()) * 31) + this.f121177c.hashCode();
        }

        public String toString() {
            return "ShowLimitScreen(premiumFeature=" + this.f121175a + ", entrancesDetail=" + this.f121176b + ", entrances=" + this.f121177c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowMaximumTimerValueReached extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f121178a;

        public ShowMaximumTimerValueReached(int i3) {
            super(null);
            this.f121178a = i3;
        }

        public final int a() {
            return this.f121178a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowMaximumTimerValueReached) && this.f121178a == ((ShowMaximumTimerValueReached) obj).f121178a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f121178a);
        }

        public String toString() {
            return "ShowMaximumTimerValueReached(maximumDays=" + this.f121178a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowOptionsScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f121179a;

        public ShowOptionsScreen(boolean z2) {
            super(null);
            this.f121179a = z2;
        }

        public final boolean a() {
            return this.f121179a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowOptionsScreen) && this.f121179a == ((ShowOptionsScreen) obj).f121179a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f121179a);
        }

        public String toString() {
            return "ShowOptionsScreen(isInactive=" + this.f121179a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionActivity extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f121180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PermissionRequestReason f121181b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionActivity(List missingPermissions, PermissionRequestReason requestReason) {
            super(null);
            Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
            Intrinsics.checkNotNullParameter(requestReason, "requestReason");
            this.f121180a = missingPermissions;
            this.f121181b = requestReason;
        }

        public final List a() {
            return this.f121180a;
        }

        public final PermissionRequestReason b() {
            return this.f121181b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionActivity)) {
                return false;
            }
            ShowPermissionActivity showPermissionActivity = (ShowPermissionActivity) obj;
            return Intrinsics.areEqual(this.f121180a, showPermissionActivity.f121180a) && this.f121181b == showPermissionActivity.f121181b;
        }

        public int hashCode() {
            return (this.f121180a.hashCode() * 31) + this.f121181b.hashCode();
        }

        public String toString() {
            return "ShowPermissionActivity(missingPermissions=" + this.f121180a + ", requestReason=" + this.f121181b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPinCodeScreen extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictMode3ViewModel.PinCodeScreenType f121182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f121183b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPinCodeScreen(StrictMode3ViewModel.PinCodeScreenType screenType, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            this.f121182a = screenType;
            this.f121183b = z2;
        }

        public final StrictMode3ViewModel.PinCodeScreenType a() {
            return this.f121182a;
        }

        public final boolean b() {
            return this.f121183b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPinCodeScreen)) {
                return false;
            }
            ShowPinCodeScreen showPinCodeScreen = (ShowPinCodeScreen) obj;
            return this.f121182a == showPinCodeScreen.f121182a && this.f121183b == showPinCodeScreen.f121183b;
        }

        public int hashCode() {
            return (this.f121182a.hashCode() * 31) + Boolean.hashCode(this.f121183b);
        }

        public String toString() {
            return "ShowPinCodeScreen(screenType=" + this.f121182a + ", withPause=" + this.f121183b + ")";
        }

        public /* synthetic */ ShowPinCodeScreen(StrictMode3ViewModel.PinCodeScreenType pinCodeScreenType, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(pinCodeScreenType, (i3 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSignInBeforeActivate extends StrictMode3ViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f121184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f121185b;

        public ShowSignInBeforeActivate(boolean z2, boolean z3) {
            super(null);
            this.f121184a = z2;
            this.f121185b = z3;
        }

        public final boolean a() {
            return this.f121185b;
        }

        public final boolean b() {
            return this.f121184a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowSignInBeforeActivate)) {
                return false;
            }
            ShowSignInBeforeActivate showSignInBeforeActivate = (ShowSignInBeforeActivate) obj;
            return this.f121184a == showSignInBeforeActivate.f121184a && this.f121185b == showSignInBeforeActivate.f121185b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f121184a) * 31) + Boolean.hashCode(this.f121185b);
        }

        public String toString() {
            return "ShowSignInBeforeActivate(requireSignIn=" + this.f121184a + ", requirePremium=" + this.f121185b + ")";
        }
    }

    public /* synthetic */ StrictMode3ViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictMode3ViewCommand() {
    }
}
