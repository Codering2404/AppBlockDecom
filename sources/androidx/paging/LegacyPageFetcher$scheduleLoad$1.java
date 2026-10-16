package androidx.paging;

import androidx.paging.PagingSource;
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
@DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.jvm.kt", l = {53}, m = "invokeSuspend")
final class LegacyPageFetcher$scheduleLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LegacyPageFetcher f49854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PagingSource.LoadParams f49855d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LoadType f49856f;

    /* JADX INFO: renamed from: androidx.paging.LegacyPageFetcher$scheduleLoad$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.jvm.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f49857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PagingSource.LoadResult f49858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyPageFetcher f49859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LoadType f49860d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagingSource.LoadResult loadResult, LegacyPageFetcher legacyPageFetcher, LoadType loadType, Continuation continuation) {
            super(2, continuation);
            this.f49858b = loadResult;
            this.f49859c = legacyPageFetcher;
            this.f49860d = loadType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f49858b, this.f49859c, this.f49860d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f49857a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            PagingSource.LoadResult loadResult = this.f49858b;
            if (loadResult instanceof PagingSource.LoadResult.Page) {
                this.f49859c.l(this.f49860d, (PagingSource.LoadResult.Page) loadResult);
            } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                this.f49859c.j(this.f49860d, ((PagingSource.LoadResult.Error) loadResult).a());
            } else if (loadResult instanceof PagingSource.LoadResult.Invalid) {
                this.f49859c.k();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyPageFetcher$scheduleLoad$1(LegacyPageFetcher legacyPageFetcher, PagingSource.LoadParams loadParams, LoadType loadType, Continuation continuation) {
        super(2, continuation);
        this.f49854c = legacyPageFetcher;
        this.f49855d = loadParams;
        this.f49856f = loadType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LegacyPageFetcher$scheduleLoad$1 legacyPageFetcher$scheduleLoad$1 = new LegacyPageFetcher$scheduleLoad$1(this.f49854c, this.f49855d, this.f49856f, continuation);
        legacyPageFetcher$scheduleLoad$1.f49853b = obj;
        return legacyPageFetcher$scheduleLoad$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49852a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.f49853b;
            PagingSource pagingSourceH = this.f49854c.h();
            PagingSource.LoadParams loadParams = this.f49855d;
            this.f49853b = coroutineScope2;
            this.f49852a = 1;
            Object objG = pagingSourceH.g(loadParams, this);
            if (objG == objF) {
                return objF;
            }
            coroutineScope = coroutineScope2;
            obj = objG;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.f49853b;
            ResultKt.b(obj);
        }
        PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
        if (this.f49854c.h().b()) {
            this.f49854c.e();
            return Unit.f139807a;
        }
        BuildersKt__Builders_commonKt.d(coroutineScope, this.f49854c.f49844d, null, new AnonymousClass1(loadResult, this.f49854c, this.f49856f, null), 2, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LegacyPageFetcher$scheduleLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
