package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaap extends zaav {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f71662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zaaw f71663c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar, null);
        this.f71663c = zaawVar;
        this.f71662b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void a() {
        zaaw zaawVar = this.f71663c;
        zaawVar.f71669a.f71741o.f71716p = zaaw.y(zaawVar);
        ArrayList arrayList = this.f71662b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Api.Client client = (Api.Client) arrayList.get(i3);
            zaaw zaawVar2 = this.f71663c;
            client.getRemoteService(zaawVar2.f71683o, zaawVar2.f71669a.f71741o.f71716p);
        }
    }
}
