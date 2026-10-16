package com.google.android.datatransport.runtime.scheduling.persistence;

import com.facebook.UserSettingsManager;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class EventStoreConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final EventStoreConfig f69552a = a().f(10485760).d(200).b(ColorExtractionConstants.MAX_PIXEL_SAMPLES).c(UserSettingsManager.TIMEOUT_7D).e(81920).a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class Builder {
        Builder() {
        }

        abstract EventStoreConfig a();

        abstract Builder b(int i3);

        abstract Builder c(long j3);

        abstract Builder d(int i3);

        abstract Builder e(int i3);

        abstract Builder f(long j3);
    }

    EventStoreConfig() {
    }

    static Builder a() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}
