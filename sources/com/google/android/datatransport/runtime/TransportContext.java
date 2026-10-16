package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TransportContext {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract TransportContext a();

        public abstract Builder b(String str);

        public abstract Builder c(byte[] bArr);

        public abstract Builder d(Priority priority);
    }

    public static Builder a() {
        return new AutoValue_TransportContext.Builder().d(Priority.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Priority d();

    public boolean e() {
        return c() != null;
    }

    public TransportContext f(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
