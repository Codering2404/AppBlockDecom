package androidx.paging;

import androidx.paging.LegacyPageFetcher;
import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import androidx.paging.PagingSource;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback, LegacyPageFetcher.PageConsumer<V> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f49664x = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PagingSource f49665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PagedList.BoundaryCallback f49666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f49667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f49668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f49669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f49670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f49671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f49672s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f49673t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f49674u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f49675v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final LegacyPageFetcher f49676w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList(PagingSource pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher notifyDispatcher, CoroutineDispatcher backgroundDispatcher, PagedList.BoundaryCallback boundaryCallback, PagedList.Config config, PagingSource.LoadResult.Page initialPage, Object obj) {
        super(pagingSource, coroutineScope, notifyDispatcher, new PagedStorage(), config);
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(notifyDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(initialPage, "initialPage");
        this.f49665l = pagingSource;
        this.f49666m = boundaryCallback;
        this.f49667n = obj;
        this.f49672s = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f49673t = Integer.MIN_VALUE;
        this.f49675v = config.f50274e != Integer.MAX_VALUE;
        PagedStorage pagedStorageW = w();
        Intrinsics.checkNotNull(pagedStorageW, "null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K of androidx.paging.ContiguousPagedList>");
        this.f49676w = new LegacyPageFetcher(coroutineScope, config, pagingSource, notifyDispatcher, backgroundDispatcher, this, pagedStorageW);
        if (config.f50272c) {
            w().q(initialPage.e() != Integer.MIN_VALUE ? initialPage.e() : 0, initialPage, initialPage.d() != Integer.MIN_VALUE ? initialPage.d() : 0, 0, this, (initialPage.e() == Integer.MIN_VALUE || initialPage.d() == Integer.MIN_VALUE) ? false : true);
        } else {
            w().q(0, initialPage, 0, initialPage.e() != Integer.MIN_VALUE ? initialPage.e() : 0, this, false);
        }
        M(LoadType.REFRESH, initialPage.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(boolean z2, boolean z3) {
        if (z2) {
            PagedList.BoundaryCallback boundaryCallback = this.f49666m;
            Intrinsics.checkNotNull(boundaryCallback);
            boundaryCallback.b(w().h());
        }
        if (z3) {
            PagedList.BoundaryCallback boundaryCallback2 = this.f49666m;
            Intrinsics.checkNotNull(boundaryCallback2);
            boundaryCallback2.a(w().n());
        }
    }

    private final void M(LoadType loadType, List list) {
        if (this.f49666m != null) {
            boolean z2 = false;
            boolean z3 = w().size() == 0;
            boolean z4 = !z3 && loadType == LoadType.PREPEND && list.isEmpty();
            if (!z3 && loadType == LoadType.APPEND && list.isEmpty()) {
                z2 = true;
            }
            J(z3, z4, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean z2) {
        boolean z3 = this.f49670q && this.f49672s <= o().f50271b;
        boolean z4 = this.f49671r && this.f49673t >= (size() - 1) - o().f50271b;
        if (z3 || z4) {
            if (z3) {
                this.f49670q = false;
            }
            if (z4) {
                this.f49671r = false;
            }
            if (z2) {
                BuildersKt__Builders_commonKt.d(p(), s(), null, new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this, z3, z4, null), 2, null);
            } else {
                K(z3, z4);
            }
        }
    }

    @Override // androidx.paging.PagedList
    public void C(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        this.f49676w.f().d(loadType, loadState);
    }

    public final void J(boolean z2, boolean z3, boolean z4) {
        if (this.f49666m == null) {
            throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
        }
        if (this.f49672s == Integer.MAX_VALUE) {
            this.f49672s = w().size();
        }
        if (this.f49673t == Integer.MIN_VALUE) {
            this.f49673t = 0;
        }
        if (z2 || z3 || z4) {
            BuildersKt__Builders_commonKt.d(p(), s(), null, new ContiguousPagedList$deferBoundaryCallbacks$1(z2, this, z3, z4, null), 2, null);
        }
    }

    public final PagedList.BoundaryCallback L() {
        return this.f49666m;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void a(int i3, int i4) {
        y(i3, i4);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void b(int i3, int i4) {
        A(i3, i4);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void d(int i3, int i4, int i5) {
        y(i3, i4);
        z(i3 + i4, i5);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void e(int i3, int i4, int i5) {
        y(i3, i4);
        z(0, i5);
        this.f49672s += i5;
        this.f49673t += i5;
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public boolean f(LoadType type, PagingSource.LoadResult.Page page) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(page, "page");
        List listB = page.b();
        boolean z2 = true;
        boolean z3 = x() > w().o();
        boolean z4 = this.f49675v && w().y(o().f50274e, u(), listB.size());
        LoadType loadType = LoadType.APPEND;
        if (type == loadType) {
            if (!z4 || z3) {
                w().g(page, this);
                int size = this.f49669p - listB.size();
                this.f49669p = size;
                if (size <= 0 || listB.isEmpty()) {
                }
            } else {
                this.f49669p = 0;
            }
            z2 = false;
        } else {
            if (type != LoadType.PREPEND) {
                throw new IllegalArgumentException("unexpected result type " + type);
            }
            if (z4 && z3) {
                this.f49668o = 0;
            } else {
                w().w(page, this);
                int size2 = this.f49668o - listB.size();
                this.f49668o = size2;
                if (size2 <= 0 || listB.isEmpty()) {
                }
            }
            z2 = false;
        }
        if (this.f49675v) {
            if (z3) {
                if (!(this.f49676w.f().b() instanceof LoadState.Loading) && w().A(this.f49674u, o().f50274e, u(), this)) {
                    this.f49676w.f().d(LoadType.PREPEND, LoadState.NotLoading.f49893b.b());
                }
            } else if (!(this.f49676w.f().a() instanceof LoadState.Loading) && w().z(this.f49674u, o().f50274e, u(), this)) {
                this.f49676w.f().d(loadType, LoadState.NotLoading.f49893b.b());
            }
        }
        M(type, listB);
        return z2;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void g(int i3) {
        z(0, i3);
        this.f49674u = w().d() > 0 || w().f() > 0;
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public void h(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        n(type, state);
    }

    @Override // androidx.paging.PagedList
    public Object q() {
        Object objE;
        PagingState pagingStateP = w().p(o());
        return (pagingStateP == null || (objE = this.f49665l.e(pagingStateP)) == null) ? this.f49667n : objE;
    }

    @Override // androidx.paging.PagedList
    public final PagingSource t() {
        return this.f49665l;
    }
}
