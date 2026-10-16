package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzad extends zzos {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f73378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set f73379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f73380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Long f73381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f73382h;

    zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy n(Integer num) {
        if (this.f73380f.containsKey(num)) {
            return (zzy) this.f73380f.get(num);
        }
        zzy zzyVar = new zzy(this, this.f73378d, null);
        this.f73380f.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean o(int i3, int i4) {
        zzy zzyVar = (zzy) this.f73380f.get(Integer.valueOf(i3));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.c().get(i4);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:405:0x0969, code lost:
    
        r0 = r13.a().r();
        r2 = com.google.android.gms.measurement.internal.zzgu.x(r34.f73378d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x097b, code lost:
    
        if (r12.zza() == false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x097d, code lost:
    
        r3 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0986, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0987, code lost:
    
        r0.c("Invalid property filter ID. appId, id", r2, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0854 A[PHI: r0 r13 r36
      0x0854: PHI (r0v120 java.util.Map) = (r0v122 java.util.Map), (r0v128 java.util.Map) binds: [B:370:0x0878, B:360:0x0852] A[DONT_GENERATE, DONT_INLINE]
      0x0854: PHI (r13v4 android.database.Cursor) = (r13v5 android.database.Cursor), (r13v6 android.database.Cursor) binds: [B:370:0x0878, B:360:0x0852] A[DONT_GENERATE, DONT_INLINE]
      0x0854: PHI (r36v4 java.util.Iterator) = (r36v5 java.util.Iterator), (r36v9 java.util.Iterator) binds: [B:370:0x0878, B:360:0x0852] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a48  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a2 A[Catch: all -> 0x01b0, SQLiteException -> 0x01b3, TRY_LEAVE, TryCatch #13 {all -> 0x01b0, blocks: (B:59:0x019c, B:61:0x01a2, B:69:0x01bc, B:70:0x01c1, B:71:0x01cb, B:72:0x01db, B:81:0x0207, B:74:0x01ea, B:78:0x01fa, B:80:0x0200, B:98:0x0230), top: B:452:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bc A[Catch: all -> 0x01b0, SQLiteException -> 0x01b3, TRY_ENTER, TryCatch #13 {all -> 0x01b0, blocks: (B:59:0x019c, B:61:0x01a2, B:69:0x01bc, B:70:0x01c1, B:71:0x01cb, B:72:0x01db, B:81:0x0207, B:74:0x01ea, B:78:0x01fa, B:80:0x0200, B:98:0x0230), top: B:452:0x019c }] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List m(java.lang.String r35, java.util.List r36, java.util.List r37, java.lang.Long r38, java.lang.Long r39, boolean r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.m(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }
}
