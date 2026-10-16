package cz.mobilesoft.appblock.service;

import android.content.Context;
import cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.koin.java.KoinJavaComponent;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.TimeNudgeEvaluationHelper$evaluate$1", f = "TimeNudgeEvaluationHelper.kt", l = {30}, m = "invokeSuspend", v = 1)
final class TimeNudgeEvaluationHelper$evaluate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f94711b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeNudgeEvaluationHelper$evaluate$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f94711b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TimeNudgeEvaluationHelper$evaluate$1(this.f94711b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94710a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                EvaluateTimeNudgeUseCase evaluateTimeNudgeUseCase = (EvaluateTimeNudgeUseCase) KoinJavaComponent.c(EvaluateTimeNudgeUseCase.class, null, null, 6, null);
                EvaluateTimeNudgeUseCase.Params params = new EvaluateTimeNudgeUseCase.Params(this.f94711b);
                this.f94710a = 1;
                if (evaluateTimeNudgeUseCase.i(params, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TimeNudgeEvaluationHelper$evaluate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
