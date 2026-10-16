package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory;
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
public abstract class PomodoroViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnHistorySelected extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PomodoroHistory f114061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnHistorySelected(PomodoroHistory history) {
            super(null);
            Intrinsics.checkNotNullParameter(history, "history");
            this.f114061a = history;
        }

        public final PomodoroHistory a() {
            return this.f114061a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnHistorySelected) && Intrinsics.areEqual(this.f114061a, ((OnHistorySelected) obj).f114061a);
        }

        public int hashCode() {
            return this.f114061a.hashCode();
        }

        public String toString() {
            return "OnHistorySelected(history=" + this.f114061a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsGranted extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PomodoroViewModel.PomodoroDto f114062a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPermissionsGranted(PomodoroViewModel.PomodoroDto pomodoro) {
            super(null);
            Intrinsics.checkNotNullParameter(pomodoro, "pomodoro");
            this.f114062a = pomodoro;
        }

        public final PomodoroViewModel.PomodoroDto a() {
            return this.f114062a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPermissionsGranted) && Intrinsics.areEqual(this.f114062a, ((OnPermissionsGranted) obj).f114062a);
        }

        public int hashCode() {
            return this.f114062a.hashCode();
        }

        public String toString() {
            return "OnPermissionsGranted(pomodoro=" + this.f114062a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeConfirmedClicked extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeConfirmedClicked f114063a = new OnStrictModeConfirmedClicked();

        private OnStrictModeConfirmedClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeConfirmedClicked);
        }

        public int hashCode() {
            return 1039392505;
        }

        public String toString() {
            return "OnStrictModeConfirmedClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SetPomodoroBreak extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114064a;

        public SetPomodoroBreak(long j3) {
            super(null);
            this.f114064a = j3;
        }

        public final long a() {
            return this.f114064a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetPomodoroBreak) && this.f114064a == ((SetPomodoroBreak) obj).f114064a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114064a);
        }

        public String toString() {
            return "SetPomodoroBreak(time=" + this.f114064a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SetPomodoroFocus extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114065a;

        public SetPomodoroFocus(long j3) {
            super(null);
            this.f114065a = j3;
        }

        public final long a() {
            return this.f114065a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetPomodoroFocus) && this.f114065a == ((SetPomodoroFocus) obj).f114065a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114065a);
        }

        public String toString() {
            return "SetPomodoroFocus(time=" + this.f114065a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SetPomodoroSessions extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f114066a;

        public SetPomodoroSessions(int i3) {
            super(null);
            this.f114066a = i3;
        }

        public final int a() {
            return this.f114066a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetPomodoroSessions) && this.f114066a == ((SetPomodoroSessions) obj).f114066a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f114066a);
        }

        public String toString() {
            return "SetPomodoroSessions(sessions=" + this.f114066a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartPomodoro extends PomodoroViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StartPomodoro f114067a = new StartPomodoro();

        private StartPomodoro() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof StartPomodoro);
        }

        public int hashCode() {
            return -389091099;
        }

        public String toString() {
            return "StartPomodoro";
        }
    }

    public /* synthetic */ PomodoroViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PomodoroViewEvent() {
    }
}
