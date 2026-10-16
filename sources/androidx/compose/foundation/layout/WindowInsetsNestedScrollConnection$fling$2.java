package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", l = {345}, m = "invokeSuspend")
final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f7229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f7230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WindowInsetsNestedScrollConnection f7231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f7232d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f7233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec f7234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f7235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f7236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f7237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ WindowInsetsAnimationController f7238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f7239l;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", l = {329}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f7242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SplineBasedFloatDecayAnimationSpec f7243d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f7244f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7245g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ WindowInsetsNestedScrollConnection f7246h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.FloatRef f7247i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ WindowInsetsAnimationController f7248j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f7249k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, float f3, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i4, int i5, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f7241b = i3;
            this.f7242c = f3;
            this.f7243d = splineBasedFloatDecayAnimationSpec;
            this.f7244f = i4;
            this.f7245g = i5;
            this.f7246h = windowInsetsNestedScrollConnection;
            this.f7247i = floatRef;
            this.f7248j = windowInsetsAnimationController;
            this.f7249k = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f7241b, this.f7242c, this.f7243d, this.f7244f, this.f7245g, this.f7246h, this.f7247i, this.f7248j, this.f7249k, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f7240a;
            if (i3 == 0) {
                ResultKt.b(obj);
                float f3 = this.f7241b;
                float f4 = this.f7242c;
                SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.f7243d;
                final int i4 = this.f7244f;
                final int i5 = this.f7245g;
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f7246h;
                final Ref.FloatRef floatRef = this.f7247i;
                final WindowInsetsAnimationController windowInsetsAnimationController = this.f7248j;
                final boolean z2 = this.f7249k;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.fling.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final void c(float f5, float f6) {
                        float f7 = i4;
                        if (f5 <= i5 && f7 <= f5) {
                            windowInsetsNestedScrollConnection.h(f5);
                            return;
                        }
                        floatRef.f140141a = f6;
                        windowInsetsAnimationController.finish(z2);
                        windowInsetsNestedScrollConnection.f7214f = null;
                        Job job = windowInsetsNestedScrollConnection.f7218j;
                        if (job != null) {
                            job.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.f139807a;
                    }
                };
                this.f7240a = 1;
                if (SuspendAnimationKt.g(f3, f4, splineBasedFloatDecayAnimationSpec, function2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i3, float f3, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i4, int i5, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f7231c = windowInsetsNestedScrollConnection;
        this.f7232d = i3;
        this.f7233f = f3;
        this.f7234g = splineBasedFloatDecayAnimationSpec;
        this.f7235h = i4;
        this.f7236i = i5;
        this.f7237j = floatRef;
        this.f7238k = windowInsetsAnimationController;
        this.f7239l = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.f7231c, this.f7232d, this.f7233f, this.f7234g, this.f7235h, this.f7236i, this.f7237j, this.f7238k, this.f7239l, continuation);
        windowInsetsNestedScrollConnection$fling$2.f7230b = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f7229a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f7230b;
            WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f7231c;
            windowInsetsNestedScrollConnection.f7218j = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(this.f7232d, this.f7233f, this.f7234g, this.f7235h, this.f7236i, windowInsetsNestedScrollConnection, this.f7237j, this.f7238k, this.f7239l, null), 3, null);
            Job job = this.f7231c.f7218j;
            if (job != null) {
                this.f7229a = 1;
                if (job.join(this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f7231c.f7218j = null;
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
