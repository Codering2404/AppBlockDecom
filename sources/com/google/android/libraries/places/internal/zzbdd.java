package com.google.android.libraries.places.internal;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdd extends zzbdc {
    zzbdd() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdc
    final zzbdg a(Object obj) {
        zzbdn zzbdnVar = (zzbdn) obj;
        zzbdg zzbdgVar = zzbdnVar.zzb;
        if (zzbdgVar.f76046b) {
            zzbdnVar.zzb = zzbdgVar.clone();
        }
        return zzbdnVar.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbdc
    final void b(Object obj) {
        ((zzbdn) obj).zzb.b();
    }

    @Override // com.google.android.libraries.places.internal.zzbdc
    final void c(zzbgl zzbglVar, Map.Entry entry) {
        zzbdo zzbdoVar = (zzbdo) entry.getKey();
        zzbgj zzbgjVar = zzbgj.f76186b;
        switch (zzbdoVar.f76084b.ordinal()) {
            case 0:
                zzbglVar.zzf(525004180, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                zzbglVar.zze(525004180, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                zzbglVar.zzc(525004180, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                zzbglVar.zzh(525004180, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzbglVar.zzi(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                zzbglVar.zzj(525004180, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                zzbglVar.zzk(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                zzbglVar.zzl(525004180, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                zzbglVar.zzm(525004180, (String) entry.getValue());
                break;
            case 9:
                zzbglVar.c(525004180, entry.getValue(), zzbfh.a().b(entry.getValue().getClass()));
                break;
            case 10:
                zzbglVar.b(525004180, entry.getValue(), zzbfh.a().b(entry.getValue().getClass()));
                break;
            case 11:
                zzbglVar.a(525004180, (zzbcl) entry.getValue());
                break;
            case 12:
                zzbglVar.zzo(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzbglVar.zzi(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                zzbglVar.zzb(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzbglVar.zzd(525004180, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                zzbglVar.zzp(525004180, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                zzbglVar.zzq(525004180, ((Long) entry.getValue()).longValue());
                break;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbdc
    final void d(zzbfk zzbfkVar, Object obj, zzbdb zzbdbVar, zzbdg zzbdgVar) {
        zzbdp zzbdpVar = (zzbdp) obj;
        zzbdgVar.f(zzbdpVar.f76086b, zzbfkVar.a(zzbdpVar.f76085a.getClass(), zzbdbVar));
    }
}
