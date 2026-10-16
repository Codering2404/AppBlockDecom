package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class we {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f64656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f64657b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        AD_UNIT_ID,
        AD_FORMAT,
        AD
    }

    private we(a aVar, String str) {
        this.f64656a = aVar;
        this.f64657b = str;
    }

    public a a() {
        return this.f64656a;
    }

    public String b() {
        return this.f64657b;
    }

    public static we a(fe feVar) {
        String strR = feVar.R();
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        return new we(a.AD, strR);
    }

    public static we a(MaxAdFormat maxAdFormat) {
        String label = maxAdFormat.getLabel();
        if (TextUtils.isEmpty(label)) {
            return null;
        }
        return new we(a.AD_FORMAT, label);
    }

    public static we a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new we(a.AD_UNIT_ID, str);
    }
}
