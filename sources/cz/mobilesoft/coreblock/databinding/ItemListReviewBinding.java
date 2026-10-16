package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListReviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialCardView f96737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RatingBar f96739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96740d;

    private ItemListReviewBinding(MaterialCardView materialCardView, TextView textView, RatingBar ratingBar, TextView textView2) {
        this.f96737a = materialCardView;
        this.f96738b = textView;
        this.f96739c = ratingBar;
        this.f96740d = textView2;
    }

    public static ItemListReviewBinding a(View view) {
        int i3 = R.id.f95631k1;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.H1;
            RatingBar ratingBar = (RatingBar) ViewBindings.a(view, i3);
            if (ratingBar != null) {
                i3 = R.id.N1;
                TextView textView2 = (TextView) ViewBindings.a(view, i3);
                if (textView2 != null) {
                    return new ItemListReviewBinding((MaterialCardView) view, textView, ratingBar, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ItemListReviewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.X, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.f96737a;
    }
}
