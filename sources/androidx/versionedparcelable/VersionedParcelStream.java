package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class VersionedParcelStream extends VersionedParcel {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Charset f53723m = Charset.forName("UTF-16");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataInputStream f53724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataOutputStream f53725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DataInputStream f53726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DataOutputStream f53727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FieldBuffer f53728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f53729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f53730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f53731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f53732l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FieldBuffer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ByteArrayOutputStream f53734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final DataOutputStream f53735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f53736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DataOutputStream f53737d;

        FieldBuffer(int i3, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f53734a = byteArrayOutputStream;
            this.f53735b = new DataOutputStream(byteArrayOutputStream);
            this.f53736c = i3;
            this.f53737d = dataOutputStream;
        }

        void a() throws IOException {
            this.f53735b.flush();
            int size = this.f53734a.size();
            this.f53737d.writeInt((this.f53736c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.f53737d.writeInt(size);
            }
            this.f53734a.writeTo(this.f53737d);
        }
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f53730j = 0;
        this.f53731k = -1;
        this.f53732l = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.f53732l;
                if (i3 != -1 && versionedParcelStream.f53730j >= i3) {
                    throw new IOException();
                }
                int i4 = super.read();
                VersionedParcelStream.this.f53730j++;
                return i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j3) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.f53732l;
                if (i3 != -1 && versionedParcelStream.f53730j >= i3) {
                    throw new IOException();
                }
                long jSkip = super.skip(j3);
                if (jSkip > 0) {
                    VersionedParcelStream.this.f53730j += (int) jSkip;
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i3, int i4) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i5 = versionedParcelStream.f53732l;
                if (i5 != -1 && versionedParcelStream.f53730j >= i5) {
                    throw new IOException();
                }
                int i6 = super.read(bArr, i3, i4);
                if (i6 > 0) {
                    VersionedParcelStream.this.f53730j += i6;
                }
                return i6;
            }
        }) : null;
        this.f53724d = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.f53725e = dataOutputStream;
        this.f53726f = dataInputStream;
        this.f53727g = dataOutputStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        try {
            if (bArr == null) {
                this.f53727g.writeInt(-1);
            } else {
                this.f53727g.writeInt(bArr.length);
                this.f53727g.write(bArr);
            }
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        if (!this.f53729i) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i3) {
        try {
            this.f53727g.writeInt(i3);
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        if (!this.f53729i) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        try {
            if (str == null) {
                this.f53727g.writeInt(-1);
                return;
            }
            byte[] bytes = str.getBytes(f53723m);
            this.f53727g.writeInt(bytes.length);
            this.f53727g.write(bytes);
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        FieldBuffer fieldBuffer = this.f53728h;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f53734a.size() != 0) {
                    this.f53728h.a();
                }
                this.f53728h = null;
            } catch (IOException e3) {
                throw new VersionedParcel.ParcelException(e3);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        return new VersionedParcelStream(this.f53726f, this.f53727g, this.f53712a, this.f53713b, this.f53714c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean f() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        try {
            return this.f53726f.readBoolean();
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        try {
            int i3 = this.f53726f.readInt();
            if (i3 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            this.f53726f.readFully(bArr);
            return bArr;
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i3) {
        while (true) {
            try {
                int i4 = this.f53731k;
                if (i4 == i3) {
                    return true;
                }
                if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                    return false;
                }
                if (this.f53730j < this.f53732l) {
                    this.f53724d.skip(r2 - r1);
                }
                this.f53732l = -1;
                int i5 = this.f53724d.readInt();
                this.f53730j = 0;
                int i6 = i5 & 65535;
                if (i6 == 65535) {
                    i6 = this.f53724d.readInt();
                }
                this.f53731k = (i5 >> 16) & 65535;
                this.f53732l = i6;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        try {
            return this.f53726f.readInt();
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Parcelable q() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        try {
            int i3 = this.f53726f.readInt();
            if (i3 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            this.f53726f.readFully(bArr);
            return new String(bArr, f53723m);
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i3) {
        a();
        FieldBuffer fieldBuffer = new FieldBuffer(i3, this.f53725e);
        this.f53728h = fieldBuffer;
        this.f53727g = fieldBuffer.f53735b;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void x(boolean z2, boolean z3) {
        if (!z2) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.f53729i = z3;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z2) {
        try {
            this.f53727g.writeBoolean(z2);
        } catch (IOException e3) {
            throw new VersionedParcel.ParcelException(e3);
        }
    }
}
