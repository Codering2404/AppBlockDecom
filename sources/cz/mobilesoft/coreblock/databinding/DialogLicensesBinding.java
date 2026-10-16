package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class DialogLicensesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView f96519a;

    private DialogLicensesBinding(RecyclerView recyclerView) {
        this.f96519a = recyclerView;
    }

    public static DialogLicensesBinding a(View view) {
        if (view != null) {
            return new DialogLicensesBinding((RecyclerView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static DialogLicensesBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static DialogLicensesBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95712o, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView getRoot() {
        return this.f96519a;
    }
}
