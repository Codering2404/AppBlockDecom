package cz.mobilesoft.coreblock.scene.dashboard.card;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class QuickBlockViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAdClosed extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAdClosed f100561a = new OnAdClosed();

        private OnAdClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAdClosed);
        }

        public int hashCode() {
            return -68809794;
        }

        public String toString() {
            return "OnAdClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsGranted extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100562a;

        public OnPermissionsGranted(long j3) {
            super(null);
            this.f100562a = j3;
        }

        public final long a() {
            return this.f100562a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPermissionsGranted) && this.f100562a == ((OnPermissionsGranted) obj).f100562a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100562a);
        }

        public String toString() {
            return "OnPermissionsGranted(presetTime=" + this.f100562a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPomodoroBreakSkip extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPomodoroBreakSkip f100563a = new OnPomodoroBreakSkip();

        private OnPomodoroBreakSkip() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPomodoroBreakSkip);
        }

        public int hashCode() {
            return 45608518;
        }

        public String toString() {
            return "OnPomodoroBreakSkip";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPomodoroClicked extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPomodoroClicked f100564a = new OnPomodoroClicked();

        private OnPomodoroClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPomodoroClicked);
        }

        public int hashCode() {
            return 1242434895;
        }

        public String toString() {
            return "OnPomodoroClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f100565a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return -2021302360;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStartClicked extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100566a;

        public OnStartClicked(long j3) {
            super(null);
            this.f100566a = j3;
        }

        public final long a() {
            return this.f100566a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStartClicked) && this.f100566a == ((OnStartClicked) obj).f100566a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100566a);
        }

        public String toString() {
            return "OnStartClicked(presetTime=" + this.f100566a + ")";
        }

        public /* synthetic */ OnStartClicked(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStartConfirmed extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100567a;

        public OnStartConfirmed(long j3) {
            super(null);
            this.f100567a = j3;
        }

        public final long a() {
            return this.f100567a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStartConfirmed) && this.f100567a == ((OnStartConfirmed) obj).f100567a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100567a);
        }

        public String toString() {
            return "OnStartConfirmed(presetTime=" + this.f100567a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStopClicked extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStopClicked f100568a = new OnStopClicked();

        private OnStopClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStopClicked);
        }

        public int hashCode() {
            return 1817791254;
        }

        public String toString() {
            return "OnStopClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStopConfirmed extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStopConfirmed f100569a = new OnStopConfirmed();

        private OnStopConfirmed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStopConfirmed);
        }

        public int hashCode() {
            return 6160014;
        }

        public String toString() {
            return "OnStopConfirmed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimerClicked extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTimerClicked f100570a = new OnTimerClicked();

        private OnTimerClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTimerClicked);
        }

        public int hashCode() {
            return 403812849;
        }

        public String toString() {
            return "OnTimerClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnViewInitialized extends QuickBlockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnViewInitialized f100571a = new OnViewInitialized();

        private OnViewInitialized() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnViewInitialized);
        }

        public int hashCode() {
            return -744543296;
        }

        public String toString() {
            return "OnViewInitialized";
        }
    }

    public /* synthetic */ QuickBlockViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QuickBlockViewEvent() {
    }
}
