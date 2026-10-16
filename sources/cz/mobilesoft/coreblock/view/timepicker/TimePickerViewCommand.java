package cz.mobilesoft.coreblock.view.timepicker;

import cz.mobilesoft.coreblock.base.ViewCommand;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public abstract class TimePickerViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseTimerScreenCommand extends TimePickerViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CloseTimerScreenCommand f133061a = new CloseTimerScreenCommand();

        private CloseTimerScreenCommand() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CloseTimerScreenCommand);
        }

        public int hashCode() {
            return 1676980794;
        }

        public String toString() {
            return "CloseTimerScreenCommand";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowSnackbarCommand extends TimePickerViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f133062a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShowSnackbarCommand(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f133062a = message;
        }

        public final String a() {
            return this.f133062a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnShowSnackbarCommand) && Intrinsics.areEqual(this.f133062a, ((OnShowSnackbarCommand) obj).f133062a);
        }

        public int hashCode() {
            return this.f133062a.hashCode();
        }

        public String toString() {
            return "OnShowSnackbarCommand(message=" + this.f133062a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeUpdatedCommand extends TimePickerViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f133063a;

        public OnTimeUpdatedCommand(long j3) {
            super(null);
            this.f133063a = j3;
        }

        public final long a() {
            return this.f133063a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimeUpdatedCommand) && this.f133063a == ((OnTimeUpdatedCommand) obj).f133063a;
        }

        public int hashCode() {
            return Long.hashCode(this.f133063a);
        }

        public String toString() {
            return "OnTimeUpdatedCommand(timeMillis=" + this.f133063a + ")";
        }
    }

    public /* synthetic */ TimePickerViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimePickerViewCommand() {
    }
}
