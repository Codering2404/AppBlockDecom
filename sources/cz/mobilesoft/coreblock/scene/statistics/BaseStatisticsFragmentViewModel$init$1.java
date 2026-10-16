package cz.mobilesoft.coreblock.scene.statistics;

import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.util.StatisticsHelper;
import cz.mobilesoft.statistics.api.Statistics;
import kotlin.Metadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$init$1", f = "BaseStatisticsFragmentViewModel.kt", l = {68}, m = "invokeSuspend", v = 1)
final class BaseStatisticsFragmentViewModel$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f119667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseStatisticsFragmentViewModel f119669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStatisticsFragmentViewModel$init$1(BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119669c = baseStatisticsFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseStatisticsFragmentViewModel$init$1(this.f119669c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119668b;
        if (i3 == 0) {
            ResultKt.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f119669c.f119636s = Boxing.e(StatisticsHelper.b(jCurrentTimeMillis));
            this.f119667a = jCurrentTimeMillis;
            this.f119668b = 1;
            obj = Statistics.N(this);
            if (obj == objF) {
                return objF;
            }
            j3 = jCurrentTimeMillis;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.f119667a;
            ResultKt.b(obj);
        }
        Long l3 = (Long) obj;
        long jLongValue = l3 != null ? l3.longValue() : j3;
        MutableLiveData mutableLiveData = this.f119669c.f119633p;
        StatisticsIntervalConfig statisticsIntervalConfig = (StatisticsIntervalConfig) this.f119669c.f119633p.f();
        if (statisticsIntervalConfig == null) {
            statisticsIntervalConfig = new StatisticsIntervalConfig();
        }
        statisticsIntervalConfig.e(StatisticsHelper.g(jLongValue));
        statisticsIntervalConfig.f(StatisticsHelper.k(jLongValue));
        StatisticsHelper statisticsHelper = StatisticsHelper.f128018a;
        statisticsIntervalConfig.g(statisticsHelper.h(jLongValue, j3));
        statisticsIntervalConfig.h(statisticsHelper.i(jLongValue, j3));
        mutableLiveData.n(statisticsIntervalConfig);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseStatisticsFragmentViewModel$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
