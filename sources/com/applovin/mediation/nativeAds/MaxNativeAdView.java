package com.applovin.mediation.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.ie;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinStarRatingView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAdView extends FrameLayout {
    public static final String MEDIUM_TEMPLATE_1 = "medium_template_1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f65538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f65539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f65540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f65541d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Button f65542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageView f65543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FrameLayout f65544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ViewGroup f65545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FrameLayout f65546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ViewGroup f65547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewGroup f65548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final FrameLayout f65549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.applovin.impl.mediation.ads.b f65550n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f65551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f65552b;

        a(WeakReference weakReference, ViewGroup viewGroup) {
            this.f65551a = weakReference;
            this.f65552b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f65551a.get();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                j.f63329u0.I();
                if (n.a()) {
                    j.f63329u0.I().k("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                }
            } else {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.f65551a.clear();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65552b.getLayoutParams();
            layoutParams.height = ((View) this.f65552b.getParent()).getWidth();
            this.f65552b.setLayoutParams(layoutParams);
            return true;
        }
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
    }

    public com.applovin.impl.mediation.ads.b getAdViewTracker() {
        return this.f65550n;
    }

    public TextView getAdvertiserTextView() {
        return this.f65540c;
    }

    public TextView getBodyTextView() {
        return this.f65541d;
    }

    public Button getCallToActionButton() {
        return this.f65542f;
    }

    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList(5);
        TextView textView = this.f65539b;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f65540c;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.f65541d;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        Button button = this.f65542f;
        if (button != null) {
            arrayList.add(button);
        }
        ImageView imageView = this.f65543g;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        return arrayList;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.f65544h;
    }

    public ImageView getIconImageView() {
        return this.f65543g;
    }

    public View getMainView() {
        return this.f65538a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.f65549m;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.f65548l;
        return viewGroup != null ? viewGroup : this.f65549m;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.f65546j;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.f65545i;
        return viewGroup != null ? viewGroup : this.f65546j;
    }

    public ViewGroup getStarRatingContentViewGroup() {
        return this.f65547k;
    }

    public TextView getTitleTextView() {
        return this.f65539b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.applovin.impl.mediation.ads.b bVar = this.f65550n;
        if (bVar != null) {
            bVar.c();
        }
        if (isHardwareAccelerated()) {
            return;
        }
        n.j("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
    }

    public void recycle() {
        setOnClickListener(null);
        com.applovin.impl.mediation.ads.b bVar = this.f65550n;
        if (bVar != null) {
            bVar.a();
            this.f65550n = null;
        }
        View view = this.f65538a;
        if (view == null || view.getParent() == this) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f65538a.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            removeView(viewGroup);
        }
        addView(this.f65538a);
    }

    public void render(ie ieVar, a.InterfaceC0110a interfaceC0110a, j jVar) {
        recycle();
        if (!ieVar.s0().get() || !ieVar.q0().get()) {
            this.f65550n = new com.applovin.impl.mediation.ads.b(ieVar, this, interfaceC0110a, jVar);
        }
        final MaxNativeAd nativeAd = ieVar.getNativeAd();
        if (ieVar.t0() && nativeAd.isContainerClickable()) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("MaxNativeAdView", "Enabling container click");
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.nativeAds.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nativeAd.performClick();
                }
            });
        }
        if (StringUtils.isValidString(ieVar.r0())) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("MaxNativeAdView", "Rendering template ad view");
            }
            a(nativeAd);
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().a("MaxNativeAdView", "Rendering custom ad view");
        }
        renderCustomNativeAdView(nativeAd);
    }

    public void renderCustomNativeAdView(MaxNativeAd maxNativeAd) {
        TextView textView = this.f65539b;
        if (textView != null) {
            textView.setText(maxNativeAd.getTitle());
        }
        TextView textView2 = this.f65541d;
        if (textView2 != null) {
            textView2.setText(maxNativeAd.getBody());
        }
        TextView textView3 = this.f65540c;
        if (textView3 != null) {
            textView3.setText(maxNativeAd.getAdvertiser());
        }
        Button button = this.f65542f;
        if (button != null) {
            button.setText(maxNativeAd.getCallToAction());
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.f65543g;
        if (imageView != null) {
            if (icon == null) {
                imageView.setImageDrawable(null);
            } else if (icon.getDrawable() != null) {
                this.f65543g.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null) {
                ImageViewUtils.setAndDownscaleImageUri(this.f65543g, icon.getUri());
            } else {
                this.f65543g.setImageDrawable(null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.f65548l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f65548l.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.f65545i;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f65545i.addView(optionsView);
                this.f65545i.bringToFront();
            }
        }
        ViewGroup viewGroup3 = this.f65547k;
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f65547k.addView(appLovinStarRatingView);
            }
        }
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    private int a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_small_template_1;
            }
            if (MEDIUM_TEMPLATE_1.equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid format: " + str);
        }
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return "vertical_banner_template".equals(str) ? R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? R.layout.max_native_ad_vertical_media_banner_view : R.layout.max_native_ad_banner_view;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return "vertical_leader_template".equals(str) ? R.layout.max_native_ad_vertical_leader_view : R.layout.max_native_ad_leader_view;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return R.layout.max_native_ad_mrec_view;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private void b() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.applovin_native_inner_parent_layout);
        if (viewGroup == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new a(new WeakReference(viewTreeObserver), viewGroup));
        }
    }

    @Deprecated
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        this(maxNativeAd, str, activity.getApplicationContext());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Context context) {
        MaxNativeAdViewBinder.Builder iconContentViewId = new MaxNativeAdViewBinder.Builder(-1).setTemplateType(str).setTitleTextViewId(R.id.applovin_native_title_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setCallToActionButtonId(R.id.applovin_native_cta_button).setIconImageViewId(R.id.applovin_native_icon_image_view).setIconContentViewId(R.id.applovin_native_icon_view);
        int i3 = R.id.applovin_native_options_view;
        MaxNativeAdViewBinder.Builder starRatingContentViewGroupId = iconContentViewId.setOptionsContentViewGroupId(i3).setOptionsContentFrameLayoutId(i3).setStarRatingContentViewGroupId(R.id.applovin_native_star_rating_view);
        int i4 = R.id.applovin_native_media_content_view;
        this(maxNativeAd, starRatingContentViewGroupId.setMediaContentViewGroupId(i4).setMediaContentFrameLayoutId(i4).build(), context);
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        int iA;
        super(context);
        boolean z2 = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        View view = maxNativeAdViewBinder.mainView;
        if (view != null) {
            this.f65538a = view;
        } else {
            if (z2) {
                iA = a(maxNativeAdViewBinder.templateType, format);
            } else {
                iA = maxNativeAdViewBinder.layoutResourceId;
            }
            this.f65538a = LayoutInflater.from(context).inflate(iA, (ViewGroup) this, false);
        }
        addView(this.f65538a);
        this.f65539b = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.f65540c = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.f65541d = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.f65542f = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        this.f65543g = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.f65544h = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.f65545i = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.f65546j = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.f65547k = (ViewGroup) findViewById(maxNativeAdViewBinder.starRatingContentViewGroupId);
        this.f65548l = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.f65549m = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        if (maxNativeAd != null) {
            a(maxNativeAd);
        }
    }

    private void a(MaxNativeAd maxNativeAd) {
        if (this.f65539b == null) {
            n.j("MaxNativeAdView", "Rendering template ad view without title text view");
        } else if (StringUtils.isValidString(maxNativeAd.getTitle())) {
            this.f65539b.setText(maxNativeAd.getTitle());
        } else {
            this.f65539b.setVisibility(8);
        }
        if (this.f65540c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.f65540c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.f65540c.setVisibility(8);
            }
        }
        if (this.f65541d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.f65541d.setText(maxNativeAd.getBody());
            } else if (maxNativeAd.getFormat() != MaxAdFormat.NATIVE && maxNativeAd.getFormat() != MaxAdFormat.MREC) {
                this.f65541d.setVisibility(4);
            } else {
                this.f65541d.setVisibility(8);
            }
        }
        if (this.f65542f != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.f65542f.setText(maxNativeAd.getCallToAction());
            } else if (maxNativeAd.getFormat() != MaxAdFormat.NATIVE && maxNativeAd.getFormat() != MaxAdFormat.MREC) {
                this.f65542f.setVisibility(4);
            } else {
                this.f65542f.setVisibility(8);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.f65544h;
        if (frameLayout != null) {
            if (icon == null || this.f65543g == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.f65544h.removeAllViews();
                    this.f65544h.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.f65543g.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null && StringUtils.isValidString(icon.getUri().toString())) {
                ImageViewUtils.setAndDownscaleImageUri(this.f65543g, icon.getUri());
            } else {
                this.f65544h.setVisibility(8);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.f65546j;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f65546j.addView(optionsView);
            this.f65546j.bringToFront();
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.f65549m != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f65549m.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.f65549m.setVisibility(8);
            }
        }
        if (this.f65547k != null) {
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                this.f65547k.removeAllViews();
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f65547k.addView(appLovinStarRatingView);
            } else {
                this.f65547k.setVisibility(8);
            }
        }
        b();
        postDelayed(new Runnable() { // from class: com.applovin.mediation.nativeAds.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f65568a.a();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        setSelected(true);
    }
}
