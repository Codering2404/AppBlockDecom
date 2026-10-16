package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public class MediationAdConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f70476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f70477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f70478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f70479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f70480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f70481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f70482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f70483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f70484i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z2, Location location, int i3, int i4, String str2, String str3) {
        this.f70476a = str;
        this.f70477b = bundle;
        this.f70478c = bundle2;
        this.f70479d = context;
        this.f70480e = z2;
        this.f70481f = i3;
        this.f70482g = i4;
        this.f70483h = str2;
        this.f70484i = str3;
    }

    public String a() {
        return this.f70476a;
    }

    public Context b() {
        return this.f70479d;
    }

    public Bundle c() {
        return this.f70478c;
    }

    public Bundle d() {
        return this.f70477b;
    }

    public String e() {
        return this.f70484i;
    }

    public int f() {
        return this.f70481f;
    }

    public int g() {
        return this.f70482g;
    }
}
