package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ObjectIdMapper {
    protected final Object mSync = new Object();
    private int mNextId = 1;
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            onUnmapped(sparseArray.valueAt(i3), sparseArray.keyAt(i3));
        }
    }

    public boolean containsId(int i3) {
        boolean z2;
        synchronized (this.mSync) {
            z2 = this.mIdToObjectMap.get(i3) != null;
        }
        return z2;
    }

    public boolean containsObject(Object obj) {
        boolean zContainsKey;
        synchronized (this.mSync) {
            zContainsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return zContainsKey;
    }

    @Nullable
    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    @Nullable
    public Object getObjectForId(int i3) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i3);
        }
        return obj;
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            try {
                Integer num = this.mObjectToIdMap.get(obj);
                if (num != null) {
                    return num.intValue();
                }
                int i3 = this.mNextId;
                this.mNextId = i3 + 1;
                this.mObjectToIdMap.put(obj, Integer.valueOf(i3));
                this.mIdToObjectMap.put(i3, obj);
                onMapped(obj, i3);
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            try {
                Integer numRemove = this.mObjectToIdMap.remove(obj);
                if (numRemove == null) {
                    return null;
                }
                this.mIdToObjectMap.remove(numRemove.intValue());
                onUnmapped(obj, numRemove.intValue());
                return numRemove;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public Object removeObjectById(int i3) {
        synchronized (this.mSync) {
            try {
                Object obj = this.mIdToObjectMap.get(i3);
                if (obj == null) {
                    return null;
                }
                this.mIdToObjectMap.remove(i3);
                this.mObjectToIdMap.remove(obj);
                onUnmapped(obj, i3);
                return obj;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }

    protected void onMapped(Object obj, int i3) {
    }

    protected void onUnmapped(Object obj, int i3) {
    }
}
