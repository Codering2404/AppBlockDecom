package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.auth.PlacesAppCheckTokenProvider;
import com.google.common.base.Preconditions;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f78218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Locale f78219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f78220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PlacesAppCheckTokenProvider f78221d;

    public final synchronized void a(String str, Locale locale, boolean z2) {
        Preconditions.u(str, "API Key must not be null.");
        Preconditions.e(!str.isEmpty(), "API Key must not be empty.");
        this.f78218a = str;
        this.f78219b = locale;
        this.f78220c = z2;
    }

    public final synchronized boolean b() {
        return this.f78218a != null;
    }

    public final synchronized String c() {
        Preconditions.A(b(), "ApiConfig must be initialized.");
        Preconditions.t(this.f78218a);
        return this.f78218a;
    }

    public final synchronized Locale d() {
        try {
            Preconditions.A(b(), "ApiConfig must be initialized.");
        } catch (Throwable th) {
            throw th;
        }
        return this.f78219b == null ? Locale.getDefault() : this.f78219b;
    }

    public final boolean e() {
        return this.f78220c;
    }

    public final PlacesAppCheckTokenProvider f() {
        Preconditions.A(b(), "ApiConfig must be initialized.");
        return this.f78221d;
    }
}
