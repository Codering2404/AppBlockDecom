package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteArrayPool {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Comparator f57768e = new Comparator<byte[]>() { // from class: com.android.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f57769a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f57770b = new ArrayList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f57771c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57772d;

    public ByteArrayPool(int i3) {
        this.f57772d = i3;
    }

    private synchronized void c() {
        while (this.f57771c > this.f57772d) {
            byte[] bArr = (byte[]) this.f57769a.remove(0);
            this.f57770b.remove(bArr);
            this.f57771c -= bArr.length;
        }
    }

    public synchronized byte[] a(int i3) {
        for (int i4 = 0; i4 < this.f57770b.size(); i4++) {
            byte[] bArr = (byte[]) this.f57770b.get(i4);
            if (bArr.length >= i3) {
                this.f57771c -= bArr.length;
                this.f57770b.remove(i4);
                this.f57769a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f57772d) {
                this.f57769a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f57770b, bArr, f57768e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f57770b.add(iBinarySearch, bArr);
                this.f57771c += bArr.length;
                c();
            }
        }
    }
}
