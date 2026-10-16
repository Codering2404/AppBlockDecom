package cz.mobilesoft.coreblock.scene.dashboard;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewCommand;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$RootCompose$3$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$RootCompose$3$1 extends SuspendLambda implements Function2<UnlockAllAppsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f99187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f99188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$RootCompose$3$1(MutableState mutableState, DashboardActivity dashboardActivity, Continuation continuation) {
        super(2, continuation);
        this.f99188c = mutableState;
        this.f99189d = dashboardActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DashboardActivity$RootCompose$3$1 dashboardActivity$RootCompose$3$1 = new DashboardActivity$RootCompose$3$1(this.f99188c, this.f99189d, continuation);
        dashboardActivity$RootCompose$3$1.f99187b = obj;
        return dashboardActivity$RootCompose$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(UnlockAllAppsViewCommand unlockAllAppsViewCommand, Continuation continuation) {
        return ((DashboardActivity$RootCompose$3$1) create(unlockAllAppsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        UnlockAllAppsViewCommand unlockAllAppsViewCommand = (UnlockAllAppsViewCommand) this.f99187b;
        IntrinsicsKt.f();
        if (this.f99186a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (unlockAllAppsViewCommand instanceof UnlockAllAppsViewCommand.Finish) {
            this.f99188c.setValue(Boxing.a(false));
        } else {
            if (!(unlockAllAppsViewCommand instanceof UnlockAllAppsViewCommand.OpenEmergencyUnlockFeedback)) {
                throw new NoWhenBranchMatchedException();
            }
            DashboardActivity dashboardActivity = this.f99189d;
            dashboardActivity.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, dashboardActivity, ContactReason.EmergencyUnblocking, null, null, "unlock_all_apps_shortcut", null, false, 108, null));
            this.f99188c.setValue(Boxing.a(false));
        }
        return Unit.f139807a;
    }
}
