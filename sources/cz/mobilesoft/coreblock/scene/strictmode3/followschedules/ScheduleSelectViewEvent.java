package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
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
public abstract class ScheduleSelectViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockingModeSelected extends ScheduleSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f122057a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlockingModeSelected(AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f122057a = blockingMode;
        }

        public final AccessMethodConfiguration.Schedules.SchedulesBlockingMode a() {
            return this.f122057a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BlockingModeSelected) && this.f122057a == ((BlockingModeSelected) obj).f122057a;
        }

        public int hashCode() {
            return this.f122057a.hashCode();
        }

        public String toString() {
            return "BlockingModeSelected(blockingMode=" + this.f122057a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfirmButtonClicked extends ScheduleSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnConfirmButtonClicked f122058a = new OnConfirmButtonClicked();

        private OnConfirmButtonClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleClicked extends ScheduleSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f122059a;

        public OnScheduleClicked(long j3) {
            super(null);
            this.f122059a = j3;
        }

        public final long a() {
            return this.f122059a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleClicked) && this.f122059a == ((OnScheduleClicked) obj).f122059a;
        }

        public int hashCode() {
            return Long.hashCode(this.f122059a);
        }

        public String toString() {
            return "OnScheduleClicked(scheduleId=" + this.f122059a + ")";
        }
    }

    public /* synthetic */ ScheduleSelectViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ScheduleSelectViewEvent() {
    }
}
