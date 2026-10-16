package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutRatingBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RatingBar f96808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RatingBar f96809b;

    private LayoutRatingBarBinding(RatingBar ratingBar, RatingBar ratingBar2) {
        this.f96808a = ratingBar;
        this.f96809b = ratingBar2;
    }

    public static LayoutRatingBarBinding a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RatingBar ratingBar = (RatingBar) view;
        return new LayoutRatingBarBinding(ratingBar, ratingBar);
    }

    public static LayoutRatingBarBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static LayoutRatingBarBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95709m0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RatingBar getRoot() {
        return this.f96808a;
    }
}
