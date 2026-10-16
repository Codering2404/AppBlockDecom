package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationBarPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f81423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavigationBarMenuView f81424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f81425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f81426d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f81427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ParcelableSparseArray f81428b;

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f81427a);
            parcel.writeParcelable(this.f81428b, 0);
        }

        SavedState(Parcel parcel) {
            this.f81427a = parcel.readInt();
            this.f81428b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void b(boolean z2) {
        this.f81425c = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f81424b.k(savedState.f81427a);
            this.f81424b.j(BadgeUtils.d(this.f81424b.getContext(), savedState.f81428b));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f81427a = this.f81424b.getSelectedItemId();
        savedState.f81428b = BadgeUtils.e(this.f81424b.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f81426d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        if (this.f81425c) {
            return;
        }
        if (z2) {
            this.f81424b.d();
        } else {
            this.f81424b.l();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void k(Context context, MenuBuilder menuBuilder) {
        this.f81423a = menuBuilder;
        this.f81424b.a(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
    }
}
