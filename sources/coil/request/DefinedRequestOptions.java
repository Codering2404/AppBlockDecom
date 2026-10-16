package coil.request;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class DefinedRequestOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f56027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SizeResolver f56028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Scale f56029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineDispatcher f56030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineDispatcher f56031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineDispatcher f56032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineDispatcher f56033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Transition.Factory f56034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Precision f56035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bitmap.Config f56036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Boolean f56037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Boolean f56038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CachePolicy f56039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CachePolicy f56040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CachePolicy f56041o;

    public DefinedRequestOptions(Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f56027a = lifecycle;
        this.f56028b = sizeResolver;
        this.f56029c = scale;
        this.f56030d = coroutineDispatcher;
        this.f56031e = coroutineDispatcher2;
        this.f56032f = coroutineDispatcher3;
        this.f56033g = coroutineDispatcher4;
        this.f56034h = factory;
        this.f56035i = precision;
        this.f56036j = config;
        this.f56037k = bool;
        this.f56038l = bool2;
        this.f56039m = cachePolicy;
        this.f56040n = cachePolicy2;
        this.f56041o = cachePolicy3;
    }

    public final Boolean a() {
        return this.f56037k;
    }

    public final Boolean b() {
        return this.f56038l;
    }

    public final Bitmap.Config c() {
        return this.f56036j;
    }

    public final CoroutineDispatcher d() {
        return this.f56032f;
    }

    public final CachePolicy e() {
        return this.f56040n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefinedRequestOptions)) {
            return false;
        }
        DefinedRequestOptions definedRequestOptions = (DefinedRequestOptions) obj;
        return Intrinsics.areEqual(this.f56027a, definedRequestOptions.f56027a) && Intrinsics.areEqual(this.f56028b, definedRequestOptions.f56028b) && this.f56029c == definedRequestOptions.f56029c && Intrinsics.areEqual(this.f56030d, definedRequestOptions.f56030d) && Intrinsics.areEqual(this.f56031e, definedRequestOptions.f56031e) && Intrinsics.areEqual(this.f56032f, definedRequestOptions.f56032f) && Intrinsics.areEqual(this.f56033g, definedRequestOptions.f56033g) && Intrinsics.areEqual(this.f56034h, definedRequestOptions.f56034h) && this.f56035i == definedRequestOptions.f56035i && this.f56036j == definedRequestOptions.f56036j && Intrinsics.areEqual(this.f56037k, definedRequestOptions.f56037k) && Intrinsics.areEqual(this.f56038l, definedRequestOptions.f56038l) && this.f56039m == definedRequestOptions.f56039m && this.f56040n == definedRequestOptions.f56040n && this.f56041o == definedRequestOptions.f56041o;
    }

    public final CoroutineDispatcher f() {
        return this.f56031e;
    }

    public final CoroutineDispatcher g() {
        return this.f56030d;
    }

    public final Lifecycle h() {
        return this.f56027a;
    }

    public int hashCode() {
        Lifecycle lifecycle = this.f56027a;
        int iHashCode = (lifecycle != null ? lifecycle.hashCode() : 0) * 31;
        SizeResolver sizeResolver = this.f56028b;
        int iHashCode2 = (iHashCode + (sizeResolver != null ? sizeResolver.hashCode() : 0)) * 31;
        Scale scale = this.f56029c;
        int iHashCode3 = (iHashCode2 + (scale != null ? scale.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher = this.f56030d;
        int iHashCode4 = (iHashCode3 + (coroutineDispatcher != null ? coroutineDispatcher.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher2 = this.f56031e;
        int iHashCode5 = (iHashCode4 + (coroutineDispatcher2 != null ? coroutineDispatcher2.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher3 = this.f56032f;
        int iHashCode6 = (iHashCode5 + (coroutineDispatcher3 != null ? coroutineDispatcher3.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher4 = this.f56033g;
        int iHashCode7 = (iHashCode6 + (coroutineDispatcher4 != null ? coroutineDispatcher4.hashCode() : 0)) * 31;
        Transition.Factory factory = this.f56034h;
        int iHashCode8 = (iHashCode7 + (factory != null ? factory.hashCode() : 0)) * 31;
        Precision precision = this.f56035i;
        int iHashCode9 = (iHashCode8 + (precision != null ? precision.hashCode() : 0)) * 31;
        Bitmap.Config config = this.f56036j;
        int iHashCode10 = (iHashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.f56037k;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.f56038l;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy = this.f56039m;
        int iHashCode13 = (iHashCode12 + (cachePolicy != null ? cachePolicy.hashCode() : 0)) * 31;
        CachePolicy cachePolicy2 = this.f56040n;
        int iHashCode14 = (iHashCode13 + (cachePolicy2 != null ? cachePolicy2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy3 = this.f56041o;
        return iHashCode14 + (cachePolicy3 != null ? cachePolicy3.hashCode() : 0);
    }

    public final CachePolicy i() {
        return this.f56039m;
    }

    public final CachePolicy j() {
        return this.f56041o;
    }

    public final Precision k() {
        return this.f56035i;
    }

    public final Scale l() {
        return this.f56029c;
    }

    public final SizeResolver m() {
        return this.f56028b;
    }

    public final CoroutineDispatcher n() {
        return this.f56033g;
    }

    public final Transition.Factory o() {
        return this.f56034h;
    }
}
