package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: androidx.media3.common.DrmInitData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DrmInitData[] newArray(int i3) {
            return new DrmInitData[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SchemeData[] f40581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40584d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: androidx.media3.common.DrmInitData.SchemeData.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SchemeData[] newArray(int i3) {
                return new SchemeData[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f40585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f40586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f40587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f40588d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f40589f;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public SchemeData a(byte[] bArr) {
            return new SchemeData(this.f40586b, this.f40587c, this.f40588d, bArr);
        }

        public boolean c() {
            return this.f40589f != null;
        }

        public boolean d(UUID uuid) {
            return C.f40541a.equals(this.f40586b) || uuid.equals(this.f40586b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return Objects.equals(this.f40587c, schemeData.f40587c) && Objects.equals(this.f40588d, schemeData.f40588d) && Objects.equals(this.f40586b, schemeData.f40586b) && Arrays.equals(this.f40589f, schemeData.f40589f);
        }

        public int hashCode() {
            if (this.f40585a == 0) {
                int iHashCode = this.f40586b.hashCode() * 31;
                String str = this.f40587c;
                this.f40585a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f40588d.hashCode()) * 31) + Arrays.hashCode(this.f40589f);
            }
            return this.f40585a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f40586b.getMostSignificantBits());
            parcel.writeLong(this.f40586b.getLeastSignificantBits());
            parcel.writeString(this.f40587c);
            parcel.writeString(this.f40588d);
            parcel.writeByteArray(this.f40589f);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this.f40586b = (UUID) Assertions.e(uuid);
            this.f40587c = str;
            this.f40588d = MimeTypes.r((String) Assertions.e(str2));
            this.f40589f = bArr;
        }

        SchemeData(Parcel parcel) {
            this.f40586b = new UUID(parcel.readLong(), parcel.readLong());
            this.f40587c = parcel.readString();
            this.f40588d = (String) Util.k(parcel.readString());
            this.f40589f = parcel.createByteArray();
        }
    }

    public DrmInitData(List list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    private static boolean c(ArrayList arrayList, int i3, UUID uuid) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (((SchemeData) arrayList.get(i4)).f40586b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static DrmInitData e(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f40583c;
            for (SchemeData schemeData : drmInitData.f40581a) {
                if (schemeData.c()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f40583c;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f40581a) {
                if (schemeData2.c() && !c(arrayList, size, schemeData2.f40586b)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C.f40541a;
        return uuid.equals(schemeData.f40586b) ? uuid.equals(schemeData2.f40586b) ? 0 : 1 : schemeData.f40586b.compareTo(schemeData2.f40586b);
    }

    public DrmInitData d(String str) {
        return Objects.equals(this.f40583c, str) ? this : new DrmInitData(str, false, this.f40581a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DrmInitData.class == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            if (Objects.equals(this.f40583c, drmInitData.f40583c) && Arrays.equals(this.f40581a, drmInitData.f40581a)) {
                return true;
            }
        }
        return false;
    }

    public SchemeData f(int i3) {
        return this.f40581a[i3];
    }

    public int hashCode() {
        if (this.f40582b == 0) {
            String str = this.f40583c;
            this.f40582b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f40581a);
        }
        return this.f40582b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f40583c);
        parcel.writeTypedArray(this.f40581a, 0);
    }

    public DrmInitData(String str, List list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    private DrmInitData(String str, boolean z2, SchemeData... schemeDataArr) {
        this.f40583c = str;
        schemeDataArr = z2 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f40581a = schemeDataArr;
        this.f40584d = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    DrmInitData(Parcel parcel) {
        this.f40583c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) Util.k((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f40581a = schemeDataArr;
        this.f40584d = schemeDataArr.length;
    }
}
