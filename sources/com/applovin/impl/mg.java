package com.applovin.impl;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class mg extends lg {
    public mg(com.applovin.impl.sdk.ad.a aVar) {
        super(aVar);
    }

    @Override // com.applovin.impl.lg
    protected AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f61216c.a(this.f61217d, "Failed to create ad session configuration", th);
            return null;
        }
    }

    @Override // com.applovin.impl.lg
    protected AdSessionContext a(WebView webView) {
        try {
            if (this.f61214a.getOpenMeasurementVerificationScriptResources().size() > 0) {
                return AdSessionContext.createNativeAdSessionContext(this.f61215b.V().b(), this.f61215b.V().a(), this.f61214a.getOpenMeasurementVerificationScriptResources(), this.f61214a.getOpenMeasurementContentUrl(), this.f61214a.getOpenMeasurementCustomReferenceData());
            }
            return AdSessionContext.createHtmlAdSessionContext(this.f61215b.V().b(), webView, this.f61214a.getOpenMeasurementContentUrl(), this.f61214a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f61216c.a(this.f61217d, "Failed to create ad session context", th);
            return null;
        }
    }
}
