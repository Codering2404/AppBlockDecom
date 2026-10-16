package com.google.crypto.tink.shaded.protobuf;

import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class NewInstanceSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final NewInstanceSchema f87045a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NewInstanceSchema f87046b = new NewInstanceSchemaLite();

    static NewInstanceSchema a() {
        return f87045a;
    }

    static NewInstanceSchema b() {
        return f87046b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName(MHoiDDglUlPJC.gEHHUWIshMcxq).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
