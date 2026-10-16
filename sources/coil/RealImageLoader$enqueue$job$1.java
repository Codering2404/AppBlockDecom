package coil;

import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.util.Logger;
import coil.util.Logs;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "coil.RealImageLoader$enqueue$job$1", f = "RealImageLoader.kt", l = {117}, m = "invokeSuspend")
final class RealImageLoader$enqueue$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RealImageLoader f55458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55459c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RealImageLoader$enqueue$job$1(RealImageLoader realImageLoader, ImageRequest imageRequest, Continuation continuation) {
        super(2, continuation);
        this.f55458b = realImageLoader;
        this.f55459c = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RealImageLoader$enqueue$job$1(this.f55458b, this.f55459c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Logger loggerH;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55457a;
        if (i3 == 0) {
            ResultKt.b(obj);
            RealImageLoader realImageLoader = this.f55458b;
            ImageRequest imageRequest = this.f55459c;
            this.f55457a = 1;
            obj = realImageLoader.g(imageRequest, 0, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        RealImageLoader realImageLoader2 = this.f55458b;
        ImageResult imageResult = (ImageResult) obj;
        if ((imageResult instanceof ErrorResult) && (loggerH = realImageLoader2.h()) != null) {
            Logs.a(loggerH, "RealImageLoader", ((ErrorResult) imageResult).c());
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RealImageLoader$enqueue$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
