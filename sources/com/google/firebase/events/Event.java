package com.google.firebase.events;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Event<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f89181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f89182b;

    public Object a() {
        return this.f89182b;
    }

    public Class b() {
        return this.f89181a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f89181a, this.f89182b);
    }
}
