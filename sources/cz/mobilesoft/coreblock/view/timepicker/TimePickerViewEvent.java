package cz.mobilesoft.coreblock.view.timepicker;

import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class TimePickerViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateCustomIndexEvent extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133064a;

        public OnUpdateCustomIndexEvent(int i3) {
            super(null);
            this.f133064a = i3;
        }

        public final int a() {
            return this.f133064a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdateCustomIndexEvent) && this.f133064a == ((OnUpdateCustomIndexEvent) obj).f133064a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133064a);
        }

        public String toString() {
            return "OnUpdateCustomIndexEvent(index=" + this.f133064a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateDayIndexEvent extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133065a;

        public OnUpdateDayIndexEvent(int i3) {
            super(null);
            this.f133065a = i3;
        }

        public final int a() {
            return this.f133065a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdateDayIndexEvent) && this.f133065a == ((OnUpdateDayIndexEvent) obj).f133065a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133065a);
        }

        public String toString() {
            return "OnUpdateDayIndexEvent(index=" + this.f133065a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateHourIndexEvent extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133066a;

        public OnUpdateHourIndexEvent(int i3) {
            super(null);
            this.f133066a = i3;
        }

        public final int a() {
            return this.f133066a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdateHourIndexEvent) && this.f133066a == ((OnUpdateHourIndexEvent) obj).f133066a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133066a);
        }

        public String toString() {
            return "OnUpdateHourIndexEvent(index=" + this.f133066a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateMinuteIndexEvent extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f133067a;

        public OnUpdateMinuteIndexEvent(int i3) {
            super(null);
            this.f133067a = i3;
        }

        public final int a() {
            return this.f133067a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdateMinuteIndexEvent) && this.f133067a == ((OnUpdateMinuteIndexEvent) obj).f133067a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f133067a);
        }

        public String toString() {
            return "OnUpdateMinuteIndexEvent(index=" + this.f133067a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateSelectedTimeEvent extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUpdateSelectedTimeEvent f133068a = new OnUpdateSelectedTimeEvent();

        private OnUpdateSelectedTimeEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnUpdateSelectedTimeEvent);
        }

        public int hashCode() {
            return 1735952449;
        }

        public String toString() {
            return "OnUpdateSelectedTimeEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUpdateTimePickerConfig extends TimePickerViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimePickerConfig f133069a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnUpdateTimePickerConfig(TimePickerConfig config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.f133069a = config;
        }

        public final TimePickerConfig a() {
            return this.f133069a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdateTimePickerConfig) && Intrinsics.areEqual(this.f133069a, ((OnUpdateTimePickerConfig) obj).f133069a);
        }

        public int hashCode() {
            return this.f133069a.hashCode();
        }

        public String toString() {
            return "OnUpdateTimePickerConfig(config=" + this.f133069a + ")";
        }
    }

    public /* synthetic */ TimePickerViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimePickerViewEvent() {
    }
}
