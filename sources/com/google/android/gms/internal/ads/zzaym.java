package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaym extends zziee implements zzifq {
    private static final zzaym zzbo;
    private static volatile zzifx zzbp;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzH;
    private long zzI;
    private long zzJ;
    private long zzL;
    private zzayo zzO;
    private int zza;
    private zzayh zzaF;
    private zzayf zzaG;
    private long zzaM;
    private long zzaN;
    private long zzaQ;
    private zzaxw zzaR;
    private zzaxy zzaS;
    private int zzaV;
    private zzayj zzag;
    private zzayl zzai;
    private int zzat;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzazd zzax;
    private int zzb;
    private int zzba;
    private zzaxu zzbb;
    private boolean zzbc;
    private long zzbd;
    private boolean zzbg;
    private long zzbi;
    private zzazb zzbj;
    private int zzc;
    private int zzd;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zze = "";
    private String zzf = "";
    private String zzu = "";
    private String zzE = "";
    private String zzF = "D";
    private String zzG = "";
    private String zzK = "";
    private long zzM = -1;
    private long zzN = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private String zzV = "D";
    private String zzW = "D";
    private long zzX = -1;
    private int zzY = 1000;
    private int zzZ = 1000;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private int zzaf = 1000;
    private zzieq zzah = zziee.zzbM();
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private String zzar = "D";
    private long zzas = -1;
    private long zzay = -1;
    private int zzaz = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzieq zzaC = zziee.zzbM();
    private int zzaD = 1000;
    private zzieq zzaE = zziee.zzbM();
    private String zzaH = "";
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL = -1;
    private long zzaO = -1;
    private String zzaP = "";
    private long zzaT = -1;
    private long zzaU = -1;
    private String zzaW = "";
    private String zzaX = "";
    private long zzaY = -1;
    private long zzaZ = -1;
    private String zzbe = "";
    private int zzbf = 2;
    private String zzbh = "";
    private long zzbk = -1;
    private String zzbl = "";
    private zziem zzbm = zziee.zzbC();
    private long zzbn = -1;

    static {
        zzaym zzaymVar = new zzaym();
        zzbo = zzaymVar;
        zziee.zzbu(zzaym.class, zzaymVar);
    }

    private zzaym() {
    }

    public static zzaym zzi(byte[] bArr, zzido zzidoVar) throws zziet {
        return (zzaym) zziee.zzbV(zzbo, bArr, zzidoVar);
    }

    public static zzaxm zzj() {
        return (zzaxm) zzbo.zzbn();
    }

    public static zzaym zzk() {
        return zzbo;
    }

    final /* synthetic */ void zzA(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzG = str;
    }

    final /* synthetic */ void zzB(long j3) {
        this.zza |= 33554432;
        this.zzH = j3;
    }

    final /* synthetic */ void zzC(long j3) {
        this.zza |= 67108864;
        this.zzI = j3;
    }

    final /* synthetic */ void zzD(long j3) {
        this.zza |= 134217728;
        this.zzJ = j3;
    }

    final /* synthetic */ void zzE(String str) {
        str.getClass();
        this.zza |= 268435456;
        this.zzK = str;
    }

    final /* synthetic */ void zzF(long j3) {
        this.zza |= 536870912;
        this.zzL = j3;
    }

    final /* synthetic */ void zzG(long j3) {
        this.zza |= 1073741824;
        this.zzM = j3;
    }

    final /* synthetic */ void zzH(long j3) {
        this.zza |= Integer.MIN_VALUE;
        this.zzN = j3;
    }

    final /* synthetic */ void zzI(long j3) {
        this.zzb |= 2;
        this.zzP = j3;
    }

    final /* synthetic */ void zzJ(long j3) {
        this.zzb |= 4;
        this.zzQ = j3;
    }

    final /* synthetic */ void zzK(long j3) {
        this.zzb |= 8;
        this.zzR = j3;
    }

    final /* synthetic */ void zzL(long j3) {
        this.zzb |= 16;
        this.zzS = j3;
    }

    final /* synthetic */ void zzM(long j3) {
        this.zzb |= 32;
        this.zzT = j3;
    }

    final /* synthetic */ void zzN(long j3) {
        this.zzb |= 64;
        this.zzU = j3;
    }

    final /* synthetic */ void zzO(String str) {
        str.getClass();
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.zzV = str;
    }

    final /* synthetic */ void zzP(String str) {
        str.getClass();
        this.zzb |= Function.MAX_NARGS;
        this.zzW = str;
    }

    final /* synthetic */ void zzQ(long j3) {
        this.zzb |= 4096;
        this.zzaa = j3;
    }

    final /* synthetic */ void zzR(long j3) {
        this.zzb |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzab = j3;
    }

    final /* synthetic */ void zzS(long j3) {
        this.zzb |= 16384;
        this.zzac = j3;
    }

    final /* synthetic */ void zzT(zzayj zzayjVar) {
        zzayjVar.getClass();
        this.zzag = zzayjVar;
        this.zzb |= 262144;
    }

    final /* synthetic */ void zzU(zzayj zzayjVar) {
        zzayjVar.getClass();
        zzieq zzieqVar = this.zzah;
        if (!zzieqVar.zza()) {
            this.zzah = zziee.zzbN(zzieqVar);
        }
        this.zzah.add(zzayjVar);
    }

    final /* synthetic */ void zzV() {
        this.zzah = zziee.zzbM();
    }

    final /* synthetic */ void zzW(zzayl zzaylVar) {
        zzaylVar.getClass();
        this.zzai = zzaylVar;
        this.zzb |= 524288;
    }

    final /* synthetic */ void zzX(long j3) {
        this.zzb |= 1048576;
        this.zzaj = j3;
    }

    final /* synthetic */ void zzY(long j3) {
        this.zzb |= 2097152;
        this.zzak = j3;
    }

    final /* synthetic */ void zzZ(long j3) {
        this.zzb |= 4194304;
        this.zzal = j3;
    }

    public final boolean zza() {
        return (this.zza & 4194304) != 0;
    }

    final /* synthetic */ void zzaa(long j3) {
        this.zzb |= 8388608;
        this.zzam = j3;
    }

    final /* synthetic */ void zzab(long j3) {
        this.zzb |= 16777216;
        this.zzan = j3;
    }

    final /* synthetic */ void zzac(long j3) {
        this.zzb |= 67108864;
        this.zzap = j3;
    }

    final /* synthetic */ void zzad(long j3) {
        this.zzb |= 134217728;
        this.zzaq = j3;
    }

    final /* synthetic */ void zzae(String str) {
        str.getClass();
        this.zzb |= 268435456;
        this.zzar = str;
    }

    final /* synthetic */ void zzaf(String str) {
        str.getClass();
        this.zzc |= 1024;
        this.zzaH = str;
    }

    final /* synthetic */ void zzag(long j3) {
        this.zzc |= 2048;
        this.zzaI = j3;
    }

    final /* synthetic */ void zzah(long j3) {
        this.zzc |= 4096;
        this.zzaJ = j3;
    }

    final /* synthetic */ void zzai(long j3) {
        this.zzc |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzaK = j3;
    }

    final /* synthetic */ void zzaj(long j3) {
        this.zzc |= 16384;
        this.zzaL = j3;
    }

    final /* synthetic */ void zzak(String str) {
        str.getClass();
        this.zzc |= 262144;
        this.zzaP = str;
    }

    final /* synthetic */ void zzal(long j3) {
        this.zzc |= 8388608;
        this.zzaU = j3;
    }

    final /* synthetic */ void zzam(long j3) {
        this.zzd |= 32;
        this.zzbi = j3;
    }

    final /* synthetic */ void zzan(zzazb zzazbVar) {
        zzazbVar.getClass();
        this.zzbj = zzazbVar;
        this.zzd |= 64;
    }

    final /* synthetic */ void zzap(int i3) {
        this.zzY = i3 - 1;
        this.zzb |= 1024;
    }

    final /* synthetic */ void zzaq(int i3) {
        this.zzZ = i3 - 1;
        this.zzb |= 2048;
    }

    final /* synthetic */ void zzar(int i3) {
        this.zzaf = i3 - 1;
        this.zzb |= 131072;
    }

    final /* synthetic */ void zzas(int i3) {
        this.zzaz = i3 - 1;
        this.zzc |= 16;
    }

    final /* synthetic */ void zzat(int i3) {
        this.zzaA = i3 - 1;
        this.zzc |= 32;
    }

    final /* synthetic */ void zzau(int i3) {
        this.zzaV = i3 - 1;
        this.zzc |= 16777216;
    }

    public final String zzb() {
        return this.zzE;
    }

    public final boolean zzc() {
        return (this.zzb & 1048576) != 0;
    }

    public final long zzd() {
        return this.zzaj;
    }

    public final long zze() {
        return this.zzan;
    }

    public final boolean zzg() {
        return (this.zzd & 64) != 0;
    }

    public final zzazb zzh() {
        zzazb zzazbVar = this.zzbj;
        return zzazbVar == null ? zzazb.zze() : zzazbVar;
    }

    final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzm(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void zzn(long j3) {
        this.zza |= 4;
        this.zzg = j3;
    }

    final /* synthetic */ void zzo(long j3) {
        this.zza |= 16;
        this.zzi = j3;
    }

    final /* synthetic */ void zzp(long j3) {
        this.zza |= 32;
        this.zzj = j3;
    }

    final /* synthetic */ void zzq(long j3) {
        this.zza |= 1024;
        this.zzo = j3;
    }

    final /* synthetic */ void zzr(long j3) {
        this.zza |= 2048;
        this.zzp = j3;
    }

    final /* synthetic */ void zzs(long j3) {
        this.zza |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzv = j3;
    }

    final /* synthetic */ void zzt(long j3) {
        this.zza |= 16384;
        this.zzw = j3;
    }

    final /* synthetic */ void zzu(long j3) {
        this.zza |= 32768;
        this.zzx = j3;
    }

    final /* synthetic */ void zzv(long j3) {
        this.zza |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.zzy = j3;
    }

    final /* synthetic */ void zzw(long j3) {
        this.zza |= 524288;
        this.zzB = j3;
    }

    final /* synthetic */ void zzx(long j3) {
        this.zza |= 1048576;
        this.zzC = j3;
    }

    final /* synthetic */ void zzy(long j3) {
        this.zza |= 2097152;
        this.zzD = j3;
    }

    final /* synthetic */ void zzz(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzE = str;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    byte[] bArr = null;
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            if (iOrdinal == 6) {
                                zzifx zzifxVar = zzbp;
                                if (zzifxVar == null) {
                                    synchronized (zzaym.class) {
                                        try {
                                            zzidzVar = zzbp;
                                            if (zzidzVar == null) {
                                                zzidzVar = new zzidz(zzbo);
                                                zzbp = zzidzVar;
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    return zzidzVar;
                                }
                                return zzifxVar;
                            }
                            throw null;
                        }
                        return zzbo;
                    }
                    return new zzaxm(bArr);
                }
                return new zzaym();
            }
            zziek zziekVar = zzaxq.zza;
            zziek zziekVar2 = zzayw.zza;
            return zziee.zzbv(zzbo, "\u0001n\u0000\u0004\u0001Įn\u0000\u0004\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ`\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈa\u0019ဂe\u001a᠌b\u001bဈ\u0016\u001cဇc\u001dဈ\u0018\u001eဈd\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉT[ဉU\\ဂV]ဂW^᠌X_᠌@`ဉIaဂPbဈYcဈZdဂ[eဂ\\f᠌]gဂShဉ^iဇ_j'kဂiÉဉfĭဂgĮဈh", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzbd", "zzC", "zzD", "zzbe", "zzbi", "zzbf", zziekVar, "zzE", "zzbg", "zzG", "zzbh", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzah", zzayj.class, "zzT", "zzU", "zzV", "zzW", "zzY", zziekVar2, "zzZ", zziekVar2, "zzag", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", zziekVar2, "zzai", "zzaj", "zzak", "zzal", "zzam", "zzap", "zzaq", "zzas", "zzat", zzayv.zza, "zzau", zzayz.zza, "zzar", "zzaw", zzaxn.zza, CbYNFSEGaQj.PnImQwT, "zzay", "zzan", "zzao", "zzaz", zziekVar2, "zzX", "zzF", "zzaA", zziekVar2, "zzaB", "zzaC", zzayd.class, "zzaD", zziekVar2, HcgZcEUYo.kJPulJsupfeQSG, zzaxp.class, "zzaF", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaR", "zzaS", "zzaT", "zzaU", "zzaV", zzaxz.zza, "zzav", zzaxr.zza, "zzaG", "zzaN", "zzaW", "zzaX", "zzaY", "zzaZ", "zzba", zzayb.zza, "zzaQ", "zzbb", "zzbc", "zzbm", "zzbn", "zzbj", "zzbk", "zzbl"});
        }
        return (byte) 1;
    }
}
