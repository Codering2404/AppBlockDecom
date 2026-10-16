package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.TimeProvider;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RemoteSettings_Factory implements Factory<RemoteSettings> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f90189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f90190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f90191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f90192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f90193e;

    public RemoteSettings_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.f90189a = provider;
        this.f90190b = provider2;
        this.f90191c = provider3;
        this.f90192d = provider4;
        this.f90193e = provider5;
    }

    public static RemoteSettings_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new RemoteSettings_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static RemoteSettings c(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, SettingsCache settingsCache) {
        return new RemoteSettings(timeProvider, firebaseInstallationsApi, applicationInfo, crashlyticsSettingsFetcher, settingsCache);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteSettings get() {
        return c((TimeProvider) this.f90189a.get(), (FirebaseInstallationsApi) this.f90190b.get(), (ApplicationInfo) this.f90191c.get(), (CrashlyticsSettingsFetcher) this.f90192d.get(), (SettingsCache) this.f90193e.get());
    }
}
