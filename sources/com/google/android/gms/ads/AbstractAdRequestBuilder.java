package com.google.android.gms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.internal.client.zzeg;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractAdRequestBuilder<T extends AbstractAdRequestBuilder<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzeg f69625a;

    protected AbstractAdRequestBuilder() {
        zzeg zzegVar = new zzeg();
        this.f69625a = zzegVar;
        zzegVar.j("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public AbstractAdRequestBuilder a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(",")) {
            StringBuilder sb = new StringBuilder(str2.length() + 108);
            sb.append("Value ");
            sb.append(str2);
            sb.append(" contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
            zzo.f(sb.toString());
        }
        this.f69625a.q(str, str2);
        return d();
    }

    public AbstractAdRequestBuilder b(String str) {
        this.f69625a.g(str);
        return d();
    }

    public AbstractAdRequestBuilder c(Class cls, Bundle bundle) {
        zzeg zzegVar = this.f69625a;
        zzegVar.i(cls, bundle);
        if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            zzegVar.k("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return d();
    }

    protected abstract AbstractAdRequestBuilder d();

    public AbstractAdRequestBuilder e(String str) {
        this.f69625a.t(str);
        return d();
    }

    public AbstractAdRequestBuilder f(String str) {
        Preconditions.n(str, "Content URL must be non-null.");
        Preconditions.h(str, "Content URL must be non-empty.");
        int length = str.length();
        Preconditions.c(length <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
        this.f69625a.l(str);
        return d();
    }

    public AbstractAdRequestBuilder g(List list) {
        if (list == null) {
            zzo.f("neighboring content URLs list should not be null");
            return d();
        }
        this.f69625a.m(list);
        return d();
    }

    public AbstractAdRequestBuilder h(String str) {
        this.f69625a.o(str);
        return d();
    }

    public final AbstractAdRequestBuilder i(Bundle bundle) {
        this.f69625a.h(bundle);
        return d();
    }

    public final AbstractAdRequestBuilder j(String str) {
        this.f69625a.j(str);
        return d();
    }

    public final AbstractAdRequestBuilder k(boolean z2) {
        this.f69625a.p(z2);
        return d();
    }

    public final AbstractAdRequestBuilder l(boolean z2) {
        this.f69625a.s(z2);
        return d();
    }
}
