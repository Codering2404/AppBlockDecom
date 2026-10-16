package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class TargetTracker implements LifecycleListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f67073a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f67073a.clear();
    }

    public List d() {
        return Util.k(this.f67073a);
    }

    public void e(Target target) {
        this.f67073a.add(target);
    }

    public void l(Target target) {
        this.f67073a.remove(target);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Iterator it = Util.k(this.f67073a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Iterator it = Util.k(this.f67073a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Iterator it = Util.k(this.f67073a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }
}
