package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zza implements EventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zza f87694a = new zza();

    private /* synthetic */ zza() {
    }

    @Override // com.google.firebase.events.EventHandler
    public final /* synthetic */ void a(Event event) {
        AnalyticsConnectorImpl.i(event);
    }
}
