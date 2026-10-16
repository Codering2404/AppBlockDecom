package com.applovin.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class t0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static t0 f63842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f63843f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f63844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f63845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f63846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f63847d;

    private t0(Context context) throws Throwable {
        Bundle bundle;
        int iIntValue;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            bundle = applicationInfo.metaData;
            try {
                try {
                    String str = applicationInfo.processName;
                    this.f63844a = bundle;
                    this.f63847d = str;
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    com.applovin.impl.sdk.n.c("AndroidManifest", "Failed to get meta data.", e);
                    this.f63844a = bundle;
                    this.f63847d = null;
                }
            } catch (Throwable th) {
                th = th;
                this.f63844a = bundle;
                this.f63847d = null;
                throw th;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e = e4;
            bundle = null;
        } catch (Throwable th2) {
            th = th2;
            bundle = null;
            this.f63844a = bundle;
            this.f63847d = null;
            throw th;
        }
        boolean z2 = false;
        try {
            XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = xmlResourceParserOpenXmlResourceParser.getEventType();
            iIntValue = 0;
            boolean zBooleanValue = false;
            do {
                if (2 == eventType) {
                    try {
                        if (xmlResourceParserOpenXmlResourceParser.getName().equals("application")) {
                            for (int i3 = 0; i3 < xmlResourceParserOpenXmlResourceParser.getAttributeCount(); i3++) {
                                String attributeName = xmlResourceParserOpenXmlResourceParser.getAttributeName(i3);
                                String attributeValue = xmlResourceParserOpenXmlResourceParser.getAttributeValue(i3);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    iIntValue = Integer.valueOf(attributeValue.substring(1)).intValue();
                                } else if (attributeName.equals("usesCleartextTraffic")) {
                                    zBooleanValue = Boolean.valueOf(attributeValue).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = zBooleanValue;
                        try {
                            com.applovin.impl.sdk.n.c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                            return;
                        } finally {
                            this.f63845b = iIntValue;
                            this.f63846c = z2;
                        }
                    }
                }
                eventType = xmlResourceParserOpenXmlResourceParser.next();
            } while (eventType != 1);
            this.f63845b = iIntValue;
            this.f63846c = zBooleanValue;
        } catch (Throwable th4) {
            th = th4;
            iIntValue = 0;
        }
    }

    public boolean a(String str, boolean z2) {
        Bundle bundle = this.f63844a;
        return bundle != null ? bundle.getBoolean(str, z2) : z2;
    }

    public String a(String str, String str2) {
        Bundle bundle = this.f63844a;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public String a() {
        return this.f63847d;
    }

    public boolean a(String str) {
        Bundle bundle = this.f63844a;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public static t0 a(Context context) {
        t0 t0Var;
        synchronized (f63843f) {
            try {
                if (f63842e == null) {
                    f63842e = new t0(context);
                }
                t0Var = f63842e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t0Var;
    }
}
