package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ProjectionDecoder {
    public static Projection a(byte[] bArr, int i3) {
        ArrayList arrayListF;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            arrayListF = c(parsableByteArray) ? f(parsableByteArray) : e(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new Projection((Projection.Mesh) arrayListF.get(0), i3);
        }
        if (size != 2) {
            return null;
        }
        return new Projection((Projection.Mesh) arrayListF.get(0), (Projection.Mesh) arrayListF.get(1), i3);
    }

    private static int b(int i3) {
        return (-(i3 & 1)) ^ (i3 >> 1);
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        parsableByteArray.X(4);
        int iQ = parsableByteArray.q();
        parsableByteArray.W(0);
        return iQ == 1886547818;
    }

    private static Projection.Mesh d(ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        Projection.Mesh mesh = null;
        if (iQ > 10000) {
            return null;
        }
        float[] fArr = new float[iQ];
        for (int i3 = 0; i3 < iQ; i3++) {
            fArr[i3] = parsableByteArray.p();
        }
        int iQ2 = parsableByteArray.q();
        if (iQ2 > 32000) {
            return null;
        }
        double d3 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iQ) * 2.0d) / dLog);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        int i4 = 8;
        parsableBitArray.p(parsableByteArray.f() * 8);
        float[] fArr2 = new float[iQ2 * 5];
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < iQ2) {
            Projection.Mesh mesh2 = mesh;
            int i7 = 0;
            while (i7 < 5) {
                int iB = iArr[i7] + b(parsableBitArray.h(iCeil));
                if (iB >= iQ || iB < 0) {
                    return mesh2;
                }
                fArr2[i6] = fArr[iB];
                iArr[i7] = iB;
                i7++;
                i6++;
            }
            i5++;
            mesh = mesh2;
        }
        Projection.Mesh mesh3 = mesh;
        parsableBitArray.p((parsableBitArray.e() + 7) & (-8));
        int i8 = 32;
        int iH = parsableBitArray.h(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[iH];
        int i9 = 0;
        while (i9 < iH) {
            int iH2 = parsableBitArray.h(i4);
            int iH3 = parsableBitArray.h(i4);
            int iH4 = parsableBitArray.h(i8);
            if (iH4 > 128000) {
                return mesh3;
            }
            int i10 = iH;
            int iCeil2 = (int) Math.ceil(Math.log(((double) iQ2) * d3) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int i11 = 0;
            int i12 = 0;
            while (i11 < iH4) {
                int iB2 = i12 + b(parsableBitArray.h(iCeil2));
                if (iB2 < 0 || iB2 >= iQ2) {
                    return mesh3;
                }
                int i13 = i11 * 3;
                int i14 = iB2 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i11 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
                i11++;
                i12 = iB2;
            }
            subMeshArr[i9] = new Projection.SubMesh(iH2, fArr3, fArr4, iH3);
            i9++;
            iH = i10;
            i8 = 32;
            d3 = 2.0d;
            i4 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }

    private static ArrayList e(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.H() != 0) {
            return null;
        }
        parsableByteArray.X(7);
        int iQ = parsableByteArray.q();
        if (iQ == 1684433976) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.x0(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (iQ != 1918990112) {
            return null;
        }
        return g(parsableByteArray);
    }

    private static ArrayList f(ParsableByteArray parsableByteArray) {
        int iQ;
        parsableByteArray.X(8);
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        while (iF < iG && (iQ = parsableByteArray.q() + iF) > iF && iQ <= iG) {
            int iQ2 = parsableByteArray.q();
            if (iQ2 == 2037673328 || iQ2 == 1836279920) {
                parsableByteArray.V(iQ);
                return e(parsableByteArray);
            }
            parsableByteArray.W(iQ);
            iF = iQ;
        }
        return null;
    }

    private static ArrayList g(ParsableByteArray parsableByteArray) {
        ArrayList arrayList = new ArrayList();
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        while (iF < iG) {
            int iQ = parsableByteArray.q() + iF;
            if (iQ <= iF || iQ > iG) {
                return null;
            }
            if (parsableByteArray.q() == 1835365224) {
                Projection.Mesh meshD = d(parsableByteArray);
                if (meshD == null) {
                    return null;
                }
                arrayList.add(meshD);
            }
            parsableByteArray.W(iQ);
            iF = iQ;
        }
        return arrayList;
    }
}
