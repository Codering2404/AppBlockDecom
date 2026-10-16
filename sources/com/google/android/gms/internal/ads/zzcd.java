package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcd {
    private final zzgub zza;
    private final Handler zzb;
    private zzcc zzc;
    private zzd zzd;
    private int zzf;
    private zzch zzh;
    private float zzg = 1.0f;
    private int zze = 0;

    public zzcd(final Context context, Looper looper, zzcc zzccVar) {
        this.zza = zzguf.zza(new zzgub() { // from class: com.google.android.gms.internal.ads.zzcb
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return zzcj.zza(context);
            }
        });
        this.zzc = zzccVar;
        this.zzb = new Handler(looper);
    }

    private final void zzf() {
        int i3 = this.zze;
        if (i3 == 1 || i3 == 0 || this.zzh == null) {
            return;
        }
        ((AudioManager) this.zza.zza()).abandonAudioFocusRequest(this.zzh.zzc());
    }

    private final void zzg(int i3) {
        if (this.zze == i3) {
            return;
        }
        this.zze = i3;
        float f3 = i3 == 4 ? 0.2f : 1.0f;
        if (this.zzg != f3) {
            this.zzg = f3;
            zzcc zzccVar = this.zzc;
            if (zzccVar != null) {
                zzccVar.zza(f3);
            }
        }
    }

    private final void zzh(int i3) {
        zzcc zzccVar = this.zzc;
        if (zzccVar != null) {
            zzccVar.zzb(i3);
        }
    }

    public final float zza() {
        return this.zzg;
    }

    public final void zzb(zzd zzdVar) {
        if (Objects.equals(this.zzd, zzdVar)) {
            return;
        }
        this.zzd = zzdVar;
        this.zzf = zzdVar == null ? 0 : 1;
    }

    public final int zzc(boolean z2, int i3) {
        if (i3 == 1 || this.zzf != 1) {
            zzf();
            zzg(0);
            return 1;
        }
        if (!z2) {
            int i4 = this.zze;
            if (i4 != 1) {
                return i4 != 3 ? 1 : 0;
            }
            return -1;
        }
        if (this.zze == 2) {
            return 1;
        }
        if (this.zzh == null) {
            zzce zzceVar = new zzce(1);
            zzd zzdVar = this.zzd;
            zzdVar.getClass();
            zzceVar.zzb(zzdVar);
            zzceVar.zzc(true);
            zzceVar.zza(new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzca
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final /* synthetic */ void onAudioFocusChange(int i5) {
                    this.zza.zze(i5);
                }
            }, this.zzb);
            this.zzh = zzceVar.zzd();
        }
        int iRequestAudioFocus = ((AudioManager) this.zza.zza()).requestAudioFocus(this.zzh.zzc());
        if (iRequestAudioFocus == 1 || iRequestAudioFocus == 2) {
            zzg(2);
            return 1;
        }
        zzg(1);
        return -1;
    }

    public final void zzd() {
        this.zzc = null;
        zzf();
        zzg(0);
    }

    final /* synthetic */ void zze(int i3) {
        if (i3 == -3 || i3 == -2) {
            if (i3 != -2) {
                zzg(4);
                return;
            } else {
                zzh(0);
                zzg(3);
                return;
            }
        }
        if (i3 == -1) {
            zzh(-1);
            zzf();
            zzg(1);
        } else if (i3 == 1) {
            zzg(2);
            zzh(1);
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 27);
            sb.append("Unknown focus change type: ");
            sb.append(i3);
            zzeg.zzc("AudioFocusManager", sb.toString());
        }
    }
}
