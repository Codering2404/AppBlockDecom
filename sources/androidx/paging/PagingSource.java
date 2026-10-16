package androidx.paging;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

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
public abstract class PagingSource<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InvalidateCallbackTracker f50485a = new InvalidateCallbackTracker(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.paging.PagingSource$invalidateCallbackTracker$1
        public final void c(Function0 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.invoke();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Function0) obj);
            return Unit.f139807a;
        }
    }, null, 2, 0 == true ? 1 : 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadParams<Key> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f50486c = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f50487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f50488b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Append<Key> extends LoadParams<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Object f50489d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Append(Object key, int i3, boolean z2) {
                super(i3, z2, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.f50489d = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Object a() {
                return this.f50489d;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f50490a;

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
                    f50490a = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LoadParams a(LoadType loadType, Object obj, int i3, boolean z2) {
                Intrinsics.checkNotNullParameter(loadType, "loadType");
                int i4 = WhenMappings.f50490a[loadType.ordinal()];
                if (i4 == 1) {
                    return new Refresh(obj, i3, z2);
                }
                if (i4 == 2) {
                    if (obj != null) {
                        return new Prepend(obj, i3, z2);
                    }
                    throw new IllegalArgumentException("key cannot be null for prepend");
                }
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (obj != null) {
                    return new Append(obj, i3, z2);
                }
                throw new IllegalArgumentException("key cannot be null for append");
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Prepend<Key> extends LoadParams<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Object f50491d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prepend(Object key, int i3, boolean z2) {
                super(i3, z2, null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.f50491d = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Object a() {
                return this.f50491d;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Refresh<Key> extends LoadParams<Key> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Object f50492d;

            public Refresh(Object obj, int i3, boolean z2) {
                super(i3, z2, null);
                this.f50492d = obj;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Object a() {
                return this.f50492d;
            }
        }

        public /* synthetic */ LoadParams(int i3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, z2);
        }

        public abstract Object a();

        public final int b() {
            return this.f50487a;
        }

        public final boolean c() {
            return this.f50488b;
        }

        private LoadParams(int i3, boolean z2) {
            this.f50487a = i3;
            this.f50488b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadResult<Key, Value> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Error<Key, Value> extends LoadResult<Key, Value> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f50493a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable throwable) {
                super(null);
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.f50493a = throwable;
            }

            public final Throwable a() {
                return this.f50493a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual(this.f50493a, ((Error) obj).f50493a);
            }

            public int hashCode() {
                return this.f50493a.hashCode();
            }

            public String toString() {
                return StringsKt.p("LoadResult.Error(\n                    |   throwable: " + this.f50493a + "\n                    |) ", null, 1, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super(null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, KMappedMarker {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final Companion f50494g = new Companion(null);

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final Page f50495h = new Page(CollectionsKt.emptyList(), null, null, 0, 0);

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f50496a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f50497b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object f50498c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f50499d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f50500f;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Page a() {
                    Page pageB = b();
                    Intrinsics.checkNotNull(pageB, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Page<Key of androidx.paging.PagingSource.LoadResult.Page.Companion.empty, Value of androidx.paging.PagingSource.LoadResult.Page.Companion.empty>");
                    return pageB;
                }

                public final Page b() {
                    return Page.f50495h;
                }

                private Companion() {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Page(List data, Object obj, Object obj2, int i3, int i4) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.f50496a = data;
                this.f50497b = obj;
                this.f50498c = obj2;
                this.f50499d = i3;
                this.f50500f = i4;
                if (i3 != Integer.MIN_VALUE && i3 < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative");
                }
                if (i4 != Integer.MIN_VALUE && i4 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative");
                }
            }

            public final List b() {
                return this.f50496a;
            }

            public final int d() {
                return this.f50500f;
            }

            public final int e() {
                return this.f50499d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Page)) {
                    return false;
                }
                Page page = (Page) obj;
                return Intrinsics.areEqual(this.f50496a, page.f50496a) && Intrinsics.areEqual(this.f50497b, page.f50497b) && Intrinsics.areEqual(this.f50498c, page.f50498c) && this.f50499d == page.f50499d && this.f50500f == page.f50500f;
            }

            public final Object f() {
                return this.f50498c;
            }

            public final Object g() {
                return this.f50497b;
            }

            public int hashCode() {
                int iHashCode = this.f50496a.hashCode() * 31;
                Object obj = this.f50497b;
                int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
                Object obj2 = this.f50498c;
                return ((((iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31) + Integer.hashCode(this.f50499d)) * 31) + Integer.hashCode(this.f50500f);
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return this.f50496a.listIterator();
            }

            public String toString() {
                return StringsKt.p("LoadResult.Page(\n                    |   data size: " + this.f50496a.size() + "\n                    |   first Item: " + CollectionsKt.firstOrNull(this.f50496a) + "\n                    |   last Item: " + CollectionsKt.lastOrNull(this.f50496a) + "\n                    |   nextKey: " + this.f50498c + "\n                    |   prevKey: " + this.f50497b + "\n                    |   itemsBefore: " + this.f50499d + "\n                    |   itemsAfter: " + this.f50500f + "\n                    |) ", null, 1, null);
            }
        }

        public /* synthetic */ LoadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private LoadResult() {
        }
    }

    public final boolean b() {
        return this.f50485a.a();
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public abstract Object e(PagingState pagingState);

    public final void f() {
        if (this.f50485a.b()) {
            PagingLogger pagingLogger = PagingLogger.f50484a;
            if (pagingLogger.a(3)) {
                pagingLogger.b(3, "Invalidated PagingSource " + this, null);
            }
        }
    }

    public abstract Object g(LoadParams loadParams, Continuation continuation);

    public final void h(Function0 onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50485a.c(onInvalidatedCallback);
    }

    public final void i(Function0 onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50485a.d(onInvalidatedCallback);
    }
}
