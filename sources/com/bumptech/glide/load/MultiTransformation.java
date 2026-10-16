package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiTransformation<T> implements Transformation<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection f66254b;

    @Override // com.bumptech.glide.load.Transformation
    public Resource a(Context context, Resource resource, int i3, int i4) {
        Iterator it = this.f66254b.iterator();
        Resource resource2 = resource;
        while (it.hasNext()) {
            Resource resourceA = ((Transformation) it.next()).a(context, resource2, i3, i4);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(resourceA)) {
                resource2.a();
            }
            resource2 = resourceA;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        Iterator it = this.f66254b.iterator();
        while (it.hasNext()) {
            ((Transformation) it.next()).b(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.f66254b.equals(((MultiTransformation) obj).f66254b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f66254b.hashCode();
    }
}
