package com.applovin.impl;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class hn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final eq f60226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f60227i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, es esVar, int i3) {
            this.f65231a.i0().a(zm.a(esVar, hn.this.f60226h, hn.this.f60227i, hn.this.f65231a));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, es esVar) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to resolve VAST wrapper. Server returned " + i3);
            }
            hn.this.a(i3);
        }
    }

    hn(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskResolveVastWrapper", jVar);
        this.f60227i = appLovinAdLoadListener;
        this.f60226h = eqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = mq.a(this.f60226h);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, QgXempTBEfV.LTbcxGKhWmsTKL + this.f60226h.d() + " at " + strA);
        }
        try {
            this.f65231a.i0().a(new a(com.applovin.impl.sdk.network.a.a(this.f65231a).b(strA).c("GET").a(es.f59546f).a(((Integer) this.f65231a.a(sj.K4)).intValue()).c(((Integer) this.f65231a.a(sj.L4)).intValue()).a(false).a(), this.f65231a));
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unable to resolve VAST wrapper", th);
            }
            a(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Failed to resolve VAST wrapper due to error code " + i3);
        }
        if (i3 == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.f60227i;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i3);
                return;
            }
            return;
        }
        mq.a(this.f60226h, this.f60227i, i3 == -1001 ? fq.TIMED_OUT : fq.GENERAL_WRAPPER_ERROR, i3, this.f65231a);
    }
}
