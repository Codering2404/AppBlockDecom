package com.google.android.datatransport;

import com.google.android.datatransport.EventContext;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_EventContext extends EventContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f69053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f69054c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends EventContext.Builder {
    }

    @Override // com.google.android.datatransport.EventContext
    public byte[] a() {
        return this.f69053b;
    }

    @Override // com.google.android.datatransport.EventContext
    public byte[] b() {
        return this.f69054c;
    }

    @Override // com.google.android.datatransport.EventContext
    public String c() {
        return this.f69052a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EventContext) {
            EventContext eventContext = (EventContext) obj;
            String str = this.f69052a;
            if (str != null ? str.equals(eventContext.c()) : eventContext.c() == null) {
                boolean z2 = eventContext instanceof AutoValue_EventContext;
                if (Arrays.equals(this.f69053b, z2 ? ((AutoValue_EventContext) eventContext).f69053b : eventContext.a())) {
                    if (Arrays.equals(this.f69054c, z2 ? ((AutoValue_EventContext) eventContext).f69054c : eventContext.b())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f69052a;
        return (((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f69053b)) * 1000003) ^ Arrays.hashCode(this.f69054c);
    }

    public String toString() {
        return "EventContext{pseudonymousId=" + this.f69052a + ", experimentIdsClear=" + Arrays.toString(this.f69053b) + ", experimentIdsEncrypted=" + Arrays.toString(this.f69054c) + "}";
    }
}
