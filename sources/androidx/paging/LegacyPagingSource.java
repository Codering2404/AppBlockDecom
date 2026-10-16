package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

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
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> implements CompatLegacyPagingSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f49861e = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f49862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f49863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f49864d;

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {
        AnonymousClass1() {
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final void a() {
            LegacyPagingSource.this.f();
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function b() {
            return new FunctionReferenceImpl(0, LegacyPagingSource.this, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49868a;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49868a = iArr;
        }
    }

    public LegacyPagingSource(CoroutineContext fetchContext, DataSource dataSource) {
        Intrinsics.checkNotNullParameter(fetchContext, "fetchContext");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f49862b = fetchContext;
        this.f49863c = dataSource;
        this.f49864d = Integer.MIN_VALUE;
        dataSource.a(new AnonymousClass1());
        h(new Function0<Unit>() { // from class: androidx.paging.LegacyPagingSource.2

            /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ LegacyPagingSource f49867a;

                AnonymousClass1(LegacyPagingSource legacyPagingSource) {
                    this.f49867a = legacyPagingSource;
                }

                @Override // androidx.paging.DataSource.InvalidatedCallback
                public final void a() {
                    this.f49867a.f();
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function b() {
                    return new FunctionReferenceImpl(0, this.f49867a, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
                }

                public final boolean equals(Object obj) {
                    if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
                        return Intrinsics.areEqual(b(), ((FunctionAdapter) obj).b());
                    }
                    return false;
                }

                public final int hashCode() {
                    return b().hashCode();
                }
            }

            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m350invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m350invoke() {
                LegacyPagingSource.this.j().h(new AnonymousClass1(LegacyPagingSource.this));
                LegacyPagingSource.this.j().d();
            }
        });
    }

    private final int k(PagingSource.LoadParams loadParams) {
        return ((loadParams instanceof PagingSource.LoadParams.Refresh) && loadParams.b() % 3 == 0) ? loadParams.b() / 3 : loadParams.b();
    }

    @Override // androidx.paging.CompatLegacyPagingSource
    public void a(int i3) {
        int i4 = this.f49864d;
        if (i4 == Integer.MIN_VALUE || i3 == i4) {
            this.f49864d = i3;
            return;
        }
        throw new IllegalStateException(("Page size is already set to " + this.f49864d + '.').toString());
    }

    @Override // androidx.paging.PagingSource
    public boolean c() {
        return this.f49863c.c() == DataSource.KeyType.POSITIONAL;
    }

    @Override // androidx.paging.PagingSource
    public Object e(PagingState state) {
        Object objG;
        Object objB;
        Intrinsics.checkNotNullParameter(state, "state");
        int i3 = WhenMappings.f49868a[this.f49863c.c().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return null;
            }
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Integer numD = state.d();
            if (numD == null || (objB = state.b(numD.intValue())) == null) {
                return null;
            }
            return this.f49863c.b(objB);
        }
        Integer numD2 = state.d();
        if (numD2 == null) {
            return null;
        }
        int iIntValue = numD2.intValue();
        int size = iIntValue - state.f50505d;
        for (int i4 = 0; i4 < CollectionsKt.getLastIndex(state.f()) && size > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) state.f().get(i4)).b()); i4++) {
            size -= ((PagingSource.LoadResult.Page) state.f().get(i4)).b().size();
        }
        PagingSource.LoadResult.Page pageC = state.c(iIntValue);
        if (pageC == null || (objG = pageC.g()) == null) {
            objG = 0;
        }
        Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type kotlin.Int");
        return Integer.valueOf(((Integer) objG).intValue() + size);
    }

    @Override // androidx.paging.PagingSource
    public Object g(PagingSource.LoadParams loadParams, Continuation continuation) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else {
            if (!(loadParams instanceof PagingSource.LoadParams.Prepend)) {
                throw new NoWhenBranchMatchedException();
            }
            loadType = LoadType.PREPEND;
        }
        LoadType loadType2 = loadType;
        if (this.f49864d == Integer.MIN_VALUE) {
            System.out.println((Object) "WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.f49864d = k(loadParams);
        }
        return BuildersKt.g(this.f49862b, new LegacyPagingSource$load$2(this, new DataSource.Params(loadType2, loadParams.a(), loadParams.b(), loadParams.c(), this.f49864d), loadParams, null), continuation);
    }

    public final DataSource j() {
        return this.f49863c;
    }
}
