package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
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
abstract class InsetsConsumingModifier implements ModifierLocalConsumer, ModifierLocalProvider<WindowInsets> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f6959a;

    public /* synthetic */ InsetsConsumingModifier(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final WindowInsets b() {
        return (WindowInsets) this.f6959a.getValue();
    }

    private final void d(WindowInsets windowInsets) {
        this.f6959a.setValue(windowInsets);
    }

    public abstract WindowInsets a(WindowInsets windowInsets);

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public WindowInsets getValue() {
        return b();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal getKey() {
        return WindowInsetsPaddingKt.b();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void l1(ModifierLocalReadScope modifierLocalReadScope) {
        d(a((WindowInsets) modifierLocalReadScope.u(WindowInsetsPaddingKt.b())));
    }

    private InsetsConsumingModifier() {
        this.f6959a = SnapshotStateKt__SnapshotStateKt.e(WindowInsetsKt.a(0, 0, 0, 0), null, 2, null);
    }
}
