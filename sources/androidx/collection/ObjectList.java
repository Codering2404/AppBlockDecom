package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class ObjectList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f3081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3082b;

    public /* synthetic */ ObjectList(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public static /* synthetic */ String j(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
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
        if ((i4 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return objectList.i(charSequence, charSequence2, charSequence3, i3, charSequence5, function12);
    }

    public final boolean a(Object obj) {
        return f(obj) >= 0;
    }

    public final boolean b(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!a(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object c() {
        if (g()) {
            RuntimeHelpersKt.d("ObjectList is empty.");
        }
        return this.f3081a[0];
    }

    public final Object d(int i3) {
        if (i3 < 0 || i3 >= this.f3082b) {
            l(i3);
        }
        return this.f3081a[i3];
    }

    public final int e() {
        return this.f3082b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i3 = objectList.f3082b;
            int i4 = this.f3082b;
            if (i3 == i4) {
                Object[] objArr = this.f3081a;
                Object[] objArr2 = objectList.f3081a;
                IntRange intRangeB = RangesKt.B(0, i4);
                int iG = intRangeB.g();
                int iH = intRangeB.h();
                if (iG > iH) {
                    return true;
                }
                while (Intrinsics.areEqual(objArr[iG], objArr2[iG])) {
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

    public final int f(Object obj) {
        int i3 = 0;
        if (obj == null) {
            Object[] objArr = this.f3081a;
            int i4 = this.f3082b;
            while (i3 < i4) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        Object[] objArr2 = this.f3081a;
        int i5 = this.f3082b;
        while (i3 < i5) {
            if (obj.equals(objArr2[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final boolean g() {
        return this.f3082b == 0;
    }

    public final boolean h() {
        return this.f3082b != 0;
    }

    public int hashCode() {
        Object[] objArr = this.f3081a;
        int i3 = this.f3082b;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = objArr[i4];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final String i(CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.f3081a;
        int i4 = this.f3082b;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                sb.append(postfix);
                break;
            }
            Object obj = objArr[i5];
            if (i5 == i3) {
                sb.append(truncated);
                break;
            }
            if (i5 != 0) {
                sb.append(separator);
            }
            if (function1 == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) function1.invoke(obj));
            }
            i5++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int k(Object obj) {
        if (obj == null) {
            Object[] objArr = this.f3081a;
            for (int i3 = this.f3082b - 1; -1 < i3; i3--) {
                if (objArr[i3] == null) {
                    return i3;
                }
            }
        } else {
            Object[] objArr2 = this.f3081a;
            for (int i4 = this.f3082b - 1; -1 < i4; i4--) {
                if (obj.equals(objArr2[i4])) {
                    return i4;
                }
            }
        }
        return -1;
    }

    public final void l(int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i3);
        sb.append(" must be in 0..");
        sb.append(this.f3082b - 1);
        RuntimeHelpersKt.c(sb.toString());
    }

    public String toString() {
        return j(this, null, "[", "]", 0, null, new Function1<E, CharSequence>() { // from class: androidx.collection.ObjectList.toString.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Object obj) {
                return obj == ObjectList.this ? "(this)" : String.valueOf(obj);
            }
        }, 25, null);
    }

    private ObjectList(int i3) {
        this.f3081a = i3 == 0 ? ObjectListKt.f3084a : new Object[i3];
    }
}
