package com.applovin.impl;

import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ji {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f60758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f60759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f60760c;

        public a(UUID uuid, int i3, byte[] bArr) {
            this.f60758a = uuid;
            this.f60759b = i3;
            this.f60760c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return a(uuid, null, bArr);
    }

    private static a b(byte[] bArr) {
        ah ahVar = new ah(bArr);
        if (ahVar.e() < 32) {
            return null;
        }
        ahVar.f(0);
        if (ahVar.j() != ahVar.a() + 4 || ahVar.j() != 1886614376) {
            return null;
        }
        int iC = j1.c(ahVar.j());
        if (iC > 1) {
            oc.d("PsshAtomUtil", "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(ahVar.s(), ahVar.s());
        if (iC == 1) {
            ahVar.g(ahVar.A() * 16);
        }
        int iA = ahVar.A();
        if (iA != ahVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iA];
        ahVar.a(bArr2, 0, iA);
        return new a(uuid, iC, bArr2);
    }

    public static UUID c(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        return aVarB.f60758a;
    }

    public static int d(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return -1;
        }
        return aVarB.f60759b;
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean a(byte[] bArr) {
        return b(bArr) != null;
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        if (uuid.equals(aVarB.f60758a)) {
            return aVarB.f60760c;
        }
        oc.d("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarB.f60758a + ".");
        return null;
    }
}
