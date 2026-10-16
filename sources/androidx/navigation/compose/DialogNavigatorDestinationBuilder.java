package androidx.navigation.compose;

import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.compose.DialogNavigator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

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
@NavDestinationDsl
@Metadata
public final class DialogNavigatorDestinationBuilder extends NavDestinationBuilder<DialogNavigator.Destination> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DialogNavigator f49087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DialogProperties f49088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function3 f49089k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.NavDestinationBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public DialogNavigator.Destination e() {
        return new DialogNavigator.Destination(this.f49087i, this.f49088j, this.f49089k);
    }
}
