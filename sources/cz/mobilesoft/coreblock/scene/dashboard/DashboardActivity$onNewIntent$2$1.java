package cz.mobilesoft.coreblock.scene.dashboard;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$onNewIntent$2$1", f = "DashboardActivity.kt", l = {286}, m = "invokeSuspend", v = 1)
final class DashboardActivity$onNewIntent$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Intent f99212c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$onNewIntent$2$1(DashboardActivity dashboardActivity, Intent intent, Continuation continuation) {
        super(1, continuation);
        this.f99211b = dashboardActivity;
        this.f99212c = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DashboardActivity$onNewIntent$2$1(this.f99211b, this.f99212c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99210a;
        if (i3 == 0) {
            ResultKt.b(obj);
            DashboardActivity dashboardActivity = this.f99211b;
            Intent intent = this.f99212c;
            this.f99210a = 1;
            if (dashboardActivity.L2(intent, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f99211b.K2(this.f99212c);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DashboardActivity$onNewIntent$2$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
