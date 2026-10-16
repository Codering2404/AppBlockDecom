package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() { // from class: androidx.media3.exoplayer.offline.DownloadRequest.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i3) {
            return new DownloadRequest[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f44430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f44432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f44433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f44434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f44435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ByteRange f44436i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f44437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f44438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f44439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f44440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f44441e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f44442f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f44443g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ByteRange f44444h = null;

        public Builder(String str, Uri uri) {
            this.f44437a = str;
            this.f44438b = uri;
        }

        public DownloadRequest a() {
            String str = this.f44437a;
            Uri uri = this.f44438b;
            String str2 = this.f44439c;
            List listY = this.f44440d;
            if (listY == null) {
                listY = ImmutableList.y();
            }
            return new DownloadRequest(str, uri, str2, listY, this.f44441e, this.f44442f, this.f44443g, this.f44444h);
        }

        public Builder b(String str) {
            this.f44442f = str;
            return this;
        }

        public Builder c(byte[] bArr) {
            this.f44443g = bArr;
            return this;
        }

        public Builder d(byte[] bArr) {
            this.f44441e = bArr;
            return this;
        }

        public Builder e(String str) {
            this.f44439c = MimeTypes.r(str);
            return this;
        }

        public Builder f(List list) {
            this.f44440d = list;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest a(DownloadRequest downloadRequest) {
        List arrayList;
        Assertions.a(this.f44429a.equals(downloadRequest.f44429a));
        if (this.f44432d.isEmpty() || downloadRequest.f44432d.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList(this.f44432d);
            for (int i3 = 0; i3 < downloadRequest.f44432d.size(); i3++) {
                StreamKey streamKey = (StreamKey) downloadRequest.f44432d.get(i3);
                if (!arrayList.contains(streamKey)) {
                    arrayList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f44429a, downloadRequest.f44430b, downloadRequest.f44431c, arrayList, downloadRequest.f44433f, downloadRequest.f44434g, downloadRequest.f44435h, downloadRequest.f44436i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f44429a.equals(downloadRequest.f44429a) && this.f44430b.equals(downloadRequest.f44430b) && Objects.equals(this.f44431c, downloadRequest.f44431c) && this.f44432d.equals(downloadRequest.f44432d) && Arrays.equals(this.f44433f, downloadRequest.f44433f) && Objects.equals(this.f44434g, downloadRequest.f44434g) && Arrays.equals(this.f44435h, downloadRequest.f44435h) && Objects.equals(this.f44436i, downloadRequest.f44436i);
    }

    public int hashCode() {
        int iHashCode = ((this.f44429a.hashCode() * 961) + this.f44430b.hashCode()) * 31;
        String str = this.f44431c;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f44432d.hashCode()) * 31) + Arrays.hashCode(this.f44433f)) * 31;
        String str2 = this.f44434g;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f44435h)) * 31;
        ByteRange byteRange = this.f44436i;
        return iHashCode3 + (byteRange != null ? byteRange.hashCode() : 0);
    }

    public String toString() {
        return this.f44431c + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f44429a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f44429a);
        parcel.writeString(this.f44430b.toString());
        parcel.writeString(this.f44431c);
        parcel.writeInt(this.f44432d.size());
        for (int i4 = 0; i4 < this.f44432d.size(); i4++) {
            parcel.writeParcelable((Parcelable) this.f44432d.get(i4), 0);
        }
        parcel.writeByteArray(this.f44433f);
        parcel.writeString(this.f44434g);
        parcel.writeByteArray(this.f44435h);
        parcel.writeParcelable(this.f44436i, 0);
    }

    private DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, ByteRange byteRange) {
        int iW0 = Util.w0(uri, str2);
        if (iW0 == 0 || iW0 == 2 || iW0 == 1) {
            Assertions.b(str3 == null, "customCacheKey must be null for type: " + iW0);
            this.f44436i = null;
        } else {
            this.f44436i = byteRange;
        }
        this.f44429a = str;
        this.f44430b = uri;
        this.f44431c = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.f44432d = Collections.unmodifiableList(arrayList);
        this.f44433f = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.f44434g = str3;
        this.f44435h = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.f41614f;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ByteRange implements Parcelable {
        public static final Parcelable.Creator<ByteRange> CREATOR = new Parcelable.Creator<ByteRange>() { // from class: androidx.media3.exoplayer.offline.DownloadRequest.ByteRange.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ByteRange createFromParcel(Parcel parcel) {
                return new ByteRange(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteRange[] newArray(int i3) {
                return new ByteRange[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f44446b;

        ByteRange(long j3, long j4) {
            Assertions.a(j3 >= 0);
            Assertions.a(j4 >= 0 || j4 == -1);
            this.f44445a = j3;
            this.f44446b = j4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ByteRange)) {
                return false;
            }
            ByteRange byteRange = (ByteRange) obj;
            return this.f44445a == byteRange.f44445a && this.f44446b == byteRange.f44446b;
        }

        public int hashCode() {
            return (((int) this.f44445a) * 961) + ((int) this.f44446b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f44445a);
            parcel.writeLong(this.f44446b);
        }

        ByteRange(Parcel parcel) {
            this(parcel.readLong(), parcel.readLong());
        }
    }

    DownloadRequest(Parcel parcel) {
        this.f44429a = (String) Util.k(parcel.readString());
        this.f44430b = Uri.parse((String) Util.k(parcel.readString()));
        this.f44431c = parcel.readString();
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f44432d = Collections.unmodifiableList(arrayList);
        this.f44433f = parcel.createByteArray();
        this.f44434g = parcel.readString();
        this.f44435h = (byte[]) Util.k(parcel.createByteArray());
        this.f44436i = (ByteRange) parcel.readParcelable(ByteRange.class.getClassLoader());
    }
}
