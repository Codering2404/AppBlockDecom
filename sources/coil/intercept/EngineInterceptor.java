package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class EngineInterceptor implements Interceptor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f55857e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageLoader f55858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestService f55859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Logger f55860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MemoryCacheService f55861d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExecuteResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f55862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f55863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DataSource f55864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f55865d;

        public ExecuteResult(Drawable drawable, boolean z2, DataSource dataSource, String str) {
            this.f55862a = drawable;
            this.f55863b = z2;
            this.f55864c = dataSource;
            this.f55865d = str;
        }

        public static /* synthetic */ ExecuteResult b(ExecuteResult executeResult, Drawable drawable, boolean z2, DataSource dataSource, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                drawable = executeResult.f55862a;
            }
            if ((i3 & 2) != 0) {
                z2 = executeResult.f55863b;
            }
            if ((i3 & 4) != 0) {
                dataSource = executeResult.f55864c;
            }
            if ((i3 & 8) != 0) {
                str = executeResult.f55865d;
            }
            return executeResult.a(drawable, z2, dataSource, str);
        }

        public final ExecuteResult a(Drawable drawable, boolean z2, DataSource dataSource, String str) {
            return new ExecuteResult(drawable, z2, dataSource, str);
        }

        public final DataSource c() {
            return this.f55864c;
        }

        public final String d() {
            return this.f55865d;
        }

        public final Drawable e() {
            return this.f55862a;
        }

        public final boolean f() {
            return this.f55863b;
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {73}, m = "intercept")
    static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f55908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f55909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f55910c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f55912f;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f55910c = obj;
            this.f55912f |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {75}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f55913a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageRequest f55915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f55916d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Options f55917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EventListener f55918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ MemoryCache.Key f55919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Interceptor.Chain f55920i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation continuation) {
            super(2, continuation);
            this.f55915c = imageRequest;
            this.f55916d = obj;
            this.f55917f = options;
            this.f55918g = eventListener;
            this.f55919h = key;
            this.f55920i = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EngineInterceptor.this.new AnonymousClass2(this.f55915c, this.f55916d, this.f55917f, this.f55918g, this.f55919h, this.f55920i, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objH;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f55913a;
            if (i3 == 0) {
                ResultKt.b(obj);
                EngineInterceptor engineInterceptor = EngineInterceptor.this;
                ImageRequest imageRequest = this.f55915c;
                Object obj2 = this.f55916d;
                Options options = this.f55917f;
                EventListener eventListener = this.f55918g;
                this.f55913a = 1;
                objH = engineInterceptor.h(imageRequest, obj2, options, eventListener, this);
                if (objH == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objH = obj;
            }
            ExecuteResult executeResult = (ExecuteResult) objH;
            boolean zH = EngineInterceptor.this.f55861d.h(this.f55919h, this.f55915c, executeResult);
            Drawable drawableE = executeResult.e();
            ImageRequest imageRequest2 = this.f55915c;
            DataSource dataSourceC = executeResult.c();
            MemoryCache.Key key = this.f55919h;
            if (!zH) {
                key = null;
            }
            return new SuccessResult(drawableE, imageRequest2, dataSourceC, key, executeResult.d(), executeResult.f(), Utils.u(this.f55920i));
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.f55858a = imageLoader;
        this.f55859b = requestService;
        this.f55860c = logger;
        this.f55861d = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap f(Drawable drawable, Options options, List list) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config configC = Bitmaps.c(bitmap);
            if (ArraysKt.contains(Utils.p(), configC)) {
                return bitmap;
            }
            Logger logger = this.f55860c;
            if (logger != null && logger.getLevel() <= 4) {
                logger.a("EngineInterceptor", 4, "Converting bitmap with config " + configC + " to apply transformations: " + list + '.', null);
            }
        } else {
            Logger logger2 = this.f55860c;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.a("EngineInterceptor", 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + list + '.', null);
            }
        }
        return DrawableUtils.f56225a.a(drawable, options.f(), options.o(), options.n(), options.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0097 -> B:21:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(coil.fetch.SourceResult r8, coil.ComponentRegistry r9, coil.request.ImageRequest r10, java.lang.Object r11, coil.request.Options r12, coil.EventListener r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.g(coil.fetch.SourceResult, coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ff, code lost:
    
        if (r0 == r9) goto L76;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022c  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(coil.request.ImageRequest r33, java.lang.Object r34, coil.request.Options r35, coil.EventListener r36, kotlin.coroutines.Continuation r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.h(coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:21:0x0095). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(coil.ComponentRegistry r8, coil.request.ImageRequest r9, java.lang.Object r10, coil.request.Options r11, coil.EventListener r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.i(coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object intercept(coil.intercept.Interceptor.Chain r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            coil.intercept.EngineInterceptor$intercept$1 r0 = (coil.intercept.EngineInterceptor.AnonymousClass1) r0
            int r1 = r0.f55912f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55912f = r1
            goto L18
        L13:
            coil.intercept.EngineInterceptor$intercept$1 r0 = new coil.intercept.EngineInterceptor$intercept$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f55910c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f55912f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r14 = r0.f55909b
            coil.intercept.Interceptor$Chain r14 = (coil.intercept.Interceptor.Chain) r14
            java.lang.Object r0 = r0.f55908a
            r1 = r0
            coil.intercept.EngineInterceptor r1 = (coil.intercept.EngineInterceptor) r1
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L32
            return r15
        L32:
            r0 = move-exception
            r15 = r0
            r5 = r13
            goto Lae
        L37:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3f:
            kotlin.ResultKt.b(r15)
            coil.request.ImageRequest r6 = r14.b()     // Catch: java.lang.Throwable -> La9
            java.lang.Object r15 = r6.m()     // Catch: java.lang.Throwable -> La9
            coil.size.Size r2 = r14.getSize()     // Catch: java.lang.Throwable -> La9
            coil.EventListener r9 = coil.util.Utils.h(r14)     // Catch: java.lang.Throwable -> La9
            coil.request.RequestService r4 = r13.f55859b     // Catch: java.lang.Throwable -> La9
            coil.request.Options r8 = r4.f(r6, r2)     // Catch: java.lang.Throwable -> La9
            coil.size.Scale r4 = r8.n()     // Catch: java.lang.Throwable -> La9
            r9.i(r6, r15)     // Catch: java.lang.Throwable -> La9
            coil.ImageLoader r5 = r13.f55858a     // Catch: java.lang.Throwable -> La9
            coil.ComponentRegistry r5 = r5.getComponents()     // Catch: java.lang.Throwable -> La9
            java.lang.Object r7 = r5.g(r15, r8)     // Catch: java.lang.Throwable -> La9
            r9.g(r6, r7)     // Catch: java.lang.Throwable -> La9
            coil.memory.MemoryCacheService r15 = r13.f55861d     // Catch: java.lang.Throwable -> La9
            coil.memory.MemoryCache$Key r10 = r15.f(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> La9
            if (r10 == 0) goto L80
            coil.memory.MemoryCacheService r15 = r13.f55861d     // Catch: java.lang.Throwable -> L7b
            coil.memory.MemoryCache$Value r15 = r15.a(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L7b
            goto L81
        L7b:
            r0 = move-exception
            r15 = r0
            r1 = r13
            r5 = r1
            goto Lae
        L80:
            r15 = 0
        L81:
            if (r15 == 0) goto L8a
            coil.memory.MemoryCacheService r0 = r13.f55861d     // Catch: java.lang.Throwable -> L7b
            coil.request.SuccessResult r14 = r0.g(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L7b
            return r14
        L8a:
            kotlinx.coroutines.CoroutineDispatcher r15 = r6.v()     // Catch: java.lang.Throwable -> La9
            coil.intercept.EngineInterceptor$intercept$2 r4 = new coil.intercept.EngineInterceptor$intercept$2     // Catch: java.lang.Throwable -> La9
            r12 = 0
            r5 = r13
            r11 = r14
            r4.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> La4
            r0.f55908a = r5     // Catch: java.lang.Throwable -> La4
            r0.f55909b = r11     // Catch: java.lang.Throwable -> La4
            r0.f55912f = r3     // Catch: java.lang.Throwable -> La4
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r15, r4, r0)     // Catch: java.lang.Throwable -> La4
            if (r14 != r1) goto La3
            return r1
        La3:
            return r14
        La4:
            r0 = move-exception
            r15 = r0
            r1 = r5
            r14 = r11
            goto Lae
        La9:
            r0 = move-exception
            r5 = r13
            r11 = r14
            r15 = r0
            r1 = r5
        Lae:
            boolean r0 = r15 instanceof java.util.concurrent.CancellationException
            if (r0 != 0) goto Lbd
            coil.request.RequestService r0 = r1.f55859b
            coil.request.ImageRequest r14 = r14.b()
            coil.request.ErrorResult r14 = r0.b(r14, r15)
            return r14
        Lbd:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.intercept(coil.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object j(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation continuation) {
        List listO = imageRequest.O();
        if (listO.isEmpty()) {
            return executeResult;
        }
        if ((executeResult.e() instanceof BitmapDrawable) || imageRequest.g()) {
            return BuildersKt.g(imageRequest.N(), new EngineInterceptor$transform$3(this, executeResult, options, listO, eventListener, imageRequest, null), continuation);
        }
        Logger logger = this.f55860c;
        if (logger != null && logger.getLevel() <= 4) {
            logger.a("EngineInterceptor", 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.e().getClass().getCanonicalName() + '.', null);
        }
        return executeResult;
    }
}
