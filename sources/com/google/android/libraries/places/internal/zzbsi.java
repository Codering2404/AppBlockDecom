package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbsi extends zzbwn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f76791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbnp f76792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbpm f76793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbje[] f76794e;

    public zzbsi(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbje[] zzbjeVarArr) {
        Preconditions.e(!zzbnpVar.j(), "error must not be OK");
        this.f76792c = zzbnpVar;
        this.f76793d = zzbpmVar;
        this.f76794e = zzbjeVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbwn, com.google.android.libraries.places.internal.zzbpl
    public final void a(zzbpn zzbpnVar) {
        Preconditions.A(!this.f76791b, "already started");
        this.f76791b = true;
        int i3 = 0;
        while (true) {
            zzbje[] zzbjeVarArr = this.f76794e;
            if (i3 >= zzbjeVarArr.length) {
                zzbpnVar.b(this.f76792c, this.f76793d, new zzbmg());
                return;
            } else {
                zzbje zzbjeVar = zzbjeVarArr[i3];
                i3++;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwn, com.google.android.libraries.places.internal.zzbpl
    public final void g(zzbtf zzbtfVar) {
        zzbtfVar.b("error", this.f76792c);
        zzbtfVar.b("progress", this.f76793d);
    }
}
