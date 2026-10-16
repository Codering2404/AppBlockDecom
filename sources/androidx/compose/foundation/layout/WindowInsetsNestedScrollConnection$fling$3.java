package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3", f = "WindowInsetsConnection.android.kt", l = {}, m = "invokeSuspend")
final class WindowInsetsNestedScrollConnection$fling$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f7256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f7257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WindowInsetsNestedScrollConnection f7258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f7259d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f7260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f7261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ WindowInsetsAnimationController f7262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f7263i;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1", f = "WindowInsetsConnection.android.kt", l = {355}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f7267d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WindowInsetsAnimationController f7268f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7269g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ WindowInsetsNestedScrollConnection f7270h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, int i4, float f3, WindowInsetsAnimationController windowInsetsAnimationController, boolean z2, WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Continuation continuation) {
            super(2, continuation);
            this.f7265b = i3;
            this.f7266c = i4;
            this.f7267d = f3;
            this.f7268f = windowInsetsAnimationController;
            this.f7269g = z2;
            this.f7270h = windowInsetsNestedScrollConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f7265b, this.f7266c, this.f7267d, this.f7268f, this.f7269g, this.f7270h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f7264a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Animatable animatableB = AnimatableKt.b(this.f7265b, 0.0f, 2, null);
                Float fC = Boxing.c(this.f7266c);
                Float fC2 = Boxing.c(this.f7267d);
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f7270h;
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.fling.3.1.1
                    {
                        super(1);
                    }

                    public final void c(Animatable animatable) {
                        windowInsetsNestedScrollConnection.h(((Number) animatable.n()).floatValue());
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        c((Animatable) obj2);
                        return Unit.f139807a;
                    }
                };
                this.f7264a = 1;
                anonymousClass1 = this;
                if (Animatable.f(animatableB, fC, null, fC2, function1, anonymousClass1, 2, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass1 = this;
            }
            anonymousClass1.f7268f.finish(anonymousClass1.f7269g);
            anonymousClass1.f7270h.f7214f = null;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$3(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i3, int i4, float f3, WindowInsetsAnimationController windowInsetsAnimationController, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f7258c = windowInsetsNestedScrollConnection;
        this.f7259d = i3;
        this.f7260f = i4;
        this.f7261g = f3;
        this.f7262h = windowInsetsAnimationController;
        this.f7263i = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowInsetsNestedScrollConnection$fling$3 windowInsetsNestedScrollConnection$fling$3 = new WindowInsetsNestedScrollConnection$fling$3(this.f7258c, this.f7259d, this.f7260f, this.f7261g, this.f7262h, this.f7263i, continuation);
        windowInsetsNestedScrollConnection$fling$3.f7257b = obj;
        return windowInsetsNestedScrollConnection$fling$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f7256a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f7257b;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f7258c;
        windowInsetsNestedScrollConnection.f7218j = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(this.f7259d, this.f7260f, this.f7261g, this.f7262h, this.f7263i, windowInsetsNestedScrollConnection, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
