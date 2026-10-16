package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.applovin.sdk.AppLovinEventTypes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztx extends zzvt implements zzmb {
    private final Context zzb;
    private final zzru zzc;
    private final zzse zzd;
    private final zzvf zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzv zzi;
    private zzv zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztx(Context context, zzvh zzvhVar, zzvv zzvvVar, boolean z2, Handler handler, zzrv zzrvVar, zzse zzseVar) {
        super(context.getApplicationContext(), 1, zzvhVar, zzvvVar, false, 44100.0f);
        zzvf zzvfVar = Build.VERSION.SDK_INT >= 35 ? new zzvf(zzve.zzb) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzseVar;
        this.zze = zzvfVar;
        this.zzp = -1000;
        this.zzc = new zzru(handler, zzrvVar);
        this.zzr = -9223372036854775807L;
        zzseVar.zza(new zztw(this, null));
    }

    private static List zzbm(zzvv zzvvVar, zzv zzvVar, boolean z2, zzse zzseVar) throws zzvx {
        zzvm zzvmVarZza;
        return zzvVar.zzp == null ? zzgwm.zzi() : (!zzseVar.zzd(zzvVar) || (zzvmVarZza = zzwf.zza()) == null) ? zzwf.zzc(zzvvVar, zzvVar, false, false) : zzgwm.zzj(zzvmVarZza);
    }

    private final int zzbn(zzvm zzvmVar, zzv zzvVar) {
        "OMX.google.raw.decoder".equals(zzvmVar.zza);
        return zzvVar.zzq;
    }

    private final void zzbo() {
        long jZzg = this.zzd.zzg(zzab());
        if (jZzg != Long.MIN_VALUE) {
            if (!this.zzl) {
                jZzg = Math.max(this.zzk, jZzg);
            }
            this.zzk = jZzg;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzA(long j3, boolean z2, boolean z3) throws zzjk {
        super.zzA(j3, z2, z3);
        this.zzd.zzB();
        this.zzk = j3;
        this.zzr = -9223372036854775807L;
        this.zzn = false;
        this.zzo = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzB() {
        this.zzd.zzi();
        this.zzq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzC() {
        zzbo();
        this.zzq = false;
        this.zzd.zzA();
        this.zzo = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzD() {
        this.zzm = true;
        this.zzi = null;
        this.zzr = -9223372036854775807L;
        this.zzo = false;
        try {
            this.zzd.zzB();
            super.zzD();
        } catch (Throwable th) {
            super.zzD();
            throw th;
        } finally {
            this.zzc.zzg(((zzvt) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzE() {
        this.zzn = false;
        this.zzo = false;
        this.zzr = -9223372036854775807L;
        try {
            super.zzE();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzC();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzC();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzF() {
        zzvf zzvfVar;
        this.zzd.zzD();
        if (Build.VERSION.SDK_INT < 35 || (zzvfVar = this.zze) == null) {
            return;
        }
        zzvfVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    final /* synthetic */ zzvf zzaA() {
        return this.zze;
    }

    final /* synthetic */ void zzaB(boolean z2) {
        this.zzn = true;
    }

    final /* synthetic */ void zzaC(boolean z2) {
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzaa() {
        return this.zzd.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzab() {
        return super.zzab() && this.zzd.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final int zzae(zzvv zzvvVar, zzv zzvVar) throws zzvx {
        int i3;
        boolean z2;
        String str = zzvVar.zzp;
        boolean zZza = zzas.zza(str);
        int i4 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (!zZza) {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = zzvVar.zzO;
        boolean zZzbj = zzvt.zzbj(zzvVar);
        int i6 = 1;
        if (!zZzbj || (i5 != 0 && zzwf.zza() == null)) {
            i3 = 0;
        } else {
            zzse zzseVar = this.zzd;
            zzqs zzqsVarZzf = zzseVar.zzf(zzvVar);
            if (zzqsVarZzf.zzb) {
                i3 = true != zzqsVarZzf.zzc ? 512 : 1536;
                if (zzqsVarZzf.zzd) {
                    i3 |= 2048;
                }
            } else {
                i3 = 0;
            }
            if (zzseVar.zzd(zzvVar)) {
                return i3 | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzd(zzvVar)) {
            zzse zzseVar2 = this.zzd;
            if (zzseVar2.zzd(zzfl.zzA(2, zzvVar.zzH, zzvVar.zzI))) {
                List listZzbm = zzbm(zzvvVar, zzvVar, false, zzseVar2);
                if (!listZzbm.isEmpty()) {
                    if (zZzbj) {
                        zzvm zzvmVar = (zzvm) listZzbm.get(0);
                        Context context = this.zzb;
                        boolean zZzc = zzvmVar.zzc(context, zzvVar);
                        if (zZzc) {
                            z2 = true;
                        } else {
                            for (int i7 = 1; i7 < listZzbm.size(); i7++) {
                                zzvm zzvmVar2 = (zzvm) listZzbm.get(i7);
                                if (zzvmVar2.zzc(context, zzvVar)) {
                                    z2 = false;
                                    zZzc = true;
                                    zzvmVar = zzvmVar2;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        int i8 = true != zZzc ? 3 : 4;
                        int i9 = 8;
                        if (zZzc && zzvmVar.zze(zzvVar)) {
                            i9 = 16;
                        }
                        int i10 = true != zzvmVar.zzg ? 0 : 64;
                        if (true != z2) {
                            i4 = 0;
                        }
                        return i8 | i9 | 32 | i10 | i4 | i3;
                    }
                    i6 = 2;
                }
            }
        }
        return i6 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z2) throws zzvx {
        return zzwf.zze(this.zzb, zzbm(zzvvVar, zzvVar, false, this.zzd), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzag(zzv zzvVar) {
        zzK();
        return this.zzd.zzd(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        int i3;
        int i4;
        zzjc zzjcVarZzf = zzvmVar.zzf(zzvVar, zzvVar2);
        int i5 = zzjcVarZzf.zze;
        if (zzaF(zzvVar2)) {
            i5 |= 32768;
        }
        if (zzbn(zzvmVar, zzvVar2) > this.zzf) {
            i5 |= 64;
        }
        String str = zzvmVar.zza;
        if (i5 != 0) {
            i4 = 0;
            i3 = i5;
        } else {
            i3 = 0;
            i4 = zzjcVarZzf.zzd;
        }
        return new zzjc(str, zzvVar, zzvVar2, i4, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final long zzaj(long j3, long j4, boolean z2) {
        zzse zzseVar = this.zzd;
        boolean z3 = false;
        if (zzseVar.zzn() && this.zzr != -9223372036854775807L) {
            z3 = true;
        }
        if (!this.zzq) {
            return (z3 || super.zzab()) ? 1000000L : 10000L;
        }
        long jZzx = zzseVar.zzx();
        if (this.zzo && z3 && jZzx != -9223372036854775807L) {
            return Math.max(10000L, (long) ((Math.min(jZzx, this.zzr - j3) / (zzj() != null ? zzj().zzb : 1.0f)) / 2.0f));
        }
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final float zzak(float f3, zzv zzvVar, zzv[] zzvVarArr) {
        int iMax = -1;
        for (zzv zzvVar2 : zzvVarArr) {
            int i3 = zzvVar2.zzI;
            if (i3 != -1) {
                iMax = Math.max(iMax, i3);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f3;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzal(String str, zzvg zzvgVar, long j3, long j4) {
        this.zzc.zzb(str, j3, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzam(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzan(Exception exc) {
        zzeg.zzf("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzao(zzlw zzlwVar) throws zzjk {
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        this.zzi = zzvVar;
        zzjc zzjcVarZzao = super.zzao(zzlwVar);
        this.zzc.zzc(zzvVar, zzjcVarZzao);
        return zzjcVarZzao;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzap(zzv zzvVar, MediaFormat mediaFormat) throws zzjk {
        int i3;
        zzv zzvVar2 = this.zzj;
        zzhaf zzhafVarZza = null;
        if (zzvVar2 != null) {
            zzvVar = zzvVar2;
        } else if (zzaI() != null) {
            mediaFormat.getClass();
            int integer = "audio/raw".equals(zzvVar.zzp) ? zzvVar.zzJ : mediaFormat.containsKey("pcm-encoding") ? mediaFormat.getInteger("pcm-encoding") : mediaFormat.containsKey("v-bits-per-sample") ? zzfl.zzB(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            zzt zztVar = new zzt();
            zztVar.zzo("audio/raw");
            zztVar.zzI(integer);
            zztVar.zzJ(zzvVar.zzK);
            zztVar.zzK(zzvVar.zzL);
            zztVar.zzl(zzvVar.zzl);
            zztVar.zza(zzvVar.zza);
            zztVar.zzc(zzvVar.zzb);
            zztVar.zzd(zzvVar.zzc);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzf(zzvVar.zze);
            zztVar.zzg(zzvVar.zzf);
            zztVar.zzG(mediaFormat.getInteger("channel-count"));
            zztVar.zzH(mediaFormat.getInteger("sample-rate"));
            zzv zzvVarZzO = zztVar.zzO();
            if (this.zzg && zzvVarZzO.zzH == 6 && (i3 = zzvVar.zzH) < 6) {
                zzhae zzhaeVarZzg = zzhaf.zzg(i3);
                for (int i4 = 0; i4 < i3; i4++) {
                    zzhaeVarZzg.zza(i4);
                }
                zzhafVarZza = zzhaeVarZzg.zzb();
            } else if (this.zzh) {
                zzhafVarZza = zzahm.zza(zzvVarZzO.zzH);
            }
            zzvVar = zzvVarZzO;
        }
        try {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 29) {
                if (zzaH()) {
                    zzK();
                }
                zzgtj.zzi(i5 >= 29);
            }
            zzse zzseVar = this.zzd;
            zzrw zzrwVar = new zzrw(zzvVar);
            zzrwVar.zza(zzhafVarZza);
            zzseVar.zzh(zzrwVar.zzb());
        } catch (zzrz e3) {
            throw zzP(e3, e3.zza, false, 5001);
        }
    }

    protected final void zzaq() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzar() {
        this.zzd.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzas(long j3, long j4, zzvj zzvjVar, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, zzv zzvVar) throws zzjk {
        byteBuffer.getClass();
        this.zzr = -9223372036854775807L;
        if (this.zzj != null && (i4 & 2) != 0) {
            zzvjVar.getClass();
            zzvjVar.zzc(i3, false);
            return true;
        }
        if (z2) {
            if (zzvjVar != null) {
                zzvjVar.zzc(i3, false);
            }
            ((zzvt) this).zza.zzf += i5;
            this.zzd.zzj();
            return true;
        }
        try {
            if (!this.zzd.zzk(byteBuffer, j5, i5)) {
                this.zzr = j5;
                return false;
            }
            if (zzvjVar != null) {
                zzvjVar.zzc(i3, false);
            }
            ((zzvt) this).zza.zze += i5;
            return true;
        } catch (zzsa e3) {
            zzv zzvVar2 = this.zzi;
            if (zzaH()) {
                zzK();
            }
            throw zzP(e3, zzvVar2, false, 5001);
        } catch (zzsd e4) {
            if (zzaH()) {
                zzK();
            }
            throw zzP(e4, zzvVar, e4.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzat(zziz zzizVar) {
        this.zzc.zzn(zzizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzau() throws zzjk {
        try {
            this.zzd.zzl();
            if (zzbe() != -9223372036854775807L) {
                this.zzr = zzbe();
            }
        } catch (zzsd e3) {
            throw zzP(e3, e3.zzc, e3.zzb, true != zzaH() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzav(zziv zzivVar) {
        zzv zzvVar;
        if (Build.VERSION.SDK_INT < 29 || (zzvVar = zzivVar.zza) == null || !Objects.equals(zzvVar.zzp, "audio/opus") || !zzaH()) {
            return;
        }
        ByteBuffer byteBuffer = zzivVar.zzf;
        byteBuffer.getClass();
        zzv zzvVar2 = zzivVar.zza;
        zzvVar2.getClass();
        int i3 = zzvVar2.zzK;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzy(i3, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    final /* synthetic */ zzru zzaz() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzna
    public final zzmb zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final long zzg() {
        if (zze() == 2) {
            zzbo();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zzh() {
        boolean z2 = this.zzn;
        this.zzn = false;
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzi(zzav zzavVar) {
        this.zzd.zzo(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzav zzj() {
        return this.zzd.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzmv
    public final void zzx(int i3, Object obj) throws zzjk {
        zzvf zzvfVar;
        if (i3 == 2) {
            zzse zzseVar = this.zzd;
            obj.getClass();
            zzseVar.zzz(((Float) obj).floatValue());
            return;
        }
        if (i3 == 3) {
            zzd zzdVar = (zzd) obj;
            zzse zzseVar2 = this.zzd;
            zzdVar.getClass();
            zzseVar2.zzr(zzdVar);
            return;
        }
        if (i3 == 6) {
            zze zzeVar = (zze) obj;
            zzse zzseVar3 = this.zzd;
            zzeVar.getClass();
            zzseVar3.zzu(zzeVar);
            return;
        }
        if (i3 == 12) {
            this.zzd.zzv((AudioDeviceInfo) obj);
            return;
        }
        if (i3 == 16) {
            obj.getClass();
            this.zzp = ((Integer) obj).intValue();
            zzvj zzvjVarZzaI = zzaI();
            if (zzvjVarZzaI == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzp));
            zzvjVarZzaI.zzp(bundle);
            return;
        }
        if (i3 == 19) {
            zzse zzseVar4 = this.zzd;
            obj.getClass();
            zzseVar4.zzw(((Integer) obj).intValue());
            return;
        }
        if (i3 == 9) {
            zzse zzseVar5 = this.zzd;
            obj.getClass();
            zzseVar5.zzq(((Boolean) obj).booleanValue());
        } else {
            if (i3 != 10) {
                super.zzx(i3, obj);
                return;
            }
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            this.zzd.zzt(iIntValue);
            if (Build.VERSION.SDK_INT < 35 || (zzvfVar = this.zze) == null) {
                return;
            }
            zzvfVar.zza(iIntValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzy(boolean z2, boolean z3) throws zzjk {
        super.zzy(z2, z3);
        this.zzc.zza(((zzvt) this).zza);
        zzK();
        zzse zzseVar = this.zzd;
        zzseVar.zzb(zzL());
        zzseVar.zzc(zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f3) {
        boolean z2;
        zzv zzvVar2;
        zzv[] zzvVarArrZzJ = zzJ();
        int length = zzvVarArrZzJ.length;
        int iZzbn = zzbn(zzvmVar, zzvVar);
        if (length != 1) {
            for (zzv zzvVar3 : zzvVarArrZzJ) {
                if (zzvmVar.zzf(zzvVar, zzvVar3).zzd != 0) {
                    iZzbn = Math.max(iZzbn, zzbn(zzvmVar, zzvVar3));
                }
            }
        }
        this.zzf = iZzbn;
        String str = zzvmVar.zza;
        int i3 = Build.VERSION.SDK_INT;
        this.zzg = false;
        if (str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder")) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzh = z2;
        String str2 = zzvmVar.zzc;
        int i4 = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        int i5 = zzvVar.zzH;
        mediaFormat.setInteger("channel-count", i5);
        int i6 = zzvVar.zzI;
        mediaFormat.setInteger("sample-rate", i6);
        zzej.zza(mediaFormat, zzvVar.zzs);
        zzej.zzb(mediaFormat, "max-input-size", i4);
        mediaFormat.setInteger("priority", 0);
        if (f3 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f3);
        }
        String str3 = zzvVar.zzp;
        if ("audio/ac4".equals(str3)) {
            Pair pairZze = zzdq.zze(zzvVar);
            if (pairZze != null) {
                zzej.zzb(mediaFormat, "profile", ((Integer) pairZze.first).intValue());
                zzej.zzb(mediaFormat, AppLovinEventTypes.USER_COMPLETED_LEVEL, ((Integer) pairZze.second).intValue());
            }
            if (i3 <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (this.zzd.zze(zzfl.zzA(4, i5, i6)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i3 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i3 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzp));
        }
        if (Objects.equals(str3, "audio/iamf")) {
            zzqh zzqhVarZzs = this.zzd.zzs();
            if (zzqhVarZzs == null) {
                zzeg.zzc(MHoiDDglUlPJC.kuhfpmwkPbGUdif, "AudioCapabilities from the AudioSink are null, using default stereo output layout.");
                mediaFormat.setInteger("channel-mask", 12);
                mediaFormat.setInteger("max-output-channel-count", 2);
            } else {
                int iZza = zztv.zza(zzqhVarZzs);
                int iBitCount = Integer.bitCount(iZza);
                mediaFormat.setInteger("channel-mask", iZza);
                mediaFormat.setInteger("max-output-channel-count", iBitCount);
            }
        }
        zzbi(mediaFormat);
        if ("audio/raw".equals(zzvmVar.zzb) && !"audio/raw".equals(str3)) {
            zzvVar2 = zzvVar;
        } else {
            zzvVar2 = null;
        }
        this.zzj = zzvVar2;
        return zzvg.zza(zzvmVar, mediaFormat, zzvVar, null, this.zze);
    }
}
