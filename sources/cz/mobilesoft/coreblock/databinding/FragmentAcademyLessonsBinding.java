package cz.mobilesoft.coreblock.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyLessonsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f96597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f96598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollView f96599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f96601i;

    private FragmentAcademyLessonsBinding(NestedScrollView nestedScrollView, ImageView imageView, TextView textView, TextView textView2, ProgressBar progressBar, RecyclerView recyclerView, NestedScrollView nestedScrollView2, TextView textView3, TextView textView4) {
        this.f96593a = nestedScrollView;
        this.f96594b = imageView;
        this.f96595c = textView;
        this.f96596d = textView2;
        this.f96597e = progressBar;
        this.f96598f = recyclerView;
        this.f96599g = nestedScrollView2;
        this.f96600h = textView3;
        this.f96601i = textView4;
    }

    public static FragmentAcademyLessonsBinding a(View view) {
        int i3 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.a(view, R.id.icon);
        if (imageView != null) {
            i3 = cz.mobilesoft.coreblock.R.id.X0;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = cz.mobilesoft.coreblock.R.id.Y0;
                TextView textView2 = (TextView) ViewBindings.a(view, i3);
                if (textView2 != null) {
                    i3 = R.id.progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, R.id.progress);
                    if (progressBar != null) {
                        i3 = cz.mobilesoft.coreblock.R.id.I1;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i3);
                        if (recyclerView != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                            i3 = R.id.text1;
                            TextView textView3 = (TextView) ViewBindings.a(view, R.id.text1);
                            if (textView3 != null) {
                                i3 = R.id.title;
                                TextView textView4 = (TextView) ViewBindings.a(view, R.id.title);
                                if (textView4 != null) {
                                    return new FragmentAcademyLessonsBinding(nestedScrollView, imageView, textView, textView2, progressBar, recyclerView, nestedScrollView, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentAcademyLessonsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(cz.mobilesoft.coreblock.R.layout.f95731y, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96593a;
    }
}
