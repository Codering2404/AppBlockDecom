package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil.decode.Decoder;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.size.Dimension;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import coil.size.ViewSizeResolver;
import coil.size.ViewSizeResolvers;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.Contexts;
import coil.util.Requests;
import coil.util.Utils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

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
public final class ImageRequest {
    private final Lifecycle A;
    private final SizeResolver B;
    private final Scale C;
    private final Parameters D;
    private final MemoryCache.Key E;
    private final Integer F;
    private final Drawable G;
    private final Integer H;
    private final Drawable I;
    private final Integer J;
    private final Drawable K;
    private final DefinedRequestOptions L;
    private final DefaultRequestOptions M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f56047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f56048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Target f56049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Listener f56050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MemoryCache.Key f56051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f56052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bitmap.Config f56053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ColorSpace f56054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Precision f56055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Pair f56056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Decoder.Factory f56057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f56058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Transition.Factory f56059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Headers f56060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Tags f56061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f56062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f56063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f56064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f56065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final CachePolicy f56066t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final CachePolicy f56067u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final CachePolicy f56068v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final CoroutineDispatcher f56069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CoroutineDispatcher f56070x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final CoroutineDispatcher f56071y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final CoroutineDispatcher f56072z;

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z2, boolean z3, boolean z4, boolean z5, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, key, str, config, colorSpace, precision, pair, factory, list, factory2, headers, tags, z2, z3, z4, z5, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, parameters, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    public static /* synthetic */ Builder R(ImageRequest imageRequest, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = imageRequest.f56047a;
        }
        return imageRequest.Q(context);
    }

    public final Listener A() {
        return this.f56050d;
    }

    public final MemoryCache.Key B() {
        return this.f56051e;
    }

    public final CachePolicy C() {
        return this.f56066t;
    }

    public final CachePolicy D() {
        return this.f56068v;
    }

    public final Parameters E() {
        return this.D;
    }

    public final Drawable F() {
        return Requests.c(this, this.G, this.F, this.M.l());
    }

    public final MemoryCache.Key G() {
        return this.E;
    }

    public final Precision H() {
        return this.f56055i;
    }

    public final boolean I() {
        return this.f56065s;
    }

    public final Scale J() {
        return this.C;
    }

    public final SizeResolver K() {
        return this.B;
    }

    public final Tags L() {
        return this.f56061o;
    }

    public final Target M() {
        return this.f56049c;
    }

    public final CoroutineDispatcher N() {
        return this.f56072z;
    }

    public final List O() {
        return this.f56058l;
    }

    public final Transition.Factory P() {
        return this.f56059m;
    }

    public final Builder Q(Context context) {
        return new Builder(this, context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual(this.f56047a, imageRequest.f56047a) && Intrinsics.areEqual(this.f56048b, imageRequest.f56048b) && Intrinsics.areEqual(this.f56049c, imageRequest.f56049c) && Intrinsics.areEqual(this.f56050d, imageRequest.f56050d) && Intrinsics.areEqual(this.f56051e, imageRequest.f56051e) && Intrinsics.areEqual(this.f56052f, imageRequest.f56052f) && this.f56053g == imageRequest.f56053g && Intrinsics.areEqual(this.f56054h, imageRequest.f56054h) && this.f56055i == imageRequest.f56055i && Intrinsics.areEqual(this.f56056j, imageRequest.f56056j) && Intrinsics.areEqual(this.f56057k, imageRequest.f56057k) && Intrinsics.areEqual(this.f56058l, imageRequest.f56058l) && Intrinsics.areEqual(this.f56059m, imageRequest.f56059m) && Intrinsics.areEqual(this.f56060n, imageRequest.f56060n) && Intrinsics.areEqual(this.f56061o, imageRequest.f56061o) && this.f56062p == imageRequest.f56062p && this.f56063q == imageRequest.f56063q && this.f56064r == imageRequest.f56064r && this.f56065s == imageRequest.f56065s && this.f56066t == imageRequest.f56066t && this.f56067u == imageRequest.f56067u && this.f56068v == imageRequest.f56068v && Intrinsics.areEqual(this.f56069w, imageRequest.f56069w) && Intrinsics.areEqual(this.f56070x, imageRequest.f56070x) && Intrinsics.areEqual(this.f56071y, imageRequest.f56071y) && Intrinsics.areEqual(this.f56072z, imageRequest.f56072z) && Intrinsics.areEqual(this.E, imageRequest.E) && Intrinsics.areEqual(this.F, imageRequest.F) && Intrinsics.areEqual(this.G, imageRequest.G) && Intrinsics.areEqual(this.H, imageRequest.H) && Intrinsics.areEqual(this.I, imageRequest.I) && Intrinsics.areEqual(this.J, imageRequest.J) && Intrinsics.areEqual(this.K, imageRequest.K) && Intrinsics.areEqual(this.A, imageRequest.A) && Intrinsics.areEqual(this.B, imageRequest.B) && this.C == imageRequest.C && Intrinsics.areEqual(this.D, imageRequest.D) && Intrinsics.areEqual(this.L, imageRequest.L) && Intrinsics.areEqual(this.M, imageRequest.M);
    }

    public final boolean g() {
        return this.f56062p;
    }

    public final boolean h() {
        return this.f56063q;
    }

    public int hashCode() {
        int iHashCode = ((this.f56047a.hashCode() * 31) + this.f56048b.hashCode()) * 31;
        Target target = this.f56049c;
        int iHashCode2 = (iHashCode + (target != null ? target.hashCode() : 0)) * 31;
        Listener listener = this.f56050d;
        int iHashCode3 = (iHashCode2 + (listener != null ? listener.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.f56051e;
        int iHashCode4 = (iHashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.f56052f;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.f56053g.hashCode()) * 31;
        ColorSpace colorSpace = this.f56054h;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.f56055i.hashCode()) * 31;
        Pair pair = this.f56056j;
        int iHashCode7 = (iHashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder.Factory factory = this.f56057k;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (factory != null ? factory.hashCode() : 0)) * 31) + this.f56058l.hashCode()) * 31) + this.f56059m.hashCode()) * 31) + this.f56060n.hashCode()) * 31) + this.f56061o.hashCode()) * 31) + Boolean.hashCode(this.f56062p)) * 31) + Boolean.hashCode(this.f56063q)) * 31) + Boolean.hashCode(this.f56064r)) * 31) + Boolean.hashCode(this.f56065s)) * 31) + this.f56066t.hashCode()) * 31) + this.f56067u.hashCode()) * 31) + this.f56068v.hashCode()) * 31) + this.f56069w.hashCode()) * 31) + this.f56070x.hashCode()) * 31) + this.f56071y.hashCode()) * 31) + this.f56072z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31;
        MemoryCache.Key key2 = this.E;
        int iHashCode9 = (iHashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.F;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.G;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.H;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.I;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.J;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.K;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.L.hashCode()) * 31) + this.M.hashCode();
    }

    public final boolean i() {
        return this.f56064r;
    }

    public final Bitmap.Config j() {
        return this.f56053g;
    }

    public final ColorSpace k() {
        return this.f56054h;
    }

    public final Context l() {
        return this.f56047a;
    }

    public final Object m() {
        return this.f56048b;
    }

    public final CoroutineDispatcher n() {
        return this.f56071y;
    }

    public final Decoder.Factory o() {
        return this.f56057k;
    }

    public final DefaultRequestOptions p() {
        return this.M;
    }

    public final DefinedRequestOptions q() {
        return this.L;
    }

    public final String r() {
        return this.f56052f;
    }

    public final CachePolicy s() {
        return this.f56067u;
    }

    public final Drawable t() {
        return Requests.c(this, this.I, this.H, this.M.f());
    }

    public final Drawable u() {
        return Requests.c(this, this.K, this.J, this.M.g());
    }

    public final CoroutineDispatcher v() {
        return this.f56070x;
    }

    public final Pair w() {
        return this.f56056j;
    }

    public final Headers x() {
        return this.f56060n;
    }

    public final CoroutineDispatcher y() {
        return this.f56069w;
    }

    public final Lifecycle z() {
        return this.A;
    }

    private ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z2, boolean z3, boolean z4, boolean z5, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.f56047a = context;
        this.f56048b = obj;
        this.f56049c = target;
        this.f56050d = listener;
        this.f56051e = key;
        this.f56052f = str;
        this.f56053g = config;
        this.f56054h = colorSpace;
        this.f56055i = precision;
        this.f56056j = pair;
        this.f56057k = factory;
        this.f56058l = list;
        this.f56059m = factory2;
        this.f56060n = headers;
        this.f56061o = tags;
        this.f56062p = z2;
        this.f56063q = z3;
        this.f56064r = z4;
        this.f56065s = z5;
        this.f56066t = cachePolicy;
        this.f56067u = cachePolicy2;
        this.f56068v = cachePolicy3;
        this.f56069w = coroutineDispatcher;
        this.f56070x = coroutineDispatcher2;
        this.f56071y = coroutineDispatcher3;
        this.f56072z = coroutineDispatcher4;
        this.A = lifecycle;
        this.B = sizeResolver;
        this.C = scale;
        this.D = parameters;
        this.E = key2;
        this.F = num;
        this.G = drawable;
        this.H = num2;
        this.I = drawable2;
        this.J = num3;
        this.K = drawable3;
        this.L = definedRequestOptions;
        this.M = defaultRequestOptions;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Listener {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        default void a(ImageRequest imageRequest) {
        }

        default void b(ImageRequest imageRequest) {
        }

        default void c(ImageRequest imageRequest, ErrorResult errorResult) {
        }

        default void d(ImageRequest imageRequest, SuccessResult successResult) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        private CoroutineDispatcher A;
        private Parameters.Builder B;
        private MemoryCache.Key C;
        private Integer D;
        private Drawable E;
        private Integer F;
        private Drawable G;
        private Integer H;
        private Drawable I;
        private Lifecycle J;
        private SizeResolver K;
        private Scale L;
        private Lifecycle M;
        private SizeResolver N;
        private Scale O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f56073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DefaultRequestOptions f56074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f56075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Target f56076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Listener f56077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MemoryCache.Key f56078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f56079g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Bitmap.Config f56080h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ColorSpace f56081i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Precision f56082j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Pair f56083k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Decoder.Factory f56084l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List f56085m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Transition.Factory f56086n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Headers.Builder f56087o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Map f56088p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f56089q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Boolean f56090r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Boolean f56091s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f56092t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private CachePolicy f56093u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private CachePolicy f56094v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private CachePolicy f56095w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private CoroutineDispatcher f56096x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private CoroutineDispatcher f56097y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private CoroutineDispatcher f56098z;

        public Builder(Context context) {
            this.f56073a = context;
            this.f56074b = Requests.b();
            this.f56075c = null;
            this.f56076d = null;
            this.f56077e = null;
            this.f56078f = null;
            this.f56079g = null;
            this.f56080h = null;
            this.f56081i = null;
            this.f56082j = null;
            this.f56083k = null;
            this.f56084l = null;
            this.f56085m = CollectionsKt.emptyList();
            this.f56086n = null;
            this.f56087o = null;
            this.f56088p = null;
            this.f56089q = true;
            this.f56090r = null;
            this.f56091s = null;
            this.f56092t = true;
            this.f56093u = null;
            this.f56094v = null;
            this.f56095w = null;
            this.f56096x = null;
            this.f56097y = null;
            this.f56098z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final void k() {
            this.O = null;
        }

        private final void l() {
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final Lifecycle m() {
            Target target = this.f56076d;
            Lifecycle lifecycleC = Contexts.c(target instanceof ViewTarget ? ((ViewTarget) target).a().getContext() : this.f56073a);
            return lifecycleC == null ? GlobalLifecycle.f56045a : lifecycleC;
        }

        private final Scale n() {
            View viewA;
            SizeResolver sizeResolver = this.K;
            View viewA2 = null;
            ViewSizeResolver viewSizeResolver = sizeResolver instanceof ViewSizeResolver ? (ViewSizeResolver) sizeResolver : null;
            if (viewSizeResolver == null || (viewA = viewSizeResolver.a()) == null) {
                Target target = this.f56076d;
                ViewTarget viewTarget = target instanceof ViewTarget ? (ViewTarget) target : null;
                if (viewTarget != null) {
                    viewA2 = viewTarget.a();
                }
            } else {
                viewA2 = viewA;
            }
            return viewA2 instanceof ImageView ? Utils.o((ImageView) viewA2) : Scale.FIT;
        }

        private final SizeResolver o() {
            ImageView.ScaleType scaleType;
            Target target = this.f56076d;
            if (!(target instanceof ViewTarget)) {
                return new DisplaySizeResolver(this.f56073a);
            }
            View viewA = ((ViewTarget) target).a();
            return ((viewA instanceof ImageView) && ((scaleType = ((ImageView) viewA).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) ? SizeResolvers.a(Size.f56177d) : ViewSizeResolvers.b(viewA, false, 2, null);
        }

        public final ImageRequest a() {
            Context context = this.f56073a;
            Object obj = this.f56075c;
            if (obj == null) {
                obj = NullRequestData.f56113a;
            }
            Object obj2 = obj;
            Target target = this.f56076d;
            Listener listener = this.f56077e;
            MemoryCache.Key key = this.f56078f;
            String str = this.f56079g;
            Bitmap.Config configC = this.f56080h;
            if (configC == null) {
                configC = this.f56074b.c();
            }
            Bitmap.Config config = configC;
            ColorSpace colorSpace = this.f56081i;
            Precision precisionM = this.f56082j;
            if (precisionM == null) {
                precisionM = this.f56074b.m();
            }
            Precision precision = precisionM;
            Pair pair = this.f56083k;
            Decoder.Factory factory = this.f56084l;
            List list = this.f56085m;
            Transition.Factory factoryO = this.f56086n;
            if (factoryO == null) {
                factoryO = this.f56074b.o();
            }
            Transition.Factory factory2 = factoryO;
            Headers.Builder builder = this.f56087o;
            Headers headersY = Utils.y(builder != null ? builder.f() : null);
            Map map = this.f56088p;
            Tags tagsX = Utils.x(map != null ? Tags.f56146b.a(map) : null);
            boolean z2 = this.f56089q;
            Boolean bool = this.f56090r;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.f56074b.a();
            Boolean bool2 = this.f56091s;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.f56074b.b();
            boolean z3 = this.f56092t;
            CachePolicy cachePolicyJ = this.f56093u;
            if (cachePolicyJ == null) {
                cachePolicyJ = this.f56074b.j();
            }
            CachePolicy cachePolicy = cachePolicyJ;
            CachePolicy cachePolicyE = this.f56094v;
            if (cachePolicyE == null) {
                cachePolicyE = this.f56074b.e();
            }
            CachePolicy cachePolicy2 = cachePolicyE;
            CachePolicy cachePolicyK = this.f56095w;
            if (cachePolicyK == null) {
                cachePolicyK = this.f56074b.k();
            }
            CachePolicy cachePolicy3 = cachePolicyK;
            CoroutineDispatcher coroutineDispatcherI = this.f56096x;
            if (coroutineDispatcherI == null) {
                coroutineDispatcherI = this.f56074b.i();
            }
            CoroutineDispatcher coroutineDispatcher = coroutineDispatcherI;
            CoroutineDispatcher coroutineDispatcherH = this.f56097y;
            if (coroutineDispatcherH == null) {
                coroutineDispatcherH = this.f56074b.h();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcherH;
            CoroutineDispatcher coroutineDispatcherD = this.f56098z;
            if (coroutineDispatcherD == null) {
                coroutineDispatcherD = this.f56074b.d();
            }
            CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcherD;
            CoroutineDispatcher coroutineDispatcherN = this.A;
            if (coroutineDispatcherN == null) {
                coroutineDispatcherN = this.f56074b.n();
            }
            CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcherN;
            Lifecycle lifecycleM = this.J;
            if (lifecycleM == null && (lifecycleM = this.M) == null) {
                lifecycleM = m();
            }
            Lifecycle lifecycle = lifecycleM;
            SizeResolver sizeResolverO = this.K;
            if (sizeResolverO == null && (sizeResolverO = this.N) == null) {
                sizeResolverO = o();
            }
            SizeResolver sizeResolver = sizeResolverO;
            Scale scaleN = this.L;
            if (scaleN == null && (scaleN = this.O) == null) {
                scaleN = n();
            }
            Scale scale = scaleN;
            Parameters.Builder builder2 = this.B;
            return new ImageRequest(context, obj2, target, listener, key, str, config, colorSpace, precision, pair, factory, list, factory2, headersY, tagsX, z2, zBooleanValue, zBooleanValue2, z3, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, Utils.w(builder2 != null ? builder2.a() : null), this.C, this.D, this.E, this.F, this.G, this.H, this.I, new DefinedRequestOptions(this.J, this.K, this.L, this.f56096x, this.f56097y, this.f56098z, this.A, this.f56086n, this.f56082j, this.f56080h, this.f56090r, this.f56091s, this.f56093u, this.f56094v, this.f56095w), this.f56074b, null);
        }

        public final Builder b(int i3) {
            Transition.Factory factory;
            if (i3 > 0) {
                factory = new CrossfadeTransition.Factory(i3, false, 2, null);
            } else {
                factory = Transition.Factory.f56204b;
            }
            v(factory);
            return this;
        }

        public final Builder c(boolean z2) {
            return b(z2 ? 100 : 0);
        }

        public final Builder d(Object obj) {
            this.f56075c = obj;
            return this;
        }

        public final Builder e(Decoder.Factory factory) {
            this.f56084l = factory;
            return this;
        }

        public final Builder f(DefaultRequestOptions defaultRequestOptions) {
            this.f56074b = defaultRequestOptions;
            k();
            return this;
        }

        public final Builder g(CachePolicy cachePolicy) {
            this.f56094v = cachePolicy;
            return this;
        }

        public final Builder h(Listener listener) {
            this.f56077e = listener;
            return this;
        }

        public final Builder i(CachePolicy cachePolicy) {
            this.f56093u = cachePolicy;
            return this;
        }

        public final Builder j(Precision precision) {
            this.f56082j = precision;
            return this;
        }

        public final Builder p(Scale scale) {
            this.L = scale;
            return this;
        }

        public final Builder q(Dimension dimension, Dimension dimension2) {
            return r(new Size(dimension, dimension2));
        }

        public final Builder r(Size size) {
            return s(SizeResolvers.a(size));
        }

        public final Builder s(SizeResolver sizeResolver) {
            this.K = sizeResolver;
            l();
            return this;
        }

        public final Builder t(Target target) {
            this.f56076d = target;
            l();
            return this;
        }

        public final Builder u(List list) {
            this.f56085m = Collections.a(list);
            return this;
        }

        public final Builder v(Transition.Factory factory) {
            this.f56086n = factory;
            return this;
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.f56073a = context;
            this.f56074b = imageRequest.p();
            this.f56075c = imageRequest.m();
            this.f56076d = imageRequest.M();
            this.f56077e = imageRequest.A();
            this.f56078f = imageRequest.B();
            this.f56079g = imageRequest.r();
            this.f56080h = imageRequest.q().c();
            this.f56081i = imageRequest.k();
            this.f56082j = imageRequest.q().k();
            this.f56083k = imageRequest.w();
            this.f56084l = imageRequest.o();
            this.f56085m = imageRequest.O();
            this.f56086n = imageRequest.q().o();
            this.f56087o = imageRequest.x().f();
            this.f56088p = MapsKt.toMutableMap(imageRequest.L().a());
            this.f56089q = imageRequest.g();
            this.f56090r = imageRequest.q().a();
            this.f56091s = imageRequest.q().b();
            this.f56092t = imageRequest.I();
            this.f56093u = imageRequest.q().i();
            this.f56094v = imageRequest.q().e();
            this.f56095w = imageRequest.q().j();
            this.f56096x = imageRequest.q().g();
            this.f56097y = imageRequest.q().f();
            this.f56098z = imageRequest.q().d();
            this.A = imageRequest.q().n();
            this.B = imageRequest.E().d();
            this.C = imageRequest.G();
            this.D = imageRequest.F;
            this.E = imageRequest.G;
            this.F = imageRequest.H;
            this.G = imageRequest.I;
            this.H = imageRequest.J;
            this.I = imageRequest.K;
            this.J = imageRequest.q().h();
            this.K = imageRequest.q().m();
            this.L = imageRequest.q().l();
            if (imageRequest.l() == context) {
                this.M = imageRequest.z();
                this.N = imageRequest.K();
                this.O = imageRequest.J();
            } else {
                this.M = null;
                this.N = null;
                this.O = null;
            }
        }
    }
}
