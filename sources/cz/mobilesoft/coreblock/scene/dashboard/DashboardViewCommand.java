package cz.mobilesoft.coreblock.scene.dashboard;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
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
public abstract class DashboardViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CheckAdConsent extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CheckAdConsent f99231a = new CheckAdConsent();

        private CheckAdConsent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CheckAdConsent);
        }

        public int hashCode() {
            return 59200804;
        }

        public String toString() {
            return "CheckAdConsent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HandleDeeplink extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f99232a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandleDeeplink(String deeplink) {
            super(null);
            Intrinsics.checkNotNullParameter(deeplink, "deeplink");
            this.f99232a = deeplink;
        }

        public final String a() {
            return this.f99232a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HandleDeeplink) && Intrinsics.areEqual(this.f99232a, ((HandleDeeplink) obj).f99232a);
        }

        public int hashCode() {
            return this.f99232a.hashCode();
        }

        public String toString() {
            return "HandleDeeplink(deeplink=" + this.f99232a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateTo extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DashboardActivity.NavBarItem f99233a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateTo(DashboardActivity.NavBarItem navItem) {
            super(null);
            Intrinsics.checkNotNullParameter(navItem, "navItem");
            this.f99233a = navItem;
        }

        public final DashboardActivity.NavBarItem a() {
            return this.f99233a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.f99233a, ((NavigateTo) obj).f99233a);
        }

        public int hashCode() {
            return this.f99233a.hashCode();
        }

        public String toString() {
            return "NavigateTo(navItem=" + this.f99233a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAutoTrialExpiredPaywall extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAutoTrialExpiredPaywall f99234a = new ShowAutoTrialExpiredPaywall();

        private ShowAutoTrialExpiredPaywall() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAutoTrialExpiredPaywall);
        }

        public int hashCode() {
            return -1671479902;
        }

        public String toString() {
            return "ShowAutoTrialExpiredPaywall";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAutoTrialFlow extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAutoTrialFlow f99235a = new ShowAutoTrialFlow();

        private ShowAutoTrialFlow() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAutoTrialFlow);
        }

        public int hashCode() {
            return 1914546563;
        }

        public String toString() {
            return "ShowAutoTrialFlow";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowCampaignOfferScreen extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f99236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CampaignSource f99237b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowCampaignOfferScreen(long j3, CampaignSource campaignSource) {
            super(null);
            Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
            this.f99236a = j3;
            this.f99237b = campaignSource;
        }

        public final long a() {
            return this.f99236a;
        }

        public final CampaignSource b() {
            return this.f99237b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowCampaignOfferScreen)) {
                return false;
            }
            ShowCampaignOfferScreen showCampaignOfferScreen = (ShowCampaignOfferScreen) obj;
            return this.f99236a == showCampaignOfferScreen.f99236a && this.f99237b == showCampaignOfferScreen.f99237b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f99236a) * 31) + this.f99237b.hashCode();
        }

        public String toString() {
            return "ShowCampaignOfferScreen(campaignId=" + this.f99236a + ", campaignSource=" + this.f99237b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumExpiringFlow extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowPremiumExpiringFlow f99238a = new ShowPremiumExpiringFlow();

        private ShowPremiumExpiringFlow() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowPremiumExpiringFlow);
        }

        public int hashCode() {
            return 1194759151;
        }

        public String toString() {
            return "ShowPremiumExpiringFlow";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowProfileDisabledSuggestStrictModeDialog extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f99239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f99240b;

        public ShowProfileDisabledSuggestStrictModeDialog(long j3, boolean z2) {
            super(null);
            this.f99239a = j3;
            this.f99240b = z2;
        }

        public final boolean a() {
            return this.f99240b;
        }

        public final long b() {
            return this.f99239a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowProfileDisabledSuggestStrictModeDialog)) {
                return false;
            }
            ShowProfileDisabledSuggestStrictModeDialog showProfileDisabledSuggestStrictModeDialog = (ShowProfileDisabledSuggestStrictModeDialog) obj;
            return this.f99239a == showProfileDisabledSuggestStrictModeDialog.f99239a && this.f99240b == showProfileDisabledSuggestStrictModeDialog.f99240b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f99239a) * 31) + Boolean.hashCode(this.f99240b);
        }

        public String toString() {
            return "ShowProfileDisabledSuggestStrictModeDialog(shownCount=" + this.f99239a + ", schedulePaused=" + this.f99240b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowReferralDiscountScreen extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowReferralDiscountScreen f99241a = new ShowReferralDiscountScreen();

        private ShowReferralDiscountScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowReferralDiscountScreen);
        }

        public int hashCode() {
            return 1112310972;
        }

        public String toString() {
            return "ShowReferralDiscountScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTrialRetention extends DashboardViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowTrialRetention f99242a = new ShowTrialRetention();

        private ShowTrialRetention() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowTrialRetention);
        }

        public int hashCode() {
            return -225689254;
        }

        public String toString() {
            return "ShowTrialRetention";
        }
    }

    public /* synthetic */ DashboardViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DashboardViewCommand() {
    }
}
