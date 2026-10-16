package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjd extends zzcja {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcjd(zzchn zzchnVar) {
        super(zzchnVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfzk.zza().zza(cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String strValueOf = String.valueOf(this.zzg.getAbsolutePath());
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not create preload cache directory at ".concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(zzfzk.zza().zza(this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x03c6, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03ce, code lost:
    
        if (com.google.android.gms.ads.internal.util.client.zzo.j(3) == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03d0, code lost:
    
        r0 = r10.format(r4);
        r5 = new java.lang.StringBuilder((java.lang.String.valueOf(r0).length() + 22) + java.lang.String.valueOf(r34).length());
        r5.append(r17);
        r5.append(r0);
        r5.append(" bytes from ");
        r5.append(r34);
        com.google.android.gms.ads.internal.util.client.zzo.a(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0402, code lost:
    
        r13.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x040c, code lost:
    
        if (r7.isFile() == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x040e, code lost:
    
        r7.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x041a, code lost:
    
        r7.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.internal.ads.zzcja, com.google.android.gms.internal.ads.zzcjd] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v38 */
    @Override // com.google.android.gms.internal.ads.zzcja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(final java.lang.String r34) {
        /*
            Method dump skipped, instruction units count: 1240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjd.zze(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        this.zzh = true;
    }
}
