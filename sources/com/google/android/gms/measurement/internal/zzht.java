package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzht extends zzos implements zzak {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f73851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map f73852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map f73853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map f73854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f73855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f73856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final LruCache f73857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final com.google.android.gms.internal.measurement.zzr f73858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f73859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map f73860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f73861n;

    zzht(zzpg zzpgVar) {
        super(zzpgVar);
        this.f73851d = new ArrayMap();
        this.f73852e = new ArrayMap();
        this.f73853f = new ArrayMap();
        this.f73854g = new ArrayMap();
        this.f73855h = new ArrayMap();
        this.f73859l = new ArrayMap();
        this.f73860m = new ArrayMap();
        this.f73861n = new ArrayMap();
        this.f73856i = new ArrayMap();
        this.f73857j = new zzhm(this, 20);
        this.f73858k = new zzhn(this);
    }

    private final void q(String str) throws Throwable {
        j();
        h();
        Preconditions.g(str);
        Map map = this.f73855h;
        if (map.get(str) == null) {
            zzaq zzaqVarN0 = this.f74388b.F0().N0(str);
            if (zzaqVarN0 != null) {
                com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) t(str, zzaqVarN0.f73416a).zzcl();
                r(str, zzgkVar);
                this.f73851d.put(str, u((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()));
                map.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
                s(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
                this.f73859l.put(str, zzgkVar.zzh());
                this.f73860m.put(str, zzaqVarN0.f73417b);
                this.f73861n.put(str, zzaqVarN0.f73418c);
                return;
            }
            this.f73851d.put(str, null);
            this.f73853f.put(str, null);
            this.f73852e.put(str, null);
            this.f73854g.put(str, null);
            map.put(str, null);
            this.f73859l.put(str, null);
            this.f73860m.put(str, null);
            this.f73861n.put(str, null);
            this.f73856i.put(str, null);
        }
    }

    private final void r(String str, com.google.android.gms.internal.measurement.zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzgkVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).zza());
        }
        for (int i3 = 0; i3 < zzgkVar.zza(); i3++) {
            com.google.android.gms.internal.measurement.zzgi zzgiVar = (com.google.android.gms.internal.measurement.zzgi) zzgkVar.zzb(i3).zzcl();
            if (zzgiVar.zza().isEmpty()) {
                this.f73997a.a().r().a("EventConfig contained null event name");
            } else {
                String strZza = zzgiVar.zza();
                String strB = zzjm.b(zzgiVar.zza());
                if (!TextUtils.isEmpty(strB)) {
                    zzgiVar.zzb(strB);
                    zzgkVar.zzc(i3, zzgiVar);
                }
                if (zzgiVar.zzc() && zzgiVar.zzd()) {
                    arrayMap.put(strZza, Boolean.TRUE);
                }
                if (zzgiVar.zze() && zzgiVar.zzf()) {
                    arrayMap2.put(zzgiVar.zza(), Boolean.TRUE);
                }
                if (zzgiVar.zzg()) {
                    if (zzgiVar.zzh() < 2 || zzgiVar.zzh() > 65535) {
                        this.f73997a.a().r().c("Invalid sampling rate. Event name, sample rate", zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    } else {
                        arrayMap3.put(zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    }
                }
            }
        }
        this.f73852e.put(str, hashSet);
        this.f73853f.put(str, arrayMap);
        this.f73854g.put(str, arrayMap2);
        this.f73856i.put(str, arrayMap3);
    }

    private final void s(final String str, com.google.android.gms.internal.measurement.zzgl zzglVar) {
        if (zzglVar.zzj() == 0) {
            this.f73857j.remove(str);
            return;
        }
        zzic zzicVar = this.f73997a;
        zzicVar.a().w().b("EES programs found", Integer.valueOf(zzglVar.zzj()));
        com.google.android.gms.internal.measurement.zzja zzjaVar = (com.google.android.gms.internal.measurement.zzja) zzglVar.zzi().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhs
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzho(this.f73849a, str));
                }
            });
            zzcVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    final zzht zzhtVar = this.f73844a;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhr
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            zzht zzhtVar2 = zzhtVar;
                            zzav zzavVarF0 = zzhtVar2.f74388b.F0();
                            String str3 = str2;
                            zzh zzhVarJ0 = zzavVarF0.J0(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            zzhtVar2.f73997a.w().A();
                            map.put("gmp_version", 133005L);
                            if (zzhVarJ0 != null) {
                                String strD0 = zzhVarJ0.D0();
                                if (strD0 != null) {
                                    map.put("app_version", strD0);
                                }
                                map.put("app_version_int", Long.valueOf(zzhVarJ0.F0()));
                                map.put("dynamite_version", Long.valueOf(zzhVarJ0.b()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzcVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzt(this.f73846a.f73858k);
                }
            });
            zzcVar.zzf(zzjaVar);
            this.f73857j.put(str, zzcVar);
            zzicVar.a().w().c("EES program loaded for appId, activities", str, Integer.valueOf(zzjaVar.zzb().zzb()));
            Iterator it = zzjaVar.zzb().zza().iterator();
            while (it.hasNext()) {
                zzicVar.a().w().b("EES program activity", ((com.google.android.gms.internal.measurement.zziy) it.next()).zza());
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.f73997a.a().o().b("Failed to load EES program. appId", str);
        }
    }

    private final com.google.android.gms.internal.measurement.zzgl t(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        }
        try {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) ((com.google.android.gms.internal.measurement.zzgk) zzpk.W(com.google.android.gms.internal.measurement.zzgl.zzr(), bArr)).zzbc();
            this.f73997a.a().w().c("Parsed config. version, gmp_app_id", zzglVar.zza() ? Long.valueOf(zzglVar.zzb()) : null, zzglVar.zzc() ? zzglVar.zzd() : null);
            return zzglVar;
        } catch (com.google.android.gms.internal.measurement.zzmr e3) {
            this.f73997a.a().r().c("Unable to merge remote config. appId", zzgu.x(str), e3);
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        } catch (RuntimeException e4) {
            this.f73997a.a().r().c("Unable to merge remote config. appId", zzgu.x(str), e4);
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        }
    }

    private static final Map u(com.google.android.gms.internal.measurement.zzgl zzglVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzglVar != null) {
            for (com.google.android.gms.internal.measurement.zzgt zzgtVar : zzglVar.zze()) {
                arrayMap.put(zzgtVar.zza(), zzgtVar.zzb());
            }
        }
        return arrayMap;
    }

    private static final zzjk v(int i3) {
        int i4 = i3 - 1;
        if (i4 == 1) {
            return zzjk.AD_STORAGE;
        }
        if (i4 == 2) {
            return zzjk.ANALYTICS_STORAGE;
        }
        if (i4 == 3) {
            return zzjk.AD_USER_DATA;
        }
        if (i4 != 4) {
            return null;
        }
        return zzjk.AD_PERSONALIZATION;
    }

    protected final void A(String str) {
        h();
        this.f73860m.put(str, null);
    }

    final void B(String str) {
        h();
        this.f73855h.remove(str);
    }

    protected final boolean C(String str, byte[] bArr, String str2, String str3) throws Throwable {
        j();
        h();
        Preconditions.g(str);
        com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) t(str, bArr).zzcl();
        r(str, zzgkVar);
        s(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        this.f73855h.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        this.f73859l.put(str, zzgkVar.zzh());
        this.f73860m.put(str, str2);
        this.f73861n.put(str, str3);
        this.f73851d.put(str, u((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()));
        this.f74388b.F0().Y(str, new ArrayList(zzgkVar.zzd()));
        try {
            zzgkVar.zze();
            bArr = ((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()).zzcc();
        } catch (RuntimeException e3) {
            this.f73997a.a().r().c("Unable to serialize reduced-size config. Storing full config instead. appId", zzgu.x(str), e3);
        }
        zzav zzavVarF0 = this.f74388b.F0();
        Preconditions.g(str);
        zzavVarF0.h();
        zzavVarF0.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzavVarF0.u0().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzavVarF0.f73997a.a().o().b("Failed to update remote config (got 0). appId", zzgu.x(str));
            }
        } catch (SQLiteException e4) {
            zzavVarF0.f73997a.a().o().c("Error storing remote config. appId", zzgu.x(str), e4);
        }
        zzgkVar.zzf();
        this.f73855h.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        return true;
    }

    final boolean D(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        q(str);
        if (H(str) && zzpp.N(str2)) {
            return true;
        }
        if (I(str) && zzpp.r0(str2)) {
            return true;
        }
        Map map = (Map) this.f73853f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        q(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f73854g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final Set F(String str) {
        h();
        q(str);
        return (Set) this.f73852e.get(str);
    }

    final int G(String str, String str2) throws Throwable {
        Integer num;
        h();
        q(str);
        Map map = (Map) this.f73856i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    final boolean H(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(f(str, "measurement.upload.blacklist_internal"));
    }

    final boolean I(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(f(str, "measurement.upload.blacklist_public"));
    }

    final boolean J(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean K(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean L(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        return map.get(str) != null && ((Set) map.get(str)).contains("user_id");
    }

    final boolean M(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        return map.get(str) != null && ((Set) map.get(str)).contains("google_signals");
    }

    final boolean N(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        return map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id");
    }

    final boolean O(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f73852e;
        return map.get(str) != null && ((Set) map.get(str)).contains("enhanced_user_id");
    }

    final boolean P(String str, zzjk zzjkVar) throws Throwable {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return false;
        }
        Iterator it = zzgfVarR.zza().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.zzfu zzfuVar = (com.google.android.gms.internal.measurement.zzfu) it.next();
            if (zzjkVar == v(zzfuVar.zzb())) {
                if (zzfuVar.zzc() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    final zzjk Q(String str, zzjk zzjkVar) {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return null;
        }
        for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzgfVarR.zzb()) {
            if (zzjkVar == v(zzfwVar.zzb())) {
                return v(zzfwVar.zzc());
            }
        }
        return null;
    }

    final com.google.android.gms.internal.measurement.zzgf R(String str) {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgl zzglVarW = w(str);
        if (zzglVarW == null || !zzglVarW.zzn()) {
            return null;
        }
        return zzglVarW.zzo();
    }

    final boolean S(String str) {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        return zzgfVarR == null || !zzgfVarR.zzd() || zzgfVarR.zze();
    }

    final SortedSet T(String str) {
        h();
        q(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        if (zzgfVarR != null) {
            Iterator it = zzgfVarR.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.zzgc) it.next()).zza());
            }
        }
        return treeSet;
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String f(String str, String str2) throws Throwable {
        h();
        q(str);
        Map map = (Map) this.f73851d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    final zzji m(String str, zzjk zzjkVar) {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return zzji.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarR.zzf()) {
            if (v(zzfuVar.zzb()) == zzjkVar) {
                int iZzc = zzfuVar.zzc() - 1;
                return iZzc != 1 ? iZzc != 2 ? zzji.UNINITIALIZED : zzji.DENIED : zzji.GRANTED;
            }
        }
        return zzji.UNINITIALIZED;
    }

    final boolean n(String str) throws Throwable {
        h();
        q(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarR.zza()) {
            if (zzfuVar.zzb() == 3 && zzfuVar.zzd() == 3) {
                return true;
            }
        }
        return false;
    }

    final /* synthetic */ com.google.android.gms.internal.measurement.zzc o(String str) throws Throwable {
        j();
        Preconditions.g(str);
        zzaq zzaqVarN0 = this.f74388b.F0().N0(str);
        if (zzaqVarN0 == null) {
            return null;
        }
        this.f73997a.a().w().b("Populate EES config from database on cache miss. appId", str);
        s(str, t(str, zzaqVarN0.f73416a));
        return (com.google.android.gms.internal.measurement.zzc) this.f73857j.snapshot().get(str);
    }

    final /* synthetic */ Map p() {
        return this.f73851d;
    }

    protected final com.google.android.gms.internal.measurement.zzgl w(String str) {
        j();
        h();
        Preconditions.g(str);
        q(str);
        return (com.google.android.gms.internal.measurement.zzgl) this.f73855h.get(str);
    }

    final String x(String str) {
        h();
        q(str);
        return (String) this.f73859l.get(str);
    }

    protected final String y(String str) {
        h();
        return (String) this.f73860m.get(str);
    }

    protected final String z(String str) {
        h();
        return (String) this.f73861n.get(str);
    }
}
