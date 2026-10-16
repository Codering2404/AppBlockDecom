package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class VectorResources_androidKt {
    public static final ImageVectorCache.ImageVectorEntry a(Resources.Theme theme, Resources resources, XmlResourceParser xmlResourceParser, int i3) throws XmlPullParserException, IOException {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        AndroidVectorParser androidVectorParser = new AndroidVectorParser(xmlResourceParser, 0, 2, null);
        ImageVector.Builder builderA = XmlVectorParser_androidKt.a(androidVectorParser, resources, theme, attributeSetAsAttributeSet);
        int iG = 0;
        while (!XmlVectorParser_androidKt.d(xmlResourceParser)) {
            iG = XmlVectorParser_androidKt.g(androidVectorParser, resources, attributeSetAsAttributeSet, theme, builderA, iG);
            xmlResourceParser.next();
        }
        return new ImageVectorCache.ImageVectorEntry(builderA.f(), i3);
    }

    public static final ImageVector b(ImageVector.Companion companion, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        if (ComposerKt.M()) {
            ComposerKt.U(44534090, i4, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:47)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        Resources resourcesA = Resources_androidKt.a(composer, 0);
        Resources.Theme theme = context.getTheme();
        boolean Z = composer.Z(resourcesA) | ((((i4 & 112) ^ 48) > 32 && composer.e(i3)) || (i4 & 48) == 32) | composer.Z(theme) | composer.Z(resourcesA.getConfiguration());
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = c(companion, theme, resourcesA, i3);
            composer.w(objG);
        }
        ImageVector imageVector = (ImageVector) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return imageVector;
    }

    public static final ImageVector c(ImageVector.Companion companion, Resources.Theme theme, Resources resources, int i3) throws XmlPullParserException, IOException {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i3, typedValue, true);
        XmlResourceParser xml = resources.getXml(i3);
        XmlVectorParser_androidKt.j(xml);
        Unit unit = Unit.f139807a;
        return a(theme, resources, xml, typedValue.changingConfigurations).b();
    }
}
