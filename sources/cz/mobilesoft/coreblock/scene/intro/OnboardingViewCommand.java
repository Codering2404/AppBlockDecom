package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class OnboardingViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToExplanation1 extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnboardingHelpItem f104504a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToExplanation1(OnboardingHelpItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.f104504a = item;
        }

        public final OnboardingHelpItem a() {
            return this.f104504a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToExplanation1) && Intrinsics.areEqual(this.f104504a, ((NavigateToExplanation1) obj).f104504a);
        }

        public int hashCode() {
            return this.f104504a.hashCode();
        }

        public String toString() {
            return "NavigateToExplanation1(item=" + this.f104504a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToFeaturesOverview extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToFeaturesOverview f104505a = new NavigateToFeaturesOverview();

        private NavigateToFeaturesOverview() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToFeaturesOverview);
        }

        public int hashCode() {
            return -1514174412;
        }

        public String toString() {
            return "NavigateToFeaturesOverview";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToPrivacyExplanation extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToPrivacyExplanation f104506a = new NavigateToPrivacyExplanation();

        private NavigateToPrivacyExplanation() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToPrivacyExplanation);
        }

        public int hashCode() {
            return -531313329;
        }

        public String toString() {
            return "NavigateToPrivacyExplanation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToReport extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToReport f104507a = new NavigateToReport();

        private NavigateToReport() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToReport);
        }

        public int hashCode() {
            return -305057262;
        }

        public String toString() {
            return "NavigateToReport";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToStatsExplanation1 extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToStatsExplanation1 f104508a = new NavigateToStatsExplanation1();

        private NavigateToStatsExplanation1() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToStatsExplanation1);
        }

        public int hashCode() {
            return 1618748377;
        }

        public String toString() {
            return "NavigateToStatsExplanation1";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToStatsQuestion2 extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToStatsQuestion2 f104509a = new NavigateToStatsQuestion2();

        private NavigateToStatsQuestion2() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToStatsQuestion2);
        }

        public int hashCode() {
            return 2053602827;
        }

        public String toString() {
            return "NavigateToStatsQuestion2";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenDashboard extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenDashboard f104510a = new OpenDashboard();

        private OpenDashboard() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenDashboard);
        }

        public int hashCode() {
            return 1464658616;
        }

        public String toString() {
            return "OpenDashboard";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenNewIntroPremiumScreen extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenNewIntroPremiumScreen f104511a = new OpenNewIntroPremiumScreen();

        private OpenNewIntroPremiumScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenNewIntroPremiumScreen);
        }

        public int hashCode() {
            return -295772549;
        }

        public String toString() {
            return "OpenNewIntroPremiumScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenQuickBlockSetup extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f104512a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenQuickBlockSetup(List recommendedApps) {
            super(null);
            Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
            this.f104512a = recommendedApps;
        }

        public final List a() {
            return this.f104512a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenQuickBlockSetup) && Intrinsics.areEqual(this.f104512a, ((OpenQuickBlockSetup) obj).f104512a);
        }

        public int hashCode() {
            return this.f104512a.hashCode();
        }

        public String toString() {
            return "OpenQuickBlockSetup(recommendedApps=" + this.f104512a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenScheduleSetup extends OnboardingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenScheduleSetup f104513a = new OpenScheduleSetup();

        private OpenScheduleSetup() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenScheduleSetup);
        }

        public int hashCode() {
            return 1242500170;
        }

        public String toString() {
            return "OpenScheduleSetup";
        }
    }

    public /* synthetic */ OnboardingViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingViewCommand() {
    }
}
