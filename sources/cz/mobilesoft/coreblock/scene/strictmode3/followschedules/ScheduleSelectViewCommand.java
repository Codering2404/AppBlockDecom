package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import java.util.Arrays;
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
public abstract class ScheduleSelectViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCreateNewScheduleClicked extends ScheduleSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCreateNewScheduleClicked f122051a = new OnCreateNewScheduleClicked();

        private OnCreateNewScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCreateNewScheduleClicked);
        }

        public int hashCode() {
            return 522200285;
        }

        public String toString() {
            return "OnCreateNewScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends ScheduleSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f122052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f122053b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSaveClicked(long[] scheduleIds, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f122052a = scheduleIds;
            this.f122053b = blockingMode;
        }

        public final AccessMethodConfiguration.Schedules.SchedulesBlockingMode a() {
            return this.f122053b;
        }

        public final long[] b() {
            return this.f122052a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSaveClicked)) {
                return false;
            }
            OnSaveClicked onSaveClicked = (OnSaveClicked) obj;
            return Intrinsics.areEqual(this.f122052a, onSaveClicked.f122052a) && this.f122053b == onSaveClicked.f122053b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f122052a) * 31) + this.f122053b.hashCode();
        }

        public String toString() {
            return "OnSaveClicked(scheduleIds=" + Arrays.toString(this.f122052a) + ", blockingMode=" + this.f122053b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeActive extends ScheduleSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeActive f122054a = new OnStrictModeActive();

        private OnStrictModeActive() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeActive);
        }

        public int hashCode() {
            return 849435171;
        }

        public String toString() {
            return "OnStrictModeActive";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInfoDialog extends ScheduleSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f122055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f122056b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInfoDialog(String title, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.f122055a = title;
            this.f122056b = message;
        }

        public final String a() {
            return this.f122056b;
        }

        public final String b() {
            return this.f122055a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInfoDialog)) {
                return false;
            }
            ShowInfoDialog showInfoDialog = (ShowInfoDialog) obj;
            return Intrinsics.areEqual(this.f122055a, showInfoDialog.f122055a) && Intrinsics.areEqual(this.f122056b, showInfoDialog.f122056b);
        }

        public int hashCode() {
            return (this.f122055a.hashCode() * 31) + this.f122056b.hashCode();
        }

        public String toString() {
            return "ShowInfoDialog(title=" + this.f122055a + ", message=" + this.f122056b + ")";
        }
    }

    public /* synthetic */ ScheduleSelectViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ScheduleSelectViewCommand() {
    }
}
