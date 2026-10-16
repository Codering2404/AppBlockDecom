package androidx.room.paging;

import androidx.paging.PagingSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class CommonLimitOffsetImpl<Value> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f52666i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final PagingSource.LoadResult.Invalid f52667j = new PagingSource.LoadResult.Invalid();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f52668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LimitOffsetPagingSource f52669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3 f52670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RoomDatabase f52671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RoomRawQuery f52672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f52673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f52674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Job f52675h;

    /* JADX INFO: renamed from: androidx.room.paging.CommonLimitOffsetImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.paging.CommonLimitOffsetImpl$1", f = "LimitOffsetPagingSource.kt", l = {84}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52676a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52676a;
            if (i3 == 0) {
                ResultKt.b(obj);
                InvalidationTracker invalidationTracker = CommonLimitOffsetImpl.this.f52671d.getInvalidationTracker();
                String[] strArr = CommonLimitOffsetImpl.this.f52668a;
                Flow flowN = invalidationTracker.n((String[]) Arrays.copyOf(strArr, strArr.length), false);
                final CommonLimitOffsetImpl commonLimitOffsetImpl = CommonLimitOffsetImpl.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.room.paging.CommonLimitOffsetImpl.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Set set, Continuation continuation) {
                        if (commonLimitOffsetImpl.f52669b.b()) {
                            throw new CancellationException("PagingSource is invalid");
                        }
                        if (commonLimitOffsetImpl.f52674g.get()) {
                            commonLimitOffsetImpl.f52669b.f();
                        }
                        return Unit.f139807a;
                    }
                };
                this.f52676a = 1;
                if (flowN.collect(flowCollector, this) == objF) {
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CommonLimitOffsetImpl(String[] tables, LimitOffsetPagingSource pagingSource, Function3 convertRows) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(convertRows, "convertRows");
        this.f52668a = tables;
        this.f52669b = pagingSource;
        this.f52670c = convertRows;
        RoomDatabase roomDatabaseO = pagingSource.o();
        this.f52671d = roomDatabaseO;
        this.f52672e = pagingSource.q();
        this.f52673f = new AtomicInteger(-1);
        this.f52674g = new AtomicBoolean(false);
        this.f52675h = BuildersKt__Builders_commonKt.d(roomDatabaseO.getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        pagingSource.h(new Function0() { // from class: androidx.room.paging.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CommonLimitOffsetImpl.b(this.f52713a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(CommonLimitOffsetImpl commonLimitOffsetImpl) {
        Job job = commonLimitOffsetImpl.f52675h;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        return Unit.f139807a;
    }

    private final Object k(PagingSource.LoadParams loadParams, Continuation continuation) {
        return BuildersKt.g(this.f52671d.getCoroutineScope().getCoroutineContext(), new CommonLimitOffsetImpl$initialLoad$2(this, loadParams, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r8, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(androidx.paging.PagingSource.LoadParams r6, int r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$1 r0 = (androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$1) r0
            int r1 = r0.f52695d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52695d = r1
            goto L18
        L13:
            androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$1 r0 = new androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f52693b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52695d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f52692a
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            kotlin.ResultKt.b(r8)
            goto L6a
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.b(r8)
            goto L4c
        L3c:
            kotlin.ResultKt.b(r8)
            androidx.room.RoomRawQuery r8 = r5.f52672e
            kotlin.jvm.functions.Function3 r2 = r5.f52670c
            r0.f52695d = r4
            java.lang.Object r8 = androidx.room.paging.util.RoomPagingUtil.d(r6, r8, r7, r2, r0)
            if (r8 != r1) goto L4c
            goto L69
        L4c:
            r6 = r8
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            androidx.room.RoomDatabase r7 = r5.f52671d
            kotlinx.coroutines.CoroutineScope r7 = r7.getCoroutineScope()
            kotlin.coroutines.CoroutineContext r7 = r7.getCoroutineContext()
            androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$2 r8 = new androidx.room.paging.CommonLimitOffsetImpl$nonInitialLoad$2
            r2 = 0
            r8.<init>(r5, r2)
            r0.f52692a = r6
            r0.f52695d = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r8, r0)
            if (r7 != r1) goto L6a
        L69:
            return r1
        L6a:
            androidx.room.paging.LimitOffsetPagingSource r7 = r5.f52669b
            boolean r7 = r7.b()
            if (r7 == 0) goto L79
            androidx.paging.PagingSource$LoadResult$Invalid r6 = androidx.room.paging.CommonLimitOffsetImpl.f52667j
            java.lang.String r7 = "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Invalid<kotlin.Int, Value of androidx.room.paging.CommonLimitOffsetImpl>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
        L79:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.CommonLimitOffsetImpl.m(androidx.paging.PagingSource$LoadParams, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AtomicInteger j() {
        return this.f52673f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        if (r7 == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(androidx.paging.PagingSource.LoadParams r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.paging.CommonLimitOffsetImpl$load$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.paging.CommonLimitOffsetImpl$load$1 r0 = (androidx.room.paging.CommonLimitOffsetImpl$load$1) r0
            int r1 = r0.f52691c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52691c = r1
            goto L18
        L13:
            androidx.room.paging.CommonLimitOffsetImpl$load$1 r0 = new androidx.room.paging.CommonLimitOffsetImpl$load$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f52689a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52691c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L2c
            goto L64
        L2c:
            r6 = move-exception
            goto L67
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L2c
            goto L4f
        L3a:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.atomic.AtomicInteger r7 = r5.f52673f
            int r7 = r7.get()
            r2 = -1
            if (r7 != r2) goto L5b
            r0.f52691c = r4     // Catch: java.lang.Exception -> L2c
            java.lang.Object r7 = r5.k(r6, r0)     // Catch: java.lang.Exception -> L2c
            if (r7 != r1) goto L4f
            goto L63
        L4f:
            r6 = r7
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6     // Catch: java.lang.Exception -> L2c
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f52674g     // Catch: java.lang.Exception -> L2c
            r0 = 0
            r6.compareAndSet(r0, r4)     // Catch: java.lang.Exception -> L2c
            androidx.paging.PagingSource$LoadResult r7 = (androidx.paging.PagingSource.LoadResult) r7     // Catch: java.lang.Exception -> L2c
            return r7
        L5b:
            r0.f52691c = r3     // Catch: java.lang.Exception -> L2c
            java.lang.Object r7 = r5.m(r6, r7, r0)     // Catch: java.lang.Exception -> L2c
            if (r7 != r1) goto L64
        L63:
            return r1
        L64:
            androidx.paging.PagingSource$LoadResult r7 = (androidx.paging.PagingSource.LoadResult) r7     // Catch: java.lang.Exception -> L2c
            return r7
        L67:
            androidx.paging.PagingSource$LoadResult$Error r7 = new androidx.paging.PagingSource$LoadResult$Error
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.CommonLimitOffsetImpl.l(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
