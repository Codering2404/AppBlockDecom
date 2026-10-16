package cz.mobilesoft.coreblock.scene.emergency_unblock;

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
public abstract class EmergencyUnblockViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmergencyUnblockCanceled extends EmergencyUnblockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEmergencyUnblockCanceled f101760a = new OnEmergencyUnblockCanceled();

        private OnEmergencyUnblockCanceled() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEmergencyUnblockCanceled);
        }

        public int hashCode() {
            return 404332460;
        }

        public String toString() {
            return "OnEmergencyUnblockCanceled";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmergencyUnblockClicked extends EmergencyUnblockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEmergencyUnblockClicked f101761a = new OnEmergencyUnblockClicked();

        private OnEmergencyUnblockClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEmergencyUnblockClicked);
        }

        public int hashCode() {
            return 1016088244;
        }

        public String toString() {
            return "OnEmergencyUnblockClicked";
        }
    }

    public /* synthetic */ EmergencyUnblockViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private EmergencyUnblockViewEvent() {
    }
}
