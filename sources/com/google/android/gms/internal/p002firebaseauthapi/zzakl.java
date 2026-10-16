package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakl implements zzanc {
    private final zzakh zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzakl(zzakh zzakhVar) {
        zzakh zzakhVar2 = (zzakh) zzalh.zza(zzakhVar, "input");
        this.zza = zzakhVar2;
        zzakhVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzc() throws IOException {
        int i3 = this.zzd;
        if (i3 != 0) {
            this.zzb = i3;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i4 = this.zzb;
        return (i4 == 0 || i4 == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i4 >>> 3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final zzajv zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final boolean zzt() throws IOException {
        int i3;
        if (this.zza.zzw() || (i3 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i3);
    }

    private final <T> void zzd(T t2, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        int iZzj = this.zza.zzj();
        this.zza.zzt();
        int iZzb = this.zza.zzb(iZzj);
        this.zza.zza++;
        zzanbVar.zza(t2, this, zzakuVar);
        this.zza.zzc(0);
        r4.zza--;
        this.zza.zzd(iZzb);
    }

    public static zzakl zza(zzakh zzakhVar) {
        zzakl zzaklVar = zzakhVar.zzc;
        return zzaklVar != null ? zzaklVar : new zzakl(zzakhVar);
    }

    private final <T> T zzb(zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        T tZza = zzanbVar.zza();
        zzd(tZza, zzanbVar, zzakuVar);
        zzanbVar.zzd(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zze(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzaliVar.zzc(this.zza.zze());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i3 == 5) {
                do {
                    zzaliVar.zzc(this.zza.zze());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zze()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i4 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzf(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzalx) {
            zzalx zzalxVar = (zzalx) list;
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    zzalxVar.zza(this.zza.zzk());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzalxVar.zza(this.zza.zzk());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzg(List<Float> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzald) {
            zzald zzaldVar = (zzald) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzaldVar.zza(this.zza.zzb());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i3 == 5) {
                do {
                    zzaldVar.zza(this.zza.zzb());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Float.valueOf(this.zza.zzb()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i4 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzh(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzaliVar.zzc(this.zza.zzf());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaliVar.zzc(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzi(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzalx) {
            zzalx zzalxVar = (zzalx) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzalxVar.zza(this.zza.zzl());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalxVar.zza(this.zza.zzl());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzj(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzaliVar.zzc(this.zza.zzg());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i3 == 5) {
                do {
                    zzaliVar.zzc(this.zza.zzg());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i4 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzk(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzalx) {
            zzalx zzalxVar = (zzalx) list;
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    zzalxVar.zza(this.zza.zzn());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzalxVar.zza(this.zza.zzn());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzl(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzaliVar.zzc(this.zza.zzh());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaliVar.zzc(this.zza.zzh());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzm(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzalx) {
            zzalx zzalxVar = (zzalx) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzalxVar.zza(this.zza.zzo());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalxVar.zza(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzp(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzaliVar.zzc(this.zza.zzj());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaliVar.zzc(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzq(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzalx) {
            zzalx zzalxVar = (zzalx) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzalxVar.zza(this.zza.zzp());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalxVar.zza(this.zza.zzp());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    private final Object zza(zzaog zzaogVar, Class<?> cls, zzaku zzakuVar) throws IOException {
        switch (zzako.zza[zzaogVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzamx.zza().zza((Class) cls), zzakuVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> void zzc(T t2, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        int i3 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzanbVar.zza(t2, this, zzakuVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzall.zzg();
            }
        } finally {
            this.zzc = i3;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final <T> void zzb(T t2, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        zzb(2);
        zzd(t2, zzanbVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzb(List<zzajv> list) throws IOException {
        int iZzi;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzd(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzali) {
            zzali zzaliVar = (zzali) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzaliVar.zzc(this.zza.zzd());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaliVar.zzc(this.zza.zzd());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final <T> void zzb(List<T> list, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        int iZzi;
        int i3 = this.zzb;
        if ((i3 & 7) == 2) {
            do {
                list.add(zzb(zzanbVar, zzakuVar));
                if (this.zza.zzw() || this.zzd != 0) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == i3);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zzc(List<Double> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzaks) {
            zzaks zzaksVar = (zzaks) list;
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    zzaksVar.zza(this.zza.zza());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzaksVar.zza(this.zza.zza());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzall.zza();
    }

    private final void zzb(int i3) throws IOException {
        if ((this.zzb & 7) != i3) {
            throw zzall.zza();
        }
    }

    private final <T> T zza(zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        T tZza = zzanbVar.zza();
        zzc(tZza, zzanbVar, zzakuVar);
        zzanbVar.zzd(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final <T> void zza(T t2, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        zzb(3);
        zzc(t2, zzanbVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    public final void zza(List<Boolean> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzajt) {
            zzajt zzajtVar = (zzajt) list;
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    zzajtVar.zza(this.zza.zzx());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i3 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzajtVar.zza(this.zza.zzx());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzall.zza();
        }
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzx()));
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i4 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzx()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzall.zza();
    }

    private static void zzd(int i3) throws IOException {
        if ((i3 & 7) != 0) {
            throw zzall.zzg();
        }
    }

    private static void zzc(int i3) throws IOException {
        if ((i3 & 3) != 0) {
            throw zzall.zzg();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    @Deprecated
    public final <T> void zza(List<T> list, zzanb<T> zzanbVar, zzaku zzakuVar) throws IOException {
        int iZzi;
        int i3 = this.zzb;
        if ((i3 & 7) == 3) {
            do {
                list.add(zza(zzanbVar, zzakuVar));
                if (this.zza.zzw() || this.zzd != 0) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == i3);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        r7.zza.zzd(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.p002firebaseauthapi.zzamd<K, V> r9, com.google.android.gms.internal.p002firebaseauthapi.zzaku r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.firebase-auth-api.zzakh r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.firebase-auth-api.zzakh r2 = r7.zza
            int r1 = r2.zzb(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L39
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5f
            com.google.android.gms.internal.firebase-auth-api.zzakh r5 = r7.zza     // Catch: java.lang.Throwable -> L39
            boolean r5 = r5.zzw()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L5f
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L4a
            if (r4 == r0) goto L3d
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.firebase-auth-api.zzall r4 = new com.google.android.gms.internal.firebase-auth-api.zzall     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            throw r4     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
        L39:
            r8 = move-exception
            goto L68
        L3b:
            r4 = move-exception
            goto L52
        L3d:
            com.google.android.gms.internal.firebase-auth-api.zzaog r4 = r9.zzc     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            V r5 = r9.zzd     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            goto L14
        L4a:
            com.google.android.gms.internal.firebase-auth-api.zzaog r4 = r9.zza     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: java.lang.Throwable -> L39 com.google.android.gms.internal.p002firebaseauthapi.zzalo -> L3b
            goto L14
        L52:
            boolean r5 = r7.zzt()     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L59
            goto L14
        L59:
            com.google.android.gms.internal.firebase-auth-api.zzall r8 = new com.google.android.gms.internal.firebase-auth-api.zzall     // Catch: java.lang.Throwable -> L39
            r8.<init>(r6, r4)     // Catch: java.lang.Throwable -> L39
            throw r8     // Catch: java.lang.Throwable -> L39
        L5f:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.firebase-auth-api.zzakh r8 = r7.zza
            r8.zzd(r1)
            return
        L68:
            com.google.android.gms.internal.firebase-auth-api.zzakh r9 = r7.zza
            r9.zzd(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakl.zza(java.util.Map, com.google.android.gms.internal.firebase-auth-api.zzamd, com.google.android.gms.internal.firebase-auth-api.zzaku):void");
    }

    private final void zza(List<String> list, boolean z2) throws IOException {
        int iZzi;
        int iZzi2;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzalt) && !z2) {
                zzalt zzaltVar = (zzalt) list;
                do {
                    zzaltVar.zza(zzp());
                    if (this.zza.zzw()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            do {
                list.add(z2 ? zzr() : zzq());
                if (this.zza.zzw()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzall.zza();
    }

    private final void zza(int i3) throws IOException {
        if (this.zza.zzc() != i3) {
            throw zzall.zzj();
        }
    }
}
