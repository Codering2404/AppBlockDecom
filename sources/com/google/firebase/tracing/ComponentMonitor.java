package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.tracing.ComponentMonitor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ComponentMonitor implements ComponentRegistrarProcessor {
    public static /* synthetic */ Object b(String str, Component component, ComponentContainer componentContainer) {
        try {
            FirebaseTrace.b(str);
            return component.h().a(componentContainer);
        } finally {
            FirebaseTrace.a();
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final Component componentR : componentRegistrar.getComponents()) {
            final String strI = componentR.i();
            if (strI != null) {
                componentR = componentR.r(new ComponentFactory() { // from class: z.a
                    @Override // com.google.firebase.components.ComponentFactory
                    public final Object a(ComponentContainer componentContainer) {
                        return ComponentMonitor.b(strI, componentR, componentContainer);
                    }
                });
            }
            arrayList.add(componentR);
        }
        return arrayList;
    }
}
