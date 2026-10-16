package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import java.util.Collection;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListCustomFragmentViewModel$getApplicationsByPackageNames$1", f = "IgnoreListCustomFragmentViewModel.kt", l = {36}, m = "invokeSuspend", v = 1)
final class IgnoreListCustomFragmentViewModel$getApplicationsByPackageNames$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Application>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IgnoreListCustomFragmentViewModel f119974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Collection f119975c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IgnoreListCustomFragmentViewModel$getApplicationsByPackageNames$1(IgnoreListCustomFragmentViewModel ignoreListCustomFragmentViewModel, Collection collection, Continuation continuation) {
        super(2, continuation);
        this.f119974b = ignoreListCustomFragmentViewModel;
        this.f119975c = collection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new IgnoreListCustomFragmentViewModel$getApplicationsByPackageNames$1(this.f119974b, this.f119975c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119973a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ApplicationDao applicationDaoK0 = this.f119974b.K0();
        Collection collection = this.f119975c;
        this.f119973a = 1;
        Object objA0 = applicationDaoK0.a0(collection, this);
        return objA0 == objF ? objF : objA0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IgnoreListCustomFragmentViewModel$getApplicationsByPackageNames$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
