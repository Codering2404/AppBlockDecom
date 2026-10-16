package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface ComponentContainer {
    default Object a(Class cls) {
        return e(Qualified.b(cls));
    }

    Provider b(Qualified qualified);

    default Set c(Qualified qualified) {
        return (Set) d(qualified).get();
    }

    Provider d(Qualified qualified);

    default Object e(Qualified qualified) {
        Provider providerB = b(qualified);
        if (providerB == null) {
            return null;
        }
        return providerB.get();
    }

    default Set f(Class cls) {
        return c(Qualified.b(cls));
    }

    default Provider g(Class cls) {
        return b(Qualified.b(cls));
    }

    Deferred h(Qualified qualified);

    default Deferred i(Class cls) {
        return h(Qualified.b(cls));
    }
}
