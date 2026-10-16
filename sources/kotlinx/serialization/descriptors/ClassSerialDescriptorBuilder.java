package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ClassSerialDescriptorBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f142712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f142713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f142714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f142715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f142716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f142717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f142718g;

    public ClassSerialDescriptorBuilder(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f142712a = serialName;
        this.f142713b = CollectionsKt.emptyList();
        this.f142714c = new ArrayList();
        this.f142715d = new HashSet();
        this.f142716e = new ArrayList();
        this.f142717f = new ArrayList();
        this.f142718g = new ArrayList();
    }

    public static /* synthetic */ void b(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        classSerialDescriptorBuilder.a(str, serialDescriptor, list, z2);
    }

    public final void a(String elementName, SerialDescriptor descriptor, List annotations, boolean z2) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.f142715d.add(elementName)) {
            this.f142714c.add(elementName);
            this.f142716e.add(descriptor);
            this.f142717f.add(annotations);
            this.f142718g.add(Boolean.valueOf(z2));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.f142712a).toString());
    }

    public final List c() {
        return this.f142713b;
    }

    public final List d() {
        return this.f142717f;
    }

    public final List e() {
        return this.f142716e;
    }

    public final List f() {
        return this.f142714c;
    }

    public final List g() {
        return this.f142718g;
    }

    public final void h(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f142713b = list;
    }
}
