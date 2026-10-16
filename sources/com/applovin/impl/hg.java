package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig f60195a = new ig();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f60196b = new ah(new byte[65025], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f60197c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60199e;

    hg() {
    }

    private int a(int i3) {
        int i4;
        int i5 = 0;
        this.f60198d = 0;
        do {
            int i6 = this.f60198d;
            int i7 = i3 + i6;
            ig igVar = this.f60195a;
            if (i7 >= igVar.f60452g) {
                break;
            }
            int[] iArr = igVar.f60455j;
            this.f60198d = i6 + 1;
            i4 = iArr[i7];
            i5 += i4;
        } while (i4 == 255);
        return i5;
    }

    public ah b() {
        return this.f60196b;
    }

    public void c() {
        this.f60195a.a();
        this.f60196b.d(0);
        this.f60197c = -1;
        this.f60199e = false;
    }

    public void d() {
        if (this.f60196b.c().length == 65025) {
            return;
        }
        ah ahVar = this.f60196b;
        ahVar.a(Arrays.copyOf(ahVar.c(), Math.max(65025, this.f60196b.e())), this.f60196b.e());
    }

    public ig a() {
        return this.f60195a;
    }

    public boolean a(k8 k8Var) {
        int i3;
        b1.b(k8Var != null);
        if (this.f60199e) {
            this.f60199e = false;
            this.f60196b.d(0);
        }
        while (!this.f60199e) {
            if (this.f60197c < 0) {
                if (!this.f60195a.a(k8Var) || !this.f60195a.a(k8Var, true)) {
                    return false;
                }
                ig igVar = this.f60195a;
                int iA = igVar.f60453h;
                if ((igVar.f60447b & 1) == 1 && this.f60196b.e() == 0) {
                    iA += a(0);
                    i3 = this.f60198d;
                } else {
                    i3 = 0;
                }
                if (!m8.a(k8Var, iA)) {
                    return false;
                }
                this.f60197c = i3;
            }
            int iA2 = a(this.f60197c);
            int i4 = this.f60197c + this.f60198d;
            if (iA2 > 0) {
                ah ahVar = this.f60196b;
                ahVar.a(ahVar.e() + iA2);
                if (!m8.b(k8Var, this.f60196b.c(), this.f60196b.e(), iA2)) {
                    return false;
                }
                ah ahVar2 = this.f60196b;
                ahVar2.e(ahVar2.e() + iA2);
                this.f60199e = this.f60195a.f60455j[i4 + (-1)] != 255;
            }
            if (i4 == this.f60195a.f60452g) {
                i4 = -1;
            }
            this.f60197c = i4;
        }
        return true;
    }
}
