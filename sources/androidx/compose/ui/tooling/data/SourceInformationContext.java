package androidx.compose.ui.tooling.data;

import java.util.List;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class SourceInformationContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f29942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f29943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f29944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f29945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f29946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f29947i;

    public SourceInformationContext(String str, String str2, int i3, List list, int i4, List list2, boolean z2, boolean z3) {
        this.f29939a = str;
        this.f29940b = str2;
        this.f29941c = i3;
        this.f29942d = list;
        this.f29943e = i4;
        this.f29944f = list2;
        this.f29945g = z2;
        this.f29946h = z3;
    }

    public final String a() {
        return this.f29939a;
    }

    public final int b() {
        return this.f29941c;
    }

    public final List c() {
        return this.f29944f;
    }

    public final String d() {
        return this.f29940b;
    }

    public final boolean e() {
        return this.f29945g;
    }

    public final boolean f() {
        return this.f29946h;
    }

    public final SourceLocation g() {
        int i3;
        if (this.f29947i >= this.f29942d.size() && (i3 = this.f29943e) >= 0) {
            this.f29947i = i3;
        }
        if (this.f29947i >= this.f29942d.size()) {
            return null;
        }
        List list = this.f29942d;
        int i4 = this.f29947i;
        this.f29947i = i4 + 1;
        SourceLocationInfo sourceLocationInfo = (SourceLocationInfo) list.get(i4);
        Integer numB = sourceLocationInfo.b();
        int iIntValue = numB != null ? numB.intValue() : -1;
        Integer numC = sourceLocationInfo.c();
        int iIntValue2 = numC != null ? numC.intValue() : -1;
        Integer numA = sourceLocationInfo.a();
        return new SourceLocation(iIntValue, iIntValue2, numA != null ? numA.intValue() : -1, this.f29940b, this.f29941c);
    }
}
