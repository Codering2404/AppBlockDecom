package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Builder f71898l = new zab(new String[0], null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f71900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Bundle f71901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CursorWindow[] f71902d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f71903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f71904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f71905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f71906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f71907j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f71908k = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f71909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f71910b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashMap f71911c = new HashMap();
    }

    DataHolder(int i3, String[] strArr, CursorWindow[] cursorWindowArr, int i4, Bundle bundle) {
        this.f71899a = i3;
        this.f71900b = strArr;
        this.f71902d = cursorWindowArr;
        this.f71903f = i4;
        this.f71904g = bundle;
    }

    private final void z0(String str, int i3) {
        Bundle bundle = this.f71901c;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i3 < 0 || i3 >= this.f71906i) {
            throw new CursorIndexOutOfBoundsException(i3, this.f71906i);
        }
    }

    public byte[] M(String str, int i3, int i4) {
        z0(str, i3);
        return this.f71902d[i4].getBlob(i3, this.f71901c.getInt(str));
    }

    public Bundle N() {
        return this.f71904g;
    }

    public int O() {
        return this.f71903f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (!this.f71907j) {
                    this.f71907j = true;
                    int i3 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f71902d;
                        if (i3 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i3].close();
                        i3++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f71908k && this.f71902d.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
            }
        } finally {
            super.finalize();
        }
    }

    public String g0(String str, int i3, int i4) {
        z0(str, i3);
        return this.f71902d[i4].getString(i3, this.f71901c.getInt(str));
    }

    public int getCount() {
        return this.f71906i;
    }

    public boolean isClosed() {
        boolean z2;
        synchronized (this) {
            z2 = this.f71907j;
        }
        return z2;
    }

    public int j0(int i3) {
        int length;
        int i4 = 0;
        Preconditions.q(i3 >= 0 && i3 < this.f71906i);
        while (true) {
            int[] iArr = this.f71905h;
            length = iArr.length;
            if (i4 >= length) {
                break;
            }
            if (i3 < iArr[i4]) {
                i4--;
                break;
            }
            i4++;
        }
        return i4 == length ? i4 - 1 : i4;
    }

    public final void w0() {
        this.f71901c = new Bundle();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String[] strArr = this.f71900b;
            if (i4 >= strArr.length) {
                break;
            }
            this.f71901c.putInt(strArr[i4], i4);
            i4++;
        }
        this.f71905h = new int[this.f71902d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f71902d;
            if (i3 >= cursorWindowArr.length) {
                this.f71906i = numRows;
                return;
            }
            this.f71905h[i3] = numRows;
            numRows += this.f71902d[i3].getNumRows() - (numRows - cursorWindowArr[i3].getStartPosition());
            i3++;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String[] strArr = this.f71900b;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.H(parcel, 1, strArr, false);
        SafeParcelWriter.J(parcel, 2, this.f71902d, i3, false);
        SafeParcelWriter.u(parcel, 3, O());
        SafeParcelWriter.j(parcel, 4, N(), false);
        SafeParcelWriter.u(parcel, 1000, this.f71899a);
        SafeParcelWriter.b(parcel, iA);
        if ((i3 & 1) != 0) {
            close();
        }
    }
}
