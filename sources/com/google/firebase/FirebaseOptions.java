package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f87613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f87614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f87615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f87616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f87617g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.r(!Strings.b(str), "ApplicationId must be set.");
        this.f87612b = str;
        this.f87611a = str2;
        this.f87613c = str3;
        this.f87614d = str4;
        this.f87615e = str5;
        this.f87616f = str6;
        this.f87617g = str7;
    }

    public static FirebaseOptions a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String strA = stringResourceValueReader.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new FirebaseOptions(strA, stringResourceValueReader.a("google_api_key"), stringResourceValueReader.a("firebase_database_url"), stringResourceValueReader.a("ga_trackingId"), stringResourceValueReader.a("gcm_defaultSenderId"), stringResourceValueReader.a("google_storage_bucket"), stringResourceValueReader.a("project_id"));
    }

    public String b() {
        return this.f87611a;
    }

    public String c() {
        return this.f87612b;
    }

    public String d() {
        return this.f87615e;
    }

    public String e() {
        return this.f87617g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return Objects.b(this.f87612b, firebaseOptions.f87612b) && Objects.b(this.f87611a, firebaseOptions.f87611a) && Objects.b(this.f87613c, firebaseOptions.f87613c) && Objects.b(this.f87614d, firebaseOptions.f87614d) && Objects.b(this.f87615e, firebaseOptions.f87615e) && Objects.b(this.f87616f, firebaseOptions.f87616f) && Objects.b(this.f87617g, firebaseOptions.f87617g);
    }

    public int hashCode() {
        return Objects.c(this.f87612b, this.f87611a, this.f87613c, this.f87614d, this.f87615e, this.f87616f, this.f87617g);
    }

    public String toString() {
        return Objects.d(this).a("applicationId", this.f87612b).a("apiKey", this.f87611a).a("databaseUrl", this.f87613c).a("gcmSenderId", this.f87615e).a("storageBucket", this.f87616f).a("projectId", this.f87617g).toString();
    }
}
