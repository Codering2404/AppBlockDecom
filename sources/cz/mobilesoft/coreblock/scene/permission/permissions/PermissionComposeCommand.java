package cz.mobilesoft.coreblock.scene.permission.permissions;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import java.util.List;
import kotlin.Metadata;
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
public interface PermissionComposeCommand extends ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishFlow implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f111991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f111992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f111993c;

        public FinishFlow(boolean z2, List skippedPermissions, boolean z3) {
            Intrinsics.checkNotNullParameter(skippedPermissions, "skippedPermissions");
            this.f111991a = z2;
            this.f111992b = skippedPermissions;
            this.f111993c = z3;
        }

        public final boolean a() {
            return this.f111993c;
        }

        public final boolean b() {
            return this.f111991a;
        }

        public final List c() {
            return this.f111992b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FinishFlow)) {
                return false;
            }
            FinishFlow finishFlow = (FinishFlow) obj;
            return this.f111991a == finishFlow.f111991a && Intrinsics.areEqual(this.f111992b, finishFlow.f111992b) && this.f111993c == finishFlow.f111993c;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f111991a) * 31) + this.f111992b.hashCode()) * 31) + Boolean.hashCode(this.f111993c);
        }

        public String toString() {
            return "FinishFlow(resultOk=" + this.f111991a + ", skippedPermissions=" + this.f111992b + ", allowSkippingPermissions=" + this.f111993c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HandlePermissionAction implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionDTO f111994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f111995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f111996c;

        public HandlePermissionAction(PermissionDTO permissionDTO, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(permissionDTO, "permissionDTO");
            this.f111994a = permissionDTO;
            this.f111995b = z2;
            this.f111996c = z3;
        }

        public final PermissionDTO a() {
            return this.f111994a;
        }

        public final boolean b() {
            return this.f111996c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HandlePermissionAction)) {
                return false;
            }
            HandlePermissionAction handlePermissionAction = (HandlePermissionAction) obj;
            return Intrinsics.areEqual(this.f111994a, handlePermissionAction.f111994a) && this.f111995b == handlePermissionAction.f111995b && this.f111996c == handlePermissionAction.f111996c;
        }

        public int hashCode() {
            return (((this.f111994a.hashCode() * 31) + Boolean.hashCode(this.f111995b)) * 31) + Boolean.hashCode(this.f111996c);
        }

        public String toString() {
            return "HandlePermissionAction(permissionDTO=" + this.f111994a + ", allowSkippingPermissions=" + this.f111995b + ", showDetail=" + this.f111996c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateBack implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateBack f111997a = new NavigateBack();

        private NavigateBack() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NavigateBack);
        }

        public int hashCode() {
            return -1512665342;
        }

        public String toString() {
            return "NavigateBack";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToTroubleshooting implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f111998a;

        public NavigateToTroubleshooting(List initialPermissions) {
            Intrinsics.checkNotNullParameter(initialPermissions, "initialPermissions");
            this.f111998a = initialPermissions;
        }

        public final List a() {
            return this.f111998a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToTroubleshooting) && Intrinsics.areEqual(this.f111998a, ((NavigateToTroubleshooting) obj).f111998a);
        }

        public int hashCode() {
            return this.f111998a.hashCode();
        }

        public String toString() {
            return "NavigateToTroubleshooting(initialPermissions=" + this.f111998a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAdvancedProtectionSettings implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenAdvancedProtectionSettings f111999a = new OpenAdvancedProtectionSettings();

        private OpenAdvancedProtectionSettings() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenAdvancedProtectionSettings);
        }

        public int hashCode() {
            return -1348153774;
        }

        public String toString() {
            return "OpenAdvancedProtectionSettings";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenEmailConsentActivity implements PermissionComposeCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenEmailConsentActivity f112000a = new OpenEmailConsentActivity();

        private OpenEmailConsentActivity() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenEmailConsentActivity);
        }

        public int hashCode() {
            return -1430625919;
        }

        public String toString() {
            return "OpenEmailConsentActivity";
        }
    }
}
