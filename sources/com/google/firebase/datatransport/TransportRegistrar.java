package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ TransportFactory a(ComponentContainer componentContainer) {
        TransportRuntime.f((Context) componentContainer.a(Context.class));
        return TransportRuntime.c().g(CCTDestination.f69065g);
    }

    public static /* synthetic */ TransportFactory b(ComponentContainer componentContainer) {
        TransportRuntime.f((Context) componentContainer.a(Context.class));
        return TransportRuntime.c().g(CCTDestination.f69066h);
    }

    public static /* synthetic */ TransportFactory c(ComponentContainer componentContainer) {
        TransportRuntime.f((Context) componentContainer.a(Context.class));
        return TransportRuntime.c().g(CCTDestination.f69066h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.e(TransportFactory.class).h(LIBRARY_NAME).b(Dependency.l(Context.class)).f(new ComponentFactory() { // from class: x.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return TransportRegistrar.c(componentContainer);
            }
        }).d(), Component.c(Qualified.a(LegacyTransportBackend.class, TransportFactory.class)).b(Dependency.l(Context.class)).f(new ComponentFactory() { // from class: x.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return TransportRegistrar.b(componentContainer);
            }
        }).d(), Component.c(Qualified.a(TransportBackend.class, TransportFactory.class)).b(Dependency.l(Context.class)).f(new ComponentFactory() { // from class: x.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return TransportRegistrar.a(componentContainer);
            }
        }).d(), LibraryVersionComponent.b(LIBRARY_NAME, "19.0.0"));
    }
}
