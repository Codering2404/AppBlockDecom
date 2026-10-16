package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivation;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel;
import java.util.Arrays;
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
public abstract class StrictMode3ViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessMethodConfirmed extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f121186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f121187b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAccessMethodConfirmed(StrictModeAccessMethod accessMethod, List configurations) {
            super(null);
            Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
            Intrinsics.checkNotNullParameter(configurations, "configurations");
            this.f121186a = accessMethod;
            this.f121187b = configurations;
        }

        public final StrictModeAccessMethod a() {
            return this.f121186a;
        }

        public final List b() {
            return this.f121187b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAccessMethodConfirmed)) {
                return false;
            }
            OnAccessMethodConfirmed onAccessMethodConfirmed = (OnAccessMethodConfirmed) obj;
            return this.f121186a == onAccessMethodConfirmed.f121186a && Intrinsics.areEqual(this.f121187b, onAccessMethodConfirmed.f121187b);
        }

        public int hashCode() {
            return (this.f121186a.hashCode() * 31) + this.f121187b.hashCode();
        }

        public String toString() {
            return "OnAccessMethodConfirmed(accessMethod=" + this.f121186a + ", configurations=" + this.f121187b + YgVrd.bwOIPvJ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessMethodsClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAccessMethodsClicked f121188a = new OnAccessMethodsClicked();

        private OnAccessMethodsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAccessMethodsClicked);
        }

        public int hashCode() {
            return -1026774012;
        }

        public String toString() {
            return "OnAccessMethodsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnActivationConfirmed extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnActivationConfirmed f121189a = new OnActivationConfirmed();

        private OnActivationConfirmed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnActivationConfirmed);
        }

        public int hashCode() {
            return -492525538;
        }

        public String toString() {
            return "OnActivationConfirmed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnActiveStateChangeButtonClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnActiveStateChangeButtonClicked f121190a = new OnActiveStateChangeButtonClicked();

        private OnActiveStateChangeButtonClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnActiveStateChangeButtonClicked);
        }

        public int hashCode() {
            return 1239027525;
        }

        public String toString() {
            return "OnActiveStateChangeButtonClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApprovalEmailChanged extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121191a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnApprovalEmailChanged(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121191a = email;
        }

        public final String a() {
            return this.f121191a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnApprovalEmailChanged) && Intrinsics.areEqual(this.f121191a, ((OnApprovalEmailChanged) obj).f121191a);
        }

        public int hashCode() {
            return this.f121191a.hashCode();
        }

        public String toString() {
            return "OnApprovalEmailChanged(email=" + this.f121191a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApprovalSendUnblockRequest extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnApprovalSendUnblockRequest f121192a = new OnApprovalSendUnblockRequest();

        private OnApprovalSendUnblockRequest() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnApprovalSendUnblockRequest);
        }

        public int hashCode() {
            return 584364241;
        }

        public String toString() {
            return "OnApprovalSendUnblockRequest";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissActivationConfirmationBottomSheet extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissActivationConfirmationBottomSheet f121193a = new OnDismissActivationConfirmationBottomSheet();

        private OnDismissActivationConfirmationBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissActivationConfirmationBottomSheet);
        }

        public int hashCode() {
            return -571840246;
        }

        public String toString() {
            return "OnDismissActivationConfirmationBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissCooldownBottomSheet extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissCooldownBottomSheet f121194a = new OnDismissCooldownBottomSheet();

        private OnDismissCooldownBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissCooldownBottomSheet);
        }

        public int hashCode() {
            return -953288758;
        }

        public String toString() {
            return "OnDismissCooldownBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissResumeBottomSheet extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissResumeBottomSheet f121195a = new OnDismissResumeBottomSheet();

        private OnDismissResumeBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissResumeBottomSheet);
        }

        public int hashCode() {
            return -332388856;
        }

        public String toString() {
            return "OnDismissResumeBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnExtendTimerClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnExtendTimerClicked f121196a = new OnExtendTimerClicked();

        private OnExtendTimerClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnExtendTimerClicked);
        }

        public int hashCode() {
            return 1516350855;
        }

        public String toString() {
            return "OnExtendTimerClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLearnMoreClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLearnMoreClicked f121197a = new OnLearnMoreClicked();

        private OnLearnMoreClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLearnMoreClicked);
        }

        public int hashCode() {
            return 358490393;
        }

        public String toString() {
            return "OnLearnMoreClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMissingPermissionsChanged extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionRequestReason f121198a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMissingPermissionsChanged(PermissionRequestReason requestReason) {
            super(null);
            Intrinsics.checkNotNullParameter(requestReason, "requestReason");
            this.f121198a = requestReason;
        }

        public final PermissionRequestReason a() {
            return this.f121198a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMissingPermissionsChanged) && this.f121198a == ((OnMissingPermissionsChanged) obj).f121198a;
        }

        public int hashCode() {
            return this.f121198a.hashCode();
        }

        public String toString() {
            return "OnMissingPermissionsChanged(requestReason=" + this.f121198a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOptionsClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOptionsClicked f121199a = new OnOptionsClicked();

        private OnOptionsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOptionsClicked);
        }

        public int hashCode() {
            return -525502124;
        }

        public String toString() {
            return "OnOptionsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPinConfirmed extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictMode3ViewModel.PinCodeScreenType f121200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f121201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f121202c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPinConfirmed(StrictMode3ViewModel.PinCodeScreenType screenType, String pinCode, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            Intrinsics.checkNotNullParameter(pinCode, "pinCode");
            this.f121200a = screenType;
            this.f121201b = pinCode;
            this.f121202c = z2;
        }

        public final String a() {
            return this.f121201b;
        }

        public final StrictMode3ViewModel.PinCodeScreenType b() {
            return this.f121200a;
        }

        public final boolean c() {
            return this.f121202c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnPinConfirmed)) {
                return false;
            }
            OnPinConfirmed onPinConfirmed = (OnPinConfirmed) obj;
            return this.f121200a == onPinConfirmed.f121200a && Intrinsics.areEqual(this.f121201b, onPinConfirmed.f121201b) && this.f121202c == onPinConfirmed.f121202c;
        }

        public int hashCode() {
            return (((this.f121200a.hashCode() * 31) + this.f121201b.hashCode()) * 31) + Boolean.hashCode(this.f121202c);
        }

        public String toString() {
            return "OnPinConfirmed(screenType=" + this.f121200a + ", pinCode=" + this.f121201b + ", withPause=" + this.f121202c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRefreshClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRefreshClicked f121203a = new OnRefreshClicked();

        private OnRefreshClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRefreshClicked);
        }

        public int hashCode() {
            return -87843209;
        }

        public String toString() {
            return "OnRefreshClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f121204a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return -2082499956;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleIdsSet extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f121205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f121206b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnScheduleIdsSet(long[] scheduleIds, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f121205a = scheduleIds;
            this.f121206b = blockingMode;
        }

        public final AccessMethodConfiguration.Schedules.SchedulesBlockingMode a() {
            return this.f121206b;
        }

        public final long[] b() {
            return this.f121205a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnScheduleIdsSet)) {
                return false;
            }
            OnScheduleIdsSet onScheduleIdsSet = (OnScheduleIdsSet) obj;
            return Intrinsics.areEqual(this.f121205a, onScheduleIdsSet.f121205a) && this.f121206b == onScheduleIdsSet.f121206b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f121205a) * 31) + this.f121206b.hashCode();
        }

        public String toString() {
            return "OnScheduleIdsSet(scheduleIds=" + Arrays.toString(this.f121205a) + ", blockingMode=" + this.f121206b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSelectedAccessMethodClicked extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSelectedAccessMethodClicked f121207a = new OnSelectedAccessMethodClicked();

        private OnSelectedAccessMethodClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSelectedAccessMethodClicked);
        }

        public int hashCode() {
            return -1898090852;
        }

        public String toString() {
            return "OnSelectedAccessMethodClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeDeactivation extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeDeactivation f121208a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnStrictModeDeactivation(StrictModeDeactivation deactivation) {
            super(null);
            Intrinsics.checkNotNullParameter(deactivation, "deactivation");
            this.f121208a = deactivation;
        }

        public final StrictModeDeactivation a() {
            return this.f121208a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStrictModeDeactivation) && this.f121208a == ((OnStrictModeDeactivation) obj).f121208a;
        }

        public int hashCode() {
            return this.f121208a.hashCode();
        }

        public String toString() {
            return "OnStrictModeDeactivation(deactivation=" + this.f121208a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeResumed extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeResumed f121209a = new OnStrictModeResumed();

        private OnStrictModeResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeResumed);
        }

        public int hashCode() {
            return 618931872;
        }

        public String toString() {
            return "OnStrictModeResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimerValueSet extends StrictMode3ViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f121210a;

        public OnTimerValueSet(long j3) {
            super(null);
            this.f121210a = j3;
        }

        public final long a() {
            return this.f121210a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimerValueSet) && this.f121210a == ((OnTimerValueSet) obj).f121210a;
        }

        public int hashCode() {
            return Long.hashCode(this.f121210a);
        }

        public String toString() {
            return "OnTimerValueSet(timeInMillis=" + this.f121210a + ")";
        }
    }

    public /* synthetic */ StrictMode3ViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictMode3ViewEvent() {
    }
}
