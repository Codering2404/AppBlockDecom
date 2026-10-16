package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public interface MessageLite extends MessageLiteOrBuilder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        /* JADX INFO: renamed from: R0 */
        Builder r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder T(MessageLite messageLite);

        MessageLite build();

        MessageLite f();

        Builder n(byte[] bArr);
    }

    Builder a();

    ByteString b();

    int c();

    Builder e();

    Parser h();

    void i(CodedOutputStream codedOutputStream);
}
