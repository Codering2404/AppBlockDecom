package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztr implements zzse {
    private static final AtomicInteger zza = new AtomicInteger();
    private long zzA;
    private long zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private long zzF;
    private float zzG;
    private ByteBuffer zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private boolean zzP;
    private zze zzQ;
    private AudioDeviceInfo zzR;
    private int zzS;
    private long zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private Handler zzY;
    private final zztm zzZ;
    private final Context zzb;
    private final zztg zzc;
    private final zzud zzd;
    private final zzcv zze;
    private final zzuc zzf;
    private final zzgwm zzg;
    private final ArrayDeque zzh;
    private zzti zzi;
    private final zztq zzj;
    private final zztq zzk;
    private zzqf zzl;
    private zzsb zzm;
    private zztl zzn;
    private zztl zzo;
    private zzck zzp;
    private final zzrf zzq;
    private zzrc zzr;
    private zzqv zzs;
    private zzd zzt;
    private zztp zzu;
    private zztp zzv;
    private zzav zzw;
    private boolean zzx;
    private long zzy;
    private long zzz;

    /* synthetic */ zztr(zztk zztkVar, byte[] bArr) {
        this.zzb = zztkVar.zzb() == null ? null : zztkVar.zzb().getApplicationContext();
        this.zzt = zzd.zza;
        this.zzZ = zztkVar.zzd();
        this.zzq = zztkVar.zzc();
        zztg zztgVar = new zztg();
        this.zzc = zztgVar;
        zzud zzudVar = new zzud();
        this.zzd = zzudVar;
        this.zze = new zzcv();
        this.zzf = new zzuc();
        this.zzg = zzgwm.zzk(zzudVar, zztgVar);
        this.zzG = 1.0f;
        this.zzO = 0;
        this.zzQ = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzv = new zztp(zzavVar, 0L, 0L, null);
        this.zzw = zzavVar;
        this.zzx = false;
        this.zzh = new ArrayDeque();
        this.zzj = new zztq();
        this.zzk = new zztq();
        int iZzah = -1;
        if (Build.VERSION.SDK_INT >= 34 && zztkVar.zzb() != null) {
            iZzah = zzah(zztkVar.zzb().getDeviceId());
        }
        this.zzS = iZzah;
    }

    static int zzE(int i3, ByteBuffer byteBuffer) {
        int i4;
        int i5;
        byte b3;
        int i6;
        int i7;
        if (i3 == 20) {
            return zzgv.zzb(byteBuffer);
        }
        if (i3 != 30) {
            switch (i3) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iZzb = zzagw.zzb(zzfl.zzM(byteBuffer, byteBuffer.position()));
                    if (iZzb != -1) {
                        return iZzb;
                    }
                    throw new IllegalArgumentException();
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i3) {
                        case 14:
                            int i8 = zzaey.zza;
                            int iPosition = byteBuffer.position();
                            int iLimit = byteBuffer.limit() - 10;
                            int i9 = iPosition;
                            while (true) {
                                if (i9 > iLimit) {
                                    i7 = -1;
                                } else if ((zzfl.zzM(byteBuffer, i9 + 4) & (-2)) == -126718022) {
                                    i7 = i9 - iPosition;
                                } else {
                                    i9++;
                                }
                            }
                            if (i7 == -1) {
                                return 0;
                            }
                            return (40 << ((byteBuffer.get((byteBuffer.position() + i7) + ((byteBuffer.get((byteBuffer.position() + i7) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            int i10 = zzafb.zza;
                            byte[] bArr = new byte[16];
                            int iPosition2 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(iPosition2);
                            return zzafb.zzb(new zzes(bArr, 16)).zzc;
                        case 18:
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 27);
                            sb.append("Unexpected audio encoding: ");
                            sb.append(i3);
                            throw new IllegalStateException(sb.toString());
                    }
                    break;
            }
            return zzaey.zze(byteBuffer);
        }
        int i11 = zzafx.zza;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition3 = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition3);
        if (b4 != -2) {
            if (b4 == -1) {
                i5 = (byteBuffer.get(iPosition3 + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition3 + 7);
            } else if (b4 != 31) {
                i5 = (byteBuffer.get(iPosition3 + 4) & 1) << 6;
                i6 = byteBuffer.get(iPosition3 + 5) & 252;
                i4 = (i6 >> 2) | i5;
            } else {
                i5 = (byteBuffer.get(iPosition3 + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition3 + 6);
            }
            i6 = b3 & 60;
            i4 = (i6 >> 2) | i5;
        } else {
            i4 = ((byteBuffer.get(iPosition3 + 5) & 1) << 6) | ((byteBuffer.get(iPosition3 + 4) & 252) >> 2);
        }
        return (i4 + 1) * 32;
    }

    static /* synthetic */ boolean zzH() {
        return zza.get() > 0;
    }

    private final void zzR() {
        zzck zzckVarZzk = this.zzo.zzk();
        this.zzp = zzckVarZzk;
        zzckVarZzk.zzb(zzcm.zza);
    }

    private final zzqv zzS(zzre zzreVar) throws zzsa {
        try {
            return ((zztd) this.zzq).zzf(zzreVar);
        } catch (zzrb e3) {
            zzsa zzsaVar = new zzsa(0, zzreVar.zzb, zzreVar.zzc, zzreVar.zza, zzreVar.zze, this.zzo.zzf(), false, e3);
            zzsb zzsbVar = this.zzm;
            if (zzsbVar == null) {
                throw zzsaVar;
            }
            zzsbVar.zza(zzsaVar);
            throw zzsaVar;
        }
    }

    private final void zzT(long j3) throws Exception {
        zzW(j3);
        if (this.zzJ != null) {
            return;
        }
        if (!this.zzp.zzc()) {
            ByteBuffer byteBuffer = this.zzH;
            if (byteBuffer != null) {
                zzV(byteBuffer);
                zzW(j3);
                return;
            }
            return;
        }
        while (!this.zzp.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzp.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzV(byteBufferZze);
                    zzW(j3);
                } else {
                    ByteBuffer byteBuffer2 = this.zzH;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzp.zzd(this.zzH);
                    }
                }
            } while (this.zzJ == null);
            return;
        }
    }

    private final boolean zzU() throws Exception {
        if (!this.zzp.zzc()) {
            zzW(Long.MIN_VALUE);
            return this.zzJ == null;
        }
        this.zzp.zzf();
        zzT(Long.MIN_VALUE);
        if (!this.zzp.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzJ;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzV(java.nio.ByteBuffer r29) {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztr.zzV(java.nio.ByteBuffer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzW(long r9) throws java.lang.Exception {
        /*
            r8 = this;
            java.nio.ByteBuffer r0 = r8.zzJ
            if (r0 != 0) goto L6
            goto Lbb
        L6:
            com.google.android.gms.internal.ads.zztq r0 = r8.zzk
            boolean r0 = r0.zzb()
            if (r0 != 0) goto Lbb
            java.nio.ByteBuffer r0 = r8.zzJ
            int r0 = r0.remaining()
            r1 = 0
            r3 = 1
            r4 = 0
            com.google.android.gms.internal.ads.zzqv r5 = r8.zzs     // Catch: com.google.android.gms.internal.ads.zzqu -> L83
            java.nio.ByteBuffer r6 = r8.zzJ     // Catch: com.google.android.gms.internal.ads.zzqu -> L83
            int r7 = r8.zzI     // Catch: com.google.android.gms.internal.ads.zzqu -> L83
            boolean r9 = r5.zzc(r6, r7, r9)     // Catch: com.google.android.gms.internal.ads.zzqu -> L83
            long r5 = android.os.SystemClock.elapsedRealtime()
            r8.zzT = r5
            com.google.android.gms.internal.ads.zztq r10 = r8.zzk
            r10.zzc()
            com.google.android.gms.internal.ads.zzqv r10 = r8.zzs
            boolean r10 = r10.zzg()
            if (r10 == 0) goto L49
            long r5 = r8.zzB
            int r10 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r10 <= 0) goto L3d
            r8.zzV = r4
        L3d:
            boolean r10 = r8.zzN
            if (r10 == 0) goto L49
            com.google.android.gms.internal.ads.zzsb r10 = r8.zzm
            if (r10 == 0) goto L49
            if (r9 != 0) goto L49
            com.google.android.gms.internal.ads.zztw r10 = (com.google.android.gms.internal.ads.zztw) r10
        L49:
            com.google.android.gms.internal.ads.zztl r10 = r8.zzo
            boolean r10 = r10.zze()
            if (r10 == 0) goto L5e
            long r1 = r8.zzA
            java.nio.ByteBuffer r10 = r8.zzJ
            int r10 = r10.remaining()
            int r0 = r0 - r10
            long r5 = (long) r0
            long r1 = r1 + r5
            r8.zzA = r1
        L5e:
            if (r9 == 0) goto Lbb
            com.google.android.gms.internal.ads.zztl r9 = r8.zzo
            boolean r9 = r9.zze()
            if (r9 != 0) goto L7f
            java.nio.ByteBuffer r9 = r8.zzJ
            java.nio.ByteBuffer r10 = r8.zzH
            if (r9 != r10) goto L6f
            goto L70
        L6f:
            r3 = r4
        L70:
            com.google.android.gms.internal.ads.zzgtj.zzi(r3)
            long r9 = r8.zzB
            int r0 = r8.zzC
            long r0 = (long) r0
            int r2 = r8.zzI
            long r2 = (long) r2
            long r0 = r0 * r2
            long r9 = r9 + r0
            r8.zzB = r9
        L7f:
            r9 = 0
            r8.zzJ = r9
            return
        L83:
            r9 = move-exception
            boolean r10 = r9.zzb
            if (r10 == 0) goto L9d
            long r5 = r8.zzae()
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 <= 0) goto L91
            goto L9e
        L91:
            com.google.android.gms.internal.ads.zzqv r0 = r8.zzs
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L9d
            r8.zzX()
            goto L9e
        L9d:
            r3 = r4
        L9e:
            int r9 = r9.zza
            com.google.android.gms.internal.ads.zzsd r0 = new com.google.android.gms.internal.ads.zzsd
            com.google.android.gms.internal.ads.zztl r1 = r8.zzo
            com.google.android.gms.internal.ads.zzv r1 = r1.zzf()
            r0.<init>(r9, r1, r3)
            com.google.android.gms.internal.ads.zzsb r9 = r8.zzm
            if (r9 == 0) goto Lb2
            r9.zza(r0)
        Lb2:
            if (r10 != 0) goto Lba
            com.google.android.gms.internal.ads.zztq r9 = r8.zzk
            r9.zza(r0)
            return
        Lba:
            throw r0
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztr.zzW(long):void");
    }

    private final void zzX() {
        this.zzo.zzj();
    }

    private final void zzY() {
        if (zzad()) {
            this.zzs.zzf(this.zzG);
        }
    }

    private final void zzZ() {
        if (this.zzo != null) {
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            try {
                this.zzo = new zztl(this.zzo.zzf(), this.zzo.zzg(), this.zzo.zzh(), this.zzo.zzi(), this.zzq.zzb(zzaf(this.zzo.zzg(), -1)), this.zzo.zzk(), null);
            } catch (zzqw e3) {
                throw new IllegalStateException(new zzrz(e3, this.zzo.zzf()));
            }
        }
        zzB();
    }

    private final void zzaa(zzav zzavVar) {
        zztp zztpVar = new zztp(zzavVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzad()) {
            this.zzu = zztpVar;
        } else {
            this.zzv = zztpVar;
        }
    }

    private final void zzab(long j3) {
        zzav zzavVar;
        boolean z2;
        if (zzac()) {
            zztm zztmVar = this.zzZ;
            zzavVar = this.zzw;
            zztmVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzw = zzavVar2;
        if (zzac()) {
            zztm zztmVar2 = this.zzZ;
            z2 = this.zzx;
            zztmVar2.zzc(z2);
        } else {
            z2 = false;
        }
        this.zzx = z2;
        this.zzh.add(new zztp(zzavVar2, Math.max(0L, j3), this.zzo.zzc(zzae()), null));
        zzR();
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzaz().zzh(this.zzx);
        }
    }

    private final boolean zzac() {
        if (!this.zzo.zze()) {
            return false;
        }
        int i3 = this.zzo.zzf().zzJ;
        return true;
    }

    private final boolean zzad() {
        return this.zzs != null;
    }

    private final long zzae() {
        if (!this.zzo.zze()) {
            return this.zzB;
        }
        long j3 = this.zzA;
        long jZzi = this.zzo.zzi();
        String str = zzfl.zza;
        return ((j3 + jZzi) - 1) / jZzi;
    }

    private final zzqy zzaf(zzv zzvVar, int i3) {
        zzqx zzqxVar = new zzqx(zzvVar);
        zzqxVar.zza(this.zzt);
        zzqxVar.zzb(this.zzR);
        zzqxVar.zzc(this.zzO);
        zzqxVar.zze(-1);
        zzqxVar.zzd(this.zzS);
        return new zzqy(zzqxVar, null);
    }

    private final void zzag() {
        if (this.zzL) {
            return;
        }
        this.zzL = true;
        if (this.zzs.zzg()) {
            this.zzM = false;
        }
        this.zzs.zzd();
    }

    private static int zzah(int i3) {
        if (i3 == 0 || i3 == -1) {
            return -1;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzA() {
        this.zzN = false;
        if (zzad()) {
            this.zzs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzB() {
        if (zzad()) {
            this.zzy = 0L;
            this.zzz = 0L;
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzV = false;
            this.zzC = 0;
            this.zzv = new zztp(this.zzw, 0L, 0L, null);
            this.zzF = 0L;
            this.zzu = null;
            this.zzh.clear();
            this.zzH = null;
            this.zzI = 0;
            this.zzJ = null;
            this.zzL = false;
            this.zzK = false;
            this.zzM = false;
            this.zzd.zzr();
            zzR();
            this.zzi = null;
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            zza.incrementAndGet();
            this.zzs.zze();
            this.zzs = null;
        }
        this.zzk.zzc();
        this.zzj.zzc();
        this.zzW = 0L;
        this.zzX = 0L;
        Handler handler = this.zzY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzC() {
        zzB();
        zzgwm zzgwmVar = this.zzg;
        int size = zzgwmVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzco) zzgwmVar.get(i3)).zzj();
        }
        this.zze.zzj();
        this.zzf.zzj();
        zzck zzckVar = this.zzp;
        if (zzckVar != null) {
            zzckVar.zzh();
        }
        this.zzN = false;
        this.zzU = false;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzD() {
        this.zzq.zze();
    }

    final /* synthetic */ void zzF() {
        if (this.zzX >= 300000) {
            ((zztw) this.zzm).zza.zzaB(true);
            this.zzX = 0L;
        }
    }

    final /* synthetic */ void zzG() {
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzT();
        }
    }

    final /* synthetic */ zzti zzJ() {
        return this.zzi;
    }

    final /* synthetic */ zzsb zzK() {
        return this.zzm;
    }

    final /* synthetic */ zztl zzL() {
        return this.zzo;
    }

    final /* synthetic */ zzqv zzM() {
        return this.zzs;
    }

    final /* synthetic */ boolean zzN() {
        return this.zzL;
    }

    final /* synthetic */ void zzO(boolean z2) {
        this.zzM = true;
    }

    final /* synthetic */ boolean zzP() {
        return this.zzN;
    }

    final /* synthetic */ long zzQ() {
        return this.zzT;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zza(zzsb zzsbVar) {
        this.zzm = zzsbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzb(zzqf zzqfVar) {
        this.zzl = zzqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzc(zzdo zzdoVar) {
        this.zzq.zzd(zzdoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final int zze(zzv zzvVar) {
        boolean z2;
        int i3 = zzvVar.zzJ;
        if (!zzfl.zzD(i3) || i3 == 2) {
            z2 = false;
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzI(2);
            zzvVar = zztVarZza.zzO();
            z2 = true;
        }
        int i4 = this.zzq.zza(zzaf(zzvVar, -1)).zzd;
        if (i4 == 1) {
            return 1;
        }
        if (i4 != 2) {
            return 0;
        }
        return z2 ? 1 : 2;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqs zzf(zzv zzvVar) {
        if (this.zzU) {
            return zzqs.zza;
        }
        zzra zzraVarZza = this.zzq.zza(zzaf(zzvVar, -1));
        zzqr zzqrVar = new zzqr();
        zzqrVar.zza(zzraVarZza.zza);
        zzqrVar.zzb(zzraVarZza.zzb);
        zzqrVar.zzc(zzraVarZza.zzc);
        return zzqrVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzg(boolean z2) {
        ArrayDeque arrayDeque;
        long j3;
        if (!zzad() || this.zzE) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzs.zzk(), this.zzo.zzc(zzae()));
        while (true) {
            arrayDeque = this.zzh;
            if (arrayDeque.isEmpty() || jMin < ((zztp) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzv = (zztp) arrayDeque.remove();
        }
        zztp zztpVar = this.zzv;
        long j4 = jMin - zztpVar.zzc;
        long jZzx = zzfl.zzx(j4, zztpVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzZ.zzd(j4);
            zztp zztpVar2 = this.zzv;
            j3 = zztpVar2.zzb + jZzd;
            zztpVar2.zzd = jZzd - jZzx;
        } else {
            zztp zztpVar3 = this.zzv;
            j3 = zztpVar3.zzb + jZzx + zztpVar3.zzd;
        }
        long jZze = this.zzZ.zze();
        long jZzc = j3 + this.zzo.zzc(jZze);
        long j5 = this.zzW;
        if (jZze > j5) {
            long jZzc2 = this.zzo.zzc(jZze - j5);
            this.zzW = jZze;
            this.zzX += jZzc2;
            if (this.zzY == null) {
                this.zzY = new Handler(Looper.myLooper());
            }
            this.zzY.removeCallbacksAndMessages(null);
            this.zzY.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzto
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzF();
                }
            }, 100L);
        }
        return jZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzh(zzrx zzrxVar) throws zzrz {
        int i3;
        zzv zzvVarZzO;
        zzck zzckVar;
        int iZzG;
        if (this.zzr == null && this.zzb != null) {
            zzrc zzrcVar = new zzrc() { // from class: com.google.android.gms.internal.ads.zztn
                @Override // com.google.android.gms.internal.ads.zzrc
                public final /* synthetic */ void zza() {
                    this.zza.zzG();
                }
            };
            this.zzr = zzrcVar;
            this.zzq.zzc(zzrcVar);
        }
        zzv zzvVar = zzrxVar.zza;
        if ("audio/raw".equals(zzvVar.zzp)) {
            int i4 = zzvVar.zzJ;
            zzgtj.zza(zzfl.zzD(i4));
            int i5 = zzvVar.zzH;
            int iZzG2 = zzfl.zzG(i4) * i5;
            zzgwj zzgwjVar = new zzgwj();
            zzgwjVar.zzh(this.zzg);
            zzgwjVar.zzf(this.zze);
            zzgwjVar.zzg(this.zzZ.zza());
            zzck zzckVar2 = new zzck(zzgwjVar.zzi());
            if (zzckVar2.equals(this.zzp)) {
                zzckVar2 = this.zzp;
            }
            this.zzd.zzq(zzvVar.zzK, zzvVar.zzL);
            this.zzc.zzq(zzrxVar.zzc);
            try {
                zzcl zzclVarZza = zzckVar2.zza(new zzcl(zzvVar.zzI, i5, i4));
                zzt zztVarZza = zzvVar.zza();
                int i6 = zzclVarZza.zzd;
                zztVarZza.zzI(i6);
                zztVarZza.zzH(zzclVarZza.zzb);
                int i7 = zzclVarZza.zzc;
                zztVarZza.zzG(i7);
                i3 = iZzG2;
                zzckVar = zzckVar2;
                zzvVarZzO = zztVarZza.zzO();
                iZzG = zzfl.zzG(i6) * i7;
            } catch (zzcn e3) {
                throw new zzrz(e3, zzvVar);
            }
        } else {
            i3 = -1;
            zzvVarZzO = zzvVar;
            zzckVar = new zzck(zzgwm.zzi());
            iZzG = -1;
        }
        zzqy zzqyVarZzaf = zzaf(zzvVarZzO, -1);
        try {
            zzre zzreVarZzb = this.zzq.zzb(zzqyVarZzaf);
            if (zzreVarZzb.zza == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(false).length() + 36);
                sb.append("Invalid output encoding (isOffload=");
                sb.append(false);
                sb.append(")");
                throw new zzrz(sb.toString(), zzqyVarZzaf.zza);
            }
            if (zzreVarZzb.zzc == 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(false).length() + 42);
                sb2.append("Invalid output channel config (isOffload=");
                sb2.append(false);
                sb2.append(")");
                throw new zzrz(sb2.toString(), zzqyVarZzaf.zza);
            }
            this.zzU = false;
            zztl zztlVar = new zztl(zzvVar, zzvVarZzO, i3, iZzG, zzreVarZzb, zzckVar, null);
            if (zzad()) {
                this.zzn = zztlVar;
            } else {
                this.zzo = zztlVar;
            }
        } catch (zzqw e4) {
            throw new zzrz(e4, zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzi() {
        this.zzN = true;
        if (zzad()) {
            this.zzs.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzj() {
        this.zzD = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    @Override // com.google.android.gms.internal.ads.zzse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.nio.ByteBuffer r19, long r20, int r22) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztr.zzk(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzl() throws zzsd {
        if (!this.zzK && zzad() && zzU()) {
            zzag();
            this.zzK = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzm() {
        if (zzad()) {
            return this.zzK && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzn() {
        if (!zzad()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.zzs.zzg() && this.zzM) {
            return false;
        }
        long jZzae = zzae();
        long jZzk = this.zzs.zzk();
        zzqv zzqvVar = this.zzs;
        zzqvVar.getClass();
        return jZzae > zzfl.zzu(jZzk, zzqvVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzo(zzav zzavVar) {
        float f3 = zzavVar.zzb;
        String str = zzfl.zza;
        zzav zzavVar2 = new zzav(Math.max(0.1f, Math.min(f3, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        this.zzw = zzavVar2;
        zzaa(zzavVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzav zzp() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzq(boolean z2) {
        this.zzx = z2;
        zzaa(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzr(zzd zzdVar) {
        if (this.zzt.equals(zzdVar)) {
            return;
        }
        this.zzt = zzdVar;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqh zzs() {
        zzrf zzrfVar = this.zzq;
        if (zzrfVar instanceof zztd) {
            return ((zztd) zzrfVar).zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzt(int i3) {
        if (this.zzP) {
            if (this.zzO != i3) {
                return;
            } else {
                this.zzP = false;
            }
        }
        if (this.zzO != i3) {
            this.zzO = i3;
            zzZ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzu(zze zzeVar) {
        if (this.zzQ.equals(zzeVar)) {
            return;
        }
        if (this.zzs != null) {
            int i3 = this.zzQ.zza;
        }
        this.zzQ = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzv(AudioDeviceInfo audioDeviceInfo) {
        this.zzR = audioDeviceInfo;
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzo(audioDeviceInfo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzw(int i3) {
        int i4 = this.zzS;
        int iZzah = zzah(i3);
        if (i4 == iZzah) {
            return;
        }
        this.zzS = iZzah;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzx() {
        if (!zzad()) {
            return -9223372036854775807L;
        }
        if (this.zzo.zze()) {
            return this.zzo.zzc(this.zzs.zzj());
        }
        long jZzj = this.zzs.zzj();
        int iZzf = zzagc.zzf(this.zzo.zzj().zza);
        zzgtj.zzi(iZzf != -2147483647);
        return zzfl.zzv(jZzj, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzy(int i3, int i4) {
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzz(float f3) {
        if (this.zzG != f3) {
            this.zzG = f3;
            zzY();
        }
    }
}
