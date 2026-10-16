package cz.mobilesoft.coreblock.util.paywalltrace;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TraceGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f128989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f128990b;

    public TraceGroup(int i3, List entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f128989a = i3;
        this.f128990b = entries;
    }

    public final Boolean a() {
        Iterator it = this.f128990b.iterator();
        while (it.hasNext()) {
            Boolean boolG = ((CollapsedTrace) it.next()).d().g();
            if (boolG != null) {
                return boolG;
            }
        }
        return null;
    }

    public final String b() {
        Iterator it = this.f128990b.iterator();
        while (it.hasNext()) {
            String strD = ((CollapsedTrace) it.next()).d().d();
            if (strD != null) {
                return strD;
            }
        }
        return null;
    }

    public final List c() {
        return this.f128990b;
    }

    public final String d() {
        Iterator it = this.f128990b.iterator();
        while (it.hasNext()) {
            String strF = ((CollapsedTrace) it.next()).d().f();
            if (strF != null) {
                return strF;
            }
        }
        return null;
    }

    public final int e() {
        return this.f128989a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceGroup)) {
            return false;
        }
        TraceGroup traceGroup = (TraceGroup) obj;
        return this.f128989a == traceGroup.f128989a && Intrinsics.areEqual(this.f128990b, traceGroup.f128990b);
    }

    public final long f() {
        return ((CollapsedTrace) CollectionsKt.first(this.f128990b)).d().l();
    }

    public final boolean g() {
        return this.f128989a == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f128989a) * 31) + this.f128990b.hashCode();
    }

    public String toString() {
        return "TraceGroup(presentationId=" + this.f128989a + ", entries=" + this.f128990b + ")";
    }
}
