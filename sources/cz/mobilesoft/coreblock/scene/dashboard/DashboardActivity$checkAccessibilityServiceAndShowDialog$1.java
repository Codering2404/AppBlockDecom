package cz.mobilesoft.coreblock.scene.dashboard;

import android.content.DialogInterface;
import androidx.lifecycle.Lifecycle;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$checkAccessibilityServiceAndShowDialog$1", f = "DashboardActivity.kt", l = {1128}, m = "invokeSuspend", v = 1)
final class DashboardActivity$checkAccessibilityServiceAndShowDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99194b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$checkAccessibilityServiceAndShowDialog$1(DashboardActivity dashboardActivity, Continuation continuation) {
        super(2, continuation);
        this.f99194b = dashboardActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final DashboardActivity dashboardActivity, boolean z2) {
        if (z2 && dashboardActivity.getLifecycle().getCurrentState().b(Lifecycle.State.f39950d)) {
            AnswersHelper.O();
            DialogHelper.h(dashboardActivity, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.dashboard.q3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    DashboardActivity$checkAccessibilityServiceAndShowDialog$1.z(dashboardActivity, dialogInterface, i3);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DashboardActivity dashboardActivity, DialogInterface dialogInterface, int i3) {
        AnswersHelper.P();
        dashboardActivity.Q2();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$checkAccessibilityServiceAndShowDialog$1(this.f99194b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99193a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f99193a = 1;
            if (DelayKt.b(1000L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        PermissionsManager permissionsManager = PermissionsManager.f129021a;
        final DashboardActivity dashboardActivity = this.f99194b;
        permissionsManager.G(dashboardActivity, new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.p3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DashboardActivity$checkAccessibilityServiceAndShowDialog$1.y(dashboardActivity, ((Boolean) obj2).booleanValue());
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$checkAccessibilityServiceAndShowDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
