package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.superwall.sdk.billing.GoogleBillingWrapperKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ql {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ql f62647a = new a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ql {
        a() {
        }

        @Override // com.applovin.impl.ql
        public boolean a(e9 e9Var) {
            String str = e9Var.f59394m;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.applovin.impl.ql
        public ol b(e9 e9Var) {
            String str = e9Var.f59394m;
            if (str != null) {
                byte b3 = -1;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            b3 = 0;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            b3 = 1;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            b3 = 2;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            b3 = 3;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            b3 = 4;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            b3 = 5;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            b3 = 6;
                        }
                        break;
                    case 1201784583:
                        if (str.equals("text/x-exoplayer-cues")) {
                            b3 = 7;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            b3 = 8;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            b3 = 9;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            b3 = 10;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            b3 = Ascii.VT;
                        }
                        break;
                }
                switch (b3) {
                    case 0:
                        return new i7(e9Var.f59396o);
                    case 1:
                        return new jh();
                    case 2:
                        return new pf();
                    case 3:
                        return new yr();
                    case 4:
                        return new lp(e9Var.f59396o);
                    case 5:
                        return new xk(e9Var.f59396o);
                    case 6:
                    case 8:
                        return new y2(str, e9Var.E, GoogleBillingWrapperKt.RECONNECT_TIMER_MAX_TIME_MILLISECONDS);
                    case 7:
                        return new h8();
                    case 9:
                        return new z2(e9Var.E, e9Var.f59396o);
                    case 10:
                        return new jl();
                    case 11:
                        return new fp();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(e9 e9Var);

    ol b(e9 e9Var);
}
