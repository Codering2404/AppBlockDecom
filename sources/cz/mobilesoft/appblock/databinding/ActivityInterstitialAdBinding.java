package cz.mobilesoft.appblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.appblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityInterstitialAdBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f93987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f93988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f93989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f93990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Button f93991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f93992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f93993g;

    private ActivityInterstitialAdBinding(ScrollView scrollView, ImageView imageView, TextView textView, ImageView imageView2, Button button, TextView textView2, TextView textView3) {
        this.f93987a = scrollView;
        this.f93988b = imageView;
        this.f93989c = textView;
        this.f93990d = imageView2;
        this.f93991e = button;
        this.f93992f = textView2;
        this.f93993g = textView3;
    }

    public static ActivityInterstitialAdBinding a(View view) {
        int i3 = R.id.closeButton;
        ImageView imageView = (ImageView) ViewBindings.a(view, R.id.closeButton);
        if (imageView != null) {
            i3 = R.id.descriptionTextView;
            TextView textView = (TextView) ViewBindings.a(view, R.id.descriptionTextView);
            if (textView != null) {
                i3 = R.id.iconImageView;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, R.id.iconImageView);
                if (imageView2 != null) {
                    i3 = R.id.premiumButton;
                    Button button = (Button) ViewBindings.a(view, R.id.premiumButton);
                    if (button != null) {
                        i3 = R.id.subtitleTextView;
                        TextView textView2 = (TextView) ViewBindings.a(view, R.id.subtitleTextView);
                        if (textView2 != null) {
                            i3 = R.id.titleTextView;
                            TextView textView3 = (TextView) ViewBindings.a(view, R.id.titleTextView);
                            if (textView3 != null) {
                                return new ActivityInterstitialAdBinding((ScrollView) view, imageView, textView, imageView2, button, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityInterstitialAdBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityInterstitialAdBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_interstitial_ad, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f93987a;
    }
}
