package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@JvmInline
public final class PrioritySet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntList f24004a;

    public static final void a(MutableIntList mutableIntList, int i3) {
        if (mutableIntList.f2877b == 0 || !(mutableIntList.e(0) == i3 || mutableIntList.e(mutableIntList.f2877b - 1) == i3)) {
            int i4 = mutableIntList.f2877b;
            mutableIntList.l(i3);
            while (i4 > 0) {
                int i5 = ((i4 + 1) >>> 1) - 1;
                int iE = mutableIntList.e(i5);
                if (i3 <= iE) {
                    break;
                }
                mutableIntList.q(i4, iE);
                i4 = i5;
            }
            mutableIntList.q(i4, i3);
        }
    }

    public static /* synthetic */ MutableIntList c(MutableIntList mutableIntList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        int i4 = 1;
        if ((i3 & 1) != 0) {
            mutableIntList = new MutableIntList(0, i4, null);
        }
        return b(mutableIntList);
    }

    public static boolean d(MutableIntList mutableIntList, Object obj) {
        return (obj instanceof PrioritySet) && Intrinsics.areEqual(mutableIntList, ((PrioritySet) obj).j());
    }

    public static int e(MutableIntList mutableIntList) {
        return mutableIntList.hashCode();
    }

    public static final boolean f(MutableIntList mutableIntList) {
        return mutableIntList.f2877b != 0;
    }

    public static final int g(MutableIntList mutableIntList) {
        return mutableIntList.d();
    }

    public static final int h(MutableIntList mutableIntList) {
        int iE;
        int i3 = mutableIntList.f2877b;
        int iE2 = mutableIntList.e(0);
        while (mutableIntList.f2877b != 0 && mutableIntList.e(0) == iE2) {
            mutableIntList.q(0, mutableIntList.j());
            mutableIntList.p(mutableIntList.f2877b - 1);
            int i4 = mutableIntList.f2877b;
            int i5 = i4 >>> 1;
            int i6 = 0;
            while (i6 < i5) {
                int iE3 = mutableIntList.e(i6);
                int i7 = (i6 + 1) * 2;
                int i8 = i7 - 1;
                int iE4 = mutableIntList.e(i8);
                if (i7 >= i4 || (iE = mutableIntList.e(i7)) <= iE4) {
                    if (iE4 > iE3) {
                        mutableIntList.q(i6, iE4);
                        mutableIntList.q(i8, iE3);
                        i6 = i8;
                    }
                } else if (iE > iE3) {
                    mutableIntList.q(i6, iE);
                    mutableIntList.q(i7, iE3);
                    i6 = i7;
                }
            }
        }
        return iE2;
    }

    public static String i(MutableIntList mutableIntList) {
        return "PrioritySet(list=" + mutableIntList + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f24004a, obj);
    }

    public int hashCode() {
        return e(this.f24004a);
    }

    public final /* synthetic */ MutableIntList j() {
        return this.f24004a;
    }

    public String toString() {
        return i(this.f24004a);
    }

    public static MutableIntList b(MutableIntList mutableIntList) {
        return mutableIntList;
    }
}
