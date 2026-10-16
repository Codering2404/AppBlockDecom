package com.google.android.gms.ads.nonagon.devicetier;

import android.content.Context;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DeviceTierManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f70568b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f70569c = new AtomicReference(AdvertisedMemoryTier.UNKNOWN);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f70570d = new AtomicReference(AvailableMemoryTier.UNKNOWN);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference f70571e = new AtomicReference(AvailableProcessorTier.UNKNOWN);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AdvertisedMemoryTier {
        UNKNOWN(0),
        INVALID_DATA_SOURCE(1),
        EXTREME_LOW(2),
        VERY_LOW(3),
        LOW(4),
        MID(5),
        MID_PLUS(6),
        HIGH(7),
        VERY_HIGH(8),
        EXTREME_HIGH(9);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f70583a;

        AdvertisedMemoryTier(int i3) {
            this.f70583a = i3;
        }

        public static AdvertisedMemoryTier a(int i3) {
            for (AdvertisedMemoryTier advertisedMemoryTier : values()) {
                if (advertisedMemoryTier.f70583a == i3) {
                    return advertisedMemoryTier;
                }
            }
            return null;
        }

        public int b() {
            return this.f70583a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AvailableMemoryTier {
        UNKNOWN(0),
        INVALID_DATA_SOURCE(1),
        EXTREME_LOW(2),
        VERY_LOW(3),
        LOW(4),
        MID(5),
        MID_PLUS(6),
        HIGH(7),
        VERY_HIGH(8),
        EXTREME_HIGH(9);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f70595a;

        AvailableMemoryTier(int i3) {
            this.f70595a = i3;
        }

        public static AvailableMemoryTier a(int i3) {
            for (AvailableMemoryTier availableMemoryTier : values()) {
                if (availableMemoryTier.f70595a == i3) {
                    return availableMemoryTier;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AvailableProcessorTier {
        UNKNOWN(0),
        INVALID_DATA_SOURCE(1),
        EXTREME_LOW(2),
        LOW(3),
        MID(4),
        MID_PLUS(5),
        HIGH(6),
        EXTREME_HIGH(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f70605a;

        AvailableProcessorTier(int i3) {
            this.f70605a = i3;
        }

        public static AvailableProcessorTier a(int i3) {
            for (AvailableProcessorTier availableProcessorTier : values()) {
                if (availableProcessorTier.f70605a == i3) {
                    return availableProcessorTier;
                }
            }
            return null;
        }
    }

    DeviceTierManager(Context context) {
        this.f70567a = context;
    }

    public AdvertisedMemoryTier a() {
        return (AdvertisedMemoryTier) this.f70569c.get();
    }

    public AvailableProcessorTier b() {
        return (AvailableProcessorTier) this.f70571e.get();
    }

    public void c() {
        AtomicBoolean atomicBoolean = this.f70568b;
        if (atomicBoolean.get()) {
            return;
        }
        AdvertisedMemoryTier advertisedMemoryTierA = AdvertisedMemoryTier.a(this.f70567a.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0).getInt("advertised_memory_tier", AdvertisedMemoryTier.UNKNOWN.b()));
        if (advertisedMemoryTierA != null) {
            this.f70569c.set(advertisedMemoryTierA);
        }
        atomicBoolean.set(true);
    }

    public synchronized void d(AdvertisedMemoryTier advertisedMemoryTier) {
        if (advertisedMemoryTier == null) {
            return;
        }
        this.f70569c.set(advertisedMemoryTier);
        this.f70567a.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0).edit().putInt("advertised_memory_tier", advertisedMemoryTier.b()).apply();
    }

    public void e(AvailableMemoryTier availableMemoryTier) {
        if (availableMemoryTier != null) {
            this.f70570d.set(availableMemoryTier);
        }
    }

    public void f(AvailableProcessorTier availableProcessorTier) {
        if (availableProcessorTier != null) {
            this.f70571e.set(availableProcessorTier);
        }
    }
}
