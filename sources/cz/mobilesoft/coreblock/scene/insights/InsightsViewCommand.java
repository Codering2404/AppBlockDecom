package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
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
public abstract class InsightsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CreateNewSchedule extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f102660a;

        public CreateNewSchedule(List list) {
            super(null);
            this.f102660a = list;
        }

        public final List a() {
            return this.f102660a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CreateNewSchedule) && Intrinsics.areEqual(this.f102660a, ((CreateNewSchedule) obj).f102660a);
        }

        public int hashCode() {
            List list = this.f102660a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "CreateNewSchedule(applicationList=" + this.f102660a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DismissBottomSheet extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DismissBottomSheet f102661a = new DismissBottomSheet();

        private DismissBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof DismissBottomSheet);
        }

        public int hashCode() {
            return -1449130957;
        }

        public String toString() {
            return "DismissBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAppFeel extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenAppFeel f102662a = new OpenAppFeel();

        private OpenAppFeel() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenAppFeel);
        }

        public int hashCode() {
            return 765337268;
        }

        public String toString() {
            return "OpenAppFeel";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScrollToMoodCheckIn extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScrollToMoodCheckIn f102663a = new ScrollToMoodCheckIn();

        private ScrollToMoodCheckIn() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ScrollToMoodCheckIn);
        }

        public int hashCode() {
            return 1432073221;
        }

        public String toString() {
            return "ScrollToMoodCheckIn";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAppBlockWarningDialog extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAppBlockWarningDialog f102664a = new ShowAppBlockWarningDialog();

        private ShowAppBlockWarningDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAppBlockWarningDialog);
        }

        public int hashCode() {
            return 1542323762;
        }

        public String toString() {
            return "ShowAppBlockWarningDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowExcludedAppsBottomSheet extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowExcludedAppsBottomSheet f102665a = new ShowExcludedAppsBottomSheet();

        private ShowExcludedAppsBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowExcludedAppsBottomSheet);
        }

        public int hashCode() {
            return 1969864754;
        }

        public String toString() {
            return "ShowExcludedAppsBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowExcludedPremiumCard extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowExcludedPremiumCard f102666a = new ShowExcludedPremiumCard();

        private ShowExcludedPremiumCard() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowExcludedPremiumCard);
        }

        public int hashCode() {
            return -689092073;
        }

        public String toString() {
            return "ShowExcludedPremiumCard";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowMoodCheckInDisableDialog extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowMoodCheckInDisableDialog f102667a = new ShowMoodCheckInDisableDialog();

        private ShowMoodCheckInDisableDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowMoodCheckInDisableDialog);
        }

        public int hashCode() {
            return -894254944;
        }

        public String toString() {
            return "ShowMoodCheckInDisableDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumScreen extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f102668a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumScreen(PremiumFeature premiumFeature) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            this.f102668a = premiumFeature;
        }

        public final PremiumFeature a() {
            return this.f102668a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPremiumScreen) && this.f102668a == ((ShowPremiumScreen) obj).f102668a;
        }

        public int hashCode() {
            return this.f102668a.hashCode();
        }

        public String toString() {
            return "ShowPremiumScreen(premiumFeature=" + this.f102668a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f102669a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f102669a = text;
        }

        public final String a() {
            return this.f102669a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f102669a, ((ShowSnackBar) obj).f102669a);
        }

        public int hashCode() {
            return this.f102669a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(text=" + this.f102669a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStrictModeActive extends InsightsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowStrictModeActive f102670a = new ShowStrictModeActive();

        private ShowStrictModeActive() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowStrictModeActive);
        }

        public int hashCode() {
            return 1097188408;
        }

        public String toString() {
            return "ShowStrictModeActive";
        }
    }

    public /* synthetic */ InsightsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InsightsViewCommand() {
    }
}
