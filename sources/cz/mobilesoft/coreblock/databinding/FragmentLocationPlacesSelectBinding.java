package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentLocationPlacesSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f96664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f96665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f96666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EditText f96667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Toolbar f96668f;

    private FragmentLocationPlacesSelectBinding(FrameLayout frameLayout, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, EditText editText, Toolbar toolbar) {
        this.f96663a = frameLayout;
        this.f96664b = progressBar;
        this.f96665c = progressBar2;
        this.f96666d = recyclerView;
        this.f96667e = editText;
        this.f96668f = toolbar;
    }

    public static FragmentLocationPlacesSelectBinding a(View view) {
        int i3 = R.id.G0;
        ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i3);
        if (progressBar != null) {
            i3 = R.id.F1;
            ProgressBar progressBar2 = (ProgressBar) ViewBindings.a(view, i3);
            if (progressBar2 != null) {
                i3 = R.id.I1;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i3);
                if (recyclerView != null) {
                    i3 = R.id.R1;
                    EditText editText = (EditText) ViewBindings.a(view, i3);
                    if (editText != null) {
                        i3 = R.id.f95636l2;
                        Toolbar toolbar = (Toolbar) ViewBindings.a(view, i3);
                        if (toolbar != null) {
                            return new FragmentLocationPlacesSelectBinding((FrameLayout) view, progressBar, progressBar2, recyclerView, editText, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentLocationPlacesSelectBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.L, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96663a;
    }
}
