package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CctBackendFactory implements BackendFactory {
    @Override // com.google.android.datatransport.runtime.backends.BackendFactory
    public TransportBackend create(CreationContext creationContext) {
        return new CctTransportBackend(creationContext.b(), creationContext.e(), creationContext.d());
    }
}
