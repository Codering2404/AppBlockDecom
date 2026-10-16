package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzagh extends zzael {
    private final String zza;
    private final /* synthetic */ zzagc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagh(zzagc zzagcVar, zzael zzaelVar, String str) {
        super(zzaelVar);
        Objects.requireNonNull(zzagcVar);
        this.zzb = zzagcVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael, com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status) {
        int i3 = 0;
        zzagc.zza.c("SMS verification code request failed: " + CommonStatusCodes.a(status.O()) + " " + status.g0(), new Object[0]);
        zzagj zzagjVar = (zzagj) this.zzb.zzd.get(this.zza);
        if (zzagjVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(zzagjVar.zzb);
        this.zzb.zzb(this.zza);
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((zzael) obj).zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael, com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb(String str) {
        zzagc.zza.a("onCodeSent", new Object[0]);
        zzagj zzagjVar = (zzagj) this.zzb.zzd.get(this.zza);
        if (zzagjVar == null) {
            return;
        }
        Iterator<zzael> it = zzagjVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zzb(str);
        }
        zzagjVar.zzg = true;
        zzagjVar.zzd = str;
        if (zzagjVar.zza <= 0) {
            this.zzb.zze(this.zza);
        } else if (!zzagjVar.zzc) {
            this.zzb.zzd(this.zza);
        } else {
            if (zzac.zzc(zzagjVar.zze)) {
                return;
            }
            zzagc.zzb(this.zzb, this.zza);
        }
    }
}
