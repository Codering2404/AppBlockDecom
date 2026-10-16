package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagingSource;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
@Deprecated
@Metadata
public abstract class PagedList<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f50256k = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PagingSource f50257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f50258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f50259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PagedStorage f50260d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Config f50261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f50262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f50263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f50264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f50265j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Deprecated
    public static final class Builder<Key, Value> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Callback {
        public abstract void a(int i3, int i4);

        public abstract void b(int i3, int i4);

        public abstract void c(int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PagedList a(PagingSource pagingSource, PagingSource.LoadResult.Page page, CoroutineScope coroutineScope, CoroutineDispatcher notifyDispatcher, CoroutineDispatcher fetchDispatcher, BoundaryCallback boundaryCallback, Config config, Object obj) {
            Object obj2;
            Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(notifyDispatcher, "notifyDispatcher");
            Intrinsics.checkNotNullParameter(fetchDispatcher, "fetchDispatcher");
            Intrinsics.checkNotNullParameter(config, "config");
            if (page == null) {
                obj2 = obj;
                page = (PagingSource.LoadResult.Page) BuildersKt__BuildersKt.b(null, new PagedList$Companion$create$resolvedInitialPage$1(pagingSource, new PagingSource.LoadParams.Refresh(obj2, config.f50273d, config.f50272c), null), 1, null);
            } else {
                obj2 = obj;
            }
            return new ContiguousPagedList(pagingSource, coroutineScope, notifyDispatcher, fetchDispatcher, boundaryCallback, config, page, obj2);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Config {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f50269f = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f50271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f50272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f50273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f50274e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Companion f50275a = new Companion(null);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
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
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadStateManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LoadState f50276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LoadState f50277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LoadState f50278c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f50279a;

            static {
                int[] iArr = new int[LoadType.values().length];
                try {
                    iArr[LoadType.REFRESH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadType.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LoadType.APPEND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f50279a = iArr;
            }
        }

        public LoadStateManager() {
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.f49893b;
            this.f50276a = companion.b();
            this.f50277b = companion.b();
            this.f50278c = companion.b();
        }

        public final LoadState a() {
            return this.f50278c;
        }

        public final LoadState b() {
            return this.f50277b;
        }

        public abstract void c(LoadType loadType, LoadState loadState);

        public final void d(LoadType type, LoadState state) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = WhenMappings.f50279a[type.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (Intrinsics.areEqual(this.f50278c, state)) {
                            return;
                        } else {
                            this.f50278c = state;
                        }
                    }
                } else if (Intrinsics.areEqual(this.f50277b, state)) {
                    return;
                } else {
                    this.f50277b = state;
                }
            } else if (Intrinsics.areEqual(this.f50276a, state)) {
                return;
            } else {
                this.f50276a = state;
            }
            c(type, state);
        }
    }

    public PagedList(PagingSource pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher notifyDispatcher, PagedStorage storage, Config config) {
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(notifyDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f50257a = pagingSource;
        this.f50258b = coroutineScope;
        this.f50259c = notifyDispatcher;
        this.f50260d = storage;
        this.f50261f = config;
        this.f50263h = (config.f50271b * 2) + config.f50270a;
        this.f50264i = new ArrayList();
        this.f50265j = new ArrayList();
    }

    public final void A(int i3, int i4) {
        if (i4 == 0) {
            return;
        }
        Iterator<T> it = CollectionsKt.reversed(this.f50264i).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.c(i3, i4);
            }
        }
    }

    public /* bridge */ Object B(int i3) {
        return super.remove(i3);
    }

    public void C(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
    }

    public final void D(Runnable runnable) {
        this.f50262g = runnable;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        return this.f50260d.get(i3);
    }

    public final void n(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        BuildersKt__Builders_commonKt.d(this.f50258b, this.f50259c, null, new PagedList$dispatchStateChangeAsync$1(this, type, state, null), 2, null);
    }

    public final Config o() {
        return this.f50261f;
    }

    public final CoroutineScope p() {
        return this.f50258b;
    }

    public abstract Object q();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i3) {
        return B(i3);
    }

    public final CoroutineDispatcher s() {
        return this.f50259c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return v();
    }

    public PagingSource t() {
        return this.f50257a;
    }

    public final int u() {
        return this.f50263h;
    }

    public int v() {
        return this.f50260d.size();
    }

    public final PagedStorage w() {
        return this.f50260d;
    }

    public final int x() {
        return this.f50260d.l();
    }

    public final void y(int i3, int i4) {
        if (i4 == 0) {
            return;
        }
        Iterator<T> it = CollectionsKt.reversed(this.f50264i).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.a(i3, i4);
            }
        }
    }

    public final void z(int i3, int i4) {
        if (i4 == 0) {
            return;
        }
        Iterator<T> it = CollectionsKt.reversed(this.f50264i).iterator();
        while (it.hasNext()) {
            Callback callback = (Callback) ((WeakReference) it.next()).get();
            if (callback != null) {
                callback.b(i3, i4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class BoundaryCallback<T> {
        public void a(Object itemAtEnd) {
            Intrinsics.checkNotNullParameter(itemAtEnd, "itemAtEnd");
        }

        public void b(Object itemAtFront) {
            Intrinsics.checkNotNullParameter(itemAtFront, "itemAtFront");
        }

        public void c() {
        }
    }
}
