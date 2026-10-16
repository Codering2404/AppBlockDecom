package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzauh extends zzate {
    private final Object zza;
    private final zzatj zzb;

    public zzauh(int i3, String str, zzatj zzatjVar, zzati zzatiVar) {
        super(i3, str, zzatiVar);
        this.zza = new Object();
        this.zzb = zzatjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzate
    protected final zzatk zzr(zzata zzataVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzataVar.zzb;
            Map map = zzataVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i3 = 1;
                while (true) {
                    if (i3 >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i3].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i3++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzataVar.zzb);
        }
        return zzatk.zza(str, zzaub.zza(zzataVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzate
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzs(String str) {
        zzatj zzatjVar;
        synchronized (this.zza) {
            zzatjVar = this.zzb;
        }
        zzatjVar.zza(str);
    }
}
