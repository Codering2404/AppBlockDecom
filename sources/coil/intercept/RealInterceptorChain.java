package coil.intercept;

import coil.EventListener;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;

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
public final class RealInterceptorChain implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageRequest f55933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f55934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f55935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImageRequest f55936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Size f55937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventListener f55938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f55939g;

    public RealInterceptorChain(ImageRequest imageRequest, List list, int i3, ImageRequest imageRequest2, Size size, EventListener eventListener, boolean z2) {
        this.f55933a = imageRequest;
        this.f55934b = list;
        this.f55935c = i3;
        this.f55936d = imageRequest2;
        this.f55937e = size;
        this.f55938f = eventListener;
        this.f55939g = z2;
    }

    private final void a(ImageRequest imageRequest, Interceptor interceptor) {
        if (imageRequest.l() != this.f55933a.l()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (imageRequest.m() == NullRequestData.f56113a) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (imageRequest.M() != this.f55933a.M()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (imageRequest.z() != this.f55933a.z()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (imageRequest.K() == this.f55933a.K()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    private final RealInterceptorChain c(int i3, ImageRequest imageRequest, Size size) {
        return new RealInterceptorChain(this.f55933a, this.f55934b, i3, imageRequest, size, this.f55938f, this.f55939g);
    }

    static /* synthetic */ RealInterceptorChain d(RealInterceptorChain realInterceptorChain, int i3, ImageRequest imageRequest, Size size, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = realInterceptorChain.f55935c;
        }
        if ((i4 & 2) != 0) {
            imageRequest = realInterceptorChain.b();
        }
        if ((i4 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.c(i3, imageRequest, size);
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest b() {
        return this.f55936d;
    }

    public final EventListener e() {
        return this.f55938f;
    }

    public final boolean f() {
        return this.f55939g;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object g(coil.request.ImageRequest r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof coil.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L13
            r0 = r12
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.f55944f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55944f = r1
            goto L18
        L13:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f55942c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f55944f
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r11 = r0.f55941b
            coil.intercept.Interceptor r11 = (coil.intercept.Interceptor) r11
            java.lang.Object r0 = r0.f55940a
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.b(r12)
            r4 = r10
            goto L75
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            kotlin.ResultKt.b(r12)
            int r12 = r10.f55935c
            if (r12 <= 0) goto L4d
            java.util.List r2 = r10.f55934b
            int r12 = r12 - r3
            java.lang.Object r12 = r2.get(r12)
            coil.intercept.Interceptor r12 = (coil.intercept.Interceptor) r12
            r10.a(r11, r12)
        L4d:
            java.util.List r12 = r10.f55934b
            int r2 = r10.f55935c
            java.lang.Object r12 = r12.get(r2)
            coil.intercept.Interceptor r12 = (coil.intercept.Interceptor) r12
            int r2 = r10.f55935c
            int r5 = r2 + 1
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r10
            r6 = r11
            coil.intercept.RealInterceptorChain r11 = d(r4, r5, r6, r7, r8, r9)
            r0.f55940a = r4
            r0.f55941b = r12
            r0.f55944f = r3
            java.lang.Object r11 = r12.intercept(r11, r0)
            if (r11 != r1) goto L71
            return r1
        L71:
            r0 = r12
            r12 = r11
            r11 = r0
            r0 = r4
        L75:
            coil.request.ImageResult r12 = (coil.request.ImageResult) r12
            coil.request.ImageRequest r1 = r12.b()
            r0.a(r1, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.g(coil.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.f55937e;
    }
}
