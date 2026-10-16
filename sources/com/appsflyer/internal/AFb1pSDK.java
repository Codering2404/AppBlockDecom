package com.appsflyer.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.appsflyer.internal.AFf1eSDK;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1pSDK {
    public final String AFInAppEventType;
    private final boolean AFKeystoreWrapper;
    public final long values;

    public AFb1pSDK() {
    }

    public static Uri AFInAppEventType(Intent intent) {
        if (intent == null) {
            return null;
        }
        AFf1eSDK aFf1eSDK = new AFf1eSDK(intent);
        Intrinsics.checkNotNullParameter("android.intent.extra.REFERRER", "");
        AFf1eSDK.AnonymousClass1 anonymousClass1 = new Function0() { // from class: com.appsflyer.internal.AFf1eSDK.1
            private /* synthetic */ String $valueOf;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str) {
                super(0);
                str = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: valueOf */
            public final Parcelable invoke() {
                return AFf1eSDK.this.AFInAppEventType.getParcelableExtra(str);
            }
        };
        StringBuilder sb = new StringBuilder("Error while trying to read ");
        sb.append("android.intent.extra.REFERRER");
        sb.append(" extra from intent");
        Uri uri = (Uri) ((Parcelable) aFf1eSDK.AFInAppEventType(anonymousClass1, sb.toString(), null, true));
        if (uri != null) {
            return uri;
        }
        String strAFInAppEventParameterName = aFf1eSDK.AFInAppEventParameterName("android.intent.extra.REFERRER_NAME");
        if (strAFInAppEventParameterName != null) {
            return Uri.parse(strAFInAppEventParameterName);
        }
        return null;
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFKeystoreWrapper;
    }

    public AFb1pSDK(String str, long j3, boolean z2) {
        this.AFInAppEventType = str;
        this.values = j3;
        this.AFKeystoreWrapper = z2;
    }
}
