package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuItemImpl f1412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f1413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RadioButton f1414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f1415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CheckBox f1416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f1417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f1418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f1419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinearLayout f1420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f1421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f1423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f1425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LayoutInflater f1427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1428r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f636c0);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i3) {
        LinearLayout linearLayout = this.f1420j;
        if (linearLayout != null) {
            linearLayout.addView(view, i3);
        } else {
            addView(view, i3);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.f768j, (ViewGroup) this, false);
        this.f1416f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.f769k, (ViewGroup) this, false);
        this.f1413b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.f771m, (ViewGroup) this, false);
        this.f1414c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f1427q == null) {
            this.f1427q = LayoutInflater.from(getContext());
        }
        return this.f1427q;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f1418h;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1419i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1419i.getLayoutParams();
        rect.top += this.f1419i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i3) {
        this.f1412a = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.i(this));
        setCheckable(menuItemImpl.isCheckable());
        h(menuItemImpl.A(), menuItemImpl.g());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f1412a;
    }

    public void h(boolean z2, char c3) {
        int i3 = (z2 && this.f1412a.A()) ? 0 : 8;
        if (i3 == 0) {
            this.f1417g.setText(this.f1412a.h());
        }
        if (this.f1417g.getVisibility() != i3) {
            this.f1417g.setVisibility(i3);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f1421k);
        TextView textView = (TextView) findViewById(R.id.S);
        this.f1415d = textView;
        int i3 = this.f1422l;
        if (i3 != -1) {
            textView.setTextAppearance(this.f1423m, i3);
        }
        this.f1417g = (TextView) findViewById(R.id.L);
        ImageView imageView = (ImageView) findViewById(R.id.O);
        this.f1418h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1425o);
        }
        this.f1419i = (ImageView) findViewById(R.id.f753u);
        this.f1420j = (LinearLayout) findViewById(R.id.f745m);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f1413b != null && this.f1424n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1413b.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f1414c == null && this.f1416f == null) {
            return;
        }
        if (this.f1412a.m()) {
            if (this.f1414c == null) {
                g();
            }
            compoundButton = this.f1414c;
            view = this.f1416f;
        } else {
            if (this.f1416f == null) {
                e();
            }
            compoundButton = this.f1416f;
            view = this.f1414c;
        }
        if (z2) {
            compoundButton.setChecked(this.f1412a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1416f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1414c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f1412a.m()) {
            if (this.f1414c == null) {
                g();
            }
            compoundButton = this.f1414c;
        } else {
            if (this.f1416f == null) {
                e();
            }
            compoundButton = this.f1416f;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f1428r = z2;
        this.f1424n = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f1419i;
        if (imageView != null) {
            imageView.setVisibility((this.f1426p || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f1412a.z() || this.f1428r;
        if (z2 || this.f1424n) {
            ImageView imageView = this.f1413b;
            if (imageView == null && drawable == null && !this.f1424n) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f1424n) {
                this.f1413b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1413b;
            if (!z2) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1413b.getVisibility() != 0) {
                this.f1413b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1415d.getVisibility() != 8) {
                this.f1415d.setVisibility(8);
            }
        } else {
            this.f1415d.setText(charSequence);
            if (this.f1415d.getVisibility() != 0) {
                this.f1415d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayV = TintTypedArray.v(getContext(), attributeSet, R.styleable.f820d2, i3, 0);
        this.f1421k = tintTypedArrayV.g(R.styleable.f828f2);
        this.f1422l = tintTypedArrayV.n(R.styleable.f824e2, -1);
        this.f1424n = tintTypedArrayV.a(R.styleable.f832g2, false);
        this.f1423m = context;
        this.f1425o = tintTypedArrayV.g(R.styleable.f836h2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.Y, 0);
        this.f1426p = typedArrayObtainStyledAttributes.hasValue(0);
        tintTypedArrayV.x();
        typedArrayObtainStyledAttributes.recycle();
    }
}
