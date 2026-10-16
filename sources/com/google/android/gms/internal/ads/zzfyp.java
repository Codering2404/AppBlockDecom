package com.google.android.gms.internal.ads;

import com.facebook.internal.Utility;
import com.google.android.gms.common.util.IOUtils;
import com.sun.jna.Function;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyp {
    private final zzbeb zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzfyp(zzbeb zzbebVar, File file, File file2, File file3) {
        this.zza = zzbebVar;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzbeb zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzb;
    }

    public final File zzc() {
        return this.zzc;
    }

    public final byte[] zzd() throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArrZzA;
        ArrayList arrayList;
        int iMin;
        FileInputStream fileInputStream2 = null;
        if (this.zze == null) {
            try {
                fileInputStream = new FileInputStream(this.zzd);
                try {
                    zzida zzidaVar = zzida.zza;
                    arrayList = new ArrayList();
                    iMin = Function.MAX_NARGS;
                } catch (IOException unused) {
                    IOUtils.a(fileInputStream);
                    bArrZzA = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    IOUtils.a(fileInputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                byte[] bArr = new byte[iMin];
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = fileInputStream.read(bArr, i3, iMin - i3);
                    if (i4 == -1) {
                        break;
                    }
                    i3 += i4;
                }
                zzida zzidaVarZzt = i3 == 0 ? null : zzida.zzt(bArr, 0, i3);
                if (zzidaVarZzt == null) {
                    break;
                }
                arrayList.add(zzidaVarZzt);
                iMin = Math.min(iMin + iMin, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                this.zze = bArrZzA;
            }
            bArrZzA = zzida.zzy(arrayList).zzA();
            IOUtils.a(fileInputStream);
            this.zze = bArrZzA;
        }
        byte[] bArr2 = this.zze;
        if (bArr2 == null) {
            return null;
        }
        return Arrays.copyOf(bArr2, bArr2.length);
    }

    public final boolean zze(long j3) {
        return this.zza.zzc() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
