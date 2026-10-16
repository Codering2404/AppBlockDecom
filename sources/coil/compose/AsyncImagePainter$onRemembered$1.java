package coil.compose;

import androidx.compose.runtime.SnapshotStateKt;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "coil.compose.AsyncImagePainter$onRemembered$1", f = "AsyncImagePainter.kt", l = {243}, m = "invokeSuspend")
final class AsyncImagePainter$onRemembered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AsyncImagePainter f55534b;

    /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "coil.compose.AsyncImagePainter$onRemembered$1$2", f = "AsyncImagePainter.kt", l = {242}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ImageRequest, Continuation<? super AsyncImagePainter.State>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f55536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f55537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AsyncImagePainter f55538c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AsyncImagePainter asyncImagePainter, Continuation continuation) {
            super(2, continuation);
            this.f55538c = asyncImagePainter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f55538c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ImageRequest imageRequest, Continuation continuation) {
            return ((AnonymousClass2) create(imageRequest, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AsyncImagePainter asyncImagePainter;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f55537b;
            if (i3 == 0) {
                ResultKt.b(obj);
                AsyncImagePainter asyncImagePainter2 = this.f55538c;
                ImageLoader imageLoaderX = asyncImagePainter2.x();
                AsyncImagePainter asyncImagePainter3 = this.f55538c;
                ImageRequest imageRequestR = asyncImagePainter3.R(asyncImagePainter3.z());
                this.f55536a = asyncImagePainter2;
                this.f55537b = 1;
                Object objC = imageLoaderX.c(imageRequestR, this);
                if (objC == objF) {
                    return objF;
                }
                asyncImagePainter = asyncImagePainter2;
                obj = objC;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                asyncImagePainter = (AsyncImagePainter) this.f55536a;
                ResultKt.b(obj);
            }
            return asyncImagePainter.Q((ImageResult) obj);
        }
    }

    /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass3 implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncImagePainter f55539a;

        AnonymousClass3(AsyncImagePainter asyncImagePainter) {
            this.f55539a = asyncImagePainter;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(AsyncImagePainter.State state, Continuation continuation) {
            Object objQ = AsyncImagePainter$onRemembered$1.q(this.f55539a, state, continuation);
            return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function b() {
            return new AdaptedFunctionReference(2, this.f55539a, AsyncImagePainter.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncImagePainter$onRemembered$1(AsyncImagePainter asyncImagePainter, Continuation continuation) {
        super(2, continuation);
        this.f55534b = asyncImagePainter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object q(AsyncImagePainter asyncImagePainter, AsyncImagePainter.State state, Continuation continuation) {
        asyncImagePainter.S(state);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AsyncImagePainter$onRemembered$1(this.f55534b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55533a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AsyncImagePainter asyncImagePainter = this.f55534b;
            Flow flowR = FlowKt.R(SnapshotStateKt.q(new Function0<ImageRequest>() { // from class: coil.compose.AsyncImagePainter$onRemembered$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ImageRequest invoke() {
                    return asyncImagePainter.z();
                }
            }), new AnonymousClass2(this.f55534b, null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.f55534b);
            this.f55533a = 1;
            if (flowR.collect(anonymousClass3, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AsyncImagePainter$onRemembered$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
