package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Choreographer;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeb {
    private final Context zzb;
    private zzadx zzc;
    private boolean zzd;
    private Surface zze;
    private float zzg;
    private float zzh;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private final zzacx zza = new zzacx();
    private float zzf = -1.0f;
    private float zzi = 1.0f;
    private int zzj = 0;

    public zzaeb(Context context) {
        this.zzb = context;
    }

    private final void zzj() {
        this.zzm = 0L;
        this.zzq = -1L;
        this.zzn = -1L;
        this.zzk = 0L;
        this.zzl = 0L;
    }

    private final void zzk() {
        if (Build.VERSION.SDK_INT < 30 || this.zze == null) {
            return;
        }
        zzacx zzacxVar = this.zza;
        float fZzg = zzacxVar.zzc() ? zzacxVar.zzg() : this.zzf;
        float f3 = this.zzg;
        if (fZzg != f3) {
            if (fZzg != -1.0f && f3 != -1.0f) {
                float f4 = 1.0f;
                if (zzacxVar.zzc() && zzacxVar.zze() >= 5000000000L) {
                    f4 = 0.1f;
                }
                if (Math.abs(fZzg - this.zzg) < f4) {
                    return;
                }
            } else if (fZzg == -1.0f && zzacxVar.zzd() < 30) {
                return;
            }
            this.zzg = fZzg;
            zzl(false);
        }
    }

    private final void zzl(boolean z2) {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || !surface.isValid()) {
            return;
        }
        float f3 = 0.0f;
        if (this.zzd) {
            float f4 = this.zzg;
            if (f4 != -1.0f) {
                f3 = this.zzi * f4;
            }
        }
        if (z2 || this.zzh != f3) {
            this.zzh = f3;
            zzadw.zza(this.zze, f3);
        }
    }

    private final void zzm() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f || !surface.isValid()) {
            return;
        }
        this.zzh = 0.0f;
        zzadw.zza(this.zze, 0.0f);
    }

    public final void zza(int i3) {
        if (this.zzj == i3) {
            return;
        }
        this.zzj = i3;
        zzl(true);
    }

    public final void zzb() {
        this.zzd = true;
        zzj();
        DisplayManager displayManager = (DisplayManager) this.zzb.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        zzadx zzaeaVar = null;
        if (displayManager != null) {
            try {
                Choreographer choreographer = Choreographer.getInstance();
                zzaeaVar = Build.VERSION.SDK_INT >= 33 ? new zzaea(choreographer, displayManager, null) : new zzady(choreographer, displayManager, null);
            } catch (RuntimeException e3) {
                zzeg.zzd("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e3);
            }
        }
        this.zzc = zzaeaVar;
        if (zzaeaVar != null) {
            zzaeaVar.zza();
        }
        zzl(false);
    }

    public final void zzc(Surface surface) {
        if (this.zze == surface) {
            return;
        }
        zzm();
        this.zze = surface;
        zzl(true);
    }

    public final void zzd() {
        zzj();
    }

    public final void zze(float f3) {
        this.zzi = f3;
        zzl(false);
    }

    public final void zzf(float f3) {
        this.zzf = f3;
        this.zza.zza();
        zzk();
    }

    public final void zzg(long j3) {
        long j4 = this.zzn;
        if (j4 != -1) {
            this.zzq = j4;
            this.zzr = this.zzo;
            this.zzs = this.zzp;
            this.zzk = this.zzl;
        }
        this.zzm++;
        this.zza.zzb(j3 * 1000);
        zzk();
    }

    public final void zzh() {
        this.zzd = false;
        zzadx zzadxVar = this.zzc;
        if (zzadxVar != null) {
            zzadxVar.zzb();
        }
        zzm();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzi(long r19, long r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            long r3 = r0.zzq
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L41
            com.google.android.gms.internal.ads.zzacx r3 = r0.zza
            boolean r4 = r3.zzc()
            if (r4 == 0) goto L24
            long r3 = r3.zzf()
            long r5 = r0.zzm
            long r7 = r0.zzq
            long r5 = r5 - r7
            long r3 = r3 * r5
            float r5 = r0.zzi
        L20:
            float r3 = (float) r3
            float r3 = r3 / r5
            long r3 = (long) r3
            goto L2e
        L24:
            long r3 = r0.zzs
            long r3 = r1 - r3
            float r5 = r0.zzi
            r6 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r6
            goto L20
        L2e:
            long r5 = r0.zzr
            long r5 = r5 + r3
            long r3 = r19 - r5
            long r3 = java.lang.Math.abs(r3)
            r7 = 20000000(0x1312d00, double:9.881313E-317)
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L43
            r0.zzj()
        L41:
            r5 = r19
        L43:
            long r3 = r0.zzm
            r0.zzn = r3
            r0.zzo = r5
            r0.zzp = r1
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzc
            if (r1 != 0) goto L51
            goto Lb9
        L51:
            long r1 = r1.zzc
            com.google.android.gms.internal.ads.zzadx r3 = r0.zzc
            long r3 = r3.zzd
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 == 0) goto Lb9
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto Lb9
            long r7 = r5 - r1
            long r7 = r7 / r3
            long r7 = r7 * r3
            long r1 = r1 + r7
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 > 0) goto L70
            long r7 = r1 - r3
            goto L77
        L70:
            long r7 = r1 + r3
            r16 = r7
            r7 = r1
            r1 = r16
        L77:
            r9 = 2
            long r9 = r3 / r9
            long r11 = r1 - r5
            long r5 = r5 - r7
            long r13 = r11 - r5
            long r13 = java.lang.Math.abs(r13)
            int r9 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r9 >= 0) goto La7
            r9 = 4
            long r9 = r3 / r9
            int r13 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r13 >= 0) goto La4
            r19 = 0
            long r14 = r0.zzk
            int r13 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r13 == 0) goto L9b
        L98:
            r0.zzl = r14
            goto Laa
        L9b:
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 >= 0) goto La0
            long r9 = -r9
        La0:
            r0.zzl = r9
            r14 = r9
            goto Laa
        La4:
            r9 = 0
            goto La0
        La7:
            long r14 = r0.zzk
            goto L98
        Laa:
            long r11 = r11 + r14
            int r5 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r5 >= 0) goto Lb0
            goto Lb1
        Lb0:
            r1 = r7
        Lb1:
            r5 = 80
            long r3 = r3 * r5
            r5 = 100
            long r3 = r3 / r5
            long r1 = r1 - r3
            return r1
        Lb9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeb.zzi(long, long):long");
    }
}
