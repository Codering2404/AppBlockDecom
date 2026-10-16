package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class f86275d;

    protected PrivateKeyTypeManager(Class cls, Class cls2, PrimitiveFactory... primitiveFactoryArr) {
        super(cls, primitiveFactoryArr);
        this.f86275d = cls2;
    }
}
