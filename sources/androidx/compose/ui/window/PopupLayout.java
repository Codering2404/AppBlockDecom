package androidx.compose.ui.window;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.R;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Companion f30250v = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f30251w = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Function1 f30252x = new Function1<PopupLayout, Unit>() { // from class: androidx.compose.ui.window.PopupLayout$Companion$onCommitAffectingPopupPosition$1
        public final void c(PopupLayout popupLayout) {
            if (popupLayout.isAttachedToWindow()) {
                popupLayout.s();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((PopupLayout) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f30253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PopupProperties f30254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f30255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f30256d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PopupLayoutHelper f30257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WindowManager f30258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WindowManager.LayoutParams f30259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PopupPositionProvider f30260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LayoutDirection f30261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f30262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f30263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IntRect f30264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final State f30265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f30266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f30267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final SnapshotStateObserver f30268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Object f30269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f30270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f30271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int[] f30272u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30274a;

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
            f30274a = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PopupLayout(Function0 function0, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, PopupLayoutHelper popupLayoutHelper, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        PopupLayoutHelper popupLayoutHelperImpl29;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            popupLayoutHelperImpl29 = Build.VERSION.SDK_INT >= 29 ? new PopupLayoutHelperImpl29() : new PopupLayoutHelperImpl();
        } else {
            popupLayoutHelperImpl29 = popupLayoutHelper;
        }
        this(function0, popupProperties, str, view, density, popupPositionProvider, uuid, popupLayoutHelperImpl29);
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.f30270s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.f30263l.getValue();
    }

    private final IntRect getVisibleDisplayBounds() {
        Rect rect = this.f30267p;
        this.f30257f.a(this.f30256d, rect);
        return AndroidPopup_androidKt.l(rect);
    }

    private final WindowManager.LayoutParams h() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = AndroidPopup_androidKt.j(this.f30254b, AndroidPopup_androidKt.k(this.f30256d));
        layoutParams.type = 1002;
        layoutParams.token = this.f30256d.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.f30256d.getContext().getResources().getString(R.string.f25157d));
        return layoutParams;
    }

    private final void i() {
        if (!this.f30254b.a() || Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (this.f30269r == null) {
            this.f30269r = Api33Impl.b(this.f30253a);
        }
        Api33Impl.d(this, this.f30269r);
    }

    private final void j() {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.e(this, this.f30269r);
        }
        this.f30269r = null;
    }

    private final void n(LayoutDirection layoutDirection) {
        int i3 = WhenMappings.f30274a[layoutDirection.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 0;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i4);
    }

    private final void r(PopupProperties popupProperties) {
        if (Intrinsics.areEqual(this.f30254b, popupProperties)) {
            return;
        }
        if (popupProperties.f() && !this.f30254b.f()) {
            WindowManager.LayoutParams layoutParams = this.f30259h;
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        this.f30254b = popupProperties;
        this.f30259h.flags = AndroidPopup_androidKt.j(popupProperties, AndroidPopup_androidKt.k(this.f30256d));
        this.f30257f.b(this.f30258g, this, this.f30259h);
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.f30270s.setValue(function2);
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.f30263l.setValue(layoutCoordinates);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i3) {
        composer.a0(-857613600);
        if (ComposerKt.M()) {
            ComposerKt.U(-857613600, i3, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:572)");
        }
        getContent().invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.b(this, null);
        this.f30258g.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f30254b.a()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1 && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                Function0 function0 = this.f30253a;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.f30265n.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.f30259h;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.f30261j;
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m281getPopupContentSizebOM6tXw() {
        return (IntSize) this.f30262k.getValue();
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.f30260i;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f30271t;
    }

    public final String getTestTag() {
        return this.f30255c;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* bridge */ /* synthetic */ View getViewRoot() {
        return super.getViewRoot();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean z2, int i3, int i4, int i5, int i6) {
        View childAt;
        super.internalOnLayout$ui_release(z2, i3, i4, i5, i6);
        if (this.f30254b.f() || (childAt = getChildAt(0)) == null) {
            return;
        }
        this.f30259h.width = childAt.getMeasuredWidth();
        this.f30259h.height = childAt.getMeasuredHeight();
        this.f30257f.b(this.f30258g, this, this.f30259h);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int i3, int i4) {
        if (this.f30254b.f()) {
            super.internalOnMeasure$ui_release(i3, i4);
        } else {
            IntRect visibleDisplayBounds = getVisibleDisplayBounds();
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.l(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.f(), Integer.MIN_VALUE));
        }
    }

    public final void k() {
        int[] iArr = this.f30272u;
        int i3 = iArr[0];
        int i4 = iArr[1];
        this.f30256d.getLocationOnScreen(iArr);
        int[] iArr2 = this.f30272u;
        if (i3 == iArr2[0] && i4 == iArr2[1]) {
            return;
        }
        p();
    }

    public final void l(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.f30271t = true;
    }

    public final void m() {
        this.f30258g.addView(this, this.f30259h);
    }

    public final void o(Function0 function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        this.f30253a = function0;
        this.f30255c = str;
        r(popupProperties);
        n(layoutDirection);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f30268q.t();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f30268q.u();
        this.f30268q.k();
        j();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f30254b.b()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (motionEvent.getX() < 0.0f || motionEvent.getX() >= getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() >= getHeight())) {
            Function0 function0 = this.f30253a;
            if (function0 != null) {
                function0.invoke();
            }
            return true;
        }
        if (motionEvent == null || motionEvent.getAction() != 4) {
            return super.onTouchEvent(motionEvent);
        }
        Function0 function02 = this.f30253a;
        if (function02 != null) {
            function02.invoke();
        }
        return true;
    }

    public final void p() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.m()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jA = parentLayoutCoordinates.a();
            long jG = LayoutCoordinatesKt.g(parentLayoutCoordinates);
            IntRect intRectA = IntRectKt.a(IntOffset.f((((long) Math.round(Float.intBitsToFloat((int) (jG >> 32)))) << 32) | (4294967295L & ((long) Math.round(Float.intBitsToFloat((int) (jG & 4294967295L)))))), jA);
            if (Intrinsics.areEqual(intRectA, this.f30264m)) {
                return;
            }
            this.f30264m = intRectA;
            s();
        }
    }

    public final void q(LayoutCoordinates layoutCoordinates) {
        setParentLayoutCoordinates(layoutCoordinates);
        p();
    }

    public final void s() {
        IntSize intSizeM281getPopupContentSizebOM6tXw;
        final IntRect intRect = this.f30264m;
        if (intRect == null || (intSizeM281getPopupContentSizebOM6tXw = m281getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        final long j3 = intSizeM281getPopupContentSizebOM6tXw.j();
        IntRect visibleDisplayBounds = getVisibleDisplayBounds();
        final long jC = IntSize.c((((long) visibleDisplayBounds.l()) << 32) | (((long) visibleDisplayBounds.f()) & 4294967295L));
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.f140143a = IntOffset.f29988b.b();
        this.f30268q.p(this, f30252x, new Function0<Unit>() { // from class: androidx.compose.ui.window.PopupLayout$updatePosition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m283invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m283invoke() {
                longRef.f140143a = this.getPositionProvider().a(intRect, jC, this.getParentLayoutDirection(), j3);
            }
        });
        this.f30259h.x = IntOffset.k(longRef.f140143a);
        this.f30259h.y = IntOffset.l(longRef.f140143a);
        if (this.f30254b.c()) {
            this.f30257f.c(this, (int) (jC >> 32), (int) (jC & 4294967295L));
        }
        this.f30257f.b(this.f30258g, this, this.f30259h);
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.f30261j = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m282setPopupContentSizefhxjrPA(IntSize intSize) {
        this.f30262k.setValue(intSize);
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.f30260i = popupPositionProvider;
    }

    public final void setTestTag(String str) {
        this.f30255c = str;
    }

    public PopupLayout(Function0 function0, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, PopupLayoutHelper popupLayoutHelper) {
        super(view.getContext(), null, 0, 6, null);
        this.f30253a = function0;
        this.f30254b = popupProperties;
        this.f30255c = str;
        this.f30256d = view;
        this.f30257f = popupLayoutHelper;
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f30258g = (WindowManager) systemService;
        this.f30259h = h();
        this.f30260i = popupPositionProvider;
        this.f30261j = LayoutDirection.f30001a;
        this.f30262k = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f30263l = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f30265n = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.ui.window.PopupLayout$canCalculatePosition$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                LayoutCoordinates parentLayoutCoordinates = this.f30275a.getParentLayoutCoordinates();
                if (parentLayoutCoordinates == null || !parentLayoutCoordinates.m()) {
                    parentLayoutCoordinates = null;
                }
                return Boolean.valueOf((parentLayoutCoordinates == null || this.f30275a.m281getPopupContentSizebOM6tXw() == null) ? false : true);
            }
        });
        float fG = Dp.g(8);
        this.f30266o = fG;
        this.f30267p = new Rect();
        this.f30268q = new SnapshotStateObserver(new PopupLayout$snapshotStateObserver$1(this));
        setId(android.R.id.content);
        ViewTreeLifecycleOwner.b(this, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(this, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(this, ViewTreeSavedStateRegistryOwner.a(view));
        setTag(R.id.H, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.M1(fG));
        setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.ui.window.PopupLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                outline.setAlpha(0.0f);
            }
        });
        this.f30270s = SnapshotStateKt__SnapshotStateKt.e(ComposableSingletons$AndroidPopup_androidKt.f30228a.a(), null, 2, null);
        this.f30272u = new int[2];
    }

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
    }
}
