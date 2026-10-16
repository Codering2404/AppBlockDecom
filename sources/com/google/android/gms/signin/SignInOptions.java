package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SignInOptions f74552k = new SignInOptions(false, false, null, false, null, null, false, null, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f74553a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f74554b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f74555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f74556d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f74559h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f74557f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f74558g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Long f74560i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Long f74561j = null;

    /* synthetic */ SignInOptions(boolean z2, boolean z3, String str, boolean z4, String str2, String str3, boolean z5, Long l3, Long l4, zaf zafVar) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SignInOptions) && Objects.b(null, null) && Objects.b(null, null) && Objects.b(null, null) && Objects.b(null, null) && Objects.b(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.c(bool, bool, null, bool, bool, null, null, null, null);
    }
}
