package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.dd;
import com.applovin.impl.ie;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.yc;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdPlacer implements dd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinSdkUtils.Size f65569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MaxNativeAdViewBinder f65570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final yc f65571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final dd f65572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Listener f65573e;
    protected final n logger;
    protected final j sdk;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i3);

        void onAdRemoved(int i3);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public void clearAds() {
        a(this.f65571c.b(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f65594a.b();
            }
        });
    }

    public Collection<Integer> clearTrailingAds(final int i3) {
        final Collection<Integer> collectionE = this.f65571c.e(i3);
        if (!collectionE.isEmpty()) {
            a(collectionE, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65595a.a(i3, collectionE);
                }
            });
        }
        return collectionE;
    }

    public void destroy() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Destroying ad placer");
        }
        clearAds();
        this.f65572d.c();
    }

    public long getAdItemId(int i3) {
        if (isFilledPosition(i3)) {
            return -System.identityHashCode(this.f65571c.a(i3));
        }
        return 0L;
    }

    public AppLovinSdkUtils.Size getAdSize(int i3, int i4) {
        if (isFilledPosition(i3)) {
            AppLovinSdkUtils.Size size = this.f65569a;
            boolean z2 = size != AppLovinSdkUtils.Size.ZERO;
            int iMin = Math.min(z2 ? size.getWidth() : 360, i4);
            ie ieVar = (ie) this.f65571c.a(i3);
            if ("small_template_1".equalsIgnoreCase(ieVar.r0())) {
                return new AppLovinSdkUtils.Size(iMin, z2 ? this.f65569a.getHeight() : 120);
            }
            if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(ieVar.r0())) {
                return new AppLovinSdkUtils.Size(iMin, (int) (((double) iMin) / (z2 ? ((double) this.f65569a.getWidth()) / ((double) this.f65569a.getHeight()) : 1.2d)));
            }
            if (z2) {
                return this.f65569a;
            }
            if (ieVar.o0() != null) {
                View mainView = ieVar.o0().getMainView();
                return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public int getAdjustedCount(int i3) {
        return this.f65571c.b(i3);
    }

    public int getAdjustedPosition(int i3) {
        return this.f65571c.c(i3);
    }

    public int getOriginalPosition(int i3) {
        return this.f65571c.d(i3);
    }

    public void insertItem(int i3) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Inserting item at position: " + i3);
        }
        this.f65571c.f(i3);
    }

    public boolean isAdPosition(int i3) {
        return this.f65571c.g(i3);
    }

    public boolean isFilledPosition(int i3) {
        return this.f65571c.h(i3);
    }

    public void loadAds() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Loading ads");
        }
        this.f65572d.e();
    }

    public void moveItem(int i3, int i4) {
        this.f65571c.b(i3, i4);
    }

    @Override // com.applovin.impl.dd.a
    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.f65573e;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.impl.dd.a
    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.f65573e;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.impl.dd.a
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        if (n.a()) {
            this.logger.b("MaxAdPlacer", "Native ad failed to load: " + maxError);
        }
    }

    @Override // com.applovin.impl.dd.a
    public void onNativeAdLoaded() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Native ad enqueued");
        }
        a();
    }

    public void removeItem(final int i3) {
        a(isFilledPosition(i3) ? Collections.singletonList(Integer.valueOf(i3)) : Collections.EMPTY_LIST, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f65592a.a(i3);
            }
        });
    }

    public void renderAd(int i3, ViewGroup viewGroup) {
        MaxAd maxAdA = this.f65571c.a(i3);
        if (maxAdA == null) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "An ad is not available for position: " + i3);
                return;
            }
            return;
        }
        MaxNativeAdView maxNativeAdViewO0 = ((ie) maxAdA).o0();
        if (maxNativeAdViewO0 == null) {
            if (this.f65570b == null) {
                if (n.a()) {
                    this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i3 + ". If you're using a custom ad template, check that nativeAdViewBinder is set.");
                    return;
                }
                return;
            }
            maxNativeAdViewO0 = new MaxNativeAdView(this.f65570b, viewGroup.getContext());
            if (this.f65572d.a(maxNativeAdViewO0, maxAdA)) {
                if (n.a()) {
                    this.logger.a("MaxAdPlacer", "Rendered ad at position: " + i3);
                }
            } else if (n.a()) {
                this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i3);
            }
        } else if (n.a()) {
            this.logger.a("MaxAdPlacer", "Using pre-rendered ad at position: " + i3);
        }
        for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
            if (viewGroup.getChildAt(childCount) instanceof MaxNativeAdView) {
                viewGroup.removeViewAt(childCount);
            }
        }
        if (maxNativeAdViewO0.getParent() != null) {
            ((ViewGroup) maxNativeAdViewO0.getParent()).removeView(maxNativeAdViewO0);
        }
        viewGroup.addView(maxNativeAdViewO0, -1, -1);
    }

    public void setAdSize(int i3, int i4) {
        this.f65569a = new AppLovinSdkUtils.Size(i3, i4);
    }

    public void setListener(Listener listener) {
        this.f65573e = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.f65570b = maxNativeAdViewBinder;
    }

    public void updateFillablePositions(int i3, int i4) {
        this.f65571c.c(i3, i4);
        if (i3 == -1 || i4 == -1) {
            return;
        }
        a();
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.f65569a = AppLovinSdkUtils.Size.ZERO;
        j jVarA = appLovinSdk.a();
        this.sdk = jVarA;
        n nVarI = jVarA.I();
        this.logger = nVarI;
        this.f65571c = new yc(maxAdPlacerSettings);
        this.f65572d = new dd(maxAdPlacerSettings, context, this);
        if (n.a()) {
            nVarI.a("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, Collection collection) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing trailing ads after position " + i3);
        }
        this.f65571c.a(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing all cached ads");
        }
        this.f65571c.a();
        this.f65572d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removing item at position: " + i3);
        }
        this.f65571c.i(i3);
    }

    private void a() {
        int iC;
        while (this.f65572d.d() && (iC = this.f65571c.c()) != -1) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "Placing ad at position: " + iC);
            }
            this.f65571c.a(this.f65572d.b(), iC);
            Listener listener = this.f65573e;
            if (listener != null) {
                listener.onAdLoaded(iC);
            }
        }
    }

    private void a(Collection collection, Runnable runnable) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.f65572d.a(this.f65571c.a(((Integer) it.next()).intValue()));
        }
        runnable.run();
        if (collection.isEmpty()) {
            return;
        }
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
        }
        if (this.f65573e != null) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                this.f65573e.onAdRemoved(((Integer) it2.next()).intValue());
            }
        }
    }
}
