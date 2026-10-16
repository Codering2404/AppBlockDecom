package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

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
public final class ConstraintLayoutKt$ConstraintLayout$contentDelegate$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f30466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref f30467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConstraintLayoutScope f30468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f30469d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Channel f30470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f30471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f30472h;

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    public final void invoke(Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-74958949, i3, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
        }
        this.f30466a.setValue(Unit.f139807a);
        if (this.f30467b.a() == CompositionSource.Unknown) {
            this.f30467b.b(CompositionSource.Content);
        }
        this.f30468c.j();
        this.f30469d.invoke(this.f30468c, composer, 0);
        boolean zI = composer.I(this.f30468c) | composer.I(this.f30470f);
        final ConstraintLayoutScope constraintLayoutScope = this.f30468c;
        final MutableState mutableState = this.f30471g;
        final MutableState mutableState2 = this.f30472h;
        final Channel channel = this.f30470f;
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$contentDelegate$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m285invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m285invoke() {
                    RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope.h().a());
                    if (mutableState.getValue() != null && mutableState2.getValue() != null) {
                        channel.h(rawConstraintSet);
                    } else {
                        mutableState.setValue(rawConstraintSet);
                        mutableState2.setValue(mutableState.getValue());
                    }
                }
            };
            composer.w(objG);
        }
        EffectsKt.j((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
