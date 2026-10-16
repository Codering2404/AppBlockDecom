package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzck {
    private final zzgwm zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzck(zzgwm zzgwmVar) {
        this.zza = zzgwmVar;
        zzcl zzclVar = zzcl.zza;
        this.zzd = false;
    }

    private final void zzi(ByteBuffer byteBuffer) {
        boolean z2;
        do {
            int i3 = 0;
            z2 = false;
            while (i3 <= zzj()) {
                if (!this.zzc[i3].hasRemaining()) {
                    List list = this.zzb;
                    zzco zzcoVar = (zzco) list.get(i3);
                    if (!zzcoVar.zzg()) {
                        ByteBuffer byteBuffer2 = i3 > 0 ? this.zzc[i3 - 1] : byteBuffer.hasRemaining() ? byteBuffer : zzco.zza;
                        long jRemaining = byteBuffer2.remaining();
                        zzcoVar.zzd(byteBuffer2);
                        this.zzc[i3] = zzcoVar.zzf();
                        boolean z3 = true;
                        if (jRemaining - ((long) byteBuffer2.remaining()) <= 0 && !this.zzc[i3].hasRemaining()) {
                            z3 = false;
                        }
                        z2 |= z3;
                    } else if (!this.zzc[i3].hasRemaining() && i3 < zzj()) {
                        ((zzco) list.get(i3 + 1)).zze();
                    }
                }
                i3++;
            }
        } while (z2);
    }

    private final int zzj() {
        return this.zzc.length - 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        zzgwm zzgwmVar = this.zza;
        int size = zzgwmVar.size();
        zzgwm zzgwmVar2 = ((zzck) obj).zza;
        if (size != zzgwmVar2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < zzgwmVar.size(); i3++) {
            if (zzgwmVar.get(i3) != zzgwmVar2.get(i3)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcl zza(zzcl zzclVar) throws zzcn {
        if (zzclVar.equals(zzcl.zza)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int i3 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                return zzclVar;
            }
            zzco zzcoVar = (zzco) zzgwmVar.get(i3);
            zzcl zzclVarZzb = zzcoVar.zzb(zzclVar);
            if (zzcoVar.zzc()) {
                zzgtj.zzi(!zzclVarZzb.equals(r0));
                zzclVar = zzclVarZzb;
            }
            i3++;
        }
    }

    public final void zzb(zzcm zzcmVar) {
        List list = this.zzb;
        list.clear();
        this.zzd = false;
        long jZza = zzcmVar.zzb;
        int i3 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                break;
            }
            zzco zzcoVar = (zzco) zzgwmVar.get(i3);
            zzcoVar.zzi(new zzcm(jZza));
            if (zzcoVar.zzc()) {
                jZza = zzcoVar.zza(jZza);
                zzgtj.zzi(jZza >= 0);
                list.add(zzcoVar);
            }
            i3++;
        }
        this.zzc = new ByteBuffer[list.size()];
        for (int i4 = 0; i4 <= zzj(); i4++) {
            this.zzc[i4] = ((zzco) list.get(i4)).zzf();
        }
    }

    public final boolean zzc() {
        return !this.zzb.isEmpty();
    }

    public final void zzd(ByteBuffer byteBuffer) {
        if (!zzc() || this.zzd) {
            return;
        }
        zzi(byteBuffer);
    }

    public final ByteBuffer zze() {
        if (!zzc()) {
            return zzco.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzj()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzi(zzco.zza);
        return this.zzc[zzj()];
    }

    public final void zzf() {
        if (!zzc() || this.zzd) {
            return;
        }
        this.zzd = true;
        ((zzco) this.zzb.get(0)).zze();
    }

    public final boolean zzg() {
        return this.zzd && ((zzco) this.zzb.get(zzj())).zzg() && !this.zzc[zzj()].hasRemaining();
    }

    public final void zzh() {
        int i3 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                this.zzb.clear();
                this.zzc = new ByteBuffer[0];
                zzcl zzclVar = zzcl.zza;
                this.zzd = false;
                return;
            }
            zzco zzcoVar = (zzco) zzgwmVar.get(i3);
            zzcoVar.zzi(zzcm.zza);
            zzcoVar.zzj();
            i3++;
        }
    }
}
