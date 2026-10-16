package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidf implements zzigc {
    private final zzide zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzidf(zzide zzideVar) {
        zzideVar.getClass();
        this.zza = zzideVar;
        zzideVar.zzd = this;
    }

    private final void zzQ(int i3) throws IOException {
        if ((this.zzb & 7) != i3) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
    }

    private final void zzR(Object obj, zzigh zzighVar, zzido zzidoVar) throws IOException {
        zzide zzideVar = this.zza;
        int iZzo = zzideVar.zzo();
        zzideVar.zzJ();
        int iZzB = zzideVar.zzB(iZzo);
        zzideVar.zza++;
        zzighVar.zzg(obj, this, zzidoVar);
        zzideVar.zzb(0);
        zzideVar.zza--;
        zzideVar.zzC(iZzB);
    }

    private final Object zzS(zzigh zzighVar, zzido zzidoVar) throws IOException {
        Object objZza = zzighVar.zza();
        zzR(objZza, zzighVar, zzidoVar);
        zzighVar.zzk(objZza);
        return objZza;
    }

    private final void zzT(Object obj, zzigh zzighVar, zzido zzidoVar) throws IOException {
        int i3 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzighVar.zzg(obj, this, zzidoVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zziet("Failed to parse the message.");
            }
        } finally {
            this.zzc = i3;
        }
    }

    private final Object zzU(zzihg zzihgVar, Class cls, zzido zzidoVar) throws IOException {
        zzihg zzihgVar2 = zzihg.zza;
        switch (zzihgVar.ordinal()) {
            case 0:
                return Double.valueOf(zze());
            case 1:
                return Float.valueOf(zzf());
            case 2:
                return Long.valueOf(zzh());
            case 3:
                return Long.valueOf(zzg());
            case 4:
                return Integer.valueOf(zzi());
            case 5:
                return Long.valueOf(zzj());
            case 6:
                return Integer.valueOf(zzk());
            case 7:
                return Boolean.valueOf(zzl());
            case 8:
                return zzn();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                zzQ(2);
                return zzS(zzifz.zza().zzb(cls), zzidoVar);
            case 11:
                return zzq();
            case 12:
                return Integer.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Integer.valueOf(zzt());
            case 15:
                return Long.valueOf(zzu());
            case 16:
                return Integer.valueOf(zzv());
            case 17:
                return Long.valueOf(zzw());
        }
    }

    private final void zzV(int i3) throws IOException {
        if (this.zza.zzE() != i3) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void zzW(int i3) throws IOException {
        if ((i3 & 3) != 0) {
            throw new zziet("Failed to parse the message.");
        }
    }

    private static final void zzX(int i3) throws IOException {
        if ((i3 & 7) != 0) {
            throw new zziet("Failed to parse the message.");
        }
    }

    public static zzidf zza(zzide zzideVar) {
        Object obj = zzideVar.zzd;
        return obj != null ? (zzidf) obj : new zzidf(zzideVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzA(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzifd) {
            zzifd zzifdVar = (zzifd) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzg());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzg());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzg()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzg()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzB(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzh());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzh());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzh()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzh()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzC(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzifd) {
            zzifd zzifdVar = (zzifd) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzX(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzifdVar.zzd(zzideVar.zzi());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzi());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzX(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Long.valueOf(zzideVar3.zzi()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzi()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzD(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzW(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zziefVar.zzi(zzideVar.zzj());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            if (i3 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzj());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 == 2) {
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzW(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Integer.valueOf(zzideVar3.zzj()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            if (i4 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzj()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzE(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzicq) {
            zzicq zzicqVar = (zzicq) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzicqVar.zzg(zzideVar.zzk());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzicqVar.zzg(zzideVar2.zzk());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Boolean.valueOf(zzideVar3.zzk()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Boolean.valueOf(zzideVar4.zzk()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzF(List list, boolean z2) throws IOException {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzifa) && !z2) {
            zzifa zzifaVar = (zzifa) list;
            do {
                zzq();
                zzifaVar.zzb();
                zzide zzideVar = this.zza;
                if (zzideVar.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z2 ? zzn() : zzm());
                zzide zzideVar2 = this.zza;
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza = zzideVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzG(List list, zzigh zzighVar, zzido zzidoVar) throws IOException {
        int iZza;
        int i3 = this.zzb;
        if ((i3 & 7) != 2) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzS(zzighVar, zzidoVar));
            zzide zzideVar = this.zza;
            if (zzideVar.zzD() || this.zzd != 0) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == i3);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    @Deprecated
    public final void zzH(List list, zzigh zzighVar, zzido zzidoVar) throws IOException {
        int iZza;
        int i3 = this.zzb;
        if ((i3 & 7) != 3) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZza = zzighVar.zza();
            zzT(objZza, zzighVar, zzidoVar);
            zzighVar.zzk(objZza);
            list.add(objZza);
            zzide zzideVar = this.zza;
            if (zzideVar.zzD() || this.zzd != 0) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == i3);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzI(List list) throws IOException {
        int iZza;
        if ((this.zzb & 7) != 2) {
            throw new zzies("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzq());
            zzide zzideVar = this.zza;
            if (zzideVar.zzD()) {
                return;
            } else {
                iZza = zzideVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzJ(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzo());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzo());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzo()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzo()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzK(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzp());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzp());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzp()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzp()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzL(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzW(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zziefVar.zzi(zzideVar.zzq());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            if (i3 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzq());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 == 2) {
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzW(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Integer.valueOf(zzideVar3.zzq()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            if (i4 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzq()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzM(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzifd) {
            zzifd zzifdVar = (zzifd) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzX(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzifdVar.zzd(zzideVar.zzr());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzr());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzX(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Long.valueOf(zzideVar3.zzr()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzr()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzN(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzief) {
            zzief zziefVar = (zzief) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zziefVar.zzi(zzideVar.zzs());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zziefVar.zzi(zzideVar2.zzs());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Integer.valueOf(zzideVar3.zzs()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Integer.valueOf(zzideVar4.zzs()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzO(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzifd) {
            zzifd zzifdVar = (zzifd) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzt());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzt());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzt()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzt()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r10.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        r9.zza.zzC(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzigc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzP(java.util.Map r10, com.google.android.gms.internal.ads.zzifh r11, com.google.android.gms.internal.ads.zzido r12) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 2
            r9.zzQ(r0)
            com.google.android.gms.internal.ads.zzide r1 = r9.zza
            int r2 = r1.zzo()
            int r2 = r1.zzB(r2)
            java.lang.Object r3 = r11.zzd
            java.lang.Object r4 = r11.zzb
            r5 = r3
        L13:
            int r6 = r9.zzb()     // Catch: java.lang.Throwable -> L37
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L5b
            boolean r7 = r1.zzD()     // Catch: java.lang.Throwable -> L37
            if (r7 == 0) goto L23
            goto L5b
        L23:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L46
            if (r6 == r0) goto L3b
            boolean r6 = r9.zzd()     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            if (r6 == 0) goto L31
            goto L13
        L31:
            com.google.android.gms.internal.ads.zziet r6 = new com.google.android.gms.internal.ads.zziet     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            throw r6     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
        L37:
            r10 = move-exception
            goto L64
        L39:
            r6 = move-exception
            goto L4e
        L3b:
            com.google.android.gms.internal.ads.zzihg r6 = r11.zzc     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            java.lang.Class r7 = r3.getClass()     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            java.lang.Object r5 = r9.zzU(r6, r7, r12)     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            goto L13
        L46:
            com.google.android.gms.internal.ads.zzihg r6 = r11.zza     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            r7 = 0
            java.lang.Object r4 = r9.zzU(r6, r7, r7)     // Catch: java.lang.Throwable -> L37 com.google.android.gms.internal.ads.zzies -> L39
            goto L13
        L4e:
            boolean r7 = r9.zzd()     // Catch: java.lang.Throwable -> L37
            if (r7 == 0) goto L55
            goto L13
        L55:
            com.google.android.gms.internal.ads.zziet r10 = new com.google.android.gms.internal.ads.zziet     // Catch: java.lang.Throwable -> L37
            r10.<init>(r8, r6)     // Catch: java.lang.Throwable -> L37
            throw r10     // Catch: java.lang.Throwable -> L37
        L5b:
            r10.put(r4, r5)     // Catch: java.lang.Throwable -> L37
            com.google.android.gms.internal.ads.zzide r10 = r9.zza
            r10.zzC(r2)
            return
        L64:
            com.google.android.gms.internal.ads.zzide r11 = r9.zza
            r11.zzC(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzidf.zzP(java.util.Map, com.google.android.gms.internal.ads.zzifh, com.google.android.gms.internal.ads.zzido):void");
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzb() throws IOException {
        int iZza = this.zzd;
        if (iZza != 0) {
            this.zzb = iZza;
            this.zzd = 0;
        } else {
            iZza = this.zza.zza();
            this.zzb = iZza;
        }
        return (iZza == 0 || iZza == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iZza >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i3;
        zzide zzideVar = this.zza;
        if (zzideVar.zzD() || (i3 = this.zzb) == this.zzc) {
            return false;
        }
        return zzideVar.zzc(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final double zze() throws IOException {
        zzQ(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final float zzf() throws IOException {
        zzQ(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzg() throws IOException {
        zzQ(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzh() throws IOException {
        zzQ(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzi() throws IOException {
        zzQ(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzj() throws IOException {
        zzQ(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzk() throws IOException {
        zzQ(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final boolean zzl() throws IOException {
        zzQ(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final String zzm() throws IOException {
        zzQ(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final String zzn() throws IOException {
        zzQ(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzo(Object obj, zzigh zzighVar, zzido zzidoVar) throws IOException {
        zzQ(2);
        zzR(obj, zzighVar, zzidoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzp(Object obj, zzigh zzighVar, zzido zzidoVar) throws IOException {
        zzQ(3);
        zzT(obj, zzighVar, zzidoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final zzida zzq() throws IOException {
        zzQ(2);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzr() throws IOException {
        zzQ(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzs() throws IOException {
        zzQ(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzt() throws IOException {
        zzQ(5);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzu() throws IOException {
        zzQ(1);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final int zzv() throws IOException {
        zzQ(0);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final long zzw() throws IOException {
        zzQ(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzx(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzidl) {
            zzidl zzidlVar = (zzidl) list;
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzX(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzidlVar.zzg(zzideVar.zzd());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzidlVar.zzg(zzideVar2.zzd());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzX(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Double.valueOf(zzideVar3.zzd()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Double.valueOf(zzideVar4.zzd()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzy(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzidv) {
            zzidv zzidvVar = (zzidv) list;
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzide zzideVar = this.zza;
                int iZzo = zzideVar.zzo();
                zzW(iZzo);
                int iZzE = zzideVar.zzE() + iZzo;
                do {
                    zzidvVar.zzg(zzideVar.zze());
                } while (zzideVar.zzE() < iZzE);
                return;
            }
            if (i3 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar2 = this.zza;
                zzidvVar.zzg(zzideVar2.zze());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 == 2) {
                zzide zzideVar3 = this.zza;
                int iZzo2 = zzideVar3.zzo();
                zzW(iZzo2);
                int iZzE2 = zzideVar3.zzE() + iZzo2;
                do {
                    list.add(Float.valueOf(zzideVar3.zze()));
                } while (zzideVar3.zzE() < iZzE2);
                return;
            }
            if (i4 != 5) {
                throw new zzies("Protocol message tag had invalid wire type.");
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Float.valueOf(zzideVar4.zze()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzigc
    public final void zzz(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzifd) {
            zzifd zzifdVar = (zzifd) list;
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar = this.zza;
                int iZzE = zzideVar.zzE() + zzideVar.zzo();
                do {
                    zzifdVar.zzd(zzideVar.zzf());
                } while (zzideVar.zzE() < iZzE);
                zzV(iZzE);
                return;
            }
            do {
                zzide zzideVar2 = this.zza;
                zzifdVar.zzd(zzideVar2.zzf());
                if (zzideVar2.zzD()) {
                    return;
                } else {
                    iZza2 = zzideVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i4 = this.zzb & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzies("Protocol message tag had invalid wire type.");
                }
                zzide zzideVar3 = this.zza;
                int iZzE2 = zzideVar3.zzE() + zzideVar3.zzo();
                do {
                    list.add(Long.valueOf(zzideVar3.zzf()));
                } while (zzideVar3.zzE() < iZzE2);
                zzV(iZzE2);
                return;
            }
            do {
                zzide zzideVar4 = this.zza;
                list.add(Long.valueOf(zzideVar4.zzf()));
                if (zzideVar4.zzD()) {
                    return;
                } else {
                    iZza = zzideVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }
}
