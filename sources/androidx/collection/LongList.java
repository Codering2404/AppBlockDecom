package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class LongList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2921b;

    public /* synthetic */ LongList(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public static /* synthetic */ String c(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i4 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i4 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return longList.b(charSequence, charSequence2, charSequence6, i3, charSequence5);
    }

    public final String b(CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        long[] jArr = this.f2920a;
        int i4 = this.f2921b;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                sb.append(postfix);
                break;
            }
            long j3 = jArr[i5];
            if (i5 == i3) {
                sb.append(truncated);
                break;
            }
            if (i5 != 0) {
                sb.append(separator);
            }
            sb.append(j3);
            i5++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongList) {
            LongList longList = (LongList) obj;
            int i3 = longList.f2921b;
            int i4 = this.f2921b;
            if (i3 == i4) {
                long[] jArr = this.f2920a;
                long[] jArr2 = longList.f2920a;
                IntRange intRangeB = RangesKt.B(0, i4);
                int iG = intRangeB.g();
                int iH = intRangeB.h();
                if (iG > iH) {
                    return true;
                }
                while (jArr[iG] == jArr2[iG]) {
                    if (iG == iH) {
                        return true;
                    }
                    iG++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        long[] jArr = this.f2920a;
        int i3 = this.f2921b;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode += Long.hashCode(jArr[i4]) * 31;
        }
        return iHashCode;
    }

    public String toString() {
        return c(this, null, "[", "]", 0, null, 25, null);
    }

    private LongList(int i3) {
        this.f2920a = i3 == 0 ? LongSetKt.a() : new long[i3];
    }

    public final long a(int i3) {
        if (i3 < 0 || i3 >= this.f2921b) {
            RuntimeHelpersKt.c(QaXmqxvjHhxVy.aLwae);
        }
        return this.f2920a[i3];
    }
}
