package com.google.android.ump;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConsentRequestParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f83203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConsentDebugSettings f83205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f83206d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f83207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f83208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConsentDebugSettings f83209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f83210d;

        public ConsentRequestParameters build() {
            return new ConsentRequestParameters(this, null);
        }

        public Builder setAdMobAppId(String str) {
            this.f83208b = str;
            return this;
        }

        public Builder setConsentDebugSettings(ConsentDebugSettings consentDebugSettings) {
            this.f83209c = consentDebugSettings;
            return this;
        }

        public Builder setConsentSyncId(String str) {
            if (str == null) {
                str = null;
            } else if (!str.matches("^[0-9a-zA-Z+.=\\/_,$\\-{}]{22,150}$")) {
                Log.e("UserMessagingPlatform", "The UMP SDK requires a valid consent sync ID matching the following regex: ^[0-9a-zA-Z+.=\\/_,$\\-{}]{22,150}$. See the setConsentSyncId() API documentation for more details.");
                return this;
            }
            this.f83210d = str;
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(boolean z2) {
            this.f83207a = z2;
            return this;
        }
    }

    /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzbVar) {
        this.f83203a = builder.f83207a;
        this.f83204b = builder.f83208b;
        this.f83205c = builder.f83209c;
        this.f83206d = builder.f83210d;
    }

    public ConsentDebugSettings getConsentDebugSettings() {
        return this.f83205c;
    }

    public String getConsentSyncId() {
        return this.f83206d;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.f83203a;
    }

    public final String zza() {
        return this.f83204b;
    }
}
