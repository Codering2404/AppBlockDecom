package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzev;
import com.google.android.gms.internal.gtm.zzew;
import com.google.android.gms.internal.gtm.zzfc;
import com.google.android.gms.internal.gtm.zzfv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GoogleAnalytics extends zza {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static List f70866k = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f70867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f70868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f70869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f70870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f70871j;

    public GoogleAnalytics(zzbx zzbxVar) {
        super(zzbxVar);
        this.f70868g = new HashSet();
    }

    public static GoogleAnalytics j(Context context) {
        return zzbx.zzg(context).zzc();
    }

    public static void o() {
        synchronized (GoogleAnalytics.class) {
            try {
                List list = f70866k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    f70866k = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h() {
        e().zzf().zzc();
    }

    public boolean i() {
        return this.f70870i;
    }

    public boolean k() {
        return this.f70869h;
    }

    public Tracker l(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(e(), str, null);
            tracker.zzW();
        }
        return tracker;
    }

    public void m(boolean z2) {
        this.f70869h = z2;
    }

    public void n(Logger logger) {
        zzfc.zzc(logger);
        if (this.f70871j) {
            return;
        }
        zzev zzevVar = zzew.zzc;
        Log.i((String) zzevVar.zzb(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzevVar.zzb()) + " DEBUG");
        this.f70871j = true;
    }

    public final void p() {
        zzfv zzfvVarZzq = e().zzq();
        zzfvVarZzq.zzf();
        if (zzfvVarZzq.zze()) {
            m(zzfvVarZzq.zzc());
        }
        zzfvVarZzq.zzf();
        this.f70867f = true;
    }

    final void q(Activity activity) throws Throwable {
        Iterator it = this.f70868g.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).b(activity);
        }
    }

    final void r(Activity activity) {
        Iterator it = this.f70868g.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).c(activity);
        }
    }

    public final boolean s() {
        return this.f70867f;
    }
}
