package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class TransportFactoryImpl implements TransportFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f69354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TransportContext f69355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TransportInternal f69356c;

    TransportFactoryImpl(Set set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f69354a = set;
        this.f69355b = transportContext;
        this.f69356c = transportInternal;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public Transport a(String str, Class cls, Encoding encoding, Transformer transformer) {
        if (this.f69354a.contains(encoding)) {
            return new TransportImpl(this.f69355b, str, encoding, transformer, this.f69356c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, this.f69354a));
    }
}
