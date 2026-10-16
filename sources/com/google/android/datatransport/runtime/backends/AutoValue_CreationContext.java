package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_CreationContext extends CreationContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f69378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f69379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f69380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f69381d;

    AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f69378a = context;
        if (clock == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f69379b = clock;
        if (clock2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f69380c = clock2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f69381d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context b() {
        return this.f69378a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public String c() {
        return this.f69381d;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock d() {
        return this.f69380c;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock e() {
        return this.f69379b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreationContext) {
            CreationContext creationContext = (CreationContext) obj;
            if (this.f69378a.equals(creationContext.b()) && this.f69379b.equals(creationContext.e()) && this.f69380c.equals(creationContext.d()) && this.f69381d.equals(creationContext.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f69378a.hashCode() ^ 1000003) * 1000003) ^ this.f69379b.hashCode()) * 1000003) ^ this.f69380c.hashCode()) * 1000003) ^ this.f69381d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f69378a + ", wallClock=" + this.f69379b + ", monotonicClock=" + this.f69380c + ", backendName=" + this.f69381d + "}";
    }
}
