package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExtensionRegistryLite f35960a = ExtensionRegistryLite.b();

    private MessageLite c(MessageLite messageLite) throws InvalidProtocolBufferException {
        if (messageLite == null || messageLite.isInitialized()) {
            return messageLite;
        }
        throw d(messageLite).a().k(messageLite);
    }

    private UninitializedMessageException d(MessageLite messageLite) {
        return messageLite instanceof AbstractMessageLite ? ((AbstractMessageLite) messageLite).m() : new UninitializedMessageException(messageLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Parser
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageLite a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return c(f(byteString, extensionRegistryLite));
    }

    public MessageLite f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStreamB = byteString.B();
        MessageLite messageLite = (MessageLite) b(codedInputStreamB, extensionRegistryLite);
        try {
            codedInputStreamB.a(0);
            return messageLite;
        } catch (InvalidProtocolBufferException e3) {
            throw e3.k(messageLite);
        }
    }
}
