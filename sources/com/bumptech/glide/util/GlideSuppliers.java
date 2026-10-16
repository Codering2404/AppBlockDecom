package com.bumptech.glide.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GlideSuppliers {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface GlideSupplier<T> {
        Object get();
    }

    public static GlideSupplier a(final GlideSupplier glideSupplier) {
        return new GlideSupplier<Object>() { // from class: com.bumptech.glide.util.GlideSuppliers.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private volatile Object f67282a;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public Object get() {
                if (this.f67282a == null) {
                    synchronized (this) {
                        try {
                            if (this.f67282a == null) {
                                this.f67282a = Preconditions.e(glideSupplier.get());
                            }
                        } finally {
                        }
                    }
                }
                return this.f67282a;
            }
        };
    }
}
