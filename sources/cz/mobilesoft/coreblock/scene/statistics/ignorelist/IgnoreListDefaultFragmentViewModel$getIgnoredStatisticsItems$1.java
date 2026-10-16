package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1", f = "IgnoreListDefaultFragmentViewModel.kt", l = {22}, m = "invokeSuspend", v = 1)
final class IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends IgnoredStatisticsItem>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IgnoreListDefaultFragmentViewModel f119993b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1(IgnoreListDefaultFragmentViewModel ignoreListDefaultFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119993b = ignoreListDefaultFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1(this.f119993b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119992a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        IgnoredStatisticsItemDao ignoredStatisticsItemDaoM0 = this.f119993b.M0();
        IgnoredStatisticsItem.ItemSourceType itemSourceType = IgnoredStatisticsItem.ItemSourceType.DEFAULT;
        this.f119992a = 1;
        Object objC0 = ignoredStatisticsItemDaoM0.c0(itemSourceType, true, this);
        return objC0 == objF ? objF : objC0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
