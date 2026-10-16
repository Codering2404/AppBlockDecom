package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f69989a = new Bundle();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f69990b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f69991c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f69992d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f69993e = new Bundle();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f69994f = new Bundle();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f69995g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f69996h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f69997i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f69998j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f69999k = 60000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f70000l = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f70001m = 0;

    public final zzm a() {
        Bundle bundle = this.f69989a;
        Bundle bundle2 = this.f69993e;
        List list = this.f69990b;
        boolean z2 = this.f69991c;
        int i3 = this.f69992d;
        int i4 = this.f69996h;
        String str = this.f69997i;
        List list2 = this.f69998j;
        int i5 = this.f70000l;
        return new zzm(8, -1L, bundle, -1, list, z2, i3, false, null, null, null, null, bundle2, this.f69994f, this.f69995g, null, null, false, null, i4, str, list2, this.f69999k, null, i5, this.f70001m, 0L);
    }

    public final zzn b(Bundle bundle) {
        this.f69989a = bundle;
        return this;
    }

    public final zzn c(List list) {
        this.f69990b = list;
        return this;
    }

    public final zzn d(boolean z2) {
        this.f69991c = z2;
        return this;
    }

    public final zzn e(int i3) {
        this.f69992d = i3;
        return this;
    }

    public final zzn f(int i3) {
        this.f69996h = i3;
        return this;
    }

    public final zzn g(String str) {
        this.f69997i = str;
        return this;
    }

    public final zzn h(int i3) {
        this.f69999k = i3;
        return this;
    }

    public final zzn i(long j3) {
        this.f70001m = j3;
        return this;
    }
}
