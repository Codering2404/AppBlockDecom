package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class TimeNudgeSettingsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAppPicker extends TimeNudgeSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f110278a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenAppPicker(List selectedPackageNames) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedPackageNames, "selectedPackageNames");
            this.f110278a = selectedPackageNames;
        }

        public final List a() {
            return this.f110278a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenAppPicker) && Intrinsics.areEqual(this.f110278a, ((OpenAppPicker) obj).f110278a);
        }

        public int hashCode() {
            return this.f110278a.hashCode();
        }

        public String toString() {
            return "OpenAppPicker(selectedPackageNames=" + this.f110278a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestPermissions extends TimeNudgeSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f110279a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestPermissions(List permissions) {
            super(null);
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            this.f110279a = permissions;
        }

        public final List a() {
            return this.f110279a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestPermissions) && Intrinsics.areEqual(this.f110279a, ((RequestPermissions) obj).f110279a);
        }

        public int hashCode() {
            return this.f110279a.hashCode();
        }

        public String toString() {
            return "RequestPermissions(permissions=" + this.f110279a + ")";
        }
    }

    public /* synthetic */ TimeNudgeSettingsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimeNudgeSettingsViewCommand() {
    }
}
