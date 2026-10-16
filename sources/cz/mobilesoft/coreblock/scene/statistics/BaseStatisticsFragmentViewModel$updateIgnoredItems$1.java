package cz.mobilesoft.coreblock.scene.statistics;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$updateIgnoredItems$1", f = "BaseStatisticsFragmentViewModel.kt", l = {110}, m = "invokeSuspend", v = 1)
final class BaseStatisticsFragmentViewModel$updateIgnoredItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseStatisticsFragmentViewModel f119683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStatisticsFragmentViewModel$updateIgnoredItems$1(BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119683c = baseStatisticsFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseStatisticsFragmentViewModel$updateIgnoredItems$1(this.f119683c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutableLiveData mutableLiveData;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119682b;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableLiveData mutableLiveData2 = this.f119683c.f119632o;
            BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel = this.f119683c;
            this.f119681a = mutableLiveData2;
            this.f119682b = 1;
            Object objU0 = baseStatisticsFragmentViewModel.U0(this);
            if (objU0 == objF) {
                return objF;
            }
            mutableLiveData = mutableLiveData2;
            obj = objU0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.f119681a;
            ResultKt.b(obj);
        }
        mutableLiveData.n(obj);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseStatisticsFragmentViewModel$updateIgnoredItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
