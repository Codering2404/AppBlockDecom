package com.iab.omid.library.applovin.internal;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.applovin.weakreference.a f92146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f92148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f92149d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f92146a = new com.iab.omid.library.applovin.weakreference.a(view);
        this.f92147b = view.getClass().getCanonicalName();
        this.f92148c = friendlyObstructionPurpose;
        this.f92149d = str;
    }

    public String a() {
        return this.f92149d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f92148c;
    }

    public com.iab.omid.library.applovin.weakreference.a c() {
        return this.f92146a;
    }

    public String d() {
        return this.f92147b;
    }
}
