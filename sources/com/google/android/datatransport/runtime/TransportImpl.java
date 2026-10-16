package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class TransportImpl<T> implements Transport<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransportContext f69357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Encoding f69359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Transformer f69360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TransportInternal f69361e;

    TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer transformer, TransportInternal transportInternal) {
        this.f69357a = transportContext;
        this.f69358b = str;
        this.f69359c = encoding;
        this.f69360d = transformer;
        this.f69361e = transportInternal;
    }

    @Override // com.google.android.datatransport.Transport
    public void a(Event event, TransportScheduleCallback transportScheduleCallback) {
        this.f69361e.a(SendRequest.a().e(this.f69357a).c(event).f(this.f69358b).d(this.f69360d).b(this.f69359c).a(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void b(Event event) {
        a(event, new TransportScheduleCallback() { // from class: com.google.android.datatransport.runtime.a
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void a(Exception exc) {
                TransportImpl.c(exc);
            }
        });
    }

    TransportContext d() {
        return this.f69357a;
    }

    public static /* synthetic */ void c(Exception exc) {
    }
}
