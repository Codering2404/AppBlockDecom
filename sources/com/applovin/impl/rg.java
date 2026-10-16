package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class rg extends lg {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f62827p = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final aq f62828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f62829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaEvents f62830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final VastProperties f62831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f62832l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f62833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f62834n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f62835o;

    public rg(aq aqVar) {
        super(aqVar);
        this.f62829i = new AtomicBoolean();
        this.f62832l = new AtomicBoolean();
        this.f62833m = new AtomicBoolean();
        this.f62834n = new AtomicBoolean();
        this.f62835o = new AtomicBoolean();
        this.f62828h = aqVar;
        float fS1 = aqVar.s1();
        if (aqVar.s1() == -1) {
            this.f62831k = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            this.f62831k = VastProperties.createVastPropertiesForSkippableMedia(fS1, true, Position.STANDALONE);
        }
    }

    public void A() {
        b("track resumed", new Runnable() { // from class: com.applovin.impl.l40
            @Override // java.lang.Runnable
            public final void run() {
                this.f61111a.s();
            }
        });
    }

    public void B() {
        b("track skipped", new Runnable() { // from class: com.applovin.impl.c40
            @Override // java.lang.Runnable
            public final void run() {
                this.f58820a.t();
            }
        });
    }

    public void C() {
        if (this.f62835o.compareAndSet(false, true)) {
            b("track third quartile", new Runnable() { // from class: com.applovin.impl.h40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60129a.u();
                }
            });
        }
    }

    @Override // com.applovin.impl.lg
    protected AdSessionConfiguration a() {
        try {
            CreativeType creativeType = CreativeType.VIDEO;
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.NATIVE;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f61216c.a(this.f61217d, "Failed to create ad session configuration", th);
            return null;
        }
    }

    public void b(final float f3, final boolean z2) {
        if (this.f62832l.compareAndSet(false, true)) {
            b("track started", new Runnable() { // from class: com.applovin.impl.m40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61365a.a(f3, z2);
                }
            });
        }
    }

    @Override // com.applovin.impl.lg
    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.f40
            @Override // java.lang.Runnable
            public final void run() {
                this.f59634a.p();
            }
        });
    }

    public void v() {
        b("track clicked", new Runnable() { // from class: com.applovin.impl.e40
            @Override // java.lang.Runnable
            public final void run() {
                this.f59359a.m();
            }
        });
    }

    public void w() {
        b("track completed", new Runnable() { // from class: com.applovin.impl.b40
            @Override // java.lang.Runnable
            public final void run() {
                this.f58554a.n();
            }
        });
    }

    public void x() {
        if (this.f62833m.compareAndSet(false, true)) {
            b("track first quartile", new Runnable() { // from class: com.applovin.impl.a40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58170a.o();
                }
            });
        }
    }

    public void y() {
        if (this.f62834n.compareAndSet(false, true)) {
            b("track midpoint", new Runnable() { // from class: com.applovin.impl.j40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60602a.q();
                }
            });
        }
    }

    public void z() {
        b("track paused", new Runnable() { // from class: com.applovin.impl.d40
            @Override // java.lang.Runnable
            public final void run() {
                this.f59085a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f62830j.bufferFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f62830j.bufferStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f62830j.adUserInteraction(InteractionType.CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f62830j.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.f62830j.firstQuartile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f61220g.loaded(this.f62831k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f62830j.midpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f62830j.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.f62830j.resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f62830j.skipped();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f62830j.thirdQuartile();
    }

    public void i() {
        if (this.f62829i.compareAndSet(true, false)) {
            b("buffer finished", new Runnable() { // from class: com.applovin.impl.g40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59865a.k();
                }
            });
        }
    }

    public void j() {
        if (this.f62829i.compareAndSet(false, true)) {
            b("buffer started", new Runnable() { // from class: com.applovin.impl.i40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60347a.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float f3, boolean z2) {
        this.f62830j.start(f3, z2 ? 0.0f : 1.0f);
    }

    public void b(final boolean z2) {
        b("track volume changed", new Runnable() { // from class: com.applovin.impl.k40
            @Override // java.lang.Runnable
            public final void run() {
                this.f60910a.a(z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2) {
        this.f62830j.volumeChange(z2 ? 0.0f : 1.0f);
    }

    @Override // com.applovin.impl.lg
    protected void a(AdSession adSession) {
        try {
            this.f62830j = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.a(this.f61217d, "Failed to create media events", th);
            }
        }
    }

    @Override // com.applovin.impl.lg
    protected AdSessionContext a(WebView webView) {
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters;
        if (!f62827p && this.f62828h.k1() == null) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        for (bq bqVar : this.f62828h.k1().b()) {
            List<hq> listC = bqVar.c();
            if (listC.isEmpty()) {
                mq.a(bqVar.b(), fq.FAILED_TO_LOAD_RESOURCE, this.f61215b);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (hq hqVar : listC) {
                    if ("omid".equalsIgnoreCase(hqVar.b())) {
                        arrayList2.add(hqVar);
                    }
                }
                if (arrayList2.isEmpty()) {
                    mq.a(bqVar.b(), fq.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED, this.f61215b);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList2.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList2.get(i4);
                        i4++;
                        try {
                            arrayList3.add(new URL(((hq) obj).c()));
                        } catch (Throwable th) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f61216c.a(this.f61217d, "Failed to parse JavaScript resource url", th);
                            }
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        mq.a(bqVar.b(), fq.FAILED_TO_LOAD_RESOURCE, this.f61215b);
                    } else {
                        String strE = bqVar.e();
                        String strD = bqVar.d();
                        if (StringUtils.isValidString(strE) && !StringUtils.isValidString(strD)) {
                            mq.a(bqVar.b(), fq.FAILED_TO_LOAD_RESOURCE, this.f61215b);
                        } else {
                            int size2 = arrayList3.size();
                            while (i3 < size2) {
                                Object obj2 = arrayList3.get(i3);
                                i3++;
                                URL url = (URL) obj2;
                                if (StringUtils.isValidString(strE)) {
                                    verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(strD, url, strE);
                                } else {
                                    verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                                }
                                arrayList.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
                            }
                        }
                    }
                }
            }
        }
        String strA = this.f61215b.V().a();
        if (TextUtils.isEmpty(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.b(this.f61217d, "JavaScript SDK content not loaded successfully");
            }
            return null;
        }
        try {
            return AdSessionContext.createNativeAdSessionContext(this.f61215b.V().b(), strA, arrayList, this.f62828h.getOpenMeasurementContentUrl(), this.f62828h.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th2) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f61216c.a(this.f61217d, "Failed to create ad session context", th2);
            return null;
        }
    }
}
