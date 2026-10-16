package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzeff;
import com.google.android.gms.internal.ads.zzegs;
import com.google.android.gms.internal.ads.zzhbe;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzba implements zzhbe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f70703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzeff f70704b;

    public zzba(Executor executor, zzeff zzeffVar) {
        this.f70703a = executor;
        this.f70704b = zzeffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        final zzcbd zzcbdVar = (zzcbd) obj;
        return zzhbw.zzj(this.f70704b.zza(zzcbdVar), new zzhbe() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaz
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj2) {
                zzegs zzegsVar = (zzegs) obj2;
                zzbc zzbcVar = new zzbc(new JsonReader(new InputStreamReader(zzegsVar.zza())), zzegsVar.zzb());
                try {
                    zzbcVar.f70707b = com.google.android.gms.ads.internal.client.zzay.a().y(zzcbdVar.zza).toString();
                } catch (JSONException unused) {
                    zzbcVar.f70707b = JsonUtils.EMPTY_JSON;
                }
                return zzhbw.zza(zzbcVar);
            }
        }, this.f70703a);
    }
}
