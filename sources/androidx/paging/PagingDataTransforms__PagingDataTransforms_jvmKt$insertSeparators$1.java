package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;

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
@DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1", f = "PagingDataTransforms.jvm.kt", l = {186}, m = "invokeSuspend")
final class PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1 extends SuspendLambda implements Function3<Object, Object, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f50461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Executor f50462d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f50463f;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1$1", f = "PagingDataTransforms.jvm.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f50465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f50466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f50467d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function2 function2, Object obj, Object obj2, Continuation continuation) {
            super(2, continuation);
            this.f50465b = function2;
            this.f50466c = obj;
            this.f50467d = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f50465b, this.f50466c, this.f50467d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f50464a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return this.f50465b.invoke(this.f50466c, this.f50467d);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1(Executor executor, Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.f50462d = executor;
        this.f50463f = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Object obj, Object obj2, Continuation continuation) {
        PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1 pagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1 = new PagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1(this.f50462d, this.f50463f, continuation);
        pagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1.f50460b = obj;
        pagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1.f50461c = obj2;
        return pagingDataTransforms__PagingDataTransforms_jvmKt$insertSeparators$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50459a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Object obj2 = this.f50460b;
        Object obj3 = this.f50461c;
        CoroutineDispatcher coroutineDispatcherB = ExecutorsKt.b(this.f50462d);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f50463f, obj2, obj3, null);
        this.f50460b = null;
        this.f50459a = 1;
        Object objG = BuildersKt.g(coroutineDispatcherB, anonymousClass1, this);
        return objG == objF ? objF : objG;
    }
}
