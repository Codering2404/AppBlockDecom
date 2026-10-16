package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CrashlyticsFileMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileStore f88397b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f88396a = str;
        this.f88397b = fileStore;
    }

    private File b() {
        return this.f88397b.g(this.f88396a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e3) {
            Logger.f().e("Error creating marker: " + this.f88396a, e3);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
