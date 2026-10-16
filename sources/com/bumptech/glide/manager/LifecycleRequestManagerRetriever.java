package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class LifecycleRequestManagerRetriever {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f67031a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestManagerRetriever.RequestManagerFactory f67032b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FragmentManager f67035a;

        SupportRequestManagerTreeNode(FragmentManager fragmentManager) {
            this.f67035a = fragmentManager;
        }

        private void b(FragmentManager fragmentManager, Set set) {
            List listD0 = fragmentManager.D0();
            int size = listD0.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = (Fragment) listD0.get(i3);
                b(fragment.getChildFragmentManager(), set);
                RequestManager requestManagerA = LifecycleRequestManagerRetriever.this.a(fragment.getLifecycle());
                if (requestManagerA != null) {
                    set.add(requestManagerA);
                }
            }
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.f67035a, hashSet);
            return hashSet;
        }
    }

    LifecycleRequestManagerRetriever(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f67032b = requestManagerFactory;
    }

    RequestManager a(androidx.lifecycle.Lifecycle lifecycle) {
        Util.b();
        return (RequestManager) this.f67031a.get(lifecycle);
    }

    RequestManager b(Context context, Glide glide, final androidx.lifecycle.Lifecycle lifecycle, FragmentManager fragmentManager, boolean z2) {
        Util.b();
        RequestManager requestManagerA = a(lifecycle);
        if (requestManagerA != null) {
            return requestManagerA;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
        RequestManager requestManagerA2 = this.f67032b.a(glide, lifecycleLifecycle, new SupportRequestManagerTreeNode(fragmentManager), context);
        this.f67031a.put(lifecycle, requestManagerA2);
        lifecycleLifecycle.c(new LifecycleListener() { // from class: com.bumptech.glide.manager.LifecycleRequestManagerRetriever.1
            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onDestroy() {
                LifecycleRequestManagerRetriever.this.f67031a.remove(lifecycle);
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStart() {
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStop() {
            }
        });
        if (z2) {
            requestManagerA2.onStart();
        }
        return requestManagerA2;
    }
}
