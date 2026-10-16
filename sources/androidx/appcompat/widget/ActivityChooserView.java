package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ActivityChooserViewAdapter f1683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Callbacks f1684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f1685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f1686d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final FrameLayout f1687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageView f1688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final FrameLayout f1689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f1690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f1691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ActionProvider f1692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final DataSetObserver f1693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f1694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ListPopupWindow f1695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    PopupWindow.OnDismissListener f1696o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f1697p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f1698q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1699r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1700s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActivityChooserViewAdapter extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ActivityChooserModel f1706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1707b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1709d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1710f;

        ActivityChooserViewAdapter() {
        }

        public int a() {
            return this.f1706a.f();
        }

        public ActivityChooserModel b() {
            return this.f1706a;
        }

        public ResolveInfo c() {
            return this.f1706a.h();
        }

        public int d() {
            return this.f1706a.i();
        }

        public boolean e() {
            return this.f1708c;
        }

        public int f() {
            int i3 = this.f1707b;
            this.f1707b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1707b = i3;
            return iMax;
        }

        public void g(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel activityChooserModelB = ActivityChooserView.this.f1683a.b();
            if (activityChooserModelB != null && ActivityChooserView.this.isShown()) {
                activityChooserModelB.unregisterObserver(ActivityChooserView.this.f1693l);
            }
            this.f1706a = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f1693l);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iF = this.f1706a.f();
            if (!this.f1708c && this.f1706a.h() != null) {
                iF--;
            }
            int iMin = Math.min(iF, this.f1707b);
            return this.f1710f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f1708c && this.f1706a.h() != null) {
                i3++;
            }
            return this.f1706a.e(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            return (this.f1710f && i3 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.f764f, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(R.id.S)).setText(ActivityChooserView.this.getContext().getString(R.string.f782b));
                return viewInflate;
            }
            if (view == null || view.getId() != R.id.f756x) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.f764f, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id.f754v);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i3);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id.S)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1708c && i3 == 0 && this.f1709d) {
                view.setActivated(true);
                return view;
            }
            view.setActivated(false);
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i3) {
            if (this.f1707b != i3) {
                this.f1707b = i3;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z2, boolean z3) {
            if (this.f1708c == z2 && this.f1709d == z3) {
                return;
            }
            this.f1708c = z2;
            this.f1709d = z3;
            notifyDataSetChanged();
        }

        public void j(boolean z2) {
            if (this.f1710f != z2) {
                this.f1710f = z2;
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1696o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1689h) {
                if (view != activityChooserView.f1687f) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.f1697p = false;
                activityChooserView.d(activityChooserView.f1698q);
                return;
            }
            activityChooserView.a();
            Intent intentB = ActivityChooserView.this.f1683a.b().b(ActivityChooserView.this.f1683a.b().g(ActivityChooserView.this.f1683a.c()));
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.f1692k;
            if (actionProvider != null) {
                actionProvider.k(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.d(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f1697p) {
                if (i3 > 0) {
                    activityChooserView.f1683a.b().o(i3);
                    return;
                }
                return;
            }
            if (!activityChooserView.f1683a.e()) {
                i3++;
            }
            Intent intentB = ActivityChooserView.this.f1683a.b().b(i3);
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1689h) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f1683a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f1697p = true;
                activityChooserView2.d(activityChooserView2.f1698q);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f1713a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray tintTypedArrayU = TintTypedArray.u(context, attributeSet, f1713a);
            setBackgroundDrawable(tintTypedArrayU.g(0));
            tintTypedArrayU.x();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1694m);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().b();
    }

    public boolean c() {
        if (b() || !this.f1699r) {
            return false;
        }
        this.f1697p = false;
        d(this.f1698q);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void d(int i3) {
        if (this.f1683a.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1694m);
        ?? r02 = this.f1689h.getVisibility() == 0 ? 1 : 0;
        int iA = this.f1683a.a();
        if (i3 == Integer.MAX_VALUE || iA <= i3 + r02) {
            this.f1683a.j(false);
            this.f1683a.h(i3);
        } else {
            this.f1683a.j(true);
            this.f1683a.h(i3 - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.b()) {
            return;
        }
        if (this.f1697p || r02 == 0) {
            this.f1683a.i(true, r02);
        } else {
            this.f1683a.i(false, false);
        }
        listPopupWindow.E(Math.min(this.f1683a.f(), this.f1691j));
        listPopupWindow.show();
        ActionProvider actionProvider = this.f1692k;
        if (actionProvider != null) {
            actionProvider.k(true);
        }
        listPopupWindow.o().setContentDescription(getContext().getString(R.string.f783c));
        listPopupWindow.o().setSelector(new ColorDrawable(0));
    }

    void e() {
        if (this.f1683a.getCount() > 0) {
            this.f1687f.setEnabled(true);
        } else {
            this.f1687f.setEnabled(false);
        }
        int iA = this.f1683a.a();
        int iD = this.f1683a.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.f1689h.setVisibility(0);
            ResolveInfo resolveInfoC = this.f1683a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1690i.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.f1700s != 0) {
                this.f1689h.setContentDescription(getContext().getString(this.f1700s, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.f1689h.setVisibility(8);
        }
        if (this.f1689h.getVisibility() == 0) {
            this.f1685c.setBackgroundDrawable(this.f1686d);
        } else {
            this.f1685c.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f1683a.b();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f1695n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1695n = listPopupWindow;
            listPopupWindow.m(this.f1683a);
            this.f1695n.C(this);
            this.f1695n.I(true);
            this.f1695n.K(this.f1684b);
            this.f1695n.J(this.f1684b);
        }
        return this.f1695n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModelB = this.f1683a.b();
        if (activityChooserModelB != null) {
            activityChooserModelB.registerObserver(this.f1693l);
        }
        this.f1699r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModelB = this.f1683a.b();
        if (activityChooserModelB != null) {
            activityChooserModelB.unregisterObserver(this.f1693l);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1694m);
        }
        if (b()) {
            a();
        }
        this.f1699r = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        this.f1685c.layout(0, 0, i5 - i3, i6 - i4);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        View view = this.f1685c;
        if (this.f1689h.getVisibility() != 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), 1073741824);
        }
        measureChild(view, i3, i4);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f1683a.g(activityChooserModel);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i3) {
        this.f1700s = i3;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i3) {
        this.f1688g.setContentDescription(getContext().getString(i3));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1688g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i3) {
        this.f1698q = i3;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1696o = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1692k = actionProvider;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1693l = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f1683a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f1683a.notifyDataSetInvalidated();
            }
        };
        this.f1694m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.b()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    ActionProvider actionProvider = ActivityChooserView.this.f1692k;
                    if (actionProvider != null) {
                        actionProvider.k(true);
                    }
                }
            }
        };
        this.f1698q = 4;
        int[] iArr = R.styleable.E;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        this.f1698q = typedArrayObtainStyledAttributes.getInt(R.styleable.G, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.F);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.f763e, (ViewGroup) this, true);
        Callbacks callbacks = new Callbacks();
        this.f1684b = callbacks;
        View viewFindViewById = findViewById(R.id.f742j);
        this.f1685c = viewFindViewById;
        this.f1686d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f750r);
        this.f1689h = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i4 = R.id.f755w;
        this.f1690i = (ImageView) frameLayout.findViewById(i4);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.f752t);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.ActivityChooserView.3
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).f0(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            @Override // androidx.appcompat.widget.ForwardingListener
            public ShowableListMenu b() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean c() {
                ActivityChooserView.this.c();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            protected boolean d() {
                ActivityChooserView.this.a();
                return true;
            }
        });
        this.f1687f = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i4);
        this.f1688g = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.f1683a = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.e();
            }
        });
        Resources resources = context.getResources();
        this.f1691j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.f695d));
    }
}
