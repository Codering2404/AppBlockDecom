package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.stack.PermissionCardView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListPermissionCardViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PermissionCardView f96735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PermissionCardView f96736b;

    private ItemListPermissionCardViewBinding(PermissionCardView permissionCardView, PermissionCardView permissionCardView2) {
        this.f96735a = permissionCardView;
        this.f96736b = permissionCardView2;
    }

    public static ItemListPermissionCardViewBinding a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        PermissionCardView permissionCardView = (PermissionCardView) view;
        return new ItemListPermissionCardViewBinding(permissionCardView, permissionCardView);
    }

    public static ItemListPermissionCardViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.W, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PermissionCardView getRoot() {
        return this.f96735a;
    }
}
