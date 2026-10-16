package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.ModalBottomSheetDialogLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
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
final class ModalBottomSheetDialogLayout extends AbstractComposeView implements DialogWindowProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Window f18202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f18204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animatable f18205d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f18206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f18207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f18208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18209i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Api33Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api33Impl f18210a = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final OnBackInvokedCallback b(final Function0<Unit> function0) {
            return new OnBackInvokedCallback() { // from class: androidx.compose.material3.d
                public final void onBackInvoked() {
                    ModalBottomSheetDialogLayout.Api33Impl.c(function0);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 function0) {
            function0.invoke();
        }

        @JvmStatic
        public static final void d(View view, Object obj) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(0, (OnBackInvokedCallback) obj);
        }

        @JvmStatic
        public static final void e(View view, Object obj) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f18211a = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final OnBackAnimationCallback a(final Function0<Unit> function0, final Animatable<Float, AnimationVector1D> animatable, final CoroutineScope coroutineScope) {
            return new OnBackAnimationCallback() { // from class: androidx.compose.material3.ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1
                public void onBackCancelled() {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1(animatable, null), 3, null);
                }

                public void onBackInvoked() {
                    function0.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackProgressed$1(animatable, backEvent, null), 3, null);
                }

                public void onBackStarted(BackEvent backEvent) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1(animatable, backEvent, null), 3, null);
                }
            };
        }
    }

    public ModalBottomSheetDialogLayout(Context context, Window window, boolean z2, Function0 function0, Animatable animatable, CoroutineScope coroutineScope) {
        super(context, null, 0, 6, null);
        this.f18202a = window;
        this.f18203b = z2;
        this.f18204c = function0;
        this.f18205d = animatable;
        this.f18206f = coroutineScope;
        this.f18207g = SnapshotStateKt__SnapshotStateKt.e(ComposableSingletons$ModalBottomSheet_androidKt.f16743a.b(), null, 2, null);
    }

    private final void g() {
        int i3;
        if (!this.f18203b || (i3 = Build.VERSION.SDK_INT) < 33) {
            return;
        }
        if (this.f18208h == null) {
            this.f18208h = i3 >= 34 ? androidx.appcompat.app.d.a(Api34Impl.a(this.f18204c, this.f18205d, this.f18206f)) : Api33Impl.b(this.f18204c);
        }
        Api33Impl.d(this, this.f18208h);
    }

    private final Function2 getContent() {
        return (Function2) this.f18207g.getValue();
    }

    private final void h() {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.e(this, this.f18208h);
        }
        this.f18208h = null;
    }

    private final void setContent(Function2 function2) {
        this.f18207g.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(576708319);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(576708319, i4, -1, "androidx.compose.material3.ModalBottomSheetDialogLayout.Content (ModalBottomSheet.android.kt:352)");
            }
            getContent().invoke(composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetDialogLayout.Content.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ModalBottomSheetDialogLayout.this.Content(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f18209i;
    }

    @Override // androidx.compose.ui.window.DialogWindowProvider
    public Window getWindow() {
        return this.f18202a;
    }

    public final void i(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.f18209i = true;
        createComposition();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }
}
