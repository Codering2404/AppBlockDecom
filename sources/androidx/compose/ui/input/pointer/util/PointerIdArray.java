package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerId;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class PointerIdArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f26980b = new long[2];

    private final long[] i(int i3) {
        long[] jArr = this.f26980b;
        long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i3, jArr.length * 2));
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        this.f26980b = jArrCopyOf;
        return jArrCopyOf;
    }

    public final boolean a(long j3) {
        if (c(j3)) {
            return false;
        }
        j(this.f26979a, j3);
        return true;
    }

    public final void b() {
        this.f26979a = 0;
    }

    public final boolean c(long j3) {
        int i3 = this.f26979a;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f26980b[i4] == j3) {
                return true;
            }
        }
        return false;
    }

    public final long d(int i3) {
        return PointerId.a(this.f26980b[i3]);
    }

    public final int e() {
        return this.f26979a;
    }

    public final boolean f() {
        return this.f26979a == 0;
    }

    public final boolean g(long j3) {
        int i3 = this.f26979a;
        int i4 = 0;
        while (i4 < i3) {
            if (j3 == this.f26980b[i4]) {
                int i5 = this.f26979a - 1;
                while (i4 < i5) {
                    long[] jArr = this.f26980b;
                    int i6 = i4 + 1;
                    jArr[i4] = jArr[i6];
                    i4 = i6;
                }
                this.f26979a--;
                return true;
            }
            i4++;
        }
        return false;
    }

    public final boolean h(int i3) {
        int i4 = this.f26979a;
        if (i3 >= i4) {
            return false;
        }
        int i5 = i4 - 1;
        while (i3 < i5) {
            long[] jArr = this.f26980b;
            int i6 = i3 + 1;
            jArr[i3] = jArr[i6];
            i3 = i6;
        }
        this.f26979a--;
        return true;
    }

    public final void j(int i3, long j3) {
        long[] jArrI = this.f26980b;
        if (i3 >= jArrI.length) {
            jArrI = i(i3 + 1);
        }
        jArrI[i3] = j3;
        if (i3 >= this.f26979a) {
            this.f26979a = i3 + 1;
        }
    }
}
