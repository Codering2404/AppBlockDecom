package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzdb;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConsentDebugSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f83196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f83197b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f83199b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f83201d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f83198a = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f83200c = 0;

        public Builder(Context context) {
            this.f83199b = context.getApplicationContext();
        }

        public Builder addTestDeviceHashedId(String str) {
            this.f83198a.add(str);
            return this;
        }

        public ConsentDebugSettings build() {
            boolean z2 = true;
            if (!zzdb.zza(true) && !this.f83198a.contains(zzct.zza(this.f83199b)) && !this.f83201d) {
                z2 = false;
            }
            return new ConsentDebugSettings(z2, this, null);
        }

        public Builder setDebugGeography(int i3) {
            this.f83200c = i3;
            return this;
        }

        public Builder setForceTesting(boolean z2) {
            this.f83201d = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;

        @Deprecated
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
        public static final int DEBUG_GEOGRAPHY_OTHER = 4;
        public static final int DEBUG_GEOGRAPHY_REGULATED_US_STATE = 3;
    }

    /* synthetic */ ConsentDebugSettings(boolean z2, Builder builder, zza zzaVar) {
        this.f83196a = z2;
        this.f83197b = builder.f83200c;
    }

    public int getDebugGeography() {
        return this.f83197b;
    }

    public boolean isTestDevice() {
        return this.f83196a;
    }
}
