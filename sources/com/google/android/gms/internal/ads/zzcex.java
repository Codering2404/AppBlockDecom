package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcex {
    private final Clock zza;
    private final zzcfi zzb;
    private final String zze;
    private final String zzf;
    private final Object zzd = new Object();
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = 0;
    private long zzj = -1;
    private long zzk = -1;
    private final LinkedList zzc = new LinkedList();

    zzcex(Clock clock, zzcfi zzcfiVar, String str, String str2) {
        this.zza = clock;
        this.zzb = zzcfiVar;
        this.zze = str;
        this.zzf = str2;
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        synchronized (this.zzd) {
            long jA = this.zza.a();
            this.zzj = jA;
            this.zzb.zzf(zzmVar, jA);
        }
    }

    public final void zzb() {
        synchronized (this.zzd) {
            this.zzb.zzg();
        }
    }

    public final void zzc() {
        synchronized (this.zzd) {
            this.zzb.zzh();
        }
    }

    public final void zzd(long j3) {
        synchronized (this.zzd) {
            try {
                this.zzk = j3;
                if (j3 != -1) {
                    this.zzb.zzb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1 && this.zzg == -1) {
                    this.zzg = this.zza.a();
                    this.zzb.zzb(this);
                }
                this.zzb.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1) {
                    zzcew zzcewVar = new zzcew(this);
                    zzcewVar.zzc();
                    this.zzc.add(zzcewVar);
                    this.zzi++;
                    zzcfi zzcfiVar = this.zzb;
                    zzcfiVar.zzd();
                    zzcfiVar.zzb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1) {
                    LinkedList linkedList = this.zzc;
                    if (!linkedList.isEmpty()) {
                        zzcew zzcewVar = (zzcew) linkedList.getLast();
                        if (zzcewVar.zza() == -1) {
                            zzcewVar.zzb();
                            this.zzb.zzb(this);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzh(boolean z2) {
        synchronized (this.zzd) {
            try {
                if (this.zzk != -1) {
                    this.zzh = this.zza.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bundle zzi() {
        Bundle bundle;
        synchronized (this.zzd) {
            try {
                bundle = new Bundle();
                bundle.putString("seq_num", this.zze);
                bundle.putString("slotid", this.zzf);
                bundle.putBoolean("ismediation", false);
                bundle.putLong("treq", this.zzj);
                bundle.putLong("tresponse", this.zzk);
                bundle.putLong("timp", this.zzg);
                bundle.putLong("tload", this.zzh);
                bundle.putLong("pcc", this.zzi);
                bundle.putLong("tfetch", -1L);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzcew) it.next()).zzd());
                }
                bundle.putParcelableArrayList("tclick", arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bundle;
    }

    public final String zzj() {
        return this.zze;
    }

    final /* synthetic */ Clock zzk() {
        return this.zza;
    }
}
