package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1", f = "BaseIgnoreListFragmentViewModel.kt", l = {25}, m = "invokeSuspend", v = 1)
final class BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseIgnoreListFragmentViewModel f119914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f119915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UsageAccess.Type f119916d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1(BaseIgnoreListFragmentViewModel baseIgnoreListFragmentViewModel, String str, UsageAccess.Type type, Continuation continuation) {
        super(2, continuation);
        this.f119914b = baseIgnoreListFragmentViewModel;
        this.f119915c = str;
        this.f119916d = type;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1(this.f119914b, this.f119915c, this.f119916d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119913a;
        if (i3 == 0) {
            ResultKt.b(obj);
            IgnoredStatisticsItemDao ignoredStatisticsItemDaoM0 = this.f119914b.M0();
            String str = this.f119915c;
            UsageAccess.Type type = this.f119916d;
            this.f119913a = 1;
            if (ignoredStatisticsItemDaoM0.o0(str, type, false, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f119914b.R0();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
