package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmb extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile zzlu f74210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile zzlu f74211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected zzlu f74212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f74213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.zzdf f74214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f74215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile zzlu f74216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzlu f74217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f74218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f74219l;

    public zzmb(zzic zzicVar) {
        super(zzicVar);
        this.f74219l = new Object();
        this.f74213f = new ConcurrentHashMap();
    }

    private final void F(String str, zzlu zzluVar, boolean z2) {
        zzlu zzluVar2;
        zzlu zzluVar3 = this.f74210c == null ? this.f74211d : this.f74210c;
        if (zzluVar.f74184b == null) {
            zzluVar2 = new zzlu(zzluVar.f74183a, str != null ? r(str, "Activity") : null, zzluVar.f74185c, zzluVar.f74187e, zzluVar.f74188f);
        } else {
            zzluVar2 = zzluVar;
        }
        this.f74211d = this.f74210c;
        this.f74210c = zzluVar2;
        zzic zzicVar = this.f73997a;
        zzicVar.b().t(new zzlw(this, zzluVar2, zzluVar3, zzicVar.e().a(), z2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G(com.google.android.gms.measurement.internal.zzlu r15, com.google.android.gms.measurement.internal.zzlu r16, long r17, boolean r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzmb.G(com.google.android.gms.measurement.internal.zzlu, com.google.android.gms.measurement.internal.zzlu, long, boolean, android.os.Bundle):void");
    }

    private final void o(zzlu zzluVar, boolean z2, long j3) {
        zzic zzicVar = this.f73997a;
        zzicVar.M().k(zzicVar.e().a());
        if (!zzicVar.z().f74370f.d(zzluVar != null && zzluVar.f74186d, z2, j3) || zzluVar == null) {
            return;
        }
        zzluVar.f74186d = false;
    }

    private final zzlu p(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Preconditions.m(zzdfVar);
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        Map map = this.f74213f;
        zzlu zzluVar = (zzlu) map.get(numValueOf);
        if (zzluVar == null) {
            zzlu zzluVar2 = new zzlu(null, r(zzdfVar.zzb, "Activity"), this.f73997a.C().p0());
            map.put(numValueOf, zzluVar2);
            zzluVar = zzluVar2;
        }
        return this.f74216i != null ? this.f74216i : zzluVar;
    }

    final /* synthetic */ void A(Bundle bundle, zzlu zzluVar, zzlu zzluVar2, long j3) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        G(zzluVar, zzluVar2, j3, true, this.f73997a.C().t(null, "screen_view", bundle, null, false));
    }

    final /* synthetic */ void B(zzlu zzluVar, zzlu zzluVar2, long j3, boolean z2, Bundle bundle) {
        G(zzluVar, zzluVar2, j3, z2, null);
    }

    final /* synthetic */ void C(zzlu zzluVar, boolean z2, long j3) {
        o(zzluVar, false, j3);
    }

    final /* synthetic */ zzlu D() {
        return this.f74217j;
    }

    final /* synthetic */ void E(zzlu zzluVar) {
        this.f74217j = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return false;
    }

    public final zzlu q(boolean z2) {
        j();
        h();
        if (!z2) {
            return this.f74212e;
        }
        zzlu zzluVar = this.f74212e;
        return zzluVar != null ? zzluVar : this.f74217j;
    }

    final String r(String str, String str2) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str3 = length > 0 ? strArrSplit[length - 1] : "";
        zzic zzicVar = this.f73997a;
        return str3.length() > zzicVar.w().x(null, false) ? str3.substring(0, zzicVar.w().x(null, false)) : str3;
    }

    public final void s(Bundle bundle, long j3) {
        synchronized (this.f74219l) {
            try {
                if (!this.f74218k) {
                    this.f73997a.a().t().a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > this.f73997a.w().x(null, false))) {
                    this.f73997a.a().t().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > this.f73997a.w().x(null, false))) {
                    this.f73997a.a().t().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    com.google.android.gms.internal.measurement.zzdf zzdfVar = this.f74214g;
                    string2 = zzdfVar != null ? r(zzdfVar.zzb, "Activity") : "Activity";
                }
                zzlu zzluVar = this.f74210c;
                if (this.f74215h && zzluVar != null) {
                    this.f74215h = false;
                    boolean zEquals = Objects.equals(zzluVar.f74184b, string2);
                    boolean zEquals2 = Objects.equals(zzluVar.f74183a, string);
                    if (zEquals && zEquals2) {
                        this.f73997a.a().t().a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzic zzicVar = this.f73997a;
                zzicVar.a().w().c("Logging screen view with name, class", string == null ? "null" : string, string2 == null ? "null" : string2);
                zzlu zzluVar2 = this.f74210c == null ? this.f74211d : this.f74210c;
                zzlu zzluVar3 = new zzlu(string, string2, zzicVar.C().p0(), true, j3);
                this.f74210c = zzluVar3;
                this.f74211d = zzluVar2;
                this.f74216i = zzluVar3;
                zzicVar.b().t(new zzlv(this, bundle, zzluVar3, zzluVar2, zzicVar.e().a()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(com.google.android.gms.internal.measurement.zzdf zzdfVar, String str, String str2) {
        zzic zzicVar = this.f73997a;
        if (!zzicVar.w().N()) {
            zzicVar.a().t().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlu zzluVar = this.f74210c;
        if (zzluVar == null) {
            zzicVar.a().t().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.f74213f;
        Integer numValueOf = Integer.valueOf(zzdfVar.zza);
        if (map.get(numValueOf) == null) {
            zzicVar.a().t().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = r(zzdfVar.zzb, "Activity");
        }
        String str3 = zzluVar.f74184b;
        String str4 = zzluVar.f74183a;
        boolean zEquals = Objects.equals(str3, str2);
        boolean zEquals2 = Objects.equals(str4, str);
        if (zEquals && zEquals2) {
            zzicVar.a().t().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zzicVar.w().x(null, false))) {
            zzicVar.a().t().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zzicVar.w().x(null, false))) {
            zzicVar.a().t().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzicVar.a().w().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzlu zzluVar2 = new zzlu(str, str2, zzicVar.C().p0());
        map.put(numValueOf, zzluVar2);
        F(zzdfVar.zzb, zzluVar2, true);
    }

    public final zzlu u() {
        return this.f74210c;
    }

    public final void v(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.f73997a.w().N() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f74213f.put(Integer.valueOf(zzdfVar.zza), new zzlu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void w(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Object obj = this.f74219l;
        synchronized (obj) {
            this.f74218k = true;
            if (!Objects.equals(zzdfVar, this.f74214g)) {
                synchronized (obj) {
                    this.f74214g = zzdfVar;
                    this.f74215h = false;
                    zzic zzicVar = this.f73997a;
                    if (zzicVar.w().N()) {
                        this.f74216i = null;
                        zzicVar.b().t(new zzma(this));
                    }
                }
            }
        }
        zzic zzicVar2 = this.f73997a;
        if (!zzicVar2.w().N()) {
            this.f74210c = this.f74216i;
            zzicVar2.b().t(new zzlx(this));
            return;
        }
        F(zzdfVar.zzb, p(zzdfVar), false);
        zzd zzdVarM = this.f73997a.M();
        zzic zzicVar3 = zzdVarM.f73997a;
        zzicVar3.b().t(new zzc(zzdVarM, zzicVar3.e().a()));
    }

    public final void x(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.f74219l) {
            this.f74218k = false;
            this.f74215h = true;
        }
        zzic zzicVar = this.f73997a;
        long jA = zzicVar.e().a();
        if (!zzicVar.w().N()) {
            this.f74210c = null;
            zzicVar.b().t(new zzly(this, jA));
        } else {
            zzlu zzluVarP = p(zzdfVar);
            this.f74211d = this.f74210c;
            this.f74210c = null;
            zzicVar.b().t(new zzlz(this, zzluVarP, jA));
        }
    }

    public final void y(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        zzlu zzluVar;
        if (!this.f73997a.w().N() || bundle == null || (zzluVar = (zzlu) this.f74213f.get(Integer.valueOf(zzdfVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzluVar.f74185c);
        bundle2.putString("name", zzluVar.f74183a);
        bundle2.putString("referrer_name", zzluVar.f74184b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void z(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        synchronized (this.f74219l) {
            try {
                if (Objects.equals(this.f74214g, zzdfVar)) {
                    this.f74214g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f73997a.w().N()) {
            this.f74213f.remove(Integer.valueOf(zzdfVar.zza));
        }
    }
}
