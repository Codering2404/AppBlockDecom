package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewModel$onShowSnackbar$1", f = "LaunchCountConditionViewModel.kt", l = {58}, m = "invokeSuspend", v = 1)
final class LaunchCountConditionViewModel$onShowSnackbar$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LaunchCountConditionViewModel f115257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f115258c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LaunchCountConditionViewModel$onShowSnackbar$1(LaunchCountConditionViewModel launchCountConditionViewModel, int i3, Continuation continuation) {
        super(1, continuation);
        this.f115257b = launchCountConditionViewModel;
        this.f115258c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LaunchCountConditionViewModel$onShowSnackbar$1(this.f115257b, this.f115258c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115256a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LaunchCountConditionViewModel launchCountConditionViewModel = this.f115257b;
            String string = this.f115257b.A0().getString(this.f115258c);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            LaunchCountConditionViewCommand.ShowSnackbar showSnackbar = new LaunchCountConditionViewCommand.ShowSnackbar(string);
            this.f115256a = 1;
            if (launchCountConditionViewModel.P0(showSnackbar, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LaunchCountConditionViewModel$onShowSnackbar$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
