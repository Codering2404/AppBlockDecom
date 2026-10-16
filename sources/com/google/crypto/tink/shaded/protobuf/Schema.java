package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
interface Schema<T> {
    void a(Object obj, Object obj2);

    void b(Object obj);

    boolean c(Object obj);

    int d(Object obj);

    int e(Object obj);

    boolean f(Object obj, Object obj2);

    void g(Object obj, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers);

    void h(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void i(Object obj, Writer writer);

    Object newInstance();
}
