package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchr implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzchq zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzchr(Context context, zzchq zzchqVar) {
        this.zza = (AudioManager) context.getSystemService("audio");
        this.zzb = zzchqVar;
    }

    private final void zzf() {
        if (!this.zzd || this.zze || this.zzf <= 0.0f) {
            if (this.zzc) {
                AudioManager audioManager = this.zza;
                if (audioManager != null) {
                    this.zzc = audioManager.abandonAudioFocus(this) == 0;
                }
                this.zzb.zzq();
                return;
            }
            return;
        }
        if (this.zzc) {
            return;
        }
        AudioManager audioManager2 = this.zza;
        if (audioManager2 != null) {
            this.zzc = audioManager2.requestAudioFocus(this, 3, 2) == 1;
        }
        this.zzb.zzq();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i3) {
        this.zzc = i3 > 0;
        this.zzb.zzq();
    }

    public final void zza(boolean z2) {
        this.zze = z2;
        zzf();
    }

    public final void zzb(float f3) {
        this.zzf = f3;
        zzf();
    }

    public final float zzc() {
        float f3 = this.zze ? 0.0f : this.zzf;
        if (this.zzc) {
            return f3;
        }
        return 0.0f;
    }

    public final void zzd() {
        this.zzd = true;
        zzf();
    }

    public final void zze() {
        this.zzd = false;
        zzf();
    }
}
