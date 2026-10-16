package androidx.compose.ui.focus;

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
public final class CancelIndicatingFocusBoundaryScope implements FocusEnterExitScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25434b;

    public /* synthetic */ CancelIndicatingFocusBoundaryScope(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    @Override // androidx.compose.ui.focus.FocusEnterExitScope
    public void a() {
        this.f25434b = true;
    }

    @Override // androidx.compose.ui.focus.FocusEnterExitScope
    public int b() {
        return this.f25433a;
    }

    public final boolean c() {
        return this.f25434b;
    }

    private CancelIndicatingFocusBoundaryScope(int i3) {
        this.f25433a = i3;
    }
}
