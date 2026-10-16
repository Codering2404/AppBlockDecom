package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class StatusLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Protocol f93418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f93419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f93420c;

    public StatusLine(Protocol protocol, int i3, String str) {
        this.f93418a = protocol;
        this.f93419b = i3;
        this.f93420c = str;
    }

    public static StatusLine a(String str) throws ProtocolException {
        Protocol protocol;
        int i3;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i3 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            protocol = Protocol.HTTP_1_0;
            i3 = 4;
        }
        int i4 = i3 + 3;
        if (str.length() < i4) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i5 = Integer.parseInt(str.substring(i3, i4));
            if (str.length() <= i4) {
                strSubstring = "";
            } else {
                if (str.charAt(i4) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i3 + 4);
            }
            return new StatusLine(protocol, i5, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f93418a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f93419b);
        if (this.f93420c != null) {
            sb.append(' ');
            sb.append(this.f93420c);
        }
        return sb.toString();
    }
}
