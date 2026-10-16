package com.google.android.libraries.places.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbai extends zzbdq implements zzbey {
    private static final zzbai zzaK;
    private static volatile zzbff zzaL;
    private zzbib zzA;
    private int zzD;
    private zzbhr zzE;
    private int zzF;
    private int zzH;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private zzazx zzW;
    private zzbhv zzZ;
    private boolean zzaA;
    private zzawe zzaB;
    private zzazm zzaC;
    private zzbaq zzaD;
    private zzbaf zzaE;
    private zzazi zzaF;
    private zzazo zzaG;
    private zzaze zzaH;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private boolean zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private zzbab zzam;
    private zzazz zzan;
    private zzayq zzap;
    private boolean zzaq;
    private boolean zzar;
    private boolean zzas;
    private boolean zzat;
    private boolean zzau;
    private zzaye zzav;
    private zzaxy zzaw;
    private zzazk zzax;
    private zzayu zzay;
    private int zzb;
    private int zze;
    private zzbhv zzh;
    private zzbhv zzk;
    private zzbhz zzp;
    private zzbad zzr;
    private zzbht zzs;
    private zzaua zzt;
    private double zzu;
    private zzazx zzy;
    private int zzz;
    private String zzf = "";
    private String zzg = "";
    private zzbea zzi = zzbdq.s();
    private String zzj = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private zzbea zzq = zzbdq.s();
    private String zzv = "";
    private String zzw = "";
    private zzbea zzx = zzbdq.s();
    private zzbea zzB = zzbdq.s();
    private String zzC = "";
    private zzbea zzG = zzbdq.s();
    private String zzI = "";
    private String zzJ = "";
    private zzbea zzX = zzbdq.s();
    private zzbea zzY = zzbdq.s();
    private zzbea zzao = zzbdq.s();
    private zzbea zzaz = zzbdq.s();
    private String zzaI = "";
    private String zzaJ = "";

    static {
        zzbai zzbaiVar = new zzbai();
        zzaK = zzbaiVar;
        zzbdq.D(zzbai.class, zzbaiVar);
    }

    private zzbai() {
    }

    public static zzbai q1() {
        return zzaK;
    }

    public final boolean A0() {
        return (this.zze & 32768) != 0;
    }

    public final String A1() {
        return this.zzm;
    }

    public final zzazk B0() {
        zzazk zzazkVar = this.zzax;
        return zzazkVar == null ? zzazk.L() : zzazkVar;
    }

    public final String B1() {
        return this.zzn;
    }

    public final boolean C0() {
        return (this.zze & 131072) != 0;
    }

    public final String C1() {
        return this.zzo;
    }

    public final boolean D0() {
        return this.zzaA;
    }

    public final List D1() {
        return this.zzq;
    }

    public final boolean E0() {
        return (this.zze & 524288) != 0;
    }

    public final boolean E1() {
        return (this.zzb & 8) != 0;
    }

    public final zzazm F0() {
        zzazm zzazmVar = this.zzaC;
        return zzazmVar == null ? zzazm.L() : zzazmVar;
    }

    public final zzbad F1() {
        zzbad zzbadVar = this.zzr;
        return zzbadVar == null ? zzbad.I() : zzbadVar;
    }

    public final boolean G() {
        return (this.zzb & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
    }

    public final zzbaq G0() {
        zzbaq zzbaqVar = this.zzaD;
        return zzbaqVar == null ? zzbaq.K() : zzbaqVar;
    }

    public final boolean G1() {
        return (this.zzb & 16) != 0;
    }

    public final int H() {
        return this.zzz;
    }

    public final boolean H0() {
        return this.zzR;
    }

    public final zzbht H1() {
        zzbht zzbhtVar = this.zzs;
        return zzbhtVar == null ? zzbht.J() : zzbhtVar;
    }

    public final List I() {
        return this.zzB;
    }

    public final boolean I0() {
        return (this.zzb & 524288) != 0;
    }

    public final boolean I1() {
        return (this.zzb & 32) != 0;
    }

    public final String J() {
        return this.zzC;
    }

    public final boolean J0() {
        return this.zzS;
    }

    public final zzaua J1() {
        zzaua zzauaVar = this.zzt;
        return zzauaVar == null ? zzaua.J() : zzauaVar;
    }

    public final zzayy K() {
        int i3 = this.zzD;
        zzayy zzayyVar = i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? null : zzayy.FUTURE_OPENING : zzayy.CLOSED_PERMANENTLY : zzayy.CLOSED_TEMPORARILY : zzayy.OPERATIONAL : zzayy.BUSINESS_STATUS_UNSPECIFIED;
        return zzayyVar == null ? zzayy.UNRECOGNIZED : zzayyVar;
    }

    public final boolean K0() {
        return (this.zzb & 1048576) != 0;
    }

    public final double K1() {
        return this.zzu;
    }

    public final zzbao L() {
        int i3 = this.zzF;
        zzbao zzbaoVar = i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? null : zzbao.PRICE_LEVEL_VERY_EXPENSIVE : zzbao.PRICE_LEVEL_EXPENSIVE : zzbao.PRICE_LEVEL_MODERATE : zzbao.PRICE_LEVEL_INEXPENSIVE : zzbao.PRICE_LEVEL_FREE : zzbao.PRICE_LEVEL_UNSPECIFIED;
        return zzbaoVar == null ? zzbao.UNRECOGNIZED : zzbaoVar;
    }

    public final boolean L0() {
        return this.zzT;
    }

    public final String L1() {
        return this.zzv;
    }

    public final List M() {
        return this.zzG;
    }

    public final boolean M0() {
        return (this.zzb & 2097152) != 0;
    }

    public final String M1() {
        return this.zzw;
    }

    public final boolean N() {
        return (this.zzb & 1024) != 0;
    }

    public final boolean N0() {
        return this.zzU;
    }

    public final List N1() {
        return this.zzx;
    }

    public final int O() {
        return this.zzH;
    }

    public final boolean O0() {
        return (this.zzb & 4194304) != 0;
    }

    public final boolean O1() {
        return (this.zzb & 64) != 0;
    }

    public final String P() {
        return this.zzI;
    }

    public final boolean P0() {
        return this.zzV;
    }

    public final zzazx P1() {
        zzazx zzazxVar = this.zzy;
        return zzazxVar == null ? zzazx.Q() : zzazxVar;
    }

    public final String Q() {
        return this.zzJ;
    }

    public final boolean Q0() {
        return (this.zzb & 8388608) != 0;
    }

    public final boolean R() {
        return (this.zzb & 2048) != 0;
    }

    public final zzazx R0() {
        zzazx zzazxVar = this.zzW;
        return zzazxVar == null ? zzazx.Q() : zzazxVar;
    }

    public final boolean S() {
        return this.zzK;
    }

    public final List S0() {
        return this.zzX;
    }

    public final boolean T() {
        return (this.zzb & 4096) != 0;
    }

    public final List T0() {
        return this.zzY;
    }

    public final boolean U() {
        return this.zzL;
    }

    public final boolean U0() {
        return (this.zzb & 16777216) != 0;
    }

    public final boolean V() {
        return (this.zzb & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public final zzbhv V0() {
        zzbhv zzbhvVar = this.zzZ;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final boolean W() {
        return this.zzM;
    }

    public final boolean W0() {
        return (this.zzb & 33554432) != 0;
    }

    public final boolean X() {
        return (this.zzb & 16384) != 0;
    }

    public final boolean X0() {
        return this.zzaa;
    }

    public final boolean Y() {
        return this.zzN;
    }

    public final boolean Y0() {
        return (this.zzb & 67108864) != 0;
    }

    public final boolean Z() {
        return (this.zzb & 32768) != 0;
    }

    public final boolean Z0() {
        return this.zzab;
    }

    public final boolean a0() {
        return this.zzO;
    }

    public final boolean b0() {
        return (this.zzb & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public final boolean b1() {
        return (this.zzb & 134217728) != 0;
    }

    public final boolean c0() {
        return this.zzP;
    }

    public final boolean c1() {
        return this.zzac;
    }

    public final boolean d0() {
        return (this.zzb & 131072) != 0;
    }

    public final boolean d1() {
        return (this.zzb & 268435456) != 0;
    }

    public final boolean e0() {
        return this.zzQ;
    }

    public final boolean e1() {
        return this.zzad;
    }

    public final boolean f0() {
        return (this.zzb & 262144) != 0;
    }

    public final boolean f1() {
        return (this.zzb & 536870912) != 0;
    }

    public final String g0() {
        return this.zzf;
    }

    public final boolean g1() {
        return this.zzae;
    }

    public final boolean h0() {
        return this.zzaf;
    }

    public final boolean h1() {
        return (this.zzb & 1073741824) != 0;
    }

    public final boolean i0() {
        return (this.zze & 1) != 0;
    }

    public final boolean i1() {
        return (this.zze & 2097152) != 0;
    }

    public final boolean j0() {
        return this.zzah;
    }

    public final zzbaf j1() {
        zzbaf zzbafVar = this.zzaE;
        return zzbafVar == null ? zzbaf.K() : zzbafVar;
    }

    public final boolean k0() {
        return (this.zze & 2) != 0;
    }

    public final boolean k1() {
        return (this.zze & 4194304) != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzaK, "\u0000S\u0000\u0002\u0001_S\u0000\t\u0000\u0001Ȉ\u0002Ȉ\u0005Ț\u0007Ȉ\bȈ\tȈ\n\u001b\u000bဉ\u0003\fဉ\u0004\rဉ\u0005\u000e\u0000\u000fȈ\u0010Ȉ\u0015ဉ\u0006\u0016င\u0007\u0018Ȉ\u0019\f\u001a\f\u001b\u001b\u001cင\n\u001dȈ\u001eȈ\u001fဉ\u0000 ဉ\u0001!ဇ\u000b\"ဇ\f#ဇ\r$ဇ\u000e&ဇ\u000f'ဇ\u0010(ဇ\u0011)ဇ\u0012*ဇ\u0013+ဇ\u0014,ဇ\u0015-ဇ\u0016.ဉ\u0017/\u001b1\u001b2Ȉ3Ȉ4ဉ\u00185\u001b6\u001b7ဇ\u00198ဇ\u001a9ဇ\u001b:ဇ\u001c;ဇ\u001d<ဇ\u001e=ဇ\u001f>ဇ ?ဇ!@ဇ\"Aဇ#Bဇ$Cဉ%Fဉ&G\u001bHဉ'Iဇ(Jဇ)Kဇ*Lဇ+Mဇ,Nဉ-Oဉ.Pဉ/Qဉ0R\u001bSဇ1Tဉ2Uဉ3Vဉ4Wဉ5Xဉ\bYဉ6Zဉ\u0002[ဉ7\\ဉ8]Ȉ^Ȉ_ဉ\t", new Object[]{"zzb", "zze", "zzf", "zzg", "zzi", "zzl", "zzm", "zzn", "zzq", zzays.class, "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzy", "zzz", "zzC", "zzD", "zzF", "zzG", zzayw.class, "zzH", "zzI", "zzJ", "zzh", "zzk", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", zzazx.class, "zzY", zzazx.class, "zzj", "zzo", "zzZ", "zzx", zzbau.class, "zzB", zzaym.class, "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", zzbah.class, "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", "zzax", "zzay", "zzaz", zzazg.class, "zzaA", "zzaB", "zzaC", "zzaD", "zzaE", "zzA", "zzaF", "zzp", "zzaG", "zzaH", "zzaI", "zzaJ", "zzE"});
        }
        if (i4 == 3) {
            return new zzbai();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayx(bArr);
        }
        if (i4 == 5) {
            return zzaK;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzaL;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbai.class) {
            try {
                zzbdlVar = zzaL;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzaK);
                    zzaL = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }

    public final boolean l0() {
        return this.zzai;
    }

    public final zzazi l1() {
        zzazi zzaziVar = this.zzaF;
        return zzaziVar == null ? zzazi.P() : zzaziVar;
    }

    public final boolean m0() {
        return (this.zze & 4) != 0;
    }

    public final boolean m1() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean n0() {
        return this.zzaj;
    }

    public final zzazo n1() {
        zzazo zzazoVar = this.zzaG;
        return zzazoVar == null ? zzazo.M() : zzazoVar;
    }

    public final boolean o0() {
        return (this.zze & 8) != 0;
    }

    public final boolean o1() {
        return (this.zze & 16777216) != 0;
    }

    public final boolean p0() {
        return this.zzak;
    }

    public final zzaze p1() {
        zzaze zzazeVar = this.zzaH;
        return zzazeVar == null ? zzaze.K() : zzazeVar;
    }

    public final boolean q0() {
        return (this.zze & 16) != 0;
    }

    public final boolean r0() {
        return this.zzal;
    }

    public final zzbab s0() {
        zzbab zzbabVar = this.zzam;
        return zzbabVar == null ? zzbab.O() : zzbabVar;
    }

    public final String s1() {
        return this.zzg;
    }

    public final zzazz t0() {
        zzazz zzazzVar = this.zzan;
        return zzazzVar == null ? zzazz.U() : zzazzVar;
    }

    public final boolean t1() {
        return (this.zzb & 1) != 0;
    }

    public final List u0() {
        return this.zzao;
    }

    public final zzbhv u1() {
        zzbhv zzbhvVar = this.zzh;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final zzayq v0() {
        zzayq zzayqVar = this.zzap;
        return zzayqVar == null ? zzayq.O() : zzayqVar;
    }

    public final List v1() {
        return this.zzi;
    }

    public final boolean w0() {
        return (this.zze & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public final String w1() {
        return this.zzj;
    }

    public final zzaye x0() {
        zzaye zzayeVar = this.zzav;
        return zzayeVar == null ? zzaye.H() : zzayeVar;
    }

    public final boolean x1() {
        return (this.zzb & 2) != 0;
    }

    public final boolean y0() {
        return (this.zze & 16384) != 0;
    }

    public final zzbhv y1() {
        zzbhv zzbhvVar = this.zzk;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final zzaxy z0() {
        zzaxy zzaxyVar = this.zzaw;
        return zzaxyVar == null ? zzaxy.I() : zzaxyVar;
    }

    public final String z1() {
        return this.zzl;
    }
}
