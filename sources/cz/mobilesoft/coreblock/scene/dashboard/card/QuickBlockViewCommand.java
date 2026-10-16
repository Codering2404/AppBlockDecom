package cz.mobilesoft.coreblock.scene.dashboard.card;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class QuickBlockViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GoToPremiumScreen extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GoToPremiumScreen f100545a = new GoToPremiumScreen();

        private GoToPremiumScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof GoToPremiumScreen);
        }

        public int hashCode() {
            return 1378768641;
        }

        public String toString() {
            return "GoToPremiumScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenEmailConsentActivity extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f100546a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenEmailConsentActivity(String emailConsentSource) {
            super(null);
            Intrinsics.checkNotNullParameter(emailConsentSource, "emailConsentSource");
            this.f100546a = emailConsentSource;
        }

        public final String a() {
            return this.f100546a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenEmailConsentActivity) && Intrinsics.areEqual(this.f100546a, ((OpenEmailConsentActivity) obj).f100546a);
        }

        public int hashCode() {
            return this.f100546a.hashCode();
        }

        public String toString() {
            return "OpenEmailConsentActivity(emailConsentSource=" + this.f100546a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowNoBlockingLevelSelected extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowNoBlockingLevelSelected f100547a = new ShowNoBlockingLevelSelected();

        private ShowNoBlockingLevelSelected() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowNoBlockingLevelSelected);
        }

        public int hashCode() {
            return 1740437997;
        }

        public String toString() {
            return "ShowNoBlockingLevelSelected";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionsBeforeStart extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f100548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f100549b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionsBeforeStart(List missingPermissions, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
            this.f100548a = missingPermissions;
            this.f100549b = j3;
        }

        public final List a() {
            return this.f100548a;
        }

        public final long b() {
            return this.f100549b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionsBeforeStart)) {
                return false;
            }
            ShowPermissionsBeforeStart showPermissionsBeforeStart = (ShowPermissionsBeforeStart) obj;
            return Intrinsics.areEqual(this.f100548a, showPermissionsBeforeStart.f100548a) && this.f100549b == showPermissionsBeforeStart.f100549b;
        }

        public int hashCode() {
            return (this.f100548a.hashCode() * 31) + Long.hashCode(this.f100549b);
        }

        public String toString() {
            return "ShowPermissionsBeforeStart(missingPermissions=" + this.f100548a + ", presetTime=" + this.f100549b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPomodoroScreen extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowPomodoroScreen f100550a = new ShowPomodoroScreen();

        private ShowPomodoroScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowPomodoroScreen);
        }

        public int hashCode() {
            return -1605841007;
        }

        public String toString() {
            return "ShowPomodoroScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumFeatureScreen extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f100551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f100552b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumFeatureScreen(PremiumFeature premiumFeature, String entrancesDetail) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            this.f100551a = premiumFeature;
            this.f100552b = entrancesDetail;
        }

        public final String a() {
            return this.f100552b;
        }

        public final PremiumFeature b() {
            return this.f100551a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPremiumFeatureScreen)) {
                return false;
            }
            ShowPremiumFeatureScreen showPremiumFeatureScreen = (ShowPremiumFeatureScreen) obj;
            return this.f100551a == showPremiumFeatureScreen.f100551a && Intrinsics.areEqual(this.f100552b, showPremiumFeatureScreen.f100552b);
        }

        public int hashCode() {
            return (this.f100551a.hashCode() * 31) + this.f100552b.hashCode();
        }

        public String toString() {
            return "ShowPremiumFeatureScreen(premiumFeature=" + this.f100551a + ", entrancesDetail=" + this.f100552b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowQuickBlockContainsAppBlockError extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowQuickBlockContainsAppBlockError f100553a = new ShowQuickBlockContainsAppBlockError();

        private ShowQuickBlockContainsAppBlockError() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowQuickBlockContainsAppBlockError);
        }

        public int hashCode() {
            return -115352319;
        }

        public String toString() {
            return "ShowQuickBlockContainsAppBlockError";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f100554a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f100554a = text;
        }

        public final String a() {
            return this.f100554a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f100554a, ((ShowSnackBar) obj).f100554a);
        }

        public int hashCode() {
            return this.f100554a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(text=" + this.f100554a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStopDialog extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowStopDialog f100555a = new ShowStopDialog();

        private ShowStopDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowStopDialog);
        }

        public int hashCode() {
            return -91346874;
        }

        public String toString() {
            return "ShowStopDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStrictModeActiveDialog extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100556a;

        public ShowStrictModeActiveDialog(long j3) {
            super(null);
            this.f100556a = j3;
        }

        public final long a() {
            return this.f100556a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowStrictModeActiveDialog) && this.f100556a == ((ShowStrictModeActiveDialog) obj).f100556a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100556a);
        }

        public String toString() {
            return "ShowStrictModeActiveDialog(presetTime=" + this.f100556a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimeSelectBottomSheet extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowTimeSelectBottomSheet f100557a = new ShowTimeSelectBottomSheet();

        private ShowTimeSelectBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowTimeSelectBottomSheet);
        }

        public int hashCode() {
            return -1082056145;
        }

        public String toString() {
            return "ShowTimeSelectBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimeSelectScreen extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f100558a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowTimeSelectScreen(List history) {
            super(null);
            Intrinsics.checkNotNullParameter(history, "history");
            this.f100558a = history;
        }

        public final List a() {
            return this.f100558a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowTimeSelectScreen) && Intrinsics.areEqual(this.f100558a, ((ShowTimeSelectScreen) obj).f100558a);
        }

        public int hashCode() {
            return this.f100558a.hashCode();
        }

        public String toString() {
            return "ShowTimeSelectScreen(history=" + this.f100558a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimerUpsellDialog extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowTimerUpsellDialog f100559a = new ShowTimerUpsellDialog();

        private ShowTimerUpsellDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowTimerUpsellDialog);
        }

        public int hashCode() {
            return 677001246;
        }

        public String toString() {
            return "ShowTimerUpsellDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TryToShowInterstitialAd extends QuickBlockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumState f100560a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TryToShowInterstitialAd(PremiumState premiumState) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f100560a = premiumState;
        }

        public final PremiumState a() {
            return this.f100560a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TryToShowInterstitialAd) && Intrinsics.areEqual(this.f100560a, ((TryToShowInterstitialAd) obj).f100560a);
        }

        public int hashCode() {
            return this.f100560a.hashCode();
        }

        public String toString() {
            return "TryToShowInterstitialAd(premiumState=" + this.f100560a + ")";
        }
    }

    public /* synthetic */ QuickBlockViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QuickBlockViewCommand() {
    }
}
