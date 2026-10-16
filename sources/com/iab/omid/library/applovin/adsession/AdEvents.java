package com.iab.omid.library.applovin.adsession;

import com.iab.omid.library.applovin.adsession.media.VastProperties;
import com.iab.omid.library.applovin.utils.g;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AdEvents {
    private final a adSession;

    private AdEvents(a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession) {
        a aVar = (a) adSession;
        g.a(adSession, "AdSession is null");
        g.g(aVar);
        g.b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        g.b(this.adSession);
        g.e(this.adSession);
        if (!this.adSession.f()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.f()) {
            this.adSession.k();
        }
    }

    public void loaded() {
        g.a(this.adSession);
        g.e(this.adSession);
        this.adSession.l();
    }

    public void loaded(VastProperties vastProperties) {
        g.a(vastProperties, "VastProperties is null");
        g.a(this.adSession);
        g.e(this.adSession);
        this.adSession.a(vastProperties.a());
    }
}
