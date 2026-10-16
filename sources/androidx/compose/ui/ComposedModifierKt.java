package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class ComposedModifierKt {
    public static final Modifier b(Modifier modifier, Function1 function1, Function3 function3) {
        return modifier.then(new ComposedModifier(function1, function3));
    }

    public static /* synthetic */ Modifier c(Modifier modifier, Function1 function1, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = InspectableValueKt.a();
        }
        return b(modifier, function1, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier e(final Composer composer, Modifier modifier) {
        if (modifier.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Modifier.Element element) {
                return Boolean.valueOf(!(element instanceof ComposedModifier));
            }
        })) {
            return modifier;
        }
        composer.F(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.b8, new Function2<Modifier, Modifier.Element, Modifier>() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$result$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Modifier invoke(Modifier modifier3, Modifier.Element element) {
                boolean z2 = element instanceof ComposedModifier;
                Modifier modifierE = element;
                if (z2) {
                    Function3 function3C = ((ComposedModifier) element).c();
                    Intrinsics.checkNotNull(function3C, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    modifierE = ComposedModifierKt.e(composer, (Modifier) ((Function3) TypeIntrinsics.f(function3C, 3)).invoke(Modifier.b8, composer, 0));
                }
                return modifier3.then(modifierE);
            }
        });
        composer.Y();
        return modifier2;
    }

    public static final Modifier f(Composer composer, Modifier modifier) {
        composer.a0(439770924);
        Modifier modifierE = e(composer, modifier);
        composer.U();
        return modifierE;
    }

    public static final Modifier g(Composer composer, Modifier modifier) {
        return modifier == Modifier.b8 ? modifier : f(composer, new CompositionLocalMapInjectionElement(composer.u()).then(modifier));
    }
}
