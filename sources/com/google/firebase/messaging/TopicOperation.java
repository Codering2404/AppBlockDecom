package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TopicOperation {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f89474d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89477c;

    private TopicOperation(String str, String str2) {
        this.f89475a = d(str2, str);
        this.f89476b = str;
        this.f89477c = str + "!" + str2;
    }

    static TopicOperation a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new TopicOperation(strArrSplit[0], strArrSplit[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f89474d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public String b() {
        return this.f89476b;
    }

    public String c() {
        return this.f89475a;
    }

    public String e() {
        return this.f89477c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        return this.f89475a.equals(topicOperation.f89475a) && this.f89476b.equals(topicOperation.f89476b);
    }

    public int hashCode() {
        return Objects.c(this.f89476b, this.f89475a);
    }
}
