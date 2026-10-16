package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f33743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Notification.Builder f33744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NotificationCompat.Builder f33745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f33746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoteViews f33747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f33748f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f33749g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f33750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RemoteViews f33751i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api20Impl {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Builder e(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder f(Notification.Builder builder, boolean z2) {
            return builder.setGroupSummary(z2);
        }

        static Notification.Builder g(Notification.Builder builder, boolean z2) {
            return builder.setLocalOnly(z2);
        }

        static Notification.Builder h(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i3) {
            return builder.setColor(i3);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i3) {
            return builder.setVisibility(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAllowGeneratedReplies(z2);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            return builder.setBadgeIconType(i3);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z2) {
            return builder.setColorized(z2);
        }

        static Notification.Builder d(Notification.Builder builder, int i3) {
            return builder.setGroupAlertBehavior(i3);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j3) {
            return builder.setTimeoutAfter(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static Notification.Builder a(Notification.Builder builder, android.app.Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i3) {
            return builder.setSemanticAction(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static Notification.Builder a(Notification.Builder builder, boolean z2) {
            return builder.setAllowSystemGeneratedContextualActions(z2);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z2) {
            return builder.setContextual(z2);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z2) {
            return builder.setAuthenticationRequired(z2);
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            return builder.setForegroundServiceBehavior(i3);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        int i3;
        this.f33745c = builder;
        Context context = builder.f33677a;
        this.f33743a = context;
        Notification.Builder builderA = Api26Impl.a(context, builder.K);
        this.f33744b = builderA;
        Notification notification = builder.T;
        int i4 = 0;
        builderA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f33685i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f33681e).setContentText(builder.f33682f).setContentInfo(builder.f33687k).setContentIntent(builder.f33683g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f33684h, (notification.flags & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0).setNumber(builder.f33688l).setProgress(builder.f33696t, builder.f33697u, builder.f33698v);
        IconCompat iconCompat = builder.f33686j;
        Api23Impl.b(builderA, iconCompat == null ? null : iconCompat.p(context));
        builderA.setSubText(builder.f33693q).setUsesChronometer(builder.f33691o).setPriority(builder.f33689m);
        NotificationCompat.Style style = builder.f33692p;
        if (style instanceof NotificationCompat.CallStyle) {
            ArrayList arrayListH = ((NotificationCompat.CallStyle) style).h();
            int size = arrayListH.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayListH.get(i5);
                i5++;
                b((NotificationCompat.Action) obj);
            }
        } else {
            ArrayList arrayList = builder.f33678b;
            int size2 = arrayList.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList.get(i6);
                i6++;
                b((NotificationCompat.Action) obj2);
            }
        }
        Bundle bundle = builder.D;
        if (bundle != null) {
            this.f33749g.putAll(bundle);
        }
        this.f33746d = builder.H;
        this.f33747e = builder.I;
        this.f33744b.setShowWhen(builder.f33690n);
        Api20Impl.g(this.f33744b, builder.f33702z);
        Api20Impl.e(this.f33744b, builder.f33699w);
        Api20Impl.h(this.f33744b, builder.f33701y);
        Api20Impl.f(this.f33744b, builder.f33700x);
        this.f33750h = builder.P;
        Api21Impl.b(this.f33744b, builder.C);
        Api21Impl.c(this.f33744b, builder.E);
        Api21Impl.f(this.f33744b, builder.F);
        Api21Impl.d(this.f33744b, builder.G);
        Api21Impl.e(this.f33744b, notification.sound, notification.audioAttributes);
        ArrayList arrayList2 = builder.W;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size3 = arrayList2.size();
            int i7 = 0;
            while (i7 < size3) {
                Object obj3 = arrayList2.get(i7);
                i7++;
                Api21Impl.a(this.f33744b, (String) obj3);
            }
        }
        this.f33751i = builder.J;
        if (builder.f33680d.size() > 0) {
            Bundle bundle2 = builder.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i8 = 0; i8 < builder.f33680d.size(); i8++) {
                bundle4.putBundle(Integer.toString(i8), NotificationCompatJellybean.a((NotificationCompat.Action) builder.f33680d.get(i8)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.f33749g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        Object obj4 = builder.V;
        if (obj4 != null) {
            Api23Impl.c(this.f33744b, obj4);
        }
        this.f33744b.setExtras(builder.D);
        Api24Impl.e(this.f33744b, builder.f33695s);
        RemoteViews remoteViews = builder.H;
        if (remoteViews != null) {
            Api24Impl.c(this.f33744b, remoteViews);
        }
        RemoteViews remoteViews2 = builder.I;
        if (remoteViews2 != null) {
            Api24Impl.b(this.f33744b, remoteViews2);
        }
        RemoteViews remoteViews3 = builder.J;
        if (remoteViews3 != null) {
            Api24Impl.d(this.f33744b, remoteViews3);
        }
        Api26Impl.b(this.f33744b, builder.L);
        Api26Impl.e(this.f33744b, builder.f33694r);
        Api26Impl.f(this.f33744b, builder.M);
        Api26Impl.g(this.f33744b, builder.O);
        Api26Impl.d(this.f33744b, builder.P);
        if (builder.B) {
            Api26Impl.c(this.f33744b, builder.A);
        }
        if (!TextUtils.isEmpty(builder.K)) {
            this.f33744b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        ArrayList arrayList3 = builder.f33679c;
        int size4 = arrayList3.size();
        while (i4 < size4) {
            Object obj5 = arrayList3.get(i4);
            i4++;
            Api28Impl.a(this.f33744b, ((Person) obj5).h());
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            Api29Impl.a(this.f33744b, builder.R);
            Api29Impl.b(this.f33744b, NotificationCompat.BubbleMetadata.j(builder.S));
            LocusIdCompat locusIdCompat = builder.N;
            if (locusIdCompat != null) {
                Api29Impl.d(this.f33744b, locusIdCompat.c());
            }
        }
        if (i9 >= 31 && (i3 = builder.Q) != 0) {
            Api31Impl.b(this.f33744b, i3);
        }
        if (builder.U) {
            if (this.f33745c.f33700x) {
                this.f33750h = 2;
            } else {
                this.f33750h = 1;
            }
            this.f33744b.setVibrate(null);
            this.f33744b.setSound(null);
            int i10 = notification.defaults & (-4);
            notification.defaults = i10;
            this.f33744b.setDefaults(i10);
            if (TextUtils.isEmpty(this.f33745c.f33699w)) {
                Api20Impl.e(this.f33744b, "silent");
            }
            Api26Impl.d(this.f33744b, this.f33750h);
        }
    }

    private void b(NotificationCompat.Action action) {
        IconCompat iconCompatD = action.d();
        Notification.Action.Builder builderA = Api23Impl.a(iconCompatD != null ? iconCompatD.o() : null, action.h(), action.a());
        if (action.e() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.b(action.e())) {
                Api20Impl.c(builderA, remoteInput);
            }
        }
        Bundle bundle = action.c() != null ? new Bundle(action.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        int i3 = Build.VERSION.SDK_INT;
        Api24Impl.a(builderA, action.b());
        bundle.putInt("android.support.action.semanticAction", action.f());
        Api28Impl.b(builderA, action.f());
        if (i3 >= 29) {
            Api29Impl.c(builderA, action.j());
        }
        if (i3 >= 31) {
            Api31Impl.a(builderA, action.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.g());
        Api20Impl.b(builderA, bundle);
        Api20Impl.a(this.f33744b, Api20Impl.d(builderA));
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder a() {
        return this.f33744b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        NotificationCompat.Style style = this.f33745c.f33692p;
        if (style != null) {
            style.b(this);
        }
        RemoteViews remoteViewsE = style != null ? style.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f33745c.H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (style != null && (remoteViewsD = style.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (style != null && (remoteViewsF = this.f33745c.f33692p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (style != null && (bundleA = NotificationCompat.a(notificationD)) != null) {
            style.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        return this.f33744b.build();
    }

    Context e() {
        return this.f33743a;
    }
}
