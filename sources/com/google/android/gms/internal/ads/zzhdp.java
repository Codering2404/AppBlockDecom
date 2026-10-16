package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdp implements zzhed {
    private static final Charset zza = Charset.forName(Utf8Charset.NAME);
    private final InputStream zzb;

    private zzhdp(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzhdp zza(String str) {
        return new zzhdp(new ByteArrayInputStream(str.getBytes(zza)));
    }

    private static int zzc(zzibg zzibgVar) throws IOException {
        if (!(zzibgVar instanceof zzibk)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!zzibgVar.zzg().zzc()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long jZzc = zzhlm.zzc(zzibgVar.zzg().zzh());
            if (jZzc > 4294967295L || jZzc < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) jZzc;
        } catch (NumberFormatException e3) {
            throw new IOException(e3);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01dd A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144 A[Catch: all -> 0x0033, IllegalStateException -> 0x0036, zzibj -> 0x0039, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:13:0x003c, B:15:0x0053, B:17:0x005b, B:19:0x0065, B:21:0x006f, B:23:0x007b, B:25:0x0081, B:27:0x008f, B:29:0x0095, B:31:0x009b, B:33:0x00a1, B:35:0x00a9, B:51:0x00eb, B:56:0x0114, B:69:0x0137, B:71:0x0144, B:73:0x014a, B:75:0x0150, B:80:0x0192, B:93:0x01b5, B:84:0x019d, B:88:0x01a8, B:92:0x01b3, B:94:0x01d3, B:95:0x01dc, B:96:0x01dd, B:97:0x01e4, B:60:0x011f, B:64:0x012a, B:68:0x0135, B:98:0x01e5, B:99:0x01ee, B:100:0x01ef, B:101:0x01f8, B:102:0x01f9, B:103:0x0200, B:104:0x0201, B:105:0x0208, B:106:0x0209, B:109:0x0215, B:110:0x021c, B:111:0x021d, B:112:0x0224, B:113:0x0225, B:114:0x022c, B:115:0x022d, B:116:0x0232), top: B:119:0x0014 }] */
    @Override // com.google.android.gms.internal.ads.zzhed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzhsz zzb() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhdp.zzb():com.google.android.gms.internal.ads.zzhsz");
    }
}
