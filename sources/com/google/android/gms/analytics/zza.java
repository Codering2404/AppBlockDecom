package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbg;
import com.google.android.gms.internal.gtm.zzbk;
import com.google.android.gms.internal.gtm.zzbx;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zza extends zzk {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbx f70887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f70888e;

    public zza(zzbx zzbxVar) {
        super(zzbxVar.zzd(), zzbxVar.zzr());
        this.f70887d = zzbxVar;
    }

    @Override // com.google.android.gms.analytics.zzk
    protected final void a(zzh zzhVar) {
        zzbg zzbgVar = (zzbg) zzhVar.b(zzbg.class);
        if (TextUtils.isEmpty(zzbgVar.zze())) {
            zzbgVar.zzj(this.f70887d.zzi().zzb());
        }
        if (this.f70888e && TextUtils.isEmpty(zzbgVar.zzd())) {
            zzbk zzbkVarZze = this.f70887d.zze();
            zzbgVar.zzi(zzbkVarZze.zza());
            zzbgVar.zzh(zzbkVarZze.zzb());
        }
    }

    public final zzh d() {
        zzh zzhVar = new zzh(this.f70909b);
        zzhVar.g(this.f70887d.zzh().zza());
        zzhVar.g(this.f70887d.zzk().zza());
        c(zzhVar);
        return zzhVar;
    }

    final zzbx e() {
        return this.f70887d;
    }

    public final void f(String str) {
        Preconditions.g(str);
        zzh zzhVar = this.f70909b;
        Uri uriB = zzb.b(str);
        ListIterator listIterator = zzhVar.f().listIterator();
        while (listIterator.hasNext()) {
            if (uriB.equals(((zzt) listIterator.next()).zzb())) {
                listIterator.remove();
            }
        }
        this.f70909b.f().add(new zzb(this.f70887d, str));
    }

    public final void g(boolean z2) {
        this.f70888e = z2;
    }
}
