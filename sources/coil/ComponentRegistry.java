package coil;

import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.key.Keyer;
import coil.map.Mapper;
import coil.request.Options;
import coil.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ComponentRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f55410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f55411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f55412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f55413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f55414e;

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    public final List a() {
        return this.f55414e;
    }

    public final List b() {
        return this.f55413d;
    }

    public final List c() {
        return this.f55410a;
    }

    public final List d() {
        return this.f55412c;
    }

    public final List e() {
        return this.f55411b;
    }

    public final String f(Object obj, Options options) {
        List list = this.f55412c;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) list.get(i3);
            Keyer keyer = (Keyer) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(keyer, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String strA = keyer.a(obj, options);
                if (strA != null) {
                    return strA;
                }
            }
        }
        return null;
    }

    public final Object g(Object obj, Options options) {
        List list = this.f55411b;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) list.get(i3);
            Mapper mapper = (Mapper) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(mapper, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object objA = mapper.a(obj, options);
                if (objA != null) {
                    obj = objA;
                }
            }
        }
        return obj;
    }

    public final Builder h() {
        return new Builder(this);
    }

    public final Pair i(SourceResult sourceResult, Options options, ImageLoader imageLoader, int i3) {
        int size = this.f55414e.size();
        while (i3 < size) {
            Decoder decoderA = ((Decoder.Factory) this.f55414e.get(i3)).a(sourceResult, options, imageLoader);
            if (decoderA != null) {
                return TuplesKt.a(decoderA, Integer.valueOf(i3));
            }
            i3++;
        }
        return null;
    }

    public final Pair j(Object obj, Options options, ImageLoader imageLoader, int i3) {
        int size = this.f55413d.size();
        while (i3 < size) {
            Pair pair = (Pair) this.f55413d.get(i3);
            Fetcher.Factory factory = (Fetcher.Factory) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher fetcherA = factory.a(obj, options, imageLoader);
                if (fetcherA != null) {
                    return TuplesKt.a(fetcherA, Integer.valueOf(i3));
                }
            }
            i3++;
        }
        return null;
    }

    private ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.f55410a = list;
        this.f55411b = list2;
        this.f55412c = list3;
        this.f55413d = list4;
        this.f55414e = list5;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f55415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f55416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f55417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f55418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f55419e;

        public Builder() {
            this.f55415a = new ArrayList();
            this.f55416b = new ArrayList();
            this.f55417c = new ArrayList();
            this.f55418d = new ArrayList();
            this.f55419e = new ArrayList();
        }

        public final Builder a(Decoder.Factory factory) {
            this.f55419e.add(factory);
            return this;
        }

        public final Builder b(Fetcher.Factory factory, Class cls) {
            this.f55418d.add(TuplesKt.a(factory, cls));
            return this;
        }

        public final Builder c(Interceptor interceptor) {
            this.f55415a.add(interceptor);
            return this;
        }

        public final Builder d(Keyer keyer, Class cls) {
            this.f55417c.add(TuplesKt.a(keyer, cls));
            return this;
        }

        public final Builder e(Mapper mapper, Class cls) {
            this.f55416b.add(TuplesKt.a(mapper, cls));
            return this;
        }

        public final ComponentRegistry f() {
            return new ComponentRegistry(Collections.a(this.f55415a), Collections.a(this.f55416b), Collections.a(this.f55417c), Collections.a(this.f55418d), Collections.a(this.f55419e), null);
        }

        public final List g() {
            return this.f55419e;
        }

        public final List h() {
            return this.f55418d;
        }

        public Builder(ComponentRegistry componentRegistry) {
            this.f55415a = CollectionsKt.toMutableList((Collection) componentRegistry.c());
            this.f55416b = CollectionsKt.toMutableList((Collection) componentRegistry.e());
            this.f55417c = CollectionsKt.toMutableList((Collection) componentRegistry.d());
            this.f55418d = CollectionsKt.toMutableList((Collection) componentRegistry.b());
            this.f55419e = CollectionsKt.toMutableList((Collection) componentRegistry.a());
        }
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
