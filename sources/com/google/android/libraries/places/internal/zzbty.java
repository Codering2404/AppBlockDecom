package com.google.android.libraries.places.internal;

import com.facebook.appevents.integrity.IntegrityManager;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbty implements zzbwc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbqa f76877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f76878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbua f76879c;

    zzbty(zzbua zzbuaVar, zzbqa zzbqaVar) {
        Objects.requireNonNull(zzbuaVar);
        this.f76879c = zzbuaVar;
        this.f76878b = false;
        this.f76877a = zzbqaVar;
    }

    static final /* synthetic */ String c(zzbni zzbniVar) {
        int iOrdinal;
        if (zzbniVar == null || (iOrdinal = zzbniVar.ordinal()) == 0) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        if (iOrdinal == 1) {
            return "integrity_only";
        }
        if (iOrdinal == 2) {
            return "privacy_and_integrity";
        }
        throw new IllegalArgumentException("Unknown SecurityLevel: ".concat(zzbniVar.toString()));
    }

    static final /* synthetic */ String d(zzbio zzbioVar, zzbin zzbinVar) {
        String str = (String) zzbioVar.a(zzbinVar);
        return str == null ? "" : str;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void a(zzbnp zzbnpVar) {
        Object[] objArr = {this.f76877a.zzc(), zzbua.s(zzbnpVar)};
        zzbua zzbuaVar = this.f76879c;
        zzbuaVar.D().b(2, "{0} SHUTDOWN with {1}", objArr);
        this.f76878b = true;
        zzbtw zzbtwVar = new zzbtw(this, zzbnpVar);
        zzbnx zzbnxVarF = zzbuaVar.F();
        zzbnxVarF.a(zzbtwVar);
        zzbnxVarF.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final zzbio b(zzbio zzbioVar) {
        Iterator it = this.f76879c.E().iterator();
        if (!it.hasNext()) {
            return zzbioVar;
        }
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zzb() {
        zzbua zzbuaVar = this.f76879c;
        zzbuaVar.D().a(2, "READY");
        zzbtv zzbtvVar = new zzbtv(this);
        zzbnx zzbnxVarF = zzbuaVar.F();
        zzbnxVarF.a(zzbtvVar);
        zzbnxVarF.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zzc(boolean z2) {
        this.f76879c.y(this.f76877a, z2);
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final void zze() {
        Preconditions.A(this.f76878b, "transportShutdown() must be called before transportTerminated().");
        zzbqa zzbqaVar = this.f76877a;
        Object[] objArr = {zzbqaVar.zzc()};
        zzbua zzbuaVar = this.f76879c;
        zzbuaVar.D().b(2, "{0} Terminated", objArr);
        zzbuaVar.C().g(zzbqaVar);
        zzbuaVar.y(zzbqaVar, false);
        Iterator it = zzbuaVar.E().iterator();
        if (it.hasNext()) {
            zzbqaVar.zzf();
            throw null;
        }
        zzbnx zzbnxVarF = zzbuaVar.F();
        zzbnxVarF.a(new zzbtx(this));
        zzbnxVarF.zza();
    }
}
