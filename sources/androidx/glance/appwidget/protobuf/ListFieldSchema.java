package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class ListFieldSchema {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ListFieldSchema f39135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ListFieldSchema f39136b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ListFieldSchemaFull extends ListFieldSchema {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class f39137c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static List f(Object obj, long j3) {
            return (List) UnsafeUtil.H(obj, j3);
        }

        private static List g(Object obj, long j3, int i3) {
            List listF = f(obj, j3);
            if (listF.isEmpty()) {
                List lazyStringArrayList = listF instanceof LazyStringList ? new LazyStringArrayList(i3) : ((listF instanceof PrimitiveNonBoxingCollection) && (listF instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) listF).c(i3) : new ArrayList(i3);
                UnsafeUtil.Y(obj, j3, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (f39137c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i3);
                arrayList.addAll(listF);
                UnsafeUtil.Y(obj, j3, arrayList);
                return arrayList;
            }
            if (listF instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(listF.size() + i3);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) listF);
                UnsafeUtil.Y(obj, j3, lazyStringArrayList2);
                return lazyStringArrayList2;
            }
            if ((listF instanceof PrimitiveNonBoxingCollection) && (listF instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) listF;
                if (!protobufList.m()) {
                    Internal.ProtobufList protobufListC = protobufList.c(listF.size() + i3);
                    UnsafeUtil.Y(obj, j3, protobufListC);
                    return protobufListC;
                }
            }
            return listF;
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        void c(Object obj, long j3) {
            Object objUnmodifiableList;
            List list = (List) UnsafeUtil.H(obj, j3);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).F();
            } else {
                if (f39137c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.m()) {
                        protobufList.j();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.Y(obj, j3, objUnmodifiableList);
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        void d(Object obj, Object obj2, long j3) {
            List listF = f(obj2, j3);
            List listG = g(obj, j3, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            UnsafeUtil.Y(obj, j3, listF);
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        List e(Object obj, long j3) {
            return g(obj, j3, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static Internal.ProtobufList f(Object obj, long j3) {
            return (Internal.ProtobufList) UnsafeUtil.H(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        void c(Object obj, long j3) {
            f(obj, j3).j();
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        void d(Object obj, Object obj2, long j3) {
            Internal.ProtobufList protobufListF = f(obj, j3);
            Internal.ProtobufList protobufListF2 = f(obj2, j3);
            int size = protobufListF.size();
            int size2 = protobufListF2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufListF.m()) {
                    protobufListF = protobufListF.c(size2 + size);
                }
                protobufListF.addAll(protobufListF2);
            }
            if (size > 0) {
                protobufListF2 = protobufListF;
            }
            UnsafeUtil.Y(obj, j3, protobufListF2);
        }

        @Override // androidx.glance.appwidget.protobuf.ListFieldSchema
        List e(Object obj, long j3) {
            Internal.ProtobufList protobufListF = f(obj, j3);
            if (protobufListF.m()) {
                return protobufListF;
            }
            int size = protobufListF.size();
            Internal.ProtobufList protobufListC = protobufListF.c(size == 0 ? 10 : size * 2);
            UnsafeUtil.Y(obj, j3, protobufListC);
            return protobufListC;
        }
    }

    static {
        f39135a = new ListFieldSchemaFull();
        f39136b = new ListFieldSchemaLite();
    }

    static ListFieldSchema a() {
        return f39135a;
    }

    static ListFieldSchema b() {
        return f39136b;
    }

    abstract void c(Object obj, long j3);

    abstract void d(Object obj, Object obj2, long j3);

    abstract List e(Object obj, long j3);

    private ListFieldSchema() {
    }
}
