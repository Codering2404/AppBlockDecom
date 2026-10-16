package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.d4;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class dn extends yl implements d4.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f59268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d4.e f59269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private tm.b f59270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private sj f59271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private sj f59272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected d4.b f59273m;

    public dn(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        this(aVar, jVar, false);
    }

    @Override // com.applovin.impl.d4.e
    public abstract void a(String str, int i3, String str2, Object obj);

    @Override // com.applovin.impl.d4.e
    public abstract void a(String str, Object obj, int i3);

    @Override // java.lang.Runnable
    public void run() {
        d4 d4VarT = b().t();
        if (!b().v0() && !b().s0()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "AppLovin SDK is disabled");
            a(this.f59268h.f(), -22, null, null);
        } else if (!StringUtils.isValidString(this.f59268h.f()) || this.f59268h.f().length() < 4) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Task has an invalid or null request endpoint.");
            }
            a(this.f59268h.f(), AppLovinErrorCodes.INVALID_URL, null, null);
        } else {
            if (TextUtils.isEmpty(this.f59268h.h())) {
                this.f59268h.b(this.f59268h.b() != null ? "POST" : "GET");
            }
            d4VarT.a(this.f59268h, this.f59273m, this.f59269i);
        }
    }

    public dn(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z2) {
        super("TaskRepeatRequest", jVar, z2);
        this.f59270j = tm.b.OTHER;
        this.f59271k = null;
        this.f59272l = null;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        a(aVar.f());
        this.f59268h = aVar;
        this.f59273m = new d4.b();
        this.f59269i = new a(jVar);
    }

    public void b(sj sjVar) {
        this.f59272l = sjVar;
    }

    public void c(sj sjVar) {
        this.f59271k = sjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sj sjVar) {
        if (sjVar != null) {
            b().g0().a(sjVar, sjVar.a());
        }
    }

    public void a(tm.b bVar) {
        this.f59270j = bVar;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements d4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f59274a;

        a(com.applovin.impl.sdk.j jVar) {
            this.f59274a = jVar;
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, Object obj) {
            boolean z2 = false;
            boolean z3 = i3 < 200 || i3 >= 500;
            boolean z4 = i3 == 429;
            boolean z5 = i3 != -1009 || dn.this.f59268h.q();
            boolean z6 = (i3 == -900 || i3 == -1000) ? false : true;
            if (!z5 || !z6 || (!z3 && !z4 && !dn.this.f59268h.p())) {
                dn dnVar = dn.this;
                dnVar.a(dnVar.f59268h.f(), i3, str2, obj);
                return;
            }
            String strA = dn.this.f59268h.a();
            if (dn.this.f59268h.j() <= 0) {
                if (strA == null || !strA.equals(dn.this.f59268h.f())) {
                    dn dnVar2 = dn.this;
                    dnVar2.a(dnVar2.f59271k);
                } else {
                    dn dnVar3 = dn.this;
                    dnVar3.a(dnVar3.f59272l);
                }
                dn dnVar4 = dn.this;
                dnVar4.a(dnVar4.f59268h.f(), i3, str2, obj);
                return;
            }
            com.applovin.impl.sdk.n nVar = dn.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                dn dnVar5 = dn.this;
                dnVar5.f65233c.k(dnVar5.f65232b, "Unable to send request due to server failure (code " + i3 + "). " + dn.this.f59268h.j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(dn.this.f59268h.k()) + " seconds...");
            }
            int iJ = dn.this.f59268h.j() - 1;
            dn.this.f59268h.a(iJ);
            if (iJ == 0) {
                dn dnVar6 = dn.this;
                dnVar6.a(dnVar6.f59271k);
                if (StringUtils.isValidString(strA) && strA.length() >= 4) {
                    com.applovin.impl.sdk.n nVar2 = dn.this.f65233c;
                    if (com.applovin.impl.sdk.n.a()) {
                        dn dnVar7 = dn.this;
                        dnVar7.f65233c.d(dnVar7.f65232b, "Switching to backup endpoint " + strA);
                    }
                    dn.this.f59268h.a(strA);
                    z2 = true;
                }
            }
            long millis = (((Boolean) this.f59274a.a(sj.i3)).booleanValue() && z2) ? 0L : dn.this.f59268h.n() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, dn.this.f59268h.c())) : dn.this.f59268h.k();
            tm tmVarI0 = this.f59274a.i0();
            dn dnVar8 = dn.this;
            tmVarI0.a(dnVar8, dnVar8.f59270j, millis);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, Object obj, int i3) {
            dn.this.f59268h.a(0);
            dn.this.a(str, obj, i3);
        }
    }
}
