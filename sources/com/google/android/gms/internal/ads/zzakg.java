package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakg {
    public byte[] zzN;
    public zzahl zzT;
    public boolean zzV;
    public zzahk zzX;
    public zzv zzY;
    public int zzZ;
    public boolean zza;
    private int zzaa;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzahj zzj;
    public byte[] zzk;
    public zzq zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzU = false;
    public boolean zzW = true;
    private String zzab = "eng";

    protected zzakg() {
    }

    private static Pair zzf(zzet zzetVar) throws zzat {
        try {
            zzetVar.zzk(16);
            long jZzA = zzetVar.zzA();
            if (jZzA == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzA == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzA != 826496599) {
                zzeg.zzc("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzg = zzetVar.zzg() + 20;
            byte[] bArrZzi = zzetVar.zzi();
            while (true) {
                int length = bArrZzi.length;
                if (iZzg >= length - 4) {
                    throw zzat.zzb("Failed to find FourCC VC1 initialization data", null);
                }
                int i3 = iZzg + 1;
                if (bArrZzi[iZzg] == 0 && bArrZzi[i3] == 0 && bArrZzi[iZzg + 2] == 1 && bArrZzi[iZzg + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzi, iZzg, length)));
                }
                iZzg = i3;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzat {
        int i3;
        int i4;
        try {
            if (bArr[0] != 2) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i5 = 0;
            int i6 = 1;
            while (true) {
                int i7 = bArr[i6];
                i6++;
                i3 = i7 & 255;
                if (i3 != 255) {
                    break;
                }
                i5 += 255;
            }
            int i8 = i5 + i3;
            int i9 = 0;
            while (true) {
                int i10 = bArr[i6];
                i6++;
                i4 = i10 & 255;
                if (i4 != 255) {
                    break;
                }
                i9 += 255;
            }
            int i11 = i9 + i4;
            if (bArr[i6] != 1) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, i6, bArr2, 0, i8);
            int i12 = i6 + i8;
            if (bArr[i12] != 3) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i13 = i12 + i11;
            if (bArr[i13] != 5) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i13;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i13, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzet zzetVar) throws zzat {
        try {
            int iZzu = zzetVar.zzu();
            if (iZzu == 1) {
                return true;
            }
            if (iZzu == 65534) {
                zzetVar.zzh(24);
                if (zzetVar.zzD() == zzakh.zzf.getMostSignificantBits()) {
                    if (zzetVar.zzD() == zzakh.zzf.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull
    private final byte[] zzi(String str) throws zzat {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzat.zzb("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06c3  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(int r25) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakg.zza(int):void");
    }

    final /* synthetic */ void zzb() {
        this.zzX.getClass();
    }

    final /* synthetic */ int zzc() {
        return this.zzaa;
    }

    final /* synthetic */ void zzd(int i3) {
        this.zzaa = i3;
    }

    final /* synthetic */ void zze(String str) {
        this.zzab = str;
    }
}
