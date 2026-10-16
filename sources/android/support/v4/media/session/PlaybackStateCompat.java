package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i3) {
            return new PlaybackStateCompat[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f293d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final CharSequence f296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final long f297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List f298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final long f299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Bundle f300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object f301m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f306e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CharSequence f309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f311j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Bundle f312k;

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f302a = arrayList;
            this.f311j = -1L;
            this.f303b = playbackStateCompat.f290a;
            this.f304c = playbackStateCompat.f291b;
            this.f306e = playbackStateCompat.f293d;
            this.f310i = playbackStateCompat.f297i;
            this.f305d = playbackStateCompat.f292c;
            this.f307f = playbackStateCompat.f294f;
            this.f308g = playbackStateCompat.f295g;
            this.f309h = playbackStateCompat.f296h;
            List list = playbackStateCompat.f298j;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f311j = playbackStateCompat.f299k;
            this.f312k = playbackStateCompat.f300l;
        }

        public PlaybackStateCompat a() {
            return new PlaybackStateCompat(this.f303b, this.f304c, this.f305d, this.f306e, this.f307f, this.f308g, this.f309h, this.f310i, this.f302a, this.f311j, this.f312k);
        }

        public Builder b(int i3, long j3, float f3, long j4) {
            this.f303b = i3;
            this.f304c = j3;
            this.f310i = j4;
            this.f306e = f3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    PlaybackStateCompat(int i3, long j3, long j4, float f3, long j5, int i4, CharSequence charSequence, long j6, List list, long j7, Bundle bundle) {
        this.f290a = i3;
        this.f291b = j3;
        this.f292c = j4;
        this.f293d = f3;
        this.f294f = j5;
        this.f295g = i4;
        this.f296h = charSequence;
        this.f297i = j6;
        this.f298j = new ArrayList(list);
        this.f299k = j7;
        this.f300l = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList = null;
        if (obj == null) {
            return null;
        }
        List listD = PlaybackStateCompatApi21.d(obj);
        if (listD != null) {
            arrayList = new ArrayList(listD.size());
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.a(it.next()));
            }
        }
        Bundle bundleA = PlaybackStateCompatApi22.a(obj);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.i(obj), PlaybackStateCompatApi21.h(obj), PlaybackStateCompatApi21.c(obj), PlaybackStateCompatApi21.g(obj), PlaybackStateCompatApi21.a(obj), 0, PlaybackStateCompatApi21.e(obj), PlaybackStateCompatApi21.f(obj), arrayList, PlaybackStateCompatApi21.b(obj), bundleA);
        playbackStateCompat.f301m = obj;
        return playbackStateCompat;
    }

    public long c() {
        return this.f294f;
    }

    public long d() {
        return this.f297i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.f293d;
    }

    public long f() {
        return this.f291b;
    }

    public int g() {
        return this.f290a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f290a + ", position=" + this.f291b + ", buffered position=" + this.f292c + ", speed=" + this.f293d + ", updated=" + this.f297i + ", actions=" + this.f294f + ", error code=" + this.f295g + ", error message=" + this.f296h + ", custom actions=" + this.f298j + ", active item id=" + this.f299k + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f290a);
        parcel.writeLong(this.f291b);
        parcel.writeFloat(this.f293d);
        parcel.writeLong(this.f297i);
        parcel.writeLong(this.f292c);
        parcel.writeLong(this.f294f);
        TextUtils.writeToParcel(this.f296h, parcel, i3);
        parcel.writeTypedList(this.f298j);
        parcel.writeLong(this.f299k);
        parcel.writeBundle(this.f300l);
        parcel.writeInt(this.f295g);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i3) {
                return new CustomAction[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f316d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Object f317f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        CustomAction(String str, CharSequence charSequence, int i3, Bundle bundle) {
            this.f313a = str;
            this.f314b = charSequence;
            this.f315c = i3;
            this.f316d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.a(obj), PlaybackStateCompatApi21.CustomAction.d(obj), PlaybackStateCompatApi21.CustomAction.c(obj), PlaybackStateCompatApi21.CustomAction.b(obj));
            customAction.f317f = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f314b) + ", mIcon=" + this.f315c + ", mExtras=" + this.f316d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f313a);
            TextUtils.writeToParcel(this.f314b, parcel, i3);
            parcel.writeInt(this.f315c);
            parcel.writeBundle(this.f316d);
        }

        CustomAction(Parcel parcel) {
            this.f313a = parcel.readString();
            this.f314b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f315c = parcel.readInt();
            this.f316d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f290a = parcel.readInt();
        this.f291b = parcel.readLong();
        this.f293d = parcel.readFloat();
        this.f297i = parcel.readLong();
        this.f292c = parcel.readLong();
        this.f294f = parcel.readLong();
        this.f296h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f298j = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f299k = parcel.readLong();
        this.f300l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f295g = parcel.readInt();
    }
}
