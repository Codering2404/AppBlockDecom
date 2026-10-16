package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzgta;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzal implements zzgta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzal f70644a = new zzal();

    private /* synthetic */ zzal() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        List list = zzap.H;
        return ((JSONObject) obj).optString("nas");
    }
}
