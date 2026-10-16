package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.sessions.api.SessionSubscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsAppQualitySessionsSubscriber implements SessionSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataCollectionArbiter f88341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsStore f88342b;

    public CrashlyticsAppQualitySessionsSubscriber(DataCollectionArbiter dataCollectionArbiter, FileStore fileStore) {
        this.f88341a = dataCollectionArbiter;
        this.f88342b = new CrashlyticsAppQualitySessionsStore(fileStore);
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public boolean a() {
        return this.f88341a.d();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public SessionSubscriber.Name b() {
        return SessionSubscriber.Name.f90138a;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public void c(SessionSubscriber.SessionDetails sessionDetails) {
        Logger.f().b("App Quality Sessions session changed: " + sessionDetails);
        this.f88342b.f(sessionDetails.a());
    }

    public String d(String str) {
        return this.f88342b.c(str);
    }

    public void e(String str) {
        this.f88342b.g(str);
    }
}
