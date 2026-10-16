package androidx.paging;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1", f = "PagingDataTransforms.jvm.kt", l = {55}, m = "invokeSuspend")
final class PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageEvent<Object>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PageEvent f50454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f50455c;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1$1", f = "PagingDataTransforms.jvm.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Object, Continuation<? super Iterable<Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f50457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f50458c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f50458c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50458c, continuation);
            anonymousClass1.f50457b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f50456a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return this.f50458c.invoke(this.f50457b);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1(PageEvent pageEvent, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f50454b = pageEvent;
        this.f50455c = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1(this.f50454b, this.f50455c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50453a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        PageEvent pageEvent = this.f50454b;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50455c, null);
        this.f50453a = 1;
        Object objC = pageEvent.c(anonymousClass1, this);
        return objC == objF ? objF : objC;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagingDataTransforms__PagingDataTransforms_jvmKt$flatMap$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
