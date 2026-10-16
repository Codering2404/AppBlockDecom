package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRect f29779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SourceLocation f29780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f29781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f29782f;

    public ViewInfo(String str, int i3, IntRect intRect, SourceLocation sourceLocation, List list, Object obj) {
        this.f29777a = str;
        this.f29778b = i3;
        this.f29779c = intRect;
        this.f29780d = sourceLocation;
        this.f29781e = list;
        this.f29782f = obj;
    }

    public final List a() {
        List list = this.f29781e;
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ViewInfo) it.next()).a());
        }
        return CollectionsKt.plus((Collection) list2, (Iterable) arrayList);
    }

    public final IntRect b() {
        return this.f29779c;
    }

    public final List c() {
        return this.f29781e;
    }

    public final String d() {
        return this.f29777a;
    }

    public final Object e() {
        return this.f29782f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        return Intrinsics.areEqual(this.f29777a, viewInfo.f29777a) && this.f29778b == viewInfo.f29778b && Intrinsics.areEqual(this.f29779c, viewInfo.f29779c) && Intrinsics.areEqual(this.f29780d, viewInfo.f29780d) && Intrinsics.areEqual(this.f29781e, viewInfo.f29781e) && Intrinsics.areEqual(this.f29782f, viewInfo.f29782f);
    }

    public final int f() {
        return this.f29778b;
    }

    public final SourceLocation g() {
        return this.f29780d;
    }

    public final boolean h() {
        return (this.f29779c.d() == 0 || this.f29779c.h() == 0) ? false : true;
    }

    public int hashCode() {
        int iHashCode = ((((this.f29777a.hashCode() * 31) + Integer.hashCode(this.f29778b)) * 31) + this.f29779c.hashCode()) * 31;
        SourceLocation sourceLocation = this.f29780d;
        int iHashCode2 = (((iHashCode + (sourceLocation == null ? 0 : sourceLocation.hashCode())) * 31) + this.f29781e.hashCode()) * 31;
        Object obj = this.f29782f;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            java.lang.String r2 = r4.f29777a
            r0.append(r2)
            r2 = 58
            r0.append(r2)
            int r2 = r4.f29778b
            r0.append(r2)
            java.lang.String r2 = ",\n            |bounds=(top="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.f29779c
            int r2 = r2.j()
            r0.append(r2)
            java.lang.String r2 = ", left="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.f29779c
            int r2 = r2.g()
            r0.append(r2)
            java.lang.String r2 = ",\n            |location="
            r0.append(r2)
            androidx.compose.ui.tooling.data.SourceLocation r2 = r4.f29780d
            if (r2 == 0) goto L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            int r1 = r2.c()
            r3.append(r1)
            r1 = 76
            r3.append(r1)
            int r1 = r2.a()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 != 0) goto L61
        L5f:
            java.lang.String r1 = "<none>"
        L61:
            r0.append(r1)
            java.lang.String r1 = "\n            |bottom="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.f29779c
            int r1 = r1.d()
            r0.append(r1)
            java.lang.String r1 = ", right="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.f29779c
            int r1 = r1.h()
            r0.append(r1)
            java.lang.String r1 = "),\n            |childrenCount="
            r0.append(r1)
            java.util.List r1 = r4.f29781e
            int r1 = r1.size()
            r0.append(r1)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            r2 = 0
            java.lang.String r0 = kotlin.text.StringsKt.p(r0, r2, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ViewInfo.toString():java.lang.String");
    }
}
