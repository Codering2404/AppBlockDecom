package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MenuItemImpl f1350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f1351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f1352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    MenuBuilder.ItemInvoker f1353d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ForwardingListener f1354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    PopupCallback f1355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1360l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu b() {
            PopupCallback popupCallback = ActionMenuItemView.this.f1355g;
            if (popupCallback != null) {
                return popupCallback.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean c() {
            ShowableListMenu showableListMenuB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f1353d;
            return itemInvoker != null && itemInvoker.b(actionMenuItemView.f1350a) && (showableListMenuB = b()) != null && showableListMenuB.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class PopupCallback {
        public abstract ShowableListMenu a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (i3 < 480) {
            return (i3 >= 640 && i4 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    private void h() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1351b);
        if (this.f1352c != null && (!this.f1350a.B() || (!this.f1356h && !this.f1357i))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f1351b : null);
        CharSequence contentDescription = this.f1350a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z4 ? null : this.f1350a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1350a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.a(this, z4 ? null : this.f1350a.getTitle());
        } else {
            TooltipCompat.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean b() {
        return f() && this.f1350a.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i3) {
        this.f1350a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.i(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f1354f == null) {
            this.f1354f = new ActionMenuItemForwardingListener();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return true;
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f1350a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f1353d;
        if (itemInvoker != null) {
            itemInvoker.b(this.f1350a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1356h = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        boolean zF = f();
        if (zF && (i5 = this.f1359k) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1358j) : this.f1358j;
        if (mode != 1073741824 && this.f1358j > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i4);
        }
        if (zF || this.f1352c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1352c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.f1350a.hasSubMenu() && (forwardingListener = this.f1354f) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f1357i != z2) {
            this.f1357i = z2;
            MenuItemImpl menuItemImpl = this.f1350a;
            if (menuItemImpl != null) {
                menuItemImpl.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1352c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.f1360l;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
            } else {
                i3 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i3);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f1353d = itemInvoker;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        this.f1359k = i3;
        super.setPadding(i3, i4, i5, i6);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f1355g = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1351b = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Resources resources = context.getResources();
        this.f1356h = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f885v, i3, 0);
        this.f1358j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f888w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1360l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1359k = -1;
        setSaveEnabled(false);
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }
}
