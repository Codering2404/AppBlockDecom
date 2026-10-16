package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SpreadBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f140149a;

    public SpreadBuilder(int i3) {
        this.f140149a = new ArrayList(i3);
    }

    public void a(Object obj) {
        this.f140149a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList arrayList = this.f140149a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f140149a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f140149a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f140149a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f140149a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f140149a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f140149a.toArray(objArr);
    }
}
