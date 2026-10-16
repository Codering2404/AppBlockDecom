package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaht implements zzafy {
    private final zzet zza;
    private final zzahs zzb;
    private final boolean zzc;
    private final zzanj zzd;
    private int zze;
    private zzagb zzf;
    private zzahu zzg;
    private long zzh;
    private zzahw[] zzi;
    private long zzj;
    private zzahw zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaht() {
        this(1, zzanj.zza);
    }

    private final zzahw zzi(int i3) {
        for (zzahw zzahwVar : this.zzi) {
            if (zzahwVar.zzc(i3)) {
                return zzahwVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzafzVar.zzi(zzetVar.zzi(), 0, 12);
        zzetVar.zzh(0);
        if (zzetVar.zzC() != 1179011410) {
            return false;
        }
        zzetVar.zzk(4);
        return zzetVar.zzC() == 541677121;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zze = 0;
        if (this.zzc) {
            zzagbVar = new zzanm(zzagbVar, this.zzd);
        }
        this.zzf = zzagbVar;
        this.zzj = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        boolean z2;
        int i3;
        long j3;
        long j4 = this.zzj;
        if (j4 != -1) {
            long jZzn = zzafzVar.zzn();
            if (j4 < jZzn || j4 > 262144 + jZzn) {
                zzagyVar.zza = j4;
                z2 = true;
            } else {
                zzafzVar.zzf((int) (j4 - jZzn));
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.zzj = -1L;
        if (z2) {
            return 1;
        }
        int i4 = this.zze;
        zzahw zzahwVar = null;
        if (i4 == 0) {
            if (!zza(zzafzVar)) {
                throw zzat.zzb("AVI Header List not found", null);
            }
            zzafzVar.zzf(12);
            this.zze = 1;
            return 0;
        }
        if (i4 == 1) {
            zzet zzetVar = this.zza;
            zzafzVar.zzc(zzetVar.zzi(), 0, 12);
            zzetVar.zzh(0);
            zzahs zzahsVar = this.zzb;
            zzahsVar.zza(zzetVar);
            int i5 = zzahsVar.zza;
            if (i5 != 1414744396) {
                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 22);
                sb.append("LIST expected, found: ");
                sb.append(i5);
                throw zzat.zzb(sb.toString(), null);
            }
            int iZzC = zzetVar.zzC();
            if (iZzC == 1819436136) {
                this.zzl = zzahsVar.zzb;
                this.zze = 2;
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzC).length() + 22);
            sb2.append("hdrl expected, found: ");
            sb2.append(iZzC);
            throw zzat.zzb(sb2.toString(), null);
        }
        if (i4 == 2) {
            int i6 = this.zzl - 4;
            zzet zzetVar2 = new zzet(i6);
            zzafzVar.zzc(zzetVar2.zzi(), 0, i6);
            zzahx zzahxVarZzb = zzahx.zzb(1819436136, zzetVar2);
            if (zzahxVarZzb.zza() != 1819436136) {
                int iZza = zzahxVarZzb.zza();
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb3.append("Unexpected header list type ");
                sb3.append(iZza);
                throw zzat.zzb(sb3.toString(), null);
            }
            zzahu zzahuVar = (zzahu) zzahxVarZzb.zzc(zzahu.class);
            if (zzahuVar == null) {
                throw zzat.zzb("AviHeader not found", null);
            }
            this.zzg = zzahuVar;
            this.zzh = ((long) zzahuVar.zzc) * ((long) zzahuVar.zza);
            ArrayList arrayList = new ArrayList();
            zzgwm zzgwmVar = zzahxVarZzb.zza;
            int size = zzgwmVar.size();
            int i7 = 0;
            int i8 = 0;
            while (i7 < size) {
                zzahq zzahqVar = (zzahq) zzgwmVar.get(i7);
                if (zzahqVar.zza() == 1819440243) {
                    zzahx zzahxVar = (zzahx) zzahqVar;
                    int i9 = i8 + 1;
                    zzahv zzahvVar = (zzahv) zzahxVar.zzc(zzahv.class);
                    zzahy zzahyVar = (zzahy) zzahxVar.zzc(zzahy.class);
                    if (zzahvVar == null) {
                        zzeg.zzc("AviExtractor", "Missing Stream Header");
                    } else if (zzahyVar == null) {
                        zzeg.zzc("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzd = zzahvVar.zzd();
                        zzv zzvVar = zzahyVar.zza;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzb(i8);
                        int i10 = zzahvVar.zze;
                        if (i10 != 0) {
                            zztVarZza.zzp(i10);
                        }
                        zzahz zzahzVar = (zzahz) zzahxVar.zzc(zzahz.class);
                        if (zzahzVar != null) {
                            zztVarZza.zzc(zzahzVar.zza);
                        }
                        int iZzf = zzas.zzf(zzvVar.zzp);
                        if (iZzf == 1) {
                            zzahk zzahkVarZzu = this.zzf.zzu(i8, iZzf);
                            zzahkVarZzu.zzA(zztVarZza.zzO());
                            zzahkVarZzu.zzO(jZzd);
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzahwVar = new zzahw(i8, zzahvVar, zzahkVarZzu);
                        } else if (iZzf == 2) {
                            iZzf = 2;
                            zzahk zzahkVarZzu2 = this.zzf.zzu(i8, iZzf);
                            zzahkVarZzu2.zzA(zztVarZza.zzO());
                            zzahkVarZzu2.zzO(jZzd);
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzahwVar = new zzahw(i8, zzahvVar, zzahkVarZzu2);
                        } else {
                            zzahwVar = null;
                        }
                    }
                    if (zzahwVar != null) {
                        arrayList.add(zzahwVar);
                    }
                    i8 = i9;
                }
                i7++;
                zzahwVar = null;
            }
            this.zzi = (zzahw[]) arrayList.toArray(new zzahw[0]);
            this.zzf.zzv();
            this.zze = 3;
            return 0;
        }
        if (i4 == 3) {
            long j5 = this.zzm;
            if (j5 != -1 && zzafzVar.zzn() != j5) {
                this.zzj = j5;
                return 0;
            }
            zzet zzetVar3 = this.zza;
            zzafzVar.zzi(zzetVar3.zzi(), 0, 12);
            zzafzVar.zzl();
            zzetVar3.zzh(0);
            zzahs zzahsVar2 = this.zzb;
            zzahsVar2.zza(zzetVar3);
            int iZzC2 = zzetVar3.zzC();
            int i11 = zzahsVar2.zza;
            if (i11 == 1179011410) {
                zzafzVar.zzf(12);
                return 0;
            }
            if (i11 != 1414744396 || iZzC2 != 1769369453) {
                this.zzj = zzafzVar.zzn() + ((long) zzahsVar2.zzb) + 8;
                return 0;
            }
            long jZzn2 = zzafzVar.zzn();
            this.zzm = jZzn2;
            long j6 = jZzn2 + ((long) zzahsVar2.zzb) + 8;
            this.zzn = j6;
            if (!this.zzp) {
                zzahu zzahuVar2 = this.zzg;
                zzahuVar2.getClass();
                if ((zzahuVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j6;
                    return 0;
                }
                this.zzf.zzw(new zzaha(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzafzVar.zzn() + 12;
            this.zze = 6;
            return 0;
        }
        if (i4 == 4) {
            zzet zzetVar4 = this.zza;
            zzafzVar.zzc(zzetVar4.zzi(), 0, 8);
            zzetVar4.zzh(0);
            int iZzC3 = zzetVar4.zzC();
            int iZzC4 = zzetVar4.zzC();
            if (iZzC3 != 829973609) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC4);
                return 0;
            }
            this.zze = 5;
            this.zzo = iZzC4;
            return 0;
        }
        if (i4 != 5) {
            if (zzafzVar.zzn() >= this.zzn) {
                return -1;
            }
            zzahw zzahwVar2 = this.zzk;
            if (zzahwVar2 != null) {
                if (!zzahwVar2.zze(zzafzVar)) {
                    return 0;
                }
                this.zzk = null;
                return 0;
            }
            if ((zzafzVar.zzn() & 1) == 1) {
                zzafzVar.zzf(1);
            }
            zzet zzetVar5 = this.zza;
            zzafzVar.zzi(zzetVar5.zzi(), 0, 12);
            zzetVar5.zzh(0);
            int iZzC5 = zzetVar5.zzC();
            if (iZzC5 == 1414744396) {
                zzetVar5.zzh(8);
                zzafzVar.zzf(zzetVar5.zzC() != 1769369453 ? 8 : 12);
                zzafzVar.zzl();
                return 0;
            }
            int iZzC6 = zzetVar5.zzC();
            if (iZzC5 == 1263424842) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC6) + 8;
                return 0;
            }
            zzafzVar.zzf(8);
            zzafzVar.zzl();
            zzahw zzahwVarZzi = zzi(iZzC5);
            if (zzahwVarZzi == null) {
                this.zzj = zzafzVar.zzn() + ((long) iZzC6);
                return 0;
            }
            zzahwVarZzi.zzd(iZzC6);
            this.zzk = zzahwVarZzi;
            return 0;
        }
        zzet zzetVar6 = new zzet(this.zzo);
        zzafzVar.zzc(zzetVar6.zzi(), 0, this.zzo);
        if (zzetVar6.zzd() < 16) {
            i3 = 0;
            j3 = 0;
        } else {
            int iZzg = zzetVar6.zzg();
            zzetVar6.zzk(8);
            long jZzC = zzetVar6.zzC();
            i3 = 0;
            long j7 = this.zzm;
            j3 = jZzC > j7 ? 0L : j7 + 8;
            zzetVar6.zzh(iZzg);
        }
        while (zzetVar6.zzd() >= 16) {
            int iZzC7 = zzetVar6.zzC();
            int iZzC8 = zzetVar6.zzC();
            long jZzC2 = ((long) zzetVar6.zzC()) + j3;
            zzetVar6.zzk(4);
            zzahw zzahwVarZzi2 = zzi(iZzC7);
            if (zzahwVarZzi2 != null) {
                zzahwVarZzi2.zza(jZzC2, (iZzC8 & 16) == 16 ? 1 : i3);
            }
        }
        zzahw[] zzahwVarArr = this.zzi;
        int length = zzahwVarArr.length;
        for (int i12 = i3; i12 < length; i12++) {
            zzahwVarArr[i12].zzb();
        }
        this.zzp = true;
        if (this.zzi.length == 0) {
            this.zzf.zzw(new zzaha(this.zzh, 0L));
        } else {
            this.zzf.zzw(new zzahr(this, this.zzh));
        }
        this.zze = 6;
        this.zzj = this.zzm;
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzahw zzahwVar : this.zzi) {
            zzahwVar.zzf(j3);
        }
        if (j3 == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    final /* synthetic */ zzahw[] zzh() {
        return this.zzi;
    }

    public zzaht(int i3, zzanj zzanjVar) {
        this.zzd = zzanjVar;
        this.zzc = 1 == (i3 ^ 1);
        this.zza = new zzet(12);
        this.zzb = new zzahs(null);
        this.zzf = new zzagx();
        this.zzi = new zzahw[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
