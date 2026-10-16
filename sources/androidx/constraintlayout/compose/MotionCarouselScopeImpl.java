package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

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
final class MotionCarouselScopeImpl implements MotionCarouselScope, MotionItemsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function3 f30711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function4 f30712c;

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public boolean a() {
        return this.f30712c != null;
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public Function2 b(final int i3, final androidx.compose.runtime.State state) {
        return ComposableLambdaKt.c(1612828220, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselScopeImpl$getContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i4) {
                if ((i4 & 3) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(1612828220, i4, -1, "androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.<anonymous> (MotionCarousel.kt:361)");
                }
                Function4 function4E = this.f30715a.e();
                if (function4E != null) {
                    function4E.invoke(Integer.valueOf(i3), state, composer, 0);
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        });
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public Function2 c(final int i3) {
        return ComposableLambdaKt.c(752436001, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselScopeImpl$getContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i4) {
                if ((i4 & 3) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(752436001, i4, -1, "androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.<anonymous> (MotionCarousel.kt:354)");
                }
                Function3 function3D = this.f30713a.d();
                if (function3D != null) {
                    function3D.invoke(Integer.valueOf(i3), composer, 0);
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        });
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public int count() {
        return this.f30710a;
    }

    public final Function3 d() {
        return this.f30711b;
    }

    public final Function4 e() {
        return this.f30712c;
    }
}
