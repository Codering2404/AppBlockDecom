package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
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
public abstract class LockViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContactReason f105442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f105443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f105444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f105445d;

        public CloseCommand(ContactReason contactReason, boolean z2, boolean z3, boolean z4) {
            super(null);
            this.f105442a = contactReason;
            this.f105443b = z2;
            this.f105444c = z3;
            this.f105445d = z4;
        }

        public final ContactReason a() {
            return this.f105442a;
        }

        public final boolean b() {
            return this.f105445d;
        }

        public final boolean c() {
            return this.f105444c;
        }

        public final boolean d() {
            return this.f105443b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloseCommand)) {
                return false;
            }
            CloseCommand closeCommand = (CloseCommand) obj;
            return this.f105442a == closeCommand.f105442a && this.f105443b == closeCommand.f105443b && this.f105444c == closeCommand.f105444c && this.f105445d == closeCommand.f105445d;
        }

        public int hashCode() {
            ContactReason contactReason = this.f105442a;
            return ((((((contactReason == null ? 0 : contactReason.hashCode()) * 31) + Boolean.hashCode(this.f105443b)) * 31) + Boolean.hashCode(this.f105444c)) * 31) + Boolean.hashCode(this.f105445d);
        }

        public String toString() {
            return "CloseCommand(contactReason=" + this.f105442a + ", showRatingDialog=" + this.f105443b + ", showBackdoorFeedback=" + this.f105444c + ", openBlockingPreferences=" + this.f105445d + ")";
        }

        public /* synthetic */ CloseCommand(ContactReason contactReason, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : contactReason, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAllowAppBottomSheet extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAllowAppBottomSheet f105446a = new ShowAllowAppBottomSheet();

        private ShowAllowAppBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAllowAppBottomSheet);
        }

        public int hashCode() {
            return 1767634146;
        }

        public String toString() {
            return "ShowAllowAppBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAvailableSettingsDialog extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAvailableSettingsDialog f105447a = new ShowAvailableSettingsDialog();

        private ShowAvailableSettingsDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAvailableSettingsDialog);
        }

        public int hashCode() {
            return 1836663706;
        }

        public String toString() {
            return "ShowAvailableSettingsDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowBackdoorCodeDialog extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowBackdoorCodeDialog f105448a = new ShowBackdoorCodeDialog();

        private ShowBackdoorCodeDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowBackdoorCodeDialog);
        }

        public int hashCode() {
            return -1555598428;
        }

        public String toString() {
            return "ShowBackdoorCodeDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowCampaignActivityCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f105449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CampaignSource f105450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f105451c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowCampaignActivityCommand(long j3, CampaignSource campaignSource, String source) {
            super(null);
            Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
            Intrinsics.checkNotNullParameter(source, "source");
            this.f105449a = j3;
            this.f105450b = campaignSource;
            this.f105451c = source;
        }

        public final CampaignSource a() {
            return this.f105450b;
        }

        public final long b() {
            return this.f105449a;
        }

        public final String c() {
            return this.f105451c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowCustomBlockingScreen extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowCustomBlockingScreen f105452a = new ShowCustomBlockingScreen();

        private ShowCustomBlockingScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowCustomBlockingScreen);
        }

        public int hashCode() {
            return -1721230484;
        }

        public String toString() {
            return "ShowCustomBlockingScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowFeedbackFormCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContactReason f105453a;

        public final ContactReason a() {
            return this.f105453a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowFeedbackFormCommand) && this.f105453a == ((ShowFeedbackFormCommand) obj).f105453a;
        }

        public int hashCode() {
            return this.f105453a.hashCode();
        }

        public String toString() {
            return "ShowFeedbackFormCommand(reason=" + this.f105453a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInAppUpdateCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f105454a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInAppUpdateCommand(String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.f105454a = source;
        }

        public final String a() {
            return this.f105454a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInterstitialAd extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowInterstitialAd f105455a = new ShowInterstitialAd();

        private ShowInterstitialAd() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowInterstitialAd);
        }

        public int hashCode() {
            return -1483599735;
        }

        public String toString() {
            return "ShowInterstitialAd";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowIntroScheduleCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowIntroScheduleCommand f105456a = new ShowIntroScheduleCommand();

        private ShowIntroScheduleCommand() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowIntroScheduleCommand);
        }

        public int hashCode() {
            return 1991379266;
        }

        public String toString() {
            return "ShowIntroScheduleCommand";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumDiscountCommand extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RevenueCatPlacement f105457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DiscountSource f105458b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumDiscountCommand(RevenueCatPlacement placement, DiscountSource dSource) {
            super(null);
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(dSource, "dSource");
            this.f105457a = placement;
            this.f105458b = dSource;
        }

        public final DiscountSource a() {
            return this.f105458b;
        }

        public final RevenueCatPlacement b() {
            return this.f105457a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends LockViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f105459a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f105459a = text;
        }

        public final String a() {
            return this.f105459a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f105459a, ((ShowSnackBar) obj).f105459a);
        }

        public int hashCode() {
            return this.f105459a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(text=" + this.f105459a + ")";
        }
    }

    public /* synthetic */ LockViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LockViewCommand() {
    }
}
