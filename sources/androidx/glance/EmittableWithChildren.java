package androidx.glance;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

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
public abstract class EmittableWithChildren implements Emittable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f37604c;

    public EmittableWithChildren(int i3, boolean z2) {
        this.f37602a = i3;
        this.f37603b = z2;
        this.f37604c = new ArrayList();
    }

    protected final String c() {
        return StringsKt.i(CollectionsKt.joinToString$default(this.f37604c, ",\n", null, null, 0, null, null, 62, null), "  ");
    }

    public final List d() {
        return this.f37604c;
    }

    public final int e() {
        return this.f37602a;
    }

    public final boolean f() {
        return this.f37603b;
    }

    public final void g(int i3) {
        this.f37602a = i3;
    }

    public /* synthetic */ EmittableWithChildren(int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3, (i4 & 2) != 0 ? false : z2);
    }
}
