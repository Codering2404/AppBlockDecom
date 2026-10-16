package androidx.paging.compose;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1", f = "LazyPagingItems.kt", l = {220, 222}, m = "invokeSuspend")
final class LazyPagingItemsKt$collectAsLazyPagingItems$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineContext f50775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyPagingItems f50776c;

    /* JADX INFO: renamed from: androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1$1", f = "LazyPagingItems.kt", l = {223}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f50777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LazyPagingItems f50778b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyPagingItems lazyPagingItems, Continuation continuation) {
            super(2, continuation);
            this.f50778b = lazyPagingItems;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f50778b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f50777a;
            if (i3 == 0) {
                ResultKt.b(obj);
                LazyPagingItems lazyPagingItems = this.f50778b;
                this.f50777a = 1;
                if (lazyPagingItems.d(this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyPagingItemsKt$collectAsLazyPagingItems$2$1(CoroutineContext coroutineContext, LazyPagingItems lazyPagingItems, Continuation continuation) {
        super(2, continuation);
        this.f50775b = coroutineContext;
        this.f50776c = lazyPagingItems;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyPagingItemsKt$collectAsLazyPagingItems$2$1(this.f50775b, this.f50776c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r6.d(r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r6, r1, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f50774a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            goto L46
        L1b:
            kotlin.ResultKt.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.f50775b
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.f139889a
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto L33
            androidx.paging.compose.LazyPagingItems r6 = r5.f50776c
            r5.f50774a = r3
            java.lang.Object r6 = r6.d(r5)
            if (r6 != r0) goto L46
            goto L45
        L33:
            kotlin.coroutines.CoroutineContext r6 = r5.f50775b
            androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1$1 r1 = new androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1$1
            androidx.paging.compose.LazyPagingItems r3 = r5.f50776c
            r4 = 0
            r1.<init>(r3, r4)
            r5.f50774a = r2
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r1, r5)
            if (r6 != r0) goto L46
        L45:
            return r0
        L46:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.compose.LazyPagingItemsKt$collectAsLazyPagingItems$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LazyPagingItemsKt$collectAsLazyPagingItems$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
