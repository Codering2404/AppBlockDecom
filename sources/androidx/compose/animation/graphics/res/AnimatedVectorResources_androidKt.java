package androidx.compose.animation.graphics.res;

import android.content.Context;
import android.content.res.Resources;
import android.util.Xml;
import androidx.compose.animation.graphics.vector.AnimatedImageVector;
import androidx.compose.animation.graphics.vector.compat.XmlAnimatedVectorParser_androidKt;
import androidx.compose.animation.graphics.vector.compat.XmlPullParserUtils_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.io.IOException;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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
public final class AnimatedVectorResources_androidKt {
    public static final AnimatedImageVector a(AnimatedImageVector.Companion companion, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        if (ComposerKt.M()) {
            ComposerKt.U(-976666674, i4, -1, "androidx.compose.animation.graphics.res.animatedVectorResource (AnimatedVectorResources.android.kt:39)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        boolean z2 = (((i4 & 112) ^ 48) > 32 && composer.e(i3)) || (i4 & 48) == 32;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = b(theme, resources, i3);
            composer.w(objG);
        }
        AnimatedImageVector animatedImageVector = (AnimatedImageVector) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return animatedImageVector;
    }

    public static final AnimatedImageVector b(Resources.Theme theme, Resources resources, int i3) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserB = XmlPullParserUtils_androidKt.b(resources.getXml(i3));
        return XmlAnimatedVectorParser_androidKt.a(xmlPullParserB, resources, theme, Xml.asAttributeSet(xmlPullParserB));
    }
}
