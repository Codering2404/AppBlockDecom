package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionHandler$onTimeConditionError$1", f = "TimeConditionViewModel.kt", l = {365}, m = "invokeSuspend", v = 1)
final class TimeConditionHandler$onTimeConditionError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f115732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimeConditionHandler f115733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f115734d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeConditionHandler$onTimeConditionError$1(boolean z2, TimeConditionHandler timeConditionHandler, boolean z3, Continuation continuation) {
        super(2, continuation);
        this.f115732b = z2;
        this.f115733c = timeConditionHandler;
        this.f115734d = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TimeConditionHandler$onTimeConditionError$1(this.f115732b, this.f115733c, this.f115734d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115731a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f115732b) {
                this.f115733c.c(R.string.Ad);
            }
            TimeConditionHandler timeConditionHandler = this.f115733c;
            timeConditionHandler.n0(TimeConditionConfigurationViewState.d(timeConditionHandler.x0(), null, false, this.f115732b, this.f115734d, false, null, false, 115, null));
            this.f115731a = 1;
            if (DelayKt.b(800L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        TimeConditionHandler timeConditionHandler2 = this.f115733c;
        timeConditionHandler2.n0(TimeConditionConfigurationViewState.d(timeConditionHandler2.x0(), null, false, false, false, false, null, false, 115, null));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TimeConditionHandler$onTimeConditionError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
