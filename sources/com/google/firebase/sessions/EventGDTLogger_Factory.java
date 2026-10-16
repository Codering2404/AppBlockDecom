package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89955a;

    public EventGDTLogger_Factory(Provider provider) {
        this.f89955a = provider;
    }

    public static EventGDTLogger_Factory a(Provider provider) {
        return new EventGDTLogger_Factory(provider);
    }

    public static EventGDTLogger c(com.google.firebase.inject.Provider provider) {
        return new EventGDTLogger(provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public EventGDTLogger get() {
        return c((com.google.firebase.inject.Provider) this.f89955a.get());
    }
}
