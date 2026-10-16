package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
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
public final class LegacyPageFetcher<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f49841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PagedList.Config f49842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PagingSource f49843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineDispatcher f49844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineDispatcher f49845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageConsumer f49846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final KeyProvider f49847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f49848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PagedList.LoadStateManager f49849i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface KeyProvider<K> {
        Object b();

        Object e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface PageConsumer<V> {
        boolean f(LoadType loadType, PagingSource.LoadResult.Page page);

        void h(LoadType loadType, LoadState loadState);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49850a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f49850a = iArr;
        }
    }

    public LegacyPageFetcher(CoroutineScope pagedListScope, PagedList.Config config, PagingSource source, CoroutineDispatcher notifyDispatcher, CoroutineDispatcher fetchDispatcher, PageConsumer pageConsumer, KeyProvider keyProvider) {
        Intrinsics.checkNotNullParameter(pagedListScope, "pagedListScope");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(notifyDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(fetchDispatcher, "fetchDispatcher");
        Intrinsics.checkNotNullParameter(pageConsumer, "pageConsumer");
        Intrinsics.checkNotNullParameter(keyProvider, "keyProvider");
        this.f49841a = pagedListScope;
        this.f49842b = config;
        this.f49843c = source;
        this.f49844d = notifyDispatcher;
        this.f49845e = fetchDispatcher;
        this.f49846f = pageConsumer;
        this.f49847g = keyProvider;
        this.f49848h = new AtomicBoolean(false);
        this.f49849i = new PagedList.LoadStateManager() { // from class: androidx.paging.LegacyPageFetcher$loadStateManager$1
            @Override // androidx.paging.PagedList.LoadStateManager
            public void c(LoadType type, LoadState state) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(state, "state");
                this.f49851d.g().h(type, state);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(LoadType loadType, Throwable th) {
        if (i()) {
            return;
        }
        this.f49849i.d(loadType, new LoadState.Error(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        this.f49843c.f();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(LoadType loadType, PagingSource.LoadResult.Page page) {
        if (i()) {
            return;
        }
        if (!this.f49846f.f(loadType, page)) {
            this.f49849i.d(loadType, page.b().isEmpty() ? LoadState.NotLoading.f49893b.a() : LoadState.NotLoading.f49893b.b());
            return;
        }
        int i3 = WhenMappings.f49850a[loadType.ordinal()];
        if (i3 == 1) {
            o();
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("Can only fetch more during append/prepend");
            }
            m();
        }
    }

    private final void m() {
        Object objB = this.f49847g.b();
        if (objB == null) {
            l(LoadType.APPEND, PagingSource.LoadResult.Page.f50494g.a());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.f49849i;
        LoadType loadType = LoadType.APPEND;
        loadStateManager.d(loadType, LoadState.Loading.f49892b);
        PagedList.Config config = this.f49842b;
        n(loadType, new PagingSource.LoadParams.Append(objB, config.f50270a, config.f50272c));
    }

    private final void n(LoadType loadType, PagingSource.LoadParams loadParams) {
        BuildersKt__Builders_commonKt.d(this.f49841a, this.f49845e, null, new LegacyPageFetcher$scheduleLoad$1(this, loadParams, loadType, null), 2, null);
    }

    private final void o() {
        Object objE = this.f49847g.e();
        if (objE == null) {
            l(LoadType.PREPEND, PagingSource.LoadResult.Page.f50494g.a());
            return;
        }
        PagedList.LoadStateManager loadStateManager = this.f49849i;
        LoadType loadType = LoadType.PREPEND;
        loadStateManager.d(loadType, LoadState.Loading.f49892b);
        PagedList.Config config = this.f49842b;
        n(loadType, new PagingSource.LoadParams.Prepend(objE, config.f50270a, config.f50272c));
    }

    public final void e() {
        this.f49848h.set(true);
    }

    public final PagedList.LoadStateManager f() {
        return this.f49849i;
    }

    public final PageConsumer g() {
        return this.f49846f;
    }

    public final PagingSource h() {
        return this.f49843c;
    }

    public final boolean i() {
        return this.f49848h.get();
    }
}
