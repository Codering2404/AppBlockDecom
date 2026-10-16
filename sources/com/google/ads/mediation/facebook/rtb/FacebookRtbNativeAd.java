package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookRtbNativeAd extends NativeAdMapper {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MediationAdLoadCallback f69019q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private NativeAdBase f69020r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MediationNativeAdCallback f69021s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MediaView f69022t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MetaFactory f69023u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FacebookAdapterNativeAdImage extends NativeAd.Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f69025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f69026b;

        public FacebookAdapterNativeAdImage() {
        }

        @Override // com.google.android.gms.ads.nativead.NativeAd.Image
        public Drawable getDrawable() {
            return this.f69025a;
        }

        @Override // com.google.android.gms.ads.nativead.NativeAd.Image
        public double getScale() {
            return 1.0d;
        }

        @Override // com.google.android.gms.ads.nativead.NativeAd.Image
        public Uri getUri() {
            return this.f69026b;
        }

        public FacebookAdapterNativeAdImage(Uri uri) {
            this.f69026b = uri;
        }

        public FacebookAdapterNativeAdImage(Drawable drawable) {
            this.f69025a = drawable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface NativeAdMapperListener {
        void a(AdError adError);

        void b();
    }

    public FacebookRtbNativeAd(MediationAdLoadCallback mediationAdLoadCallback, MetaFactory metaFactory) {
        this.f69019q = mediationAdLoadCallback;
        this.f69023u = metaFactory;
    }

    private boolean L(NativeAdBase nativeAdBase) {
        boolean z2 = (nativeAdBase.getAdHeadline() == null || nativeAdBase.getAdBodyText() == null || nativeAdBase.getAdIcon() == null || nativeAdBase.getAdCallToAction() == null) ? false : true;
        return nativeAdBase instanceof NativeBannerAd ? z2 : (!z2 || nativeAdBase.getAdCoverImage() == null || this.f69022t == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Context context, NativeAdMapperListener nativeAdMapperListener) {
        if (!L(this.f69020r)) {
            AdError adError = new AdError(108, "Ad from Meta Audience Network doesn't have all required assets.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.w(FacebookMediationAdapter.TAG, adError.c());
            nativeAdMapperListener.a(adError);
            return;
        }
        z(this.f69020r.getAdHeadline());
        if (this.f69020r.getAdCoverImage() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.f69020r.getAdCoverImage().getUrl())));
            B(arrayList);
        }
        v(this.f69020r.getAdBodyText());
        if (this.f69020r.getPreloadedIconViewDrawable() != null) {
            A(new FacebookAdapterNativeAdImage(this.f69020r.getPreloadedIconViewDrawable()));
        } else if (this.f69020r.getAdIcon() == null) {
            A(new FacebookAdapterNativeAdImage());
        } else {
            A(new FacebookAdapterNativeAdImage(Uri.parse(this.f69020r.getAdIcon().getUrl())));
        }
        w(this.f69020r.getAdCallToAction());
        u(this.f69020r.getAdvertiserName());
        this.f69022t.setListener(new MediaViewListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.1
            @Override // com.facebook.ads.MediaViewListener
            public void onComplete(MediaView mediaView) {
                if (FacebookRtbNativeAd.this.f69021s != null) {
                    FacebookRtbNativeAd.this.f69021s.onVideoComplete();
                }
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onEnterFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onExitFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenBackground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenForeground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPause(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPlay(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onVolumeChange(MediaView mediaView, float f3) {
            }
        });
        y(true);
        C(this.f69022t);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("id", this.f69020r.getId());
        bundle.putCharSequence(FacebookMediationAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f69020r.getAdSocialContext());
        x(bundle);
        t(new AdOptionsView(context, this.f69020r, null));
        nativeAdMapperListener.b();
    }

    @Override // com.google.android.gms.ads.mediation.NativeAdMapper
    public void E(View view, Map map, Map map2) {
        D(true);
        ArrayList arrayList = new ArrayList(map.values());
        View view2 = (View) map.get("3003");
        NativeAdBase nativeAdBase = this.f69020r;
        if (nativeAdBase instanceof NativeBannerAd) {
            if (view2 == null) {
                Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Meta Audience Network impression recording might be impacted for this ad.");
                return;
            } else if (view2 instanceof ImageView) {
                ((NativeBannerAd) nativeAdBase).registerViewForInteraction(view, (ImageView) view2, arrayList);
                return;
            } else {
                Log.w(FacebookMediationAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Meta Audience Network impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", view2.getClass()));
                return;
            }
        }
        if (!(nativeAdBase instanceof com.facebook.ads.NativeAd)) {
            Log.w(FacebookMediationAdapter.TAG, QgXempTBEfV.GTaIdcqnIlwT);
            return;
        }
        com.facebook.ads.NativeAd nativeAd = (com.facebook.ads.NativeAd) nativeAdBase;
        if (view2 instanceof ImageView) {
            nativeAd.registerViewForInteraction(view, this.f69022t, (ImageView) view2, arrayList);
        } else {
            Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView. Calling registerViewForInteraction() without a reference to the icon view.");
            nativeAd.registerViewForInteraction(view, this.f69022t, arrayList);
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeAdMapper
    public void F(View view) {
        NativeAdBase nativeAdBase = this.f69020r;
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
            this.f69020r.destroy();
            this.f69020r = null;
        }
        MediaView mediaView = this.f69022t;
        if (mediaView != null) {
            mediaView.destroy();
            this.f69022t = null;
        }
        super.F(view);
    }

    public void N(MediationNativeAdConfiguration mediationNativeAdConfiguration) {
        String placementId = FacebookMediationAdapter.getPlacementId(mediationNativeAdConfiguration.d());
        if (TextUtils.isEmpty(placementId)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.f69019q.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(mediationNativeAdConfiguration);
        this.f69022t = this.f69023u.c(mediationNativeAdConfiguration.b());
        try {
            this.f69020r = NativeAdBase.fromBidPayload(mediationNativeAdConfiguration.b(), placementId, mediationNativeAdConfiguration.a());
            if (!TextUtils.isEmpty(mediationNativeAdConfiguration.e())) {
                this.f69020r.setExtraHints(new ExtraHints.Builder().mediationData(mediationNativeAdConfiguration.e()).build());
            }
            NativeAdBase nativeAdBase = this.f69020r;
            nativeAdBase.loadAd(nativeAdBase.buildLoadAdConfig().withAdListener(new NativeListener(mediationNativeAdConfiguration.b(), this.f69020r)).withBid(mediationNativeAdConfiguration.a()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e3) {
            AdError adError2 = new AdError(109, "Failed to create native ad from bid payload: " + e3.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN);
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            this.f69019q.onFailure(adError2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NativeListener implements AdListener, NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f69027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final NativeAdBase f69028b;

        NativeListener(Context context, NativeAdBase nativeAdBase) {
            this.f69028b = nativeAdBase;
            this.f69027a = new WeakReference(context);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            FacebookRtbNativeAd.this.f69021s.reportAdClicked();
            FacebookRtbNativeAd.this.f69021s.onAdOpened();
            FacebookRtbNativeAd.this.f69021s.onAdLeftApplication();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            if (ad != this.f69028b) {
                AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", FacebookMediationAdapter.ERROR_DOMAIN);
                Log.e(FacebookMediationAdapter.TAG, adError.c());
                FacebookRtbNativeAd.this.f69019q.onFailure(adError);
                return;
            }
            Context context = (Context) this.f69027a.get();
            if (context != null) {
                FacebookRtbNativeAd.this.M(context, new NativeAdMapperListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeListener.1
                    @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                    public void a(AdError adError2) {
                        Log.w(FacebookMediationAdapter.TAG, adError2.c());
                        FacebookRtbNativeAd.this.f69019q.onFailure(adError2);
                    }

                    @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                    public void b() {
                        FacebookRtbNativeAd facebookRtbNativeAd = FacebookRtbNativeAd.this;
                        facebookRtbNativeAd.f69021s = (MediationNativeAdCallback) facebookRtbNativeAd.f69019q.onSuccess(FacebookRtbNativeAd.this);
                    }
                });
                return;
            }
            AdError adError2 = new AdError(107, "Context is null.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError2.c());
            FacebookRtbNativeAd.this.f69019q.onFailure(adError2);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            FacebookRtbNativeAd.this.f69019q.onFailure(adError2);
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }
    }
}
