package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.share.internal.ShareConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class NotificationCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f33631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IconCompat f33632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final RemoteInput[] f33633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final RemoteInput[] f33634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f33635e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f33636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f33637g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f33638h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f33639i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f33640j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f33641k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f33642l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IconCompat f33643a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CharSequence f33644b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f33645c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f33646d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Bundle f33647e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private ArrayList f33648f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f33649g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f33650h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f33651i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f33652j;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api20Impl {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api23Impl {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api24Impl {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api28Impl {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api29Impl {
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api31Impl {
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private void b() {
                if (this.f33651i && this.f33645c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public Action a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f33648f;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList3.get(i3);
                        i3++;
                        RemoteInput remoteInput = (RemoteInput) obj;
                        if (remoteInput.j()) {
                            arrayList.add(remoteInput);
                        } else {
                            arrayList2.add(remoteInput);
                        }
                    }
                }
                return new Action(this.f33643a, this.f33644b, this.f33645c, this.f33647e, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]), this.f33646d, this.f33649g, this.f33650h, this.f33651i, this.f33652j);
            }

            private Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z2, int i3, boolean z3, boolean z4, boolean z5) {
                this.f33646d = true;
                this.f33650h = true;
                this.f33643a = iconCompat;
                this.f33644b = Builder.e(charSequence);
                this.f33645c = pendingIntent;
                this.f33647e = bundle;
                this.f33648f = remoteInputArr == null ? null : new ArrayList(Arrays.asList(remoteInputArr));
                this.f33646d = z2;
                this.f33649g = i3;
                this.f33650h = z3;
                this.f33651i = z4;
                this.f33652j = z5;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Extender {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class WearableExtender implements Extender {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f33653a = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private CharSequence f33654b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private CharSequence f33655c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private CharSequence f33656d;

            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f33653a = this.f33653a;
                wearableExtender.f33654b = this.f33654b;
                wearableExtender.f33655c = this.f33655c;
                wearableExtender.f33656d = this.f33656d;
                return wearableExtender;
            }
        }

        public Action(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i3 != 0 ? IconCompat.e(null, "", i3) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f33641k;
        }

        public boolean b() {
            return this.f33635e;
        }

        public Bundle c() {
            return this.f33631a;
        }

        public IconCompat d() {
            int i3;
            if (this.f33632b == null && (i3 = this.f33639i) != 0) {
                this.f33632b = IconCompat.e(null, "", i3);
            }
            return this.f33632b;
        }

        public RemoteInput[] e() {
            return this.f33633c;
        }

        public int f() {
            return this.f33637g;
        }

        public boolean g() {
            return this.f33636f;
        }

        public CharSequence h() {
            return this.f33640j;
        }

        public boolean i() {
            return this.f33642l;
        }

        public boolean j() {
            return this.f33638h;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z2, int i3, boolean z3, boolean z4, boolean z5) {
            this.f33636f = true;
            this.f33632b = iconCompat;
            if (iconCompat != null && iconCompat.i() == 2) {
                this.f33639i = iconCompat.g();
            }
            this.f33640j = Builder.e(charSequence);
            this.f33641k = pendingIntent;
            this.f33631a = bundle == null ? new Bundle() : bundle;
            this.f33633c = remoteInputArr;
            this.f33634d = remoteInputArr2;
            this.f33635e = z2;
            this.f33637g = i3;
            this.f33636f = z3;
            this.f33638h = z4;
            this.f33642l = z5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api20Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BigPictureStyle extends Style {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IconCompat f33657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IconCompat f33658f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f33659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CharSequence f33660h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f33661i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Api23Impl {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Api31Impl {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z2) {
                bigPictureStyle.showBigPictureWhenCollapsed(z2);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f33726b);
            IconCompat iconCompat = this.f33657e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(bigContentTitle, this.f33657e.p(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).e() : null));
                } else if (iconCompat.i() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f33657e.f());
                }
            }
            if (this.f33659g) {
                if (this.f33658f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    Api23Impl.a(bigContentTitle, this.f33658f.p(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).e() : null));
                }
            }
            if (this.f33728d) {
                bigContentTitle.setSummaryText(this.f33727c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.c(bigContentTitle, this.f33661i);
                Api31Impl.b(bigContentTitle, this.f33660h);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public BigPictureStyle h(Bitmap bitmap) {
            this.f33658f = bitmap == null ? null : IconCompat.c(bitmap);
            this.f33659g = true;
            return this;
        }

        public BigPictureStyle i(Bitmap bitmap) {
            this.f33657e = bitmap == null ? null : IconCompat.c(bitmap);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BigTextStyle extends Style {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f33662e;

        @Override // androidx.core.app.NotificationCompat.Style
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f33726b).bigText(this.f33662e);
            if (this.f33728d) {
                bigTextStyleBigText.setSummaryText(this.f33727c);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public BigTextStyle h(CharSequence charSequence) {
            this.f33662e = Builder.e(charSequence);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class BubbleMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PendingIntent f33663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PendingIntent f33664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IconCompat f33665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f33666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f33667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f33668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f33669g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Api29Impl {
            static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.f() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.e().o()).setIntent(bubbleMetadata.f()).setDeleteIntent(bubbleMetadata.b()).setAutoExpandBubble(bubbleMetadata.a()).setSuppressNotification(bubbleMetadata.h());
                if (bubbleMetadata.c() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.c());
                }
                if (bubbleMetadata.d() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.d());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Api30Impl {
            static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = bubbleMetadata.g() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.g()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.f(), bubbleMetadata.e().o());
                builder.setDeleteIntent(bubbleMetadata.b()).setAutoExpandBubble(bubbleMetadata.a()).setSuppressNotification(bubbleMetadata.h());
                if (bubbleMetadata.c() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.c());
                }
                if (bubbleMetadata.d() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.d());
                }
                return builder.build();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private PendingIntent f33670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IconCompat f33671b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f33672c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f33673d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f33674e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private PendingIntent f33675f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f33676g;

            public Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.f33670a = pendingIntent;
                this.f33671b = iconCompat;
            }

            private Builder d(int i3, boolean z2) {
                if (z2) {
                    this.f33674e = i3 | this.f33674e;
                    return this;
                }
                this.f33674e = (~i3) & this.f33674e;
                return this;
            }

            public BubbleMetadata a() {
                String str = this.f33676g;
                if (str == null && this.f33670a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f33671b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                BubbleMetadata bubbleMetadata = new BubbleMetadata(this.f33670a, this.f33675f, this.f33671b, this.f33672c, this.f33673d, this.f33674e, str);
                bubbleMetadata.i(this.f33674e);
                return bubbleMetadata;
            }

            public Builder b(boolean z2) {
                d(1, z2);
                return this;
            }

            public Builder c(int i3) {
                this.f33672c = Math.max(i3, 0);
                this.f33673d = 0;
                return this;
            }

            public Builder e(boolean z2) {
                d(2, z2);
                return this;
            }
        }

        public static Notification.BubbleMetadata j(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                return Api30Impl.a(bubbleMetadata);
            }
            if (i3 == 29) {
                return Api29Impl.a(bubbleMetadata);
            }
            return null;
        }

        public boolean a() {
            return (this.f33668f & 1) != 0;
        }

        public PendingIntent b() {
            return this.f33664b;
        }

        public int c() {
            return this.f33666d;
        }

        public int d() {
            return this.f33667e;
        }

        public IconCompat e() {
            return this.f33665c;
        }

        public PendingIntent f() {
            return this.f33663a;
        }

        public String g() {
            return this.f33669g;
        }

        public boolean h() {
            return (this.f33668f & 2) != 0;
        }

        public void i(int i3) {
            this.f33668f = i3;
        }

        private BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i3, int i4, int i5, String str) {
            this.f33663a = pendingIntent;
            this.f33665c = iconCompat;
            this.f33666d = i3;
            this.f33667e = i4;
            this.f33664b = pendingIntent2;
            this.f33668f = i5;
            this.f33669g = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CarExtender implements Extender {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api20Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api29Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Deprecated
        public static class UnreadConversation {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static class Builder {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DecoratedCustomViewStyle extends Style {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
            static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.a().setStyle(Api24Impl.a());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews e(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews f(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Extender {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class InboxStyle extends Style {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList f33713e;

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f33726b);
            if (this.f33728d) {
                bigContentTitle.setSummaryText(this.f33727c);
            }
            ArrayList arrayList = this.f33713e;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                bigContentTitle.addLine((CharSequence) obj);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class TvExtender implements Extender {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class WearableExtender implements Extender {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PendingIntent f33731c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f33733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f33734f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f33738j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f33740l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f33741m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f33742n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList f33729a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f33730b = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList f33732d = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f33735g = 8388613;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f33736h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f33737i = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f33739k = 80;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api20Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api23Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api31Impl {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f33729a = new ArrayList(this.f33729a);
            wearableExtender.f33730b = this.f33730b;
            wearableExtender.f33731c = this.f33731c;
            wearableExtender.f33732d = new ArrayList(this.f33732d);
            wearableExtender.f33733e = this.f33733e;
            wearableExtender.f33734f = this.f33734f;
            wearableExtender.f33735g = this.f33735g;
            wearableExtender.f33736h = this.f33736h;
            wearableExtender.f33737i = this.f33737i;
            wearableExtender.f33738j = this.f33738j;
            wearableExtender.f33739k = this.f33739k;
            wearableExtender.f33740l = this.f33740l;
            wearableExtender.f33741m = this.f33741m;
            wearableExtender.f33742n = this.f33742n;
            return wearableExtender;
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MessagingStyle extends Style {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f33714e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f33715f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Person f33716g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CharSequence f33717h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Boolean f33718i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api26Impl {
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api28Impl {
            static Notification.MessagingStyle a(android.app.Person person) {
                return new Notification.MessagingStyle(person);
            }

            static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z2) {
                return messagingStyle.setGroupConversation(z2);
            }
        }

        public MessagingStyle(Person person) {
            if (TextUtils.isEmpty(person.d())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.f33716g = person;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f33716g.d());
            bundle.putBundle("android.messagingStyleUser", this.f33716g.i());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f33717h);
            if (this.f33717h != null && this.f33718i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f33717h);
            }
            if (!this.f33714e.isEmpty()) {
                bundle.putParcelableArray("android.messages", Message.a(this.f33714e));
            }
            if (!this.f33715f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", Message.a(this.f33715f));
            }
            Boolean bool = this.f33718i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            i(h());
            Notification.MessagingStyle messagingStyleA = Api28Impl.a(this.f33716g.h());
            Iterator it = this.f33714e.iterator();
            while (it.hasNext()) {
                Api24Impl.a(messagingStyleA, ((Message) it.next()).g());
            }
            Iterator it2 = this.f33715f.iterator();
            while (it2.hasNext()) {
                Api26Impl.a(messagingStyleA, ((Message) it2.next()).g());
            }
            this.f33718i.booleanValue();
            Api24Impl.b(messagingStyleA, this.f33717h);
            Api28Impl.b(messagingStyleA, this.f33718i.booleanValue());
            messagingStyleA.setBuilder(notificationBuilderWithBuilderAccessor.a());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        public boolean h() {
            Builder builder = this.f33725a;
            if (builder != null && builder.f33677a.getApplicationInfo().targetSdkVersion < 28 && this.f33718i == null) {
                return this.f33717h != null;
            }
            Boolean bool = this.f33718i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public MessagingStyle i(boolean z2) {
            this.f33718i = Boolean.valueOf(z2);
            return this;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Message {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CharSequence f33719a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f33720b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Person f33721c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Bundle f33722d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f33723e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private Uri f33724f;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api24Impl {
                static Notification.MessagingStyle.Message a(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    bundleArr[i3] = ((Message) list.get(i3)).h();
                }
                return bundleArr;
            }

            private Bundle h() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f33719a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f33720b);
                Person person = this.f33721c;
                if (person != null) {
                    bundle.putCharSequence("sender", person.d());
                    bundle.putParcelable("sender_person", Api28Impl.a(this.f33721c.h()));
                }
                String str = this.f33723e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f33724f;
                if (uri != null) {
                    bundle.putParcelable(ShareConstants.MEDIA_URI, uri);
                }
                Bundle bundle2 = this.f33722d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public String b() {
                return this.f33723e;
            }

            public Uri c() {
                return this.f33724f;
            }

            public Person d() {
                return this.f33721c;
            }

            public CharSequence e() {
                return this.f33719a;
            }

            public long f() {
                return this.f33720b;
            }

            Notification.MessagingStyle.Message g() {
                Person personD = d();
                Notification.MessagingStyle.Message messageB = Api28Impl.b(e(), f(), personD == null ? null : personD.h());
                if (b() != null) {
                    Api24Impl.a(messageB, b(), c());
                }
                return messageB;
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static class Api28Impl {
                static Notification.MessagingStyle.Message b(CharSequence charSequence, long j3, android.app.Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j3, person);
                }

                static Parcelable a(android.app.Person person) {
                    return person;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        LocusIdCompat N;
        long O;
        int P;
        int Q;
        boolean R;
        BubbleMetadata S;
        Notification T;
        boolean U;
        Object V;
        public ArrayList W;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f33677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f33678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f33679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f33680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f33681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f33682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        PendingIntent f33683g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f33684h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        RemoteViews f33685i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        IconCompat f33686j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        CharSequence f33687k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33688l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33689m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f33690n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f33691o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Style f33692p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        CharSequence f33693q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        CharSequence f33694r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        CharSequence[] f33695s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f33696t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f33697u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f33698v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f33699w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f33700x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f33701y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f33702z;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api21Impl {
            static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i3) {
                return builder.setContentType(i3);
            }

            static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i3) {
                return builder.setUsage(i3);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api23Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
        }

        public Builder(Context context, String str) {
            this.f33678b = new ArrayList();
            this.f33679c = new ArrayList();
            this.f33680d = new ArrayList();
            this.f33690n = true;
            this.f33702z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            this.Q = 0;
            Notification notification = new Notification();
            this.T = notification;
            this.f33677a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.T.audioStreamType = -1;
            this.f33689m = 0;
            this.W = new ArrayList();
            this.R = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void q(int i3, boolean z2) {
            if (z2) {
                Notification notification = this.T;
                notification.flags = i3 | notification.flags;
            } else {
                Notification notification2 = this.T;
                notification2.flags = (~i3) & notification2.flags;
            }
        }

        public Builder A(boolean z2) {
            this.U = z2;
            return this;
        }

        public Builder B(int i3) {
            this.T.icon = i3;
            return this;
        }

        public Builder C(Uri uri) {
            Notification notification = this.T;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderD = Api21Impl.d(Api21Impl.c(Api21Impl.b(), 4), 5);
            this.T.audioAttributes = Api21Impl.a(builderD);
            return this;
        }

        public Builder D(Style style) {
            if (this.f33692p != style) {
                this.f33692p = style;
                if (style != null) {
                    style.g(this);
                }
            }
            return this;
        }

        public Builder E(CharSequence charSequence) {
            this.f33693q = e(charSequence);
            return this;
        }

        public Builder F(CharSequence charSequence) {
            this.T.tickerText = e(charSequence);
            return this;
        }

        public Builder G(long[] jArr) {
            this.T.vibrate = jArr;
            return this;
        }

        public Builder H(int i3) {
            this.F = i3;
            return this;
        }

        public Builder I(long j3) {
            this.T.when = j3;
            return this;
        }

        public Builder a(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f33678b.add(new Action(i3, charSequence, pendingIntent));
            return this;
        }

        public Builder b(Person person) {
            if (person != null) {
                this.f33679c.add(person);
            }
            return this;
        }

        public Notification c() {
            return new NotificationCompatBuilder(this).c();
        }

        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public Builder f(boolean z2) {
            q(16, z2);
            return this;
        }

        public Builder g(int i3) {
            this.L = i3;
            return this;
        }

        public Builder h(BubbleMetadata bubbleMetadata) {
            this.S = bubbleMetadata;
            return this;
        }

        public Builder i(String str) {
            this.C = str;
            return this;
        }

        public Builder j(String str) {
            this.K = str;
            return this;
        }

        public Builder k(int i3) {
            this.E = i3;
            return this;
        }

        public Builder l(PendingIntent pendingIntent) {
            this.f33683g = pendingIntent;
            return this;
        }

        public Builder m(CharSequence charSequence) {
            this.f33682f = e(charSequence);
            return this;
        }

        public Builder n(CharSequence charSequence) {
            this.f33681e = e(charSequence);
            return this;
        }

        public Builder o(int i3) {
            Notification notification = this.T;
            notification.defaults = i3;
            if ((i3 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder p(PendingIntent pendingIntent) {
            this.T.deleteIntent = pendingIntent;
            return this;
        }

        public Builder r(Bitmap bitmap) {
            this.f33686j = bitmap == null ? null : IconCompat.c(NotificationCompat.b(this.f33677a, bitmap));
            return this;
        }

        public Builder s(int i3, int i4, int i5) {
            Notification notification = this.T;
            notification.ledARGB = i3;
            notification.ledOnMS = i4;
            notification.ledOffMS = i5;
            notification.flags = ((i4 == 0 || i5 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public Builder t(boolean z2) {
            this.f33702z = z2;
            return this;
        }

        public Builder u(int i3) {
            this.f33688l = i3;
            return this;
        }

        public Builder v(boolean z2) {
            q(2, z2);
            return this;
        }

        public Builder w(boolean z2) {
            q(8, z2);
            return this;
        }

        public Builder x(int i3) {
            this.f33689m = i3;
            return this;
        }

        public Builder y(String str) {
            this.M = str;
            return this;
        }

        public Builder z(boolean z2) {
            this.f33690n = z2;
            return this;
        }

        public Builder(Context context) {
            this(context, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CallStyle extends Style {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f33703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Person f33704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private PendingIntent f33705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private PendingIntent f33706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PendingIntent f33707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f33708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Integer f33709k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Integer f33710l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private IconCompat f33711m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private CharSequence f33712n;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api20Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api21Impl {
            static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api31Impl {
            static Notification.CallStyle a(android.app.Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle b(android.app.Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification.CallStyle c(android.app.Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle d(Notification.CallStyle callStyle, int i3) {
                return callStyle.setAnswerButtonColorHint(i3);
            }

            static Notification.CallStyle e(Notification.CallStyle callStyle, int i3) {
                return callStyle.setDeclineButtonColorHint(i3);
            }

            static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z2) {
                return callStyle.setIsVideo(z2);
            }

            static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        private String i() {
            int i3 = this.f33703e;
            if (i3 == 1) {
                return this.f33725a.f33677a.getResources().getString(R.string.f33527e);
            }
            if (i3 == 2) {
                return this.f33725a.f33677a.getResources().getString(R.string.f33528f);
            }
            if (i3 != 3) {
                return null;
            }
            return this.f33725a.f33677a.getResources().getString(R.string.f33529g);
        }

        private boolean j(Action action) {
            return action != null && action.c().getBoolean("key_action_priority");
        }

        private Action k(int i3, int i4, Integer num, int i5, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.getColor(this.f33725a.f33677a, i5));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f33725a.f33677a.getResources().getString(i4));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action actionA = new Action.Builder(IconCompat.d(this.f33725a.f33677a, i3), spannableStringBuilder, pendingIntent).a();
            actionA.c().putBoolean("key_action_priority", true);
            return actionA;
        }

        private Action l() {
            int i3 = R.drawable.f33495b;
            int i4 = R.drawable.f33494a;
            PendingIntent pendingIntent = this.f33705g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z2 = this.f33708j;
            return k(z2 ? i3 : i4, z2 ? R.string.f33524b : R.string.f33523a, this.f33709k, R.color.f33492a, pendingIntent);
        }

        private Action m() {
            int i3 = R.drawable.f33496c;
            PendingIntent pendingIntent = this.f33706h;
            return pendingIntent == null ? k(i3, R.string.f33526d, this.f33710l, R.color.f33493b, this.f33707i) : k(i3, R.string.f33525c, this.f33710l, R.color.f33493b, pendingIntent);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f33703e);
            bundle.putBoolean("android.callIsVideo", this.f33708j);
            Person person = this.f33704f;
            if (person != null) {
                bundle.putParcelable("android.callPerson", Api28Impl.b(person.h()));
            }
            IconCompat iconCompat = this.f33711m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", Api23Impl.a(iconCompat.p(this.f33725a.f33677a)));
            }
            bundle.putCharSequence("android.verificationText", this.f33712n);
            bundle.putParcelable("android.answerIntent", this.f33705g);
            bundle.putParcelable("android.declineIntent", this.f33706h);
            bundle.putParcelable("android.hangUpIntent", this.f33707i);
            Integer num = this.f33709k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f33710l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence charSequenceI = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceI = null;
            if (Build.VERSION.SDK_INT < 31) {
                Notification.Builder builderA = notificationBuilderWithBuilderAccessor.a();
                Person person = this.f33704f;
                builderA.setContentTitle(person != null ? person.d() : null);
                Bundle bundle = this.f33725a.D;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceI = this.f33725a.D.getCharSequence("android.text");
                }
                if (charSequenceI == null) {
                    charSequenceI = i();
                }
                builderA.setContentText(charSequenceI);
                Person person2 = this.f33704f;
                if (person2 != null) {
                    if (person2.b() != null) {
                        Api23Impl.b(builderA, this.f33704f.b().p(this.f33725a.f33677a));
                    }
                    Api28Impl.a(builderA, this.f33704f.h());
                }
                Api21Impl.a(builderA, "call");
                return;
            }
            int i3 = this.f33703e;
            if (i3 == 1) {
                callStyleA = Api31Impl.a(this.f33704f.h(), this.f33706h, this.f33705g);
            } else if (i3 == 2) {
                callStyleA = Api31Impl.b(this.f33704f.h(), this.f33707i);
            } else if (i3 == 3) {
                callStyleA = Api31Impl.c(this.f33704f.h(), this.f33707i, this.f33705g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f33703e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(notificationBuilderWithBuilderAccessor.a());
                Integer num = this.f33709k;
                if (num != null) {
                    Api31Impl.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f33710l;
                if (num2 != null) {
                    Api31Impl.e(callStyleA, num2.intValue());
                }
                Api31Impl.h(callStyleA, this.f33712n);
                IconCompat iconCompat = this.f33711m;
                if (iconCompat != null) {
                    Api31Impl.g(callStyleA, iconCompat.p(this.f33725a.f33677a));
                }
                Api31Impl.f(callStyleA, this.f33708j);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String c() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList h() {
            Action actionM = m();
            Action actionL = l();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(actionM);
            ArrayList arrayList2 = this.f33725a.f33678b;
            int i3 = 2;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    Action action = (Action) obj;
                    if (action.j()) {
                        arrayList.add(action);
                    } else if (!j(action) && i3 > 1) {
                        arrayList.add(action);
                        i3--;
                    }
                    if (actionL != null && i3 == 1) {
                        arrayList.add(actionL);
                        i3--;
                    }
                }
            }
            if (actionL != null && i3 >= 1) {
                arrayList.add(actionL);
            }
            return arrayList;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api23Impl {
            static void b(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }

            static Parcelable a(Icon icon) {
                return icon;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api28Impl {
            static Notification.Builder a(Notification.Builder builder, android.app.Person person) {
                return builder.addPerson(person);
            }

            static Parcelable b(android.app.Person person) {
                return person;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Style {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected Builder f33725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f33726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f33727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f33728d = false;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api24Impl {
        }

        public void a(Bundle bundle) {
            if (this.f33728d) {
                bundle.putCharSequence("android.summaryText", this.f33727c);
            }
            CharSequence charSequence = this.f33726b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        protected String c() {
            return null;
        }

        public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews e(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews f(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void g(Builder builder) {
            if (this.f33725a != builder) {
                this.f33725a = builder;
                if (builder != null) {
                    builder.D(this);
                }
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        return bitmap;
    }
}
