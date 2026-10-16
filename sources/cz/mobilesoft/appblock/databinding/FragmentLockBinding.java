package cz.mobilesoft.appblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textview.MaterialTextView;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.coreblock.view.badge.BadgeView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentLockBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f93996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f93997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f93998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaterialButton f93999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f94000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f94001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f94002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MaterialCardView f94003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MaterialTextView f94004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MaterialButton f94005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f94006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f94007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MaterialCardView f94008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f94009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f94010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MaterialCardView f94011p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MaterialTextView f94012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BadgeView f94013r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AppCompatImageView f94014s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f94015t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f94016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CircularProgressIndicator f94017v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f94018w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MaterialButton f94019x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MaterialCardView f94020y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f94021z;

    private FragmentLockBinding(ScrollView scrollView, FrameLayout frameLayout, TextView textView, MaterialButton materialButton, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, MaterialCardView materialCardView, MaterialTextView materialTextView, MaterialButton materialButton2, TextView textView4, TextView textView5, MaterialCardView materialCardView2, TextView textView6, ImageView imageView, MaterialCardView materialCardView3, MaterialTextView materialTextView2, BadgeView badgeView, AppCompatImageView appCompatImageView2, TextView textView7, ImageView imageView2, CircularProgressIndicator circularProgressIndicator, TextView textView8, MaterialButton materialButton3, MaterialCardView materialCardView4, TextView textView9) {
        this.f93996a = scrollView;
        this.f93997b = frameLayout;
        this.f93998c = textView;
        this.f93999d = materialButton;
        this.f94000e = textView2;
        this.f94001f = textView3;
        this.f94002g = appCompatImageView;
        this.f94003h = materialCardView;
        this.f94004i = materialTextView;
        this.f94005j = materialButton2;
        this.f94006k = textView4;
        this.f94007l = textView5;
        this.f94008m = materialCardView2;
        this.f94009n = textView6;
        this.f94010o = imageView;
        this.f94011p = materialCardView3;
        this.f94012q = materialTextView2;
        this.f94013r = badgeView;
        this.f94014s = appCompatImageView2;
        this.f94015t = textView7;
        this.f94016u = imageView2;
        this.f94017v = circularProgressIndicator;
        this.f94018w = textView8;
        this.f94019x = materialButton3;
        this.f94020y = materialCardView4;
        this.f94021z = textView9;
    }

    public static FragmentLockBinding a(View view) {
        int i3 = R.id.advertisementFrameLayout;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, R.id.advertisementFrameLayout);
        if (frameLayout != null) {
            i3 = R.id.appNameTextView;
            TextView textView = (TextView) ViewBindings.a(view, R.id.appNameTextView);
            if (textView != null) {
                i3 = R.id.backToAppButton;
                MaterialButton materialButton = (MaterialButton) ViewBindings.a(view, R.id.backToAppButton);
                if (materialButton != null) {
                    i3 = R.id.blockUntilTextView;
                    TextView textView2 = (TextView) ViewBindings.a(view, R.id.blockUntilTextView);
                    if (textView2 != null) {
                        i3 = R.id.blockingProfileTextView;
                        TextView textView3 = (TextView) ViewBindings.a(view, R.id.blockingProfileTextView);
                        if (textView3 != null) {
                            i3 = R.id.blockingReasonButton;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, R.id.blockingReasonButton);
                            if (appCompatImageView != null) {
                                i3 = R.id.campaignCardView;
                                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.a(view, R.id.campaignCardView);
                                if (materialCardView != null) {
                                    i3 = R.id.campaignTextView;
                                    MaterialTextView materialTextView = (MaterialTextView) ViewBindings.a(view, R.id.campaignTextView);
                                    if (materialTextView != null) {
                                        i3 = R.id.closeButton;
                                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.a(view, R.id.closeButton);
                                        if (materialButton2 != null) {
                                            i3 = R.id.explanationTextView;
                                            TextView textView4 = (TextView) ViewBindings.a(view, R.id.explanationTextView);
                                            if (textView4 != null) {
                                                i3 = R.id.explanationTitleTextView;
                                                TextView textView5 = (TextView) ViewBindings.a(view, R.id.explanationTitleTextView);
                                                if (textView5 != null) {
                                                    i3 = R.id.fitifyCardView;
                                                    MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.a(view, R.id.fitifyCardView);
                                                    if (materialCardView2 != null) {
                                                        i3 = R.id.fitifyTextView;
                                                        TextView textView6 = (TextView) ViewBindings.a(view, R.id.fitifyTextView);
                                                        if (textView6 != null) {
                                                            i3 = R.id.iconImageView;
                                                            ImageView imageView = (ImageView) ViewBindings.a(view, R.id.iconImageView);
                                                            if (imageView != null) {
                                                                i3 = R.id.inAppUpdateCardView;
                                                                MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.a(view, R.id.inAppUpdateCardView);
                                                                if (materialCardView3 != null) {
                                                                    i3 = R.id.inAppUpdateTextView;
                                                                    MaterialTextView materialTextView2 = (MaterialTextView) ViewBindings.a(view, R.id.inAppUpdateTextView);
                                                                    if (materialTextView2 != null) {
                                                                        i3 = R.id.lockedImageView;
                                                                        BadgeView badgeView = (BadgeView) ViewBindings.a(view, R.id.lockedImageView);
                                                                        if (badgeView != null) {
                                                                            i3 = R.id.moreButton;
                                                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.a(view, R.id.moreButton);
                                                                            if (appCompatImageView2 != null) {
                                                                                i3 = R.id.motivationalTextView;
                                                                                TextView textView7 = (TextView) ViewBindings.a(view, R.id.motivationalTextView);
                                                                                if (textView7 != null) {
                                                                                    i3 = R.id.overlayView;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.a(view, R.id.overlayView);
                                                                                    if (imageView2 != null) {
                                                                                        i3 = R.id.progressIndicator;
                                                                                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.a(view, R.id.progressIndicator);
                                                                                        if (circularProgressIndicator != null) {
                                                                                            i3 = R.id.progressTextView;
                                                                                            TextView textView8 = (TextView) ViewBindings.a(view, R.id.progressTextView);
                                                                                            if (textView8 != null) {
                                                                                                i3 = R.id.settingsButton;
                                                                                                MaterialButton materialButton3 = (MaterialButton) ViewBindings.a(view, R.id.settingsButton);
                                                                                                if (materialButton3 != null) {
                                                                                                    i3 = R.id.vosHealthCardView;
                                                                                                    MaterialCardView materialCardView4 = (MaterialCardView) ViewBindings.a(view, R.id.vosHealthCardView);
                                                                                                    if (materialCardView4 != null) {
                                                                                                        i3 = R.id.vosHealthTextView;
                                                                                                        TextView textView9 = (TextView) ViewBindings.a(view, R.id.vosHealthTextView);
                                                                                                        if (textView9 != null) {
                                                                                                            return new FragmentLockBinding((ScrollView) view, frameLayout, textView, materialButton, textView2, textView3, appCompatImageView, materialCardView, materialTextView, materialButton2, textView4, textView5, materialCardView2, textView6, imageView, materialCardView3, materialTextView2, badgeView, appCompatImageView2, textView7, imageView2, circularProgressIndicator, textView8, materialButton3, materialCardView4, textView9);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentLockBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_lock, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f93996a;
    }
}
