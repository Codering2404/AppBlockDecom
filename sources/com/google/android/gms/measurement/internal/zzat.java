package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f73431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzav f73432c;

    public zzat(zzav zzavVar, String str) {
        Objects.requireNonNull(zzavVar);
        this.f73432c = zzavVar;
        Preconditions.g(str);
        this.f73430a = str;
        this.f73431b = -1L;
    }

    public final List a() {
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f73432c.u0().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f73430a, String.valueOf(this.f73431b)}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j3 = cursorQuery.getLong(0);
                        long j4 = cursorQuery.getLong(3);
                        boolean z2 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j3 > this.f73431b) {
                            this.f73431b = j3;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.W(com.google.android.gms.internal.measurement.zzhs.zzk(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhrVar.zzl(string);
                            zzhrVar.zzo(cursorQuery.getLong(2));
                            arrayList.add(new zzas(j3, j4, z2, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc()));
                        } catch (IOException e3) {
                            this.f73432c.f73997a.a().o().c("Data loss. Failed to merge raw event. appId", zzgu.x(this.f73430a), e3);
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    arrayList = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e4) {
                this.f73432c.f73997a.a().o().c("Data loss. Error querying raw events batch. appId", zzgu.x(this.f73430a), e4);
            }
            return arrayList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public zzat(zzav zzavVar, String str, long j3) {
        Objects.requireNonNull(zzavVar);
        this.f73432c = zzavVar;
        Preconditions.g(str);
        this.f73430a = str;
        this.f73431b = zzavVar.b0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j3)}, -1L);
    }
}
