package androidx.compose.ui.scrollcapture;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.View;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SemanticsNode f28386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntRect f28387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScrollCaptureSessionListener f28388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f28389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineScope f28390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeScroller f28391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f28392g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ScrollCaptureSessionListener {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureEnd$1", f = "ComposeScrollCaptureCallback.android.kt", l = {186}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28393a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f28395c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Runnable runnable, Continuation continuation) {
            super(2, continuation);
            this.f28395c = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ComposeScrollCaptureCallback.this.new AnonymousClass1(this.f28395c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f28393a;
            if (i3 == 0) {
                ResultKt.b(obj);
                RelativeScroller relativeScroller = ComposeScrollCaptureCallback.this.f28391f;
                this.f28393a = 1;
                if (relativeScroller.g(0.0f, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            ComposeScrollCaptureCallback.this.f28388c.b();
            this.f28395c.run();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1", f = "ComposeScrollCaptureCallback.android.kt", l = {119}, m = "invokeSuspend")
    static final class C03461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28396a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScrollCaptureSession f28398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Rect f28399d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Consumer f28400f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03461(ScrollCaptureSession scrollCaptureSession, Rect rect, Consumer consumer, Continuation continuation) {
            super(2, continuation);
            this.f28398c = scrollCaptureSession;
            this.f28399d = rect;
            this.f28400f = consumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ComposeScrollCaptureCallback.this.new C03461(this.f28398c, this.f28399d, this.f28400f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f28396a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ComposeScrollCaptureCallback composeScrollCaptureCallback = ComposeScrollCaptureCallback.this;
                ScrollCaptureSession scrollCaptureSession = this.f28398c;
                IntRect intRectD = RectHelper_androidKt.d(this.f28399d);
                this.f28396a = 1;
                obj = composeScrollCaptureCallback.e(scrollCaptureSession, intRectD, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.f28400f.accept(RectHelper_androidKt.b((IntRect) obj));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03461) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback", f = "ComposeScrollCaptureCallback.android.kt", l = {132, 135}, m = "onScrollCaptureImageRequest")
    static final class AnonymousClass2 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28404d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f28405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f28406g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f28408i;

        AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f28406g = obj;
            this.f28408i |= Integer.MIN_VALUE;
            return ComposeScrollCaptureCallback.this.e(null, null, this);
        }
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, CoroutineScope coroutineScope, ScrollCaptureSessionListener scrollCaptureSessionListener, View view) {
        this.f28386a = semanticsNode;
        this.f28387b = intRect;
        this.f28388c = scrollCaptureSessionListener;
        this.f28389d = view;
        this.f28390e = CoroutineScopeKt.i(coroutineScope, DisableAnimationMotionDurationScale.f28415a);
        this.f28391f = new RelativeScroller(intRect.f(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(android.view.ScrollCaptureSession r9, androidx.compose.ui.unit.IntRect r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.e(android.view.ScrollCaptureSession, androidx.compose.ui.unit.IntRect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void onScrollCaptureEnd(Runnable runnable) {
        BuildersKt__Builders_commonKt.d(this.f28390e, NonCancellable.f141003a, null, new AnonymousClass1(runnable, null), 2, null);
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        ComposeScrollCaptureCallback_androidKt.c(this.f28390e, cancellationSignal, new C03461(scrollCaptureSession, rect, consumer, null));
    }

    public void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(RectHelper_androidKt.b(this.f28387b));
    }

    public void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f28391f.d();
        this.f28392g = 0;
        this.f28388c.a();
        runnable.run();
    }
}
