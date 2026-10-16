package androidx.compose.ui.semantics;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.node.LayoutNode;
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
public final class SemanticsOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f28513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EmptySemanticsModifier f28514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IntObjectMap f28515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableObjectList f28516d = new MutableObjectList(2);

    public SemanticsOwner(LayoutNode layoutNode, EmptySemanticsModifier emptySemanticsModifier, IntObjectMap intObjectMap) {
        this.f28513a = layoutNode;
        this.f28514b = emptySemanticsModifier;
        this.f28515c = intObjectMap;
    }

    public final SemanticsInfo a(int i3) {
        return (SemanticsInfo) this.f28515c.b(i3);
    }

    public final MutableObjectList b() {
        return this.f28516d;
    }

    public final SemanticsInfo c() {
        return this.f28513a;
    }

    public final SemanticsNode d() {
        return new SemanticsNode(this.f28514b, false, this.f28513a, new SemanticsConfiguration());
    }

    public final void e(SemanticsInfo semanticsInfo, SemanticsConfiguration semanticsConfiguration) {
        MutableObjectList mutableObjectList = this.f28516d;
        Object[] objArr = mutableObjectList.f3081a;
        int i3 = mutableObjectList.f3082b;
        for (int i4 = 0; i4 < i3; i4++) {
            ((SemanticsListener) objArr[i4]).b(semanticsInfo, semanticsConfiguration);
        }
    }
}
