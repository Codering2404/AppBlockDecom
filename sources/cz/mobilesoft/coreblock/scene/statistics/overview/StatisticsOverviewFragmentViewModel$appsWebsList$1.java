package cz.mobilesoft.coreblock.scene.statistics.overview;

import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel$appsWebsList$1", f = "StatisticsOverviewFragmentViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class StatisticsOverviewFragmentViewModel$appsWebsList$1 extends SuspendLambda implements Function2<List<? extends AggregatedItemRecord>, Continuation<? super List<? extends AppWebWrapper>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f120066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsOverviewFragmentViewModel f120067c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsOverviewFragmentViewModel$appsWebsList$1(StatisticsOverviewFragmentViewModel statisticsOverviewFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f120067c = statisticsOverviewFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatisticsOverviewFragmentViewModel$appsWebsList$1 statisticsOverviewFragmentViewModel$appsWebsList$1 = new StatisticsOverviewFragmentViewModel$appsWebsList$1(this.f120067c, continuation);
        statisticsOverviewFragmentViewModel$appsWebsList$1.f120066b = obj;
        return statisticsOverviewFragmentViewModel$appsWebsList$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listSortedWith;
        String strC;
        List<AggregatedItemRecord> list = (List) this.f120066b;
        IntrinsicsKt.f();
        if (this.f120065a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (list != null) {
            StatisticsOverviewFragmentViewModel statisticsOverviewFragmentViewModel = this.f120067c;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (AggregatedItemRecord aggregatedItemRecord : list) {
                int iG = aggregatedItemRecord.g();
                UsageAccess.Type type = UsageAccess.Type.WEBSITE;
                String strX = iG == type.getTypeId() ? StringHelper.x(aggregatedItemRecord.e()) : aggregatedItemRecord.e();
                AppWebsiteCategoryRelation appWebsiteCategoryRelation = (AppWebsiteCategoryRelation) statisticsOverviewFragmentViewModel.s1().get(strX);
                if (appWebsiteCategoryRelation != null && (strC = appWebsiteCategoryRelation.c()) != null) {
                    strX = strC;
                }
                Object appWebWrapper = linkedHashMap.get(strX);
                if (appWebWrapper == null) {
                    appWebWrapper = new AppWebWrapper(null, null, statisticsOverviewFragmentViewModel.c1(), 3, null);
                }
                AppWebWrapper appWebWrapper2 = (AppWebWrapper) appWebWrapper;
                if (aggregatedItemRecord.g() == type.getTypeId()) {
                    ArrayList arrayListF = appWebWrapper2.f();
                    if (arrayListF == null) {
                        arrayListF = new ArrayList();
                    }
                    arrayListF.add(aggregatedItemRecord);
                    appWebWrapper2.h(arrayListF);
                } else {
                    appWebWrapper2.g(aggregatedItemRecord);
                }
                linkedHashMap.put(strX, appWebWrapper2);
            }
            Collection collectionValues = linkedHashMap.values();
            if (collectionValues != null && (listSortedWith = CollectionsKt.sortedWith(collectionValues, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel$appsWebsList$1$invokeSuspend$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return ComparisonsKt.d(Integer.valueOf(((AppWebWrapper) obj3).e()), Integer.valueOf(((AppWebWrapper) obj2).e()));
                }
            })) != null) {
                return listSortedWith;
            }
        }
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(List list, Continuation continuation) {
        return ((StatisticsOverviewFragmentViewModel$appsWebsList$1) create(list, continuation)).invokeSuspend(Unit.f139807a);
    }
}
