package cz.mobilesoft.coreblock.scene.dashboard;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.repository.AppVersionRepository;
import cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity;
import cz.mobilesoft.coreblock.util.constants.WhatsNewData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$DashboardScreen$9$1", f = "DashboardActivity.kt", l = {681}, m = "invokeSuspend", v = 1)
final class DashboardActivity$DashboardScreen$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99166b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$DashboardScreen$9$1(DashboardActivity dashboardActivity, Continuation continuation) {
        super(2, continuation);
        this.f99166b = dashboardActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$DashboardScreen$9$1(this.f99166b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99165a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowD = AppVersionRepository.f97355a.D();
            final DashboardActivity dashboardActivity = this.f99166b;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$DashboardScreen$9$1.1
                public final Object a(boolean z2, Continuation continuation) {
                    if (z2 && dashboardActivity.f99143m.compareAndSet(false, true)) {
                        String strL = LockieApplication.l();
                        Intrinsics.checkNotNullExpressionValue(strL, "getVersionName(...)");
                        if (WhatsNewData.f128462a.a().containsKey(StringsKt.t1(strL).toString())) {
                            DashboardActivity dashboardActivity2 = dashboardActivity;
                            dashboardActivity2.startActivity(WhatsNewFullScreenActivity.Companion.b(WhatsNewFullScreenActivity.f123056h, dashboardActivity2, null, 2, null));
                        }
                    }
                    return Unit.f139807a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Boolean) obj2).booleanValue(), continuation);
                }
            };
            this.f99165a = 1;
            if (flowD.collect(flowCollector, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$DashboardScreen$9$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
