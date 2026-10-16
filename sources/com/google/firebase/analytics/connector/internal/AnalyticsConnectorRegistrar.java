package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getComponents$0(ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.h((FirebaseApp) componentContainer.a(FirebaseApp.class), (Context) componentContainer.a(Context.class), (Subscriber) componentContainer.a(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.e(AnalyticsConnector.class).b(Dependency.l(FirebaseApp.class)).b(Dependency.l(Context.class)).b(Dependency.l(Subscriber.class)).f(zzb.f87677a).e().d(), LibraryVersionComponent.b("fire-analytics", "23.0.0"));
    }
}
