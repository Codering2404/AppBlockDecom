package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RtbSignalData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f70536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f70537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdSize f70538d;

    public RtbSignalData(Context context, List list, Bundle bundle, AdSize adSize) {
        this.f70535a = context;
        this.f70536b = list;
        this.f70537c = bundle;
        this.f70538d = adSize;
    }

    public Context a() {
        return this.f70535a;
    }

    public Bundle b() {
        return this.f70537c;
    }
}
