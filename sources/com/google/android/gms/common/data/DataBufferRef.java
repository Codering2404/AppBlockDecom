package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataBufferRef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final DataHolder f71893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f71894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f71895c;

    protected final void a(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f71893a.getCount()) {
            z2 = true;
        }
        Preconditions.q(z2);
        this.f71894b = i3;
        this.f71895c = this.f71893a.j0(i3);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.b(Integer.valueOf(dataBufferRef.f71894b), Integer.valueOf(this.f71894b)) && Objects.b(Integer.valueOf(dataBufferRef.f71895c), Integer.valueOf(this.f71895c)) && dataBufferRef.f71893a == this.f71893a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f71894b), Integer.valueOf(this.f71895c), this.f71893a);
    }
}
