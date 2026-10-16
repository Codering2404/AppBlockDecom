package coil.network;

import coil.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CacheResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f55976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f55977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f55978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f55979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f55980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Headers f55981f;

    public CacheResponse(BufferedSource bufferedSource) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        this.f55976a = LazyKt.a(lazyThreadSafetyMode, new Function0<CacheControl>() { // from class: coil.network.CacheResponse$cacheControl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CacheControl invoke() {
                return CacheControl.f143911n.b(this.f55982a.d());
            }
        });
        this.f55977b = LazyKt.a(lazyThreadSafetyMode, new Function0<MediaType>() { // from class: coil.network.CacheResponse$contentType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MediaType invoke() {
                String strA = this.f55983a.d().a("Content-Type");
                if (strA != null) {
                    return MediaType.f144108e.b(strA);
                }
                return null;
            }
        });
        this.f55978c = Long.parseLong(bufferedSource.Q0());
        this.f55979d = Long.parseLong(bufferedSource.Q0());
        this.f55980e = Integer.parseInt(bufferedSource.Q0()) > 0;
        int i3 = Integer.parseInt(bufferedSource.Q0());
        Headers.Builder builder = new Headers.Builder();
        for (int i4 = 0; i4 < i3; i4++) {
            Utils.b(builder, bufferedSource.Q0());
        }
        this.f55981f = builder.f();
    }

    public final CacheControl a() {
        return (CacheControl) this.f55976a.getValue();
    }

    public final MediaType b() {
        return (MediaType) this.f55977b.getValue();
    }

    public final long c() {
        return this.f55979d;
    }

    public final Headers d() {
        return this.f55981f;
    }

    public final long e() {
        return this.f55978c;
    }

    public final boolean f() {
        return this.f55980e;
    }

    public final void g(BufferedSink bufferedSink) {
        bufferedSink.j1(this.f55978c).writeByte(10);
        bufferedSink.j1(this.f55979d).writeByte(10);
        bufferedSink.j1(this.f55980e ? 1L : 0L).writeByte(10);
        bufferedSink.j1(this.f55981f.size()).writeByte(10);
        int size = this.f55981f.size();
        for (int i3 = 0; i3 < size; i3++) {
            bufferedSink.C0(this.f55981f.d(i3)).C0(": ").C0(this.f55981f.h(i3)).writeByte(10);
        }
    }

    public CacheResponse(Response response) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        this.f55976a = LazyKt.a(lazyThreadSafetyMode, new Function0<CacheControl>() { // from class: coil.network.CacheResponse$cacheControl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CacheControl invoke() {
                return CacheControl.f143911n.b(this.f55982a.d());
            }
        });
        this.f55977b = LazyKt.a(lazyThreadSafetyMode, new Function0<MediaType>() { // from class: coil.network.CacheResponse$contentType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MediaType invoke() {
                String strA = this.f55983a.d().a("Content-Type");
                if (strA != null) {
                    return MediaType.f144108e.b(strA);
                }
                return null;
            }
        });
        this.f55978c = response.O();
        this.f55979d = response.M();
        this.f55980e = response.k() != null;
        this.f55981f = response.r();
    }
}
