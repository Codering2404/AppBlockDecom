package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1", f = "DefaultApplicationSelectFragmentViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
final class DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DefaultApplicationSelectFragmentViewModel f119933c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1(DefaultApplicationSelectFragmentViewModel defaultApplicationSelectFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119933c = defaultApplicationSelectFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1(this.f119933c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ArrayList arrayList;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119932b;
        if (i3 == 0) {
            ResultKt.b(obj);
            ArrayList arrayListN0 = this.f119933c.N0();
            IgnoredStatisticsItemDao ignoredStatisticsItemDaoM0 = this.f119933c.M0();
            IgnoredStatisticsItem.ItemSourceType itemSourceType = IgnoredStatisticsItem.ItemSourceType.DEFAULT;
            this.f119931a = arrayListN0;
            this.f119932b = 1;
            Object objA0 = ignoredStatisticsItemDaoM0.a0(itemSourceType, this);
            if (objA0 == objF) {
                return objF;
            }
            arrayList = arrayListN0;
            obj = objA0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList = (ArrayList) this.f119931a;
            ResultKt.b(obj);
        }
        Iterable iterable = (Iterable) obj;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList2.add(((IgnoredStatisticsItem) it.next()).c());
        }
        return Boxing.a(arrayList.addAll(arrayList2));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
