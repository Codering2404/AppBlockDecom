package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
public abstract class BlockingModeSettingsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnContinueClicked extends BlockingModeSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.BlockingMode f115056a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnContinueClicked(Profile.BlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f115056a = blockingMode;
        }

        public final Profile.BlockingMode a() {
            return this.f115056a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnContinueClicked) && this.f115056a == ((OnContinueClicked) obj).f115056a;
        }

        public int hashCode() {
            return this.f115056a.hashCode();
        }

        public String toString() {
            return "OnContinueClicked(blockingMode=" + this.f115056a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenPremiumActivity extends BlockingModeSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenPremiumActivity f115057a = new OpenPremiumActivity();

        private OpenPremiumActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenPremiumActivity);
        }

        public int hashCode() {
            return 872584749;
        }

        public String toString() {
            return "OpenPremiumActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAllowlistDisabledDialog extends BlockingModeSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAllowlistDisabledDialog f115058a = new ShowAllowlistDisabledDialog();

        private ShowAllowlistDisabledDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowAllowlistDisabledDialog);
        }

        public int hashCode() {
            return 735050943;
        }

        public String toString() {
            return "ShowAllowlistDisabledDialog";
        }
    }

    public /* synthetic */ BlockingModeSettingsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingModeSettingsViewCommand() {
    }
}
