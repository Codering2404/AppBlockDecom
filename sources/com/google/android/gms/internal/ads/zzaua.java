package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaua implements zzaso {
    private final zzatz zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaua(zzatz zzatzVar, int i3) {
        this.zzc = zzatzVar;
    }

    static byte[] zzg(zzaty zzatyVar, long j3) throws IOException {
        long jZza = zzatyVar.zza();
        if (j3 >= 0 && j3 <= jZza) {
            int i3 = (int) j3;
            if (i3 == j3) {
                byte[] bArr = new byte[i3];
                new DataInputStream(zzatyVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 33 + String.valueOf(jZza).length());
        sb.append("streamToBytes length=");
        sb.append(j3);
        sb.append(", maxLength=");
        sb.append(jZza);
        throw new IOException(sb.toString());
    }

    static void zzh(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(i3 & 255);
        outputStream.write((i3 >> 8) & 255);
        outputStream.write((i3 >> 16) & 255);
        outputStream.write((i3 >> 24) & 255);
    }

    static int zzi(InputStream inputStream) throws IOException {
        return (zzp(inputStream) << 24) | zzp(inputStream) | (zzp(inputStream) << 8) | (zzp(inputStream) << 16);
    }

    static void zzj(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((byte) j3);
        outputStream.write((byte) (j3 >>> 8));
        outputStream.write((byte) (j3 >>> 16));
        outputStream.write((byte) (j3 >>> 24));
        outputStream.write((byte) (j3 >>> 32));
        outputStream.write((byte) (j3 >>> 40));
        outputStream.write((byte) (j3 >>> 48));
        outputStream.write((byte) (j3 >>> 56));
    }

    static long zzk(InputStream inputStream) throws IOException {
        return (((long) zzp(inputStream)) & 255) | ((((long) zzp(inputStream)) & 255) << 8) | ((((long) zzp(inputStream)) & 255) << 16) | ((((long) zzp(inputStream)) & 255) << 24) | ((((long) zzp(inputStream)) & 255) << 32) | ((((long) zzp(inputStream)) & 255) << 40) | ((((long) zzp(inputStream)) & 255) << 48) | ((((long) zzp(inputStream)) & 255) << 56);
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Utf8Charset.NAME);
        int length = bytes.length;
        zzj(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static String zzm(zzaty zzatyVar) throws IOException {
        return new String(zzg(zzatyVar, zzk(zzatyVar)), Utf8Charset.NAME);
    }

    private final void zzn(String str, zzatx zzatxVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb += zzatxVar.zza - ((zzatx) map.get(str)).zza;
        } else {
            this.zzb += zzatxVar.zza;
        }
        map.put(str, zzatxVar);
    }

    private final void zzo(String str) {
        zzatx zzatxVar = (zzatx) this.zza.remove(str);
        if (zzatxVar != null) {
            this.zzb -= zzatxVar.zza;
        }
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int i3 = inputStream.read();
        if (i3 != -1) {
            return i3;
        }
        throw new EOFException();
    }

    private static final String zzq(String str) {
        int length = str.length() >> 1;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized zzasn zza(String str) {
        zzatx zzatxVar = (zzatx) this.zza.get(str);
        if (zzatxVar == null) {
            return null;
        }
        File fileZzf = zzf(str);
        try {
            zzaty zzatyVar = new zzaty(new BufferedInputStream(new FileInputStream(fileZzf)), fileZzf.length());
            try {
                String str2 = zzatx.zza(zzatyVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzatq.zzb("%s: key=%s, found=%s", fileZzf.getAbsolutePath(), str, str2);
                    zzo(str);
                    return null;
                }
                byte[] bArrZzg = zzg(zzatyVar, zzatyVar.zza());
                zzasn zzasnVar = new zzasn();
                zzasnVar.zza = bArrZzg;
                zzasnVar.zzb = zzatxVar.zzc;
                zzasnVar.zzc = zzatxVar.zzd;
                zzasnVar.zzd = zzatxVar.zze;
                zzasnVar.zze = zzatxVar.zzf;
                zzasnVar.zzf = zzatxVar.zzg;
                List<zzasw> list = zzatxVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzasw zzaswVar : list) {
                    treeMap.put(zzaswVar.zza(), zzaswVar.zzb());
                }
                zzasnVar.zzg = treeMap;
                zzasnVar.zzh = Collections.unmodifiableList(list);
                return zzasnVar;
            } finally {
                zzatyVar.close();
            }
        } catch (IOException e3) {
            zzatq.zzb("%s: %s", fileZzf.getAbsolutePath(), e3.toString());
            zze(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzb(String str, zzasn zzasnVar) {
        float f3;
        try {
            long j3 = this.zzb;
            int length = zzasnVar.zza.length;
            long j4 = j3 + ((long) length);
            int i3 = this.zzd;
            float f4 = 0.9f;
            if (j4 <= i3 || length <= i3 * 0.9f) {
                File fileZzf = zzf(str);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzf));
                    zzatx zzatxVar = new zzatx(str, zzasnVar);
                    try {
                        zzh(bufferedOutputStream, 538247942);
                        zzl(bufferedOutputStream, zzatxVar.zzb);
                        String str2 = zzatxVar.zzc;
                        if (str2 == null) {
                            str2 = "";
                        }
                        zzl(bufferedOutputStream, str2);
                        zzj(bufferedOutputStream, zzatxVar.zzd);
                        zzj(bufferedOutputStream, zzatxVar.zze);
                        zzj(bufferedOutputStream, zzatxVar.zzf);
                        zzj(bufferedOutputStream, zzatxVar.zzg);
                        List<zzasw> list = zzatxVar.zzh;
                        if (list != null) {
                            zzh(bufferedOutputStream, list.size());
                            for (zzasw zzaswVar : list) {
                                zzl(bufferedOutputStream, zzaswVar.zza());
                                zzl(bufferedOutputStream, zzaswVar.zzb());
                            }
                        } else {
                            zzh(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzasnVar.zza);
                        bufferedOutputStream.close();
                        zzatxVar.zza = fileZzf.length();
                        zzn(str, zzatxVar);
                        long j5 = this.zzb;
                        int i4 = this.zzd;
                        if (j5 >= i4) {
                            boolean z2 = zzatq.zzb;
                            if (z2) {
                                zzatq.zza("Pruning old cache entries.", new Object[0]);
                            }
                            long j6 = this.zzb;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.zza.entrySet().iterator();
                            int i5 = 0;
                            while (it.hasNext()) {
                                zzatx zzatxVar2 = (zzatx) ((Map.Entry) it.next()).getValue();
                                String str3 = zzatxVar2.zzb;
                                if (zzf(str3).delete()) {
                                    f3 = f4;
                                    this.zzb -= zzatxVar2.zza;
                                } else {
                                    f3 = f4;
                                    zzatq.zzb("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                                }
                                it.remove();
                                i5++;
                                if (this.zzb < i4 * f3) {
                                    break;
                                } else {
                                    f4 = f3;
                                }
                            }
                            if (z2) {
                                zzatq.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i5), Long.valueOf(this.zzb - j6), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                            }
                        }
                    } catch (IOException e3) {
                        zzatq.zzb("%s", e3.toString());
                        bufferedOutputStream.close();
                        zzatq.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused) {
                    if (!fileZzf.delete()) {
                        zzatq.zzb("Could not clean up file %s", fileZzf.getAbsolutePath());
                    }
                    if (!this.zzc.zza().exists()) {
                        zzatq.zzb("Re-initializing cache after external clearing.", new Object[0]);
                        this.zza.clear();
                        this.zzb = 0L;
                        zzc();
                    }
                }
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzc() {
        File fileZza = this.zzc.zza();
        if (fileZza.exists()) {
            File[] fileArrListFiles = fileZza.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        long length = file.length();
                        zzaty zzatyVar = new zzaty(new BufferedInputStream(new FileInputStream(file)), length);
                        try {
                            zzatx zzatxVarZza = zzatx.zza(zzatyVar);
                            zzatxVarZza.zza = length;
                            zzn(zzatxVarZza.zzb, zzatxVarZza);
                            zzatyVar.close();
                        } catch (Throwable th) {
                            zzatyVar.close();
                            throw th;
                        }
                    } catch (IOException unused) {
                        file.delete();
                    }
                }
            }
        } else if (!fileZza.mkdirs()) {
            zzatq.zzc("Unable to create cache dir %s", fileZza.getAbsolutePath());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzd(String str, boolean z2) {
        zzasn zzasnVarZza = zza(str);
        if (zzasnVarZza != null) {
            zzasnVarZza.zzf = 0L;
            zzasnVarZza.zze = 0L;
            zzb(str, zzasnVarZza);
        }
    }

    public final synchronized void zze(String str) {
        boolean zDelete = zzf(str).delete();
        zzo(str);
        if (zDelete) {
            return;
        }
        zzatq.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public final File zzf(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public zzaua(File file, int i3) {
        this.zzc = new zzatw(this, file);
    }
}
