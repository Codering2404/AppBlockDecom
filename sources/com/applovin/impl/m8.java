package com.applovin.impl;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m8 {
    public static void a(boolean z2, String str) throws ch {
        if (!z2) {
            throw ch.a(str, null);
        }
    }

    public static boolean b(k8 k8Var, byte[] bArr, int i3, int i4) {
        try {
            k8Var.d(bArr, i3, i4);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean a(k8 k8Var, byte[] bArr, int i3, int i4, boolean z2) throws EOFException {
        try {
            return k8Var.b(bArr, i3, i4, z2);
        } catch (EOFException e3) {
            if (z2) {
                return false;
            }
            throw e3;
        }
    }

    public static int a(k8 k8Var, byte[] bArr, int i3, int i4) {
        int i5 = 0;
        while (i5 < i4) {
            int iB = k8Var.b(bArr, i3 + i5, i4 - i5);
            if (iB == -1) {
                break;
            }
            i5 += iB;
        }
        return i5;
    }

    public static boolean a(k8 k8Var, int i3) {
        try {
            k8Var.a(i3);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
