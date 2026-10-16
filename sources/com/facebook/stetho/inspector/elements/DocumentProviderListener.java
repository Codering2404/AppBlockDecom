package com.facebook.stetho.inspector.elements;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface DocumentProviderListener {
    void onAttributeModified(Object obj, String str, String str2);

    void onAttributeRemoved(Object obj, String str);

    void onInspectRequested(Object obj);

    void onPossiblyChanged();
}
