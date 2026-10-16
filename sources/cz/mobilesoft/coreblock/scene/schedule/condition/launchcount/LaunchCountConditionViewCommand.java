package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
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
public abstract class LaunchCountConditionViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseScreen extends LaunchCountConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseScreen f115230a = new CloseScreen();

        private CloseScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SaveChanges extends LaunchCountConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConditionDTO.LaunchCountDTO f115231a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SaveChanges(ConditionDTO.LaunchCountDTO condition) {
            super(null);
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.f115231a = condition;
        }

        public final ConditionDTO.LaunchCountDTO a() {
            return this.f115231a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveChanges) && Intrinsics.areEqual(this.f115231a, ((SaveChanges) obj).f115231a);
        }

        public int hashCode() {
            return this.f115231a.hashCode();
        }

        public String toString() {
            return "SaveChanges(condition=" + this.f115231a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackbar extends LaunchCountConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f115232a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackbar(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f115232a = text;
        }

        public final String a() {
            return this.f115232a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackbar) && Intrinsics.areEqual(this.f115232a, ((ShowSnackbar) obj).f115232a);
        }

        public int hashCode() {
            return this.f115232a.hashCode();
        }

        public String toString() {
            return "ShowSnackbar(text=" + this.f115232a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUnsavedChangesDialog extends LaunchCountConditionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowUnsavedChangesDialog f115233a = new ShowUnsavedChangesDialog();

        private ShowUnsavedChangesDialog() {
            super(null);
        }
    }

    public /* synthetic */ LaunchCountConditionViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LaunchCountConditionViewCommand() {
    }
}
