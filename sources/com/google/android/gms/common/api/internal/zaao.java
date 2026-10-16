package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaao extends zaav {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f71660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zaaw f71661c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaawVar, Map map) {
        super(zaawVar, null);
        this.f71661c = zaawVar;
        this.f71660b = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void a() {
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(this.f71661c.f71672d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f71660b.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaal) this.f71660b.get(client)).f71656c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i3 = 0;
        int iB = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                iB = zalVar.b(this.f71661c.f71671c, (Api.Client) arrayList.get(i3));
                i3++;
                if (iB != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i3 < size2) {
                iB = zalVar.b(this.f71661c.f71671c, (Api.Client) arrayList2.get(i3));
                i3++;
                if (iB == 0) {
                    break;
                }
            }
        }
        if (iB != 0) {
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            zaaw zaawVar = this.f71661c;
            zaawVar.f71669a.o(new zaam(this, zaawVar, connectionResult));
            return;
        }
        zaaw zaawVar2 = this.f71661c;
        if (zaawVar2.f71681m && zaawVar2.f71679k != null) {
            zaawVar2.f71679k.b();
        }
        for (Api.Client client2 : this.f71660b.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.f71660b.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.b(this.f71661c.f71671c, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaawVar3 = this.f71661c;
                zaawVar3.f71669a.o(new zaan(this, zaawVar3, connectionProgressReportCallbacks));
            }
        }
    }
}
