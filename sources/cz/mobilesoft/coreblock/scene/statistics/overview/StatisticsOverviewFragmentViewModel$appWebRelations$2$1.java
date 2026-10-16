package cz.mobilesoft.coreblock.scene.statistics.overview;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel$appWebRelations$2$1", f = "StatisticsOverviewFragmentViewModel.kt", l = {50}, m = "invokeSuspend", v = 1)
final class StatisticsOverviewFragmentViewModel$appWebRelations$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends AppWebsiteCategoryRelation>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsOverviewFragmentViewModel f120064b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsOverviewFragmentViewModel$appWebRelations$2$1(StatisticsOverviewFragmentViewModel statisticsOverviewFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f120064b = statisticsOverviewFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsOverviewFragmentViewModel$appWebRelations$2$1(this.f120064b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f120063a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AppWebsiteCategoryDao appWebsiteCategoryDaoT1 = this.f120064b.t1();
            this.f120063a = 1;
            obj = appWebsiteCategoryDaoT1.k(this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Iterable iterable = (Iterable) obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object obj2 : iterable) {
            linkedHashMap.put(((AppWebsiteCategoryRelation) obj2).b(), obj2);
        }
        return linkedHashMap;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsOverviewFragmentViewModel$appWebRelations$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
