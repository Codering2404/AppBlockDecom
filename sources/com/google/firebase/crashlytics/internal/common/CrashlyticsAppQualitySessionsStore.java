package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CrashlyticsAppQualitySessionsStore {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FilenameFilter f88336d = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.a
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith("aqs.");
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Comparator f88337e = new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileStore f88338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f88339b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f88340c = null;

    CrashlyticsAppQualitySessionsStore(FileStore fileStore) {
        this.f88338a = fileStore;
    }

    private static void d(FileStore fileStore, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            fileStore.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e3) {
            Logger.f().l("Failed to persist App Quality Sessions session id.", e3);
        }
    }

    static String e(FileStore fileStore, String str) {
        List listR = fileStore.r(str, f88336d);
        if (!listR.isEmpty()) {
            return ((File) Collections.min(listR, f88337e)).getName().substring(4);
        }
        Logger.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f88339b, str)) {
            return this.f88340c;
        }
        return e(this.f88338a, str);
    }

    public synchronized void f(String str) {
        if (!Objects.equals(this.f88340c, str)) {
            d(this.f88338a, this.f88339b, str);
            this.f88340c = str;
        }
    }

    public synchronized void g(String str) {
        if (!Objects.equals(this.f88339b, str)) {
            d(this.f88338a, str, this.f88340c);
            this.f88339b = str;
        }
    }
}
