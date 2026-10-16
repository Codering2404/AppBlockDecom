package com.google.firebase.components;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface ComponentRegistrarProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComponentRegistrarProcessor f88107a = new ComponentRegistrarProcessor() { // from class: com.google.firebase.components.d
        @Override // com.google.firebase.components.ComponentRegistrarProcessor
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List a(ComponentRegistrar componentRegistrar);
}
