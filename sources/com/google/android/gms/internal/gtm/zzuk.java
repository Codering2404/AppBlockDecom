package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuk implements zzzs {
    private final zzuj zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzuk(zzuj zzujVar) {
        byte[] bArr = zzye.zzd;
        this.zza = zzujVar;
        zzujVar.zzc = this;
    }

    private final Object zzR(zzzt zzztVar, zzxf zzxfVar) throws IOException {
        Object objZze = zzztVar.zze();
        zzT(objZze, zzztVar, zzxfVar);
        zzztVar.zzf(objZze);
        return objZze;
    }

    private final Object zzS(zzzt zzztVar, zzxf zzxfVar) throws IOException {
        Object objZze = zzztVar.zze();
        zzU(objZze, zzztVar, zzxfVar);
        zzztVar.zzf(objZze);
        return objZze;
    }

    private final void zzT(Object obj, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        int i3 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzztVar.zzh(obj, this, zzxfVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzyg.zzg();
            }
        } finally {
            this.zzc = i3;
        }
    }

    private final void zzU(Object obj, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        zzuj zzujVar = this.zza;
        int iZzn = zzujVar.zzn();
        if (zzujVar.zza >= zzujVar.zzb) {
            throw new zzyg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZze = this.zza.zze(iZzn);
        this.zza.zza++;
        zzztVar.zzh(obj, this, zzxfVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(iZze);
    }

    private final void zzV(int i3) throws IOException {
        if (this.zza.zzd() != i3) {
            throw zzyg.zzj();
        }
    }

    private final void zzW(int i3) throws IOException {
        if ((this.zzb & 7) != i3) {
            throw zzyg.zza();
        }
    }

    private static final void zzX(int i3) throws IOException {
        if ((i3 & 3) != 0) {
            throw zzyg.zzg();
        }
    }

    private static final void zzY(int i3) throws IOException {
        if ((i3 & 7) != 0) {
            throw zzyg.zzg();
        }
    }

    public static zzuk zzq(zzuj zzujVar) {
        zzuk zzukVar = zzujVar.zzc;
        return zzukVar != null ? zzukVar : new zzuk(zzujVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzA(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzxwVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzxwVar.zzh(this.zza.zzf());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzB(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i3 != 5) {
                throw zzyg.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            this.zzd = iZzm;
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzn2 = this.zza.zzn();
            zzX(iZzn2);
            int iZzd2 = this.zza.zzd() + iZzn2;
            do {
                zzxwVar.zzh(this.zza.zzg());
            } while (this.zza.zzd() < iZzd2);
            return;
        }
        if (i4 != 5) {
            throw zzyg.zza();
        }
        do {
            zzxwVar.zzh(this.zza.zzg());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm2 = this.zza.zzm();
            }
        } while (iZzm2 == this.zzb);
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzC(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzyv)) {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            int iZzn = this.zza.zzn();
            zzY(iZzn);
            int iZzd = this.zza.zzd() + iZzn;
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzd() < iZzd);
            return;
        }
        zzyv zzyvVar = (zzyv) list;
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                zzyvVar.zzf(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        int iZzn2 = this.zza.zzn();
        zzY(iZzn2);
        int iZzd2 = this.zza.zzd() + iZzn2;
        do {
            zzyvVar.zzf(this.zza.zzo());
        } while (this.zza.zzd() < iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzD(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxm)) {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i3 != 5) {
                throw zzyg.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            this.zzd = iZzm;
            return;
        }
        zzxm zzxmVar = (zzxm) list;
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzn2 = this.zza.zzn();
            zzX(iZzn2);
            int iZzd2 = this.zza.zzd() + iZzn2;
            do {
                zzxmVar.zze(this.zza.zzc());
            } while (this.zza.zzd() < iZzd2);
            return;
        }
        if (i4 != 5) {
            throw zzyg.zza();
        }
        do {
            zzxmVar.zze(this.zza.zzc());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm2 = this.zza.zzm();
            }
        } while (iZzm2 == this.zzb);
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    @Deprecated
    public final void zzE(List list, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        int iZzm;
        int i3 = this.zzb;
        if ((i3 & 7) != 3) {
            throw zzyg.zza();
        }
        do {
            list.add(zzR(zzztVar, zzxfVar));
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i3);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzF(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzxwVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzxwVar.zzh(this.zza.zzh());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzG(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzyv)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzyv zzyvVar = (zzyv) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzyvVar.zzf(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzyvVar.zzf(this.zza.zzp());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzH(List list, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        int iZzm;
        int i3 = this.zzb;
        if ((i3 & 7) != 2) {
            throw zzyg.zza();
        }
        do {
            list.add(zzS(zzztVar, zzxfVar));
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i3);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzI(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i3 != 5) {
                throw zzyg.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            this.zzd = iZzm;
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 2) {
            int iZzn2 = this.zza.zzn();
            zzX(iZzn2);
            int iZzd2 = this.zza.zzd() + iZzn2;
            do {
                zzxwVar.zzh(this.zza.zzk());
            } while (this.zza.zzd() < iZzd2);
            return;
        }
        if (i4 != 5) {
            throw zzyg.zza();
        }
        do {
            zzxwVar.zzh(this.zza.zzk());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm2 = this.zza.zzm();
            }
        } while (iZzm2 == this.zzb);
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzJ(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzyv)) {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            int iZzn = this.zza.zzn();
            zzY(iZzn);
            int iZzd = this.zza.zzd() + iZzn;
            do {
                list.add(Long.valueOf(this.zza.zzt()));
            } while (this.zza.zzd() < iZzd);
            return;
        }
        zzyv zzyvVar = (zzyv) list;
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                zzyvVar.zzf(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        int iZzn2 = this.zza.zzn();
        zzY(iZzn2);
        int iZzd2 = this.zza.zzd() + iZzn2;
        do {
            zzyvVar.zzf(this.zza.zzt());
        } while (this.zza.zzd() < iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzK(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzxwVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzxwVar.zzh(this.zza.zzl());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzL(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzyv)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzu()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzyv zzyvVar = (zzyv) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzyvVar.zzf(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzyvVar.zzf(this.zza.zzu());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    public final void zzM(List list, boolean z2) throws IOException {
        int iZzm;
        int iZzm2;
        if ((this.zzb & 7) != 2) {
            throw zzyg.zza();
        }
        if (!(list instanceof zzyo) || z2) {
            do {
                list.add(z2 ? zzu() : zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            this.zzd = iZzm;
            return;
        }
        zzyo zzyoVar = (zzyo) list;
        do {
            zzyoVar.zzi(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm2 = this.zza.zzm();
            }
        } while (iZzm2 == this.zzb);
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzN(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxw)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzxw zzxwVar = (zzxw) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzxwVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzxwVar.zzh(this.zza.zzn());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzO(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzyv)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Long.valueOf(this.zza.zzv()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzyv zzyvVar = (zzyv) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zzyvVar.zzf(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zzyvVar.zzf(this.zza.zzv());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final boolean zzP() throws IOException {
        zzW(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final boolean zzQ() throws IOException {
        int i3;
        if (this.zza.zzC() || (i3 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final double zza() throws IOException {
        zzW(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final float zzb() throws IOException {
        zzW(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzc() throws IOException {
        int iZzm = this.zzd;
        if (iZzm != 0) {
            this.zzb = iZzm;
            this.zzd = 0;
        } else {
            iZzm = this.zza.zzm();
            this.zzb = iZzm;
        }
        return (iZzm == 0 || iZzm == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iZzm >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zze() throws IOException {
        zzW(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzf() throws IOException {
        zzW(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzg() throws IOException {
        zzW(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzh() throws IOException {
        zzW(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzi() throws IOException {
        zzW(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final int zzj() throws IOException {
        zzW(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final long zzk() throws IOException {
        zzW(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final long zzl() throws IOException {
        zzW(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final long zzm() throws IOException {
        zzW(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final long zzn() throws IOException {
        zzW(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final long zzo() throws IOException {
        zzW(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final zzud zzp() throws IOException {
        zzW(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    @Deprecated
    public final Object zzr(Class cls, zzxf zzxfVar) throws IOException {
        zzW(3);
        return zzR(zzzp.zza().zzb(cls), zzxfVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final Object zzs(Class cls, zzxf zzxfVar) throws IOException {
        zzW(2);
        return zzS(zzzp.zza().zzb(cls), zzxfVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final String zzt() throws IOException {
        zzW(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final String zzu() throws IOException {
        zzW(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzv(Object obj, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        zzW(3);
        zzT(obj, zzztVar, zzxfVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzw(Object obj, zzzt zzztVar, zzxf zzxfVar) throws IOException {
        zzW(2);
        zzU(obj, zzztVar, zzxfVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzx(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzts)) {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            zzuj zzujVar = this.zza;
            int iZzd = zzujVar.zzd() + zzujVar.zzn();
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
            } while (this.zza.zzd() < iZzd);
            zzV(iZzd);
            return;
        }
        zzts zztsVar = (zzts) list;
        int i4 = this.zzb & 7;
        if (i4 == 0) {
            do {
                zztsVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        zzuj zzujVar2 = this.zza;
        int iZzd2 = zzujVar2.zzd() + zzujVar2.zzn();
        do {
            zztsVar.zze(this.zza.zzD());
        } while (this.zza.zzd() < iZzd2);
        zzV(iZzd2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzy(List list) throws IOException {
        int iZzm;
        if ((this.zzb & 7) != 2) {
            throw zzyg.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == this.zzb);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.gtm.zzzs
    public final void zzz(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (!(list instanceof zzxc)) {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (this.zza.zzC()) {
                        return;
                    } else {
                        iZzm = this.zza.zzm();
                    }
                } while (iZzm == this.zzb);
                this.zzd = iZzm;
                return;
            }
            if (i3 != 2) {
                throw zzyg.zza();
            }
            int iZzn = this.zza.zzn();
            zzY(iZzn);
            int iZzd = this.zza.zzd() + iZzn;
            do {
                list.add(Double.valueOf(this.zza.zzb()));
            } while (this.zza.zzd() < iZzd);
            return;
        }
        zzxc zzxcVar = (zzxc) list;
        int i4 = this.zzb & 7;
        if (i4 == 1) {
            do {
                zzxcVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
            this.zzd = iZzm2;
            return;
        }
        if (i4 != 2) {
            throw zzyg.zza();
        }
        int iZzn2 = this.zza.zzn();
        zzY(iZzn2);
        int iZzd2 = this.zza.zzd() + iZzn2;
        do {
            zzxcVar.zze(this.zza.zzb());
        } while (this.zza.zzd() < iZzd2);
    }
}
