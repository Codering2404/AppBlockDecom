package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.aq;
import com.applovin.impl.bm;
import com.applovin.impl.f1;
import com.applovin.impl.iq;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class dm extends bm {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final aq f59258r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f59259a;

        a(iq iqVar) {
            this.f59259a = iqVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                this.f59259a.a(uri);
                dm.this.f59258r.b(true);
                return;
            }
            com.applovin.impl.sdk.n nVar = dm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar = dm.this;
                dmVar.f65233c.b(dmVar.f65232b, "Failed to cache static companion ad");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements bm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f59261a;

        b(iq iqVar) {
            this.f59261a = iqVar;
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            this.f59261a.a(str);
            dm.this.f59258r.b(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements bm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ iq f59263a;

        c(iq iqVar) {
            this.f59263a = iqVar;
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            this.f59263a.a(str);
            dm.this.f59258r.b(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ oq f59265a;

        d(oq oqVar) {
            this.f59265a = oqVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.n nVar = dm.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    dm dmVar = dm.this;
                    dmVar.f65233c.a(dmVar.f65232b, "Video file successfully cached into: " + uri);
                }
                this.f59265a.a(uri);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = dm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar2 = dm.this;
                dmVar2.f65233c.b(dmVar2.f65232b, "Failed to cache video file: " + this.f59265a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class e implements bm.e {
        e() {
        }

        @Override // com.applovin.impl.bm.e
        public void a(String str) {
            if (dm.this.f59258r.isOpenMeasurementEnabled()) {
                str = dm.this.f65231a.V().a(str);
            }
            dm.this.f59258r.b(str);
            com.applovin.impl.sdk.n nVar = dm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                dm dmVar = dm.this;
                dmVar.f65233c.a(dmVar.f65232b, "Finish caching HTML template " + dm.this.f59258r.n1() + " for ad #" + dm.this.f59258r.getAdIdNumber());
            }
        }
    }

    public dm(aq aqVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aqVar, jVar, appLovinAdLoadListener);
        this.f59258r = aqVar;
    }

    private String d(String str) {
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f65231a.a(sj.Y4)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                Uri uriA = a(str2, Collections.EMPTY_LIST, false);
                if (uriA != null) {
                    str = str.replace(str2, uriA.toString());
                    this.f58720h.a(uriA);
                    this.f58721i.d();
                } else {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.b(this.f65232b, "Failed to cache JavaScript resource: " + str2);
                    }
                    this.f58721i.c();
                }
            }
        }
        return str;
    }

    private void n() {
        String strN1;
        if (l() || !mq.a(this.f59258r)) {
            return;
        }
        if (this.f59258r.o1() != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Begin caching HTML template. Fetching from " + this.f59258r.o1() + "...");
            }
            strN1 = b(this.f59258r.o1().toString(), this.f59258r.Y(), true);
        } else {
            strN1 = this.f59258r.n1();
        }
        if (!StringUtils.isValidString(strN1)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String strA = a(strN1, this.f59258r.Y(), this.f58720h);
        if (this.f59258r.isOpenMeasurementEnabled()) {
            strA = this.f65231a.V().a(strA);
        }
        this.f59258r.b(strA);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Finish caching HTML template " + this.f59258r.n1() + " for ad #" + this.f59258r.getAdIdNumber());
        }
    }

    private void o() {
        oq oqVarW1;
        Uri uriE;
        if (l()) {
            return;
        }
        if (!this.f59258r.B1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Video caching disabled. Skipping...");
                return;
            }
            return;
        }
        if (this.f59258r.v1() == null || (oqVarW1 = this.f59258r.w1()) == null || (uriE = oqVarW1.e()) == null) {
            return;
        }
        Uri uriC = c(uriE.toString(), Collections.EMPTY_LIST, false);
        if (uriC != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Video file successfully cached into: " + uriC);
            }
            oqVarW1.a(uriC);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Failed to cache video file: " + oqVarW1);
        }
    }

    private d1 p() {
        if (!this.f59258r.A1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        dq dqVarL1 = this.f59258r.l1();
        if (dqVarL1 == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "No companion ad provided. Skipping...");
            }
            return null;
        }
        iq iqVarE = dqVarL1.e();
        if (iqVarE == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri uriC = iqVarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = iqVarE.b();
        if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strB)) {
            if (iqVarE.d() == iq.a.STATIC) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Caching static companion ad at " + string + "...");
                }
                return new f1(string, this.f59258r, Collections.EMPTY_LIST, false, this.f58721i, this.f65231a, new a(iqVarE));
            }
            if (iqVarE.d() == iq.a.HTML) {
                if (!StringUtils.isValidString(string)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.a(this.f65232b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
                    }
                    return a(strB, Collections.EMPTY_LIST, new c(iqVarE));
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Begin caching HTML companion ad. Fetching from " + string + "...");
                }
                String strD = d(string, null, false);
                if (StringUtils.isValidString(strD)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.a(this.f65232b, "HTML fetched. Caching HTML now...");
                    }
                    return a(strD, Collections.EMPTY_LIST, new b(iqVarE));
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "Unable to load companion ad resources from " + string);
                }
            } else if (iqVarE.d() == iq.a.IFRAME && com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Skip caching of iFrame resource...");
            }
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.k(this.f65232b, "Companion ad does not have any resources attached. Skipping...");
        }
        return null;
    }

    @Override // com.applovin.impl.bm
    void f() {
        this.f59258r.getAdEventTracker().h();
        super.f();
    }

    protected e1 q() {
        if (!TextUtils.isEmpty(this.f59258r.n1())) {
            return a(this.f59258r.n1(), this.f59258r.Y(), new e());
        }
        if (!com.applovin.impl.sdk.n.a()) {
            return null;
        }
        this.f65233c.a(this.f65232b, "Unable to load HTML template");
        return null;
    }

    protected f1 r() {
        oq oqVarW1;
        Uri uriE;
        if (!this.f59258r.B1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.f59258r.v1() == null || (oqVarW1 = this.f59258r.w1()) == null || (uriE = oqVarW1.e()) == null) {
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching video file " + oqVarW1 + " creative...");
        }
        return a(uriE.toString(), Collections.EMPTY_LIST, false, (f1.a) new d(oqVarW1));
    }

    @Override // com.applovin.impl.bm, java.lang.Runnable
    public void run() {
        super.run();
        boolean zK0 = this.f59258r.K0();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar = this.f65233c;
            String str = this.f65232b;
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching for VAST ");
            sb.append(zK0 ? "streaming " : "");
            sb.append("ad #");
            sb.append(this.f58720h.getAdIdNumber());
            sb.append("...");
            nVar.a(str, sb.toString());
        }
        if (zK0) {
            if (((Boolean) this.f65231a.a(sj.I0)).booleanValue()) {
                if (!z3.f()) {
                    a(e());
                }
                if (this.f59258r.y1()) {
                    f();
                    ArrayList arrayList = new ArrayList();
                    d1 d1VarP = p();
                    if (d1VarP != null) {
                        arrayList.add(d1VarP);
                    }
                    e1 e1VarQ = q();
                    if (e1VarQ != null) {
                        arrayList.add(e1VarQ);
                    }
                    f1 f1VarR = r();
                    if (f1VarR != null) {
                        arrayList.add(f1VarR);
                    }
                    a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (this.f59258r.p1() == aq.c.COMPANION_AD) {
                        d1 d1VarP2 = p();
                        if (d1VarP2 != null) {
                            arrayList2.add(d1VarP2);
                        }
                        e1 e1VarQ2 = q();
                        if (e1VarQ2 != null) {
                            arrayList2.add(e1VarQ2);
                        }
                        a(arrayList2);
                        f();
                        f1 f1VarR2 = r();
                        if (f1VarR2 != null) {
                            arrayList3.add(f1VarR2);
                        }
                        a(arrayList3);
                    } else {
                        f1 f1VarR3 = r();
                        if (f1VarR3 != null) {
                            arrayList2.add(f1VarR3);
                        }
                        a(arrayList2);
                        f();
                        d1 d1VarP3 = p();
                        if (d1VarP3 != null) {
                            arrayList3.add(d1VarP3);
                        }
                        e1 e1VarQ3 = q();
                        if (e1VarQ3 != null) {
                            arrayList3.add(e1VarQ3);
                        }
                        a(arrayList3);
                    }
                }
            } else {
                j();
                if (this.f59258r.y1()) {
                    f();
                }
                aq.c cVarP1 = this.f59258r.p1();
                aq.c cVar = aq.c.COMPANION_AD;
                if (cVarP1 == cVar) {
                    m();
                    n();
                    a(this.f59258r);
                } else {
                    o();
                }
                if (!this.f59258r.y1()) {
                    f();
                }
                if (this.f59258r.p1() == cVar) {
                    o();
                } else {
                    m();
                    n();
                    a(this.f59258r);
                }
            }
        } else if (((Boolean) this.f65231a.a(sj.I0)).booleanValue()) {
            ArrayList arrayList4 = new ArrayList();
            if (!z3.f()) {
                arrayList4.addAll(e());
            }
            d1 d1VarP4 = p();
            if (d1VarP4 != null) {
                arrayList4.add(d1VarP4);
            }
            f1 f1VarR4 = r();
            if (f1VarR4 != null) {
                arrayList4.add(f1VarR4);
            }
            e1 e1VarQ4 = q();
            if (e1VarQ4 != null) {
                arrayList4.add(e1VarQ4);
            }
            a(arrayList4);
            f();
        } else {
            j();
            m();
            o();
            n();
            a(this.f59258r);
            f();
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Finished caching VAST ad #" + this.f59258r.getAdIdNumber());
        }
        this.f59258r.z1();
        k();
    }

    @Override // com.applovin.impl.bm
    void a(int i3) {
        this.f59258r.getAdEventTracker().f();
        super.a(i3);
    }

    private void m() {
        String string;
        if (!l()) {
            if (this.f59258r.A1()) {
                dq dqVarL1 = this.f59258r.l1();
                if (dqVarL1 != null) {
                    iq iqVarE = dqVarL1.e();
                    if (iqVarE != null) {
                        Uri uriC = iqVarE.c();
                        if (uriC != null) {
                            string = uriC.toString();
                        } else {
                            string = "";
                        }
                        String strB = iqVarE.b();
                        if (!URLUtil.isValidUrl(string) && !StringUtils.isValidString(strB)) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f65233c.k(this.f65232b, "Companion ad does not have any resources attached. Skipping...");
                                return;
                            }
                            return;
                        }
                        if (iqVarE.d() == iq.a.STATIC) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f65233c.a(this.f65232b, "Caching static companion ad at " + string + "...");
                            }
                            Uri uriA = a(string, Collections.EMPTY_LIST, false);
                            if (uriA != null) {
                                iqVarE.a(uriA);
                                this.f59258r.b(true);
                                return;
                            } else {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f65233c.b(this.f65232b, "Failed to cache static companion ad");
                                    return;
                                }
                                return;
                            }
                        }
                        if (iqVarE.d() == iq.a.HTML) {
                            if (StringUtils.isValidString(string)) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f65233c.a(this.f65232b, YgVrd.pmdO + string + "...");
                                }
                                String strD = d(string, null, false);
                                if (StringUtils.isValidString(strD)) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f65233c.a(this.f65232b, "HTML fetched. Caching HTML now...");
                                    }
                                    iqVarE.a(a(strD, Collections.EMPTY_LIST, this.f59258r));
                                    this.f59258r.b(true);
                                    return;
                                }
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f65233c.b(this.f65232b, "Unable to load companion ad resources from " + string);
                                    return;
                                }
                                return;
                            }
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f65233c.a(this.f65232b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
                            }
                            if (((Boolean) this.f65231a.a(sj.W4)).booleanValue()) {
                                strB = d(strB);
                            }
                            iqVarE.a(a(strB, Collections.EMPTY_LIST, this.f59258r));
                            this.f59258r.b(true);
                            return;
                        }
                        if (iqVarE.d() == iq.a.IFRAME && com.applovin.impl.sdk.n.a()) {
                            this.f65233c.a(this.f65232b, "Skip caching of iFrame resource...");
                            return;
                        }
                        return;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.b(this.f65232b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                        return;
                    }
                    return;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "No companion ad provided. Skipping...");
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Companion ad caching disabled. Skipping...");
            }
        }
    }
}
