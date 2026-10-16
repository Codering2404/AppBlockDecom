package com.iab.omid.library.applovin.adsession;

import android.view.View;
import com.iab.omid.library.applovin.internal.c;
import com.iab.omid.library.applovin.internal.e;
import com.iab.omid.library.applovin.internal.f;
import com.iab.omid.library.applovin.internal.i;
import com.iab.omid.library.applovin.publisher.AdSessionStatePublisher;
import com.iab.omid.library.applovin.publisher.b;
import com.iab.omid.library.applovin.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f92105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f92106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f92107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.applovin.weakreference.a f92108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f92109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f92110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f92111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f92112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f92113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f92114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f92115k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    private void a() {
        if (this.f92113i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void b() {
        if (this.f92114j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.f92111g) {
            return;
        }
        this.f92107c.a(view, friendlyObstructionPurpose, str);
    }

    public View c() {
        return this.f92108d.get();
    }

    public List<e> d() {
        return this.f92107c.a();
    }

    public boolean e() {
        return this.f92115k != null;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f92111g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f92110f && !this.f92111g;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void finish() {
        if (this.f92111g) {
            return;
        }
        this.f92108d.clear();
        removeAllFriendlyObstructions();
        this.f92111g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f92109e = null;
        this.f92115k = null;
    }

    public boolean g() {
        return this.f92111g;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public String getAdSessionId() {
        return this.f92112h;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f92109e;
    }

    public boolean h() {
        return this.f92106b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f92106b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f92110f;
    }

    void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f92113i = true;
    }

    void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f92114j = true;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f92111g) {
            return;
        }
        g.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        b(view);
        getAdSessionStatePublisher().a();
        a(view);
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f92111g) {
            return;
        }
        this.f92107c.b();
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f92111g) {
            return;
        }
        this.f92107c.c(view);
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f92115k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void start() {
        if (this.f92110f) {
            return;
        }
        this.f92110f = true;
        c.c().c(this);
        this.f92109e.a(i.c().b());
        this.f92109e.a(com.iab.omid.library.applovin.internal.a.a().b());
        this.f92109e.a(this, this.f92105a);
    }

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f92107c = new f();
        this.f92110f = false;
        this.f92111g = false;
        this.f92106b = adSessionConfiguration;
        this.f92105a = adSessionContext;
        this.f92112h = str;
        b(null);
        this.f92109e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.applovin.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f92109e.i();
        c.c().a(this);
        this.f92109e.a(adSessionConfiguration);
    }

    private void a(View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.c() == view) {
                aVar.f92108d.clear();
            }
        }
    }

    private void b(View view) {
        this.f92108d = new com.iab.omid.library.applovin.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.applovin.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.applovin.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f92115k.onPossibleObstructionsDetected(this.f92112h, arrayList);
        }
    }

    void a(JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f92114j = true;
    }
}
