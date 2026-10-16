package androidx.compose.runtime.internal;

import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ThreadMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f24832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f24833c;

    public ThreadMap(int i3, long[] jArr, Object[] objArr) {
        this.f24831a = i3;
        this.f24832b = jArr;
        this.f24833c = objArr;
    }

    private final int a(long j3) {
        int i3 = this.f24831a - 1;
        if (i3 != -1) {
            int i4 = 0;
            if (i3 != 0) {
                while (i4 <= i3) {
                    int i5 = (i4 + i3) >>> 1;
                    long j4 = this.f24832b[i5] - j3;
                    if (j4 < 0) {
                        i4 = i5 + 1;
                    } else {
                        if (j4 <= 0) {
                            return i5;
                        }
                        i3 = i5 - 1;
                    }
                }
                return -(i4 + 1);
            }
            long j5 = this.f24832b[0];
            if (j5 == j3) {
                return 0;
            }
            if (j5 > j3) {
                return -2;
            }
        }
        return -1;
    }

    public final Object b(long j3) {
        int iA = a(j3);
        if (iA >= 0) {
            return this.f24833c[iA];
        }
        return null;
    }

    public final ThreadMap c(long j3, Object obj) {
        int i3 = this.f24831a;
        int i4 = 0;
        int i5 = 0;
        for (Object obj2 : this.f24833c) {
            if (obj2 != null) {
                i5++;
            }
        }
        int i6 = i5 + 1;
        long[] jArr = new long[i6];
        Object[] objArr = new Object[i6];
        if (i6 > 1) {
            int i7 = 0;
            while (true) {
                if (i4 >= i6 || i7 >= i3) {
                    break;
                }
                long j4 = this.f24832b[i7];
                Object obj3 = this.f24833c[i7];
                if (j4 > j3) {
                    jArr[i4] = j3;
                    objArr[i4] = obj;
                    i4++;
                    break;
                }
                if (obj3 != null) {
                    jArr[i4] = j4;
                    objArr[i4] = obj3;
                    i4++;
                }
                i7++;
            }
            if (i7 == i3) {
                jArr[i5] = j3;
                objArr[i5] = obj;
            } else {
                while (i4 < i6) {
                    long j5 = this.f24832b[i7];
                    Object obj4 = this.f24833c[i7];
                    if (obj4 != null) {
                        jArr[i4] = j5;
                        objArr[i4] = obj4;
                        i4++;
                    }
                    i7++;
                }
            }
        } else {
            jArr[0] = j3;
            objArr[0] = obj;
        }
        return new ThreadMap(i6, jArr, objArr);
    }

    public final boolean d(long j3, Object obj) {
        int iA = a(j3);
        if (iA < 0) {
            return false;
        }
        this.f24833c[iA] = obj;
        return true;
    }
}
