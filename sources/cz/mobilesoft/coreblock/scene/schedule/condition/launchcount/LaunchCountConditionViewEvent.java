package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
public abstract class LaunchCountConditionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchCountTimeConditionViewEvent extends LaunchCountConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeConditionViewEvent f115234a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LaunchCountTimeConditionViewEvent(TimeConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f115234a = event;
        }

        public final TimeConditionViewEvent a() {
            return this.f115234a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LaunchCountTimeConditionViewEvent) && Intrinsics.areEqual(this.f115234a, ((LaunchCountTimeConditionViewEvent) obj).f115234a);
        }

        public int hashCode() {
            return this.f115234a.hashCode();
        }

        public String toString() {
            return "LaunchCountTimeConditionViewEvent(event=" + this.f115234a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends LaunchCountConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f115235a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLaunchCountChanged extends LaunchCountConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f115236a;

        public OnLaunchCountChanged(int i3) {
            super(null);
            this.f115236a = i3;
        }

        public final int a() {
            return this.f115236a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLaunchCountChanged) && this.f115236a == ((OnLaunchCountChanged) obj).f115236a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f115236a);
        }

        public String toString() {
            return "OnLaunchCountChanged(increment=" + this.f115236a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPeriodTypeChanged extends LaunchCountConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UsageLimit.PeriodType f115237a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPeriodTypeChanged(UsageLimit.PeriodType periodType) {
            super(null);
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            this.f115237a = periodType;
        }

        public final UsageLimit.PeriodType a() {
            return this.f115237a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPeriodTypeChanged) && this.f115237a == ((OnPeriodTypeChanged) obj).f115237a;
        }

        public int hashCode() {
            return this.f115237a.hashCode();
        }

        public String toString() {
            return "OnPeriodTypeChanged(periodType=" + this.f115237a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends LaunchCountConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f115238a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }
    }

    public /* synthetic */ LaunchCountConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LaunchCountConditionViewEvent() {
    }
}
