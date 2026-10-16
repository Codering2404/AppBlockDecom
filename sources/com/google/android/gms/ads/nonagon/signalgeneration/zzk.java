package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzdzq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzk extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzj f70750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdzq f70751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f70752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f70753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f70754e = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Boolean f70755f;

    public zzk(zzj zzjVar, boolean z2, int i3, Boolean bool, zzdzq zzdzqVar) {
        this.f70750a = zzjVar;
        this.f70752c = z2;
        this.f70753d = i3;
        this.f70755f = bool;
        this.f70751b = zzdzqVar;
    }

    private static long a() {
        return com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() + ((Long) zzbkv.zzh.zze()).longValue();
    }

    private final long b() {
        return com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - this.f70754e;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair pair = new Pair("se", "query_g");
        Pair pair2 = new Pair("ad_format", AdFormat.BANNER.name());
        Pair pair3 = new Pair("rtype", Integer.toString(6));
        Pair pair4 = new Pair("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        Pair pair5 = new Pair("lat_ms", Long.toString(b()));
        int i3 = this.f70753d;
        Pair pair6 = new Pair("sgpc_rn", Integer.toString(i3));
        Pair pair7 = new Pair("sgpc_lsu", String.valueOf(this.f70755f));
        boolean z2 = this.f70752c;
        zzv.e(this.f70751b, null, "sgpcs", pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair("tpc", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES));
        this.f70750a.c(z2, new zzl(queryInfo, "", a(), i3));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair pair = new Pair("sgf_reason", str);
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair("ad_format", AdFormat.BANNER.name());
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        Pair pair6 = new Pair(muQRKXGtpOhe.lySXRrYGvAAPbd, Long.toString(b()));
        int i3 = this.f70753d;
        Pair pair7 = new Pair("sgpc_rn", Integer.toString(i3));
        Pair pair8 = new Pair("sgpc_lsu", String.valueOf(this.f70755f));
        boolean z2 = this.f70752c;
        zzv.e(this.f70751b, null, "sgpcf", pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, new Pair("tpc", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES));
        this.f70750a.c(z2, new zzl(null, str, a(), i3));
    }
}
