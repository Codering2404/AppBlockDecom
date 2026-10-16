package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ContextualFlowRowScopeImpl implements RowScope, ContextualFlowRowScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f6734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ RowScopeInstance f6735e;

    public /* synthetic */ ContextualFlowRowScopeImpl(int i3, int i4, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, f3, f4);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier a(Modifier modifier, float f3, boolean z2) {
        return this.f6735e.a(modifier, f3, z2);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier b(Modifier modifier) {
        return this.f6735e.b(modifier);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier d(Modifier modifier, Alignment.Vertical vertical) {
        return this.f6735e.d(modifier, vertical);
    }

    private ContextualFlowRowScopeImpl(int i3, int i4, float f3, float f4) {
        this.f6731a = i3;
        this.f6732b = i4;
        this.f6733c = f3;
        this.f6734d = f4;
        this.f6735e = RowScopeInstance.f7101a;
    }
}
