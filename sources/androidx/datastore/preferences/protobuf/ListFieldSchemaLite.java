package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    ListFieldSchemaLite() {
    }

    static Internal.ProtobufList d(Object obj, long j3) {
        return (Internal.ProtobufList) UnsafeUtil.H(obj, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public void a(Object obj, long j3) {
        d(obj, j3).j();
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public void b(Object obj, Object obj2, long j3) {
        Internal.ProtobufList protobufListD = d(obj, j3);
        Internal.ProtobufList protobufListD2 = d(obj2, j3);
        int size = protobufListD.size();
        int size2 = protobufListD2.size();
        if (size > 0 && size2 > 0) {
            if (!protobufListD.m()) {
                protobufListD = protobufListD.c(size2 + size);
            }
            protobufListD.addAll(protobufListD2);
        }
        if (size > 0) {
            protobufListD2 = protobufListD;
        }
        UnsafeUtil.Y(obj, j3, protobufListD2);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public List c(Object obj, long j3) {
        Internal.ProtobufList protobufListD = d(obj, j3);
        if (protobufListD.m()) {
            return protobufListD;
        }
        int size = protobufListD.size();
        Internal.ProtobufList protobufListC = protobufListD.c(size == 0 ? 10 : size * 2);
        UnsafeUtil.Y(obj, j3, protobufListC);
        return protobufListC;
    }
}
