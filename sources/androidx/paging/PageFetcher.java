package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

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
public final class PageFetcher<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f50029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f50030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PagingConfig f50031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConflatedEventBus f50032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConflatedEventBus f50033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Flow f50034f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class GenerationInfo<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PageFetcherSnapshot f50035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PagingState f50036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Job f50037c;

        public GenerationInfo(PageFetcherSnapshot snapshot, PagingState pagingState, Job job) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            Intrinsics.checkNotNullParameter(job, "job");
            this.f50035a = snapshot;
            this.f50036b = pagingState;
            this.f50037c = job;
        }

        public final Job a() {
            return this.f50037c;
        }

        public final PageFetcherSnapshot b() {
            return this.f50035a;
        }

        public final PagingState c() {
            return this.f50036b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PagerHintReceiver<Key, Value> implements HintReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PageFetcherSnapshot f50038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PageFetcher f50039b;

        public PagerHintReceiver(PageFetcher pageFetcher, PageFetcherSnapshot pageFetcherSnapshot) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "pageFetcherSnapshot");
            this.f50039b = pageFetcher;
            this.f50038a = pageFetcherSnapshot;
        }

        @Override // androidx.paging.HintReceiver
        public void a(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
            this.f50038a.o(viewportHint);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PagerUiReceiver implements UiReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConflatedEventBus f50040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PageFetcher f50041b;

        public PagerUiReceiver(PageFetcher pageFetcher, ConflatedEventBus retryEventBus) {
            Intrinsics.checkNotNullParameter(retryEventBus, "retryEventBus");
            this.f50041b = pageFetcher;
            this.f50040a = retryEventBus;
        }
    }

    public PageFetcher(Function1 pagingSourceFactory, Object obj, PagingConfig config, RemoteMediator remoteMediator) {
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f50029a = pagingSourceFactory;
        this.f50030b = obj;
        this.f50031c = config;
        this.f50032d = new ConflatedEventBus(null, 1, null);
        this.f50033e = new ConflatedEventBus(null, 1, null);
        this.f50034f = SimpleChannelFlowKt.a(new PageFetcher$flow$1(remoteMediator, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(androidx.paging.PagingSource r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcher$generateNewPagingSource$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = (androidx.paging.PageFetcher$generateNewPagingSource$1) r0
            int r1 = r0.f50067f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50067f = r1
            goto L18
        L13:
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50065c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50067f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f50064b
            androidx.paging.PagingSource r5 = (androidx.paging.PagingSource) r5
            java.lang.Object r0 = r0.f50063a
            androidx.paging.PageFetcher r0 = (androidx.paging.PageFetcher) r0
            kotlin.ResultKt.b(r6)
            goto L4c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.functions.Function1 r6 = r4.f50029a
            r0.f50063a = r4
            r0.f50064b = r5
            r0.f50067f = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            androidx.paging.PagingSource r6 = (androidx.paging.PagingSource) r6
            boolean r1 = r6 instanceof androidx.paging.CompatLegacyPagingSource
            if (r1 == 0) goto L5c
            r1 = r6
            androidx.paging.CompatLegacyPagingSource r1 = (androidx.paging.CompatLegacyPagingSource) r1
            androidx.paging.PagingConfig r2 = r0.f50031c
            int r2 = r2.f50306a
            r1.a(r2)
        L5c:
            if (r6 == r5) goto L94
            androidx.paging.PageFetcher$generateNewPagingSource$3 r1 = new androidx.paging.PageFetcher$generateNewPagingSource$3
            r1.<init>(r0)
            r6.h(r1)
            if (r5 == 0) goto L70
            androidx.paging.PageFetcher$generateNewPagingSource$4 r1 = new androidx.paging.PageFetcher$generateNewPagingSource$4
            r1.<init>(r0)
            r5.i(r1)
        L70:
            if (r5 == 0) goto L75
            r5.f()
        L75:
            androidx.paging.PagingLogger r5 = androidx.paging.PagingLogger.f50484a
            r0 = 3
            boolean r1 = r5.a(r0)
            if (r1 == 0) goto L93
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Generated new PagingSource "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r5.b(r0, r1, r2)
        L93:
            return r6
        L94:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher.h(androidx.paging.PagingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow j(PageFetcherSnapshot pageFetcherSnapshot, Job job, RemoteMediatorAccessor remoteMediatorAccessor) {
        return remoteMediatorAccessor == null ? pageFetcherSnapshot.u() : CancelableChannelFlowKt.a(job, new PageFetcher$injectRemoteEvents$1(remoteMediatorAccessor, pageFetcherSnapshot, new MutableLoadStateCollection(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        this.f50032d.b(Boolean.FALSE);
    }

    public final Flow i() {
        return this.f50034f;
    }

    public final void l() {
        this.f50032d.b(Boolean.TRUE);
    }
}
