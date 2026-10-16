package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.LegacyTokenHelper;
import com.google.android.gms.common.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StringResourceValueReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f72022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72023b;

    public StringResourceValueReader(Context context) {
        Preconditions.m(context);
        Resources resources = context.getResources();
        this.f72022a = resources;
        this.f72023b = resources.getResourcePackageName(R.string.f71467a);
    }

    public String a(String str) {
        String str2 = this.f72023b;
        Resources resources = this.f72022a;
        int identifier = resources.getIdentifier(str, LegacyTokenHelper.TYPE_STRING, str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }
}
