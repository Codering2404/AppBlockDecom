package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyd {
    public static boolean zza(zzbds zzbdsVar) {
        int iOrdinal = zzbdsVar.ordinal();
        return iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5;
    }

    private static final void zzc(byte[] bArr, String str, Context context, zzfxg zzfxgVar) {
        if (zzfxgVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzgtz.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfxgVar.zze(4007, sb.toString());
    }

    private static final String zzd(Context context, zzfxg zzfxgVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strZza = zzgtz.OS_ARCH.zza();
        if (!TextUtils.isEmpty(strZza) && hashSet.contains(strZza)) {
            return strZza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e3) {
            if (zzfxgVar != null) {
                zzfxgVar.zzc(2024, 0L, e3);
            }
        } catch (NoSuchFieldException e4) {
            if (zzfxgVar != null) {
                zzfxgVar.zzc(2024, 0L, e4);
            }
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }

    public static final zzbds zzb(Context context, zzfxg zzfxgVar) {
        zzbds zzbdsVar;
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new zzgzu(Pattern.compile(".*\\.so$", 2)));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                if (zzfxgVar != null) {
                    zzfxgVar.zze(5017, "No .so");
                } else {
                    zzfxgVar = null;
                }
                zzbdsVar = zzbds.zzg;
            } else {
                try {
                    fileInputStream = new FileInputStream(fileArrListFiles[0]);
                    try {
                        bArr = new byte[20];
                    } finally {
                    }
                } catch (IOException e3) {
                    zzc(null, e3.toString(), context, zzfxgVar);
                }
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] == 2) {
                        zzc(bArr, null, context, zzfxgVar);
                        zzbdsVar = zzbds.UNSUPPORTED;
                    } else {
                        bArr2[0] = bArr[19];
                        bArr2[1] = bArr[18];
                        short s2 = ByteBuffer.wrap(bArr2).getShort();
                        if (s2 == 3) {
                            zzbdsVar = zzbds.X86;
                        } else if (s2 == 40) {
                            zzbdsVar = zzbds.zzb;
                        } else if (s2 == 62) {
                            zzbdsVar = zzbds.X86_64;
                        } else if (s2 == 183) {
                            zzbdsVar = zzbds.ARM64;
                        } else if (s2 != 243) {
                            zzc(bArr, null, context, zzfxgVar);
                            zzbdsVar = zzbds.UNSUPPORTED;
                        } else {
                            zzbdsVar = zzbds.RISCV64;
                        }
                    }
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                    zzbdsVar = zzbds.UNSUPPORTED;
                }
            }
        } else {
            if (zzfxgVar != null) {
                zzfxgVar.zze(5017, "No lib/");
            } else {
                zzfxgVar = null;
            }
            zzbdsVar = zzbds.zzg;
        }
        if (zzbdsVar == zzbds.zzg) {
            String strZzd = zzd(context, zzfxgVar);
            if (TextUtils.isEmpty(strZzd)) {
                zzc(null, "Empty dev arch", context, zzfxgVar);
                zzbdsVar = zzbds.UNSUPPORTED;
            } else if (strZzd.equalsIgnoreCase("i686") || strZzd.equalsIgnoreCase("x86")) {
                zzbdsVar = zzbds.X86;
            } else if (strZzd.equalsIgnoreCase("x86_64")) {
                zzbdsVar = zzbds.X86_64;
            } else if (strZzd.equalsIgnoreCase("arm64-v8a")) {
                zzbdsVar = zzbds.ARM64;
            } else if (strZzd.equalsIgnoreCase(YgVrd.sftfZGLNUt) || strZzd.equalsIgnoreCase("armv71")) {
                zzbdsVar = zzbds.zzb;
            } else if (strZzd.equalsIgnoreCase("riscv64")) {
                zzbdsVar = zzbds.RISCV64;
            } else {
                zzc(null, strZzd, context, zzfxgVar);
                zzbdsVar = zzbds.UNSUPPORTED;
            }
        }
        if (zzfxgVar != null) {
            zzfxgVar.zze(5018, zzbdsVar.name());
        }
        return zzbdsVar;
    }
}
