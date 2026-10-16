package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeu {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f69912m = new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static zzeu f69913n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzem f69914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzey f69915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzel f69916c;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzcy f69923j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f69917d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f69918e = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f69920g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f69921h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f69922i = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private OnAdInspectorClosedListener f69924k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RequestConfiguration f69925l = new RequestConfiguration.Builder().a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList f69919f = new ArrayList();

    private zzeu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus b(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbrp zzbrpVar = (zzbrp) it.next();
            map.put(zzbrpVar.zza, new zzbrx(zzbrpVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbrpVar.zzd, zzbrpVar.zzc));
        }
        return new zzbry(map);
    }

    private final void c(RequestConfiguration requestConfiguration) {
        zzcy zzcyVar = this.f69923j;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zzr(new zzfr(requestConfiguration));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to set request configuration parcel.", e3);
        }
    }

    private final void d(Context context) {
        if (this.f69923j == null) {
            this.f69923j = (zzcy) new zzat(zzay.b(), context).d(context, false);
        }
    }

    private final void e(String str) {
        zzcy zzcyVar = this.f69923j;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zze();
            this.f69923j.zzj(null, ObjectWrapper.i5(null));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("MobileAdsSettingManager initialization failed", e3);
        }
    }

    public static zzeu f() {
        zzeu zzeuVar;
        synchronized (zzeu.class) {
            try {
                if (f69913n == null) {
                    f69913n = new zzeu();
                }
                zzeuVar = f69913n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeuVar;
    }

    final /* synthetic */ OnAdInspectorClosedListener a() {
        return this.f69924k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, RemoteException -> 0x0051, blocks: (B:26:0x0034, B:28:0x003b, B:33:0x0053, B:35:0x005c, B:40:0x006f, B:42:0x0080, B:44:0x0092, B:51:0x00d5, B:52:0x00ea, B:45:0x00a2, B:47:0x00b0, B:49:0x00c2, B:50:0x00cd, B:37:0x0064, B:39:0x006a), top: B:60:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, RemoteException -> 0x0051, blocks: (B:26:0x0034, B:28:0x003b, B:33:0x0053, B:35:0x005c, B:40:0x006f, B:42:0x0080, B:44:0x0092, B:51:0x00d5, B:52:0x00ea, B:45:0x00a2, B:47:0x00b0, B:49:0x00c2, B:50:0x00cd, B:37:0x0064, B:39:0x006a), top: B:60:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(android.content.Context r3, java.lang.String r4, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r5) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzeu.g(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028 A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0031 A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f69917d
            monitor-enter(r0)
            r1 = 0
            r3.f69921h = r1     // Catch: java.lang.Throwable -> L43
            r3.f69920g = r1     // Catch: java.lang.Throwable -> L43
            java.util.ArrayList r1 = r3.f69919f     // Catch: java.lang.Throwable -> L43
            r1.clear()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r1 = r3.f69922i
            monitor-enter(r1)
            com.google.android.gms.ads.internal.client.zzcy r0 = r3.f69923j     // Catch: java.lang.Throwable -> L19 android.os.RemoteException -> L1b
            if (r0 == 0) goto L21
            r0.zzw()     // Catch: java.lang.Throwable -> L19 android.os.RemoteException -> L1b
            goto L21
        L19:
            r0 = move-exception
            goto L41
        L1b:
            r0 = move-exception
            java.lang.String r2 = "Unable to stop the SDK."
            com.google.android.gms.ads.internal.util.client.zzo.d(r2, r0)     // Catch: java.lang.Throwable -> L19
        L21:
            r0 = 0
            r3.f69923j = r0     // Catch: java.lang.Throwable -> L19
            com.google.android.gms.ads.internal.client.zzem r2 = r3.f69914a     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L2d
            r2.a()     // Catch: java.lang.Throwable -> L19
            r3.f69914a = r0     // Catch: java.lang.Throwable -> L19
        L2d:
            com.google.android.gms.ads.internal.client.zzey r2 = r3.f69915b     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L36
            r2.a()     // Catch: java.lang.Throwable -> L19
            r3.f69915b = r0     // Catch: java.lang.Throwable -> L19
        L36:
            com.google.android.gms.ads.internal.client.zzel r2 = r3.f69916c     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L3f
            r2.a()     // Catch: java.lang.Throwable -> L19
            r3.f69916c = r0     // Catch: java.lang.Throwable -> L19
        L3f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L19
            return
        L41:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L19
            throw r0
        L43:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzeu.h():void");
    }

    public final float i() {
        synchronized (this.f69922i) {
            zzcy zzcyVar = this.f69923j;
            float fZzk = 1.0f;
            if (zzcyVar == null) {
                return 1.0f;
            }
            try {
                fZzk = zzcyVar.zzk();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to get app volume.", e3);
            }
            return fZzk;
        }
    }

    public final void j(boolean z2) {
        synchronized (this.f69922i) {
            Preconditions.r(this.f69923j != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            zzcy zzcyVar = this.f69923j;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzh(z2);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to set app mute state.", e3);
            }
        }
    }

    public final boolean k() {
        synchronized (this.f69922i) {
            zzcy zzcyVar = this.f69923j;
            boolean zZzl = false;
            if (zzcyVar == null) {
                return false;
            }
            try {
                zZzl = zzcyVar.zzl();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to get app mute state.", e3);
            }
            return zZzl;
        }
    }

    public final InitializationStatus l() {
        synchronized (this.f69922i) {
            Preconditions.r(this.f69923j != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            zzcy zzcyVar = this.f69923j;
            if (zzcyVar == null) {
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                };
            }
            try {
                return b(zzcyVar.zzq());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.c("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                };
            }
        }
    }

    public final void m(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.f69922i) {
            try {
                d(context);
                zzcy zzcyVar = this.f69923j;
                if (zzcyVar == null) {
                    return;
                }
                this.f69924k = onAdInspectorClosedListener;
                try {
                    zzcyVar.zzt(new zzes(null));
                } catch (RemoteException unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.c("Unable to open the ad inspector.");
                    if (onAdInspectorClosedListener != null) {
                        onAdInspectorClosedListener.a(new AdInspectorError(0, "Ad inspector had an internal error.", "com.google.android.gms.ads"));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final RequestConfiguration n() {
        return this.f69925l;
    }

    public final void o(RequestConfiguration requestConfiguration) {
        Preconditions.b(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.f69922i) {
            try {
                RequestConfiguration requestConfiguration2 = this.f69925l;
                this.f69925l = requestConfiguration;
                if (this.f69923j == null) {
                    return;
                }
                if (requestConfiguration2.c() != requestConfiguration.c() || requestConfiguration2.d() != requestConfiguration.d()) {
                    c(requestConfiguration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(String str) {
        synchronized (this.f69922i) {
            Preconditions.r(this.f69923j != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            zzcy zzcyVar = this.f69923j;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzv(str);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to set plugin.", e3);
            }
        }
    }

    final /* synthetic */ void q(String str) {
        synchronized (this.f69922i) {
            e(null);
        }
    }

    final /* synthetic */ void r(String str) {
        synchronized (this.f69922i) {
            e(null);
        }
    }

    final /* synthetic */ Object t() {
        return this.f69917d;
    }

    final /* synthetic */ ArrayList u() {
        return this.f69919f;
    }

    final /* synthetic */ void v(boolean z2) {
        this.f69920g = false;
    }

    final /* synthetic */ void w(boolean z2) {
        this.f69921h = true;
    }
}
