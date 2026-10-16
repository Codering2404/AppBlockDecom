package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f71912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList f71913c;

    private final void n() {
        synchronized (this) {
            try {
                if (!this.f71912b) {
                    int count = ((DataHolder) Preconditions.m(this.f71884a)).getCount();
                    ArrayList arrayList = new ArrayList();
                    this.f71913c = arrayList;
                    if (count > 0) {
                        arrayList.add(0);
                        String strF = f();
                        String strG0 = this.f71884a.g0(strF, 0, this.f71884a.j0(0));
                        for (int i3 = 1; i3 < count; i3++) {
                            int iJ0 = this.f71884a.j0(i3);
                            String strG02 = this.f71884a.g0(strF, i3, iJ0);
                            if (strG02 == null) {
                                throw new NullPointerException("Missing value for markerColumn: " + strF + ", at row: " + i3 + ", for window: " + iJ0);
                            }
                            if (!strG02.equals(strG0)) {
                                this.f71913c.add(Integer.valueOf(i3));
                                strG0 = strG02;
                            }
                        }
                    }
                    this.f71912b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected String a() {
        return null;
    }

    protected abstract Object b(int i3, int i4);

    protected abstract String f();

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Object get(int i3) {
        int iIntValue;
        int iIntValue2;
        n();
        int iL = l(i3);
        int i4 = 0;
        if (i3 >= 0 && i3 != this.f71913c.size()) {
            if (i3 == this.f71913c.size() - 1) {
                iIntValue = ((DataHolder) Preconditions.m(this.f71884a)).getCount();
                iIntValue2 = ((Integer) this.f71913c.get(i3)).intValue();
            } else {
                iIntValue = ((Integer) this.f71913c.get(i3 + 1)).intValue();
                iIntValue2 = ((Integer) this.f71913c.get(i3)).intValue();
            }
            int i5 = iIntValue - iIntValue2;
            if (i5 == 1) {
                int iL2 = l(i3);
                int iJ0 = ((DataHolder) Preconditions.m(this.f71884a)).j0(iL2);
                String strA = a();
                if (strA == null || this.f71884a.g0(strA, iL2, iJ0) != null) {
                    i4 = 1;
                }
            } else {
                i4 = i5;
            }
        }
        return b(iL, i4);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        n();
        return this.f71913c.size();
    }

    final int l(int i3) {
        if (i3 >= 0 && i3 < this.f71913c.size()) {
            return ((Integer) this.f71913c.get(i3)).intValue();
        }
        throw new IllegalArgumentException("Position " + i3 + " is out of bounds for this buffer");
    }
}
