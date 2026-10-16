package com.google.android.material.navigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavigationBarMenu f81429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavigationBarMenuView f81430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NavigationBarPresenter f81431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MenuInflater f81432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnItemSelectedListener f81433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnItemReselectedListener f81434g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnItemReselectedListener {
        void a(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnItemSelectedListener {
        boolean a(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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
        Bundle f81436c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void d(Parcel parcel, ClassLoader classLoader) {
            this.f81436c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f81436c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            d(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.f81432d == null) {
            this.f81432d = new SupportMenuInflater(getContext());
        }
        return this.f81432d;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f81430b.getActiveIndicatorLabelPadding();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f81430b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f81430b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f81430b.getItemActiveIndicatorMarginHorizontal();
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.f81430b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f81430b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f81430b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f81430b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f81430b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f81430b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f81430b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f81430b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f81430b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f81430b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f81430b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f81430b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f81430b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f81429a;
    }

    public MenuView getMenuView() {
        return this.f81430b;
    }

    public NavigationBarPresenter getPresenter() {
        return this.f81431c;
    }

    public int getSelectedItemId() {
        return this.f81430b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        this.f81429a.T(savedState.f81436c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f81436c = bundle;
        this.f81429a.V(bundle);
        return savedState;
    }

    public void setActiveIndicatorLabelPadding(int i3) {
        this.f81430b.setActiveIndicatorLabelPadding(i3);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeUtils.d(this, f3);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f81430b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z2) {
        this.f81430b.setItemActiveIndicatorEnabled(z2);
    }

    public void setItemActiveIndicatorHeight(int i3) {
        this.f81430b.setItemActiveIndicatorHeight(i3);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i3) {
        this.f81430b.setItemActiveIndicatorMarginHorizontal(i3);
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.f81430b.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(int i3) {
        this.f81430b.setItemActiveIndicatorWidth(i3);
    }

    public void setItemBackground(Drawable drawable) {
        this.f81430b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i3) {
        this.f81430b.setItemBackgroundRes(i3);
    }

    public void setItemIconSize(int i3) {
        this.f81430b.setItemIconSize(i3);
    }

    public void setItemIconSizeRes(int i3) {
        setItemIconSize(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f81430b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i3) {
        this.f81430b.setItemPaddingBottom(i3);
    }

    public void setItemPaddingTop(int i3) {
        this.f81430b.setItemPaddingTop(i3);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f81430b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i3) {
        this.f81430b.setItemTextAppearanceActive(i3);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        this.f81430b.setItemTextAppearanceActiveBoldEnabled(z2);
    }

    public void setItemTextAppearanceInactive(int i3) {
        this.f81430b.setItemTextAppearanceInactive(i3);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f81430b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.f81430b.getLabelVisibilityMode() != i3) {
            this.f81430b.setLabelVisibilityMode(i3);
            this.f81431c.h(false);
        }
    }

    public void setOnItemReselectedListener(OnItemReselectedListener onItemReselectedListener) {
        this.f81434g = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f81433f = onItemSelectedListener;
    }

    public void setSelectedItemId(int i3) {
        MenuItem menuItemFindItem = this.f81429a.findItem(i3);
        if (menuItemFindItem == null || this.f81429a.P(menuItemFindItem, this.f81431c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    /* JADX INFO: renamed from: com.google.android.material.navigation.NavigationBarView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationBarView f81435a;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f81435a.f81434g == null || menuItem.getItemId() != this.f81435a.getSelectedItemId()) {
                return (this.f81435a.f81433f == null || this.f81435a.f81433f.a(menuItem)) ? false : true;
            }
            this.f81435a.f81434g.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
        }
    }
}
