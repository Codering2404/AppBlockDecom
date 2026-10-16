package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyh implements zzabz, zzwz {
    final /* synthetic */ zzyq zza;
    private final long zzb;
    private final Uri zzc;
    private final zzim zzd;
    private final zzyd zze;
    private final zzagb zzf;
    private final zzds zzg;
    private final zzagy zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzht zzl;
    private zzahk zzm;
    private boolean zzn;

    public zzyh(zzyq zzyqVar, Uri uri, zzhp zzhpVar, zzyd zzydVar, zzagb zzagbVar, zzds zzdsVar) {
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
        this.zzc = uri;
        this.zzd = new zzim(zzhpVar);
        this.zze = zzydVar;
        this.zzf = zzagbVar;
        this.zzg = zzdsVar;
        this.zzh = new zzagy();
        this.zzj = true;
        this.zzb = zzxb.zza();
        this.zzl = zzi(0L, null);
    }

    private final zzht zzi(long j3, String str) {
        Map mapZzd = zzyq.zzb;
        if (str != null && !str.startsWith("W/")) {
            zzgwo zzgwoVar = new zzgwo();
            zzgwoVar.zzb(mapZzd.entrySet());
            zzgwoVar.zza("If-Range", str);
            mapZzd = zzgwoVar.zzd();
        }
        zzhs zzhsVar = new zzhs();
        zzhsVar.zza(this.zzc);
        zzhsVar.zzc(j3);
        zzhsVar.zzd(6);
        zzhsVar.zzb(mapZzd);
        return zzhsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzet zzetVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(this.zza.zzI(true), this.zzk);
        int iZzd = zzetVar.zzd();
        zzahk zzahkVar = this.zzm;
        zzahkVar.getClass();
        zzahkVar.zzc(zzetVar, iZzd);
        zzahkVar.zze(jMax, 1, iZzd, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzb() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x020e A[EDGE_INSN: B:140:0x020e->B:99:0x020e BREAK  A[LOOP:1: B:86:0x01d5->B:143:0x01d5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0131 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0171 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0187 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c0 A[Catch: all -> 0x00b2, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c7 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #3 {all -> 0x00b2, blocks: (B:28:0x0080, B:29:0x0086, B:39:0x00c5, B:41:0x00cf, B:43:0x00dc, B:45:0x00e6, B:47:0x00f3, B:49:0x00fd, B:51:0x010a, B:53:0x0114, B:55:0x0127, B:57:0x0131, B:58:0x0138, B:66:0x0171, B:68:0x017a, B:70:0x0187, B:72:0x0190, B:74:0x01ab, B:76:0x01c0, B:77:0x01c3, B:79:0x01c7, B:61:0x0142, B:64:0x0162, B:33:0x0092, B:38:0x00b7), top: B:122:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d3  */
    @Override // com.google.android.gms.internal.ads.zzabz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyh.zzc():void");
    }

    final /* synthetic */ void zzd(long j3, long j4) {
        this.zzh.zza = j3;
        this.zzk = j4;
        this.zzj = true;
        this.zzn = false;
    }

    final /* synthetic */ long zze() {
        return this.zzb;
    }

    final /* synthetic */ zzim zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zzk;
    }

    final /* synthetic */ zzht zzh() {
        return this.zzl;
    }
}
