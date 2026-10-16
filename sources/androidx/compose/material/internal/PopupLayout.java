package androidx.compose.material.internal;

import android.R;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f15222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f15224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager f15225d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WindowManager.LayoutParams f15226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PopupPositionProvider f15227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LayoutDirection f15228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f15229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f15230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final State f15231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f15232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Rect f15233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f15234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function2 f15235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableState f15236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f15237q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15240a;

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
            f15240a = iArr;
        }
    }

    public PopupLayout(Function0 function0, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid) {
        super(view.getContext(), null, 0, 6, null);
        this.f15222a = function0;
        this.f15223b = str;
        this.f15224c = view;
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f15225d = (WindowManager) systemService;
        this.f15226f = g();
        this.f15227g = popupPositionProvider;
        this.f15228h = LayoutDirection.f30001a;
        this.f15229i = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f15230j = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f15231k = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.material.internal.PopupLayout$canCalculatePosition$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((this.f15241a.h() == null || this.f15241a.m141getPopupContentSizebOM6tXw() == null) ? false : true);
            }
        });
        float fG = Dp.g(8);
        this.f15232l = fG;
        this.f15233m = new Rect();
        this.f15234n = new Rect();
        this.f15235o = new Function2<Offset, IntRect, Boolean>() { // from class: androidx.compose.material.internal.PopupLayout$dismissOnOutsideClick$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Offset offset, IntRect intRect) {
                boolean z2 = false;
                if (offset != null && (Offset.m(offset.u()) < intRect.g() || Offset.m(offset.u()) > intRect.h() || Offset.n(offset.u()) < intRect.j() || Offset.n(offset.u()) > intRect.d())) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        };
        setId(R.id.content);
        ViewTreeLifecycleOwner.b(this, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(this, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(this, ViewTreeSavedStateRegistryOwner.a(view));
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setTag(androidx.compose.ui.R.id.H, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.M1(fG));
        setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.material.internal.PopupLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                outline.setAlpha(0.0f);
            }
        });
        this.f15236p = SnapshotStateKt__SnapshotStateKt.e(ComposableSingletons$ExposedDropdownMenuPopup_androidKt.f15183a.a(), null, 2, null);
    }

    private final WindowManager.LayoutParams g() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = 393248;
        layoutParams.softInputMode = 1;
        layoutParams.type = 1000;
        layoutParams.token = this.f15224c.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.f15224c.getContext().getResources().getString(androidx.compose.ui.R.string.f25157d));
        return layoutParams;
    }

    private final Function2 getContent() {
        return (Function2) this.f15236p.getValue();
    }

    private final void l(LayoutDirection layoutDirection) {
        int i3 = WhenMappings.f15240a[layoutDirection.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 0;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i4);
    }

    private final IntRect m(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    private final void setContent(Function2 function2) {
        this.f15236p.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-864350873);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-864350873, i4, -1, "androidx.compose.material.internal.PopupLayout.Content (ExposedDropdownMenuPopup.android.kt:301)");
            }
            getContent().invoke(composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.internal.PopupLayout.Content.4
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
                    PopupLayout.this.Content(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.b(this, null);
        this.f15224c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f15225d.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        if (keyEvent.getKeyCode() == 4) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                Function0 function0 = this.f15222a;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.f15231k.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m141getPopupContentSizebOM6tXw() {
        return (IntSize) this.f15230j.getValue();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f15237q;
    }

    public final IntRect h() {
        return (IntRect) this.f15229i.getValue();
    }

    public final void i(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.f15237q = true;
    }

    public final void j(IntRect intRect) {
        this.f15229i.setValue(intRect);
    }

    public final void k() {
        this.f15225d.addView(this, this.f15226f);
    }

    public final void n(Function0 function0, String str, LayoutDirection layoutDirection) {
        this.f15222a = function0;
        this.f15223b = str;
        l(layoutDirection);
    }

    public final void o() {
        IntSize intSizeM141getPopupContentSizebOM6tXw;
        IntRect intRectH = h();
        if (intRectH == null || (intSizeM141getPopupContentSizebOM6tXw = m141getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long j3 = intSizeM141getPopupContentSizebOM6tXw.j();
        Rect rect = this.f15233m;
        this.f15224c.getWindowVisibleDisplayFrame(rect);
        IntRect intRectM = m(rect);
        long jA = this.f15227g.a(intRectH, IntSizeKt.a(intRectM.l(), intRectM.f()), this.f15228h, j3);
        this.f15226f.x = IntOffset.k(jA);
        this.f15226f.y = IntOffset.l(jA);
        this.f15225d.updateViewLayout(this, this.f15226f);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f15224c.getWindowVisibleDisplayFrame(this.f15234n);
        if (Intrinsics.areEqual(this.f15234n, this.f15233m)) {
            return;
        }
        o();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (((java.lang.Boolean) r5.f15235o.invoke((r6.getRawX() == 0.0f || r6.getRawY() == 0.0f) ? null : androidx.compose.ui.geometry.Offset.d(androidx.compose.ui.geometry.OffsetKt.a(r6.getRawX(), r6.getRawY())), r0)).booleanValue() != false) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L7
            boolean r6 = super.onTouchEvent(r6)
            return r6
        L7:
            int r0 = r6.getAction()
            r1 = 0
            if (r0 != 0) goto L38
            float r0 = r6.getX()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r6.getX()
            int r2 = r5.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
            float r0 = r6.getY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r6.getY()
            int r2 = r5.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
        L38:
            int r0 = r6.getAction()
            r2 = 4
            if (r0 != r2) goto L7f
        L3f:
            androidx.compose.ui.unit.IntRect r0 = r5.h()
            if (r0 == 0) goto L76
            kotlin.jvm.functions.Function2 r2 = r5.f15235o
            float r3 = r6.getRawX()
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L50
            goto L58
        L50:
            float r3 = r6.getRawY()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L5a
        L58:
            r1 = 0
            goto L6a
        L5a:
            float r1 = r6.getRawX()
            float r3 = r6.getRawY()
            long r3 = androidx.compose.ui.geometry.OffsetKt.a(r1, r3)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.d(r3)
        L6a:
            java.lang.Object r0 = r2.invoke(r1, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7f
        L76:
            kotlin.jvm.functions.Function0 r6 = r5.f15222a
            if (r6 == 0) goto L7d
            r6.invoke()
        L7d:
            r6 = 1
            return r6
        L7f:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.PopupLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.f15228h = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m142setPopupContentSizefhxjrPA(IntSize intSize) {
        this.f15230j.setValue(intSize);
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.f15227g = popupPositionProvider;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
    }
}
