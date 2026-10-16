package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    ExtensionSchema() {
    }

    abstract int a(Map.Entry entry);

    abstract Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i3);

    abstract FieldSet c(Object obj);

    abstract FieldSet d(Object obj);

    abstract boolean e(MessageLite messageLite);

    abstract void f(Object obj);

    abstract Object g(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, Object obj3, UnknownFieldSchema unknownFieldSchema);

    abstract void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet);

    abstract void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet);

    abstract void j(Writer writer, Map.Entry entry);
}
