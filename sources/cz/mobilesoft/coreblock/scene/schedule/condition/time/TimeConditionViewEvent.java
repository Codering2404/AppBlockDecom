package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import com.google.common.cache.LSNn.vfptEEmYY;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;

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
public abstract class TimeConditionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddIntervalClicked extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAddIntervalClicked f115749a = new OnAddIntervalClicked();

        private OnAddIntervalClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAllDayLongCheckedChanged extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f115750a;

        public OnAllDayLongCheckedChanged(boolean z2) {
            super(null);
            this.f115750a = z2;
        }

        public final boolean a() {
            return this.f115750a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAllDayLongCheckedChanged) && this.f115750a == ((OnAllDayLongCheckedChanged) obj).f115750a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f115750a);
        }

        public String toString() {
            return "OnAllDayLongCheckedChanged(isChecked=" + this.f115750a + vfptEEmYY.HXGWSgvdf;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f115751a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDayCheckedChanged extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f115752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DayOfWeek f115753b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDayCheckedChanged(boolean z2, DayOfWeek dayOfWeek) {
            super(null);
            Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
            this.f115752a = z2;
            this.f115753b = dayOfWeek;
        }

        public final DayOfWeek a() {
            return this.f115753b;
        }

        public final boolean b() {
            return this.f115752a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnDayCheckedChanged)) {
                return false;
            }
            OnDayCheckedChanged onDayCheckedChanged = (OnDayCheckedChanged) obj;
            return this.f115752a == onDayCheckedChanged.f115752a && this.f115753b == onDayCheckedChanged.f115753b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f115752a) * 31) + this.f115753b.hashCode();
        }

        public String toString() {
            return "OnDayCheckedChanged(isChecked=" + this.f115752a + ", dayOfWeek=" + this.f115753b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissTimeRangePickerBottomSheet extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissTimeRangePickerBottomSheet f115754a = new OnDismissTimeRangePickerBottomSheet();

        private OnDismissTimeRangePickerBottomSheet() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIntervalClicked extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntervalDTO f115755a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnIntervalClicked(IntervalDTO interval) {
            super(null);
            Intrinsics.checkNotNullParameter(interval, "interval");
            this.f115755a = interval;
        }

        public final IntervalDTO a() {
            return this.f115755a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnIntervalClicked) && Intrinsics.areEqual(this.f115755a, ((OnIntervalClicked) obj).f115755a);
        }

        public int hashCode() {
            return this.f115755a.hashCode();
        }

        public String toString() {
            return "OnIntervalClicked(interval=" + this.f115755a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIntervalRemoveClicked extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntervalDTO f115756a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnIntervalRemoveClicked(IntervalDTO interval) {
            super(null);
            Intrinsics.checkNotNullParameter(interval, "interval");
            this.f115756a = interval;
        }

        public final IntervalDTO a() {
            return this.f115756a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnIntervalRemoveClicked) && Intrinsics.areEqual(this.f115756a, ((OnIntervalRemoveClicked) obj).f115756a);
        }

        public int hashCode() {
            return this.f115756a.hashCode();
        }

        public String toString() {
            return "OnIntervalRemoveClicked(interval=" + this.f115756a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIntervalSet extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntervalDTO f115757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f115758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f115759c;

        public OnIntervalSet(IntervalDTO intervalDTO, long j3, long j4) {
            super(null);
            this.f115757a = intervalDTO;
            this.f115758b = j3;
            this.f115759c = j4;
        }

        public final long a() {
            return this.f115758b;
        }

        public final IntervalDTO b() {
            return this.f115757a;
        }

        public final long c() {
            return this.f115759c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnIntervalSet)) {
                return false;
            }
            OnIntervalSet onIntervalSet = (OnIntervalSet) obj;
            return Intrinsics.areEqual(this.f115757a, onIntervalSet.f115757a) && this.f115758b == onIntervalSet.f115758b && this.f115759c == onIntervalSet.f115759c;
        }

        public int hashCode() {
            IntervalDTO intervalDTO = this.f115757a;
            return ((((intervalDTO == null ? 0 : intervalDTO.hashCode()) * 31) + Long.hashCode(this.f115758b)) * 31) + Long.hashCode(this.f115759c);
        }

        public String toString() {
            return "OnIntervalSet(interval=" + this.f115757a + ", fromInMinutes=" + this.f115758b + ", toInMinutes=" + this.f115759c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends TimeConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f115760a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }
    }

    public /* synthetic */ TimeConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimeConditionViewEvent() {
    }
}
