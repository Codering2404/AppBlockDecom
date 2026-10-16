package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        /* JADX INFO: renamed from: I1 */
        Builder q(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        MessageLite build();

        Builder c2(MessageLite messageLite);

        MessageLite f();

        Builder n(byte[] bArr);
    }

    Builder a();

    ByteString b();

    int c();

    Builder e();

    Parser h();

    byte[] i();

    void j(CodedOutputStream codedOutputStream);
}
