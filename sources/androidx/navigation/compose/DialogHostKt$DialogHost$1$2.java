package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class DialogHostKt$DialogHost$1$2 implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NavBackStackEntry f49067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DialogNavigator f49068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SaveableStateHolder f49069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SnapshotStateList f49070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DialogNavigator.Destination f49071f;

    DialogHostKt$DialogHost$1$2(NavBackStackEntry navBackStackEntry, DialogNavigator dialogNavigator, SaveableStateHolder saveableStateHolder, SnapshotStateList snapshotStateList, DialogNavigator.Destination destination) {
        this.f49067a = navBackStackEntry;
        this.f49068b = dialogNavigator;
        this.f49069c = saveableStateHolder;
        this.f49070d = snapshotStateList;
        this.f49071f = destination;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult e(final SnapshotStateList snapshotStateList, final NavBackStackEntry navBackStackEntry, final DialogNavigator dialogNavigator, DisposableEffectScope disposableEffectScope) {
        snapshotStateList.add(navBackStackEntry);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2$invoke$lambda$2$lambda$1$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                dialogNavigator.t(navBackStackEntry);
                snapshotStateList.remove(navBackStackEntry);
            }
        };
    }

    public final void d(Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1129586364, i3, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous> (DialogHost.kt:55)");
        }
        NavBackStackEntry navBackStackEntry = this.f49067a;
        boolean zI = composer.I(navBackStackEntry) | composer.I(this.f49068b);
        final SnapshotStateList snapshotStateList = this.f49070d;
        final NavBackStackEntry navBackStackEntry2 = this.f49067a;
        final DialogNavigator dialogNavigator = this.f49068b;
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: androidx.navigation.compose.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DialogHostKt$DialogHost$1$2.e(snapshotStateList, navBackStackEntry2, dialogNavigator, (DisposableEffectScope) obj);
                }
            };
            composer.w(objG);
        }
        EffectsKt.c(navBackStackEntry, (Function1) objG, composer, 0);
        final NavBackStackEntry navBackStackEntry3 = this.f49067a;
        SaveableStateHolder saveableStateHolder = this.f49069c;
        final DialogNavigator.Destination destination = this.f49071f;
        NavBackStackEntryProviderKt.d(navBackStackEntry3, saveableStateHolder, ComposableLambdaKt.e(-497631156, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2.2
            public final void c(Composer composer2, int i4) {
                if ((i4 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-497631156, i4, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous>.<anonymous> (DialogHost.kt:66)");
                }
                destination.H().invoke(navBackStackEntry3, composer2, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }
        }, composer, 54), composer, 384);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        d((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }
}
