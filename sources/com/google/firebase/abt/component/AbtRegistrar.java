package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    public static /* synthetic */ AbtComponent a(ComponentContainer componentContainer) {
        return new AbtComponent((Context) componentContainer.a(Context.class), componentContainer.g(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.e(AbtComponent.class).h(LIBRARY_NAME).b(Dependency.l(Context.class)).b(Dependency.j(AnalyticsConnector.class)).f(new ComponentFactory() { // from class: v.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return AbtRegistrar.a(componentContainer);
            }
        }).d(), LibraryVersionComponent.b(LIBRARY_NAME, "21.1.1"));
    }
}
