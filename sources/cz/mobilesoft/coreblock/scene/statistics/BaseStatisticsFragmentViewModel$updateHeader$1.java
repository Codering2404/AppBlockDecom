package cz.mobilesoft.coreblock.scene.statistics;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$updateHeader$1", f = "BaseStatisticsFragmentViewModel.kt", l = {99}, m = "invokeSuspend", v = 1)
final class BaseStatisticsFragmentViewModel$updateHeader$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseStatisticsFragmentViewModel f119680b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStatisticsFragmentViewModel$updateHeader$1(BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119680b = baseStatisticsFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseStatisticsFragmentViewModel$updateHeader$1(this.f119680b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119679a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel = this.f119680b;
            this.f119679a = 1;
            obj = baseStatisticsFragmentViewModel.S0(this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel2 = this.f119680b;
            MutableLiveData mutableLiveDataR0 = baseStatisticsFragmentViewModel2.R0();
            Double d3 = (Double) pair.e();
            mutableLiveDataR0.n(Boxing.b(d3 != null ? d3.doubleValue() : 0.0d));
            baseStatisticsFragmentViewModel2.Q0().n(pair.f());
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseStatisticsFragmentViewModel$updateHeader$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
