package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90159a;

    public LocalOverrideSettings_Factory(Provider provider) {
        this.f90159a = provider;
    }

    public static LocalOverrideSettings_Factory a(Provider provider) {
        return new LocalOverrideSettings_Factory(provider);
    }

    public static LocalOverrideSettings c(Context context) {
        return new LocalOverrideSettings(context);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LocalOverrideSettings get() {
        return c((Context) this.f90159a.get());
    }
}
