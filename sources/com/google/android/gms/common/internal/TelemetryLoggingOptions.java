package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TelemetryLoggingOptions f72026b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72027a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f72028a;

        /* synthetic */ Builder(zaac zaacVar) {
        }

        public TelemetryLoggingOptions a() {
            return new TelemetryLoggingOptions(this.f72028a, null);
        }

        public Builder b(String str) {
            this.f72028a = str;
            return this;
        }
    }

    /* synthetic */ TelemetryLoggingOptions(String str, zaad zaadVar) {
        this.f72027a = str;
    }

    public static Builder a() {
        return new Builder(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f72027a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return Objects.b(this.f72027a, ((TelemetryLoggingOptions) obj).f72027a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(this.f72027a);
    }
}
