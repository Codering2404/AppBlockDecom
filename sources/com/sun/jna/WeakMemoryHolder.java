package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class WeakMemoryHolder {
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    IdentityHashMap<Reference<Object>, Memory> backingMap = new IdentityHashMap<>();

    public synchronized void clean() {
        while (true) {
            Reference<? extends Object> referencePoll = this.referenceQueue.poll();
            if (referencePoll != null) {
                this.backingMap.remove(referencePoll);
            }
        }
    }

    public synchronized void put(Object obj, Memory memory) {
        clean();
        this.backingMap.put(new WeakReference(obj, this.referenceQueue), memory);
    }
}
