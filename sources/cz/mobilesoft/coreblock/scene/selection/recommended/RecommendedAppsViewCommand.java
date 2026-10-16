package cz.mobilesoft.coreblock.scene.selection.recommended;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class RecommendedAppsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishRecommendedApps extends RecommendedAppsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f119187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f119188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f119189c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FinishRecommendedApps(List applications, List websites, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(websites, "websites");
            this.f119187a = applications;
            this.f119188b = websites;
            this.f119189c = z2;
        }

        public final List a() {
            return this.f119187a;
        }

        public final boolean b() {
            return this.f119189c;
        }

        public final List c() {
            return this.f119188b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FinishRecommendedApps)) {
                return false;
            }
            FinishRecommendedApps finishRecommendedApps = (FinishRecommendedApps) obj;
            return Intrinsics.areEqual(this.f119187a, finishRecommendedApps.f119187a) && Intrinsics.areEqual(this.f119188b, finishRecommendedApps.f119188b) && this.f119189c == finishRecommendedApps.f119189c;
        }

        public int hashCode() {
            return (((this.f119187a.hashCode() * 31) + this.f119188b.hashCode()) * 31) + Boolean.hashCode(this.f119189c);
        }

        public String toString() {
            return "FinishRecommendedApps(applications=" + this.f119187a + ", websites=" + this.f119188b + ", seeAll=" + this.f119189c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumFeatureDialog extends RecommendedAppsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f119190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumFeatureDialog(PremiumFeature premiumFeature) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            this.f119190a = premiumFeature;
        }

        public final PremiumFeature a() {
            return this.f119190a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPremiumFeatureDialog) && this.f119190a == ((ShowPremiumFeatureDialog) obj).f119190a;
        }

        public int hashCode() {
            return this.f119190a.hashCode();
        }

        public String toString() {
            return "ShowPremiumFeatureDialog(premiumFeature=" + this.f119190a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowWebsitesBottomSheet extends RecommendedAppsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowWebsitesBottomSheet f119191a = new ShowWebsitesBottomSheet();

        private ShowWebsitesBottomSheet() {
            super(null);
        }
    }

    public /* synthetic */ RecommendedAppsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RecommendedAppsViewCommand() {
    }
}
