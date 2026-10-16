package com.applovin.impl;

import android.os.Bundle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.utils.StringUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f62431a = new StringBuilder();

    public pc a(com.applovin.impl.sdk.ad.b bVar) {
        boolean z2 = bVar instanceof aq;
        a("Format", bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null).a("Ad ID", Long.valueOf(bVar.getAdIdNumber())).a("Zone ID", bVar.getAdZone().e()).a("Ad Class", z2 ? "VastAd" : "AdServerAd");
        String dspName = bVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            a("DSP Name", dspName);
        }
        if (z2) {
            a("VAST DSP", ((aq) bVar).t1());
        }
        return this;
    }

    public pc b(com.applovin.impl.sdk.ad.b bVar) {
        a("Target", bVar.f0()).a("close_style", bVar.n()).a("close_delay_graphic", Long.valueOf(bVar.p()), "s");
        if (bVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) bVar;
            a("HTML", aVar.l1().substring(0, Math.min(aVar.l1().length(), 64)));
        }
        if (bVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(bVar.m0()), "s").a("skip_style", bVar.d0()).a("Streaming", Boolean.valueOf(bVar.K0())).a("Video Location", bVar.Q()).a("video_button_properties", bVar.k0());
        }
        return this;
    }

    public String toString() {
        return this.f62431a.toString();
    }

    public pc a(AppLovinAdView appLovinAdView) {
        return a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).a("Visibility", zq.a(appLovinAdView.getVisibility()));
    }

    public pc a(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                a(str, bundle.get(str));
            }
        }
        return this;
    }

    public pc a() {
        this.f62431a.append("\n========================================");
        return this;
    }

    public pc b(String str) {
        this.f62431a.append(str);
        return this;
    }

    public pc a(fe feVar) {
        return a("Network", feVar.c()).a("Adapter Version", feVar.z()).a("Format", feVar.getFormat().getLabel()).a("Ad Unit ID", feVar.getAdUnitId()).a("Placement", feVar.getPlacement()).a("Network Placement", feVar.T()).a("Serve ID", feVar.R()).a("Creative ID", StringUtils.isValidString(feVar.getCreativeId()) ? feVar.getCreativeId() : "None").a("Ad Review Creative ID", StringUtils.isValidString(feVar.getAdReviewCreativeId()) ? feVar.getAdReviewCreativeId() : "None").a("Ad Domain", StringUtils.isValidString(feVar.v()) ? feVar.v() : "None").a("DSP Name", StringUtils.isValidString(feVar.getDspName()) ? feVar.getDspName() : "None").a("DSP ID", StringUtils.isValidString(feVar.getDspId()) ? feVar.getDspId() : "None").a("Server Parameters", feVar.l());
    }

    public pc a(com.applovin.impl.sdk.j jVar) {
        return a("Muted", Boolean.valueOf(jVar.f0().isMuted()));
    }

    public pc a(String str) {
        StringBuilder sb = this.f62431a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    public pc a(String str, Object obj) {
        return a(str, obj, "");
    }

    public pc a(String str, Object obj, String str2) {
        StringBuilder sb = this.f62431a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }
}
