package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.size.Precision;
import coil.transition.Transition;
import coil.util.Utils;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

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
public final class DefaultRequestOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineDispatcher f56012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineDispatcher f56013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f56014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineDispatcher f56015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Transition.Factory f56016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Precision f56017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bitmap.Config f56018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f56019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f56020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Drawable f56021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Drawable f56022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Drawable f56023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CachePolicy f56024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CachePolicy f56025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CachePolicy f56026o;

    public DefaultRequestOptions(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision, Bitmap.Config config, boolean z2, boolean z3, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f56012a = coroutineDispatcher;
        this.f56013b = coroutineDispatcher2;
        this.f56014c = coroutineDispatcher3;
        this.f56015d = coroutineDispatcher4;
        this.f56016e = factory;
        this.f56017f = precision;
        this.f56018g = config;
        this.f56019h = z2;
        this.f56020i = z3;
        this.f56021j = drawable;
        this.f56022k = drawable2;
        this.f56023l = drawable3;
        this.f56024m = cachePolicy;
        this.f56025n = cachePolicy2;
        this.f56026o = cachePolicy3;
    }

    public final boolean a() {
        return this.f56019h;
    }

    public final boolean b() {
        return this.f56020i;
    }

    public final Bitmap.Config c() {
        return this.f56018g;
    }

    public final CoroutineDispatcher d() {
        return this.f56014c;
    }

    public final CachePolicy e() {
        return this.f56025n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultRequestOptions)) {
            return false;
        }
        DefaultRequestOptions defaultRequestOptions = (DefaultRequestOptions) obj;
        return Intrinsics.areEqual(this.f56012a, defaultRequestOptions.f56012a) && Intrinsics.areEqual(this.f56013b, defaultRequestOptions.f56013b) && Intrinsics.areEqual(this.f56014c, defaultRequestOptions.f56014c) && Intrinsics.areEqual(this.f56015d, defaultRequestOptions.f56015d) && Intrinsics.areEqual(this.f56016e, defaultRequestOptions.f56016e) && this.f56017f == defaultRequestOptions.f56017f && this.f56018g == defaultRequestOptions.f56018g && this.f56019h == defaultRequestOptions.f56019h && this.f56020i == defaultRequestOptions.f56020i && Intrinsics.areEqual(this.f56021j, defaultRequestOptions.f56021j) && Intrinsics.areEqual(this.f56022k, defaultRequestOptions.f56022k) && Intrinsics.areEqual(this.f56023l, defaultRequestOptions.f56023l) && this.f56024m == defaultRequestOptions.f56024m && this.f56025n == defaultRequestOptions.f56025n && this.f56026o == defaultRequestOptions.f56026o;
    }

    public final Drawable f() {
        return this.f56022k;
    }

    public final Drawable g() {
        return this.f56023l;
    }

    public final CoroutineDispatcher h() {
        return this.f56013b;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.f56012a.hashCode() * 31) + this.f56013b.hashCode()) * 31) + this.f56014c.hashCode()) * 31) + this.f56015d.hashCode()) * 31) + this.f56016e.hashCode()) * 31) + this.f56017f.hashCode()) * 31) + this.f56018g.hashCode()) * 31) + Boolean.hashCode(this.f56019h)) * 31) + Boolean.hashCode(this.f56020i)) * 31;
        Drawable drawable = this.f56021j;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.f56022k;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.f56023l;
        return ((((((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.f56024m.hashCode()) * 31) + this.f56025n.hashCode()) * 31) + this.f56026o.hashCode();
    }

    public final CoroutineDispatcher i() {
        return this.f56012a;
    }

    public final CachePolicy j() {
        return this.f56024m;
    }

    public final CachePolicy k() {
        return this.f56026o;
    }

    public final Drawable l() {
        return this.f56021j;
    }

    public final Precision m() {
        return this.f56017f;
    }

    public final CoroutineDispatcher n() {
        return this.f56015d;
    }

    public final Transition.Factory o() {
        return this.f56016e;
    }

    public /* synthetic */ DefaultRequestOptions(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision, Bitmap.Config config, boolean z2, boolean z3, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.c().w0() : coroutineDispatcher, (i3 & 2) != 0 ? Dispatchers.b() : coroutineDispatcher2, (i3 & 4) != 0 ? Dispatchers.b() : coroutineDispatcher3, (i3 & 8) != 0 ? Dispatchers.b() : coroutineDispatcher4, (i3 & 16) != 0 ? Transition.Factory.f56204b : factory, (i3 & 32) != 0 ? Precision.AUTOMATIC : precision, (i3 & 64) != 0 ? Utils.f() : config, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? true : z2, (i3 & Function.MAX_NARGS) != 0 ? false : z3, (i3 & 512) != 0 ? null : drawable, (i3 & 1024) != 0 ? null : drawable2, (i3 & 2048) == 0 ? drawable3 : null, (i3 & 4096) != 0 ? CachePolicy.ENABLED : cachePolicy, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i3 & 16384) != 0 ? CachePolicy.ENABLED : cachePolicy3);
    }
}
