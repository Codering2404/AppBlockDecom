package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class UnlockAllAppsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfirmUnlock extends UnlockAllAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConfirmUnlock f101487a = new ConfirmUnlock();

        private ConfirmUnlock() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ConfirmUnlock);
        }

        public int hashCode() {
            return -1349153561;
        }

        public String toString() {
            return "ConfirmUnlock";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Dismiss extends UnlockAllAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Dismiss f101488a = new Dismiss();

        private Dismiss() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Dismiss);
        }

        public int hashCode() {
            return -750802035;
        }

        public String toString() {
            return "Dismiss";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestEmergencyUnlock extends UnlockAllAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestEmergencyUnlock f101489a = new RequestEmergencyUnlock();

        private RequestEmergencyUnlock() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof RequestEmergencyUnlock);
        }

        public int hashCode() {
            return 1454003779;
        }

        public String toString() {
            return "RequestEmergencyUnlock";
        }
    }

    public /* synthetic */ UnlockAllAppsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UnlockAllAppsViewEvent() {
    }
}
