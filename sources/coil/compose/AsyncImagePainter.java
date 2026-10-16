package coil.compose;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Precision;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import com.google.accompanist.drawablepainter.DrawablePainter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class AsyncImagePainter extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Companion f55509w = new Companion(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Function1 f55510x = new Function1<State, State>() { // from class: coil.compose.AsyncImagePainter$Companion$DefaultTransform$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
            return state;
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CoroutineScope f55511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableStateFlow f55512i = StateFlowKt.a(Size.c(Size.f25617b.b()));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f55513j = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f55514k = SnapshotStateKt__SnapshotStateKt.e(Float.valueOf(1.0f), null, 2, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f55515l = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private State f55516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Painter f55517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Function1 f55518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Function1 f55519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ContentScale f55520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f55521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f55522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableState f55523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableState f55524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableState f55525v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1 a() {
            return AsyncImagePainter.f55510x;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class State {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Empty extends State {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Empty f55527a = new Empty();

            private Empty() {
                super(null);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter a() {
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Error extends State {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Painter f55528a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ErrorResult f55529b;

            public Error(Painter painter, ErrorResult errorResult) {
                super(null);
                this.f55528a = painter;
                this.f55529b = errorResult;
            }

            public static /* synthetic */ Error c(Error error, Painter painter, ErrorResult errorResult, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    painter = error.f55528a;
                }
                if ((i3 & 2) != 0) {
                    errorResult = error.f55529b;
                }
                return error.b(painter, errorResult);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter a() {
                return this.f55528a;
            }

            public final Error b(Painter painter, ErrorResult errorResult) {
                return new Error(painter, errorResult);
            }

            public final ErrorResult d() {
                return this.f55529b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.f55528a, error.f55528a) && Intrinsics.areEqual(this.f55529b, error.f55529b);
            }

            public int hashCode() {
                Painter painter = this.f55528a;
                return ((painter == null ? 0 : painter.hashCode()) * 31) + this.f55529b.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.f55528a + ", result=" + this.f55529b + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Loading extends State {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Painter f55530a;

            public Loading(Painter painter) {
                super(null);
                this.f55530a = painter;
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter a() {
                return this.f55530a;
            }

            public final Loading b(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && Intrinsics.areEqual(this.f55530a, ((Loading) obj).f55530a);
            }

            public int hashCode() {
                Painter painter = this.f55530a;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.f55530a + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Success extends State {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Painter f55531a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final SuccessResult f55532b;

            public Success(Painter painter, SuccessResult successResult) {
                super(null);
                this.f55531a = painter;
                this.f55532b = successResult;
            }

            @Override // coil.compose.AsyncImagePainter.State
            public Painter a() {
                return this.f55531a;
            }

            public final SuccessResult b() {
                return this.f55532b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.f55531a, success.f55531a) && Intrinsics.areEqual(this.f55532b, success.f55532b);
            }

            public int hashCode() {
                return (this.f55531a.hashCode() * 31) + this.f55532b.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.f55531a + ", result=" + this.f55532b + ')';
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Painter a();

        private State() {
        }
    }

    public AsyncImagePainter(ImageRequest imageRequest, ImageLoader imageLoader) {
        State.Empty empty = State.Empty.f55527a;
        this.f55516m = empty;
        this.f55518o = f55510x;
        this.f55520q = ContentScale.f27054a.e();
        this.f55521r = DrawScope.e8.b();
        this.f55523t = SnapshotStateKt__SnapshotStateKt.e(empty, null, 2, null);
        this.f55524u = SnapshotStateKt__SnapshotStateKt.e(imageRequest, null, 2, null);
        this.f55525v = SnapshotStateKt__SnapshotStateKt.e(imageLoader, null, 2, null);
    }

    private final CrossfadePainter B(State state, State state2) {
        ImageResult imageResultD;
        if (!(state2 instanceof State.Success)) {
            if (state2 instanceof State.Error) {
                imageResultD = ((State.Error) state2).d();
            }
            return null;
        }
        imageResultD = ((State.Success) state2).b();
        Transition transitionA = imageResultD.b().P().a(AsyncImagePainterKt.f55547a, imageResultD);
        if (transitionA instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) transitionA;
            return new CrossfadePainter(state instanceof State.Loading ? state.a() : null, state2.a(), this.f55520q, crossfadeTransition.b(), ((imageResultD instanceof SuccessResult) && ((SuccessResult) imageResultD).d()) ? false : true, crossfadeTransition.c());
        }
        return null;
    }

    private final void C(float f3) {
        this.f55514k.setValue(Float.valueOf(f3));
    }

    private final void D(ColorFilter colorFilter) {
        this.f55515l.setValue(colorFilter);
    }

    private final void I(Painter painter) {
        this.f55513j.setValue(painter);
    }

    private final void L(State state) {
        this.f55523t.setValue(state);
    }

    private final void N(Painter painter) {
        this.f55517n = painter;
        I(painter);
    }

    private final void O(State state) {
        this.f55516m = state;
        L(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Painter P(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? BitmapPainterKt.b(AndroidImageBitmap_androidKt.c(((BitmapDrawable) drawable).getBitmap()), 0L, 0L, this.f55521r, 6, null) : new DrawablePainter(drawable.mutate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State Q(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(P(successResult.a()), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        Drawable drawableA = imageResult.a();
        return new State.Error(drawableA != null ? P(drawableA) : null, (ErrorResult) imageResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest R(ImageRequest imageRequest) {
        ImageRequest.Builder builderT = ImageRequest.R(imageRequest, null, 1, null).t(new Target() { // from class: coil.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil.target.Target
            public void d(Drawable drawable) {
                this.f55540a.S(new AsyncImagePainter.State.Loading(drawable != null ? this.f55540a.P(drawable) : null));
            }

            @Override // coil.target.Target
            public void c(Drawable drawable) {
            }

            @Override // coil.target.Target
            public void e(Drawable drawable) {
            }
        });
        if (imageRequest.q().m() == null) {
            builderT.s(new SizeResolver() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1
                @Override // coil.size.SizeResolver
                public final Object b(Continuation continuation) {
                    final MutableStateFlow mutableStateFlow = this.f55541a.f55512i;
                    return FlowKt.D(new Flow<coil.size.Size>() { // from class: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1

                        /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        @Metadata
                        public static final class AnonymousClass2<T> implements FlowCollector {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final /* synthetic */ FlowCollector f55543a;

                            /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2", f = "AsyncImagePainter.kt", l = {225}, m = "emit")
                            public static final class AnonymousClass1 extends ContinuationImpl {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                /* synthetic */ Object f55544a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                int f55545b;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.f55544a = obj;
                                    this.f55545b |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.f55543a = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                                /*
                                    r6 = this;
                                    boolean r0 = r8 instanceof coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                    if (r0 == 0) goto L13
                                    r0 = r8
                                    coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 r0 = (coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                    int r1 = r0.f55545b
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.f55545b = r1
                                    goto L18
                                L13:
                                    coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 r0 = new coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1
                                    r0.<init>(r8)
                                L18:
                                    java.lang.Object r8 = r0.f55544a
                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                    int r2 = r0.f55545b
                                    r3 = 1
                                    if (r2 == 0) goto L31
                                    if (r2 != r3) goto L29
                                    kotlin.ResultKt.b(r8)
                                    goto L4b
                                L29:
                                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                    r7.<init>(r8)
                                    throw r7
                                L31:
                                    kotlin.ResultKt.b(r8)
                                    kotlinx.coroutines.flow.FlowCollector r8 = r6.f55543a
                                    androidx.compose.ui.geometry.Size r7 = (androidx.compose.ui.geometry.Size) r7
                                    long r4 = r7.m()
                                    coil.size.Size r7 = coil.compose.AsyncImagePainterKt.b(r4)
                                    if (r7 == 0) goto L4b
                                    r0.f55545b = r3
                                    java.lang.Object r7 = r8.emit(r7, r0)
                                    if (r7 != r1) goto L4b
                                    return r1
                                L4b:
                                    kotlin.Unit r7 = kotlin.Unit.f139807a
                                    return r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: coil.compose.AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                            Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector), continuation2);
                            return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                        }
                    }, continuation);
                }
            });
        }
        if (imageRequest.q().l() == null) {
            builderT.p(UtilsKt.g(this.f55520q));
        }
        if (imageRequest.q().k() != Precision.EXACT) {
            builderT.j(Precision.INEXACT);
        }
        return builderT.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(State state) {
        State state2 = this.f55516m;
        State state3 = (State) this.f55518o.invoke(state);
        O(state3);
        Painter painterB = B(state2, state3);
        if (painterB == null) {
            painterB = state3.a();
        }
        N(painterB);
        if (this.f55511h != null && state2.a() != state3.a()) {
            Object objA = state2.a();
            RememberObserver rememberObserver = objA instanceof RememberObserver ? (RememberObserver) objA : null;
            if (rememberObserver != null) {
                rememberObserver.e();
            }
            Object objA2 = state3.a();
            RememberObserver rememberObserver2 = objA2 instanceof RememberObserver ? (RememberObserver) objA2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.c();
            }
        }
        Function1 function1 = this.f55519p;
        if (function1 != null) {
            function1.invoke(state3);
        }
    }

    private final void u() {
        CoroutineScope coroutineScope = this.f55511h;
        if (coroutineScope != null) {
            CoroutineScopeKt.e(coroutineScope, null, 1, null);
        }
        this.f55511h = null;
    }

    private final float v() {
        return ((Number) this.f55514k.getValue()).floatValue();
    }

    private final ColorFilter w() {
        return (ColorFilter) this.f55515l.getValue();
    }

    private final Painter y() {
        return (Painter) this.f55513j.getValue();
    }

    public final State A() {
        return (State) this.f55523t.getValue();
    }

    public final void E(ContentScale contentScale) {
        this.f55520q = contentScale;
    }

    public final void F(int i3) {
        this.f55521r = i3;
    }

    public final void G(ImageLoader imageLoader) {
        this.f55525v.setValue(imageLoader);
    }

    public final void H(Function1 function1) {
        this.f55519p = function1;
    }

    public final void J(boolean z2) {
        this.f55522s = z2;
    }

    public final void K(ImageRequest imageRequest) {
        this.f55524u.setValue(imageRequest);
    }

    public final void M(Function1 function1) {
        this.f55518o = function1;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        C(f3);
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        D(colorFilter);
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        if (this.f55511h != null) {
            return;
        }
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.c().w0()));
        this.f55511h = coroutineScopeA;
        Object obj = this.f55517n;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.c();
        }
        if (!this.f55522s) {
            BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AsyncImagePainter$onRemembered$1(this, null), 3, null);
        } else {
            Drawable drawableF = ImageRequest.R(z(), null, 1, null).f(x().a()).a().F();
            S(new State.Loading(drawableF != null ? P(drawableF) : null));
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        u();
        Object obj = this.f55517n;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.d();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        u();
        Object obj = this.f55517n;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.e();
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        Painter painterY = y();
        return painterY != null ? painterY.l() : Size.f25617b.a();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        this.f55512i.setValue(Size.c(drawScope.b()));
        Painter painterY = y();
        if (painterY != null) {
            painterY.j(drawScope, drawScope.b(), v(), w());
        }
    }

    public final ImageLoader x() {
        return (ImageLoader) this.f55525v.getValue();
    }

    public final ImageRequest z() {
        return (ImageRequest) this.f55524u.getValue();
    }
}
