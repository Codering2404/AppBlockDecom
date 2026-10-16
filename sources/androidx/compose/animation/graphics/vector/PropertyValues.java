package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
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
public abstract class PropertyValues<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4427a;

    public /* synthetic */ PropertyValues(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    protected final Function3 a(final int i3) {
        return new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<T>>() { // from class: androidx.compose.animation.graphics.vector.PropertyValues$createAnimationSpec$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer, int i4) {
                composer.a0(-361329948);
                if (ComposerKt.M()) {
                    ComposerKt.U(-361329948, i4, -1, "androidx.compose.animation.graphics.vector.PropertyValues.createAnimationSpec.<anonymous> (Animator.kt:154)");
                }
                List listC = this.f4428a.c();
                ArrayList arrayList = new ArrayList(listC.size());
                int size = listC.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Timestamp timestamp = (Timestamp) listC.get(i5);
                    arrayList.add(TuplesKt.a(Integer.valueOf(timestamp.f()), timestamp.a()));
                }
                FiniteAnimationSpec finiteAnimationSpecB = AnimatorAnimationSpecsKt.b(arrayList);
                if (!((Boolean) segment.a()).booleanValue()) {
                    finiteAnimationSpecB = AnimatorAnimationSpecsKt.d(finiteAnimationSpecB, i3);
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return finiteAnimationSpecB;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        };
    }

    public abstract State b(Transition transition, String str, int i3, Composer composer, int i4);

    public final List c() {
        return this.f4427a;
    }

    private PropertyValues() {
        this.f4427a = new ArrayList();
    }
}
