package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EmittedSource>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediatorLiveData f39903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LiveData f39904c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineLiveDataKt$addDisposableSource$2(MediatorLiveData mediatorLiveData, LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.f39903b = mediatorLiveData;
        this.f39904c = liveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.p(obj);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CoroutineLiveDataKt$addDisposableSource$2(this.f39903b, this.f39904c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f39902a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final MediatorLiveData mediatorLiveData = this.f39903b;
        mediatorLiveData.q(this.f39904c, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.lifecycle.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return CoroutineLiveDataKt$addDisposableSource$2.q(mediatorLiveData, obj2);
            }
        }));
        return new EmittedSource(this.f39904c, this.f39903b);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
