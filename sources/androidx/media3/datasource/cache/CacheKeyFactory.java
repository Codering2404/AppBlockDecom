package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface CacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheKeyFactory f42053a = new CacheKeyFactory() { // from class: androidx.media3.datasource.cache.a
        @Override // androidx.media3.datasource.cache.CacheKeyFactory
        public final String b(DataSpec dataSpec) {
            return CacheKeyFactory.a(dataSpec);
        }
    };

    static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.f41837i;
        return str != null ? str : dataSpec.f41829a.toString();
    }

    String b(DataSpec dataSpec);
}
