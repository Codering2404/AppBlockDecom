package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StreamingAeadWrapper f87334a = new StreamingAeadWrapper();

    StreamingAeadWrapper() {
    }

    public static void b() {
        Registry.g(f87334a);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return StreamingAead.class;
    }
}
