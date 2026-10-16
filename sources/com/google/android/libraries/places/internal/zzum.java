package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzum implements zztu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f78658e = new HashSet(Arrays.asList(Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f78661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f78662d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78659a = "[CONTEXT ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78660b = " ]";

    public zzum(String str, String str2, StringBuilder sb) {
        this.f78661c = sb;
    }

    private static int c(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < ' ' || cCharAt == '\"' || cCharAt == '\\') {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zztu
    public final void a(String str, Object obj) {
        if (this.f78662d) {
            this.f78661c.append(' ');
        } else {
            StringBuilder sb = this.f78661c;
            if (sb.length() > 0) {
                sb.append((sb.length() > 1000 || sb.indexOf("\n") != -1) ? '\n' : ' ');
            }
            sb.append(this.f78659a);
            this.f78662d = true;
        }
        StringBuilder sb2 = this.f78661c;
        sb2.append(str);
        sb2.append('=');
        if (obj == null) {
            sb2.append(true);
            return;
        }
        if (f78658e.contains(obj.getClass())) {
            sb2.append(obj);
            return;
        }
        sb2.append('\"');
        String string = obj.toString();
        int i3 = 0;
        while (true) {
            int iC = c(string, i3);
            if (iC == -1) {
                sb2.append((CharSequence) string, i3, string.length());
                sb2.append('\"');
                return;
            }
            sb2.append((CharSequence) string, i3, iC);
            i3 = iC + 1;
            char cCharAt = string.charAt(iC);
            if (cCharAt == '\t') {
                cCharAt = 't';
            } else if (cCharAt == '\n') {
                cCharAt = 'n';
            } else if (cCharAt == '\r') {
                cCharAt = 'r';
            } else if (cCharAt != '\"' && cCharAt != '\\') {
                sb2.append((char) 65533);
            }
            sb2.append("\\");
            sb2.append(cCharAt);
        }
    }

    public final void b() {
        if (this.f78662d) {
            this.f78661c.append(this.f78660b);
        }
    }
}
