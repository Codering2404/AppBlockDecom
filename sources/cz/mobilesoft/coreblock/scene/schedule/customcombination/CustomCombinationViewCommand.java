package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
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
public abstract class CustomCombinationViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CheckLocationServicesAvailable extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CheckLocationServicesAvailable f116263a = new CheckLocationServicesAvailable();

        private CheckLocationServicesAvailable() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CheckLocationServicesAvailable);
        }

        public int hashCode() {
            return -438151782;
        }

        public String toString() {
            return "CheckLocationServicesAvailable";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseScreen extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseScreen f116264a = new CloseScreen();

        private CloseScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CloseScreen);
        }

        public int hashCode() {
            return 582796056;
        }

        public String toString() {
            return "CloseScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToMain extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToMain f116265a = new NavigateToMain();

        private NavigateToMain() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateToMain);
        }

        public int hashCode() {
            return 1683431569;
        }

        public String toString() {
            return "NavigateToMain";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenCondition extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f116266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenCondition(ProfileType profileType) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f116266a = profileType;
        }

        public final ProfileType a() {
            return this.f116266a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenCondition) && this.f116266a == ((OpenCondition) obj).f116266a;
        }

        public int hashCode() {
            return this.f116266a.hashCode();
        }

        public String toString() {
            return "OpenCondition(profileType=" + this.f116266a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestLocationPermissions extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestLocationPermissions f116267a = new RequestLocationPermissions();

        private RequestLocationPermissions() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof RequestLocationPermissions);
        }

        public int hashCode() {
            return -1689169556;
        }

        public String toString() {
            return "RequestLocationPermissions";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestManifestPermissions extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f116268a;

        public final List a() {
            return this.f116268a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestManifestPermissions) && Intrinsics.areEqual(this.f116268a, ((RequestManifestPermissions) obj).f116268a);
        }

        public int hashCode() {
            return this.f116268a.hashCode();
        }

        public String toString() {
            return "RequestManifestPermissions(permissions=" + this.f116268a + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestManifestPermissions(List list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, jlWo.XmtnViae);
            this.f116268a = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SaveChanges extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConditionDTO.CombinationDTO f116269a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SaveChanges(ConditionDTO.CombinationDTO condition) {
            super(null);
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.f116269a = condition;
        }

        public final ConditionDTO.CombinationDTO a() {
            return this.f116269a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveChanges) && Intrinsics.areEqual(this.f116269a, ((SaveChanges) obj).f116269a);
        }

        public int hashCode() {
            return this.f116269a.hashCode();
        }

        public String toString() {
            return "SaveChanges(condition=" + this.f116269a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackbar extends CustomCombinationViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f116270a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackbar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f116270a = text;
        }

        public final String a() {
            return this.f116270a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackbar) && Intrinsics.areEqual(this.f116270a, ((ShowSnackbar) obj).f116270a);
        }

        public int hashCode() {
            return this.f116270a.hashCode();
        }

        public String toString() {
            return "ShowSnackbar(text=" + this.f116270a + ")";
        }
    }

    public /* synthetic */ CustomCombinationViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomCombinationViewCommand() {
    }
}
