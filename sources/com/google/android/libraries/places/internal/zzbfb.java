package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfb implements zzbfl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbex f76138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbfy f76139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f76140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbdc f76141d;

    private zzbfb(zzbfy zzbfyVar, zzbdc zzbdcVar, zzbex zzbexVar) {
        this.f76139b = zzbfyVar;
        this.f76140c = zzbexVar instanceof zzbdn;
        this.f76141d = zzbdcVar;
        this.f76138a = zzbexVar;
    }

    static zzbfb c(zzbfy zzbfyVar, zzbdc zzbdcVar, zzbex zzbexVar) {
        return new zzbfb(zzbfyVar, zzbdcVar, zzbexVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final void a(Object obj, zzbgl zzbglVar) {
        Iterator itD = ((zzbdn) obj).zzb.d();
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            zzbdf zzbdfVar = (zzbdf) entry.getKey();
            if (zzbdfVar.zzc() != zzbgk.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzbdfVar.zzd();
            zzbdfVar.zze();
            if (entry instanceof zzbef) {
                zzbdfVar.zza();
                zzbglVar.zzv(525004180, ((zzbef) entry).a().c());
            } else {
                zzbdfVar.zza();
                zzbglVar.zzv(525004180, entry.getValue());
            }
        }
        ((zzbdq) obj).zzc.f(zzbglVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        return;
     */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.Object r17, com.google.android.libraries.places.internal.zzbfk r18, com.google.android.libraries.places.internal.zzbdb r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = r18
            r3 = r19
            com.google.android.libraries.places.internal.zzbdc r4 = r1.f76141d
            com.google.android.libraries.places.internal.zzbfy r5 = r1.f76139b
            java.lang.Object r6 = r5.h(r2)
            com.google.android.libraries.places.internal.zzbdg r7 = r4.a(r2)
        L14:
            int r8 = r0.zzb()     // Catch: java.lang.Throwable -> L3a
            r9 = 2147483647(0x7fffffff, float:NaN)
            if (r8 != r9) goto L1e
            goto L49
        L1e:
            int r8 = r0.zzc()     // Catch: java.lang.Throwable -> L3a
            r10 = 11
            r11 = 0
            if (r8 == r10) goto L4d
            r9 = r8 & 7
            r10 = 2
            if (r9 != r10) goto L42
            com.google.android.libraries.places.internal.zzbex r9 = r1.f76138a     // Catch: java.lang.Throwable -> L3a
            int r8 = r8 >>> 3
            com.google.android.libraries.places.internal.zzbdp r8 = r3.b(r9, r8)     // Catch: java.lang.Throwable -> L3a
            if (r8 == 0) goto L3d
            r4.d(r0, r8, r3, r7)     // Catch: java.lang.Throwable -> L3a
            goto L14
        L3a:
            r0 = move-exception
            goto Lbe
        L3d:
            boolean r8 = r5.k(r6, r0, r11)     // Catch: java.lang.Throwable -> L3a
            goto L46
        L42:
            boolean r8 = r0.zzd()     // Catch: java.lang.Throwable -> L3a
        L46:
            if (r8 == 0) goto L49
            goto L14
        L49:
            r5.i(r2, r6)
            return
        L4d:
            r8 = 0
            r10 = r8
            r13 = r10
            r12 = r11
        L51:
            int r14 = r0.zzb()     // Catch: java.lang.Throwable -> L3a
            r15 = 12
            if (r14 != r9) goto L5a
            goto L87
        L5a:
            int r14 = r0.zzc()     // Catch: java.lang.Throwable -> L3a
            r9 = 16
            if (r14 != r9) goto L70
            int r12 = r0.zzt()     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbex r9 = r1.f76138a     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbdp r10 = r3.b(r9, r12)     // Catch: java.lang.Throwable -> L3a
        L6c:
            r9 = 2147483647(0x7fffffff, float:NaN)
            goto L51
        L70:
            r9 = 26
            if (r14 != r9) goto L7f
            if (r10 == 0) goto L7a
            r4.d(r0, r10, r3, r7)     // Catch: java.lang.Throwable -> L3a
            goto L6c
        L7a:
            com.google.android.libraries.places.internal.zzbcl r13 = r0.zzs()     // Catch: java.lang.Throwable -> L3a
            goto L6c
        L7f:
            if (r14 == r15) goto L87
            boolean r9 = r0.zzd()     // Catch: java.lang.Throwable -> L3a
            if (r9 != 0) goto L6c
        L87:
            int r9 = r0.zzc()     // Catch: java.lang.Throwable -> L3a
            if (r9 != r15) goto Lb6
            if (r13 == 0) goto L14
            if (r10 == 0) goto Lb1
            com.google.android.libraries.places.internal.zzbex r9 = r10.f76085a     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbdq r9 = (com.google.android.libraries.places.internal.zzbdq) r9     // Catch: java.lang.Throwable -> L3a
            r12 = 5
            java.lang.Object r8 = r9.l(r12, r8, r8)     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbdk r8 = (com.google.android.libraries.places.internal.zzbdk) r8     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbco r9 = r13.l()     // Catch: java.lang.Throwable -> L3a
            r8.m2(r9, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbdo r10 = r10.f76086b     // Catch: java.lang.Throwable -> L3a
            com.google.android.libraries.places.internal.zzbex r8 = r8.zzF()     // Catch: java.lang.Throwable -> L3a
            r7.f(r10, r8)     // Catch: java.lang.Throwable -> L3a
            r9.n(r11)     // Catch: java.lang.Throwable -> L3a
            goto L14
        Lb1:
            r5.d(r6, r12, r13)     // Catch: java.lang.Throwable -> L3a
            goto L14
        Lb6:
            com.google.android.libraries.places.internal.zzbed r0 = new com.google.android.libraries.places.internal.zzbed     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "Protocol message end-group tag did not match expected tag."
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            throw r0     // Catch: java.lang.Throwable -> L3a
        Lbe:
            r5.i(r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfb.b(java.lang.Object, com.google.android.libraries.places.internal.zzbfk, com.google.android.libraries.places.internal.zzbdb):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final Object zza() {
        zzbex zzbexVar = this.f76138a;
        return zzbexVar instanceof zzbdq ? ((zzbdq) zzbexVar).x() : zzbexVar.g().zzF();
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzbdq) obj).zzc.equals(((zzbdq) obj2).zzc)) {
            return false;
        }
        if (this.f76140c) {
            return ((zzbdn) obj).zzb.equals(((zzbdn) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final int zzc(Object obj) {
        int iHashCode = ((zzbdq) obj).zzc.hashCode();
        return this.f76140c ? (iHashCode * 53) + ((zzbdn) obj).zzb.f76045a.hashCode() : iHashCode;
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final void zzd(Object obj, Object obj2) {
        zzbfn.e(this.f76139b, obj, obj2);
        if (this.f76140c) {
            zzbfn.d(this.f76141d, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final int zze(Object obj) {
        int iH = ((zzbdq) obj).zzc.h();
        return this.f76140c ? iH + ((zzbdn) obj).zzb.i() : iH;
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final void zzh(Object obj) {
        this.f76139b.j(obj);
        this.f76141d.b(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final boolean zzi(Object obj) {
        return ((zzbdn) obj).zzb.g();
    }
}
