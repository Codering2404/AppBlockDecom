package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Descriptor<E> implements NodeDescriptor<E> {
    private Host mHost;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Host extends ThreadBound {
        @Nullable
        Descriptor<?> getDescriptor(@Nullable Object obj);

        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);
    }

    protected Descriptor() {
    }

    protected static Map<String, String> parseSetAttributesAsTextArg(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        int length = str.length();
        String string = "";
        String string2 = "";
        boolean z2 = false;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '=') {
                string = sb.toString();
                sb.setLength(0);
            } else if (cCharAt == '\"') {
                if (z2) {
                    string2 = sb.toString();
                    sb.setLength(0);
                }
                z2 = !z2;
            } else if (cCharAt != ' ' || z2) {
                sb.append(cCharAt);
            } else {
                map.put(string, string2);
            }
        }
        if (!string.isEmpty() && !string2.isEmpty()) {
            map.put(string, string2);
        }
        return map;
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final boolean checkThreadAccess() {
        return getHost().checkThreadAccess();
    }

    protected final Host getHost() {
        return this.mHost;
    }

    final void initialize(Host host) {
        Util.throwIfNull(host);
        Util.throwIfNotNull(this.mHost);
        this.mHost = host;
    }

    final boolean isInitialized() {
        return this.mHost != null;
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) getHost().postAndWait(uncheckedCallable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void postDelayed(Runnable runnable, long j3) {
        getHost().postDelayed(runnable, j3);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void removeCallbacks(Runnable runnable) {
        getHost().removeCallbacks(runnable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void verifyThreadAccess() {
        getHost().verifyThreadAccess();
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void postAndWait(Runnable runnable) {
        getHost().postAndWait(runnable);
    }
}
