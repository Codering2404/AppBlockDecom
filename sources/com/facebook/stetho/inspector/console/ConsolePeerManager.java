package com.facebook.stetho.inspector.console;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ConsolePeerManager extends ChromePeerManager {
    private static ConsolePeerManager sInstance;

    private ConsolePeerManager() {
    }

    @Nullable
    public static synchronized ConsolePeerManager getInstanceOrNull() {
        return sInstance;
    }

    public static synchronized ConsolePeerManager getOrCreateInstance() {
        try {
            if (sInstance == null) {
                sInstance = new ConsolePeerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }
}
