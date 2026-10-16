package com.evernote.android.job.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Clock f67961a = new Clock() { // from class: com.evernote.android.job.util.Clock.1
        @Override // com.evernote.android.job.util.Clock
        public long a() {
            return SystemClock.elapsedRealtime();
        }

        @Override // com.evernote.android.job.util.Clock
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    };

    long a();

    long currentTimeMillis();
}
