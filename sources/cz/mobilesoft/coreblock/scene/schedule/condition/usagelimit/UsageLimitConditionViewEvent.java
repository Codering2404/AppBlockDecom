package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
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
public abstract class UsageLimitConditionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends UsageLimitConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f115881a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPeriodTypeChanged extends UsageLimitConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UsageLimit.PeriodType f115882a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPeriodTypeChanged(UsageLimit.PeriodType periodType) {
            super(null);
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            this.f115882a = periodType;
        }

        public final UsageLimit.PeriodType a() {
            return this.f115882a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPeriodTypeChanged) && this.f115882a == ((OnPeriodTypeChanged) obj).f115882a;
        }

        public int hashCode() {
            return this.f115882a.hashCode();
        }

        public String toString() {
            return "OnPeriodTypeChanged(periodType=" + this.f115882a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends UsageLimitConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f115883a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimePickerStateChanged extends UsageLimitConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimePickerState f115884a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTimePickerStateChanged(TimePickerState timePickerState) {
            super(null);
            Intrinsics.checkNotNullParameter(timePickerState, "timePickerState");
            this.f115884a = timePickerState;
        }

        public final TimePickerState a() {
            return this.f115884a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimePickerStateChanged) && Intrinsics.areEqual(this.f115884a, ((OnTimePickerStateChanged) obj).f115884a);
        }

        public int hashCode() {
            return this.f115884a.hashCode();
        }

        public String toString() {
            return "OnTimePickerStateChanged(timePickerState=" + this.f115884a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UsageLimitTimeConditionViewEvent extends UsageLimitConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeConditionViewEvent f115885a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsageLimitTimeConditionViewEvent(TimeConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f115885a = event;
        }

        public final TimeConditionViewEvent a() {
            return this.f115885a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UsageLimitTimeConditionViewEvent) && Intrinsics.areEqual(this.f115885a, ((UsageLimitTimeConditionViewEvent) obj).f115885a);
        }

        public int hashCode() {
            return this.f115885a.hashCode();
        }

        public String toString() {
            return "UsageLimitTimeConditionViewEvent(event=" + this.f115885a + ")";
        }
    }

    public /* synthetic */ UsageLimitConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UsageLimitConditionViewEvent() {
    }
}
