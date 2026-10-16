package coil;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.target.ViewTarget;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "coil.RealImageLoader$execute$2", f = "RealImageLoader.kt", l = {140}, m = "invokeSuspend")
final class RealImageLoader$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f55461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RealImageLoader f55463d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RealImageLoader$execute$2(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation continuation) {
        super(2, continuation);
        this.f55462c = imageRequest;
        this.f55463d = realImageLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RealImageLoader$execute$2 realImageLoader$execute$2 = new RealImageLoader$execute$2(this.f55462c, this.f55463d, continuation);
        realImageLoader$execute$2.f55461b = obj;
        return realImageLoader$execute$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55460a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Deferred deferredB = BuildersKt__Builders_commonKt.b((CoroutineScope) this.f55461b, Dispatchers.c().w0(), null, new RealImageLoader$execute$2$job$1(this.f55463d, this.f55462c, null), 2, null);
        if (this.f55462c.M() instanceof ViewTarget) {
            Utils.m(((ViewTarget) this.f55462c.M()).a()).b(deferredB);
        }
        this.f55460a = 1;
        Object objAwait = deferredB.await(this);
        return objAwait == objF ? objF : objAwait;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RealImageLoader$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
