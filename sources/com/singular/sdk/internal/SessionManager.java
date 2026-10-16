package com.singular.sdk.internal;

import android.app.Application;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class SessionManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SingularLog f92661g = SingularLog.f("Session");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SingularInstance f92662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f92663b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f92664c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f92665d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f92666e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f92667f = true;

    SessionManager(SingularInstance singularInstance) {
        this.f92662a = singularInstance;
        l();
        u(Utils.y());
        g((Application) singularInstance.o());
        if (this.f92667f || !this.f92663b) {
            NetworkMonitor.l(singularInstance.o(), singularInstance.n());
        }
    }

    private void g(Application application) {
        if (this.f92663b) {
            return;
        }
        if (Utils.L() == null || !Utils.L().equalsIgnoreCase("mParticle")) {
            new SingularLifecycleCallbacks(this).a(application);
        }
    }

    private boolean j() {
        return this.f92664c > 0;
    }

    private boolean k(long j3) {
        return j3 - this.f92665d < this.f92662a.C().f92425j * 1000;
    }

    private void l() {
        SharedPreferences sharedPreferences = this.f92662a.o().getSharedPreferences("singular-pref-session", 0);
        this.f92664c = sharedPreferences.getLong("id", -1L);
        this.f92665d = sharedPreferences.getLong("lastSessionPauseTime", Utils.y());
        this.f92666e = sharedPreferences.getLong("seq", 0L);
        f92661g.b("load() <= %s", toString());
    }

    private void o() {
        try {
            SharedPreferences.Editor editorEdit = this.f92662a.o().getSharedPreferences("singular-pref-session", 0).edit();
            editorEdit.putLong("id", this.f92664c);
            editorEdit.putLong("lastSessionPauseTime", this.f92665d);
            editorEdit.putLong("seq", this.f92666e);
            editorEdit.commit();
        } catch (Throwable th) {
            f92661g.c(Utils.l(th));
        }
    }

    private void p() {
        this.f92666e = 0L;
    }

    private void q() {
        if (j()) {
            this.f92662a.Q(this.f92664c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j3) {
        this.f92665d = j3;
        o();
    }

    private void s(long j3) {
        this.f92664c = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(long j3) {
        if (this.f92662a == null) {
            f92661g.a("can't start new session - singular instance is null");
            return false;
        }
        if (SLPushNotificationsManager.e().h(this.f92662a.C().f92441z, this.f92662a.C().A).booleanValue()) {
            f92661g.a("app is opened with push link");
            SLPushNotificationsManager.e().b();
            t(j3);
            return true;
        }
        if (this.f92662a.C().f92428m != null) {
            f92661g.a("app is opened with deeplink.so starting new session");
            t(j3);
            return true;
        }
        DeviceIDManager.c().e(this.f92662a.o());
        if (DeviceIDManager.c().d(this.f92662a.o())) {
            f92661g.a("starting new session because current sdid is fresh");
            t(j3);
            return true;
        }
        if (j() && k(j3)) {
            f92661g.a("session is not expired yet");
            return false;
        }
        f92661g.a("session is expired. starting new session");
        t(j3);
        return true;
    }

    long h() {
        long j3 = this.f92666e + 1;
        this.f92666e = j3;
        return j3;
    }

    long i() {
        return this.f92664c;
    }

    void m(final long j3) {
        f92661g.b("onEnterForeground() At %d", Long.valueOf(j3));
        final Boolean boolValueOf = Boolean.valueOf((Utils.a0() || SLPushNotificationsManager.e().d().booleanValue()) ? false : true);
        this.f92662a.S(new Runnable() { // from class: com.singular.sdk.internal.SessionManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (boolValueOf.booleanValue()) {
                    SessionManager.this.u(j3);
                }
                SessionManager.this.f92667f = true;
                if (SessionManager.this.f92667f || !SessionManager.this.f92663b) {
                    NetworkMonitor.l(SessionManager.this.f92662a.o(), SessionManager.this.f92662a.n());
                }
            }
        });
    }

    void n(final long j3) {
        f92661g.b("onExitForeground() At %d", Long.valueOf(j3));
        SLPushNotificationsManager.e().a();
        this.f92662a.S(new Runnable() { // from class: com.singular.sdk.internal.SessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                SessionManager.this.r(j3);
                SessionManager.this.f92667f = false;
                BatchManager.r().w();
                NetworkMonitor.p(SessionManager.this.f92662a.o());
                Utils.d();
            }
        });
    }

    public void t(long j3) {
        f92661g.b("startNewSession() At %d", Long.valueOf(j3));
        s(j3);
        p();
        q();
    }

    public String toString() {
        return "{id=" + this.f92664c + ", lastSessionPauseTime=" + this.f92665d + ", seq=" + this.f92666e + '}';
    }

    void v() {
        this.f92663b = true;
    }
}
