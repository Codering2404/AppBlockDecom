package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class VersionedParcelParcel extends VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f53715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f53716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f53717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f53718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f53719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f53720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f53721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f53722k;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f53716e.writeInt(-1);
        } else {
            this.f53716e.writeInt(bArr.length);
            this.f53716e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f53716e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i3) {
        this.f53716e.writeInt(i3);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f53716e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f53716e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i3 = this.f53720i;
        if (i3 >= 0) {
            int i4 = this.f53715d.get(i3);
            int iDataPosition = this.f53716e.dataPosition();
            this.f53716e.setDataPosition(i4);
            this.f53716e.writeInt(iDataPosition - i4);
            this.f53716e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f53716e;
        int iDataPosition = parcel.dataPosition();
        int i3 = this.f53721j;
        if (i3 == this.f53717f) {
            i3 = this.f53718g;
        }
        return new VersionedParcelParcel(parcel, iDataPosition, i3, this.f53719h + "  ", this.f53712a, this.f53713b, this.f53714c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f53716e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int i3 = this.f53716e.readInt();
        if (i3 < 0) {
            return null;
        }
        byte[] bArr = new byte[i3];
        this.f53716e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f53716e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i3) {
        while (this.f53721j < this.f53718g) {
            int i4 = this.f53722k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            this.f53716e.setDataPosition(this.f53721j);
            int i5 = this.f53716e.readInt();
            this.f53722k = this.f53716e.readInt();
            this.f53721j += i5;
        }
        return this.f53722k == i3;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f53716e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Parcelable q() {
        return this.f53716e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f53716e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i3) {
        a();
        this.f53720i = i3;
        this.f53715d.put(i3, this.f53716e.dataPosition());
        E(0);
        E(i3);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z2) {
        this.f53716e.writeInt(z2 ? 1 : 0);
    }

    private VersionedParcelParcel(Parcel parcel, int i3, int i4, String str, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f53715d = new SparseIntArray();
        this.f53720i = -1;
        this.f53722k = -1;
        this.f53716e = parcel;
        this.f53717f = i3;
        this.f53718g = i4;
        this.f53721j = i3;
        this.f53719h = str;
    }
}
