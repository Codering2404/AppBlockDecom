package com.airbnb.lottie;

import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieConfig {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: com.airbnb.lottie.LottieConfig$Builder$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements LottieNetworkCacheProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f56318a;

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            public File a() {
                if (this.f56318a.isDirectory()) {
                    return this.f56318a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* JADX INFO: renamed from: com.airbnb.lottie.LottieConfig$Builder$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements LottieNetworkCacheProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LottieNetworkCacheProvider f56319a;

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            public File a() {
                File fileA = this.f56319a.a();
                if (fileA.isDirectory()) {
                    return fileA;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }
    }
}
