package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions P = (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().h(DiskCacheStrategy.f66407c)).d0(Priority.LOW)).l0(true);
    private final Context B;
    private final RequestManager C;
    private final Class D;
    private final Glide E;
    private final GlideContext F;
    private TransitionOptions G;
    private Object H;
    private List I;
    private RequestBuilder J;
    private RequestBuilder K;
    private Float L;
    private boolean M = true;
    private boolean N;
    private boolean O;

    /* JADX INFO: renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f66111b;

        static {
            int[] iArr = new int[Priority.values().length];
            f66111b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66111b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66111b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66111b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f66110a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f66110a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f66110a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f66110a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f66110a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f66110a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f66110a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f66110a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected RequestBuilder(Glide glide, RequestManager requestManager, Class cls, Context context) {
        this.E = glide;
        this.C = requestManager;
        this.D = cls;
        this.B = context;
        this.G = requestManager.p(cls);
        this.F = glide.i();
        B0(requestManager.n());
        a(requestManager.o());
    }

    private void B0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s0((RequestListener) it.next());
        }
    }

    private Target D0(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        Preconditions.e(target);
        if (!this.N) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Request requestV0 = v0(target, requestListener, baseRequestOptions, executor);
        Request requestB = target.b();
        if (requestV0.h(requestB) && !G0(baseRequestOptions, requestB)) {
            if (!((Request) Preconditions.e(requestB)).isRunning()) {
                requestB.i();
            }
            return target;
        }
        this.C.l(target);
        target.i(requestV0);
        this.C.w(target, requestV0);
        return target;
    }

    private boolean G0(BaseRequestOptions baseRequestOptions, Request request) {
        return !baseRequestOptions.K() && request.g();
    }

    private RequestBuilder L0(Object obj) {
        if (I()) {
            return clone().L0(obj);
        }
        this.H = obj;
        this.N = true;
        return (RequestBuilder) h0();
    }

    private RequestBuilder M0(Uri uri, RequestBuilder requestBuilder) {
        return (uri == null || !"android.resource".equals(uri.getScheme())) ? requestBuilder : u0(requestBuilder);
    }

    private Request N0(Object obj, Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i3, int i4, Executor executor) {
        Context context = this.B;
        GlideContext glideContext = this.F;
        return SingleRequest.y(context, glideContext, obj, this.H, this.D, baseRequestOptions, i3, i4, priority, target, requestListener, this.I, requestCoordinator, glideContext.f(), transitionOptions.b(), executor);
    }

    private RequestBuilder u0(RequestBuilder requestBuilder) {
        return (RequestBuilder) ((RequestBuilder) requestBuilder.m0(this.B.getTheme())).j0(AndroidResourceSignature.c(this.B));
    }

    private Request v0(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        return w0(new Object(), target, requestListener, null, this.G, baseRequestOptions.z(), baseRequestOptions.w(), baseRequestOptions.v(), baseRequestOptions, executor);
    }

    private Request w0(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i3, int i4, BaseRequestOptions baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        RequestCoordinator requestCoordinator2;
        Object obj2;
        Target target2;
        RequestListener requestListener2;
        TransitionOptions transitionOptions2;
        Priority priority2;
        int i5;
        int i6;
        BaseRequestOptions baseRequestOptions2;
        Executor executor2;
        RequestBuilder<TranscodeType> requestBuilder;
        if (this.K != null) {
            errorRequestCoordinator = new ErrorRequestCoordinator(obj, requestCoordinator);
            requestCoordinator2 = errorRequestCoordinator;
            requestBuilder = this;
            obj2 = obj;
            target2 = target;
            requestListener2 = requestListener;
            transitionOptions2 = transitionOptions;
            priority2 = priority;
            i5 = i3;
            i6 = i4;
            baseRequestOptions2 = baseRequestOptions;
            executor2 = executor;
        } else {
            errorRequestCoordinator = null;
            requestCoordinator2 = requestCoordinator;
            obj2 = obj;
            target2 = target;
            requestListener2 = requestListener;
            transitionOptions2 = transitionOptions;
            priority2 = priority;
            i5 = i3;
            i6 = i4;
            baseRequestOptions2 = baseRequestOptions;
            executor2 = executor;
            requestBuilder = this;
        }
        Request requestX0 = requestBuilder.x0(obj2, target2, requestListener2, requestCoordinator2, transitionOptions2, priority2, i5, i6, baseRequestOptions2, executor2);
        if (errorRequestCoordinator == null) {
            return requestX0;
        }
        int iW = this.K.w();
        int iV = this.K.v();
        if (Util.v(i3, i4) && !this.K.S()) {
            iW = baseRequestOptions.w();
            iV = baseRequestOptions.v();
        }
        RequestBuilder requestBuilder2 = this.K;
        ErrorRequestCoordinator errorRequestCoordinator2 = errorRequestCoordinator;
        errorRequestCoordinator2.o(requestX0, requestBuilder2.w0(obj, target, requestListener, errorRequestCoordinator2, requestBuilder2.G, requestBuilder2.z(), iW, iV, this.K, executor));
        return errorRequestCoordinator2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Request x0(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i3, int i4, BaseRequestOptions baseRequestOptions, Executor executor) {
        RequestBuilder requestBuilder = this.J;
        if (requestBuilder == null) {
            if (this.L == null) {
                return N0(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i3, i4, executor);
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, requestCoordinator);
            thumbnailRequestCoordinator.n(N0(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i3, i4, executor), N0(obj, target, requestListener, baseRequestOptions.clone().k0(this.L.floatValue()), thumbnailRequestCoordinator, transitionOptions, z0(priority), i3, i4, executor));
            return thumbnailRequestCoordinator;
        }
        if (this.O) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        TransitionOptions transitionOptions2 = requestBuilder.M ? transitionOptions : requestBuilder.G;
        Priority priorityZ = requestBuilder.L() ? this.J.z() : z0(priority);
        int iW = this.J.w();
        int iV = this.J.v();
        if (Util.v(i3, i4) && !this.J.S()) {
            iW = baseRequestOptions.w();
            iV = baseRequestOptions.v();
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, requestCoordinator);
        Request requestN0 = N0(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i3, i4, executor);
        this.O = true;
        RequestBuilder requestBuilder2 = this.J;
        Request requestW0 = requestBuilder2.w0(obj, target, requestListener, thumbnailRequestCoordinator2, transitionOptions2, priorityZ, iW, iV, requestBuilder2, executor);
        this.O = false;
        thumbnailRequestCoordinator2.n(requestN0, requestW0);
        return thumbnailRequestCoordinator2;
    }

    private Priority z0(Priority priority) {
        int i3 = AnonymousClass1.f66111b[priority.ordinal()];
        if (i3 == 1) {
            return Priority.NORMAL;
        }
        if (i3 == 2) {
            return Priority.HIGH;
        }
        if (i3 == 3 || i3 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + z());
    }

    public Target C0(Target target) {
        return E0(target, null, Executors.b());
    }

    public Target E0(Target target, RequestListener requestListener, Executor executor) {
        return D0(target, requestListener, this, executor);
    }

    public ViewTarget F0(ImageView imageView) {
        BaseRequestOptions baseRequestOptionsV;
        Util.b();
        Preconditions.e(imageView);
        if (!R() && P() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f66110a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptionsV = clone().V();
                    break;
                case 2:
                    baseRequestOptionsV = clone().W();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptionsV = clone().X();
                    break;
                case 6:
                    baseRequestOptionsV = clone().W();
                    break;
                default:
                    baseRequestOptionsV = this;
                    break;
            }
        } else {
            baseRequestOptionsV = this;
        }
        return (ViewTarget) D0(this.F.a(imageView, this.D), null, baseRequestOptionsV, Executors.b());
    }

    public RequestBuilder H0(RequestListener requestListener) {
        if (I()) {
            return clone().H0(requestListener);
        }
        this.I = null;
        return s0(requestListener);
    }

    public RequestBuilder I0(Uri uri) {
        return M0(uri, L0(uri));
    }

    public RequestBuilder J0(Object obj) {
        return L0(obj);
    }

    public RequestBuilder K0(String str) {
        return L0(str);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object obj) {
        if (obj instanceof RequestBuilder) {
            RequestBuilder requestBuilder = (RequestBuilder) obj;
            if (super.equals(requestBuilder) && Objects.equals(this.D, requestBuilder.D) && this.G.equals(requestBuilder.G) && Objects.equals(this.H, requestBuilder.H) && Objects.equals(this.I, requestBuilder.I) && Objects.equals(this.J, requestBuilder.J) && Objects.equals(this.K, requestBuilder.K) && Objects.equals(this.L, requestBuilder.L) && this.M == requestBuilder.M && this.N == requestBuilder.N) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return Util.r(this.N, Util.r(this.M, Util.q(this.L, Util.q(this.K, Util.q(this.J, Util.q(this.I, Util.q(this.H, Util.q(this.G, Util.q(this.D, super.hashCode())))))))));
    }

    public RequestBuilder s0(RequestListener requestListener) {
        if (I()) {
            return clone().s0(requestListener);
        }
        if (requestListener != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.add(requestListener);
        }
        return (RequestBuilder) h0();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public RequestBuilder a(BaseRequestOptions baseRequestOptions) {
        Preconditions.e(baseRequestOptions);
        return (RequestBuilder) super.a(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public RequestBuilder clone() {
        RequestBuilder requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.G = requestBuilder.G.clone();
        if (requestBuilder.I != null) {
            requestBuilder.I = new ArrayList(requestBuilder.I);
        }
        RequestBuilder requestBuilder2 = requestBuilder.J;
        if (requestBuilder2 != null) {
            requestBuilder.J = requestBuilder2.clone();
        }
        RequestBuilder requestBuilder3 = requestBuilder.K;
        if (requestBuilder3 != null) {
            requestBuilder.K = requestBuilder3.clone();
        }
        return requestBuilder;
    }
}
