package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.EventListener;
import coil.decode.BitmapFactoryDecoder;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.OneShotDisposable;
import coil.request.RequestService;
import coil.target.ViewTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.HttpUrl;

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
public final class RealImageLoader implements ImageLoader {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f55441p = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f55442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DefaultRequestOptions f55443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f55444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f55445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f55446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventListener.Factory f55447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ComponentRegistry f55448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageLoaderOptions f55449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Logger f55450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CoroutineScope f55451j = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.c().w0()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.u8, this)));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SystemCallbacks f55452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RequestService f55453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ComponentRegistry f55454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f55455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f55456o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy lazy, Lazy lazy2, Lazy lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.f55442a = context;
        this.f55443b = defaultRequestOptions;
        this.f55444c = lazy;
        this.f55445d = lazy2;
        this.f55446e = lazy3;
        this.f55447f = factory;
        this.f55448g = componentRegistry;
        this.f55449h = imageLoaderOptions;
        this.f55450i = logger;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this, context, imageLoaderOptions.d());
        this.f55452k = systemCallbacks;
        RequestService requestService = new RequestService(this, systemCallbacks, logger);
        this.f55453l = requestService;
        this.f55454m = componentRegistry.h().e(new HttpUrlMapper(), HttpUrl.class).e(new StringMapper(), String.class).e(new FileUriMapper(), Uri.class).e(new ResourceUriMapper(), Uri.class).e(new ResourceIntMapper(), Integer.class).e(new ByteArrayMapper(), byte[].class).d(new UriKeyer(), Uri.class).d(new FileKeyer(imageLoaderOptions.a()), File.class).b(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.e()), Uri.class).b(new FileFetcher.Factory(), File.class).b(new AssetUriFetcher.Factory(), Uri.class).b(new ContentUriFetcher.Factory(), Uri.class).b(new ResourceUriFetcher.Factory(), Uri.class).b(new DrawableFetcher.Factory(), Drawable.class).b(new BitmapFetcher.Factory(), Bitmap.class).b(new ByteBufferFetcher.Factory(), ByteBuffer.class).a(new BitmapFactoryDecoder.Factory(imageLoaderOptions.c(), imageLoaderOptions.b())).f();
        this.f55455n = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().c(), new EngineInterceptor(this, requestService, logger));
        this.f55456o = new AtomicBoolean(false);
        systemCallbacks.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(4:(1:(7:13|111|14|76|(1:78)(2:79|(1:81))|82|83)(2:18|19))(13:20|105|21|22|23|109|69|70|101|71|72|(5:75|76|(0)(0)|82|83)|74)|113|90|(3:92|93|94)(2:97|98))(4:26|103|27|41))(4:32|112|33|(2:35|(3:37|(2:40|41)|74)(1:44))(2:88|89))|107|45|(11:47|(1:49)(1:52)|(1:54)|(1:57)(1:58)|59|(1:61)|62|(1:64)|65|(9:68|23|109|69|70|101|71|72|(0))|74)|55|(0)(0)|59|(0)|62|(0)|65|(0)|74|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0106, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0107, code lost:
    
        r6 = r2;
        r4 = r5;
        r5 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116 A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:45:0x00f5, B:47:0x00fb, B:49:0x0101, B:54:0x010e, B:57:0x0116, B:59:0x0128, B:61:0x012e, B:62:0x0131, B:64:0x013a, B:65:0x013d, B:58:0x0124), top: B:107:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124 A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:45:0x00f5, B:47:0x00fb, B:49:0x0101, B:54:0x010e, B:57:0x0116, B:59:0x0128, B:61:0x012e, B:62:0x0131, B:64:0x013a, B:65:0x013d, B:58:0x0124), top: B:107:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:45:0x00f5, B:47:0x00fb, B:49:0x0101, B:54:0x010e, B:57:0x0116, B:59:0x0128, B:61:0x012e, B:62:0x0131, B:64:0x013a, B:65:0x013d, B:58:0x0124), top: B:107:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a A[Catch: all -> 0x0106, TryCatch #3 {all -> 0x0106, blocks: (B:45:0x00f5, B:47:0x00fb, B:49:0x0101, B:54:0x010e, B:57:0x0116, B:59:0x0128, B:61:0x012e, B:62:0x0131, B:64:0x013a, B:65:0x013d, B:58:0x0124), top: B:107:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018d A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:76:0x0187, B:78:0x018d, B:79:0x0198, B:81:0x019c), top: B:111:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0198 A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:76:0x0187, B:78:0x018d, B:79:0x0198, B:81:0x019c), top: B:111:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01be A[Catch: all -> 0x01cf, TRY_LEAVE, TryCatch #7 {all -> 0x01cf, blocks: (B:90:0x01ba, B:92:0x01be, B:97:0x01d1, B:98:0x01d4), top: B:113:0x01ba }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d1 A[Catch: all -> 0x01cf, TRY_ENTER, TryCatch #7 {all -> 0x01cf, blocks: (B:90:0x01ba, B:92:0x01be, B:97:0x01d1, B:98:0x01d4), top: B:113:0x01ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(coil.request.ImageRequest r20, int r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.g(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void i(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger = this.f55450i;
        if (logger != null && logger.getLevel() <= 4) {
            logger.a("RealImageLoader", 4, "🏗  Cancelled - " + imageRequest.m(), null);
        }
        eventListener.a(imageRequest);
        ImageRequest.Listener listenerA = imageRequest.A();
        if (listenerA != null) {
            listenerA.a(imageRequest);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void j(coil.request.ErrorResult r7, coil.target.Target r8, coil.EventListener r9) {
        /*
            r6 = this;
            coil.request.ImageRequest r0 = r7.b()
            coil.util.Logger r1 = r6.f55450i
            if (r1 == 0) goto L36
            int r2 = r1.getLevel()
            r3 = 4
            if (r2 > r3) goto L36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "🚨 Failed - "
            r2.append(r4)
            java.lang.Object r4 = r0.m()
            r2.append(r4)
            java.lang.String r4 = " - "
            r2.append(r4)
            java.lang.Throwable r4 = r7.c()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.a(r5, r3, r2, r4)
        L36:
            boolean r1 = r8 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto L3d
            if (r8 == 0) goto L69
            goto L50
        L3d:
            coil.request.ImageRequest r1 = r7.b()
            coil.transition.Transition$Factory r1 = r1.P()
            r2 = r8
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L58
        L50:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.e(r1)
            goto L69
        L58:
            coil.request.ImageRequest r8 = r7.b()
            r9.n(r8, r1)
            r1.a()
            coil.request.ImageRequest r8 = r7.b()
            r9.q(r8, r1)
        L69:
            r9.c(r0, r7)
            coil.request.ImageRequest$Listener r8 = r0.A()
            if (r8 == 0) goto L75
            r8.c(r0, r7)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.j(coil.request.ErrorResult, coil.target.Target, coil.EventListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void k(coil.request.SuccessResult r7, coil.target.Target r8, coil.EventListener r9) {
        /*
            r6 = this;
            coil.request.ImageRequest r0 = r7.b()
            coil.decode.DataSource r1 = r7.c()
            coil.util.Logger r2 = r6.f55450i
            if (r2 == 0) goto L41
            int r3 = r2.getLevel()
            r4 = 4
            if (r3 > r4) goto L41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = coil.util.Utils.g(r1)
            r3.append(r5)
            java.lang.String r5 = " Successful ("
            r3.append(r5)
            java.lang.String r1 = r1.name()
            r3.append(r1)
            java.lang.String r1 = ") - "
            r3.append(r1)
            java.lang.Object r1 = r0.m()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.a(r5, r4, r1, r3)
        L41:
            boolean r1 = r8 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto L48
            if (r8 == 0) goto L74
            goto L5b
        L48:
            coil.request.ImageRequest r1 = r7.b()
            coil.transition.Transition$Factory r1 = r1.P()
            r2 = r8
            coil.transition.TransitionTarget r2 = (coil.transition.TransitionTarget) r2
            coil.transition.Transition r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof coil.transition.NoneTransition
            if (r2 == 0) goto L63
        L5b:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.c(r1)
            goto L74
        L63:
            coil.request.ImageRequest r8 = r7.b()
            r9.n(r8, r1)
            r1.a()
            coil.request.ImageRequest r8 = r7.b()
            r9.q(r8, r1)
        L74:
            r9.d(r0, r7)
            coil.request.ImageRequest$Listener r8 = r0.A()
            if (r8 == 0) goto L80
            r8.d(r0, r7)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.k(coil.request.SuccessResult, coil.target.Target, coil.EventListener):void");
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions a() {
        return this.f55443b;
    }

    @Override // coil.ImageLoader
    public Disposable b(ImageRequest imageRequest) {
        Deferred deferredB = BuildersKt__Builders_commonKt.b(this.f55451j, null, null, new RealImageLoader$enqueue$job$1(this, imageRequest, null), 3, null);
        return imageRequest.M() instanceof ViewTarget ? Utils.m(((ViewTarget) imageRequest.M()).a()).b(deferredB) : new OneShotDisposable(deferredB);
    }

    @Override // coil.ImageLoader
    public Object c(ImageRequest imageRequest, Continuation continuation) {
        return CoroutineScopeKt.f(new RealImageLoader$execute$2(imageRequest, this, null), continuation);
    }

    @Override // coil.ImageLoader
    public MemoryCache d() {
        return (MemoryCache) this.f55444c.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.f55454m;
    }

    public final Logger h() {
        return this.f55450i;
    }

    public final void l(int i3) {
        MemoryCache memoryCache;
        Lazy lazy = this.f55444c;
        if (lazy == null || (memoryCache = (MemoryCache) lazy.getValue()) == null) {
            return;
        }
        memoryCache.a(i3);
    }
}
