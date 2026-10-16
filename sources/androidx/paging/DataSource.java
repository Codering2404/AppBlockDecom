package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class DataSource<Key, Value> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f49686e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyType f49687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InvalidateCallbackTracker f49688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f49689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f49690d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(Function function, List source) {
            Intrinsics.checkNotNullParameter(function, "function");
            Intrinsics.checkNotNullParameter(source, "source");
            List dest = (List) function.apply(source);
            if (dest.size() == source.size()) {
                Intrinsics.checkNotNullExpressionValue(dest, "dest");
                return dest;
            }
            throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Factory<Key, Value> {
        public abstract DataSource a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface InvalidatedCallback {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum KeyType {
        POSITIONAL,
        PAGE_KEYED,
        ITEM_KEYED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadType f49705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f49706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f49707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f49708d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f49709e;

        public Params(LoadType type, Object obj, int i3, boolean z2, int i4) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.f49705a = type;
            this.f49706b = obj;
            this.f49707c = i3;
            this.f49708d = z2;
            this.f49709e = i4;
            if (type != LoadType.REFRESH && obj == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        public final int a() {
            return this.f49707c;
        }

        public final Object b() {
            return this.f49706b;
        }

        public final int c() {
            return this.f49709e;
        }

        public final boolean d() {
            return this.f49708d;
        }

        public final LoadType e() {
            return this.f49705a;
        }
    }

    public DataSource(KeyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f49687a = type;
        this.f49688b = new InvalidateCallbackTracker(new Function1<InvalidatedCallback, Unit>() { // from class: androidx.paging.DataSource$invalidateCallbackTracker$1
            public final void c(DataSource.InvalidatedCallback it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DataSource.InvalidatedCallback) obj);
                return Unit.f139807a;
            }
        }, new Function0<Boolean>() { // from class: androidx.paging.DataSource$invalidateCallbackTracker$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.f49711a.e());
            }
        });
        this.f49689c = true;
        this.f49690d = true;
    }

    public void a(InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f49688b.c(onInvalidatedCallback);
    }

    public abstract Object b(Object obj);

    public final KeyType c() {
        return this.f49687a;
    }

    public void d() {
        this.f49688b.b();
    }

    public boolean e() {
        return this.f49688b.a();
    }

    public abstract Object f(Params params, Continuation continuation);

    public DataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperDataSource(this, function);
    }

    public void h(InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f49688b.d(onInvalidatedCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BaseResult<Value> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f49691f = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f49692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f49693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f49694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f49695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f49696e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BaseResult a(BaseResult result, Function function) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(function, "function");
                return new BaseResult(DataSource.f49686e.a(function, result.f49692a), result.d(), result.c(), result.b(), result.a());
            }

            public final BaseResult b() {
                return new BaseResult(CollectionsKt.emptyList(), null, null, 0, 0);
            }

            private Companion() {
            }
        }

        public BaseResult(List data, Object obj, Object obj2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f49692a = data;
            this.f49693b = obj;
            this.f49694c = obj2;
            this.f49695d = i3;
            this.f49696e = i4;
            if (i3 < 0 && i3 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (data.isEmpty() && (i3 > 0 || i4 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (i4 < 0 && i4 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public final int a() {
            return this.f49696e;
        }

        public final int b() {
            return this.f49695d;
        }

        public final Object c() {
            return this.f49694c;
        }

        public final Object d() {
            return this.f49693b;
        }

        public final void e(int i3) {
            int i4;
            if (this.f49695d == Integer.MIN_VALUE || (i4 = this.f49696e) == Integer.MIN_VALUE) {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
            if (i4 <= 0 || this.f49692a.size() % i3 == 0) {
                if (this.f49695d % i3 == 0) {
                    return;
                }
                throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.f49695d + ", pageSize = " + i3);
            }
            throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.f49692a.size() + ", position " + this.f49695d + ", totalCount " + (this.f49695d + this.f49692a.size() + this.f49696e) + ", pageSize " + i3);
        }

        public boolean equals(Object obj) {
            if (obj instanceof BaseResult) {
                BaseResult baseResult = (BaseResult) obj;
                if (Intrinsics.areEqual(this.f49692a, baseResult.f49692a) && Intrinsics.areEqual(this.f49693b, baseResult.f49693b) && Intrinsics.areEqual(this.f49694c, baseResult.f49694c) && this.f49695d == baseResult.f49695d && this.f49696e == baseResult.f49696e) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, obj, obj2, (i5 & 8) != 0 ? Integer.MIN_VALUE : i3, (i5 & 16) != 0 ? Integer.MIN_VALUE : i4);
        }
    }
}
