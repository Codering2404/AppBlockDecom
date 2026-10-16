package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Serialization {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FieldSetter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f84621a;

        void a(Object obj, int i3) {
            try {
                this.f84621a.set(obj, Integer.valueOf(i3));
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        void b(Object obj, Object obj2) {
            try {
                this.f84621a.set(obj, obj2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        private FieldSetter(Field field) {
            this.f84621a = field;
            field.setAccessible(true);
        }
    }

    static FieldSetter a(Class cls, String str) {
        try {
            return new FieldSetter(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e3) {
            throw new AssertionError(e3);
        }
    }

    static void b(Map map, ObjectInputStream objectInputStream) {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    static void c(Map map, ObjectInputStream objectInputStream, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static void d(Multimap multimap, ObjectInputStream objectInputStream) throws IOException {
        e(multimap, objectInputStream, objectInputStream.readInt());
    }

    static void e(Multimap multimap, ObjectInputStream objectInputStream, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            Collection collection = multimap.get(objectInputStream.readObject());
            int i5 = objectInputStream.readInt();
            for (int i6 = 0; i6 < i5; i6++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    static void f(Multiset multiset, ObjectInputStream objectInputStream) {
        g(multiset, objectInputStream, objectInputStream.readInt());
    }

    static void g(Multiset multiset, ObjectInputStream objectInputStream, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            multiset.t1(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static int h(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static void i(Map map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static void j(Multimap multimap, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multimap.a1().size());
        for (Map.Entry entry : multimap.a1().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    static void k(Multiset multiset, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.a());
            objectOutputStream.writeInt(entry.getCount());
        }
    }
}
