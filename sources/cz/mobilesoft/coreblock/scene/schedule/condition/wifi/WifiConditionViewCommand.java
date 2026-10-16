package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class WifiConditionViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CheckLocationServicesAvailable extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CheckLocationServicesAvailable f116034a = new CheckLocationServicesAvailable();

        private CheckLocationServicesAvailable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseScreen extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseScreen f116035a = new CloseScreen();

        private CloseScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestLocationPermissions extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestLocationPermissions f116036a = new RequestLocationPermissions();

        private RequestLocationPermissions() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestManifestPermissions extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f116037a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestManifestPermissions(List permissions) {
            super(null);
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            this.f116037a = permissions;
        }

        public final List a() {
            return this.f116037a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestManifestPermissions) && Intrinsics.areEqual(this.f116037a, ((RequestManifestPermissions) obj).f116037a);
        }

        public int hashCode() {
            return this.f116037a.hashCode();
        }

        public String toString() {
            return "RequestManifestPermissions(permissions=" + this.f116037a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SaveChanges extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConditionDTO.WifisDTO f116038a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SaveChanges(ConditionDTO.WifisDTO wifiCondition) {
            super(null);
            Intrinsics.checkNotNullParameter(wifiCondition, "wifiCondition");
            this.f116038a = wifiCondition;
        }

        public final ConditionDTO.WifisDTO a() {
            return this.f116038a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveChanges) && Intrinsics.areEqual(this.f116038a, ((SaveChanges) obj).f116038a);
        }

        public int hashCode() {
            return this.f116038a.hashCode();
        }

        public String toString() {
            return "SaveChanges(wifiCondition=" + this.f116038a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackbar extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f116039a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackbar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f116039a = text;
        }

        public final String a() {
            return this.f116039a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackbar) && Intrinsics.areEqual(this.f116039a, ((ShowSnackbar) obj).f116039a);
        }

        public int hashCode() {
            return this.f116039a.hashCode();
        }

        public String toString() {
            return "ShowSnackbar(text=" + this.f116039a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUnsavedChangesDialog extends WifiConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowUnsavedChangesDialog f116040a = new ShowUnsavedChangesDialog();

        private ShowUnsavedChangesDialog() {
            super(null);
        }
    }

    public /* synthetic */ WifiConditionViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WifiConditionViewCommand() {
    }
}
