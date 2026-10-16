package com.applovin.impl;

import com.applovin.impl.af;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class y9 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f65173c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65174a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65175b = -1;

    public boolean a() {
        return (this.f65174a == -1 || this.f65175b == -1) ? false : true;
    }

    public boolean a(af afVar) {
        for (int i3 = 0; i3 < afVar.c(); i3++) {
            af.b bVarA = afVar.a(i3);
            if (bVarA instanceof u3) {
                u3 u3Var = (u3) bVarA;
                if ("iTunSMPB".equals(u3Var.f64077c) && a(u3Var.f64078d)) {
                    return true;
                }
            } else if (bVarA instanceof rb) {
                rb rbVar = (rb) bVarA;
                if ("com.apple.iTunes".equals(rbVar.f62812b) && "iTunSMPB".equals(rbVar.f62813c) && a(rbVar.f62814d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean a(int i3) {
        int i4 = i3 >> 12;
        int i5 = i3 & 4095;
        if (i4 <= 0 && i5 <= 0) {
            return false;
        }
        this.f65174a = i4;
        this.f65175b = i5;
        return true;
    }

    private boolean a(String str) {
        Matcher matcher = f65173c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i3 = Integer.parseInt((String) xp.a((Object) matcher.group(1)), 16);
            int i4 = Integer.parseInt((String) xp.a((Object) matcher.group(2)), 16);
            if (i3 <= 0 && i4 <= 0) {
                return false;
            }
            this.f65174a = i3;
            this.f65175b = i4;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
