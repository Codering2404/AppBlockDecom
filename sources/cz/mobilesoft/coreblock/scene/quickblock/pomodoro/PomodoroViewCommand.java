package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel;
import java.util.List;
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
public abstract class PomodoroViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionsBeforeStart extends PomodoroViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PomodoroViewModel.PomodoroDto f114057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f114058b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionsBeforeStart(PomodoroViewModel.PomodoroDto pomodoro, List permissions) {
            super(null);
            Intrinsics.checkNotNullParameter(pomodoro, "pomodoro");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            this.f114057a = pomodoro;
            this.f114058b = permissions;
        }

        public final List a() {
            return this.f114058b;
        }

        public final PomodoroViewModel.PomodoroDto b() {
            return this.f114057a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionsBeforeStart)) {
                return false;
            }
            ShowPermissionsBeforeStart showPermissionsBeforeStart = (ShowPermissionsBeforeStart) obj;
            return Intrinsics.areEqual(this.f114057a, showPermissionsBeforeStart.f114057a) && Intrinsics.areEqual(this.f114058b, showPermissionsBeforeStart.f114058b);
        }

        public int hashCode() {
            return (this.f114057a.hashCode() * 31) + this.f114058b.hashCode();
        }

        public String toString() {
            return "ShowPermissionsBeforeStart(pomodoro=" + this.f114057a + ", permissions=" + this.f114058b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStrictModeDialog extends PomodoroViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowStrictModeDialog f114059a = new ShowStrictModeDialog();

        private ShowStrictModeDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowStrictModeDialog);
        }

        public int hashCode() {
            return 1420660934;
        }

        public String toString() {
            return "ShowStrictModeDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartPomodoro extends PomodoroViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114060a;

        public StartPomodoro(boolean z2) {
            super(null);
            this.f114060a = z2;
        }

        public final boolean a() {
            return this.f114060a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartPomodoro) && this.f114060a == ((StartPomodoro) obj).f114060a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114060a);
        }

        public String toString() {
            return "StartPomodoro(showEmailConsent=" + this.f114060a + ")";
        }
    }

    public /* synthetic */ PomodoroViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PomodoroViewCommand() {
    }
}
