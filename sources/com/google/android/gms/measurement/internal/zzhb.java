package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhb extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzpg f73783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f73784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f73785c;

    zzhb(zzpg zzpgVar) {
        Preconditions.m(zzpgVar);
        this.f73783a = zzpgVar;
    }

    public final void a() {
        zzpg zzpgVar = this.f73783a;
        zzpgVar.O0();
        zzpgVar.b().h();
        if (this.f73784b) {
            return;
        }
        zzpgVar.d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f73785c = zzpgVar.E0().m();
        zzpgVar.a().w().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f73785c));
        this.f73784b = true;
    }

    public final void b() {
        zzpg zzpgVar = this.f73783a;
        zzpgVar.O0();
        zzpgVar.b().h();
        zzpgVar.b().h();
        if (this.f73784b) {
            zzpgVar.a().w().a("Unregistering connectivity change receiver");
            this.f73784b = false;
            this.f73785c = false;
            try {
                zzpgVar.d().unregisterReceiver(this);
            } catch (IllegalArgumentException e3) {
                this.f73783a.a().o().b("Failed to unregister the network broadcast receiver", e3);
            }
        }
    }

    final /* synthetic */ zzpg c() {
        return this.f73783a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzpg zzpgVar = this.f73783a;
        zzpgVar.O0();
        String action = intent.getAction();
        zzpgVar.a().w().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            zzpgVar.a().r().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM = zzpgVar.E0().m();
        if (this.f73785c != zM) {
            this.f73785c = zM;
            zzpgVar.b().t(new zzha(this, zM));
        }
    }
}
