package cz.mobilesoft.coreblock.scene.permission.location;

import android.content.ComponentName;
import cz.mobilesoft.coreblock.base.ViewEvent;
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
public interface LocationPermissionEvent extends ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAllPermissionsGranted implements LocationPermissionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAllPermissionsGranted f111846a = new OnAllPermissionsGranted();

        private OnAllPermissionsGranted() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnGoToSettingsClick implements LocationPermissionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ComponentName f111847a;

        public OnGoToSettingsClick(ComponentName componentName) {
            this.f111847a = componentName;
        }

        public final ComponentName a() {
            return this.f111847a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnGoToSettingsClick) && Intrinsics.areEqual(this.f111847a, ((OnGoToSettingsClick) obj).f111847a);
        }

        public int hashCode() {
            ComponentName componentName = this.f111847a;
            if (componentName == null) {
                return 0;
            }
            return componentName.hashCode();
        }

        public String toString() {
            return "OnGoToSettingsClick(componentName=" + this.f111847a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdatePermissionState implements LocationPermissionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUpdatePermissionState f111848a = new OnUpdatePermissionState();

        private OnUpdatePermissionState() {
        }
    }
}
