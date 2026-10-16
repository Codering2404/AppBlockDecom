package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class JwtValidator {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Duration f86313j = Duration.ofMinutes(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Optional f86314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f86315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Optional f86316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f86317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Optional f86318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f86319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f86320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f86321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Duration f86322i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f86314a.isPresent()) {
            arrayList.add("expectedTypeHeader=" + ((String) this.f86314a.get()));
        }
        if (this.f86315b) {
            arrayList.add("ignoreTypeHeader");
        }
        if (this.f86316c.isPresent()) {
            arrayList.add("expectedIssuer=" + ((String) this.f86316c.get()));
        }
        if (this.f86317d) {
            arrayList.add("ignoreIssuer");
        }
        if (this.f86318e.isPresent()) {
            arrayList.add("expectedAudience=" + ((String) this.f86318e.get()));
        }
        if (this.f86319f) {
            arrayList.add("ignoreAudiences");
        }
        if (this.f86320g) {
            arrayList.add("allowMissingExpiration");
        }
        if (this.f86321h) {
            arrayList.add("expectIssuedInThePast");
        }
        if (!this.f86322i.isZero()) {
            arrayList.add("clockSkew=" + this.f86322i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JwtValidator{");
        int size = arrayList.size();
        String str = "";
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sb.append(str);
            sb.append((String) obj);
            str = ",";
        }
        sb.append("}");
        return sb.toString();
    }
}
