package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakh implements zzafy {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzD;
    private zzakg zzE;
    private boolean zzF;
    private int zzG;
    private long zzH;
    private final SparseArray zzI;
    private boolean zzJ;
    private long zzK;
    private int zzL;
    private long zzM;
    private long zzN;
    private int zzO;
    private boolean zzP;
    private long zzQ;
    private long zzR;
    private long zzS;
    private boolean zzT;
    private int zzU;
    private long zzV;
    private long zzW;
    private int zzX;
    private int zzY;
    private int[] zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private int zzad;
    private boolean zzae;
    private long zzaf;
    private int zzag;
    private int zzah;
    private int zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private int zzam;
    private byte zzan;
    private boolean zzao;
    private zzagb zzap;
    private final zzaka zzaq;
    private final zzakj zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzanj zzl;
    private final zzet zzm;
    private final zzet zzn;
    private final zzet zzo;
    private final zzet zzp;
    private final zzet zzq;
    private final zzet zzr;
    private final zzet zzs;
    private final zzet zzt;
    private final zzet zzu;
    private final zzet zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i3 = zzakd.zza;
        zzb = new byte[]{Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        String str = zzfl.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(SensibleDefaults.X_OFFSET));
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzakh() {
        this(new zzaka(), 2, zzanj.zza);
    }

    private static int[] zzA(int[] iArr, int i3) {
        if (iArr == null) {
            return new int[i3];
        }
        int length = iArr.length;
        return length >= i3 ? iArr : new int[Math.max(length + length, i3)];
    }

    private final void zzB() {
        if (!this.zzD) {
            return;
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i3 >= sparseArray.size()) {
                zzagb zzagbVar = this.zzap;
                zzagbVar.getClass();
                zzagbVar.zzv();
                this.zzD = false;
                return;
            }
            if (((zzakg) sparseArray.valueAt(i3)).zzU) {
                return;
            } else {
                i3++;
            }
        }
    }

    @EnsuresNonNull
    private final void zzq(int i3) throws zzat {
        if (this.zzE != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 32);
        sb.append("Element ");
        sb.append(i3);
        sb.append(" must be in a TrackEntry");
        throw zzat.zzb(sb.toString(), null);
    }

    private final void zzr(int i3) throws zzat {
        if (this.zzJ) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
        sb.append("Element ");
        sb.append(i3);
        sb.append(" must be in a Cues");
        throw zzat.zzb(sb.toString(), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        if (r2.equals("S_TEXT/SSA") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r2.equals("S_TEXT/ASS") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        r2 = zzx(r11, "%01d:%02d:%02d:%02d", 10000);
        r3 = 21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2 A[SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzs(com.google.android.gms.internal.ads.zzakg r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.zzs(com.google.android.gms.internal.ads.zzakg, long, int, int, int):void");
    }

    private final void zzt(zzafz zzafzVar, int i3) throws IOException {
        zzet zzetVar = this.zzo;
        if (zzetVar.zze() >= i3) {
            return;
        }
        if (zzetVar.zzj() < i3) {
            int iZzj = zzetVar.zzj();
            zzetVar.zzc(Math.max(iZzj + iZzj, i3));
        }
        zzafzVar.zzc(zzetVar.zzi(), zzetVar.zze(), i3 - zzetVar.zze());
        zzetVar.zzf(i3);
    }

    @RequiresNonNull
    private final int zzu(zzafz zzafzVar, zzakg zzakgVar, int i3, boolean z2) throws IOException {
        int i4;
        String str = zzakgVar.zzc;
        if ("S_TEXT/UTF8".equals(str)) {
            zzw(zzafzVar, zzb, i3);
            int i5 = this.zzah;
            zzv();
            return i5;
        }
        if ("S_TEXT/ASS".equals(str) || "S_TEXT/SSA".equals(str)) {
            zzw(zzafzVar, zzd, i3);
            int i6 = this.zzah;
            zzv();
            return i6;
        }
        if ("S_TEXT/WEBVTT".equals(str)) {
            zzw(zzafzVar, zze, i3);
            int i7 = this.zzah;
            zzv();
            return i7;
        }
        if (zzakgVar.zzU) {
            zzakgVar.zzY.getClass();
            int i8 = zzafx.zza;
            zzet zzetVar = new zzet(i3);
            if (zzafzVar.zzh(zzetVar.zzi(), 0, i3, true)) {
                zzafzVar.zzl();
                if (zzafx.zza(zzetVar.zzr()) == 1 && zzetVar.zzd() >= 10) {
                    byte[] bArr = new byte[10];
                    zzetVar.zzm(bArr, 0, 10);
                    zzetVar.zzh(0);
                    int iZzc = zzafx.zzc(bArr);
                    if (zzetVar.zzd() >= iZzc + 4) {
                        zzetVar.zzk(iZzc);
                        if (zzafx.zza(zzetVar.zzB()) == 2) {
                            zzt zztVarZza = zzakgVar.zzY.zza();
                            zztVarZza.zzo("audio/vnd.dts.hd");
                            zzakgVar.zzY = zztVarZza.zzO();
                        }
                    }
                }
            }
            zzakgVar.zzX.zzA(zzakgVar.zzY);
            zzakgVar.zzU = false;
            zzB();
        }
        zzahk zzahkVar = zzakgVar.zzX;
        if (!this.zzaj) {
            if (zzakgVar.zzh) {
                this.zzac &= -1073741825;
                boolean z3 = this.zzak;
                int i9 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (!z3) {
                    zzet zzetVar2 = this.zzo;
                    zzafzVar.zzc(zzetVar2.zzi(), 0, 1);
                    this.zzag++;
                    if ((zzetVar2.zzi()[0] & 128) == 128) {
                        throw zzat.zzb("Extension bit is set in signal byte", null);
                    }
                    this.zzan = zzetVar2.zzi()[0];
                    this.zzak = true;
                }
                byte b3 = this.zzan;
                if ((b3 & 1) == 1) {
                    int i10 = b3 & 2;
                    this.zzac |= 1073741824;
                    if (!this.zzao) {
                        zzet zzetVar3 = this.zzt;
                        zzafzVar.zzc(zzetVar3.zzi(), 0, 8);
                        this.zzag += 8;
                        this.zzao = true;
                        zzet zzetVar4 = this.zzo;
                        if (i10 != 2) {
                            i9 = 0;
                        }
                        zzetVar4.zzi()[0] = (byte) (i9 | 8);
                        zzetVar4.zzh(0);
                        zzahkVar.zzd(zzetVar4, 1, 1);
                        this.zzah++;
                        zzetVar3.zzh(0);
                        zzahkVar.zzd(zzetVar3, 8, 1);
                        this.zzah += 8;
                    }
                    if (i10 == 2) {
                        if (!this.zzal) {
                            zzet zzetVar5 = this.zzo;
                            zzafzVar.zzc(zzetVar5.zzi(), 0, 1);
                            this.zzag++;
                            zzetVar5.zzh(0);
                            this.zzam = zzetVar5.zzs();
                            this.zzal = true;
                        }
                        int i11 = this.zzam * 4;
                        zzet zzetVar6 = this.zzo;
                        zzetVar6.zza(i11);
                        zzafzVar.zzc(zzetVar6.zzi(), 0, i11);
                        this.zzag += i11;
                        int i12 = (this.zzam >> 1) + 1;
                        int i13 = (i12 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i13) {
                            this.zzw = ByteBuffer.allocate(i13);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i12);
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i4 = this.zzam;
                            if (i14 >= i4) {
                                break;
                            }
                            int iZzH = zzetVar6.zzH();
                            int i16 = iZzH - i15;
                            if (i14 % 2 == 0) {
                                this.zzw.putShort((short) i16);
                            } else {
                                this.zzw.putInt(i16);
                            }
                            i14++;
                            i15 = iZzH;
                        }
                        int i17 = (i3 - this.zzag) - i15;
                        if ((i4 & 1) == 1) {
                            this.zzw.putInt(i17);
                        } else {
                            this.zzw.putShort((short) i17);
                            this.zzw.putInt(0);
                        }
                        zzet zzetVar7 = this.zzu;
                        zzetVar7.zzb(this.zzw.array(), i13);
                        zzahkVar.zzd(zzetVar7, i13, 1);
                        this.zzah += i13;
                    }
                }
            } else {
                byte[] bArr2 = zzakgVar.zzi;
                if (bArr2 != null) {
                    this.zzr.zzb(bArr2, bArr2.length);
                }
            }
            if (!"A_OPUS".equals(zzakgVar.zzc) ? zzakgVar.zzg > 0 : z2) {
                this.zzac |= 268435456;
                this.zzv.zza(0);
                int iZze = (this.zzr.zze() + i3) - this.zzag;
                zzet zzetVar8 = this.zzo;
                zzetVar8.zza(4);
                zzetVar8.zzi()[0] = (byte) ((iZze >> 24) & 255);
                zzetVar8.zzi()[1] = (byte) ((iZze >> 16) & 255);
                zzetVar8.zzi()[2] = (byte) ((iZze >> 8) & 255);
                zzetVar8.zzi()[3] = (byte) (iZze & 255);
                zzahkVar.zzd(zzetVar8, 4, 2);
                this.zzah += 4;
            }
            this.zzaj = true;
        }
        zzet zzetVar9 = this.zzr;
        int iZze2 = i3 + zzetVar9.zze();
        String str2 = zzakgVar.zzc;
        if (!"V_MPEG4/ISO/AVC".equals(str2) && !"V_MPEGH/ISO/HEVC".equals(str2)) {
            if (zzakgVar.zzT != null) {
                zzgtj.zzi(zzetVar9.zze() == 0);
                zzakgVar.zzT.zzb(zzafzVar);
            }
            while (true) {
                int i18 = this.zzag;
                if (i18 >= iZze2) {
                    break;
                }
                int iZzy = zzy(zzafzVar, zzahkVar, iZze2 - i18);
                this.zzag += iZzy;
                this.zzah += iZzy;
            }
        } else {
            zzet zzetVar10 = this.zzn;
            byte[] bArrZzi = zzetVar10.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i19 = zzakgVar.zzZ;
            int i20 = 4 - i19;
            while (this.zzag < iZze2) {
                int i21 = this.zzai;
                if (i21 == 0) {
                    int iMin = Math.min(i19, zzetVar9.zzd());
                    zzafzVar.zzc(bArrZzi, i20 + iMin, i19 - iMin);
                    if (iMin > 0) {
                        zzetVar9.zzm(bArrZzi, i20, iMin);
                    }
                    this.zzag += i19;
                    zzetVar10.zzh(0);
                    this.zzai = zzetVar10.zzH();
                    zzet zzetVar11 = this.zzm;
                    zzetVar11.zzh(0);
                    zzahkVar.zzc(zzetVar11, 4);
                    this.zzah += 4;
                } else {
                    int iZzy2 = zzy(zzafzVar, zzahkVar, i21);
                    this.zzag += iZzy2;
                    this.zzah += iZzy2;
                    this.zzai -= iZzy2;
                }
            }
        }
        if ("A_VORBIS".equals(zzakgVar.zzc)) {
            zzet zzetVar12 = this.zzp;
            zzetVar12.zzh(0);
            zzahkVar.zzc(zzetVar12, 4);
            this.zzah += 4;
        }
        int i22 = this.zzah;
        zzv();
        return i22;
    }

    private final void zzv() {
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = 0;
        this.zzaj = false;
        this.zzak = false;
        this.zzal = false;
        this.zzam = 0;
        this.zzan = (byte) 0;
        this.zzao = false;
        this.zzr.zza(0);
    }

    private final void zzw(zzafz zzafzVar, byte[] bArr, int i3) throws IOException {
        int length = bArr.length;
        int i4 = length + i3;
        zzet zzetVar = this.zzs;
        if (zzetVar.zzj() < i4) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i4 + i3);
            zzetVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzetVar.zzi(), 0, length);
        }
        zzafzVar.zzc(zzetVar.zzi(), length, i3);
        zzetVar.zzh(0);
        zzetVar.zzf(i4);
    }

    private static byte[] zzx(long j3, String str, long j4) {
        zzgtj.zza(j3 != -9223372036854775807L);
        Locale locale = Locale.US;
        int i3 = (int) (j3 / 3600000000L);
        Integer numValueOf = Integer.valueOf(i3);
        long j5 = j3 - (((long) i3) * 3600000000L);
        int i4 = (int) (j5 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i4);
        long j6 = j5 - (((long) i4) * 60000000);
        int i5 = (int) (j6 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i5), Integer.valueOf((int) ((j6 - (((long) i5) * 1000000)) / j4)));
        String str3 = zzfl.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private final int zzy(zzafz zzafzVar, zzahk zzahkVar, int i3) throws IOException {
        zzet zzetVar = this.zzr;
        int iZzd = zzetVar.zzd();
        if (iZzd <= 0) {
            return zzahkVar.zza(zzafzVar, i3, false);
        }
        int iMin = Math.min(i3, iZzd);
        zzahkVar.zzc(zzetVar, iMin);
        return iMin;
    }

    private final long zzz(long j3) throws zzat {
        long j4 = this.zzz;
        if (j4 != -9223372036854775807L) {
            return zzfl.zzv(j3, j4, 1000L, RoundingMode.DOWN);
        }
        throw zzat.zzb("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return new zzaki().zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if (this.zzk) {
            zzagbVar = new zzanm(zzagbVar, this.zzl);
        }
        this.zzap = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        int i3 = 0;
        this.zzT = false;
        while (!this.zzT) {
            boolean zZzc = this.zzaq.zzc(zzafzVar);
            if (zZzc) {
                long jZzn = zzafzVar.zzn();
                if (this.zzP) {
                    this.zzR = jZzn;
                    zzagyVar.zza = this.zzQ;
                    this.zzP = false;
                    return 1;
                }
                if (this.zzF) {
                    long j3 = this.zzR;
                    if (j3 != -1) {
                        zzagyVar.zza = j3;
                        this.zzR = -1L;
                        return 1;
                    }
                }
            }
            if (!zZzc) {
                while (true) {
                    SparseArray sparseArray = this.zzi;
                    if (i3 >= sparseArray.size()) {
                        return -1;
                    }
                    zzakg zzakgVar = (zzakg) sparseArray.valueAt(i3);
                    zzakgVar.zzb();
                    zzahl zzahlVar = zzakgVar.zzT;
                    if (zzahlVar != null) {
                        zzahlVar.zzd(zzakgVar.zzX, zzakgVar.zzj);
                    }
                    i3++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        this.zzS = -9223372036854775807L;
        int i3 = 0;
        this.zzU = 0;
        this.zzaq.zzb();
        this.zzh.zza();
        zzv();
        this.zzJ = false;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1L;
        if (!this.zzF) {
            this.zzI.clear();
        }
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i3 >= sparseArray.size()) {
                return;
            }
            zzahl zzahlVar = ((zzakg) sparseArray.valueAt(i3)).zzT;
            if (zzahlVar != null) {
                zzahlVar.zza();
            }
            i3++;
        }
    }

    protected final void zzh(int i3, long j3, long j4) throws zzat {
        zzagb zzagbVar = this.zzap;
        zzagbVar.getClass();
        if (i3 == 160) {
            this.zzae = false;
            this.zzaf = 0L;
            return;
        }
        if (i3 == 174) {
            zzakg zzakgVar = new zzakg();
            this.zzE = zzakgVar;
            zzakgVar.zza = this.zzC;
            return;
        }
        if (i3 == 183) {
            if (this.zzF) {
                return;
            }
            zzr(i3);
            this.zzL = -1;
            this.zzM = -1L;
            this.zzN = -1L;
            return;
        }
        if (i3 == 187) {
            if (this.zzF) {
                return;
            }
            zzr(i3);
            this.zzK = -9223372036854775807L;
            return;
        }
        if (i3 == 19899) {
            this.zzG = -1;
            this.zzH = -1L;
            return;
        }
        if (i3 == 20533) {
            zzq(i3);
            this.zzE.zzh = true;
            return;
        }
        if (i3 == 408125543) {
            long j5 = this.zzy;
            if (j5 != -1 && j5 != j3) {
                throw zzat.zzb("Multiple Segment elements not supported", null);
            }
            this.zzy = j3;
            this.zzx = j4;
            return;
        }
        if (i3 == 475249515) {
            if (this.zzF) {
                return;
            }
            this.zzJ = true;
        } else if (i3 == 524531317 && !this.zzF) {
            if (this.zzj && this.zzQ != -1) {
                this.zzP = true;
            } else {
                zzagbVar.zzw(new zzaha(this.zzB, 0L));
                this.zzF = true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        r23 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        r39.zzap.zzw(new com.google.android.gms.internal.ads.zzaha(r39.zzB, 0));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzi(int r40) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.zzi(int):void");
    }

    protected final void zzj(int i3, long j3) throws zzat {
        boolean z2;
        if (i3 == 240) {
            if (this.zzF) {
                return;
            }
            zzr(i3);
            if (this.zzN == -1) {
                this.zzN = j3;
                return;
            }
            return;
        }
        if (i3 == 241) {
            if (this.zzF) {
                return;
            }
            zzr(i3);
            if (this.zzM == -1) {
                this.zzM = j3;
                return;
            }
            return;
        }
        if (i3 == 20529) {
            if (j3 == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 35);
            sb.append("ContentEncodingOrder ");
            sb.append(j3);
            sb.append(" not supported");
            throw zzat.zzb(sb.toString(), null);
        }
        if (i3 == 20530) {
            if (j3 == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(j3).length() + 35);
            sb2.append("ContentEncodingScope ");
            sb2.append(j3);
            sb2.append(" not supported");
            throw zzat.zzb(sb2.toString(), null);
        }
        switch (i3) {
            case 131:
                int i4 = (int) j3;
                if (i4 == 1) {
                    zzq(i3);
                    this.zzE.zze = 2;
                    return;
                }
                if (i4 == 2) {
                    zzq(i3);
                    this.zzE.zze = 1;
                    return;
                } else if (i4 == 17) {
                    zzq(i3);
                    this.zzE.zze = 3;
                    return;
                } else if (i4 != 33) {
                    zzq(i3);
                    this.zzE.zze = -1;
                    return;
                } else {
                    zzq(i3);
                    this.zzE.zze = 5;
                    return;
                }
            case 136:
                z2 = j3 == 1;
                zzq(i3);
                this.zzE.zzW = z2;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                this.zzW = zzz(j3);
                return;
            case 159:
                zzq(i3);
                this.zzE.zzO = (int) j3;
                return;
            case 176:
                zzq(i3);
                this.zzE.zzm = (int) j3;
                return;
            case 179:
                if (this.zzF) {
                    return;
                }
                zzr(i3);
                this.zzK = zzz(j3);
                return;
            case 186:
                zzq(i3);
                this.zzE.zzn = (int) j3;
                return;
            case 215:
                zzq(i3);
                this.zzE.zzd = (int) j3;
                return;
            case 231:
                this.zzS = zzz(j3);
                return;
            case 238:
                this.zzad = (int) j3;
                return;
            case 247:
                if (this.zzF) {
                    return;
                }
                zzr(i3);
                this.zzL = (int) j3;
                return;
            case 251:
                this.zzae = true;
                return;
            case 16871:
                zzq(i3);
                this.zzE.zzd((int) j3);
                return;
            case 16980:
                if (j3 == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j3).length() + 30);
                sb3.append("ContentCompAlgo ");
                sb3.append(j3);
                sb3.append(" not supported");
                throw zzat.zzb(sb3.toString(), null);
            case 17029:
                if (j3 < 1 || j3 > 2) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j3).length() + 33);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j3);
                    sb4.append(" not supported");
                    throw zzat.zzb(sb4.toString(), null);
                }
                return;
            case 17143:
                if (j3 == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j3).length() + 30);
                sb5.append("EBMLReadVersion ");
                sb5.append(j3);
                sb5.append(" not supported");
                throw zzat.zzb(sb5.toString(), null);
            case 18401:
                if (j3 == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(j3).length() + 29);
                sb6.append("ContentEncAlgo ");
                sb6.append(j3);
                sb6.append(" not supported");
                throw zzat.zzb(sb6.toString(), null);
            case 18408:
                if (j3 == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(j3).length() + 36);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j3);
                sb7.append(" not supported");
                throw zzat.zzb(sb7.toString(), null);
            case 21420:
                this.zzH = j3 + this.zzy;
                return;
            case 21432:
                int i5 = (int) j3;
                zzq(i3);
                if (i5 == 0) {
                    this.zzE.zzx = 0;
                    return;
                }
                if (i5 == 1) {
                    this.zzE.zzx = 2;
                    return;
                } else if (i5 == 3) {
                    this.zzE.zzx = 1;
                    return;
                } else {
                    if (i5 != 15) {
                        return;
                    }
                    this.zzE.zzx = 3;
                    return;
                }
            case 21680:
                zzq(i3);
                this.zzE.zzp = (int) j3;
                return;
            case 21682:
                zzq(i3);
                this.zzE.zzr = (int) j3;
                return;
            case 21690:
                zzq(i3);
                this.zzE.zzq = (int) j3;
                return;
            case 21930:
                z2 = j3 == 1;
                zzq(i3);
                this.zzE.zzV = z2;
                return;
            case 21938:
                zzq(i3);
                this.zzE.zzo = (int) j3;
                return;
            case 21998:
                zzq(i3);
                this.zzE.zzg = (int) j3;
                return;
            case 22186:
                zzq(i3);
                this.zzE.zzR = j3;
                return;
            case 22203:
                zzq(i3);
                this.zzE.zzS = j3;
                return;
            case 25188:
                zzq(i3);
                this.zzE.zzP = (int) j3;
                return;
            case 30114:
                this.zzaf = j3;
                return;
            case 30321:
                int i6 = (int) j3;
                zzq(i3);
                if (i6 == 0) {
                    this.zzE.zzs = 0;
                    return;
                }
                if (i6 == 1) {
                    this.zzE.zzs = 1;
                    return;
                } else if (i6 == 2) {
                    this.zzE.zzs = 2;
                    return;
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    this.zzE.zzs = 3;
                    return;
                }
            case 2352003:
                zzq(i3);
                this.zzE.zzf = (int) j3;
                return;
            case 2807729:
                this.zzz = j3;
                return;
            default:
                switch (i3) {
                    case 21945:
                        int i7 = (int) j3;
                        zzq(i3);
                        if (i7 == 1) {
                            this.zzE.zzA = 2;
                            return;
                        } else {
                            if (i7 != 2) {
                                return;
                            }
                            this.zzE.zzA = 1;
                            return;
                        }
                    case 21946:
                        zzq(i3);
                        int iZzc = zzi.zzc((int) j3);
                        if (iZzc != -1) {
                            this.zzE.zzz = iZzc;
                            return;
                        }
                        return;
                    case 21947:
                        zzq(i3);
                        int iZzb = zzi.zzb((int) j3);
                        if (iZzb != -1) {
                            this.zzE.zzy = iZzb;
                            return;
                        }
                        return;
                    case 21948:
                        zzq(i3);
                        this.zzE.zzB = (int) j3;
                        return;
                    case 21949:
                        zzq(i3);
                        this.zzE.zzC = (int) j3;
                        return;
                    default:
                        return;
                }
        }
    }

    protected final void zzk(int i3, double d3) throws zzat {
        if (i3 == 181) {
            zzq(i3);
            this.zzE.zzQ = (int) d3;
            return;
        }
        if (i3 == 17545) {
            this.zzA = (long) d3;
            return;
        }
        switch (i3) {
            case 21969:
                zzq(i3);
                this.zzE.zzD = (float) d3;
                break;
            case 21970:
                zzq(i3);
                this.zzE.zzE = (float) d3;
                break;
            case 21971:
                zzq(i3);
                this.zzE.zzF = (float) d3;
                break;
            case 21972:
                zzq(i3);
                this.zzE.zzG = (float) d3;
                break;
            case 21973:
                zzq(i3);
                this.zzE.zzH = (float) d3;
                break;
            case 21974:
                zzq(i3);
                this.zzE.zzI = (float) d3;
                break;
            case 21975:
                zzq(i3);
                this.zzE.zzJ = (float) d3;
                break;
            case 21976:
                zzq(i3);
                this.zzE.zzK = (float) d3;
                break;
            case 21977:
                zzq(i3);
                this.zzE.zzL = (float) d3;
                break;
            case 21978:
                zzq(i3);
                this.zzE.zzM = (float) d3;
                break;
            default:
                switch (i3) {
                    case 30323:
                        zzq(i3);
                        this.zzE.zzt = (float) d3;
                        break;
                    case 30324:
                        zzq(i3);
                        this.zzE.zzu = (float) d3;
                        break;
                    case 30325:
                        zzq(i3);
                        this.zzE.zzv = (float) d3;
                        break;
                }
                break;
        }
    }

    protected final void zzl(int i3, String str) throws zzat {
        if (i3 == 134) {
            zzq(i3);
            this.zzE.zzc = str;
            return;
        }
        if (i3 != 17026) {
            if (i3 == 21358) {
                zzq(i3);
                this.zzE.zzb = str;
                return;
            } else {
                if (i3 != 2274716) {
                    return;
                }
                zzq(i3);
                this.zzE.zze(str);
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.zzC = Objects.equals(str, "webm");
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw zzat.zzb(sb.toString(), null);
    }

    protected final void zzm(int i3, int i4, zzafz zzafzVar) throws IOException {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i3;
        int i17 = 2;
        int i18 = 1;
        int i19 = 0;
        if (i16 != 161 && i16 != 163) {
            if (i16 == 165) {
                if (this.zzU != 2) {
                    return;
                }
                zzakg zzakgVar = (zzakg) this.zzi.get(this.zzaa);
                if (this.zzad != 4 || !"V_VP9".equals(zzakgVar.zzc)) {
                    zzafzVar.zzf(i4);
                    return;
                }
                zzet zzetVar = this.zzv;
                zzetVar.zza(i4);
                zzafzVar.zzc(zzetVar.zzi(), 0, i4);
                return;
            }
            if (i16 == 16877) {
                zzq(i3);
                zzakg zzakgVar2 = this.zzE;
                if (zzakgVar2.zzc() != 1685485123 && zzakgVar2.zzc() != 1685480259) {
                    zzafzVar.zzf(i4);
                    return;
                }
                byte[] bArr = new byte[i4];
                zzakgVar2.zzN = bArr;
                zzafzVar.zzc(bArr, 0, i4);
                return;
            }
            if (i16 == 16981) {
                zzq(i3);
                byte[] bArr2 = new byte[i4];
                this.zzE.zzi = bArr2;
                zzafzVar.zzc(bArr2, 0, i4);
                return;
            }
            if (i16 == 18402) {
                byte[] bArr3 = new byte[i4];
                zzafzVar.zzc(bArr3, 0, i4);
                zzq(i3);
                this.zzE.zzj = new zzahj(1, bArr3, 0, 0);
                return;
            }
            if (i16 == 21419) {
                zzet zzetVar2 = this.zzq;
                Arrays.fill(zzetVar2.zzi(), (byte) 0);
                zzafzVar.zzc(zzetVar2.zzi(), 4 - i4, i4);
                zzetVar2.zzh(0);
                this.zzG = (int) zzetVar2.zzz();
                return;
            }
            if (i16 == 25506) {
                zzq(i3);
                byte[] bArr4 = new byte[i4];
                this.zzE.zzk = bArr4;
                zzafzVar.zzc(bArr4, 0, i4);
                return;
            }
            if (i16 != 30322) {
                StringBuilder sb = new StringBuilder(String.valueOf(i16).length() + 15);
                sb.append("Unexpected id: ");
                sb.append(i16);
                throw zzat.zzb(sb.toString(), null);
            }
            zzq(i3);
            byte[] bArr5 = new byte[i4];
            this.zzE.zzw = bArr5;
            zzafzVar.zzc(bArr5, 0, i4);
            return;
        }
        int i20 = 8;
        if (this.zzU == 0) {
            zzakj zzakjVar = this.zzh;
            this.zzaa = (int) zzakjVar.zzb(zzafzVar, false, true, 8);
            this.zzab = zzakjVar.zzc();
            this.zzW = -9223372036854775807L;
            this.zzU = 1;
            this.zzo.zza(0);
        }
        zzakg zzakgVar3 = (zzakg) this.zzi.get(this.zzaa);
        if (zzakgVar3 == null) {
            zzafzVar.zzf(i4 - this.zzab);
            this.zzU = 0;
            return;
        }
        zzakgVar3.zzb();
        if (this.zzU == 1) {
            zzt(zzafzVar, 3);
            zzet zzetVar3 = this.zzo;
            int i21 = (zzetVar3.zzi()[2] & 6) >> 1;
            if (i21 == 0) {
                this.zzY = 1;
                int[] iArrZzA = zzA(this.zzZ, 1);
                this.zzZ = iArrZzA;
                iArrZzA[0] = (i4 - this.zzab) - 3;
            } else {
                zzt(zzafzVar, 4);
                int i22 = (zzetVar3.zzi()[3] & 255) + 1;
                this.zzY = i22;
                int[] iArrZzA2 = zzA(this.zzZ, i22);
                this.zzZ = iArrZzA2;
                if (i21 == 2) {
                    int i23 = (i4 - this.zzab) - 4;
                    int i24 = this.zzY;
                    Arrays.fill(iArrZzA2, 0, i24, i23 / i24);
                } else {
                    if (i21 != 1) {
                        if (i21 != 3) {
                            throw zzat.zzb("Unexpected lacing value: 2", null);
                        }
                        int i25 = 0;
                        int i26 = 0;
                        int i27 = 4;
                        while (true) {
                            int i28 = this.zzY - 1;
                            if (i25 >= i28) {
                                i6 = i17;
                                i7 = i18;
                                i8 = i19;
                                this.zzZ[i28] = ((i4 - this.zzab) - i27) - i26;
                                break;
                            }
                            this.zzZ[i25] = i19;
                            int i29 = i27 + 1;
                            zzt(zzafzVar, i29);
                            if (zzetVar3.zzi()[i27] == 0) {
                                throw zzat.zzb("No valid varint length mask found", null);
                            }
                            int i30 = i19;
                            while (true) {
                                if (i19 >= i20) {
                                    i9 = i17;
                                    i10 = i18;
                                    i11 = i20;
                                    j3 = 0;
                                    break;
                                }
                                i11 = i20;
                                int i31 = i18 << (7 - i19);
                                if ((zzetVar3.zzi()[i27] & i31) != 0) {
                                    i29 += i19;
                                    zzt(zzafzVar, i29);
                                    int i32 = i27 + 1;
                                    int i33 = zzetVar3.zzi()[i27] & 255 & (~i31);
                                    int i34 = i17;
                                    j3 = i33;
                                    i9 = i34;
                                    int i35 = i32;
                                    while (i35 < i29) {
                                        j3 = (j3 << i11) | ((long) (zzetVar3.zzi()[i35] & 255));
                                        i18 = i18;
                                        i35++;
                                        i19 = i19;
                                    }
                                    i10 = i18;
                                    int i36 = i19;
                                    if (i25 > 0) {
                                        j3 -= (1 << ((i36 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i19++;
                                    i20 = i11;
                                }
                            }
                            if (j3 < -2147483648L || j3 > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzZ;
                            int i37 = (int) j3;
                            if (i25 != 0) {
                                i37 += iArr[i25 - 1];
                            }
                            iArr[i25] = i37;
                            i26 += i37;
                            i25++;
                            i27 = i29;
                            i19 = i30;
                            i17 = i9;
                            i20 = i11;
                            i18 = i10;
                        }
                        throw zzat.zzb("EBML lacing sample size out of range.", null);
                    }
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 4;
                    while (true) {
                        i12 = this.zzY - 1;
                        if (i38 >= i12) {
                            break;
                        }
                        this.zzZ[i38] = 0;
                        while (true) {
                            i13 = i40 + 1;
                            zzt(zzafzVar, i13);
                            int i41 = zzetVar3.zzi()[i40] & 255;
                            int[] iArr2 = this.zzZ;
                            i14 = iArr2[i38] + i41;
                            iArr2[i38] = i14;
                            if (i41 != 255) {
                                break;
                            } else {
                                i40 = i13;
                            }
                        }
                        i39 += i14;
                        i38++;
                        i40 = i13;
                    }
                    this.zzZ[i12] = ((i4 - this.zzab) - i40) - i39;
                }
            }
            i6 = 2;
            i7 = 1;
            i8 = 0;
            this.zzV = this.zzS + zzz((zzetVar3.zzi()[i8] << 8) | (zzetVar3.zzi()[i7] & 255));
            if (zzakgVar3.zze == i7) {
                i15 = 1;
                this.zzac = i15;
                this.zzU = i6;
                this.zzX = i8;
                i5 = 163;
            } else {
                if (i16 != 163) {
                    i15 = i8;
                } else if ((zzetVar3.zzi()[i6] & 128) == 128) {
                    i16 = 163;
                    i15 = 1;
                } else {
                    i15 = i8;
                    i16 = 163;
                }
                this.zzac = i15;
                this.zzU = i6;
                this.zzX = i8;
                i5 = 163;
            }
        } else {
            i5 = 163;
        }
        if (i16 == i5) {
            while (true) {
                int i42 = this.zzX;
                if (i42 >= this.zzY) {
                    this.zzU = 0;
                    return;
                }
                int iZzu = zzu(zzafzVar, zzakgVar3, this.zzZ[i42], false);
                zzakg zzakgVar4 = zzakgVar3;
                zzs(zzakgVar4, this.zzV + ((long) ((this.zzX * zzakgVar3.zzf) / 1000)), this.zzac, iZzu, 0);
                this.zzX++;
                zzakgVar3 = zzakgVar4;
            }
        } else {
            while (true) {
                int i43 = this.zzX;
                if (i43 >= this.zzY) {
                    return;
                }
                int[] iArr3 = this.zzZ;
                iArr3[i43] = zzu(zzafzVar, zzakgVar3, iArr3[i43], true);
                this.zzX++;
            }
        }
    }

    zzakh(zzaka zzakaVar, int i3, zzanj zzanjVar) {
        this.zzy = -1L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzK = -9223372036854775807L;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1L;
        this.zzO = -1;
        this.zzQ = -1L;
        this.zzR = -1L;
        this.zzS = -9223372036854775807L;
        this.zzaq = zzakaVar;
        zzakaVar.zza(new zzakc(this, null));
        this.zzl = zzanjVar;
        this.zzI = new SparseArray();
        this.zzj = 1 == ((i3 & 1) ^ 1);
        this.zzk = (i3 & 2) == 0;
        this.zzh = new zzakj();
        this.zzi = new SparseArray();
        this.zzo = new zzet(4);
        this.zzp = new zzet(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzet(4);
        this.zzm = new zzet(zzgp.zza);
        this.zzn = new zzet(4);
        this.zzr = new zzet();
        this.zzs = new zzet();
        this.zzt = new zzet(8);
        this.zzu = new zzet();
        this.zzv = new zzet();
        this.zzZ = new int[1];
        this.zzD = true;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public zzakh(zzanj zzanjVar, int i3) {
        this(new zzaka(), 0, zzanjVar);
    }
}
