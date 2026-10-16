package cz.mobilesoft.coreblock.scene.permission.permissions;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
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
public interface PermissionComposeEvent extends ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessibilityDisclaimerConfirmed implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAccessibilityDisclaimerConfirmed f112001a = new OnAccessibilityDisclaimerConfirmed();

        private OnAccessibilityDisclaimerConfirmed() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAccessibilityDisclaimerConfirmed);
        }

        public int hashCode() {
            return -2116466832;
        }

        public String toString() {
            return "OnAccessibilityDisclaimerConfirmed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessibilityDisclaimerDismissed implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAccessibilityDisclaimerDismissed f112002a = new OnAccessibilityDisclaimerDismissed();

        private OnAccessibilityDisclaimerDismissed() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAccessibilityDisclaimerDismissed);
        }

        public int hashCode() {
            return -1152890694;
        }

        public String toString() {
            return "OnAccessibilityDisclaimerDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAdvancedProtectionStepClick implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAdvancedProtectionStepClick f112003a = new OnAdvancedProtectionStepClick();

        private OnAdvancedProtectionStepClick() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAdvancedProtectionStepClick);
        }

        public int hashCode() {
            return -1158589465;
        }

        public String toString() {
            return "OnAdvancedProtectionStepClick";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDeviceAdminGranted implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDeviceAdminGranted f112004a = new OnDeviceAdminGranted();

        private OnDeviceAdminGranted() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDeviceAdminGranted);
        }

        public int hashCode() {
            return -528408836;
        }

        public String toString() {
            return "OnDeviceAdminGranted";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnError implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnError f112005a = new OnError();

        private OnError() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnError);
        }

        public int hashCode() {
            return 391878318;
        }

        public String toString() {
            return "OnError";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLocationFallback implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionDTO f112006a;

        public OnLocationFallback(PermissionDTO permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            this.f112006a = permission;
        }

        public final PermissionDTO a() {
            return this.f112006a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLocationFallback) && Intrinsics.areEqual(this.f112006a, ((OnLocationFallback) obj).f112006a);
        }

        public int hashCode() {
            return this.f112006a.hashCode();
        }

        public String toString() {
            return "OnLocationFallback(permission=" + this.f112006a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionClick implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionDTO f112007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f112008b;

        public OnPermissionClick(PermissionDTO permission, boolean z2) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            this.f112007a = permission;
            this.f112008b = z2;
        }

        public final PermissionDTO a() {
            return this.f112007a;
        }

        public final boolean b() {
            return this.f112008b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnPermissionClick)) {
                return false;
            }
            OnPermissionClick onPermissionClick = (OnPermissionClick) obj;
            return Intrinsics.areEqual(this.f112007a, onPermissionClick.f112007a) && this.f112008b == onPermissionClick.f112008b;
        }

        public int hashCode() {
            return (this.f112007a.hashCode() * 31) + Boolean.hashCode(this.f112008b);
        }

        public String toString() {
            return "OnPermissionClick(permission=" + this.f112007a + ", showDetail=" + this.f112008b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionSkipped implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPermissionSkipped f112009a = new OnPermissionSkipped();

        private OnPermissionSkipped() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPermissionSkipped);
        }

        public int hashCode() {
            return -7021049;
        }

        public String toString() {
            return "OnPermissionSkipped";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPrivacyExplanationClosed implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPrivacyExplanationClosed f112010a = new OnPrivacyExplanationClosed();

        private OnPrivacyExplanationClosed() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPrivacyExplanationClosed);
        }

        public int hashCode() {
            return 1841512407;
        }

        public String toString() {
            return "OnPrivacyExplanationClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResume implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResume f112011a = new OnResume();

        private OnResume() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResume);
        }

        public int hashCode() {
            return -376465337;
        }

        public String toString() {
            return "OnResume";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRuntimePermissionGranted implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRuntimePermissionGranted f112012a = new OnRuntimePermissionGranted();

        private OnRuntimePermissionGranted() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRuntimePermissionGranted);
        }

        public int hashCode() {
            return -354399602;
        }

        public String toString() {
            return "OnRuntimePermissionGranted";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAccessibilityDisclaimer implements PermissionComposeEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAccessibilityDisclaimer f112013a = new OnShowAccessibilityDisclaimer();

        private OnShowAccessibilityDisclaimer() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowAccessibilityDisclaimer);
        }

        public int hashCode() {
            return -866820622;
        }

        public String toString() {
            return "OnShowAccessibilityDisclaimer";
        }
    }
}
