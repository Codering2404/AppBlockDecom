package androidx.compose.ui.window;

import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.internal.Utility;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f30243d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DialogProperties f30244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f30245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DialogLayout f30246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f30247i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30249a;

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
            f30249a = iArr;
        }
    }

    public DialogWrapper(Function0 function0, DialogProperties dialogProperties, View view, LayoutDirection layoutDirection, Density density, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), dialogProperties.a() ? R.style.f25172a : R.style.f25173b), 0, 2, null);
        this.f30243d = function0;
        this.f30244f = dialogProperties;
        this.f30245g = view;
        float fG = Dp.g(8);
        this.f30247i = fG;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window");
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowCompat.b(window, this.f30244f.a());
        window.setGravity(17);
        DialogLayout dialogLayout = new DialogLayout(getContext(), window);
        dialogLayout.setTag(R.id.H, "Dialog:" + uuid);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(density.M1(fG));
        dialogLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.ui.window.DialogWrapper$1$2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                outline.setAlpha(0.0f);
            }
        });
        this.f30246h = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            e(viewGroup);
        }
        setContentView(dialogLayout);
        ViewTreeLifecycleOwner.b(dialogLayout, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(dialogLayout, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(dialogLayout, ViewTreeSavedStateRegistryOwner.a(view));
        l(this.f30243d, this.f30244f, layoutDirection);
        OnBackPressedDispatcherKt.b(getOnBackPressedDispatcher(), this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: androidx.compose.ui.window.DialogWrapper.2
            {
                super(1);
            }

            public final void c(OnBackPressedCallback onBackPressedCallback) {
                if (DialogWrapper.this.f30244f.b()) {
                    DialogWrapper.this.f30243d.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((OnBackPressedCallback) obj);
                return Unit.f139807a;
            }
        }, 2, null);
    }

    private static final void e(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                e(viewGroup2);
            }
        }
    }

    private final void j(LayoutDirection layoutDirection) {
        DialogLayout dialogLayout = this.f30246h;
        int i3 = WhenMappings.f30249a[layoutDirection.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 0;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        dialogLayout.setLayoutDirection(i4);
    }

    private final void k(SecureFlagPolicy secureFlagPolicy) {
        boolean zA = SecureFlagPolicy_androidKt.a(secureFlagPolicy, AndroidPopup_androidKt.k(this.f30245g));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setFlags(zA ? 8192 : -8193, Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }

    public final void h() {
        this.f30246h.disposeComposition();
    }

    public final void i(CompositionContext compositionContext, Function2 function2) {
        this.f30246h.i(compositionContext, function2);
    }

    public final void l(Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
        this.f30243d = function0;
        this.f30244f = dialogProperties;
        k(dialogProperties.d());
        j(layoutDirection);
        boolean zA = dialogProperties.a();
        this.f30246h.j(dialogProperties.e(), zA);
        setCanceledOnTouchOutside(dialogProperties.c());
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(zA ? 0 : Build.VERSION.SDK_INT < 31 ? 16 : 48);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (!this.f30244f.b() || !keyEvent.isTracking() || keyEvent.isCanceled() || i3 != 111) {
            return super.onKeyUp(i3, keyEvent);
        }
        this.f30243d.invoke();
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.f30244f.c() || this.f30246h.h(motionEvent)) {
            return zOnTouchEvent;
        }
        this.f30243d.invoke();
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }
}
