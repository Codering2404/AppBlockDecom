package cz.mobilesoft.coreblock.scene.quickblock.timer;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState;
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
public abstract class QuickBlockTimeSelectViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuickBlockStarted extends QuickBlockTimeSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114257a;

        public OnQuickBlockStarted(boolean z2) {
            super(null);
            this.f114257a = z2;
        }

        public final boolean a() {
            return this.f114257a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnQuickBlockStarted) && this.f114257a == ((OnQuickBlockStarted) obj).f114257a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114257a);
        }

        public String toString() {
            return "OnQuickBlockStarted(showEmailConsent=" + this.f114257a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimePickerTypeChanged extends QuickBlockTimeSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QuickBlockTimeSelectViewState.TimePickerType f114258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f114259b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTimePickerTypeChanged(QuickBlockTimeSelectViewState.TimePickerType type, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f114258a = type;
            this.f114259b = l3;
        }

        public final Long a() {
            return this.f114259b;
        }

        public final QuickBlockTimeSelectViewState.TimePickerType b() {
            return this.f114258a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnTimePickerTypeChanged)) {
                return false;
            }
            OnTimePickerTypeChanged onTimePickerTypeChanged = (OnTimePickerTypeChanged) obj;
            return this.f114258a == onTimePickerTypeChanged.f114258a && Intrinsics.areEqual(this.f114259b, onTimePickerTypeChanged.f114259b);
        }

        public int hashCode() {
            int iHashCode = this.f114258a.hashCode() * 31;
            Long l3 = this.f114259b;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "OnTimePickerTypeChanged(type=" + this.f114258a + ", time=" + this.f114259b + ")";
        }

        public /* synthetic */ OnTimePickerTypeChanged(QuickBlockTimeSelectViewState.TimePickerType timePickerType, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(timePickerType, (i3 & 2) != 0 ? null : l3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPermissionsBeforeStart extends QuickBlockTimeSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f114261b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPermissionsBeforeStart(long j3, List missingPermissions) {
            super(null);
            Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
            this.f114260a = j3;
            this.f114261b = missingPermissions;
        }

        public final List a() {
            return this.f114261b;
        }

        public final long b() {
            return this.f114260a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPermissionsBeforeStart)) {
                return false;
            }
            ShowPermissionsBeforeStart showPermissionsBeforeStart = (ShowPermissionsBeforeStart) obj;
            return this.f114260a == showPermissionsBeforeStart.f114260a && Intrinsics.areEqual(this.f114261b, showPermissionsBeforeStart.f114261b);
        }

        public int hashCode() {
            return (Long.hashCode(this.f114260a) * 31) + this.f114261b.hashCode();
        }

        public String toString() {
            return "ShowPermissionsBeforeStart(presetTime=" + this.f114260a + ", missingPermissions=" + this.f114261b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowStrictModeDialog extends QuickBlockTimeSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowStrictModeDialog f114262a = new ShowStrictModeDialog();

        private ShowStrictModeDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowStrictModeDialog);
        }

        public int hashCode() {
            return -2093100468;
        }

        public String toString() {
            return "ShowStrictModeDialog";
        }
    }

    public /* synthetic */ QuickBlockTimeSelectViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QuickBlockTimeSelectViewCommand() {
    }
}
