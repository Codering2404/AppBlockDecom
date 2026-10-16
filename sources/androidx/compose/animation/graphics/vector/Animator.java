package androidx.compose.animation.graphics.vector;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public abstract class Animator {
    public /* synthetic */ Animator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x021b, code lost:
    
        throw new java.lang.IllegalStateException("Unknown propertyName: " + r16);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final androidx.compose.animation.core.Transition r21, final androidx.compose.animation.graphics.vector.StateVectorConfig r22, final int r23, androidx.compose.runtime.Composer r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.graphics.vector.Animator.a(androidx.compose.animation.core.Transition, androidx.compose.animation.graphics.vector.StateVectorConfig, int, androidx.compose.runtime.Composer, int):void");
    }

    public abstract void b(MutableScatterMap mutableScatterMap, int i3, int i4);

    public final StateVectorConfig c(Transition transition, int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(839519568, i4, -1, "androidx.compose.animation.graphics.vector.Animator.createVectorConfig (Animator.kt:57)");
        }
        composer.a0(-1031781866);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new StateVectorConfig();
            composer.w(objG);
        }
        StateVectorConfig stateVectorConfig = (StateVectorConfig) objG;
        int i5 = i4 & 14;
        int i6 = i4 << 3;
        a(transition, stateVectorConfig, i3, composer, i5 | (i6 & 896) | (i6 & 7168));
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateVectorConfig;
    }

    public abstract int d();

    private Animator() {
    }
}
