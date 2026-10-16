package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class PauseBlockingViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDateSelected extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100115a;

        public OnDateSelected(long j3) {
            super(null);
            this.f100115a = j3;
        }

        public final long a() {
            return this.f100115a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnDateSelected) && this.f100115a == ((OnDateSelected) obj).f100115a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100115a);
        }

        public String toString() {
            return "OnDateSelected(date=" + this.f100115a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPauseClicked extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PauseBlockingViewState.PauseBlockingType f100116a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPauseClicked(PauseBlockingViewState.PauseBlockingType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f100116a = type;
        }

        public final PauseBlockingViewState.PauseBlockingType a() {
            return this.f100116a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPauseClicked) && Intrinsics.areEqual(this.f100116a, ((OnPauseClicked) obj).f100116a);
        }

        public int hashCode() {
            return this.f100116a.hashCode();
        }

        public String toString() {
            return "OnPauseClicked(type=" + this.f100116a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileCustomPauseTimeSelected extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100117a;

        public final long a() {
            return this.f100117a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileCustomPauseTimeSelected) && this.f100117a == ((OnProfileCustomPauseTimeSelected) obj).f100117a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100117a);
        }

        public String toString() {
            return "OnProfileCustomPauseTimeSelected(timeInMillis=" + this.f100117a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakPauseContinueClicked extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakPauseContinueClicked f100118a = new OnStreakPauseContinueClicked();

        private OnStreakPauseContinueClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakPauseContinueClicked);
        }

        public int hashCode() {
            return 487610465;
        }

        public String toString() {
            return "OnStreakPauseContinueClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakPauseTakeBackClicked extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakPauseTakeBackClicked f100119a = new OnStreakPauseTakeBackClicked();

        private OnStreakPauseTakeBackClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakPauseTakeBackClicked);
        }

        public int hashCode() {
            return 1735713050;
        }

        public String toString() {
            return "OnStreakPauseTakeBackClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeSelected extends PauseBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f100120a;

        public OnTimeSelected(long j3) {
            super(null);
            this.f100120a = j3;
        }

        public final long a() {
            return this.f100120a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimeSelected) && this.f100120a == ((OnTimeSelected) obj).f100120a;
        }

        public int hashCode() {
            return Long.hashCode(this.f100120a);
        }

        public String toString() {
            return "OnTimeSelected(time=" + this.f100120a + ")";
        }
    }

    public /* synthetic */ PauseBlockingViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PauseBlockingViewEvent() {
    }
}
