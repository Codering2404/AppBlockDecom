package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyTypeManager f86000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86001b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
    }

    public KeyManagerImpl(KeyTypeManager keyTypeManager, Class cls) {
        if (!keyTypeManager.e().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), cls.getName()));
        }
        this.f86000a = keyTypeManager;
        this.f86001b = cls;
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String a() {
        return this.f86000a.c();
    }
}
