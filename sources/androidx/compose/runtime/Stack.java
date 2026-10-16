package androidx.compose.runtime;

import java.util.ArrayList;
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
public final class Stack<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f24304a;

    public static final void a(ArrayList arrayList) {
        arrayList.clear();
    }

    public static /* synthetic */ ArrayList c(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            arrayList = new ArrayList();
        }
        return b(arrayList);
    }

    public static boolean d(ArrayList arrayList, Object obj) {
        return (obj instanceof Stack) && Intrinsics.areEqual(arrayList, ((Stack) obj).o());
    }

    public static final int e(ArrayList arrayList) {
        return arrayList.size();
    }

    public static int f(ArrayList arrayList) {
        return arrayList.hashCode();
    }

    public static final boolean g(ArrayList arrayList) {
        return arrayList.isEmpty();
    }

    public static final boolean h(ArrayList arrayList) {
        return !g(arrayList);
    }

    public static final Object i(ArrayList arrayList) {
        return arrayList.get(e(arrayList) - 1);
    }

    public static final Object j(ArrayList arrayList, int i3) {
        return arrayList.get(i3);
    }

    public static final Object k(ArrayList arrayList) {
        return arrayList.remove(e(arrayList) - 1);
    }

    public static final boolean l(ArrayList arrayList, Object obj) {
        return arrayList.add(obj);
    }

    public static final Object[] m(ArrayList arrayList) {
        int size = arrayList.size();
        Object[] objArr = new Object[size];
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = arrayList.get(i3);
        }
        return objArr;
    }

    public static String n(ArrayList arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f24304a, obj);
    }

    public int hashCode() {
        return f(this.f24304a);
    }

    public final /* synthetic */ ArrayList o() {
        return this.f24304a;
    }

    public String toString() {
        return n(this.f24304a);
    }

    public static ArrayList b(ArrayList arrayList) {
        return arrayList;
    }
}
