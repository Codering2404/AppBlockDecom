package androidx.glance.appwidget;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class InsertedViewInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f38089c;

    public InsertedViewInfo(int i3, int i4, Map map) {
        this.f38087a = i3;
        this.f38088b = i4;
        this.f38089c = map;
    }

    public static /* synthetic */ InsertedViewInfo b(InsertedViewInfo insertedViewInfo, int i3, int i4, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = insertedViewInfo.f38087a;
        }
        if ((i5 & 2) != 0) {
            i4 = insertedViewInfo.f38088b;
        }
        if ((i5 & 4) != 0) {
            map = insertedViewInfo.f38089c;
        }
        return insertedViewInfo.a(i3, i4, map);
    }

    public final InsertedViewInfo a(int i3, int i4, Map map) {
        return new InsertedViewInfo(i3, i4, map);
    }

    public final Map c() {
        return this.f38089c;
    }

    public final int d() {
        return this.f38088b;
    }

    public final int e() {
        return this.f38087a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertedViewInfo)) {
            return false;
        }
        InsertedViewInfo insertedViewInfo = (InsertedViewInfo) obj;
        return this.f38087a == insertedViewInfo.f38087a && this.f38088b == insertedViewInfo.f38088b && Intrinsics.areEqual(this.f38089c, insertedViewInfo.f38089c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f38087a) * 31) + Integer.hashCode(this.f38088b)) * 31) + this.f38089c.hashCode();
    }

    public String toString() {
        return "InsertedViewInfo(mainViewId=" + this.f38087a + ", complexViewId=" + this.f38088b + ", children=" + this.f38089c + ')';
    }

    public /* synthetic */ InsertedViewInfo(int i3, int i4, Map map, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? -1 : i3, (i5 & 2) != 0 ? -1 : i4, (i5 & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
