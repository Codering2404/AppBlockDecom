package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.EventContext;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Singleton
public class TransportRuntime implements TransportInternal {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile TransportRuntimeComponent f69362e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f69363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f69364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Scheduler f69365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uploader f69366d;

    TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f69363a = clock;
        this.f69364b = clock2;
        this.f69365c = scheduler;
        this.f69366d = uploader;
        workInitializer.c();
    }

    private EventInternal b(SendRequest sendRequest) {
        EventInternal.Builder builderG = EventInternal.a().i(this.f69363a.a()).o(this.f69364b.a()).n(sendRequest.g()).h(new EncodedPayload(sendRequest.b(), sendRequest.d())).g(sendRequest.c().a());
        if (sendRequest.c().e() != null && sendRequest.c().e().a() != null) {
            builderG.l(sendRequest.c().e().a());
        }
        if (sendRequest.c().b() != null) {
            EventContext eventContextB = sendRequest.c().b();
            if (eventContextB.c() != null) {
                builderG.m(eventContextB.c());
            }
            if (eventContextB.a() != null) {
                builderG.j(eventContextB.a());
            }
            if (eventContextB.b() != null) {
                builderG.k(eventContextB.b());
            }
        }
        return builderG.d();
    }

    public static TransportRuntime c() {
        TransportRuntimeComponent transportRuntimeComponent = f69362e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(Destination destination) {
        return destination instanceof EncodedDestination ? Collections.unmodifiableSet(((EncodedDestination) destination).a()) : Collections.singleton(Encoding.b("proto"));
    }

    public static void f(Context context) {
        if (f69362e == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (f69362e == null) {
                        f69362e = DaggerTransportRuntimeComponent.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    public void a(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f69365c.a(sendRequest.f().f(sendRequest.c().d()), b(sendRequest), transportScheduleCallback);
    }

    public Uploader e() {
        return this.f69366d;
    }

    public TransportFactory g(Destination destination) {
        return new TransportFactoryImpl(d(destination), TransportContext.a().b(destination.getName()).c(destination.getExtras()).a(), this);
    }

    public TransportFactory h(String str) {
        return new TransportFactoryImpl(d(null), TransportContext.a().b(str).a(), this);
    }
}
