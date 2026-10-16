package com.applovin.impl;

import com.applovin.impl.ik;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ik {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator f60493h = new Comparator() { // from class: com.applovin.impl.dy
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ik.a((ik.b) obj, (ik.b) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator f60494i = new Comparator() { // from class: com.applovin.impl.ey
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ik.b((ik.b) obj, (ik.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f60495a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f60499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f60500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f60501g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b[] f60497c = new b[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f60496b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60498d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f60502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f60503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f60504c;

        private b() {
        }
    }

    public ik(int i3) {
        this.f60495a = i3;
    }

    private void b() {
        if (this.f60498d != 0) {
            Collections.sort(this.f60496b, f60494i);
            this.f60498d = 0;
        }
    }

    public void a(int i3, float f3) {
        b bVar;
        a();
        int i4 = this.f60501g;
        if (i4 > 0) {
            b[] bVarArr = this.f60497c;
            int i5 = i4 - 1;
            this.f60501g = i5;
            bVar = bVarArr[i5];
        } else {
            bVar = new b();
        }
        int i6 = this.f60499e;
        this.f60499e = i6 + 1;
        bVar.f60502a = i6;
        bVar.f60503b = i3;
        bVar.f60504c = f3;
        this.f60496b.add(bVar);
        this.f60500f += i3;
        while (true) {
            int i7 = this.f60500f;
            int i8 = this.f60495a;
            if (i7 <= i8) {
                return;
            }
            int i9 = i7 - i8;
            b bVar2 = (b) this.f60496b.get(0);
            int i10 = bVar2.f60503b;
            if (i10 <= i9) {
                this.f60500f -= i10;
                this.f60496b.remove(0);
                int i11 = this.f60501g;
                if (i11 < 5) {
                    b[] bVarArr2 = this.f60497c;
                    this.f60501g = i11 + 1;
                    bVarArr2[i11] = bVar2;
                }
            } else {
                bVar2.f60503b = i10 - i9;
                this.f60500f -= i9;
            }
        }
    }

    public void c() {
        this.f60496b.clear();
        this.f60498d = -1;
        this.f60499e = 0;
        this.f60500f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(b bVar, b bVar2) {
        return Float.compare(bVar.f60504c, bVar2.f60504c);
    }

    private void a() {
        if (this.f60498d != 1) {
            Collections.sort(this.f60496b, f60493h);
            this.f60498d = 1;
        }
    }

    public float a(float f3) {
        b();
        float f4 = f3 * this.f60500f;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f60496b.size(); i4++) {
            b bVar = (b) this.f60496b.get(i4);
            i3 += bVar.f60503b;
            if (i3 >= f4) {
                return bVar.f60504c;
            }
        }
        if (this.f60496b.isEmpty()) {
            return Float.NaN;
        }
        return ((b) this.f60496b.get(r5.size() - 1)).f60504c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(b bVar, b bVar2) {
        return bVar.f60502a - bVar2.f60502a;
    }
}
