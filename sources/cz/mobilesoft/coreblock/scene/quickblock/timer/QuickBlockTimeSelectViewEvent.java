package cz.mobilesoft.coreblock.scene.quickblock.timer;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState;
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
public abstract class QuickBlockTimeSelectViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfirmClicked extends QuickBlockTimeSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114263a;

        public OnConfirmClicked(long j3) {
            super(null);
            this.f114263a = j3;
        }

        public final long a() {
            return this.f114263a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConfirmClicked) && this.f114263a == ((OnConfirmClicked) obj).f114263a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114263a);
        }

        public String toString() {
            return "OnConfirmClicked(timeMillis=" + this.f114263a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsGranted extends QuickBlockTimeSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114264a;

        public OnPermissionsGranted(long j3) {
            super(null);
            this.f114264a = j3;
        }

        public final long a() {
            return this.f114264a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPermissionsGranted) && this.f114264a == ((OnPermissionsGranted) obj).f114264a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114264a);
        }

        public String toString() {
            return "OnPermissionsGranted(presetTime=" + this.f114264a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeConfirmedClicked extends QuickBlockTimeSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114265a;

        public OnStrictModeConfirmedClicked(long j3) {
            super(null);
            this.f114265a = j3;
        }

        public final long a() {
            return this.f114265a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStrictModeConfirmedClicked) && this.f114265a == ((OnStrictModeConfirmedClicked) obj).f114265a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114265a);
        }

        public String toString() {
            return "OnStrictModeConfirmedClicked(timeMillis=" + this.f114265a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimePickerTypeSelected extends QuickBlockTimeSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QuickBlockTimeSelectViewState.TimePickerType f114266a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimePickerTypeSelected(QuickBlockTimeSelectViewState.TimePickerType timePickerType) {
            super(null);
            Intrinsics.checkNotNullParameter(timePickerType, "timePickerType");
            this.f114266a = timePickerType;
        }

        public final QuickBlockTimeSelectViewState.TimePickerType a() {
            return this.f114266a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimePickerTypeSelected) && this.f114266a == ((TimePickerTypeSelected) obj).f114266a;
        }

        public int hashCode() {
            return this.f114266a.hashCode();
        }

        public String toString() {
            return "TimePickerTypeSelected(timePickerType=" + this.f114266a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimeUpdated extends QuickBlockTimeSelectViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114267a;

        public TimeUpdated(long j3) {
            super(null);
            this.f114267a = j3;
        }

        public final long a() {
            return this.f114267a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimeUpdated) && this.f114267a == ((TimeUpdated) obj).f114267a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114267a);
        }

        public String toString() {
            return "TimeUpdated(timeMillis=" + this.f114267a + ")";
        }
    }

    public /* synthetic */ QuickBlockTimeSelectViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QuickBlockTimeSelectViewEvent() {
    }
}
