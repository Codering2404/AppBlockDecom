package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class PrivateKeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyManagerImpl<PrimitiveT, KeyProtoT> implements PrivateKeyManager<PrimitiveT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PrivateKeyTypeManager f86044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final KeyTypeManager f86045d;

    public PrivateKeyManagerImpl(PrivateKeyTypeManager privateKeyTypeManager, KeyTypeManager keyTypeManager, Class cls) {
        super(privateKeyTypeManager, cls);
        this.f86044c = privateKeyTypeManager;
        this.f86045d = keyTypeManager;
    }
}
