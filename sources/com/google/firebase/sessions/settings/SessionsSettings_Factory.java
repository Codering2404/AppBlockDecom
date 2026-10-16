package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90210b;

    public SessionsSettings_Factory(Provider provider, Provider provider2) {
        this.f90209a = provider;
        this.f90210b = provider2;
    }

    public static SessionsSettings_Factory a(Provider provider, Provider provider2) {
        return new SessionsSettings_Factory(provider, provider2);
    }

    public static SessionsSettings c(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        return new SessionsSettings(settingsProvider, settingsProvider2);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionsSettings get() {
        return c((SettingsProvider) this.f90209a.get(), (SettingsProvider) this.f90210b.get());
    }
}
