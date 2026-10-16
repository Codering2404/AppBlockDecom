package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    private static int i(int i3, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int iA = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            iA += mapEntryLite.a(i3, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    private static MapFieldLite j(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteO = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteO.j()) {
                mapFieldLiteO = mapFieldLiteO.o();
            }
            mapFieldLiteO.m(mapFieldLite);
        }
        return mapFieldLiteO;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public MapEntryLite.Metadata b(Object obj) {
        return ((MapEntryLite) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public Map c(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public Object d(Object obj) {
        return MapFieldLite.e().o();
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public Map e(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public Object f(Object obj) {
        ((MapFieldLite) obj).k();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public int g(int i3, Object obj, Object obj2) {
        return i(i3, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public boolean h(Object obj) {
        return !((MapFieldLite) obj).j();
    }
}
