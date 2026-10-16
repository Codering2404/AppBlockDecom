package com.google.android.material.search;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.shape.MaterialShapeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, MaterialBackHandler {
    private static final int A = R.style.f79753z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ClippableRoundedCornerLayout f81661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final View f81662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f81663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final FrameLayout f81664d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final MaterialToolbar f81665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TextView f81666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final EditText f81667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final ImageButton f81668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final TouchObserverFrameLayout f81669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f81670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SearchViewAnimationHelper f81671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MaterialBackOrchestrator f81672m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f81673n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ElevationOverlayProvider f81674o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set f81675p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SearchBar f81676q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f81677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f81678s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f81679t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f81680u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f81681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f81682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f81683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TransitionState f81684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Map f81685z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.r() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f81687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f81688d;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f81687c);
            parcel.writeInt(this.f81688d);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f81687c = parcel.readString();
            this.f81688d = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TransitionListener {
        void a(SearchView searchView, TransitionState transitionState, TransitionState transitionState2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    private void A() {
        ImageButton imageButtonE = ToolbarUtils.e(this.f81665f);
        if (imageButtonE == null) {
            return;
        }
        int i3 = this.f81661a.getVisibility() == 0 ? 1 : 0;
        Drawable drawableQ = DrawableCompat.q(imageButtonE.getDrawable());
        if (drawableQ instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawableQ).setProgress(i3);
        }
        if (drawableQ instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawableQ).a(i3);
        }
    }

    private Window getActivityWindow() {
        Activity activityA = ContextUtils.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f81676q;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.E);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static /* synthetic */ void h(SearchView searchView) {
        searchView.f81667h.clearFocus();
        SearchBar searchBar = searchView.f81676q;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        ViewUtils.n(searchView.f81667h, searchView.f81682w);
    }

    public static /* synthetic */ void i(SearchView searchView) {
        if (searchView.f81667h.requestFocus()) {
            searchView.f81667h.sendAccessibilityEvent(8);
        }
        ViewUtils.u(searchView.f81667h, searchView.f81682w);
    }

    private boolean o() {
        return this.f81684y.equals(TransitionState.HIDDEN) || this.f81684y.equals(TransitionState.HIDING);
    }

    private boolean q(Toolbar toolbar) {
        return DrawableCompat.q(toolbar.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z2) {
        this.f81663c.setVisibility(z2 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f3) {
        ElevationOverlayProvider elevationOverlayProvider = this.f81674o;
        if (elevationOverlayProvider == null || this.f81662b == null) {
            return;
        }
        this.f81662b.setBackgroundColor(elevationOverlayProvider.c(this.f81681v, f3));
    }

    private void setUpHeaderLayout(int i3) {
        if (i3 != -1) {
            j(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this.f81664d, false));
        }
    }

    private void setUpStatusBarSpacer(int i3) {
        if (this.f81663c.getLayoutParams().height != i3) {
            this.f81663c.getLayoutParams().height = i3;
            this.f81663c.requestLayout();
        }
    }

    private void u(TransitionState transitionState, boolean z2) {
        if (this.f81684y.equals(transitionState)) {
            return;
        }
        if (z2) {
            if (transitionState == TransitionState.SHOWN) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        TransitionState transitionState2 = this.f81684y;
        this.f81684y = transitionState;
        Iterator it = new LinkedHashSet(this.f81675p).iterator();
        while (it.hasNext()) {
            ((TransitionListener) it.next()).a(this, transitionState2, transitionState);
        }
        y(transitionState);
    }

    private void v() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void x(ViewGroup viewGroup, boolean z2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != this) {
                if (childAt.findViewById(this.f81661a.getId()) != null) {
                    x((ViewGroup) childAt, z2);
                } else if (z2) {
                    this.f81685z.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.w0(childAt, 4);
                } else {
                    Map map = this.f81685z;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.w0(childAt, ((Integer) this.f81685z.get(childAt)).intValue());
                    }
                }
            }
        }
    }

    private void y(TransitionState transitionState) {
        if (this.f81676q == null || !this.f81673n) {
            return;
        }
        if (transitionState.equals(TransitionState.SHOWN)) {
            this.f81672m.c();
        } else if (transitionState.equals(TransitionState.HIDDEN)) {
            this.f81672m.f();
        }
    }

    private void z() {
        MaterialToolbar materialToolbar = this.f81665f;
        if (materialToolbar == null || q(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.f81676q == null) {
            this.f81665f.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable drawableR = DrawableCompat.r(AppCompatResources.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.f81665f.getNavigationIconTint() != null) {
            DrawableCompat.n(drawableR, this.f81665f.getNavigationIconTint().intValue());
        }
        this.f81665f.setNavigationIcon(new FadeThroughDrawable(this.f81676q.getNavigationIcon(), drawableR));
        A();
    }

    public void B() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f81677r = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void a() {
        if (o() || this.f81676q == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f81671l.o();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (this.f81670k) {
            this.f81669j.addView(view, i3, layoutParams);
        } else {
            super.addView(view, i3, layoutParams);
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void d(BackEventCompat backEventCompat) {
        if (o() || this.f81676q == null) {
            return;
        }
        this.f81671l.V(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void e(BackEventCompat backEventCompat) {
        if (o() || this.f81676q == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f81671l.a0(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void f() {
        if (o()) {
            return;
        }
        BackEventCompat backEventCompatN = this.f81671l.N();
        if (Build.VERSION.SDK_INT < 34 || this.f81676q == null || backEventCompatN == null) {
            l();
        } else {
            this.f81671l.p();
        }
    }

    MaterialMainContainerBackHelper getBackHelper() {
        return this.f81671l.r();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.f81684y;
    }

    protected int getDefaultNavigationIconResource() {
        return R.drawable.f79607b;
    }

    public EditText getEditText() {
        return this.f81667h;
    }

    public CharSequence getHint() {
        return this.f81667h.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f81666g;
    }

    public CharSequence getSearchPrefixText() {
        return this.f81666g.getText();
    }

    public int getSoftInputMode() {
        return this.f81677r;
    }

    public Editable getText() {
        return this.f81667h.getText();
    }

    public Toolbar getToolbar() {
        return this.f81665f;
    }

    public void j(View view) {
        this.f81664d.addView(view);
        this.f81664d.setVisibility(0);
    }

    public void k() {
        this.f81667h.post(new Runnable() { // from class: com.google.android.material.search.h
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.h(this.f81718a);
            }
        });
    }

    public void l() {
        if (this.f81684y.equals(TransitionState.HIDDEN) || this.f81684y.equals(TransitionState.HIDING)) {
            return;
        }
        this.f81671l.M();
    }

    boolean m() {
        return this.f81677r == 48;
    }

    public boolean n() {
        return this.f81678s;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        B();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        setText(savedState.f81687c);
        setVisible(savedState.f81688d == 0);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.f81687c = text == null ? null : text.toString();
        savedState.f81688d = this.f81661a.getVisibility();
        return savedState;
    }

    public boolean p() {
        return this.f81679t;
    }

    public boolean r() {
        return this.f81676q != null;
    }

    public void s() {
        this.f81667h.postDelayed(new Runnable() { // from class: com.google.android.material.search.e
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.i(this.f81715a);
            }
        }, 100L);
    }

    public void setAnimatedNavigationIcon(boolean z2) {
        this.f81678s = z2;
    }

    public void setAutoShowKeyboard(boolean z2) {
        this.f81680u = z2;
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        setUpBackgroundViewElevationOverlay(f3);
    }

    public void setHint(CharSequence charSequence) {
        this.f81667h.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z2) {
        this.f81679t = z2;
    }

    public void setModalForAccessibility(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z2) {
            this.f81685z = new HashMap(viewGroup.getChildCount());
        }
        x(viewGroup, z2);
        if (z2) {
            return;
        }
        this.f81685z = null;
    }

    public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.f81665f.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        this.f81666g.setText(charSequence);
        this.f81666g.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z2) {
        this.f81683x = true;
        setStatusBarSpacerEnabledInternal(z2);
    }

    public void setText(CharSequence charSequence) {
        this.f81667h.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z2) {
        this.f81665f.setTouchscreenBlocksFocus(z2);
    }

    void setTransitionState(TransitionState transitionState) {
        u(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z2) {
        this.f81682w = z2;
    }

    public void setVisible(boolean z2) {
        boolean z3 = this.f81661a.getVisibility() == 0;
        this.f81661a.setVisibility(z2 ? 0 : 8);
        A();
        u(z2 ? TransitionState.SHOWN : TransitionState.HIDDEN, z3 != z2);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f81676q = searchBar;
        this.f81671l.S(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f81716a.w();
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: com.google.android.material.search.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f81717a.w();
                        }
                    });
                    this.f81667h.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        z();
        v();
        y(getCurrentTransitionState());
    }

    void t() {
        if (this.f81680u) {
            s();
        }
    }

    public void w() {
        if (this.f81684y.equals(TransitionState.SHOWN) || this.f81684y.equals(TransitionState.SHOWING)) {
            return;
        }
        this.f81671l.U();
    }

    public void setHint(int i3) {
        this.f81667h.setHint(i3);
    }

    public void setText(int i3) {
        this.f81667h.setText(i3);
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchView f81686a;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            this.f81686a.f81668i.setVisibility(charSequence.length() > 0 ? 0 : 8);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }
}
