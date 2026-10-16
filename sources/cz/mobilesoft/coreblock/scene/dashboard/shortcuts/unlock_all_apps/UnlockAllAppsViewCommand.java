package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class UnlockAllAppsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Finish extends UnlockAllAppsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Finish f101485a = new Finish();

        private Finish() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Finish);
        }

        public int hashCode() {
            return 1640725279;
        }

        public String toString() {
            return "Finish";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenEmergencyUnlockFeedback extends UnlockAllAppsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenEmergencyUnlockFeedback f101486a = new OpenEmergencyUnlockFeedback();

        private OpenEmergencyUnlockFeedback() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenEmergencyUnlockFeedback);
        }

        public int hashCode() {
            return -471676380;
        }

        public String toString() {
            return "OpenEmergencyUnlockFeedback";
        }
    }

    public /* synthetic */ UnlockAllAppsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UnlockAllAppsViewCommand() {
    }
}
