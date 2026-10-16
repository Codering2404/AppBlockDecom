package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaaj implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zabi f71651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f71652b = false;

    public zaaj(zabi zabiVar) {
        this.f71651a = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void c() {
        if (this.f71652b) {
            this.f71652b = false;
            this.f71651a.o(new zaai(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void e(int i3) {
        this.f71651a.n(null);
        this.f71651a.f71742p.b(i3, this.f71652b);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl f(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        h(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean g() {
        if (this.f71652b) {
            return false;
        }
        Set set = this.f71651a.f71741o.f71723w;
        if (set == null || set.isEmpty()) {
            this.f71651a.n(null);
            return true;
        }
        this.f71652b = true;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((zada) it.next()).j();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.f71651a.f71741o.f71724x.a(apiMethodImpl);
            zabe zabeVar = this.f71651a.f71741o;
            Api.Client client = (Api.Client) zabeVar.f71715o.get(apiMethodImpl.getClientKey());
            Preconditions.n(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.f71651a.f71734h.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.run(client);
                return apiMethodImpl;
            }
            apiMethodImpl.setFailedResult(new Status(17));
            return apiMethodImpl;
        } catch (DeadObjectException unused) {
            this.f71651a.o(new zaah(this, this));
            return apiMethodImpl;
        }
    }

    final void j() {
        if (this.f71652b) {
            this.f71652b = false;
            this.f71651a.f71741o.f71724x.b();
            g();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void b() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void d(ConnectionResult connectionResult, Api api, boolean z2) {
    }
}
