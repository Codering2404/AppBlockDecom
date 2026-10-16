package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsg {
    private final zzsf zza;
    private final int zzb;
    private final zzte zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    public zzsg(AudioTrack audioTrack, zzte zzteVar) {
        this.zza = new zzsf(audioTrack);
        this.zzb = audioTrack.getSampleRate();
        this.zzc = zzteVar;
        zzf(0);
    }

    private final void zzf(int i3) {
        this.zzd = i3;
        long j3 = 10000;
        if (i3 == 0) {
            this.zzg = 0L;
            this.zzh = -1L;
            this.zzi = -9223372036854775807L;
            this.zze = System.nanoTime() / 1000;
        } else {
            if (i3 == 1) {
                this.zzf = 10000L;
                return;
            }
            j3 = (i3 == 2 || i3 == 3) ? 10000000L : 500000L;
        }
        this.zzf = j3;
    }

    private final long zzg(long j3, float f3) {
        zzsf zzsfVar = this.zza;
        return zzh(zzsfVar.zzc(), zzsfVar.zzb(), j3, f3);
    }

    private final long zzh(long j3, long j4, long j5, float f3) {
        return zzfl.zzt(j3, this.zzb) + zzfl.zzx(j5 - j4, f3);
    }

    public final void zza(long j3, float f3, long j4, boolean z2) {
        boolean z3;
        int i3;
        if (z2 || j3 - this.zzg >= this.zzf) {
            this.zzg = j3;
            zzsf zzsfVar = this.zza;
            boolean zZza = zzsfVar.zza();
            if (zZza) {
                long jZzb = zzsfVar.zzb();
                long jZzg = zzg(j3, f3);
                i3 = 2;
                if (Math.abs(jZzb - j3) > 5000000) {
                    zzte zzteVar = this.zzc;
                    long jZzc = zzsfVar.zzc();
                    long jZzs = ((zzsr) zzteVar).zza.zzs();
                    int length = String.valueOf(jZzc).length();
                    int length2 = String.valueOf(jZzb).length();
                    int length3 = String.valueOf(j3).length();
                    StringBuilder sb = new StringBuilder(length + 52 + length2 + 2 + length3 + 2 + String.valueOf(j4).length() + 2 + String.valueOf(jZzs).length());
                    sb.append("Spurious audio timestamp (system clock mismatch): ");
                    sb.append(jZzc);
                    sb.append(", ");
                    sb.append(jZzb);
                    sb.append(", ");
                    sb.append(j3);
                    sb.append(", ");
                    sb.append(j4);
                    sb.append(", ");
                    sb.append(jZzs);
                    zzeg.zzc("AudioTrackAudioOutput", sb.toString());
                    zzf(4);
                    z3 = zZza;
                } else if (Math.abs(jZzg - j4) > 5000000) {
                    zzte zzteVar2 = this.zzc;
                    long jZzc2 = zzsfVar.zzc();
                    long jZzs2 = ((zzsr) zzteVar2).zza.zzs();
                    int length4 = String.valueOf(jZzc2).length();
                    int length5 = String.valueOf(jZzb).length();
                    int length6 = String.valueOf(j3).length();
                    int length7 = length4 + 54 + length5 + 2 + length6 + 2 + String.valueOf(j4).length() + 2;
                    z3 = zZza;
                    StringBuilder sb2 = new StringBuilder(length7 + String.valueOf(jZzs2).length());
                    sb2.append("Spurious audio timestamp (frame position mismatch): ");
                    sb2.append(jZzc2);
                    sb2.append(", ");
                    sb2.append(jZzb);
                    sb2.append(", ");
                    sb2.append(j3);
                    sb2.append(", ");
                    sb2.append(j4);
                    sb2.append(", ");
                    sb2.append(jZzs2);
                    zzeg.zzc("AudioTrackAudioOutput", sb2.toString());
                    zzf(4);
                } else {
                    z3 = zZza;
                    if (this.zzd == 4) {
                        zzf(0);
                    }
                }
            } else {
                z3 = zZza;
                i3 = 2;
            }
            int i4 = this.zzd;
            if (i4 == 0) {
                if (!z3) {
                    if (j3 - this.zze > 500000) {
                        zzf(3);
                        return;
                    }
                    return;
                } else {
                    if (zzsfVar.zzb() >= this.zze) {
                        this.zzh = zzsfVar.zzc();
                        this.zzi = zzsfVar.zzb();
                        zzf(1);
                        return;
                    }
                    return;
                }
            }
            if (i4 != 1) {
                if (i4 == i3) {
                    if (z3) {
                        return;
                    }
                    zzf(0);
                    return;
                } else {
                    if (i4 == 3 && z3) {
                        zzf(0);
                        return;
                    }
                    return;
                }
            }
            if (!z3) {
                zzf(0);
                return;
            }
            long jZzc3 = zzsfVar.zzc();
            long j5 = this.zzh;
            if (jZzc3 > j5) {
                if (Math.abs(zzg(j3, f3) - zzh(j5, this.zzi, j3, f3)) < 1000) {
                    zzf(2);
                    return;
                }
            }
            if (j3 - this.zze > 2000000) {
                zzf(3);
            } else {
                this.zzh = zzsfVar.zzc();
                this.zzi = zzsfVar.zzb();
            }
        }
    }

    public final boolean zzb() {
        return this.zzd == 2;
    }

    public final boolean zzc() {
        int i3 = this.zzd;
        return i3 == 0 || i3 == 1;
    }

    public final void zzd() {
        zzf(0);
    }

    public final long zze(long j3, float f3) {
        return zzg(j3, f3);
    }
}
