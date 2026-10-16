package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1", f = "BlockingScreenViewModel.kt", l = {189}, m = "invokeSuspend", v = 1)
public final class BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends AggregatedRecord>>, List<? extends IgnoredStatisticsItem>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f99650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f99651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f99652d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f99653f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, long j3, long j4) {
        super(3, continuation);
        this.f99652d = j3;
        this.f99653f = j4;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object obj, Continuation continuation) {
        BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1 blockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1 = new BlockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.f99652d, this.f99653f);
        blockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1.f99650b = flowCollector;
        blockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1.f99651c = obj;
        return blockingScreenViewModel$21$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99649a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f99650b;
            Object obj2 = this.f99651c;
            List list = (List) obj2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((IgnoredStatisticsItem) it.next()).c());
            }
            Statistics statistics = Statistics.f133571a;
            Flow flowK = Statistics.k(SetsKt.setOf(Boxing.d(UsageAccess.Type.APPLICATION.getTypeId())), arrayList, this.f99652d, this.f99653f);
            this.f99650b = SpillingKt.a(flowCollector);
            this.f99651c = SpillingKt.a(obj2);
            this.f99649a = 1;
            if (FlowKt.A(flowCollector, flowK, this) == objF) {
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
}
