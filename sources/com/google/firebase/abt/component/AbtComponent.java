package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AbtComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f87643a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f87644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f87645c;

    protected AbtComponent(Context context, Provider provider) {
        this.f87644b = context;
        this.f87645c = provider;
    }

    protected FirebaseABTesting a(String str) {
        return new FirebaseABTesting(this.f87644b, this.f87645c, str);
    }

    public synchronized FirebaseABTesting b(String str) {
        try {
            if (!this.f87643a.containsKey(str)) {
                this.f87643a.put(str, a(str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (FirebaseABTesting) this.f87643a.get(str);
    }
}
