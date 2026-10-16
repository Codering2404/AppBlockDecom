package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f89420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f89421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Notification f89422c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Notification {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f89423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f89424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f89425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f89426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f89427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String[] f89428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f89429g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f89430h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f89431i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f89432j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f89433k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f89434l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f89435m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Uri f89436n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final String f89437o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final Integer f89438p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Integer f89439q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final Integer f89440r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int[] f89441s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Long f89442t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f89443u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final boolean f89444v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final boolean f89445w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final boolean f89446x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final boolean f89447y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final long[] f89448z;

        private static String[] b(NotificationParams notificationParams, String str) {
            Object[] objArrG = notificationParams.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i3 = 0; i3 < objArrG.length; i3++) {
                strArr[i3] = String.valueOf(objArrG[i3]);
            }
            return strArr;
        }

        public String a() {
            return this.f89426d;
        }

        public String c() {
            return this.f89423a;
        }

        private Notification(NotificationParams notificationParams) {
            this.f89423a = notificationParams.p("gcm.n.title");
            this.f89424b = notificationParams.h("gcm.n.title");
            this.f89425c = b(notificationParams, "gcm.n.title");
            this.f89426d = notificationParams.p("gcm.n.body");
            this.f89427e = notificationParams.h("gcm.n.body");
            this.f89428f = b(notificationParams, "gcm.n.body");
            this.f89429g = notificationParams.p("gcm.n.icon");
            this.f89431i = notificationParams.o();
            this.f89432j = notificationParams.p("gcm.n.tag");
            this.f89433k = notificationParams.p("gcm.n.color");
            this.f89434l = notificationParams.p("gcm.n.click_action");
            this.f89435m = notificationParams.p("gcm.n.android_channel_id");
            this.f89436n = notificationParams.f();
            this.f89430h = notificationParams.p("gcm.n.image");
            this.f89437o = notificationParams.p("gcm.n.ticker");
            this.f89438p = notificationParams.b("gcm.n.notification_priority");
            this.f89439q = notificationParams.b("gcm.n.visibility");
            this.f89440r = notificationParams.b("gcm.n.notification_count");
            this.f89443u = notificationParams.a("gcm.n.sticky");
            this.f89444v = notificationParams.a("gcm.n.local_only");
            this.f89445w = notificationParams.a("gcm.n.default_sound");
            this.f89446x = notificationParams.a("gcm.n.default_vibrate_timings");
            this.f89447y = notificationParams.a("gcm.n.default_light_settings");
            this.f89442t = notificationParams.j(cJfnYMIyomoWf.uGknqOUKqWPYT);
            this.f89441s = notificationParams.e();
            this.f89448z = notificationParams.q();
        }
    }

    public RemoteMessage(Bundle bundle) {
        this.f89420a = bundle;
    }

    public Map M() {
        if (this.f89421b == null) {
            this.f89421b = Constants.MessagePayloadKeys.a(this.f89420a);
        }
        return this.f89421b;
    }

    public Notification N() {
        if (this.f89422c == null && NotificationParams.t(this.f89420a)) {
            this.f89422c = new Notification(new NotificationParams(this.f89420a));
        }
        return this.f89422c;
    }

    public Intent O() {
        Intent intent = new Intent();
        intent.putExtras(this.f89420a);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        RemoteMessageCreator.c(this, parcel, i3);
    }
}
