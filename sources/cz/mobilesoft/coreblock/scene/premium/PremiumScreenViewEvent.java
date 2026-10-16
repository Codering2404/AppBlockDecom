package cz.mobilesoft.coreblock.scene.premium;

import android.app.Activity;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
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
public abstract class PremiumScreenViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ManageSubscriptionClicked extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ManageSubscriptionClicked f112350a = new ManageSubscriptionClicked();

        private ManageSubscriptionClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ManageSubscriptionClicked);
        }

        public int hashCode() {
            return 795602861;
        }

        public String toString() {
            return "ManageSubscriptionClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnExitPaywallDialogDismissed extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnExitPaywallDialogDismissed f112351a = new OnExitPaywallDialogDismissed();

        private OnExitPaywallDialogDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnExitPaywallDialogDismissed);
        }

        public int hashCode() {
            return 1162641764;
        }

        public String toString() {
            return "OnExitPaywallDialogDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFinishClicked extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFinishClicked f112352a = new OnFinishClicked();

        private OnFinishClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFinishClicked);
        }

        public int hashCode() {
            return 8027005;
        }

        public String toString() {
            return "OnFinishClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOptionSelected extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumOptionDTO f112353a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnOptionSelected(PremiumOptionDTO selectedOption) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedOption, "selectedOption");
            this.f112353a = selectedOption;
        }

        public final PremiumOptionDTO a() {
            return this.f112353a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOptionSelected) && Intrinsics.areEqual(this.f112353a, ((OnOptionSelected) obj).f112353a);
        }

        public int hashCode() {
            return this.f112353a.hashCode();
        }

        public String toString() {
            return "OnOptionSelected(selectedOption=" + this.f112353a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOtherOptionsBottomSheetHidden extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOtherOptionsBottomSheetHidden f112354a = new OnOtherOptionsBottomSheetHidden();

        private OnOtherOptionsBottomSheetHidden() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOtherOptionsBottomSheetHidden);
        }

        public int hashCode() {
            return -1363550631;
        }

        public String toString() {
            return "OnOtherOptionsBottomSheetHidden";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOtherOptionsClicked extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOtherOptionsClicked f112355a = new OnOtherOptionsClicked();

        private OnOtherOptionsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOtherOptionsClicked);
        }

        public int hashCode() {
            return -2146374782;
        }

        public String toString() {
            return "OnOtherOptionsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumCodeRedeemed extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPremiumCodeRedeemed f112356a = new OnPremiumCodeRedeemed();

        private OnPremiumCodeRedeemed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPremiumCodeRedeemed);
        }

        public int hashCode() {
            return 1431282920;
        }

        public String toString() {
            return "OnPremiumCodeRedeemed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPurchase extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f112357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PremiumOptionDTO f112358b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPurchase(Activity activity, PremiumOptionDTO premiumOptionDTO) {
            super(null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f112357a = activity;
            this.f112358b = premiumOptionDTO;
        }

        public final Activity a() {
            return this.f112357a;
        }

        public final PremiumOptionDTO b() {
            return this.f112358b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnPurchase)) {
                return false;
            }
            OnPurchase onPurchase = (OnPurchase) obj;
            return Intrinsics.areEqual(this.f112357a, onPurchase.f112357a) && Intrinsics.areEqual(this.f112358b, onPurchase.f112358b);
        }

        public int hashCode() {
            int iHashCode = this.f112357a.hashCode() * 31;
            PremiumOptionDTO premiumOptionDTO = this.f112358b;
            return iHashCode + (premiumOptionDTO == null ? 0 : premiumOptionDTO.hashCode());
        }

        public String toString() {
            return "OnPurchase(activity=" + this.f112357a + ", selectedOption=" + this.f112358b + ")";
        }

        public /* synthetic */ OnPurchase(Activity activity, PremiumOptionDTO premiumOptionDTO, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(activity, (i3 & 2) != 0 ? null : premiumOptionDTO);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReloadProducts extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReloadProducts f112359a = new OnReloadProducts();

        private OnReloadProducts() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReloadProducts);
        }

        public int hashCode() {
            return 1762648020;
        }

        public String toString() {
            return "OnReloadProducts";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShareReferralLinkClicked extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShareReferralLinkClicked f112360a = new OnShareReferralLinkClicked();

        private OnShareReferralLinkClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShareReferralLinkClicked);
        }

        public int hashCode() {
            return 1963610504;
        }

        public String toString() {
            return "OnShareReferralLinkClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShared extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShared f112361a = new OnShared();

        private OnShared() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShared);
        }

        public int hashCode() {
            return -1189403364;
        }

        public String toString() {
            return "OnShared";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTrialToggleClicked extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f112362a;

        public OnTrialToggleClicked(boolean z2) {
            super(null);
            this.f112362a = z2;
        }

        public final boolean a() {
            return this.f112362a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTrialToggleClicked) && this.f112362a == ((OnTrialToggleClicked) obj).f112362a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f112362a);
        }

        public String toString() {
            return "OnTrialToggleClicked(enabled=" + this.f112362a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTryAgain extends PremiumScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTryAgain f112363a = new OnTryAgain();

        private OnTryAgain() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTryAgain);
        }

        public int hashCode() {
            return 2114487644;
        }

        public String toString() {
            return "OnTryAgain";
        }
    }

    public /* synthetic */ PremiumScreenViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PremiumScreenViewEvent() {
    }
}
