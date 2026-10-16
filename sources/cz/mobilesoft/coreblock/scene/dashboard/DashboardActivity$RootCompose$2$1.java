package cz.mobilesoft.coreblock.scene.dashboard;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$RootCompose$2$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$RootCompose$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f99181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f99182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99183d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ UnlockAllAppsViewModel f99184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f99185g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$RootCompose$2$1(String str, ManagedActivityResultLauncher managedActivityResultLauncher, DashboardActivity dashboardActivity, UnlockAllAppsViewModel unlockAllAppsViewModel, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f99181b = str;
        this.f99182c = managedActivityResultLauncher;
        this.f99183d = dashboardActivity;
        this.f99184f = unlockAllAppsViewModel;
        this.f99185g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$RootCompose$2$1(this.f99181b, this.f99182c, this.f99183d, this.f99184f, this.f99185g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f99180a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.f99181b;
        if (str != null) {
            if (Intrinsics.areEqual(str, "do_not_delete_me")) {
                AnswersHelper.f128199a.p0();
                this.f99182c.b(DoNotDeleteMeActivity.f101475g.a(this.f99183d));
            } else if (Intrinsics.areEqual(str, "unlock_all_apps")) {
                AnswersHelper.f128199a.r0();
                this.f99184f.d1();
                this.f99185g.setValue(Boxing.a(true));
            }
            this.f99183d.f99142l.setValue(null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$RootCompose$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
