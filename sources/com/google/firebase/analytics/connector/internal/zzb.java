package com.google.firebase.analytics.connector.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzb implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzb f87677a = new zzb();

    private /* synthetic */ zzb() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final /* synthetic */ Object a(ComponentContainer componentContainer) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(componentContainer);
    }
}
