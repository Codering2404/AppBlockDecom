package com.applovin.impl;

import com.applovin.impl.fb;
import com.applovin.impl.gb;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class eb extends gb implements ec {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends gb.b {
        @Override // com.applovin.impl.gb.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Object obj, Iterable iterable) {
            super.a(obj, iterable);
            return this;
        }

        public eb c() {
            return (eb) super.a();
        }

        public a b(Object obj, Object... objArr) {
            super.a(obj, objArr);
            return this;
        }
    }

    eb(fb fbVar, int i3) {
        super(fbVar, i3);
    }

    static eb a(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return l();
        }
        fb.a aVar = new fb.a(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            db dbVarA = comparator == null ? db.a(collection2) : db.a(comparator, (Iterable) collection2);
            if (!dbVarA.isEmpty()) {
                aVar.a(key, dbVarA);
                size += dbVarA.size();
            }
        }
        return new eb(aVar.a(), size);
    }

    public static a k() {
        return new a();
    }

    public static eb l() {
        return q7.f62582g;
    }

    public db b(Object obj) {
        db dbVar = (db) this.f59944d.get(obj);
        return dbVar == null ? db.h() : dbVar;
    }
}
