package com.applovin.impl;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f62045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FriendlyObstructionPurpose f62046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f62047c;

    public ng(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f62045a = view;
        this.f62046b = friendlyObstructionPurpose;
        this.f62047c = str;
    }

    public String a() {
        return this.f62047c;
    }

    public FriendlyObstructionPurpose b() {
        return this.f62046b;
    }

    public View c() {
        return this.f62045a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ng ngVar = (ng) obj;
            View view = this.f62045a;
            if (view == null ? ngVar.f62045a != null : !view.equals(ngVar.f62045a)) {
                return false;
            }
            if (this.f62046b != ngVar.f62046b) {
                return false;
            }
            String str = this.f62047c;
            String str2 = ngVar.f62047c;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        View view = this.f62045a;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.f62046b;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.f62047c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
