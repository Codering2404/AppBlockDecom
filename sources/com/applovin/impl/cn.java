package com.applovin.impl;

import com.applovin.impl.aq;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinAdLoadListener;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class cn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final eq f58981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdLoadListener f58982i;

    cn(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderVastAd", jVar);
        this.f58982i = appLovinAdLoadListener;
        this.f58981h = eqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Rendering VAST ad...");
        }
        int size = this.f58981h.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        jq jqVarA = null;
        nq nqVarA = null;
        dq dqVarA = null;
        cq cqVarA = null;
        String strA2 = "";
        for (es esVar : this.f58981h.a()) {
            es esVarB = esVar.b(mq.b(esVar) ? "Wrapper" : YgVrd.BhxlShaLhrhUcj);
            if (esVarB != null) {
                es esVarB2 = esVarB.b("AdSystem");
                if (esVarB2 != null) {
                    jqVarA = jq.a(esVarB2, jqVarA, this.f65231a);
                }
                strA = mq.a(esVarB, "AdTitle", strA);
                strA2 = mq.a(esVarB, "Description", strA2);
                mq.a(esVarB.a("Impression"), hashSet, this.f58981h, this.f65231a);
                es esVarC = esVarB.c("ViewableImpression");
                if (esVarC != null) {
                    mq.a(esVarC.a("Viewable"), hashSet, this.f58981h, this.f65231a);
                }
                es esVarB3 = esVarB.b("AdVerifications");
                if (esVarB3 != null) {
                    cqVarA = cq.a(esVarB3, cqVarA, this.f58981h, this.f65231a);
                }
                mq.a(esVarB.a("Error"), hashSet2, this.f58981h, this.f65231a);
                es esVarC2 = esVarB.c("Creatives");
                if (esVarC2 != null) {
                    for (es esVar2 : esVarC2.b()) {
                        es esVarC3 = esVar2.c("Linear");
                        if (esVarC3 != null) {
                            nqVarA = nq.a(esVarC3, nqVarA, this.f58981h, this.f65231a);
                        } else {
                            es esVarB4 = esVar2.b("CompanionAds");
                            if (esVarB4 != null) {
                                es esVarB5 = esVarB4.b("Companion");
                                if (esVarB5 != null) {
                                    dqVarA = dq.a(esVarB5, dqVarA, this.f58981h, this.f65231a);
                                }
                            } else if (com.applovin.impl.sdk.n.a()) {
                                this.f65233c.b(this.f65232b, "Received and will skip rendering for an unidentified creative: " + esVar2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Did not find wrapper or inline response for node: " + esVar);
            }
        }
        aq aqVarA = new aq.b().a(this.f65231a).a(this.f58981h.b()).b(this.f58981h.e()).a(this.f58981h.c()).b(strA).a(strA2).a(jqVarA).a(nqVarA).a(dqVarA).a(cqVarA).b(hashSet).a(cqVarA).a(hashSet2).a();
        fq fqVarC = mq.c(aqVarA);
        if (fqVarC == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Finished rendering VAST ad: " + aqVarA);
            }
            aqVarA.getAdEventTracker().e();
            this.f65231a.i0().a((yl) new dm(aqVarA, this.f65231a, this.f58982i), tm.b.CACHING);
            return;
        }
        mq.a(this.f58981h, this.f58982i, fqVarC, -6, this.f65231a);
    }
}
