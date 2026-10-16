package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzv {
    public static final /* synthetic */ int zzP = 0;
    public final float zzA;
    public final int zzB;
    public final float zzC;
    public final byte[] zzD;
    public final int zzE;
    public final zzi zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    public final int zzO;
    private int zzQ;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzap zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final String zzp;
    public final int zzq;
    public final int zzr;
    public final List zzs;
    public final zzq zzt;
    public final long zzu;
    public final boolean zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final int zzz;

    static {
        new zzv(new zzt());
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
        Integer.toString(37, 36);
    }

    /* synthetic */ zzv(zzt zztVar, byte[] bArr) {
        this(zztVar);
    }

    public static String zze(zzv zzvVar) {
        String str;
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(zzvVar.zza);
        sb.append(", mimeType=");
        sb.append(zzvVar.zzp);
        String str2 = zzvVar.zzo;
        if (str2 != null) {
            sb.append(", container=");
            sb.append(str2);
        }
        String str3 = zzvVar.zzn;
        if (str3 != null) {
            sb.append(", primaryGroupId=");
            sb.append(str3);
        }
        int i5 = zzvVar.zzj;
        if (i5 != -1) {
            sb.append(", bitrate=");
            sb.append(i5);
        }
        String str4 = zzvVar.zzk;
        if (str4 != null) {
            sb.append(", codecs=");
            sb.append(str4);
        }
        zzq zzqVar = zzvVar.zzt;
        if (zzqVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i6 = 0; i6 < zzqVar.zzb; i6++) {
                UUID uuid = zzqVar.zza(i6).zza;
                if (uuid.equals(zzg.zzb)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(zzg.zzc)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zzg.zze)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zzg.zzd)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zzg.zza)) {
                    linkedHashSet.add("universal");
                } else {
                    String string = uuid.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 10);
                    sb2.append("unknown (");
                    sb2.append(string);
                    sb2.append(")");
                    linkedHashSet.add(sb2.toString());
                }
            }
            sb.append(", drm=[");
            zzgtd.zzb(sb, linkedHashSet, ",");
            sb.append(']');
        }
        int i7 = zzvVar.zzw;
        if (i7 != -1 && (i4 = zzvVar.zzx) != -1) {
            sb.append(", res=");
            sb.append(i7);
            sb.append("x");
            sb.append(i4);
        }
        int i8 = zzvVar.zzy;
        if (i8 != -1 && (i3 = zzvVar.zzz) != -1) {
            sb.append(", decRes=");
            sb.append(i8);
            sb.append("x");
            sb.append(i3);
        }
        float f3 = zzvVar.zzC;
        int i9 = zzgzw.zza;
        double d3 = f3;
        if (Math.copySign((-1.0d) + d3, 1.0d) > 0.001d && d3 != 1.0d && (!Double.isNaN(d3) || !Double.isNaN(1.0d))) {
            sb.append(", par=");
            Object[] objArr = {Float.valueOf(f3)};
            String str5 = zzfl.zza;
            sb.append(String.format(Locale.US, "%.3f", objArr));
        }
        zzi zziVar = zzvVar.zzF;
        if (zziVar != null && (zziVar.zze() || zziVar.zzf())) {
            sb.append(", color=");
            sb.append(zziVar.zzg());
        }
        float f4 = zzvVar.zzA;
        if (f4 != -1.0f) {
            sb.append(", fps=");
            sb.append(f4);
        }
        int i10 = zzvVar.zzG;
        if (i10 != -1) {
            sb.append(", maxSubLayers=");
            sb.append(i10);
        }
        int i11 = zzvVar.zzH;
        if (i11 != -1) {
            sb.append(", channels=");
            sb.append(i11);
        }
        int i12 = zzvVar.zzI;
        if (i12 != -1) {
            sb.append(", sample_rate=");
            sb.append(i12);
        }
        String str6 = zzvVar.zzd;
        if (str6 != null) {
            sb.append(", language=");
            sb.append(str6);
        }
        List list = zzvVar.zzc;
        if (!list.isEmpty()) {
            sb.append(", labels=[");
            zzgtd.zzb(sb, zzgxm.zzc(list, zzu.zza), ",");
            sb.append("]");
        }
        int i13 = zzvVar.zze;
        if (i13 != 0) {
            sb.append(", selectionFlags=[");
            String str7 = zzfl.zza;
            ArrayList arrayList = new ArrayList();
            if ((i13 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i13 & 2) != 0) {
                arrayList.add("forced");
            }
            zzgtd.zzb(sb, arrayList, ",");
            sb.append("]");
        }
        int i14 = zzvVar.zzf;
        if (i14 != 0) {
            sb.append(", roleFlags=[");
            int i15 = i14 & 32768;
            String str8 = zzfl.zza;
            ArrayList arrayList2 = new ArrayList();
            if ((i14 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i14 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i14 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i14 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i14 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i14 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i14 & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((i14 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i14 & Function.MAX_NARGS) != 0) {
                arrayList2.add("sign");
            }
            if ((i14 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i14 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i14 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i14 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i14 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i14 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if (i15 != 0) {
                arrayList2.add("auxiliary");
            }
            zzgtd.zzb(sb, arrayList2, ",");
            sb.append("]");
        }
        if ((i14 & 32768) != 0) {
            sb.append(", auxiliaryTrackType=");
            int i16 = zzvVar.zzg;
            String str9 = zzfl.zza;
            if (i16 == 0) {
                str = "undefined";
            } else if (i16 == 1) {
                str = "original";
            } else if (i16 == 2) {
                str = "depth-linear";
            } else if (i16 == 3) {
                str = "depth-inverse";
            } else {
                if (i16 != 4) {
                    throw new IllegalStateException("Unsupported auxiliary track type");
                }
                str = "depth metadata";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        int i3;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzv.class == obj.getClass()) {
            zzv zzvVar = (zzv) obj;
            int i4 = this.zzQ;
            if ((i4 == 0 || (i3 = zzvVar.zzQ) == 0 || i4 == i3) && this.zze == zzvVar.zze && this.zzf == zzvVar.zzf && this.zzg == zzvVar.zzg && this.zzh == zzvVar.zzh && this.zzi == zzvVar.zzi && this.zzq == zzvVar.zzq && this.zzu == zzvVar.zzu && this.zzw == zzvVar.zzw && this.zzx == zzvVar.zzx && this.zzy == zzvVar.zzy && this.zzz == zzvVar.zzz && this.zzB == zzvVar.zzB && this.zzE == zzvVar.zzE && this.zzG == zzvVar.zzG && this.zzH == zzvVar.zzH && this.zzI == zzvVar.zzI && this.zzJ == zzvVar.zzJ && this.zzK == zzvVar.zzK && this.zzL == zzvVar.zzL && this.zzM == zzvVar.zzM && this.zzO == zzvVar.zzO && Float.compare(this.zzA, zzvVar.zzA) == 0 && Float.compare(this.zzC, zzvVar.zzC) == 0 && Objects.equals(this.zza, zzvVar.zza) && Objects.equals(this.zzb, zzvVar.zzb) && this.zzc.equals(zzvVar.zzc) && Objects.equals(this.zzk, zzvVar.zzk) && Objects.equals(this.zzn, zzvVar.zzn) && Objects.equals(this.zzo, zzvVar.zzo) && Objects.equals(this.zzp, zzvVar.zzp) && Objects.equals(this.zzd, zzvVar.zzd) && Arrays.equals(this.zzD, zzvVar.zzD) && Objects.equals(this.zzl, zzvVar.zzl) && Objects.equals(this.zzF, zzvVar.zzF) && Objects.equals(this.zzt, zzvVar.zzt) && zzd(zzvVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzQ;
        if (i3 != 0) {
            return i3;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = ((((iHashCode + 527) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31) + this.zzc.hashCode();
        String str3 = this.zzd;
        int iHashCode3 = ((((((((((((iHashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzap zzapVar = this.zzl;
        int iHashCode5 = iHashCode4 + (zzapVar == null ? 0 : zzapVar.hashCode());
        String str5 = this.zzn;
        int iHashCode6 = ((iHashCode5 * 961) + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.zzo;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        int iHashCode8 = ((((((((((((((((((((((((((((((((((((((((iHashCode7 + (this.zzp != null ? r2.hashCode() : 0)) * 31) + this.zzq) * 31) + ((int) this.zzu)) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31) + this.zzz) * 31) + Float.floatToIntBits(this.zzA)) * 31) + this.zzB) * 31) + Float.floatToIntBits(this.zzC)) * 31) + this.zzE) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) + this.zzM) * 31) - 1) * 31) - 1) * 31) + this.zzO;
        this.zzQ = iHashCode8;
        return iHashCode8;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzF);
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzo;
        int length3 = String.valueOf(str3).length();
        String str4 = this.zzp;
        int length4 = String.valueOf(str4).length();
        String str5 = this.zzk;
        int length5 = String.valueOf(str5).length();
        int i3 = this.zzj;
        int length6 = String.valueOf(i3).length();
        String str6 = this.zzd;
        int length7 = String.valueOf(str6).length();
        int i4 = this.zzw;
        int length8 = String.valueOf(i4).length();
        int i5 = this.zzx;
        int length9 = String.valueOf(i5).length();
        float f3 = this.zzA;
        int length10 = String.valueOf(f3).length();
        int length11 = strValueOf.length();
        int i6 = this.zzH;
        int length12 = String.valueOf(i6).length();
        int i7 = this.zzI;
        StringBuilder sb = new StringBuilder(length + 9 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2 + length6 + 2 + length7 + 3 + length8 + 2 + length9 + 2 + length10 + 2 + length11 + 4 + length12 + 2 + String.valueOf(i7).length() + 2);
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        sb.append(f3);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append("], [");
        sb.append(i6);
        sb.append(", ");
        sb.append(i7);
        sb.append("])");
        return sb.toString();
    }

    public final zzt zza() {
        return new zzt(this, null);
    }

    public final zzv zzb(int i3) {
        zzt zztVar = new zzt(this, null);
        zztVar.zzN(i3);
        return new zzv(zztVar);
    }

    public final int zzc() {
        int i3;
        int i4 = this.zzw;
        if (i4 == -1 || (i3 = this.zzx) == -1) {
            return -1;
        }
        return i4 * i3;
    }

    public final boolean zzd(zzv zzvVar) {
        List list = this.zzs;
        int size = list.size();
        List list2 = zzvVar.zzs;
        if (size != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!Arrays.equals((byte[]) list.get(i3), (byte[]) list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private zzv(zzt zztVar) {
        boolean z2;
        String str;
        this.zza = zztVar.zzP();
        String strZzi = zzfl.zzi(zztVar.zzS());
        this.zzd = strZzi;
        if (zztVar.zzR().isEmpty() && zztVar.zzQ() != null) {
            this.zzc = zzgwm.zzj(new zzx(strZzi, zztVar.zzQ()));
            this.zzb = zztVar.zzQ();
        } else if (!zztVar.zzR().isEmpty() && zztVar.zzQ() == null) {
            this.zzc = zztVar.zzR();
            List listZzR = zztVar.zzR();
            Iterator it = listZzR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzx) listZzR.get(0)).zzb;
                    break;
                }
                zzx zzxVar = (zzx) it.next();
                if (TextUtils.equals(zzxVar.zza, strZzi)) {
                    str = zzxVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        } else if (zztVar.zzR().isEmpty() && zztVar.zzQ() == null) {
            z2 = true;
            zzgtj.zzi(z2);
            this.zzc = zztVar.zzR();
            this.zzb = zztVar.zzQ();
        } else {
            for (int i3 = 0; i3 < zztVar.zzR().size(); i3++) {
                if (((zzx) zztVar.zzR().get(i3)).zzb.equals(zztVar.zzQ())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            zzgtj.zzi(z2);
            this.zzc = zztVar.zzR();
            this.zzb = zztVar.zzQ();
        }
        this.zze = zztVar.zzT();
        zzgtj.zzj(zztVar.zzV() == 0 || (zztVar.zzU() & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zztVar.zzU();
        this.zzg = zztVar.zzV();
        int iZzW = zztVar.zzW();
        this.zzh = iZzW;
        int iZzX = zztVar.zzX();
        this.zzi = iZzX;
        this.zzj = iZzX != -1 ? iZzX : iZzW;
        this.zzk = zztVar.zzY();
        this.zzl = zztVar.zzZ();
        this.zzm = null;
        this.zzn = zztVar.zzaa();
        this.zzo = zztVar.zzab();
        this.zzp = zztVar.zzac();
        this.zzq = zztVar.zzad();
        this.zzr = zztVar.zzae();
        this.zzs = zztVar.zzaf() == null ? Collections.EMPTY_LIST : zztVar.zzaf();
        zzq zzqVarZzag = zztVar.zzag();
        this.zzt = zzqVarZzag;
        this.zzu = zztVar.zzah();
        this.zzv = zztVar.zzai();
        this.zzw = zztVar.zzaj();
        this.zzx = zztVar.zzak();
        this.zzy = zztVar.zzal();
        this.zzz = zztVar.zzam();
        this.zzA = zztVar.zzan();
        this.zzB = zztVar.zzao() == -1 ? 0 : zztVar.zzao();
        this.zzC = zztVar.zzap() == -1.0f ? 1.0f : zztVar.zzap();
        this.zzD = zztVar.zzaq();
        this.zzE = zztVar.zzar();
        this.zzF = zztVar.zzas();
        this.zzG = zztVar.zzat();
        this.zzH = zztVar.zzau();
        this.zzI = zztVar.zzav();
        this.zzJ = zztVar.zzaw();
        this.zzK = zztVar.zzax() == -1 ? 0 : zztVar.zzax();
        this.zzL = zztVar.zzay() != -1 ? zztVar.zzay() : 0;
        this.zzM = zztVar.zzaz();
        this.zzN = zztVar.zzaA();
        if (zztVar.zzaB() != 0 || zzqVarZzag == null) {
            this.zzO = zztVar.zzaB();
        } else {
            this.zzO = 1;
        }
    }
}
