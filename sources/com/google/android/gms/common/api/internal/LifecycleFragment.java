package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface LifecycleFragment {
    void a(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback c(String str, Class cls);

    Activity i();

    void startActivityForResult(Intent intent, int i3);
}
