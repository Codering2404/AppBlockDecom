package androidx.compose.material3;

import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.Utility;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ModalBottomSheetDialogWrapper extends ComponentDialog implements ViewRootForInspector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f18225d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ModalBottomSheetProperties f18226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f18227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ModalBottomSheetDialogLayout f18228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f18229i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18231a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18231a = iArr;
        }
    }

    private final void i(LayoutDirection layoutDirection) {
        ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = this.f18228h;
        int i3 = WhenMappings.f18231a[layoutDirection.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 0;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        modalBottomSheetDialogLayout.setLayoutDirection(i4);
    }

    private final void j(SecureFlagPolicy secureFlagPolicy) {
        boolean zG = ModalBottomSheet_androidKt.g(secureFlagPolicy, ModalBottomSheet_androidKt.f(this.f18227g));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setFlags(zG ? 8192 : -8193, Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }

    public final void g() {
        this.f18228h.disposeComposition();
    }

    public final void h(CompositionContext compositionContext, Function2 function2) {
        this.f18228h.i(compositionContext, function2);
    }

    public final void k(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, LayoutDirection layoutDirection) {
        this.f18225d = function0;
        this.f18226f = modalBottomSheetProperties;
        j(modalBottomSheetProperties.a());
        i(layoutDirection);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(Build.VERSION.SDK_INT >= 30 ? 48 : 16);
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent) {
            this.f18225d.invoke();
        }
        return zOnTouchEvent;
    }

    public ModalBottomSheetDialogWrapper(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, View view, LayoutDirection layoutDirection, Density density, UUID uuid, Animatable animatable, CoroutineScope coroutineScope, boolean z2) {
        super(new ContextThemeWrapper(view.getContext(), R.style.f19324a), 0, 2, null);
        this.f18225d = function0;
        this.f18226f = modalBottomSheetProperties;
        this.f18227g = view;
        float fG = Dp.g(8);
        this.f18229i = fG;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException(SbbqvQlxi.yFBJKIvzwthLpqq);
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowCompat.b(window, false);
        ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = new ModalBottomSheetDialogLayout(getContext(), window, this.f18226f.b(), this.f18225d, animatable, coroutineScope);
        modalBottomSheetDialogLayout.setTag(androidx.compose.ui.R.id.H, "Dialog:" + uuid);
        modalBottomSheetDialogLayout.setClipChildren(false);
        modalBottomSheetDialogLayout.setElevation(density.M1(fG));
        modalBottomSheetDialogLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.material3.ModalBottomSheetDialogWrapper$1$2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                outline.setAlpha(0.0f);
            }
        });
        this.f18228h = modalBottomSheetDialogLayout;
        setContentView(modalBottomSheetDialogLayout);
        ViewTreeLifecycleOwner.b(modalBottomSheetDialogLayout, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(modalBottomSheetDialogLayout, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(modalBottomSheetDialogLayout, ViewTreeSavedStateRegistryOwner.a(view));
        k(this.f18225d, this.f18226f, layoutDirection);
        WindowInsetsControllerCompat windowInsetsControllerCompatA = WindowCompat.a(window, window.getDecorView());
        windowInsetsControllerCompatA.d(!z2);
        windowInsetsControllerCompatA.c(!z2);
        OnBackPressedDispatcherKt.b(getOnBackPressedDispatcher(), this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: androidx.compose.material3.ModalBottomSheetDialogWrapper.3
            {
                super(1);
            }

            public final void c(OnBackPressedCallback onBackPressedCallback) {
                if (ModalBottomSheetDialogWrapper.this.f18226f.b()) {
                    ModalBottomSheetDialogWrapper.this.f18225d.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((OnBackPressedCallback) obj);
                return Unit.f139807a;
            }
        }, 2, null);
    }
}
