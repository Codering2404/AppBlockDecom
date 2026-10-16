package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import coil.size.Scale;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

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
public final class Options {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f56115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap.Config f56116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorSpace f56117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Size f56118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Scale f56119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f56121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f56122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f56123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Headers f56124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Tags f56125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Parameters f56126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CachePolicy f56127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CachePolicy f56128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CachePolicy f56129o;

    public Options(Context context, Bitmap.Config config, ColorSpace colorSpace, Size size, Scale scale, boolean z2, boolean z3, boolean z4, String str, Headers headers, Tags tags, Parameters parameters, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f56115a = context;
        this.f56116b = config;
        this.f56117c = colorSpace;
        this.f56118d = size;
        this.f56119e = scale;
        this.f56120f = z2;
        this.f56121g = z3;
        this.f56122h = z4;
        this.f56123i = str;
        this.f56124j = headers;
        this.f56125k = tags;
        this.f56126l = parameters;
        this.f56127m = cachePolicy;
        this.f56128n = cachePolicy2;
        this.f56129o = cachePolicy3;
    }

    public final Options a(Context context, Bitmap.Config config, ColorSpace colorSpace, Size size, Scale scale, boolean z2, boolean z3, boolean z4, String str, Headers headers, Tags tags, Parameters parameters, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new Options(context, config, colorSpace, size, scale, z2, z3, z4, str, headers, tags, parameters, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public final boolean c() {
        return this.f56120f;
    }

    public final boolean d() {
        return this.f56121g;
    }

    public final ColorSpace e() {
        return this.f56117c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        return Intrinsics.areEqual(this.f56115a, options.f56115a) && this.f56116b == options.f56116b && Intrinsics.areEqual(this.f56117c, options.f56117c) && Intrinsics.areEqual(this.f56118d, options.f56118d) && this.f56119e == options.f56119e && this.f56120f == options.f56120f && this.f56121g == options.f56121g && this.f56122h == options.f56122h && Intrinsics.areEqual(this.f56123i, options.f56123i) && Intrinsics.areEqual(this.f56124j, options.f56124j) && Intrinsics.areEqual(this.f56125k, options.f56125k) && Intrinsics.areEqual(this.f56126l, options.f56126l) && this.f56127m == options.f56127m && this.f56128n == options.f56128n && this.f56129o == options.f56129o;
    }

    public final Bitmap.Config f() {
        return this.f56116b;
    }

    public final Context g() {
        return this.f56115a;
    }

    public final String h() {
        return this.f56123i;
    }

    public int hashCode() {
        int iHashCode = ((this.f56115a.hashCode() * 31) + this.f56116b.hashCode()) * 31;
        ColorSpace colorSpace = this.f56117c;
        int iHashCode2 = (((((((((((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.f56118d.hashCode()) * 31) + this.f56119e.hashCode()) * 31) + Boolean.hashCode(this.f56120f)) * 31) + Boolean.hashCode(this.f56121g)) * 31) + Boolean.hashCode(this.f56122h)) * 31;
        String str = this.f56123i;
        return ((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f56124j.hashCode()) * 31) + this.f56125k.hashCode()) * 31) + this.f56126l.hashCode()) * 31) + this.f56127m.hashCode()) * 31) + this.f56128n.hashCode()) * 31) + this.f56129o.hashCode();
    }

    public final CachePolicy i() {
        return this.f56128n;
    }

    public final Headers j() {
        return this.f56124j;
    }

    public final CachePolicy k() {
        return this.f56129o;
    }

    public final Parameters l() {
        return this.f56126l;
    }

    public final boolean m() {
        return this.f56122h;
    }

    public final Scale n() {
        return this.f56119e;
    }

    public final Size o() {
        return this.f56118d;
    }

    public final Tags p() {
        return this.f56125k;
    }
}
