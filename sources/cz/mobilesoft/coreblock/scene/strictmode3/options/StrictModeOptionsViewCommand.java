package cz.mobilesoft.coreblock.scene.strictmode3.options;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
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
public abstract class StrictModeOptionsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends StrictModeOptionsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Close f122294a = new Close();

        private Close() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionActivity extends StrictModeOptionsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f122295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StrictModeOption f122296b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionActivity(List requiredPermissions, StrictModeOption option) {
            super(null);
            Intrinsics.checkNotNullParameter(requiredPermissions, "requiredPermissions");
            Intrinsics.checkNotNullParameter(option, "option");
            this.f122295a = requiredPermissions;
            this.f122296b = option;
        }

        public final StrictModeOption a() {
            return this.f122296b;
        }

        public final List b() {
            return this.f122295a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionActivity)) {
                return false;
            }
            ShowPermissionActivity showPermissionActivity = (ShowPermissionActivity) obj;
            return Intrinsics.areEqual(this.f122295a, showPermissionActivity.f122295a) && this.f122296b == showPermissionActivity.f122296b;
        }

        public int hashCode() {
            return (this.f122295a.hashCode() * 31) + this.f122296b.hashCode();
        }

        public String toString() {
            return "ShowPermissionActivity(requiredPermissions=" + this.f122295a + ", option=" + this.f122296b + ")";
        }
    }

    public /* synthetic */ StrictModeOptionsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeOptionsViewCommand() {
    }
}
